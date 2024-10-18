/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lazaregrail & victorsimon
 * 
 */
public class Joueur implements Deplacable{
    
    /**
     * role est le rôle du Joueur, cela correspond à un Protagoniste parmi les Personnages
     * numeroJoueur est l'ordre de priorité du Joueur par rapport aux autres Joueurs
     */
    private Personnage role;
    private int priorite;
    private Scanner scanner = new Scanner(System.in);
    private World jeu;
    private int nbdeplace;
    private ArrayList<Utilisable> inventaire = new ArrayList();
    private ArrayList<Integer> inventaireInd = new ArrayList();
    
    /**
     * Permet de créer un joueur a partir d'une sauvegarde
     * @param role
     * @param priorite
     * @param scanner
     * @param jeu
     * @param nbdeplace
     * @param inventaire
     * @param inventaireInd 
     */
    
    public Joueur(Personnage role, int priorite, Scanner scanner, World jeu, int nbdeplace, ArrayList<Utilisable> inventaire,ArrayList<Integer> inventaireInd){
        this.role = role;
        this.priorite = priorite;
        this.scanner = scanner;
        this.jeu = jeu;
        this.nbdeplace = nbdeplace;
        this.inventaire = inventaire;
        this.inventaireInd = inventaireInd;
    }
     
    /**
     * permet de créer un joueur en fonction de la classe qu'il a chosi de jouer
     * @param jeu
     */
    
    public Joueur(World jeu){
        this.jeu = jeu;
        System.out.print("Entrez votre rôle entre Archer(1) et Guerrier(2): ");
        String classe = scanner.nextLine();
        System.out.print("Entrez votre nom: ");
        String nom = scanner.nextLine();
        Random genAlé = new Random();
        if (classe.equals("1")){
            
            int ptVie = genAlé.nextInt(21)+90;
            int DA = genAlé.nextInt(11)+25;
            int ptPar = genAlé.nextInt(10)+1;
            int paAtt = genAlé.nextInt(11)+75;
            int paPar = genAlé.nextInt(11)+15;
            int dMax = genAlé.nextInt(1)+5;
            Point2D pos = new Point2D(0,0);
            int nbF = genAlé.nextInt(21)+20;
            int argent = genAlé.nextInt(501);
            role = new Archer(nom,ptVie,DA,ptPar,paAtt,paPar,dMax,pos,nbF,argent,jeu,new ArrayList<Utilisable>());
        }
        else if (classe.equals("2")){
            int ptVie = genAlé.nextInt(21)+190;
            int DA = genAlé.nextInt(11)+55;
            int ptPar = genAlé.nextInt(11)+30;
            int paAtt = genAlé.nextInt(11)+90;
            int paPar = genAlé.nextInt(11)+45;
            int dMax = 1;
            Point2D pos = new Point2D(0,0);
            int argent = genAlé.nextInt(501);
            int nbMain = 0;
            int degEpee = 0;
            int prix = 0;
            int place = 0;
            role = new Guerrier(nom,ptVie,DA,ptPar,paAtt,paPar,dMax,pos,place,nbMain,degEpee,prix,argent,jeu, new ArrayList<Utilisable>());
        }
        
        int x = genAlé.nextInt(jeu.getTaille());
        int y = genAlé.nextInt(jeu.getTaille());
        Set<Integer> list = jeu.getdico().keySet();
        while (role.getposX()!= x || role.getposY()!=y){
            x = genAlé.nextInt(jeu.getTaille());
            y = genAlé.nextInt(jeu.getTaille());
            if (jeu.getmap(x,y) == 0){
                role.setpos(x,y);
                jeu.setmap(x,y,1) ;
            }
        }
//        role.setpos(6,6);
//        jeu.setmap(6,6,1) ;
    }
    
    /**
     * cette méthode permet au joueur de chosir quelles seront ses actions à chaque tour 
     */
    
    public void joue() throws IOException{
        boolean effectue = false;
        nbdeplace = 0;
        System.out.println("Le joueur joue"); 
        while (!effectue){
            System.out.println("Votre Personnage est en position: ["+role.getposX()+";"+role.getposY()+"]"); 
            System.out.println("Voulez vous combattre(1), vous déplacer(2), utiliser un objet(3), sauvegarder la partie (4) ou ne rien faire(5):");
            int x = this.role.getposX();
            int y = this.role.getposY();
            String choix = scanner.nextLine();
            switch (choix) {
                case "2":
                    effectue = true;
                    while (nbdeplace < 4 && x == this.role.getposX() && y == this.role.getposY()){
                        try{
                            deplace();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Erreur : Vous ne pouvez pas sortir de la Carte !");
                            this.joue();
                        }
                    }   break;
                case "1":
                    effectue = true;
                    combattre();
                    break;
                case "3":
                    effectue = true;
                    utilise();
                    break;
                case "4":
                    effectue = true;
                    System.out.print("Entrez le nom de la sauvegarde (0 pour un nom automatique) : ");
                    String nomSauvegarde = scanner.nextLine();
                    if (nomSauvegarde.equals("0")){
                        try {
                            jeu.sauvegarderPartie();
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(Joueur.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else {
                        try {
                            jeu.sauvegarderPartie(nomSauvegarde);
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(Joueur.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }   break;
                default:
                    System.out.println("Vous n'avez choisi aucune des options proposées");
                    System.out.println("SVP entrez un nombre parmi ceux proposés");
                    break;
            }
        }
    }

    /**
     * fonction appelée quand le joueur décide de combattre
     * Si un enemi ou plusierus sont dans sa range alors on lui donne une liste de personne qu'il peut attaquer et il choisit
     * Sinon on lui propose de faire une autre action comme se déplacer ou utiliser un objet
     */
    
    public void combattre(){
        int x = this.role.getposX();
        int y = this.role.getposY();
        ArrayList<Integer> listAttack = new ArrayList<>();
        ArrayList<Point2D> listParc = new ArrayList<>();
        role.affichePos();
        //ArrayList<Point2D> listParc2 = new ArrayList<>();
        //listParc2.add(new Point2D(3,6));
        //Point2D a = new Point2D(3,6);
        //Point2D B = new Point2D(3,6);
        //System.out.println(containsP2D(listParc2,new Point2D(3,6)));
        //System.out.println(a.equals(B));
        //System.out.println(role.getdistM());
        //System.out.println("rien");
        role.range(listAttack,listParc,new Point2D(x,y),0,role.getdistM());
        Set<Integer> set = new HashSet<>(listAttack);
        listAttack = new ArrayList<>(set);

        if (listAttack.size() == 0){
            boolean effectue = false;
            while(!effectue){
                System.out.println("Personne n'est dans votre range d'attaque.");
                System.out.println("Voulez vous vous déplacer(1) ou ne rien faire(2)?");
                String choix2 = scanner.nextLine();
                switch (choix2) {
                    case "1":
                        effectue = true;
                        deplace();
                        break;
                    case "2":
                        effectue = true;
                        break;
                    default:
                        System.out.println("Vous n'avez choisi aucune des options proposées");
                        System.out.println("SVP entrez un nombre parmi ceux proposés");
                        break;
                }
            }
        } else {
            //System.out.println(listAttack.size());
            boolean effectue = false;
            int choixInt = 0;
            while(!effectue){
            for (int ind: listAttack){
                System.out.println("Vous pouvez attaquer la créature en case: [" +jeu.getdico().get(ind).getposX()+";"+jeu.getdico().get(ind).getposY()+"], pour l'attaquer tapez "+ind);
            }
                try{
                    String choix = scanner.nextLine();
                    choixInt = Integer.parseInt(choix);
                } catch(NumberFormatException e){
                    System.out.println("Vous n'avez choisi aucune des options proposées");
                    System.out.println("SVP entrez un nombre parmi ceux proposés");
                }
                if(listAttack.contains(choixInt)){
                    effectue = true;
                }
            }
            Creature c = (Creature) jeu.getdico().get(choixInt);
            int PV = c.getptVie();
            role.combattre(c);
            if (PV > c.getptVie()){
                System.out.println("L'attaque de "+this.role.getNom()+ " est un succès. Vous avez infligez: "+(PV-c.getptVie())+" points de dégat");
            } else {
                System.out.println("L'attaque de "+this.role.getNom()+ " a manqué sa cible");
            }
        }
        
    }
    
    /**
     * Fonction appélée dans le joueur decide de se déplacer qui va ensuite appelé ramasse(x,y) et deplace(x,y)
     */
    
    @Override
    public void deplace(){
        boolean effectue = false;
        nbdeplace ++;
        int x = role.getposX();
        int y = role.getposY();
        while (!effectue){
            System.out.println("Voulez vous aller à droite(1), à gauche(2), en bas(3) ou en haut(4)");
            String deplacement = scanner.nextLine();
            switch (deplacement) {
                case "1" : this.ramasse(x+1,y); effectue=true; break;
                case "2" : this.ramasse(x-1,y); effectue=true; break;
                case "3" : this.ramasse(x,y+1); effectue=true; break;
                case "4" : this.ramasse(x,y-1); effectue=true; break;
                default : {
                    System.out.println("Vous n'avez choisi aucune des options proposées");
                    System.out.println("SVP entrez un nombre parmi ceux proposés");
                }
            } 
            switch (deplacement) {
                case "1" : this.deplace(x+1,y); break;
                case "2" : this.deplace(x-1,y); break;
                case "3" : this.deplace(x,y+1); break;
                case "4" : this.deplace(x,y-1); break;
                default : {
                }
            }
        }
        if (x != role.getposX() || y != role.getposY()){
            jeu.setmap(x,y,0);
            jeu.setmap(role.getposX(),role.getposY(),1);
            System.out.println("Le joueur à réussit a se déplacer en position ["+role.getposX()+";"+role.getposY()+"]");
        } else {
            System.out.println("La case est occupée ou à l'extérieur du monde, vous n'avez pas pu vous déplacer");
        }
    }
    
    /**
     * fonction qui est appelé à chaque fois que le joueur se déplace pour ramasser l'objet avant que le joueur ne se déplace
     * @param x
     * @param y 
     */
    
    public void ramasse(int x ,int y){
        int obj = jeu.getmap(x,y);
        if (obj >= 1000 && obj < 2000){
            Utilisable u = (Utilisable) jeu.getdico().get(obj);
            if(u instanceof Champignon){
                Champignon c = (Champignon) u;
                System.out.println("Vous avez ramassé un champignon qui va vous donner malus de"+c.getMalus() +"dégat pendant 3 tours quand vous l'utiliserez.");
            } else if(u instanceof Epinard){
                Epinard e = (Epinard) u;
                System.out.println("Vous avez ramassé un épinanrd qui va vous donner bonus de"+e.getBonus() +"dégat pendant 5 tours quand vous l'utiliserez.");
            } else if(u instanceof PotionSoin){
                PotionSoin p = (PotionSoin) u;
                System.out.println("Vous avez ramassé un potion de soin qui va vous guérir "+p.getnbPVRendu() +" point de vie instantanement quand vous l'utiliserez.");
            } else if(u instanceof Epee && role instanceof Guerrier){
                Epee ep = (Epee) u;
                System.out.println("Vous avez ramassé une épee qui va donner bonus de "+ep.getdegAtt() +" dégat quand vous l'équiperez");
            }
            inventaire.add((Utilisable) jeu.getdico().get(obj));
            inventaireInd.add(obj);
            jeu.setmap(x,y,0);
        }
    }
    
    /**
     * Fonction qui est appelée quand le joueur décide d'utiliser un objet de son inventaire
     * On lui affiche une liste d'objet qui sont dans son inventaire pour qu'il puisse choisir celui qu'il va utiliser
     * Il n'a plus qu'a chosir dans la liste qu'on lui a afficher ou faire autre chose comme combattre ou se déplacer
     */
    
    public void utilise(){
        for (int i = 0; i < inventaire.size();i++){
            Utilisable u = inventaire.get(i);
            int obj = inventaireInd.get(i);
            if(u instanceof Champignon){
                Champignon c = (Champignon) u;
                System.out.println("Voulez vous utilisez un champignon qui va vous donner malus de"+c.getMalus() +"dégat pendant 3 tours.");
                System.out.println("Tappez "+obj+" pour l'utiliser");
            } else if(u instanceof Epinard){
                Epinard e = (Epinard) u;
                System.out.println("Voulez vous utilisez un épinanrd qui va vous donner bonus de"+e.getBonus() +"dégat pendant 5 tours");
                System.out.println("Tappez "+obj+" pour l'utiliser");
            } else if(u instanceof PotionSoin){
                PotionSoin p = (PotionSoin) u;
                System.out.println("Voulez vous utilisez un potion de soin qui va vous guérir "+p.getnbPVRendu() +" point de vie instantanement");
                System.out.println("Tappez "+obj+" pour l'utiliser");
            } else if(u instanceof Epee && role instanceof Guerrier){
                Epee ep = (Epee) u;
                System.out.println("Voulez vous utilisez une épee qui va donner bonus de "+ep.getdegAtt() +" dégat");
                System.out.println("Tappez "+obj+" pour l'utiliser");
            }
        }
        System.out.println("Tappez le nombre écrit plus haut pour utiliser un objet ou (1) pour vous déplacer (2) pour combattre (3) pour ne rien faire");
        String choix = scanner.nextLine();
        int choi = Integer.parseInt(choix);
        if (choi == 1){
            deplace();
        } else if (choi == 2){
            combattre();
        } else if (choi >= 1000){
            Utilisable uti = (Utilisable) jeu.getdico().get(choi);
            uti.activation(role);
            role.getEffets().add(uti);
            inventaire.remove((Utilisable) jeu.getdico().get(choi));
            for (int i = 0; i < inventaireInd.size();i++){
                if (inventaireInd.get(i) == choi ){
                    inventaireInd.remove(i);
                }
            }
        }
    }
    
    /**
     * premet de déplacer le joueur à la case de coordonée x y 
     * @param x
     * @param y 
     */
    
    @Override
    public void deplace(int x,int y){
        this.role.deplace( x ,  y);
    }

    /**
     * Renvoi si p (Point2D) est dans la liste listParc(ArrayList<Point2D>)
     * @param listParc
     * @param p
     * @return boolean
     */
    
    private boolean containsP2D(ArrayList<Point2D> listParc,Point2D p){
        boolean rep = false;
        for (Point2D p2: listParc){
            if(p.equals(p2)){
                rep = true;
                break;
            }
        }
        return rep;
    }
    
    public Personnage getRole(){
        return role;
    }
    
    public void setRole(Personnage role){
        this.role = role;
    }
    
    public void addInventory(Utilisable o, int ind){
        this.inventaire.add(o);
        this.inventaireInd.add(ind);
    }
    
    public ArrayList<Utilisable> getInventory(){
        return(this.inventaire);
    }
}

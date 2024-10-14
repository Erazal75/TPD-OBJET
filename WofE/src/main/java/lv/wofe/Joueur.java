/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

import java.lang.reflect.Array;
import java.util.*;

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
    private int priorité;
    private Scanner scanner = new Scanner(System.in);
    private World jeu;
    private int nbdeplace;
    private ArrayList<Utilisable> inventaire = new ArrayList();
    /**
     * permet de créer un joueur en fonction de la classe qu'il a chosi de jouer  
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
        while (role.getposX()!= x && role.getposY()!=y){
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
    
    public void joue(){
        nbdeplace = 0;
        System.out.println("Le joueur joue"); 
        System.out.println("Voulez vous combattre(1), vous déplacer(2), utiliser un objet(3) ou ne rein faire(4):");
        int x = this.role.getposX();
        int y = this.role.getposY();
        String choix = scanner.nextLine();
        if (choix.equals("2")){
            while (nbdeplace < 4 && x == this.role.getposX() && y == this.role.getposY()){
                deplace();
            }
        } else if(choix.equals("1")){
            combattre();
        } else if(choix.equals("3")){
            utilise();
        }
    }
    
    public void range(ArrayList<Integer> listAttack,ArrayList<Point2D> listParc, Point2D p1,int dist,int distMax){
        int x = p1.getX();
        int y = p1.getY();
        listParc.add(p1);
        
        if (jeu.getmap(x, y) > 1 && jeu.getmap(x, y) < 1000){
            listAttack.add(jeu.getmap(x, y));
        }
        
        ArrayList<Point2D> listAVenir = new ArrayList<>();
        if (x-1 >= 0){
            Point2D p = new Point2D(x-1, y);
            //if (!containsP2D(listParc,p)){
                listAVenir.add(p);
            //}
        }
        if (x+1 <= jeu.getTaille()-1){
            Point2D p = new Point2D(x+1, y);
            //if (!containsP2D(listParc,p)){
                listAVenir.add(p);
            //}
        }
        if (y+1 <= jeu.getTaille()-1){
            Point2D p = new Point2D(x, y+1);
            //if (!containsP2D(listParc,p)){
                listAVenir.add(p);
            //}
        }
        if (y-1 >=0){
            Point2D p = new Point2D(x, y-1);
            //if (!containsP2D(listParc,p)){
                listAVenir.add(p);
            //}
        }
        if (dist < distMax){
            while (!listAVenir.isEmpty()){
                Point2D p3 = listAVenir.remove(0);
                //if (!containsP2D(listParc,p3)){
                    range(listAttack,listParc,p3,dist+1,distMax); 
                //}
            }
        }
    } 

    /**
     * déplace le joueur de manière aléatoire
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
        range(listAttack,listParc,new Point2D(x,y),0,role.getdistM());
        Set<Integer> set = new HashSet<>(listAttack);
        listAttack = new ArrayList<>(set);

        if (listAttack.size() == 0){
            System.out.println("Personnae n'est dans votre range d'attaque.");
            System.out.println("Voulez vous vous déplacer(1) ou ne rien faire(2)?");
            String choix2 = scanner.nextLine();
            if (choix2.equals("1")){
                deplace();
            }
        }
        //System.out.println(listAttack.size());

        for (int ind: listAttack){
            System.out.println("Vous pouvez attaquez la créature en case: [" +jeu.getdico().get(ind).getposX()+";"+jeu.getdico().get(ind).getposY()+"], pour l'attquer tapez "+ind);
        }
        String choix = scanner.nextLine();
        int choixInt = Integer.valueOf(choix);
        Creature c = (Creature) jeu.getdico().get(choixInt);
        int PV = c.getptVie();
        role.combattre(c);
        if (PV > c.getptVie()){
            System.out.println("L'attaque de "+this.role.getNom()+ " est un succès. Vous avez infligez: "+(PV-c.getptVie())+" points de dégat");
        }
        
    }
    
    @Override
    public void deplace(){
        nbdeplace ++;
        int x = role.getposX();
        int y = role.getposY();
        System.out.println("Voulez vous aller à droite(1), à gauche(2), en bas(3) ou en haut(4)");
        String deplacement = scanner.nextLine();
        switch (deplacement) {
            case "1" -> this.ramasse(x+1,y);
            case "2" -> this.ramasse(x-1,y);
            case "3" -> this.ramasse(x,y+1);
            case "4" -> this.ramasse(x,y-1);
            default -> {
            }
        } 
        switch (deplacement) {
            case "1" -> this.deplace(x+1,y);
            case "2" -> this.deplace(x-1,y);
            case "3" -> this.deplace(x,y+1);
            case "4" -> this.deplace(x,y-1);
            default -> {
            }
        } 
        if (x != role.getposX() || y != role.getposY()){
            jeu.setmap(x,y,0);
            jeu.setmap(role.getposX(),role.getposY(),1);
            System.out.println("Le joueur à réussit a se déplacer");
        } else {
            System.out.println("La case est occupée ou à l'extérieur du monde, vous n'avez pas pu vous déplacer");
        }
    }
    
    public void ramasse(int x ,int y){
        int obj = jeu.getmap(x,y);
        if (obj >= 1000 && obj < 2000){
            inventaire.add((Utilisable) jeu.getdico().get(obj));
            jeu.setmap(x,y,0);
        }
    }
    
    public void utilise(){
        for (Utilisable u : inventaire){
            if(u instanceof Champignon c){
                System.out.println("Voulez vous utilisez un champignon qui va vous donner malus de"+c.getMalus() +"dégat pendant 3 tours.");
                System.out.println("Tappez "+jeu.getmap(c.getposX(), c.getposY())+" pour l'utiliser");
            } else if(u instanceof Epinard e){
                System.out.println("Voulez vous utilisez un épinanrd qui va vous donner bonus de"+e.getBonus() +"dégat pendant 5 tours");
                System.out.println("Tappez "+jeu.getmap(e.getposX(), e.getposY())+" pour l'utiliser");
            } else if(u instanceof PotionSoin p){
                System.out.println("Voulez vous utilisez un potion de soin qui va vous guérir "+p.getnbPVRendu() +" point de vie instantanement");
                System.out.println("Tappez "+jeu.getmap(p.getposX(), p.getposY())+" pour l'utiliser");
            } else if(u instanceof Epee ep && role instanceof Guerrier){
                System.out.println("Voulez vous utilisez une épee qui va donner bonus de "+ep.getdegAtt() +" dégat");
                System.out.println("Tappez "+jeu.getmap(ep.getposX(), ep.getposY())+" pour l'utiliser");
            }
        }
        String choix = scanner.nextLine();
        int choi = Integer.valueOf(choix);
        Utilisable uti = (Utilisable) jeu.getdico().get(choi);
        uti.activation(role);
        role.getEffets().add(uti);   
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
}

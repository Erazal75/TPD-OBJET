/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail & victorsimon
 * 
 */
import java.util.*;

public class World {
    
    /*
    public Archer robin = new Archer();
    public Archer guillaumeT = new Archer(robin);
    public Paysan peon = new Paysan();
    public Guerrier aragorn = new Guerrier();
    public Loup warwick = new Loup();
    public Lapin bugs = new Lapin();
    public Lapin bugy = new Lapin();
    public PotionSoin heal = new PotionSoin();
    */
    
    /*
    0 = case vide
    1 = Joueur
    2 = PNJ
    3 = Objet
    */
  
    private int[][] map;
    private Joueur joueur;
    private Random genAlé = new Random();
    
    private HashMap<Integer,ElementDeJeu> dicoPerso = new HashMap<>();
    
    private int taille;
    private int currentTour = 0; 

    public World(int nb){
        
        taille = nb;
        map = new int[taille][taille];
        Random genAlé = new Random(); 
        
        creerNPaysan(genAlé.nextInt(10)+10);
        creerNGuerrier(genAlé.nextInt(10)+10);
        creerNArcher(genAlé.nextInt(10)+10);
        creerNLoup(genAlé.nextInt(10)+10);
        creerNLapin(genAlé.nextInt(10)+10);
        creerNPotion(genAlé.nextInt(10)+10);
        creerNEpee(genAlé.nextInt(10)+10);
//        dicoPerso.put(101,new Guerrier(this));
//        dicoPerso.get(101).setpos(5, 6);
//        map[5][6] = 101;
        joueur = new Joueur(this);
        creerMondeAlea();
    }
    
    /**
     *
     * @return tableauélément
     */
    
    public HashMap<Integer,ElementDeJeu> getdico(){
        return dicoPerso;
    }
    
    public void setmap(int x,int y, int valeur){
        map[x][y] = valeur;
    }
    
    public int getmap(int x,int y){
        return map[x][y];
    }
    
    public int getTour(){
        return currentTour;
    }

    public void setTour(int t){
        currentTour = t;
    }
    
    public int getTaille(){
        return taille;
    }
    
    public void setTaille(int t){
        taille = t;
    }
    
    /**
     * creerMondeAlea permet de modifier l'instance de World de sorte que chaque Protagonistes et Objets soient placés aléatoirement dans le Monde.
     */
    
    public void creerMondeAlea(){
        
        Random genAlé = new Random();
        Set<Integer> list = dicoPerso.keySet();
        for(int ind : list){
            int x=genAlé.nextInt(taille);
            int y=genAlé.nextInt(taille);
            while (dicoPerso.get(ind).getposX()!= x && dicoPerso.get(ind).getposY()!=y){
                x=genAlé.nextInt(taille);
                y=genAlé.nextInt(taille);
                if (map[x][y] == 0){
                    dicoPerso.get(ind).setpos(x,y);
                    map[x][y] = ind;
                }
            }
        }
    }
    
    /**
     * Cree nbGuerrier Guerriers
     * @param nbGuerrier 
     */
    
    public void creerNGuerrier(int nbGuerrier){
        for (int i=0 ; i<nbGuerrier ; i=i+1){
            int indice = 100 + i;
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
            dicoPerso.put(indice,new Guerrier("",ptVie,DA,ptPar,paAtt,paPar,dMax,pos,place,nbMain,degEpee,prix,argent,this, new ArrayList<Utilisable>()));
        }
    }
    
    /**
     * Cree nbPaysan Paysans
     * @param nbArcher 
     */
    
    public void creerNArcher(int nbArcher){
        for (int i=0 ; i<nbArcher ; i=i+1){
            int indice = 200 + i;
            int ptVie = genAlé.nextInt(21)+90;
            int DA = genAlé.nextInt(11)+25;
            int ptPar = genAlé.nextInt(10)+1;
            int paAtt = genAlé.nextInt(11)+75;
            int paPar = genAlé.nextInt(11)+15;
            int dMax = genAlé.nextInt(1)+5;
            Point2D pos = new Point2D(0,0);
            int nbF = genAlé.nextInt(21)+20;
            int argent = genAlé.nextInt(501);
            dicoPerso.put(indice,new Archer("",ptVie,DA,ptPar,paAtt,paPar,dMax,pos,nbF,argent,this,new ArrayList<Utilisable>()));
        }
    }
    
    /**
     * Cree nbArcher Archers
     * @param nbPaysan 
     */
    
    public void creerNPaysan(int nbPaysan){
        for (int i=0 ; i<nbPaysan ; i=i+1){
            int indice = 300 + i;
            dicoPerso.put(indice,new Paysan(this));
        }
    }
    
    /**
     * Cree nbLoup Loups
     * @param nbLoup 
     */
    
    public void creerNLoup(int nbLoup){
        for (int i=0 ; i<nbLoup ; i=i+1){
            int indice = 400 + i;
            dicoPerso.put(indice,new Loup(this));
        }
    }
    
    /**
     * Cree nbLapin Lapins
     * @param nbLapin 
     */
    
    public void creerNLapin(int nbLapin){
        for (int i=0 ; i<nbLapin ; i=i+1){
            int indice = 500 + i;
            dicoPerso.put(indice,new Lapin(this));
        }
    }
    
    /**
     * Cree nbPotion PotionSoins
     * @param nbPotion 
     */
    
    public void creerNPotion(int nbPotion){
        for (int i=0 ; i<nbPotion ; i=i+1){
            Random genAlé = new Random(); 
            int indice = 1000 + i;
            dicoPerso.put(indice,new PotionSoin(genAlé.nextInt(20)+20,this));
        }
    }
    
    /**
     * Cree nbEpee Epees
     * @param nbEpee 
     */
    
    public void creerNEpee(int nbEpee){
        for (int i=0 ; i<nbEpee ; i=i+1){
            Random genAlé = new Random();
            int indice = 1100 + i;
            dicoPerso.put(indice,new Epee(genAlé.nextInt(20)+20,this)); 
        }
    }
    
    public void creerNChampi(int nbChampi){
        for (int i=0 ; i<nbChampi ; i=i+1){
            Random genAlé = new Random();
            int indice = 1100 + i;
            dicoPerso.put(indice,new Champignon(genAlé.nextInt(20)+20,this)); 
        }
    }
    
    public void creerNEpi(int nbEpi){
        for (int i=0 ; i<nbEpi ; i=i+1){
            Random genAlé = new Random();
            int indice = 1100 + i;
            dicoPerso.put(indice,new Epinard(genAlé.nextInt(20)+20,this)); 
        }
    }
    
    /**
     * ecrit toute les cases occupé et par quel type de créature ou d'objet
     */
    
    
    /**
     * methode que nous allons appelé a chaque début de tour et qui nous permet de faire toutes les actions à chqaue tour
     */
    
    public void tourDeJeu(){
        System.out.println("Le Tour commence ...");
        System.out.println("C'est au Joueur de jouer !");
        joueur.joue();
        System.out.println("les Actions suivantes sont effectuées : ");    
        System.out.println("Les Personnages réalisent leurs actions ! "); 
        System.out.println("Les Monstres hantent le royaume ! "); 
        Set<Integer> list = dicoPerso.keySet();
        for (Integer id: list){
            ElementDeJeu perso = dicoPerso.get(id);
            if (perso.isCreature()){
                int x = perso.getposX();
                int y = perso.getposY();
                // les effets se dissipent :
                List<Utilisable> effets = ((Creature)perso).getEffets();
                int index = 0;
                for(Utilisable effet : effets){
                    if (effet.getutilRestantes() == -1) { // l'effet ne s'applique plus à la Creature
                        effets.remove(index);
                        }
                    else {
                        effet.setutilRestantes(effet.getutilRestantes()-1);  // l'effet se dissipe lentement
                        }
                    index ++;
                }
                        
                // la Creature à deux possibilités d'action : se déplacer et attaquer / par défaut il attaque sauf impossibilité.
                Creature c = (Creature)perso;
                ArrayList<Integer> listAttack = new ArrayList<>();
                ArrayList<Point2D> listParc = new ArrayList<>();
                Point2D pos = new Point2D(c.getposX(), c.getposY());
                int distMax = 1;
                if (c instanceof Personnage){
                    distMax = ((Personnage) c).getdistM();
                    }
                if (c instanceof Combattant){ // la Creature est capable de se battre
                    c.range(listAttack, listParc, pos , 0, distMax);
                    Set<Integer> set = new HashSet<>(listAttack);
                    listAttack = new ArrayList<>(set);
                    if (listAttack.size() <= 1){ // il n'y a personne à attaquer, la Creature se déplace
                        c.deplace();
                    }
                    else { // l'ElementDeJeu attaque un ennemi proche aléatoirement
                        Random genAlé = new Random(); 
                        int enemy = genAlé.nextInt(listAttack.size()-1)+1;
                        Creature e = (Creature) dicoPerso.get(listAttack.get(enemy));
                        ((Combattant) c).combattre(e);
                    }
                }
                else { // la Creature n'est pas capable de se battre
                    c.deplace();
                }
                if (c.getposX() != x || c.getposY() != y){
                    setmap(x,y,0);
                    setmap(c.getposX(),c.getposY(),id);
                }
            }  
        }
        System.out.println("Les effets se dissipent ...");  
        System.out.println("Le Tour se termine ...");    
        this.currentTour++; 
    }
    
    /**
     * permet d'afficher le jue dans la console
     */
    
    public void afficheJeu(){    
        for (int i = 0;i <  map.length; i++ ) {
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] == 0) {
                    System.out.print("_ ");
                } else {
                    System.out.print(map[j][i]+" ");
                }
            }
            System.out.println("");
        }  
    }
}

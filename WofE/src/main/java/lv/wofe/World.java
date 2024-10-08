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
            dicoPerso.put(indice,new Guerrier(this));
        }
    }
    
    /**
     * Cree nbPaysan Paysans
     * @param nbPaysan 
     */
    
    public void creerNPaysan(int nbPaysan){
        for (int i=0 ; i<nbPaysan ; i=i+1){
            int indice = 300 + i;
            dicoPerso.put(indice,new Paysan(this));
        }
    }
    
    /**
     * Cree nbArcher Archers
     * @param nbArcher 
     */
    
    public void creerNArcher(int nbArcher){
        for (int i=0 ; i<nbArcher ; i=i+1){
            int indice = 200 + i;
            dicoPerso.put(indice,new Archer(this));
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
    
    /**
     * ecrit toute les cases occupé et par quel type de créature ou d'objet
     */
    
    public void afficheWorld(){
        System.out.println("Affichons le Monde");
        Set<Integer> list = dicoPerso.keySet();
        for (Integer ind: list){
            System.out.println(dicoPerso.get(ind).getClass() +"  ["+ dicoPerso.get(ind).getposX()+ ";" + dicoPerso.get(ind).getposY()+"]");
        }
    }
    
    /**
     * methode que nous allons appelé a chaque début de tour et qui nous permet de faire toutes les actions à chqaue tour
     */
    
    public void tourDeJeu(){
        System.out.println("Le Tour commence ...");
        
        joueur.joue();
        System.out.println("les Actions sont effectuées ...");    
        
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

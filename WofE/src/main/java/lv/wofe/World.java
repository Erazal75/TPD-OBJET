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
    
    private ArrayList<ElementDeJeu> tableauElement = new ArrayList<>();
    
    public int taille;
    public int currentTour = 0; 

    public World(int nb){
        
        taille = nb;
        Random genAlé = new Random(); 
        
        creerNPaysan(genAlé.nextInt(10)+10);
        creerNGuerrier(genAlé.nextInt(10)+10);
        creerNArcher(genAlé.nextInt(10)+10);
        creerNLoup(genAlé.nextInt(10)+10);
        creerNLapin(genAlé.nextInt(10)+10);
        creerNPotion(genAlé.nextInt(10)+10);
        creerNEpee(genAlé.nextInt(10)+10);
        
        joueur = new Joueur();
        creerMondeAlea();
    }
    
    /**
     *
     * @return tableauélément
     */
    
    public ArrayList<ElementDeJeu> gettableauElement(){
        return tableauElement;
    }
    
    public void setmatrice(int x,int y, int valeur){
        map[x][y] = valeur;
    }
    
    public int getmatrice(int x,int y){
        return map[x][y];
    }

    
    /**
     * creerMondeAlea permet de modifier l'instance de World de sorte que chaque Protagonistes et Objets soient placés aléatoirement dans le Monde.
     */
    
    public void creerMondeAlea(){
        
        Random genAlé = new Random();
        for(ElementDeJeu e : tableauElement){
            int x=genAlé.nextInt(taille);
            int y=genAlé.nextInt(taille);
            if (e.isCreature()){
                Creature c = e.getCreature();
                c.deplace(x,y);
                while (e.getposX()!= x && e.getposY()!=y){
                    x=genAlé.nextInt(taille);
                    y=genAlé.nextInt(taille);
                    c.deplace(x,y);
                }
                map[x][y] = 2;
            } else {
                int compteur = 0;
                while (compteur < tableauElement.size() - 1){
                    x = genAlé.nextInt(taille);
                    y = genAlé.nextInt(taille);
                    compteur = 0;
                    for (ElementDeJeu f: tableauElement){
                        if (!e.equals(f)){
                            if (f.getposX() == x && f.getposY() == y){
                                break;
                            } else {
                                compteur ++;
                            }
                        }
                    }  
                }
                if (compteur == tableauElement.size() - 1){
                    e.setpos(x, y);
                }
                map[x][y] = 3;
            } 
            
        }
    }
    
    /**
     * Cree nbGuerrier Guerriers
     * @param nbGuerrier 
     */
    
    public void creerNGuerrier(int nbGuerrier){
        for (int i=0 ; i<nbGuerrier ; i=i+1){
            tableauElement.add(new Guerrier());
        }
    }
    
    /**
     * Cree nbPaysan Paysans
     * @param nbPaysan 
     */
    
    public void creerNPaysan(int nbPaysan){
        for (int i=0 ; i<nbPaysan ; i=i+1){
            tableauElement.add(new Paysan());
        }
    }
    
    /**
     * Cree nbArcher Archers
     * @param nbArcher 
     */
    
    public void creerNArcher(int nbArcher){
        for (int i=0 ; i<nbArcher ; i=i+1){
            tableauElement.add(new Archer());
        }
    }
    
    /**
     * Cree nbLoup Loups
     * @param nbLoup 
     */
    
    public void creerNLoup(int nbLoup){
        for (int i=0 ; i<nbLoup ; i=i+1){
            tableauElement.add(new Loup());
        }
    }
    
    /**
     * Cree nbLapin Lapins
     * @param nbLapin 
     */
    
    public void creerNLapin(int nbLapin){
        for (int i=0 ; i<nbLapin ; i=i+1){
            tableauElement.add(new Lapin());
        }
    }
    
    /**
     * Cree nbPotion PotionSoins
     * @param nbPotion 
     */
    
    public void creerNPotion(int nbPotion){
        for (int i=0 ; i<nbPotion ; i=i+1){
            Random genAlé = new Random();
            tableauElement.add(new PotionSoin(genAlé.nextInt(20)+20));
        }
    }
    
    /**
     * Cree nbEpee Epees
     * @param nbEpee 
     */
    
    public void creerNEpee(int nbEpee){
        for (int i=0 ; i<nbEpee ; i=i+1){
            Random genAlé = new Random();
            tableauElement.add(new Epee(genAlé.nextInt(20)+20)); 
        }
    }
    
    /**
     * ecrit toute les cases occupé et par quel type de créature ou d'objet
     */
    
    public void afficheWorld(){
        System.out.println("Affichons le Monde"); 
        for (ElementDeJeu c: tableauElement){
            System.out.println(c.getClass() +"  ["+ c.getposX()+ ";" + c.getposY()+"]");
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
}

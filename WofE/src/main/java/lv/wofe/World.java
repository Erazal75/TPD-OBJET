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
    
    Joueur joueur;
    static ArrayList<ElementDeJeu> tableauElement = new ArrayList<>();
    
    public int taille;
    public int currentTour = 0; 

    public World(int nb){
    taille = nb;
    Random genAlé = new Random();   
    creerNPaysan(genAlé.nextInt(10));
    creerNGuerrier(genAlé.nextInt(10));
    creerNArcher(genAlé.nextInt(10));
    creerNLoup(genAlé.nextInt(10));
    creerNLapin(genAlé.nextInt(10));
    //creerNPotion(genAlé.nextInt(10));
    //creerNEpee(genAlé.nextInt(10));
    creerMondeAlea();
    
    /*
    robin = new Archer();
    peon = new Paysan();
    aragorn = new Guerrier();
    warwick = new Loup();
    bugs = new Lapin();
    bugy = new Lapin();
    
    heal = new PotionSoin();
    heal.setpos(0,2);
    heal.setnbPVRendu(20);
    
    
    tableauCreature.add(robin);
    tableauCreature.add(peon); 
    tableauCreature.add(aragorn);
    tableauCreature.add(warwick);
    tableauCreature.add(bugs); 
    tableauCreature.add(bugy); 
    tableauCreature.add(guillaumeT); 
    
    tableauObjet.add(heal);
    */

    }
    
    static ArrayList<ElementDeJeu> gettableauElement(){
        return tableauElement;
    }

    
    /**
     * creerMondeAlea permet de modifier l'instance de World de sorte que chaque Protagonistes et Objets soient placés aléatoirement dans le Monde.
     */
    
    public void creerMondeAlea(){
        Random genAlé = new Random();
        for(ElementDeJeu e : tableauELement){
            int x=genAlé.nextInt(taille);
            int y=genAlé.nextInt(taille);
            e.deplace(x,y);
            while (e.getposX()!= x && e.getposY()!=y){
                x=genAlé.nextInt(taille);
                y=genAlé.nextInt(taille);
                c.deplace(x,y);
            }
            
        }   
    }
    
    /**
     * Cree nbGuerrier Guerriers
     * @param nbGuerrier 
     */
    
    public void creerNGuerrier(int nbGuerrier){
        for (int i=0 ; i<nbGuerrier ; i=i+1){
            tableauCreature.add(new Guerrier());
        }
    }
    
    /**
     * Cree nbPaysan Paysans
     * @param nbPaysan 
     */
    
    public void creerNPaysan(int nbPaysan){
        for (int i=0 ; i<nbPaysan ; i=i+1){
            tableauCreature.add(new Paysan());
        }
    }
    
    /**
     * Cree nbArcher Archers
     * @param nbArcher 
     */
    
    public void creerNArcher(int nbArcher){
        for (int i=0 ; i<nbArcher ; i=i+1){
            tableauCreature.add(new Archer());
        }
    }
    
    /**
     * Cree nbLoup Loups
     * @param nbLoup 
     */
    
    public void creerNLoup(int nbLoup){
        for (int i=0 ; i<nbLoup ; i=i+1){
            tableauCreature.add(new Loup());
        }
    }
    
    /**
     * Cree nbLapin Lapins
     * @param nbLapin 
     */
    
    public void creerNLapin(int nbLapin){
        for (int i=0 ; i<nbLapin ; i=i+1){
            tableauCreature.add(new Lapin());
        }
    }
    
    /**
     * Cree nbPotion PotionSoins
     * @param nbPotion 
     */
    
    public void creerNPotion(int nbPotion){
        for (int i=0 ; i<nbPotion ; i=i+1){
            tableauObjet.add(new PotionSoin());
        }
    }
    
    /**
     * Cree nbEpee Epees
     * @param nbEpee 
     */
    
    public void creerNEpee(int nbEpee){
        for (int i=0 ; i<nbEpee ; i=i+1){
            tableauObjet.add(new Epee());
        }
    }
    
    public void creationJoueur(){
        System.out.println("Un joueur rentre dans le Monde, Bienvenu !");    
        joueur = new Joueur();
    }
    
    public void afficheWorld(){
        System.out.println("Affichons le Monde");    
    }
    
    public void tourDeJeu(){
        System.out.println("Le Tour commence ...");    
      
        System.out.println("les Actions sont effectuées ...");    
        
        System.out.println("Le Tour se termine ...");    
        this.currentTour++; 
    }
}

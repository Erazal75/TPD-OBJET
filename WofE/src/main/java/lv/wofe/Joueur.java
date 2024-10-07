/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
    
    private ArrayList<Objet> inventaire;
    private Personnage role;
    private int priorité;
    private Scanner scanner = new Scanner(System.in);

    /**
     * permet de créer un joueur en fonction de la classe qu'il a chosi de jouer  
     */
        
    public Joueur(World jeu){
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
            int dMax = genAlé.nextInt(4)+2;
            Point2D pos = new Point2D(0,0);
            int nbF = genAlé.nextInt(21)+20;
            int argent = genAlé.nextInt(501);
            role = new Archer(nom,ptVie,DA,ptPar,paAtt,paPar,dMax,pos,nbF,argent,jeu);
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
            role = new Guerrier(nom,ptVie,DA,ptPar,paAtt,paPar,dMax,pos,place,nbMain,degEpee,prix,argent,jeu);
        }
    }
    
    /**
     * cette méthode permet au joueur de chosir quelles seront ses actions à chaque tour 
     */
    
    public void joue(){
        System.out.println("Le joueur joue"); 
        System.out.println("Voulez vous combattre(1) ou vous déplacer(2):");
        String choix = scanner.nextLine();
        if (choix.equals("2")){
            System.out.println("Voulez vous aller à droite(1), à gauche(2), en bas(3) ou en haut(4)");
            String deplacement = scanner.nextLine();
            switch (deplacement) {
                case "1" -> this.deplace(this.role.getposX()+1,this.role.getposY());
                case "2" -> this.deplace(this.role.getposX()-1,this.role.getposY());
                case "3" -> this.deplace(this.role.getposX(),this.role.getposY()+1);
                case "4" -> this.deplace(this.role.getposX(),this.role.getposY()-1);
                default -> {
                }
            }
        } else if(choix.equals("1")){
            for (int i = 1; i <= role.getdistM(); i++){
                
            }
        }
    }

    /**
     * déplace le joueur de manière aléatoire
     */
    
    @Override
    public void deplace(){
        System.out.println("Le joueur se déplace");
        this.role.deplace();
    }
    
    /**
     * premet de déplacer le joueur à la case de coordonée x y 
     * @param x
     * @param y 
     */
    
    @Override
    public void deplace(int x,int y){
        System.out.println("Le joueur se déplace");
        this.role.deplace( x ,  y);
    }
    
    public void combattre(Creature c){
        if (this.role instanceof Guerrier){
            this.role.combattre(c);
        } else if (this.role instanceof Archer){
            this.role.combattre(c);
        }
    }
    
    public void affiche(){
        System.out.println("Le joueur se déplace");
    }
}

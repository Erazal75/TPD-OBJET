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
public class Joueur implements Deplacable{
    
    /**
     * role est le rôle du Joueur, cela correspond à un Protagoniste parmi les Personnages
     * numeroJoueur est l'ordre de priorité du Joueur par rapport aux autres Joueurs
     */
    
    Personnage role;
    int numeroJoueur; 
    
    
    public Joueur(){

}
    }
    
    public void joue(){
        System.out.println("Le joueur joue");    
    }

    @Override
    public void deplace(){
        System.out.println("Le joueur se déplace");
}

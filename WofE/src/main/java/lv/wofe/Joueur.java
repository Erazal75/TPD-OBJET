/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail
 */
public class Joueur extends Personnage{
    
    Personnage role;
    
    public Joueur(){
        role = new Archer();
    }
}

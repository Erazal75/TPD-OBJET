/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package lv.wofe;

/**
 *
 * @author lazaregrail
 */
public class WofE {
    static World monMonde;
    
    public static void main(String[] args) {
        
        /* TEST N°1 */
        System.out.println("Test des Classes : Archer, Paysan et Lapin");
        monMonde = new World();
        
        /* TEST n°1)a) 
        System.out.println("Test Robin");
        System.out.println("Test Robin : avant déplacement");
        monMonde.robin.affichePos();
        System.out.println("Test Robin : Robin se déplace");
        monMonde.robin.deplace(5,5);
        System.out.println("Test Robin : après déplacement");
        monMonde.robin.affichePos();
        */
        
        /* TEST n°1)b) 
        System.out.println("Test Peon");
        System.out.println("Test Peon : avant deplacement");
        monMonde.peon.affichePos();
        System.out.println("Test Peon : Peon se deplace");
        monMonde.peon.deplace(7,8);
        System.out.println("Test Peon : apres deplacement");
        monMonde.peon.affichePos();
        */
        
        /* TEST n°1)c) 
        System.out.println("Test Bugs");
        System.out.println("Test Bugs : avant deplacement");
        monMonde.bugs.affichePos();
        System.out.println("Test Bugs : Bugs se deplace");
        monMonde.bugs.deplace(-3,2);
        System.out.println("Test Bugs : apres deplacement");
        monMonde.bugs.affichePos();
        */
        
        /* TEST n°3 */
        System.out.println("Déplacement de Robin");
        System.out.println("Test Robin : avant déplacement");
        monMonde.robin.affichePos();
        System.out.println("Test Robin : Robin se déplace");
        monMonde.robin.deplace(5,5);
        System.out.println("Test Robin : après déplacement");
        monMonde.robin.affichePos();
        
        System.out.println("Vérification de la positon de Guillaume T.");
        monMonde.guillaumeT.affichePos();
        
    }
}

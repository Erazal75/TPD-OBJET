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
        
        monMonde = new World();
        
        /* TEST N°1 
        System.out.println("Test des Classes : Archer, Paysan et Lapin");
        */
        
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
        /*
        System.out.println("Déplacement de Robin");
        System.out.println("Test Robin : avant déplacement");
        monMonde.robin.affichePos();
        System.out.println("Test Robin : Robin se déplace");
        monMonde.robin.deplace(5,5);
        System.out.println("Test Robin : après déplacement");
        monMonde.robin.affichePos();
        
        System.out.println("Vérification de la positon de Guillaume T.");
        monMonde.guillaumeT.affichePos();

        
        */
        // TEST N°5
        
        /*
        monMonde.creerMondeAlea();
        monMonde.robin.affiche();
        monMonde.peon.affiche();
        monMonde.aragorn.affiche();
        monMonde.bugs.affiche();
        monMonde.bugy.affiche();
        monMonde.guillaumeT.affiche();
        monMonde.warwick.affiche();
        */
        
        // TEST N°7.1
        
        /*
        monMonde.aragorn.setpos(0, 0);
        monMonde.robin.setpos(1, 1);
        
        monMonde.aragorn.setdegAtt(30);
        monMonde.aragorn.setpageAtt(80);
        
        monMonde.robin.setptVie(100);
        monMonde.robin.setpagePar(40);
        monMonde.robin.setptPar(10);
        
        monMonde.robin.affiche();
        monMonde.aragorn.affiche();
        
        monMonde.aragorn.combattre(monMonde.robin);
        
        monMonde.robin.affiche();
        monMonde.aragorn.affiche();
        */
      
        // TEST N°7.2
        /*
        monMonde.aragorn.setpos(0, 0);
        monMonde.robin.setpos(3, 0);
        monMonde.robin.setnbFleches(10);
        
        monMonde.aragorn.setptVie(100);
        monMonde.aragorn.setpagePar(100);
        monMonde.aragorn.setptPar(20);
        
        monMonde.robin.setdegAtt(15);
        monMonde.robin.setpageAtt(100);
        monMonde.robin.setdistM(4);
        
        monMonde.robin.affiche();
        System.out.println(monMonde.robin.getnbFleches());
        monMonde.aragorn.affiche();
        
        monMonde.robin.combattre(monMonde.aragorn);
        
        monMonde.robin.affiche();
        System.out.println(monMonde.robin.getnbFleches());
        monMonde.aragorn.affiche();
        */
        
        // TEST N°8
        System.out.println("Test du Systeme des Potions");
        
        monMonde.aragorn.setpos(0, 0);
        monMonde.robin.setpos(0, 1);
        
        monMonde.aragorn.setdegAtt(30);
        monMonde.aragorn.setpageAtt(0);
        
        monMonde.robin.setptVie(100);
        monMonde.robin.setpagePar(30);
        monMonde.robin.setptPar(10);
        
        monMonde.robin.affiche();
        monMonde.aragorn.affiche();
        
        monMonde.aragorn.combattre(monMonde.robin);
        
        monMonde.robin.deplace(0,2);
        
        monMonde.robin.affiche();
        monMonde.aragorn.affiche();
    }
}

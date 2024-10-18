/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package lv.wofe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;

/**
 *
 * @author lazaregrail & victorsimon
 */
public class WofE {
    
    /**
     * monMonde est une instance de World permettant de tester les différentes notions de notre jeu World Of ECN
     */
    static World monMonde;
    
    public static void main(String[] args) throws IOException {
        
        monMonde = new World(10);
        
//////////////////////////////////// TP 3 //////////////////////////////////////
        
        // TEST N°1 
        //System.out.println("Test des Classes : Archer, Paysan et Lapin");
        
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
        
        /*
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
        //System.out.println(monMonde.tableauObjet.size());
    */
        
//////////////////////////////////// TP 4 //////////////////////////////////////
/*
        Random genAlé = new Random();  
        long debut1 = System.nanoTime();
        int compteur = 0;
        for (Creature c: World.gettableauCreature()){
            //c.affichePos();
            c.setptVie(genAlé.nextInt(200));
            //c.affiche();
            compteur=compteur+c.getptVie();
        }
        long fin1 = System.nanoTime();
        System.out.println("le nombre de PV total est "+compteur+" via les iterateurs cela a pris: "+(fin1-debut1)+"ns");
        long debut2 = System.nanoTime();
        compteur = 0;
        for (int i = 0; i<World.gettableauCreature().size()-1;i=i+1){
            //c.affichePos();
            World.gettableauCreature().get(i).setptVie(genAlé.nextInt(200));
            //c.affiche();
            compteur=compteur+World.gettableauCreature().get(i).getptVie();
        }
        long fin2 = System.nanoTime();
        System.out.println("le nombre de PV total est "+compteur+" via la taille du tableau cela a pris: "+(fin2-debut2)+"ns");
        */

//////////////////////////////////// TP 5 //////////////////////////////////////

//////////////// Exceptions  ////////////////////

    // NullPointerException
    
    /*
    
        String str = null;  // Initialisation d'une variable avec la valeur null

        try {
            // Tentative d'accès à une méthode sur un objet null
            System.out.println(str.length());  // Cela va lever une NullPointerException
        } catch (NullPointerException e) {
            // Gérer l'exception NullPointerException ici
            System.out.println("Erreur : NullPointerException capturee !");
        } finally {
            // Ce bloc s'exécutera toujours, que l'exception soit levée ou non
            System.out.println("Bloc finally executed.");
        }
        
    */
    
    // ArrayIndexOutOfBoundsException
    
    /*
    
        int[] numbers = {1, 2, 3};  // Tableau avec 3 éléments

        try {
            // Tentative d'accès à un index hors limites
            System.out.println(numbers[5]);  // Cela va lever une ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            // Gérer l'exception ArrayIndexOutOfBoundsException ici
            System.out.println("Erreur : ArrayIndexOutOfBoundsException capturée !");
        } finally {
            // Ce bloc s'exécutera toujours, que l'exception soit levée ou non
            System.out.println("Bloc finally execute.");
        }

    */
    
    // ArithmeticException
    
    /*
    
        int a = 10;
        int b = 0;

        try {
            // Tentative de division par zero
            int result = a / b;  // Cela va lever une ArithmeticException
            System.out.println("Resultat : " + result);
        } catch (ArithmeticException e) {
            // Gerer l'exception ArithmeticException ici
            System.out.println("Erreur : ArithmeticException capturee !");
        } finally {
            // Ce bloc s'executera toujours, que l'exception soit levee ou non
            System.out.println("Bloc finally execute.");
        }
        
    */
            
    // ClassCastException
    
    /*
    
        Object o = "Ceci est une chaine";  // Une chaine de caracteres

        try {
            // Tentative de conversion d'une chaine en Integer
            Integer num = (Integer) o;  // Cela va lever une ClassCastException
            System.out.println("Nombre : " + num);
        } catch (ClassCastException e) {
            // Gerer l'exception ClassCastException ici
            System.out.println("Erreur : ClassCastException capturee !");
        } finally {
            // Ce bloc s'executera toujours, que l'exception soit levee ou non
            System.out.println("Bloc finally execute.");
        }
    
    */
    
    // NumberFormatException
    
    /*
    
        String str = "abc";  // Une chaine de caracteres non convertible en nombre

        try {
            // Tentative de conversion de la chaine en entier
            int num = Integer.parseInt(str);  // Cela va lever une NumberFormatException
            System.out.println("Nombre : " + num);
        } catch (NumberFormatException e) {
            // Gerer l'exception NumberFormatException ici
            System.out.println("Erreur : NumberFormatException capturee !");
        } finally {
            // Ce bloc s'executera toujours, que l'exception soit levee ou non
            System.out.println("Bloc finally execute.");
        }

    */
    
    // StackOverflowError
    
    /*
    
        try {
            // Appel récursif sans condition d'arrêt, ce qui va provoquer une StackOverflowError
            recursiveMethod();
        } catch (StackOverflowError e) {
            // Gérer l'erreur StackOverflowError ici
            System.out.println("Erreur : StackOverflowError capturee !");
        } finally {
            // Ce bloc s'executera toujours, que l'erreur soit levee ou non
            System.out.println("Bloc finally execute.");
        }
    }

    public static void recursiveMethod() {
        // Appel de la méthode elle-même sans condition d'arrêt
        recursiveMethod();

    */
    
    // ConcurrentModificationException
    
    /*
    
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        try {
            // Tentative de modification de la liste pendant l'itération
            for (Integer number : numbers) {
                System.out.println("Nombre : " + number);
                // Modifiez la liste pendant l'itération
                if (number == 2) {
                    numbers.remove(number);  // Cela va lever une ConcurrentModificationException
                }
            }
        } catch (ConcurrentModificationException e) {
            // Gerer l'exception ConcurrentModificationException ici
            System.out.println("Erreur : ConcurrentModificationException capturee !");
        } finally {
            // Ce bloc s'executera toujours, que l'exception soit levee ou non
            System.out.println("Bloc finally execute.");
        }
        
        */
    
//////////////// WOE  ////////////////////

        //monMonde.afficheWorld();
        while (true){
            monMonde.afficheJeu();
            monMonde.tourDeJeu();
        }
    }
}

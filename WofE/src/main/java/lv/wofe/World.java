/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail
 */
import java.util.*;

public class World {
    
    public Archer robin = new Archer();
    public Archer guillaumeT = new Archer(robin);
    public Paysan peon = new Paysan();
    public Guerrier aragorn = new Guerrier();
    public Loup warwick = new Loup();
    public Lapin bugs = new Lapin();
    public Lapin bugy = new Lapin();
    public ArrayList<Creature> tableauCreature = new ArrayList<>();

    public World(){
        
    robin = new Archer();
    peon = new Paysan();
    aragorn = new Guerrier();
    warwick = new Loup();
    bugs = new Lapin();
    bugy = new Lapin();
    
    tableauCreature.add(robin);
    tableauCreature.add(peon); 
    tableauCreature.add(aragorn);
    tableauCreature.add(warwick);
    tableauCreature.add(bugs); 
    tableauCreature.add(bugy); 
    }
    
    public void creerMondeAlea(){
        Random genAlé = new Random();
        for(Creature c : tableauCreature){
            boolean noOneThere = false;
            int x;
            int y;
            int compteur = 0;
            while (noOneThere != true) {
                x = genAlé.nextInt(100);
                y = genAlé.nextInt(100);
                for(Creature d : tableauCreature){
                    if (!(c.equals(d))){
                        if (x == d.getposX()&& y == d.getposY()){
                            noOneThere = false;
                            compteur = 0;
                        }
                        else{
                            compteur = compteur + 1;
                        }
                    if (compteur == tableauCreature.size()-1) {
                        noOneThere = true;
                        }
                    }
                }
            }
            c.deplace(x,y);
        }   
    }
}

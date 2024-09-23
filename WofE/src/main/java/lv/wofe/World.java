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
    static ArrayList<Objet> tableauObjet = new ArrayList<>();
    public PotionSoin heal = new PotionSoin();

    public World(){
        
    robin = new Archer();
    peon = new Paysan();
    aragorn = new Guerrier();
    warwick = new Loup();
    bugs = new Lapin();
    bugy = new Lapin();
    
    heal = new PotionSoin();
    heal.setpos(0,2);
    
    tableauCreature.add(robin);
    tableauCreature.add(peon); 
    tableauCreature.add(aragorn);
    tableauCreature.add(warwick);
    tableauCreature.add(bugs); 
    tableauCreature.add(bugy); 
    tableauCreature.add(guillaumeT); 
    
    tableauObjet.add(heal);
    }
    
    static ArrayList<Objet> gettableauObjet(){
        return tableauObjet;
    }
    
    public void creerMondeAlea(){
        Random genAlé = new Random();
        for(Creature c : tableauCreature){
            boolean noOneThere = false;
            int x=genAlé.nextInt(201)-100;
            int y=genAlé.nextInt(201)-100;
            int compteur = 0;
            while (noOneThere != true) {
                x = genAlé.nextInt(201)-100;
                y = genAlé.nextInt(201)-100;
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

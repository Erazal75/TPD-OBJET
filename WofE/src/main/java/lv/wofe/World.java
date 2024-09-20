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
    public Lapin bugs = new Lapin();
    public Lapin bugy = new Lapin();
    
    
    public World(){
    robin = new Archer();
    peon = new Paysan();
    bugs = new Lapin();
    bugy = new Lapin();
    }
    
    public void creerMondeAlea(){
        Random genAlé = new Random();
        int x = genAlé.nextInt(100);
        int y = genAlé.nextInt(100);
        
        robin.setpos(x,y);
        
        while (x == robin.getposX() && y == robin.getposY()){
            x = genAlé.nextInt(100);
            y = genAlé.nextInt(100);
        }
        
        peon.setpos(x, y);
        
        while (x == robin.getposX() && y == robin.getposY() || x == peon.getposX() && y == peon.getposY()){
            x = genAlé.nextInt(100);
            y = genAlé.nextInt(100);
        }
        
        bugs.setpos(x, y);
        
        while (x == robin.getposX() && y == robin.getposY() || 
                x == peon.getposX() && y == peon.getposY() || 
                x == bugs.getposX() && y == bugs.getposY()){
            x = genAlé.nextInt(100);
            y = genAlé.nextInt(100);
        }
        
        bugy.setpos(x, y);
        
    }
}

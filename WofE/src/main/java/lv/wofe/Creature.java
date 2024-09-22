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

public class Creature {
    
    private int ptVie ; 
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;

    
    public Creature(int ptVie,int dAtt, int ptP,int pageA, int pageP,Point2D p){
        this.ptVie = ptVie; 
        degAtt = dAtt;
        ptPar = ptP;
        pageAtt = pageA;
        pagePar = pageP;
        pos = p;
    }
    
    public Creature(Creature p){
        ptVie = p.ptVie;
        degAtt = p.degAtt;
        ptPar = p.ptPar;
        pageAtt = p.pageAtt;
        pagePar = p.pagePar;
        pos = new Point2D(p.pos);
    }
    
    public Creature(){
        this.ptVie = 0; 
        degAtt = 0;
        ptPar = 0;
        pageAtt = 0;
        pagePar = 0;
        pos = new Point2D();
    }
    
    public int getptVie(){
        return ptVie;
    }

    public int getdegAtt(){
        return degAtt;
    } 
    
    public int getptPar(){
        return ptPar;
    }
    
    public int getpageAtt(){
        return pageAtt;
    }
    
    public int getpagePar(){
        return pagePar;
    }
    
    public int getposX(){
        return pos.getX();
    }
    
    public int getposY(){
        return pos.getY();
    }
        
    public void setptVie(int ptVie){
        this.ptVie = ptVie;
    } 
    
    public void setdegAtt(int dAtt){
        degAtt = dAtt;
    } 
    
    public void setptPar(int ptP){
        ptPar = ptP;
    }
    
    public void setpageAtt(int pageA){
        pageAtt = pageA;
    }
    
    public void setpagePar(int pageP){
        pagePar = pageP;
    }
    
    public void setpos(int x, int y){
        pos.setPosition(x,y);
    }
    
    public void deplace(){
        Random genAlé = new Random();
        int x = genAlé.nextInt(21)-10;
        int y = genAlé.nextInt(21)-10;
        deplace(x,y);
    }
    
    public void deplace(int x , int y){
        pos.setPosition(pos.getX() + x, pos.getY() + y);
    }
    
    public float distance (Creature c){
        return this.pos.distance(c.pos);
    }

    /* renvoie un booléen traduissant si les deux créatures sont sur la même case */
    public boolean coincide(Creature c){
        boolean reponse = (this.getposX()== c.getposX() && this.getposY()== c.getposY());
        return(reponse);
    }
}


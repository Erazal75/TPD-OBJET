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

public class Personnage {
    
    private String nom ;
    private int ptVie ; 
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private int distAttMax;
    private Point2D pos;

    
    public Personnage(String nom,int ptVie,int dAtt, int ptP,int pageA, int pageP, int distAttM,Point2D p){
        this.nom = nom;
        this.ptVie = ptVie; 
        degAtt = dAtt;
        ptPar = ptP;
        pageAtt = pageA;
        pagePar = pageP;
        distAttMax = distAttM;
        pos = p;
    }
    
    public Personnage(Personnage p){
        nom = p.nom;
        ptVie = p.ptVie;
        degAtt = p.degAtt;
        ptPar = p.ptPar;
        pageAtt = p.pageAtt;
        pagePar = p.pagePar;
        distAttMax = p.distAttMax;
        pos = new Point2D(p.pos);
    }
    
    public Personnage(){
        this.nom = "";
        this.ptVie = 0; 
        degAtt = 0;
        ptPar = 0;
        pageAtt = 0;
        pagePar = 0;
        distAttMax = 0;
        pos = new Point2D();
    }
    
    public void rencontrer(Personnage p){
       
        System.out.println("Enchanter "+ p.nom);
        System.out.println("Enchanter de même "+this.nom);
    }
    
    public String getNom(){
        return nom;
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
    
    public int getdistAttMax(){
        return distAttMax;
    }
    
    public int getposX(){
        return pos.getX();
    }
    
    public int getposY(){
        return pos.getY();
    }
    
    public void setNom(String nom){
        this.nom = nom;
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
    
    public void setdistAttMax(int distattM){
        distAttMax = distattM;
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
    
    public void affiche(){
        System.out.println("Votre personnage s'appelle: "+nom+" point de vie: "+ptVie+" dégat d'attaque: "+degAtt+" point de Par: "+ptPar+" pageAtt: "+pageAtt+" pagePar: "+pagePar+" distance maximale d'attaque: "+distAttMax+" et de position: ["+ pos.getX()+";"+pos.getY()+"]");
    }
    
    public void affichePos(){
        System.out.println("Votre personnage est en position: ["+ pos.getX()+";"+pos.getY()+"]");
    }
    
}


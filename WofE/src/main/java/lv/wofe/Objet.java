/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail
 */
abstract class Objet {
    
    private int place;
    private int prix;
    private Point2D pos;
    
    public Objet(int place,int prix, Point2D p){
        this.place = place;
        this.prix = prix;
        this.pos = p;
    }
    
    public Objet(Objet o){
        this.place = o.place;
        this.prix = o.prix;
    }
    
    public Objet(){
        this.place = 0;
        this.prix = 0;
    }
    
    public int getPlace(){
        return place;
    }
    
    public int getPrix(){
        return prix;
    }
    
    public void setPrix(int pris){
        prix = pris;
    }
    
    public void setpos(int x, int y){
        pos.setPosition(x,y);
    }
    
    public int getposX(){
        return pos.getX();
    }
    
    public int getposY(){
        return pos.getY();
    }
    
    public abstract void activation(Creature c);
    
    
}

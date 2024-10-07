/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail & victorsimon
 * 
 */

abstract class Objet extends ElementDeJeu {
    
    /**
     * place est le nombre de place que l'objet occupe dans l'inventaire d'un Personnage
     * prix est la quantité d'argent que vaut l'Objet
     * pos est la position de l'Objet
     */
    
    private int place;
    private int prix;
    private Point2D pos;
    
    /**
     * Premier constructeur d'Objet
     * 
     * @param place est le nombre de place que l'objet occupe dans l'inventaire d'un Personnage
     * @param prix est la quantité d'argent que vaut l'Objet
     * @param p est la position de l'Objet
     */
    
    public Objet(int place,int prix, Point2D p){
        this.place = place;
        this.prix = prix;
        this.pos = p;
    }
    
    /**
     * Deuxième constructeur d'Objet
     * @param o est un autre Objet, à partir de laquel notre Objet sera créé
     */
    
    public Objet(Objet o){
        this.place = o.place;
        this.prix = o.prix;
        this.pos = o.pos;
    }
    
    /**
     * Troisème contructeur d'Objet, permet d'initialiser tous les attributs avec leur valeur par défaut.
     */
    
    public Objet(){
        this.place = 0;
        this.prix = 0;
        this.pos = new Point2D();
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
    
    /**
     * activation permet d'activer l'Objet sur la Creature c.
     * il est important de noter que chaque Objet possède sa propre activation
     * @param c est la Creature sur laquelle l'Objet sera activé
     */
    
    public abstract void activation(Creature c);
    
    
}

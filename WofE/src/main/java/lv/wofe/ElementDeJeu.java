/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

import java.util.ArrayList;

/**
 *
 * @author lazareGrail & victorSimon
 */
abstract class ElementDeJeu {
    
    /**
     * pos est la position de l'ElementDeJeu
     */
    
    private Point2D pos;
    private World jeu;
    
    /** 
     * Premier constructeur de ElementDeJeu
     *@param p est la position de l'ElementDeJeu
     */
    public ElementDeJeu(Point2D p,World jeu){
        this.pos = p;
        this.jeu = jeu;
    }
    
    /**
     * Deuxième constructeur de Monstre
     * @param e est un autre ElementDeJeu, à partir de laquel notre ElementDeJeu sera créé
     */
    
    public ElementDeJeu(ElementDeJeu e){
        this.pos = e.pos;
        this.jeu = e.jeu;
    }
    
    /**
     * Troisème contructeur de Monstre, permet d'initialiser tous les attributs avec leur valeur par défaut.
     */
    
    public ElementDeJeu(){
        this.pos = new Point2D();
        jeu = null;
    }
    
    /**
     * isObjet permet de savoir, grâce à un booléen, si l'ElementDeJeu est un Objet.
     */
    
    public boolean isObjet(){
        return (this instanceof Objet);
    }
    
    /**
     * isCreature permet de savoir, grâce à un booléen, si l'ElementDeJeu est une Creature.
     */
    
    public boolean isCreature(){
        return (this instanceof Creature);
    }
    
    public World getjeu(){
        return jeu;
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
     * distance permet de calculer la distance entre deux Creatures
     * @param c est la Creature avec laquelle nous calculons la distance
     * @return 
     */
    
    
    public float distance (ElementDeJeu c){
        return this.pos.distance(c.pos);
    }
    
    public void range(ArrayList<Integer> listAttack, ArrayList<Point2D> listParc, Point2D p1,int dist,int distMax){
        int x = p1.getX();
        int y = p1.getY();
        listParc.add(p1);
        //World jeu = this.getjeu();
        
        if (jeu.getmap(x, y) > 1 && jeu.getmap(x, y) < 1000){
            listAttack.add(jeu.getmap(x, y));
        }
        
        ArrayList<Point2D> listAVenir = new ArrayList<>();
        if (x-1 >= 0){
            Point2D p = new Point2D(x-1, y);
            //if (!containsP2D(listParc,p)){
                listAVenir.add(p);
            //}
        }
        if (x+1 <= jeu.getTaille()-1){
            Point2D p = new Point2D(x+1, y);
            //if (!containsP2D(listParc,p)){
                listAVenir.add(p);
            //}
        }
        if (y+1 <= jeu.getTaille()-1){
            Point2D p = new Point2D(x, y+1);
            //if (!containsP2D(listParc,p)){
                listAVenir.add(p);
            //}
        }
        if (y-1 >=0){
            Point2D p = new Point2D(x, y-1);
            //if (!containsP2D(listParc,p)){
                listAVenir.add(p);
            //}
        }
        if (dist < distMax){
            while (!listAVenir.isEmpty()){
                Point2D p3 = listAVenir.remove(0);
                //if (!containsP2D(listParc,p3)){
                    range(listAttack,listParc,p3,dist+1,distMax); 
                //}
            }
        }
    } 
}

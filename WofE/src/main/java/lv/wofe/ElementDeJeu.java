/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

import java.util.ArrayList;

/**
 *
 * @author lazareGrail victorSimon
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
    
    /**
     * Permet de calculer les Creatures qui sont range de notre Creature
     * Cela utilise une liste listAttack qui est l'ensemble des Creatures qui sont attaqueble par notre Creature
     * listParc qui est une liste des case déjà parcouru
     * p1 qui est le Point2D qu'on est entrain de regarder
     * dist est la distance à la case initiale
     * distMax est la distance maximale a laquelle nous avons le droit d'aller de la case initiale
     * 
     * Nous avons rencontrer un problème que nous avons pas réussi à regler
     * Notre algorythme passe plusieurs fois sur les même cases 
     * ce qui n'est pas un problème pour notre algorythme de pettie taille 
     * mais qui peut le devenir avec un jeu plus gros
     * 
     * Nous avons essayé plusieurs solution mais rien de concluant car 
     * Soit l'algorythme ne passait jamais sur certaines cases 
     * Soit il fallait créer une nouvelle classe qui était Point2d avec un int en plus 
     * représentant la distance à la case initiale
     * 
     * @param listAttack
     * @param listParc
     * @param p1
     * @param dist
     * @param distMax 
     */
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

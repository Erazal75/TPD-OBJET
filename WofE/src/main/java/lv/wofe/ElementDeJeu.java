/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

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
}

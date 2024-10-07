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
    
    /** 
     * Premier constructeur de ElementDeJeu
     *@param p est la position de l'ElementDeJeu
     */
    public ElementDeJeu(Point2D p){
        this.pos = p;
    }
    
    /**
     * Deuxième constructeur de Monstre
     * @param e est un autre ElementDeJeu, à partir de laquel notre ElementDeJeu sera créé
     */
    
    public ElementDeJeu(ElementDeJeu e){
        this.pos = e.pos;
    }
    
    /**
     * Troisème contructeur de Monstre, permet d'initialiser tous les attributs avec leur valeur par défaut.
     */
    
    public ElementDeJeu(){
        this.pos = new Point2D();
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
}

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
     * c est la Creature associée à l'ElementDeJeu (NULL si il s'agit d'un Objet)
     * o est l'Objet associé à l'ElementDeJeu (NULL si il s'agit d'une Creature)
     */
    
    public Creature c;
    public Objet o;
    public World jeu;
    
    /** 
     * Constructeur par défaut
     */
    public ElementDeJeu(){
        this.o = null;
        this.c = null;
        this.jeu = null;
    }
    
    /** 
     * Constructeur de Creature
     * @param c est la Creature correspondante à l'ElementDeJeu
     */
    public ElementDeJeu(Creature c , World ju){
        this.c = c;
        this.o = null;
        jeu = ju;
    }
    
    /** 
     * Constructeur d'Objet
     * @param o est l'Objet correspondant à l'ElementDeJeu
     */
    public ElementDeJeu(Objet o, World ju){
        this.o = o;
        this.c = null;
        jeu = ju;
    }
    
    /**
     * isObjet permet de savoir, grâce à un booléen, si l'ElementDeJeu est un Objet.
     */
    
    public boolean isObjet(){
        if (this.o != null){
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * isCreature permet de savoir, grâce à un booléen, si l'ElementDeJeu est une Creature.
     */
    
    public boolean isCreature(){
        if (this.c != null){
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * getter de l'Objet.
     */
    
    public Objet getObjet(){
        return this.o;
    }
    
    /**
     * getter de la Creature.
     */
    
    public Creature getCreature(){
        return this.c;
    }
    
    public abstract int getposX();
    public abstract int getposY();
    public abstract void setpos(int x, int y);
}

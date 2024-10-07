/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazareGrail & victorSimon
 */
public class Champignon extends Nourriture{
    
    /** 
     * malusPageAtt est le malus (entier positif) de pourcentage d'attaque affecté (soutrait) à la Creature consommant le Champignon
     * dure 3 tours par défaut.
     */
    
    private int malusPageAtt;
    
    /**
     * Premier constructeur de Champignon
     * @param malusPageAtt est le malus de pourcentage d'attaque affecté à la Creature consommant le Champignon
     * @param pos est la position du Champignon
     */
    
    public Champignon(int malusPageAtt, Point2D pos){
        super(3, pos);
        this.malusPageAtt = malusPageAtt; 
    }
    
    /**
     * Deuxième constructeur de Champignon, par copie
     * @param c est un autre Champignon, à partir de laquel notre Champignon sera créé
     */
    
    public Champignon(Champignon c){
        super(c);
        this.malusPageAtt = c.malusPageAtt;
    }
    
    /**
     * Troisieme constructeur de Nourriture, par defautL. 
     */
    
    public Champignon(){
        super();
        this.malusPageAtt = 0;
    }
    
    @Override
    public void activation(Creature c) {
        c.setpageAtt(c.getpageAtt() - malusPageAtt);
        System.out.println("Vous avez le Tournis !");
    }
    
}

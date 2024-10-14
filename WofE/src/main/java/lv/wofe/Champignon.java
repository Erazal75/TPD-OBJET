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
    private int utilRestantes = 3;
    
    /**
     * Premier constructeur de Champignon
     * @param malusPageAtt est le malus de pourcentage d'attaque affecté à la Creature consommant le Champignon
     * @param pos est la position du Champignon
     */
    
    public Champignon(int malusPageAtt, Point2D pos,World jeu){
        super(3, pos, jeu);
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
    
    public Champignon(World jeu){
        super(jeu);
        this.malusPageAtt = 0;
    }
    
    public Champignon(int malusPageAtt,World jeu){
        super(3,new Point2D(),jeu);
        this.malusPageAtt = malusPageAtt; 
    }
    
    @Override
    public void activation(Creature c) {
        c.setpageAtt(c.getpageAtt() - malusPageAtt);
        System.out.println("Vous avez le Tournis !");
    }
    
    public int getMalus(){
        return malusPageAtt;
    }
        
    @Override
    public int getutilRestantes(){
        return(this.utilRestantes);
    }
    
    @Override
    public void setutilRestantes(int x){
        this.utilRestantes = x;
    }
}

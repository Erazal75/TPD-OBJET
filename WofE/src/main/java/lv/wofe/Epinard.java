/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazare & victorSimon
 */
public class Epinard extends Nourriture{
    
    /**
     * bonusDegAtt est le bonus de dégât d'attaque engendré par la consommation d'un Epinard
     * dure 5 tours par défaut.
     */
    
    private int bonusDegAtt;
    private Point2D pos;
    
    /**
     * Premier constructeur d'Epinard
     * @param bonusDegAtt est le bonus de dégât d'attaque engendré par la consommation d'un Epinard
     * @param pos est la position de l'Epinard
     */
    
    public Epinard(int bonusDegAtt, Point2D pos){
        super(5, pos);
        this.bonusDegAtt = bonusDegAtt; 
    }
    
    /**
     * Deuxième constructeur d'Epinard, par copie
     * @param e est un autre Epinard, à partir de laquel notre Epinard sera créé
     */
    
    public Epinard(Epinard e){
        super(e);
        this.bonusDegAtt = e.bonusDegAtt;
    }
    
    /**
     * Troisieme constructeur de Nourriture, par defautL. 
     */
    
    public Epinard(){
        super();
        this.bonusDegAtt = 0;
    }
    
    @Override
    public void activation(Creature c) {
        c.setdegAtt(c.getdegAtt() + bonusDegAtt);
        System.out.println("Vous avez gagné de la Force !");
    }
    
}

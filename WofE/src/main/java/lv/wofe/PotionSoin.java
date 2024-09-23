/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail
 */
public class PotionSoin extends Objet {
    
    private int nbPVRendu;
    
    public PotionSoin(int nbPVRendu, int place,int prix,Point2D p){
        super(place,prix,p);
        this.nbPVRendu = nbPVRendu;
    }
    
    public PotionSoin(){
        super();
        nbPVRendu = 0;
    }
    
    @Override
    public void activation(Creature c) {
        c.setptVie(c.getptVie() + nbPVRendu);
        System.out.println("Vous avez regagné des points de vie");
    }
}

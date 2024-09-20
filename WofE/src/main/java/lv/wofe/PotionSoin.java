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
    
    public PotionSoin(int nbPVRendu, int place,int prix){
        super(place,prix);
        this.nbPVRendu = nbPVRendu;
    }
    
    public PotionSoin(){
        super();
        nbPVRendu = 0;
    }
    
    
}

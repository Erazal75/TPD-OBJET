/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail
 */
public class Lapin extends Monstre{
    
    public Lapin(int pV,int dA,int ptPar,int paAtt,int paPar,Point2D p,int nbFleches){
        super(pV,dA,ptPar,paAtt,paPar,p);
    }
    
    public Lapin(Lapin l){
        super(l);
    }
    
    public Lapin(){
        super();
    }
    
}

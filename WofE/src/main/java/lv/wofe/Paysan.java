/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail
 */
public class Paysan extends Personnage{
    
    public Paysan(String n,int pV,int dA,int ptPar,int paAtt,int paPar,int dMax,Point2D p,int argent,int inventaire){
        super(n,pV,dA,ptPar,paAtt,paPar,dMax,p,argent,inventaire);
    }
    
    public Paysan(Paysan p){
        super(p);
    }
    
    public Paysan(){
        super();
    }
}

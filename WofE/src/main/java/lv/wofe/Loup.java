/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

import java.util.Random;

/**
 *
 * @author lazaregrail
 */
public class Loup extends Monstre{
    
  public Loup(int pV,int dA,int ptPar,int paAtt,int paPar,Point2D p){
    super(pV,dA,ptPar,paAtt,paPar,p);
  }
    
  public Loup(Loup l){
    super(l);
  }
    
  public Loup(){
    super();
  }
    
  public void combattre(Creature c){
      if (this.distance(c)<=1){
          Random genAlé = new Random();
          int pourcAtt = genAlé.nextInt(100);
          int pourcPar = genAlé.nextInt(100);
          if (pourcAtt <= this.getpageAtt() && pourcPar>c.getpagePar()){
              c.setptVie(c.getptVie() - this.getdegAtt());
          }
          else if (pourcAtt <= this.getpageAtt() && pourcPar<=c.getpagePar() && this.getdegAtt() - c.getptPar() >0){
              c.setptVie(c.getptVie() - this.getdegAtt() + c.getptPar());
          }
    }
  
  
}
}

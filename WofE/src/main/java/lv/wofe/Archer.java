/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail
 */
public class Archer extends Personnage{
    
    private int nbFleches;
    
    public Archer(String n,int pV,int dA,int ptPar,int paAtt,int paPar,int dMax,Point2D p,int nbFleches,int argent , int inventaire){
        super(n,pV,dA,ptPar,paAtt,paPar,dMax,p,argent ,inventaire);
        this.nbFleches = nbFleches; 
    }
    
    public Archer(Archer a){
        super(a);
        this.nbFleches = a.nbFleches; 
    }
    
    public Archer(){
        super();
        nbFleches = 0;
    }
    
    public void combattre(Creature c){
      if (this.getdegAtt()-c.getptPar() > 0 && this.nbFleches > 0){
          c.setptVie(c.getptVie() - this.getdegAtt() + c.getptPar());
          this.nbFleches = this.nbFleches - 1;
      }
      else if(this.getdegAtt()-c.getptPar() <= 0 && this.nbFleches > 0){
          this.nbFleches = this.nbFleches - 1;
      }
    }
}

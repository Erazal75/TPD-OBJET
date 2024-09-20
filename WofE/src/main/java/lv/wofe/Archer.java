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
      if (this.distance(c)>1 && this.distance(c)<= this.getdistM() ){
          Random genAlé = new Random();
          int pourcAtt = genAlé.nextInt(100);
          if (pourcAtt <= this.getpageAtt() ){
              c.setptVie(c.getptVie() - this.getdegAtt());
    }
}
}}

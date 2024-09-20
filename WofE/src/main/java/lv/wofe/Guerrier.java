/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail
 */
public class Guerrier extends Personnage{
    
    private Epee arme;
    
    public Guerrier(String n,int pV,int dA,int ptPar,int paAtt,int paPar,int dMax,Point2D p,int place,int nbmain,int degEpee,int prix,int argent,int inventaire){
        super(n,pV,dA,ptPar,paAtt,paPar,dMax,p,argent,inventaire);
        arme = new Epee(nbmain,degEpee,place,prix);
    }
    
    public Guerrier(Guerrier a){
        super(a);
        arme = new Epee(a.arme);
    }
    
    public Guerrier(){
        super();
        arme = new Epee();
    }
    
    public void combattre(Creature c){
      if (this.arme.getdegAtt() + this.getdegAtt() - c.getptPar() > 0){
          c.setptVie(c.getptVie() - this.getdegAtt() - this.arme.getdegAtt() + c.getptPar());
      }
  }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

import java.util.Random;

/**
 *
 * @author lazaregrail & victorsimon
 */
public class Guerrier extends Personnage{
    
    /**
     * arme est l'Epee maniée par le Guerrier
     */
    private Epee arme;
    
    /**
     * Premier constructeur de Personnage
     * 
     * @param n est le nom du Personnage
     * @param pV est le nombre de point de vie du Guerrier
     * @param dA est le nombre de dégât d'attaque du Guerrier
     * @param ptPar est le nombre de dégat que le Guerrier pare a chaque parade réussie
     * @param paAtt est le pourcentage de chance qu'une attaque du Guerrier soit réussie
     * @param paPar est le pourcentage de chance qu'une parade du Guerrier soit réussie
     * @param dMax est la distance maximun à laquelle le Guerrier peut attaquer 
     * @param p est la position du Guerrier
     * @param place est la taille maximun de l'inventaire du Guerrier
     * @param nbmain est le nombre de main du Guerrier occupées à manier une Epee
     * @param degEpee est la caractéristique de dégât bonus de l'Epee du Guerrier
     * @param prix est la caractéristique de prix de l'Epee du Guerrier
     * @param argent est la somme d'argent que le Guerrier possède
     * @param inventaire est la taille maximun de l'inventaire du Guerrier
     */
    
    public Guerrier(String n,int pV,int dA,int ptPar,int paAtt,int paPar,int dMax,Point2D p,int place,int nbmain,int degEpee,int prix,int argent,int inventaire){
        super(n,pV,dA,ptPar,paAtt,paPar,dMax,p,argent,inventaire);
        arme = new Epee(nbmain,degEpee,place,prix,p);
    }
    
    /**
     * Deuxième constructeur de Guerrier
     * @param a est un autre Guerrier, à partir de laquel notre Guerrier sera créé
     */
    
    public Guerrier(Guerrier a){
        super(a);
        arme = new Epee(a.arme);
    }
    
    /**
     * Troisème contructeur de Guerrier, permet d'initialiser tous les attributs avec leur valeur par défaut.
     */
    
    public Guerrier(){
        super();
        arme = new Epee();
    }
    
    /**
     * combattre permet d'effectuer une attaque du Guerrier sur la Creature c.
     * le combat est régit par les pourcentage d'attaque et de parade des deux protagonistes
     * @param c est la Creature que notre Guerrier va attaquer
     */
    
    public void combattre(Creature c){
      if (this.distance(c)<=1){
          Random genAlé = new Random();
          int pourcAtt = genAlé.nextInt(100);
          int pourcPar = genAlé.nextInt(100);
          if (pourcAtt <= this.getpageAtt() && pourcPar>c.getpagePar()){
              c.setptVie(c.getptVie() - this.getdegAtt());
              System.out.println("l'attaque du Guerrier est un succès");
          }
          else if (pourcAtt <= this.getpageAtt() && pourcPar<=c.getpagePar() && this.getdegAtt() - c.getptPar() >0){
              c.setptVie(c.getptVie() - this.getdegAtt() + c.getptPar());
              System.out.println("l'attaque du Guerrier est contrée");
          }
    }
  }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

import java.util.*;

/**
 *
 * @author lazaregrail victorsimon
 */
public class Guerrier extends Personnage implements Combattant{
    
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
     * @param placeEpee est la place que prend l'epee dans l'inventaire du Guerrier
     * @param nbmain est le nombre de main du Guerrier occupées à manier une Epee
     * @param degEpee est la caractéristique de dégât bonus de l'Epee du Guerrier
     * @param prix est la caractéristique de prix de l'Epee du Guerrier
     * @param argent est la somme d'argent que le Guerrier possède
     * @param jeu est une représentation matricielle de la carte
     * @param effets est une Collection List de Utilisable contenant les effets appliqués aux joueurs pendant le tour
     */
 
    public Guerrier(String n,int pV,int dA,int ptPar,int paAtt,int paPar,int dMax,Point2D p,
            int placeEpee,int nbmain,int degEpee,int prix,int argent, World jeu, List<Utilisable> effets){
        super(n,pV,dA,ptPar,paAtt,paPar,dMax,p,argent,jeu, effets);
        arme = new Epee(nbmain,degEpee,placeEpee,prix,p,jeu);
    }
    
    /** 
     * Deuxième Connstructeur de Guerrier.
     * @param n est le nom du Personnage
     * @param pV est le nombre de point de vie du Guerrier
     * @param dA est le nombre de dégât d'attaque du Guerrier
     * @param ptPar est le nombre de dégat que le Guerrier pare a chaque parade réussie
     * @param paAtt est le pourcentage de chance qu'une attaque du Guerrier soit réussie
     * @param paPar est le pourcentage de chance qu'une parade du Guerrier soit réussie
     * @param dMax est la distance maximun à laquelle le Guerrier peut attaquer 
     * @param p est la position du Guerrier
     * @param argent
     * @param jeu
     * @param effets
     */
    
    public Guerrier(String n,int pV,int dA,int ptPar,int paAtt,int paPar,int dMax,Point2D p, int argent, World jeu,  List<Utilisable> effets) {
        super(n,pV,dA,ptPar,paAtt,paPar,dMax,p, argent, jeu, effets);
    }
     
    
    /**
     * Troisième constructeur de Guerrier
     * @param a est un autre Guerrier, à partir de laquel notre Guerrier sera créé
     */
    
    public Guerrier(Guerrier a){
        super(a);
        arme = new Epee(a.arme);
    }
    
    /**
     * Quatrième contructeur de Guerrier, permet d'initialiser tous les attributs avec leur valeur par défaut.
     * @param jeu
     */
    
    public Guerrier(World jeu){
        super(jeu);
        arme = new Epee(jeu);
    }
    
    /**
     * combattre permet d'effectuer une attaque du Guerrier sur la Creature c.
     * le combat est régit par les pourcentage d'attaque et de parade des deux protagonistes
     * @param c est la Creature que notre Guerrier va attaquer
     */
    
    @Override
    public void combattre(Creature c){
      Random genAlé = new Random();
      int pourcAtt = genAlé.nextInt(100);
      int pourcPar = genAlé.nextInt(100);
      if (pourcAtt <= this.getpageAtt() && pourcPar>c.getpagePar()){
          c.setptVie(c.getptVie() - this.getdegAtt() - this.arme.getdegAtt());
      } else if (pourcAtt <= this.getpageAtt() && pourcPar<=c.getpagePar() && this.getdegAtt() - c.getptPar() >0){
          c.setptVie(c.getptVie() - this.getdegAtt() + c.getptPar());
      }
    }
  }

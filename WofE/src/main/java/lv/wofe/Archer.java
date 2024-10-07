/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

import java.util.Random;

/**
 *
 * @author lazaregrail & victorsimon
 * 
 */
public class Archer extends Personnage implements Combattant{
    
    /**
     * nbFleches est le Nombre de Flèches que l'Archer possède
     */
    private int nbFleches;
    
    /**
     * Premier constructeur d'Archer
     * 
     * @param n est le nom de l'Archer
     * @param pV est le nombre de point de vie de l'Archer
     * @param dA est le nombre de dégât d'attaque de l'Archer
     * @param ptPar est le nombre de dégat que l'Archer pare a chaque parade réussie
     * @param paAtt est le pourcentage de chance qu'une attaque de l'Archer soit réussie
     * @param paPar est le pourcentage de chance qu'une parade de l'Archer soit réussie
     * @param dMax est la distance maximun à laquelle l'Archer peut attaquer 
     * @param p est la position de l'Archer
     * @param nbFleches est le Nombre de Flèches que l'Archer possède
     * @param argent est la somme d'argent que l'Archer possède
     */
    
    public Archer(String n,int pV,int dA,int ptPar,int paAtt,int paPar,int dMax,Point2D p,int nbFleches,int argent){
        super(n,pV,dA,ptPar,paAtt,paPar,dMax,p,argent);
        this.nbFleches = nbFleches; 
    }
    
    /**
     * Deuxième constructeur d'Archer
     * @param a est un autre Archer, à partir de laquel notre Archer sera créé
     */
    
    public Archer(Archer a){
        super(a);
        this.nbFleches = a.nbFleches; 
    }
    
    /**
     * Troisème contructeur d'Archer, permet d'initialiser tous les attributs avec leur valeur par défaut.
     */
    
    public Archer(){
        super();
        nbFleches = 0;
    }
    
    /**
     * combattre permet d'effectuer une attaque d'Archer sur la Creature c.
     * le combat est régit par les pourcentage d'attaque et de parade des deux protagonistes
     * il est notable que l'Archer perd une flèche lorsqu'il attaque
     * @param c est la Creature que notre Archer va attaquer
     */
    
    @Override
    public void combattre(Creature c){
        if (this.distance(c)>1 && this.distance(c)<= this.getdistM() && nbFleches > 0){
            Random genAlé = new Random();
            int pourcAtt = genAlé.nextInt(100);
            nbFleches = nbFleches - 1;
            if (pourcAtt <= this.getpageAtt() ){
                c.setptVie(c.getptVie() - this.getdegAtt());
            }
        }
    } 
    
    public int getnbFleches(){
        return nbFleches;
    }
    
    public void setnbFleches(int nb){
        nbFleches = nb;
    }
}

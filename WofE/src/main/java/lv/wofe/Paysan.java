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
public class Paysan extends Personnage{
    
    /**
     * Premier constructeur de Paysan
     * 
     * @param n est le nom du Paysan
     * @param pV est le nombre de point de vie du Paysan
     * @param dA est le nombre de dégât d'attaque du Paysan
     * @param ptPar est le nombre de dégat que le Paysan pare a chaque parade réussie
     * @param paAtt est le pourcentage de chance qu'une attaque du Paysan soit réussie
     * @param paPar est le pourcentage de chance qu'une parade du Paysan soit réussie
     * @param dMax est la distance maximun à laquelle le Paysan peut attaquer 
     * @param p est la positoin du Paysan
     * @param argent est la somme d'argent que le Paysan possède
     * @param jeu est la représentation matricielle de la carte 
     * @param effets est une Collection List de Utilisable contenant les effets appliqués aux joueurs pendant le tour 
     */
    
    public Paysan(String n,int pV,int dA,int ptPar,int paAtt,int paPar,int dMax,Point2D p,int argent,World jeu, List<Utilisable> effets){
        super(n,pV,dA,ptPar,paAtt,paPar,dMax,p,argent,jeu, effets);
    }
    
    /**
     * Deuxième constructeur de Paysan
     * @param p est un autre Paysan, à partir de laquel notre Paysan sera créé
     */
    
    public Paysan(Paysan p){
        super(p);
    }
    
    /**
     * Troisème contructeur de Paysan, permet d'initialiser tous les attributs avec leur valeur par défaut.
     * @param jeu
     */
    
    public Paysan(World jeu){
        super(jeu);
    }
     
    /**
     * fait que le Paysan ne fait rien quand il attaque
     * @param c 
     */
    
    @Override
    public void combattre(Creature c){
        System.out.println("Le paysan tremble devant l'adversité");
    }
    
}

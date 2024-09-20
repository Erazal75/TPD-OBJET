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
public class Monstre extends Creature{
    
    /**
     * ptVie est son nombre de point de vie
     * degAtt est les dégats qu'il inflige
     * ptPar est le point de dégat qu'il pare a chaque attaque
     * 
     * 
     * pos est 
     */

    /**
     * Permier constructeur de monstre
     * 
     * @param ptVie son nombre de point de vie
     * @param dAtt ses dégats d'attaque
     * @param ptP ses point de parade
     * @param pageA 
     * @param pageP
     * @param p sa position sur la carte
     */
    
    public Monstre(int ptVie,int dAtt, int ptP,int pageA, int pageP,Point2D p){
        super(ptVie,dAtt,ptP,pageA,pageP,p);
    }
    
    /**
     * deuxième contruscteur de monstre
     * 
     * @param m recopie un autre monstre
     */
    
    public Monstre(Monstre m){
        super(m);
    }
    
    /**
     * Troisème contructeur monstre qui met 0 à toutes les attributs
     */
    
    public Monstre(){
        super();
    }
    
    /**
     * getptVie renvoie le nombre de point de vie du presonnage
     * @return int 
     */

    /**
     * getdegAtt renvoie le nombre de dégat d'attaque du monstre
     * @return int
     */
    
    /**
     * getptPar renvoie le nombre de point de parade du monstre
     * @return int
     */
    
    /**
     * getpageAttt renvoie le pageAtt du monstre
     * @return int
     */
    
    /**
     * getpagePar renvoie le pagePar ud perosnnage
     * @return int 
     */
    
    
    /**
     * getposX renvoie la coordonnée x de la position du monstre
     * @return int
     */
    
    /**
     * getposY renvoie la coordonnée y de la position du monstre
     * @return int
     */
        
    /**
     * setptVie change le nombre de point de vie du monstre
     * @param ptVie 
     */ 
    
    /**
     * setdetAtt change les dégats d'attaque du monstre
     * @param dAtt 
     */ 
    
    /**
     * setptPar change le nombre de point de parade du monstre
     * @param ptP 
     */
    
    /**
     * setpageAtt change la valeur de pageAtt du monstre
     * @param pageA 
     */
    
    /**
     * setpagePar change la valeur de pagePar du monstre
     * @param pageP 
     */
    
    /**
     * setpos change les coordonnées x et y du monstre
     * @param x
     * @param y 
     */
    
    /**
     * la preimère méthode deplace fait bouger de manière aléatoire le monstre
     */
    
    /**
     * la deuxième méthode déplace fait bouger le perosnnage d'une valeur précise x et y
     * @param x
     * @param y 
     */
    
    /**
     * la méthode affiche permet d'afficher toutes les valeurs du monstre
     */
    
    public void affiche(){
        System.out.println("Votre monstre a point de vie: "
                +this.getptVie()+" dégat d'attaque: "
                +this.getdegAtt()+" point de Par: "
                +this.getptPar()+" pageAtt: "
                +this.getpageAtt()+" pagePar: "
                +this.getpagePar()+" et de position: ["
                + this.getposX()+";"+this.getposY()+"]");
    }
    
}

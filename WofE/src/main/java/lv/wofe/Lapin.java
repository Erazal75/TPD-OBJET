/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail & victorsimon
 */
public class Lapin extends Monstre{
    
    /**
     * Premier constructeur de Lapin
     * 
     * @param pV est le nombre de point de vie du Lapin
     * @param dA est le nombre de dégât d'attaque du Lapin
     * @param ptPar est le nombre de dégat que le Lapin pare a chaque parade réussie
     * @param paAtt est le pourcentage de chance qu'une attaque du Lapin soit réussie
     * @param paPar est le pourcentage de chance qu'une parade du Lapin soit réussie
     * @param p est la position du Lapin
     */
    
    public Lapin(int pV,int dA,int ptPar,int paAtt,int paPar,Point2D p){
        super(pV,dA,ptPar,paAtt,paPar,p);
    }
    
    /**
     * Deuxième constructeur de Lapin
     * @param l est un autre Lapin, à partir de laquel notre Lapin sera créé
     */
    
    public Lapin(Lapin l){
        super(l);
    }
    
    /**
     * Troisème contructeur de Lapin, permet d'initialiser tous les attributs avec leur valeur par défaut.
     */
    
    public Lapin(){
        super();
    }
    
}

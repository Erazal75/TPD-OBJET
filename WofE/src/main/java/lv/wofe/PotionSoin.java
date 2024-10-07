/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail & victorsimon
 */
public class PotionSoin extends Nourriture {
    
    /**
     * nbPVRendu est le nombre de point de vie que la PotionSoin peut rendre à une Creature
     */
    private int nbPVRendu;
    
    /**
     * Premier constructeur de PotionSoin
     * 
     * @param nbPVRendu est le nombre de point de vie que la PotionSoin peut rendre à une Creature
     * @param place est le nombre de place que l'objet occupe dans l'inventaire d'un Personnage
     * @param prix est la quantité d'argent que vaut l'Objet
     * @param p est la position de l'Objet
     */
    
    public PotionSoin(int nbPVRendu, int place,int prix,Point2D p){
        super(0);
        this.nbPVRendu = nbPVRendu;
    }
    
    /**
     * Deuxième constructeur d'Objet, permet d'initialiser tous les attributs avec leur valeur par défaut.
     */
    
    public PotionSoin(){
        super();
        nbPVRendu = 0;
    }
    
    /**
     * activation permet d'activer la PotionSoin sur la Creature c.
     * la potion permet de rendre nbPVRendu aux points de vie de la Creature c
     * @param c est la Creature sur laquelle la PotionSoin sera activée
     */
    
    
    @Override
    public void activation(Creature c) {
        c.setptVie(c.getptVie() + nbPVRendu);
        System.out.println("Vous avez regagné des points de vie");
    }
    
    
    public int getnbPVRendu(){
        return nbPVRendu;
    }
    
    public void setnbPVRendu(int nb){
        nbPVRendu = nb;
    }
}

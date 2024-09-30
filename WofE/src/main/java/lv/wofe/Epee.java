/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail & victorsimon
 * 
 */
public class Epee extends Objet {
    
    /**
     * nbMain est le nombre de Main nécessaire pour manier l'Epee
     * degAtt est le bonus de dégât d'attaque engendré par l'Epee
     */
    private int nbMain;
    private int degAtt;
    
    /**
     * Premier constructeur d'Epee
     * 
     * @param nbMain est le nombre de Main nécessaire pour manier l'Epee
     * @param degAtt est le bonus de dégât d'attaque engendré par l'Epee
     * @param place est le nombre de place que l'objet occupe dans l'inventaire d'un Personnage
     * @param prix est la quantité d'argent que vaut l'Epee
     * @param p est la position de l'Epee
     */
    
    public Epee(int nbMain, int degAtt, int place,int prix, Point2D p){
        super(place,prix, p);
        this.nbMain = nbMain;
        this.degAtt = degAtt;
    }
    
    /**
     * Deuxième constructeur d'Epee
     * @param e est une autre Epee, à partir de laquel notre Epee sera créée
     */
    
    public Epee(Epee e){
        super();
        this.nbMain = e.getPlace();
        this.degAtt = e.getdegAtt();
    }
    
    /**
     * Troisème contructeur d'Epee, permet d'initialiser tous les attributs avec leur valeur par défaut.
     */
    
    public Epee(){
        super();
        nbMain = 0;
        degAtt = 0;
    }
    
    public int getnbMain(){
        return nbMain;
    }
    
    public int getdegAtt(){
        return degAtt;
    }
    
    public void setnbMain(int nbMain){
        this.nbMain = nbMain;
    }
    public void setdegAtt(int degAtt){
        this.degAtt = degAtt;
    }
    
    /**
     * activation permet d'activer l'Epee sur la Creature c.
     * l'Epee vient augmenter de degAtt les dégâts d'attaque de la Creature c
     * et nécessite une taille d'inventaire suffisante
     * @param c est la Creature sur laquelle l'Epee sera activée
     */
    
    @Override
    public void activation(Creature c) {
        System.out.println("L'épée est activée, elle augmente votre force.");
    }
}

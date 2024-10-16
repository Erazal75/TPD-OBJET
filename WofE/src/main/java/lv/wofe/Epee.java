/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail victorsimon
 * 
 */
public class Epee extends Objet implements Utilisable {
    
    /**
     * nbMain est le nombre de Main nécessaire pour manier l'Epee
     * degAtt est le bonus de dégât d'attaque engendré par l'Epee
     */
    private int nbMain;
    private int degAtt;
    private int utilRestantes = -10;
    
    /**
     * Premier constructeur d'Epee
     * 
     * @param nbmain
     * @param degEpee est le bonus de dégât d'attaque engendré par l'Epee
     * @param placeEpee place prise par l'epee
     * @param prix pric de l'epee
     * @param p est la position de l'Epee
     * @param jeu
     */
    
    public Epee(int nbmain,int degEpee, int placeEpee,int prix, Point2D p,World jeu){
        super(placeEpee,prix, p,jeu);
        this.nbMain = nbmain;
        this.degAtt = degEpee;
    }
    
    /**
     * crée une épee
     * @param degAtt 
     * @param jeu 
     */
    
    public Epee(int degAtt,World jeu){
        super(jeu);
        this.nbMain = 0;
        this.degAtt = degAtt;
    }
    
    /**
     * Deuxième constructeur d'Epee
     * @param e est une autre Epee, à partir de laquel notre Epee sera créée
     */
    
    public Epee(Epee e){
        super(e);
        this.nbMain = e.getPlace();
        this.degAtt = e.getdegAtt();
    }
    
    /**
     * Troisème contructeur d'Epee, permet d'initialiser tous les attributs avec leur valeur par défaut.
     * @param jeu
     */
    
    public Epee(World jeu){
        super(jeu);
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
      
    }
    
    @Override
    public int getutilRestantes(){
        return(this.utilRestantes);
    }
    
    @Override
    public void setutilRestantes(int x){
        this.utilRestantes = x;
    }
}

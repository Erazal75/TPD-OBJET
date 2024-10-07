/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

import java.util.Random;

/**
 *
 * @author lazareGrail & victorSimon
 */
public class NuageToxique extends Objet implements Deplacable {
    
    /**
     * degAtt est le nombre de dégats qu'inflige le NuageToxique
     * vitesse est la vitesse de déplacement du NuageToxique
     * pos est la position du NuageToxique
     */
     
    private int degAtt;
    private int vitesse; 
    private Point2D pos;
    
    /**
     * Premier constructeur d'Epee
     * 
     * @param degAtt est le nombre de dégats qu'inflige le NuageToxique
     * @param vitesse est la vitesse de déplacement du NuageToxique
     * @param pos est la position du NuageToxique
     */
    
    public NuageToxique(int degAtt, int vitesse, Point2D pos,World jeu){
        super(0, 0, pos,jeu);
        this.degAtt = degAtt;
        this.vitesse = vitesse;    
    }
    
    /**
     * Deuxième constructeur de NuageToxique
     * @param n est un autre NuageToxique, à partir de laquel notre NuageToxique sera créé
     */
    
    public NuageToxique(NuageToxique n){
        super(n);
        this.degAtt = n.degAtt;
        this.vitesse = n.vitesse;
    }
    
    /**
     * Troisème contructeur de NuageToxique, permet d'initialiser tous les attributs avec leur valeur par défaut.
     */
    
    public NuageToxique(World jeu){
        super(jeu);
        degAtt = 0;
        vitesse = 0;
    }
    
    @Override
    public void activation(Creature c) {
        c.setptVie(c.getptVie() - this.degAtt);
        System.out.println("Le Nuage Toxique blesse");
    }
    
    /**
     * déplace le nuage toxic en position x y
     * @param x
     * @param y 
     */
    
    @Override
    public void deplace(int x , int y){
        if (this.getjeu().getmatrice(x,y) != 1 && this.getjeu().getmatrice(x,y) != 2){
            this.setpos(x, y);
        } 
    }
    
    /**
     * deplace permet d'attribuer des valeurs de coordonnées aléatoires à la Creature
     */
    
    @Override
    public void deplace(){
        Random genAlé = new Random();
        int x = genAlé.nextInt(21)-10;
        int y = genAlé.nextInt(21)-10;
        deplace(x,y);
    }
}
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
    
    /**
     * active le nuage toxique et enleve des points de vie a la personne qui se situe sur la même case
     * @param c 
     */
    
    @Override
    public void activation(Creature c) {
        c.setptVie(c.getptVie() - this.degAtt);
        System.out.println("Le Nuage Toxique blesse");
    }
    
    /**
     * deplace permet de déplacer la Creature aux coordonnées (x,y) désirées.
     * Simultanément, nous vérifions que lors du déplacement : 
     * 1) la Creature se déplace sur un Objet, si c'est le cas, l'Objet s'active
     * 2) la Creature ne se déplace pas sur une case déjà occuppée par une autre Creature
     * @param x est l'abscisse des coordonnées
     * @param y est l'ordonnée des coordonéees 
     */
    
    @Override
    public void deplace(int x , int y){
        if (x >= 0 && x < this.getjeu().getTaille() && y >=0 && y < this.getjeu().getTaille()) {
            int c = this.getjeu().getmap(x,y); // la valeur de la case d'arrivée
            if ( c < 1000){ // accès à la case autorisé
                this.setpos(x, y);
            }
        }    
        else {
            deplace();
        }
    }
    
    /**
     * deplace permet d'attribuer des valeurs de coordonnées aléatoires à la Creature
     */
    
    @Override
    public void deplace(){
        Random genAlé = new Random();
        int rand = genAlé.nextInt(4);
        int x = getposX();
        int y = getposY();
        switch (rand) {
            case 0:
                deplace(x+1,y);
                break;
            case 1:
                deplace(x-1,y);
                break;
            case 2:
                deplace(x,y+1);
                break;
            case 3:
                deplace(x,y-1);
                break;
            default:
                break;
        }
    }
}

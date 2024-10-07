/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail & victorsimon
 */

import java.util.*;

public abstract class Creature extends ElementDeJeu implements Deplacable{
    
    /**
     * ptVie est le nombre de point de vie de la Creature
     * degAtt est le nombre de dégats qu'inflige la Creature
     * ptPar est le nombre de dégat que la Creature pare a chaque parade réussie
     * pageAtt est le pourcentage de chance qu'une attaque de la Creature soit réussie
     * pagePar est le pourcentage de chance qu'une parade de la Creature soit réussie
     * pos est la position de la Creature
     * effets est une Collection d'Utilisable contenant les différents effets actifs sur le joueur pendant le tour
     */
     
    
    private int ptVie ; 
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;
    private List<Utilisable> effets;
    
    /**
     * Premier constructeur de Creature
     * @param ptVie est le nombre de point de vie de la Creature
     * @param dAtt est le nombre de dégats qu'inflige la Creature
     * @param ptP est le nombre de dégat que la Creature pare a chaque parade réussie
     * @param pageA est le pourcentage de chance qu'une attaque de la Creature soit réussie
     * @param pageP est le pourcentage de chance qu'une parade de la Creature soit réussie
     * @param p est la position de la Creature
     * @param effets est une Collection d'Utilisable contenant les différents effets actifs sur le joueur pendant le tour
     */
    
    public Creature(int ptVie,int dAtt, int ptP,int pageA, int pageP,Point2D p, List<Utilisable> effets){ 
        super(p);
        this.ptVie = ptVie; 
        degAtt = dAtt;
        ptPar = ptP;
        pageAtt = pageA;
        pagePar = pageP;
        this.effets = effets;
    }
    
    /**
     * Deuxième constructeur de Creature
     * @param c est une autre Creature, à partir de laquel notre Creature sera créée
     */
    
    public Creature(Creature c){
        ptVie = c.ptVie;
        degAtt = c.degAtt;
        ptPar = c.ptPar;
        pageAtt = c.pageAtt;
        pagePar = c.pagePar;
        pos = new Point2D(c.pos);
        effets = c.effets;
    }
    
    /**
     * Troisème contructeur de Creature, permet d'initialiser tous les attributs avec leur valeur par défaut.
     */
    
    public Creature(){
        this(0,0,0,0,0,new Point2D(), new ArrayList<Utilisable>());
    }
    
    /**
     * getptVie renvoie le nombre de point de vie de la Creature
     * @return ptVie est le nombre de point de vie de la Creature 
     */
    
    
    public int getptVie(){
        return ptVie;
    }
    
    /**
     * getdegAtt renvoie le nombre de dégat d'attaque du personnage
     * @return degAtt est le nombre de dégats qu'inflige la Creature
     */

    public int getdegAtt(){
        return degAtt;
    } 
    
    /**
     * getptPar renvoie le nombre de dégat que la Creature pare a chaque parade réussie
     * @return ptPar est le nombre de dégat que la Creature pare a chaque parade réussie
     */
    
    public int getptPar(){
        return ptPar;
    }
    
    /**
     * getpageAttt renvoie le pourcentage de chance qu'une attaque de la Creature soit réussie
     * @return pageAtt est le pourcentage de chance qu'une attaque de la Creature soit réussie
     */
    
    public int getpageAtt(){
        return pageAtt;
    }
    
    /**
     * getpagePar renvoie le pourcentage de chance qu'une parade de la Creature soit réussie
     * @return pagePar est le pourcentage de chance qu'une parade de la Creature soit réussie
     */
    
    public int getpagePar(){
        return pagePar;
    }
    
    /**
     * getposX renvoie l'abscisse de la Creature.
     * @return
     */
    
    public int getposX(){
        return pos.getX();
    }
    
    /**
     * getposY renvoie l'ordonnée de la Creature.
     * @return
     */
    
    public int getposY(){
        return pos.getY();
    }
    
    /**
     * setptVie permet d'attribuer la valeur ptVie aux point de Vie ptVie de la Creature
     * @param ptVie est un nombre de point de vie
     */
        
    public void setptVie(int ptVie){
        this.ptVie = ptVie;
    } 
    
    /**
     * setdegAtt permet d'attribuer la valeur dAtt aux dégât d'attaque degAtt de la Creature
     * @param dAtt est le nombre de dégats qu'inflige la Creature
     */
    
    public void setdegAtt(int dAtt){
        degAtt = dAtt;
    } 
    
    /**
     * setptPar permet d'attribuer la valeur ptP aux dégât parés ptPar de la Creature
     * @param ptP est le nombre de dégat que la Creature pare a chaque parade réussie
     */
    
    public void setptPar(int ptP){
        ptPar = ptP;
    }
    
    /**
     * setpageAtt permet d'attribuer la valeur pageA aux pourcentages d'attaque réussie pageAtt de la Creature
     * @param pageA est le pourcentage de chance qu'une attaque de la Creature soit réussie
     */
    
    public void setpageAtt(int pageA){
        pageAtt = pageA;
    }
    
    /**
     * setpagePar permet d'attribuer la valeur pageP aux pourcentages de parade réussie pagePar de la Creature
     * @param pageP est le pourcentage de chance qu'une parade de la Creature soit réussie
     */
    
    public void setpagePar(int pageP){
        pagePar = pageP;
    }
    
    /**
     * setpos permet d'attribuer la valeur (x,y) à la position pos de la Creature
     * @param x est l'abscisse des coordonnées
     * @param y est l'ordonnée des coordonéees
     */
    
    @Override
    public void setpos(int x, int y){
        pos.setPosition(x,y);
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
        boolean noOneThere = false;
        int compteur = 0;
        while (!noOneThere){
            for(ElementDeJeu e : World.gettableauElement()){
                if (!(this.equals(e)) ){
                    if (x == e.getposX() && y == e.getposY()){
                        break;
                    }
                    else{
                        compteur = compteur + 1;
                        }
                    if (compteur == World.gettableauElement().size()-1) {
                        noOneThere = true;
                    }
                }
            }
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
    
    /**
     * distance permet de calculer la distance entre deux Creatures
     * @param c est la Creature avec laquelle nous calculons la distance
     * @return 
     */
    
    public float distance (Creature c){
        return this.pos.distance(c.pos);
    }
    
    /**
     * coincide permet de vérifier si deux Creatures sont sur la même case
     * c'est-à-dire si elle possède les mêmes coordonnées
     * @param c est la Creature avec laquelle nous vérifions la position
     * @return reponse est un booléen traduissant si oui ou non les Creatures sont sur la même case
     */
    
    public boolean coincide(Creature c){
        boolean reponse = (this.getposX()== c.getposX() && this.getposY()== c.getposY());
        return(reponse);
    }
    
    public void affichePos(){
        System.out.println("Votre créature est un: "+this.getClass()+" et est en position: ["+ this.getposX()+";"+this.getposY()+"]");
    }
    
    public abstract void affiche();
    
}


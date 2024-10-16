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
    private List<Utilisable> effets;
    
    /**
     * Premier constructeur de Creature
     * @param ptVie est le nombre de point de vie de la Creature
     * @param dAtt est le nombre de dégats qu'inflige la Creature
     * @param ptP est le nombre de dégat que la Creature pare a chaque parade réussie
     * @param pageA est le pourcentage de chance qu'une attaque de la Creature soit réussie
     * @param pageP est le pourcentage de chance qu'une parade de la Creature soit réussie
     * @param p est la position de la Creature
     * @param jeu
     * @param effets est une Collection List de Utilisable contenant les effets appliqués aux joueurs pendant le tour
     */
    
    public Creature(int ptVie,int dAtt, int ptP,int pageA, int pageP,Point2D p,World jeu, List<Utilisable> effets){ 
        super(p,jeu);
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
        super(c);
        ptVie = c.ptVie;
        degAtt = c.degAtt;
        ptPar = c.ptPar;
        pageAtt = c.pageAtt;
        pagePar = c.pagePar;
        effets = c.effets;
    }
    
    /**
     * Troisème contructeur de Creature, permet d'initialiser tous les attributs avec leur valeur par défaut.
     * @param jeu
     */
    
    public Creature(World jeu){
        this(0,0,0,0,0,new Point2D(),jeu, new ArrayList<>());
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
            if ( c >= 1000 || c <= 0){ // accès à la case autorisé
                this.setpos(x, y);
                if (c >= 1000 && c < 2000) { // il y a un objet à activer sur la case
                    Utilisable o = (Utilisable) this.getjeu().getdico().get(c);
                    o.activation(this); 
                    this.effets.add(o);
                }
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
    
    public List<Utilisable> getEffets(){
        return(this.effets);
    }
       
}


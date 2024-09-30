/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail
 */


public class Personnage extends Creature{
    
    /**
     * nom est la nom du personnage
     * ptVie est son nombre de point de vie
     * degAtt est les dégats qu'il inflige
     * ptPar est le point de dégat qu'il pare a chaque attaque
     * 
     * 
     * distAttMax est la distance maximum à laquel il peut attaquer
     * pos est la position personnage
     */
    
    private String nom ;
    private int distAttMax;
    private int inventaire;
    private int argent;

    /**
     * Permier constructeur de personnage
     * 
     * @param nom le nom du personnage
     * @param ptVie son nombre de point de vie
     * @param dAtt ses dégats d'attaque
     * @param ptP ses point de parade
     * @param pageA 
     * @param pageP
     * @param distAttM la distance maximum à laquel il peut attaquer
     * @param p sa position sur la carte
     */
    
    public Personnage(String nom,int ptVie,int dAtt, int ptP,int pageA, int pageP, int distAttM,Point2D p,int argent,int inventaire){
        super(ptVie,dAtt,ptP,pageA,pageP,p);
        this.nom = nom;
        distAttMax = distAttM;
        this.argent = argent;
        this.inventaire = inventaire;
    }
    
    /**
     * deuxième contruscteur de personnage
     * 
     * @param p recopie un autre personnage
     */
    
    public Personnage(Personnage p){
        super(p);
        this.nom = p.nom;
        this.distAttMax = p.distAttMax;
        this.argent = p.argent;
        this.inventaire = p.inventaire ;
    }

    /**
     * Troisème contructeur personnage qui met 0 à toutes les attributs
     */
    
    public Personnage(){
        this.nom = "";
        distAttMax = 0;
        this.argent = 0;
        this.inventaire = 0;
    }
    
    /**
     * La méthode renconter affiche 2 lignes de texte avec enchanetr et les noms des 2 personnages
     * @param p 
     */
    
    public void rencontrer(Personnage p){
       
        System.out.println("Enchanter "+ p.nom);
        System.out.println("Enchanter de même "+this.nom);
    }
    
    /**
     * getNom renvoie le nom du personnage
     * @return String 
     */
    
    public String getNom(){
        return nom;
    } 
    
    public int getArgent(){
        return argent;
    }
    
    public int getInventaire(){
        return inventaire;
    }
    /**
     * getptVie renvoie le nombre de point de vie du presonnage
     * @return int 
     */
    
    
    /**
     * getdegAtt renvoie le nombre de dégat d'attaque du personnage
     * @return int
     */
    
    /**
     * getptPar renvoie le nombre de point de parade du personnage
     * @return int
     */
    
    /**
     * getpageAttt renvoie le pageAtt du personnage
     * @return int
     */
    
    /**
     * getpagePar renvoie le pagePar ud perosnnage
     * @return int 
     */
    
    /**
     * getdistMax renvoie la distance maximum à laquel le perosnnage peut attaquer
     * @return int
     */
    
    public int getdistM(){
        return distAttMax;
    }
    
    /**
     * getposX renvoie la coordonnée x de la position du personnage
     * @return int
     */
    
    
    /**
     * getposY renvoie la coordonnée y de la position du personnage
     * @return int
     */
    
    
    /**
     * setNom change le nom du personnage
     * @param nom String le nouveau nom du personnage
     */
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public void setArgent(int argen){
        argent = argen;
    }
    
    public void setInventaire(int invent){
        inventaire = invent;
    }
    
    
    /**
     * setptVie change le nombre de point de vie du personnage
     * @param ptVie 
     */
    
    /**
     * setdetAtt change les dégats d'attaque du personnage
     * @param dAtt 
     */
    
    /**
     * setptPar change le nombre de point de parade du personnage
     * @param ptP 
     */
   
    
    /**
     * setpageAtt change la valeur de pageAtt du personnage
     * @param pageA 
     */
    
    /**
     * setpagePar change la valeur de pagePar du personnage
     * @param pageP 
     */
    
    /**
     * setdistMax change la distance maximale à laquel le personnage peut attaquer
     * @param distM 
     */
    
    public void setdistM(int distM){
        distAttMax = distM;
    }
    
    /**
     * setpos change les coordonnées x et y du personnage
     * @param x
     * @param y 
     */
    
    /**
     * la preimère méthode deplace fait bouger de manière aléatoire le personnage
     */
    
    
    /**
     * la deuxième méthode déplace fait bouger le perosnnage d'une valeur précise x et y
     * @param x
     * @param y 
     */
    
    
    /**
     * la méthode affiche permet d'afficher toutes les valeurs du personnage
     */
    
    @Override
    public void affiche(){
        System.out.println("Votre personnage est un: "+this.getClass()+
                " il s'appelle : "+nom
                +" point de vie: "+this.getptVie()
                +" dégat d'attaque: "+this.getdegAtt()
                +" point de Par: "+this.getptPar()
                +" pageAtt: "+this.getpageAtt()
                +" pagePar: "+this.getpagePar()
                +" distance maximale d'attaque: "+distAttMax
                +" et de position: ["+ this.getposX()+";"+this.getposY()+"]");
    }
    
}


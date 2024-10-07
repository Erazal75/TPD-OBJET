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


abstract public class Personnage extends Creature{
    
    /**
     * nom est le nom du Personnage
     * distAttMax est la distance maximun à laquelle le Personnage peut attaquer
     * inventaire est la taille maximun de l'inventaire du Personnage
     * argent est la somme d'argent que le Personnage possède
     */
    
    private String nom ;
    private int distAttMax;
    private int argent;

    /**
     * Premier constructeur de Personnage
     * 
     * @param nom est le nom du Personnage
     * @param ptVie est le nombre de point de vie du Personnage
     * @param dAtt est le nombre de dégât d'attaque du Personnage
     * @param ptP est le nombre de dégat que le Personnage pare a chaque parade réussie
     * @param pageA est le pourcentage de chance qu'une attaque du Personnage soit réussie
     * @param pageP est le pourcentage de chance qu'une parade du Personnage soit réussie
     * @param distAttM est la distance maximun à laquelle le Personnage peut attaquer 
     * @param argent est la somme d'argent que le Personnage possède
     */
    
    public Personnage(String nom,int ptVie,int dAtt, int ptP,int pageA, int pageP, int distAttM,Point2D p,int argent,World jeu){
        super(ptVie,dAtt,ptP,pageA,pageP,p,jeu);
        this.nom = nom;
        distAttMax = distAttM;
        this.argent = argent;
    }
    
    /**
     * Deuxième constructeur de Personnage
     * @param p est un autre Personnage, à partir de laquel notre Personnage sera créé
     */
    
    public Personnage(Personnage p){
        super(p);
        this.nom = p.nom;
        this.distAttMax = p.distAttMax;
        this.argent = p.argent;
    }

    /**
     * Troisème contructeur de Personnage, permet d'initialiser tous les attributs avec leur valeur par défaut.
     * @param jeu
     */
    
    public Personnage(World jeu){
        super(jeu);
        this.nom = "";
        distAttMax = 0;
        this.argent = 0;
    }
    
    /**
     * La méthode rencontrer affiche 2 lignes de texte avec le dialogue "Enchanté" et les noms des 2 personnages
     * @param p 
     */
    
    public void rencontrer(Personnage p){
       
        System.out.println("Enchanté "+ p.nom);
        System.out.println("Enchanté de même "+this.nom);
    }
    
    public String getNom(){
        return nom;
    } 
    
    public int getArgent(){
        return argent;
    }
    
    public int getdistM(){
        return distAttMax;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public void setArgent(int argen){
        argent = argen;
    }
    
    public void setdistM(int distM){
        distAttMax = distM;
    }
    
    /** 
     * affiche permet d'afficher les informations du Personnage.
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
    
    /** 
     * affichePos permet d'afficher la position du Personnage.
     */
    
    @Override
    public void affichePos(){
        System.out.println("Votre personnage est en position: ["+ this.getposX()+";"+this.getposY()+"]");
    }
    
    public abstract void combattre(Creature c);
        
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail
 */
public class Objet {
    
    private int place;
    private int prix;
    
    public Objet(int place,int prix ){
        this.place = place;
        this.prix = prix;
    }
    
    public Objet(Objet o){
        this.place = o.place;
        this.prix = o.prix;
    }
    
    public Objet(){
        this.place = 0;
        this.prix = 0;
    }
    
    public int getPlace(){
        return place;
    }
    
    public void setPalce(int place){
        this.place = place;
    }
    
    public int getPrix(){
        return prix;
    }
    
    public void setPrix(int pris){
        prix = pris;
    }
}

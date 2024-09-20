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
    
    public Objet(int place){
        this.place = place;
    }
    
    public Objet(){
        this.place = 0;
    }
    
    public int getPlace(){
        return place;
    }
    
    public void setPalce(int place){
        this.place = place;
    }
}

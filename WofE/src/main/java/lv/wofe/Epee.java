/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail
 */
public class Epee extends Objet {
    
    private int nbMain;
    private int degAtt;
    
    public Epee(int nbMain, int degAtt, int place,int prix, Point2D p){
        super(place,prix, p);
        this.nbMain = nbMain;
        this.degAtt = degAtt;
    }
    
    public Epee(Epee e){
        super();
        this.nbMain = e.getPlace();
        this.degAtt = e.getdegAtt();
    }
    
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
    
    @Override
    public void activation(Creature c) {
        System.out.println("L'épée est activée, elle augmente votre force.");
    }
}

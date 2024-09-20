/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package lv.wofe;

/**
 *
 * @author lazaregrail
 */
public class Point2D {

    private int x ;
    private int y ; 
    
    public  Point2D(int x,int y) {
       this.x=x;
       this.y=y;
    }
      
    public Point2D(){
        x=0;
        y=0;
    }
    
    public Point2D(Point2D v){
        x=v.x;
        y=v.y;
    }
      
    public void setX(int x){
        this.x=x;
    }
    
    public int getX(){
        return x;
    }
    
    public void setY(int y){
        this.y=y;
    }
    
    public int getY(){
        return y;
    }
    
    public void setPosition(int x, int y){
        this.x=x;
        this.y=y;
    }
            
    public void translate(int x, int y){
        this.x = this.x + x;
        this.y = this.y + y;
    }
    
    public void affiche(){
        System.out.println("[ "+x+" ; "+y+" ]");
    }
    
    public float distance (Point2D p){
        return (float) (Math.sqrt( (p.x - this.x)*(p.x - this.x) + (p.y - this.y)*(p.y - this.y) ));
    }
}

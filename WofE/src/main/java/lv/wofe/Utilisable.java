/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail victorsimon
 */
public interface Utilisable {
    
    /**
     * Permet à l'Objet de s'activer sur une Creature
     * @param c est la Creature sur laquelle l'Objet s'active
     */
    
    void activation(Creature c);
    
    /**
     * renvoie l e nombre de tour restant pour l'utilisable
     * @return int
     */
    
    int getutilRestantes();
    
    void setutilRestantes(int x);

}

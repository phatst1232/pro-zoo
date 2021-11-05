/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalpkg;

/**
 *
 * @author phats
 */
public class BFA extends Animal {
    public boolean heroic;

    public BFA(String ID, String color, String name, AnimalType type, double weight,boolean heroic) {
        super(ID, color, name, type, weight);
        this.heroic=heroic;
    }

    @Override
    public String toString() {
        return "BFA{" +super.toString()+ "\nheroic=" + heroic + "}\n";
    }

    @Override
    public String strToFile() {
        return super.strToFile()+";"+heroic; 
    }
    
    
}

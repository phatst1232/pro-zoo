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
public class FLA extends Animal{
    public boolean canGrowl;
    public boolean danger;

    public FLA(String ID, String color, String name, AnimalType type, double weight,boolean canGrowl,boolean danger) {
        super(ID, color, name, type, weight);
        this.canGrowl=canGrowl;
        this.danger=danger;
    }

    @Override
    public String toString() {
        return "FLA{" +super.toString()+ "\n canGrowl=" + canGrowl + ", danger=" + danger + "}\n";
    }

    @Override
    public String strToFile() {
        return super.strToFile()+";"+canGrowl+";"+danger; 
    }
    
    
}

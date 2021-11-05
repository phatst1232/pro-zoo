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
public class ZLA extends Animal{
    public boolean poisonous;

    public ZLA(String ID, String color, String name, AnimalType type, double weight, boolean poisonous) {
        super(ID, color, name, type, weight);
        this.poisonous=poisonous;
    }

    @Override
    public String toString() {
        return "ZLA{" +super.toString()+ "\n poisonous=" + poisonous + "}\n";
    }

    @Override
    public String strToFile() {
        return super.strToFile() + ";" +poisonous; 
    }
}

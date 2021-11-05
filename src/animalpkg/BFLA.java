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
public class BFLA extends Animal{
    public boolean cute;

    public BFLA(String ID, String color, String name, AnimalType type, double weight,boolean cute) {
        super(ID, color, name, type, weight);
        this.cute=cute;
    }

    @Override
    public String toString() {
        return "BFLA{" +super.toString()+ "\ncute=" + cute + "}\n";
    }

    @Override
    public String strToFile() {
        return super.strToFile() + ";" + cute; 
    }
    
    
    
    
}

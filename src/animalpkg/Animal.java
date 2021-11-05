/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalpkg;

import com.sun.corba.se.spi.activation._ActivatorImplBase;

/**
 *
 * @author phats
 */
public class Animal implements Comparable<Animal> {
    public String ID;
    public String color;
    public String name;
    public AnimalType type;
    public double weight;

    public Animal(String ID, String color, String name, AnimalType type, double weight) {
        this.ID = ID;
        this.color = color;
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    @Override
    public int compareTo(Animal o) {
        int d= this.type.typeCode-o.type.typeCode;
        return d<0?-1 : d==0?0:1;
    }

    @Override
    public String toString() {
        return "Animal{" + "ID=" + ID + ", color=" + color + ", name=" + name + ", type=" + type + ", weight=" + weight + '}';
    }
    
    public String strToFile(){
        return ID + ";" +name+ ";" +type.typeCode+ ";" +color+ ";" +weight;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalpkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author phats
 */
public class AnimalList extends ArrayList<Animal>{
    public AnimalTypeList typelist;

    public AnimalList(AnimalTypeList typelist) {
        super();
        this.typelist = typelist;
    }
    
    public int search(String ID){
        ID=ID.trim().toUpperCase();
        for(int i=0;i<this.size();i++)
            if(ID.equalsIgnoreCase(this.get(i).ID))
                return i;
        return -1;
    }
    
    public boolean loadFromFile(String fName){
        FileReader fr=null;
        BufferedReader br=null;
        String line=null;
        StringTokenizer stk=null;
        try{
            fr=new FileReader(fName);
            br=new BufferedReader(fr);
            while((line=br.readLine())!=null){
                line=line.trim();
                if(line.length()>0){
                    stk=new StringTokenizer(line,";");
                    String ID=stk.nextToken().trim();
                    String name=stk.nextToken().trim();
                    int type=Integer.parseInt(stk.nextToken().trim());
                    AnimalType aType=this.typelist.get(typelist.search(type));
                    if(aType==null){
                        System.out.println("This animal type is not supported!");
                        System.exit(0);
                    }
                    String color=stk.nextToken().trim();
                    double weight=Double.parseDouble(stk.nextToken().trim());
                    String S;
                    Animal animal;
                    switch(type){
                        case 1: S=stk.nextToken().trim().toUpperCase();
                                boolean poisonous=S.startsWith("T");
                                animal=new ZLA(ID, color, name, aType, weight, poisonous);
                                this.add(animal);
                                break;
                        case 2: S=stk.nextToken().trim().toUpperCase();
                                boolean cute=S.startsWith("T");
                                animal=new BFLA(ID, color, name, aType, weight, cute);
                                this.add(animal);
                                break;
                        case 3: S=stk.nextToken().trim().toUpperCase();
                                boolean heroic=S.startsWith("T");
                                animal= new BFA(ID, color, name, aType, weight, heroic);
                                this.add(animal);
                                break;
                        case 4: S=stk.nextToken().trim().toUpperCase();
                                boolean canGrowl=S.startsWith("T");
                                S=stk.nextToken().trim().toUpperCase();
                                boolean danger=S.startsWith("T");
                                animal=new FLA(ID, color, name, aType, weight, canGrowl, danger);
                                this.add(animal);
                                break;
                    }
                }
            }
            br.close();
            fr.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
    
    public boolean writeToFile(String fName){
        FileWriter fw=null;
        PrintWriter pw=null;
        try{
            fw=new FileWriter(fName);
            pw=new PrintWriter(fw);
            for(int i=0;i<this.size();i++)
                pw.println(this.get(i).strToFile());
            pw.flush();
            System.out.println("Writing File: Done.");
            pw.close();
            fw.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return true;
    }
    
    public void add(){
        String ID;
        String name;
        AnimalType type=null;
        String color;
        double weight;
        boolean duplicated;
        do{
            ID=MyScanner.getNonBlankStr("Input it's ID:");
            ID=ID.trim().toUpperCase();
            duplicated=(this.search(ID)>=0);
            if(duplicated)  System.out.println("ID is duplicated");
        }while(duplicated);
        name=MyScanner.getNonBlankStr("Input it's Name:");
        type=this.typelist.chooseType();
        color=MyScanner.getNonBlankStr("Input it's color:");
        weight=MyScanner.getDouble("Input it's weight: ",0,type.getMaxWeight());
        Animal newAnimal=null;
        int intType=type.typeCode;
        switch(intType){
            case AnimalType.ZLA:
                boolean poison=MyScanner.getBoolean("Is it poisonous? ");
                newAnimal=new ZLA(ID, color, name, type, weight, poison);
                break;
            case AnimalType.BFLA:
                boolean cute=MyScanner.getBoolean("Is it cute? ");
                newAnimal=new BFLA(ID, color, name, type, weight, cute);
                break;
            case AnimalType.BFA:
                boolean heroic=MyScanner.getBoolean("Is it heroic? ");
                newAnimal=new BFA(ID, color, name, type, weight, heroic);
                break;
            case AnimalType.FLA:
                boolean canGrowl=MyScanner.getBoolean("Can it growl? ");
                boolean danger=MyScanner.getBoolean("Is it danger? ");
                newAnimal=new FLA(ID, color, name, type, weight, canGrowl, danger);
                break;
            default: System.out.println("This animal type is not supported!");
        }
        if(newAnimal!=null){
            this.add(newAnimal);
            System.out.println("Add operation is successful. ");
        }
    }
    
    public void update(){
        String ID;
        ID=MyScanner.getNonBlankStr("Input It's ID: ");
        int pos=this.search(ID);
        if(pos<0)
            System.out.println("Animal "+ID+" does not exist!");
        else{
            this.remove(pos);
            System.out.println("Input new animal's detail: ");
            this.add();
        }
    }
    
    public void delete(){
        String ID;
        ID=MyScanner.getNonBlankStr("Input It's ID: ");
        int pos=this.search(ID);
        if(pos<0)
            System.out.println("Animal "+ID+" does not exist");
        else{
            this.remove(pos);
            System.out.println("Animal "+ID+" has been deleted");
        }
    }
    
    public void printByName(){
        String chosenName;
        chosenName=MyScanner.getNonBlankStr("Input it's Name: ");
        chosenName=chosenName.toUpperCase();
        System.out.println("Result: ");
        int count=0;
        for(Animal a: this)
            if(a.name.toUpperCase().indexOf(chosenName)>=0){
                System.out.println(a);
                count++;
            }
        if(count>0) System.out.println(count+" animals.");
        else System.out.println("No animal has that name.");
    }
    
    public void printByType(){
        int chosenType;
        int maxType=this.typelist.size();
        chosenType=MyScanner.getInt("Input animal type code: ",1,maxType);
        System.out.println("Result: ");
        int count=0;
        for(Animal a:this)
            if(a.type.typeCode==chosenType){
                System.out.println(a);
                count++;
            }
        if(count>0) System.out.println(count+" animals.");
        else System.out.println("No animal belongs to this type.");
    }
    
    public void showAll(){
        if(this.isEmpty())
            System.out.println("The list is empty!");
        else{
            for(Animal a:this)
                System.out.println(a);
            System.out.println("There are "+this.size()+" animals in the list.");
        }
    }
}

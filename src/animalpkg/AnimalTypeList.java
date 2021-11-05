/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalpkg;

import static animalpkg.MyScanner.sc;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author phats
 */
public class AnimalTypeList extends ArrayList<AnimalType> {
        
    public AnimalType chooseType(){
        Menu mnu=this.createMenu();
        return this.get(mnu.getUserChoice()-1);
    }
    
    private Menu createMenu(){
        Menu mnu=new Menu("Choose animal type: ");
        for(int i=0;i<this.size();i++){
            mnu.add(this.get(i).desc);
        }
        return mnu;
    }
    
    public boolean loadFromFile(String filename){
        FileReader fr=null;
        BufferedReader bf=null;
        String line="";
        StringTokenizer stk=null;
        try{
            fr=new FileReader(filename);
            bf=new BufferedReader(fr);
            while((line=bf.readLine())!=null){
                line=line.trim();
                if(line.length()>0 && !line.startsWith("//")){
                    stk=new StringTokenizer(line, ";");
                    int typecode=Integer.parseInt(stk.nextToken().trim());
                    String desc=stk.nextToken().trim();
                    int numLegs=Integer.parseInt(stk.nextToken().trim());
                    int numWings=Integer.parseInt(stk.nextToken().trim());
                    String movingMethod=stk.nextToken().trim();
                    boolean Fly=Boolean.parseBoolean(stk.nextToken().trim());
                    boolean Sing=Boolean.parseBoolean(stk.nextToken().trim());
                    boolean Growl=Boolean.parseBoolean(stk.nextToken().trim());
                    String food=stk.nextToken().trim();
                    double weight=Double.parseDouble(stk.nextToken().trim());
                    AnimalType type=new AnimalType(typecode, desc, numLegs, numWings, movingMethod, Fly, Sing, Growl, food, weight);
                    this.add(type);
                }
            }
            bf.close();
            fr.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    public int search(int typeID){
        if(typeID==this.get(typeID-1).getTypeCode())
            return typeID-1;
        return 0;
    }
}

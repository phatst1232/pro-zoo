/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalpkg;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author phats
 */
public class MyScanner {
    public static Scanner sc=new Scanner(System.in);
    
    public static boolean getBoolean(String message){
        boolean nhaptiep=true;
        String[] T={"T","True","Y","Yes","1"};
        String[] F={"F","False","N","No","0"};
        String tmp;
        boolean result = false;
        do{
            try{
                System.out.println(message);
                tmp=sc.nextLine().trim();
                for(int i=0;i<T.length;i++)
                if(tmp.equalsIgnoreCase("Y") || tmp.equalsIgnoreCase("Yes") || tmp.equalsIgnoreCase("T") || tmp.equalsIgnoreCase("True") || tmp.equalsIgnoreCase("1")){
                    nhaptiep=false;
                    result=true;
                    break;
                }else if(tmp.equalsIgnoreCase("N") || tmp.equalsIgnoreCase("No") || tmp.equalsIgnoreCase("F") || tmp.equalsIgnoreCase("False") || tmp.equalsIgnoreCase("0")){
                    nhaptiep=false;
                    result=false;
                    break;
                }else
                    throw new Exception("Please input again!");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }while(nhaptiep==true);
        return result;
    }
    
    public static double getDouble(String message,double min,double max){
        boolean nhaptiep=true;
        double tmp=0;
        if(min>max){
            tmp=min;
            min=max;
            max=tmp;
        }
        do{
            try{
                System.out.println(message);
                tmp=Double.parseDouble(sc.nextLine().trim());
                if(tmp<min || tmp>max)
                    throw new Exception("Please input between "+min+"and "+max+"!");
                else nhaptiep=false;
            }
            catch(NumberFormatException ex){
                System.out.println("Please input numbers!");
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }while(nhaptiep==true);
        return tmp;
    }
    
    public static double getDouble(String message, double max){
        boolean nhaptiep=true;
        double tmp=0;
        do{
            try{
                System.out.println(message);
                tmp=Double.parseDouble(sc.nextLine().trim());
                if(tmp<0 || tmp>max)
                    throw new Exception("Please input between 0 and "+max+"!");
            }catch(NumberFormatException ex){
                System.out.println("Please input numbers!");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }while(nhaptiep==true);
        return tmp;
    }
    
    public static int getInt(String message, int min, int max){
        boolean nhaptiep=true;
        int tmp=0;
        if(min>max){
            tmp=min;
            min=max;
            max=tmp;
        }
        do{
            try{
                System.out.println(message);
                tmp=Integer.parseInt(sc.nextLine().trim());
                if(tmp<0 || tmp>max)
                    throw new Exception("Please input between "+min+" and "+max+"!");
                else nhaptiep=false;
            }catch(NumberFormatException ex){
                System.out.println("Please input numbers!");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }while(nhaptiep==true);
        return tmp;
    }
    
    public static int getInt(String message, int max){
        boolean nhaptiep=true;
        int tmp=0;
        do{
            try{
                System.out.println(message);
                tmp=Integer.parseInt(sc.nextLine().trim());
                if(tmp<0 || tmp>max)
                    throw new Exception("Please input between 0 and "+max+"!");
            }catch(NumberFormatException ex){
                System.out.println("Please input numbers!");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }while(nhaptiep==true);
        return tmp;
    }
    
    public static String getNonBlankStr(String message){
        boolean nhaptiep=true;
        String tmp="";
        do{
            try{
                System.out.println(message);
                tmp=sc.nextLine().trim();
                nhaptiep=false;
            }catch(NoSuchElementException ex){
                System.out.println("Please input texts");
            }
        }while(nhaptiep==true);
        return tmp;
    }
}

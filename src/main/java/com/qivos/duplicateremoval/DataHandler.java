package com.qivos.duplicateremoval;



import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DataHandler {
    private static int duplicates=0;
    private static int countAttrChanged=0;
    private static int linesProcessed=0;

    public  DataHandler() {
        
    }
    
    

    public int getDuplicates() {
        return duplicates;
    }

    public static void setDuplicates(int d) {
        duplicates = d;
    }

    public static  String[] tokenize(String input){
        String[] tokens=input.split(",");
        return tokens;
    }


    public static Map<String,Customer> importCustomers(String filepath){
        Scanner filein=null;
        Map<String,Customer> temp=new HashMap<>();
       
        
        try{
            filein= new Scanner(new File(filepath));}
        catch(FileNotFoundException e ){
            System.err.println(" File not found!");
        }
        

        
        linesProcessed++;
        while(filein.hasNext()){
            Customer tempCustomer=Customer.parseCustomer(filein.nextLine());
            if(tempCustomer!=null){
                temp.putIfAbsent(tempCustomer.getMobileNumber(),tempCustomer);
                //temp.add(tempCustomer);
                if(temp.containsKey(tempCustomer.getMobileNumber())){
                    if(temp.get(tempCustomer.getMobileNumber()).getEmail().equals(tempCustomer.getEmail()))setDuplicates(duplicates+1);
                    
                    else{
                        temp.replace(tempCustomer.getMobileNumber(),tempCustomer);
                        countAttrChanged++;
                    }
                }
            }else System.err.println("Line :" +linesProcessed);
            linesProcessed++;
           
        }
        return temp;
    }

    public static void exportData(Map<String,Customer> customers,String filename) {
        PrintWriter out=null;
        try{
            out=new PrintWriter(filename);
            for(Map.Entry<String,Customer> c: customers.entrySet()){
                out.println(c.getValue().outString());
            }
        }catch (IOException e){
            System.out.println(e);
        }
        out.flush();
        out.close();
    }
    
    public static void printReport(String filename){
        PrintWriter out=null;
        try{
            out=new PrintWriter(filename);
            out.println("Number of duplicates found :\t"+duplicates+"\n"+
                    "Number of attributes changed :\t"+countAttrChanged+"\n"+
                    "Processed lines :\t"+linesProcessed);
        }catch (IOException e){
            e.printStackTrace();
        }
        
        out.flush();
        out.close();
    }




}

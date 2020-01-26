package com.qivos.duplicateremoval;



import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DataHandler {
    private int duplicates=0;

    public int getDuplicates() {
        return duplicates;
    }

    public void setDuplicates(int duplicates) {
        this.duplicates = duplicates;
    }

    public static  String[] tokenize(String input){
        String[] tokens=input.split(",");
        return tokens;
    }


    public static Map<String,Customer> importCustomers(String filepath){
        Scanner filein=null;
        Map<String,Customer> temp=new HashMap<>();
       
        int exactDuplicates=0;
        try{
            filein= new Scanner(new File(filepath));}
        catch(FileNotFoundException e ){
            System.err.println(" File not found!");
        }
        

        //ToDo Create Unique Code
        int line=1;
        while(filein.hasNext()){
            Customer tempCustomer=Customer.parseCustomer(filein.nextLine());
            if(tempCustomer!=null){
                temp.putIfAbsent(tempCustomer.getMobileNumber(),tempCustomer);
                //temp.add(tempCustomer);
                if(temp.containsKey(tempCustomer.getMobileNumber())){
                    temp.replace(tempCustomer.getMobileNumber(),tempCustomer);
                    exactDuplicates++;
                }
            }else System.err.println("Line :" +line);
            line++;
            //System.out.println(filein.nextLine());
        }
        System.out.println("No. of exact duplicates found : "+ exactDuplicates);
        return temp;
    }

    public static void exportData(ArrayList<Customer> customers,String filename) throws IOException {
        PrintWriter out=new PrintWriter(filename);
        for(Customer c: customers){
            out.println(c.outString());
        }
        out.flush();
        out.close();
    }




}

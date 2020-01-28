package com.qivos.duplicateremoval;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

public class main {

    public static void main(String []args) {
        Map<String,Customer> customersList= DataHandler.importCustomers("Input Data.csv");
        DataHandler dh=new DataHandler();
        dh.exportData(customersList, "Output.csv");
        dh.printReport("Report.txt");
    }
    
    





}

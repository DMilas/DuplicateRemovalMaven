package com.qivos.duplicateremoval;

public class Errors {
    public static void invalidFormatError(){
        System.err.println("Invalid value format found!!!\nPlease check your input file.");
        //System.exit(1);
    }

    public static void attributeSizeError(){
        System.err.println("Too few arguments found!!!\nPlease check your input file for invalid entries.");
        //System.exit(1);
    }
}

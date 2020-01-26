package com.qivos.duplicateremoval;




public class Customer {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;

    public Customer(String firstName, String lastName, String mobileNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public Customer() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", email='" + email + '\'' +
                '}';
    }

    public String outString(){
        return firstName+","+lastName+","+mobileNumber+","+email;
    }

    public static Customer parseCustomer(String input){
        Customer temp=null;
        String[] tokens=DataHandler.tokenize(input);
        if(tokens.length>=4){
            if (validateCustomer(tokens)) {
                temp = new Customer(tokens[0], tokens[1], tokens[2], tokens[3]);
            }
            else Errors.invalidFormatError();

        }
        else Errors.attributeSizeError();



        return temp;
    }

    private static boolean validateCustomer(String[] tokens){
        return (!(tokens[0].equals("")||tokens[0].equals("\\N")||tokens[1].equals("")||tokens[1].equals("\\N")||tokens[2].equals("")||tokens[2].equals("\\N")));
    }



}

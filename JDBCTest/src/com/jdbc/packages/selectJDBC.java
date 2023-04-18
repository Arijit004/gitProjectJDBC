package com.jdbc.packages;

import java.sql.*;
//import java.io.*;

public class selectJDBC {
    public static void main(String[] args){
        try{
            //get connection
            Connection con=ConnectionProvider.getConnection();
             
            //query for selecting all data from table "customer"
            String q="select * from customer";
            
            //create Statement object using createStatement() 
            Statement stmt=con.createStatement();
            
            //get the data after firing query using executeQuery() and this method will return the dataset in a set form
            ResultSet set=stmt.executeQuery(q);
            
            //get the data from the dataset until the end
            while(set.next()){
                //getting all data from "id" column which is 1st column
                int i=set.getInt(1);
                System.out.println("ID: "+i);
                
                //getting all data from "name" column which is the 2nd column
                String n=set.getString(2);
                System.out.println("NAME: "+n);
                
                //getting all data from "city" column which is the 3rd column
                String c=set.getString(3);
                System.out.println("CITY: "+c);
            }
            //closing the connection
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

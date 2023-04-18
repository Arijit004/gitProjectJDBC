package com.jdbc.packages;

import java.io.*;
import java.sql.*;

public class Update {
    public static void main(String[] args){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try{
            //getting connection
            Connection con=ConnectionProvider.getConnection();
              
            //query for update data in "customer" table
            String q="update customer set name=? , city=?, id=?";
            
            //taking new datas
            System.out.println("Enter new name:");
            String n=br.readLine();
            
            System.out.println("Enter new city:");
            String c=br.readLine();
            
            System.out.println("Enter id whose data is to going to update:");
            int i=Integer.parseInt(br.readLine());
            
            //create PreparedStatement object using prepareStatement() and pass the query
            PreparedStatement pstmt=con.prepareStatement(q);
          
            //set the new values
            pstmt.setString(1, n);
            pstmt.setString(2, c);
            pstmt.setInt(3, i);
            
            //update the pstmt and fire the query
            pstmt.executeUpdate();
            
            System.out.println("Update is complete....");
            
            //closing the connection
            con.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }    
}

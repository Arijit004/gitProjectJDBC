package com.jdbc.packages;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


public class StoredProcedureJDBC2 {
    public static void main(String[] args){
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Connection con=null;
        try{
            //get connection
            con=ConnectionProvider.getConnection();
            
            //create query for callable statement to execute stored procedure named "getById()"
            String q2="{call getById(?)}";
            
            //create a callable statement to execute "getAll()"
            CallableStatement call=con.prepareCall(q2);
            
            //insert the parameter value using parameter name
            System.out.println("Enter the ID for which you want to see details:");
            int n=Integer.parseInt(br.readLine());
            call.setInt("f_id", n);
            
            //execute callable statement to get result table
            ResultSet result=call.executeQuery();
            
            //get data from result set/table by sending column name as parameter.. (ex.: result.getInt("ID") where "ID" is column name)
            while(result.next()){
                System.out.print("ID: "+result.getInt("ID")+"    ");
                System.out.print("Name: "+result.getString("NAME")+"    ");
                System.out.println("City: "+result.getString("CITY"));
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }            
}
   
package com.jdbc.packages;

import java.sql.*;
import java.io.*;

public class StoredProcedureJDBC {
    public static void main(String[] args){
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Connection con=null;
        try{
            //get connection
            con=ConnectionProvider.getConnection();
            
            //create query for callable statement to execute stored procedure named "getAll()"
            String q1="{call getAll()}";
            
            //create a callable statement to execute "getAll()"
            CallableStatement call=con.prepareCall(q1);
            
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

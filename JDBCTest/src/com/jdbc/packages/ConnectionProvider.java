package com.jdbc.packages;

import java.sql.*;

public class ConnectionProvider {
    private static Connection con;
    public static Connection getConnection(){
        try{
            //if connection isn't created, then create one
            if(con==null){
                //load the driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                //creating connection to the database we want to work with. here we want to work with 'noname' database
                String url="jdbc:mysql://localhost:3306/noname";
                String username="root";
                String password="712258";
                con=DriverManager.getConnection(url, username, password);

                //checking if connection is created or not
                if(con.isClosed()){
                    System.out.println("Connection is closed");
                }
                else{
                    System.out.println("Connection is created....");
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}

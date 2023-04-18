import java.sql.*;
import java.io.*;
import javax.swing.*;
class Main{
    public static void main(String[] args){
        //BufferedReader is faster than scanner because it reads the character sequence only. That's why we use BufferedReader instead of Scanner
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //there is a high chance that this code will throw an exception, so we need to handle it
        try{
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating connection to the database we want to work with. here we want to work with 'noname' database
            String url="jdbc:mysql://localhost:3306/noname";
            String username="root";
            String password="712258";
            Connection con=DriverManager.getConnection(url, username, password);

            //checking if connection is created or not
            if(con.isClosed()){
                System.out.println("Connection is closed");
            }
            else{
                System.out.println("Connection is created....");
            }


            //CREATING A TABLE IN DATABASE 'NONAME'
            //creating a query (which will create a table. rows of the table will be passed as parameter and the delimeter will be ',')
            String q="create table customer(id int(20) primary key auto_increment, name varchar(200) not null, city varchar(400), image longblob)";
            
            //creating a statement 
            Statement stmt=con.createStatement(); 
            
            //firing the query which will create table
            stmt.executeUpdate(q);
            System.out.println("Table is created in the database");


            //INSERTING DATA IN TABLE 'CUSTOMER'
            //creating a query to insert data in table and the values of name and city colomns will be provided later
            //note: this is the updated form of query. the one in video is old and this fuckin' works!!!!!!
            String q2="INSERT INTO customer(name,city,image)"+"VALUES (?,?,?)";
            
            //get the PreparedStatement object using prepareStatement() and pass the 2nd query
            PreparedStatement pstmt=con.prepareStatement(q2);

            //set the valuse of name and city colomns
            //for name colomn
            System.out.println("Enter name: ");
            String s1=br.readLine();
            pstmt.setString(1,s1);
            //for city colomn
            System.out.println("Enter city: ");
            String s2=br.readLine();
            pstmt.setString(2,s2);
            
            //using SWING API to add image
            //create an object which will be used to choose file
            JFileChooser jfc=new JFileChooser();
            //create dialog box which will show all imagees stored in desktop
            jfc.showOpenDialog(null);
            //store the single selected file
            File file=jfc.getSelectedFile(); 
            //read the selected file
            FileInputStream fis=new FileInputStream(file);
            pstmt.setBinaryStream(3, fis, fis.available());

           //update the pstmt and fire the query. P.S.: we don't need to pass query as we already did it while creating pstmt
           pstmt.executeUpdate();
           System.out.println("Data inserted....."); 

           //dialog box which will pass message
           JOptionPane.showMessageDialog(null, "SUCCESS!!!!");

            //closing the connection
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}  
package practicingcodes;

import java.util.*;
import java.io.*;

public class PracticingCodes {
   public static void main(String[] args) {
        // TODO code application logic here
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        
        char valid='y';
        
        ArrayList<String>alist=new ArrayList<>();
        while(valid=='y'){
            System.out.println("Enter names:");
            String name=sc.nextLine();
            alist.add(name);
            System.out.println("Do you want to add more (y/n):");
            valid=sc.next().charAt(0);
            sc.nextLine();
        }
        
        System.out.println("All names:");
        for(String a:alist){
            System.out.println(a);
        }
    }
    
}

package practicingcodes;

import java.util.*;
import java.io.*;

public class HashMap2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String>hmap=new HashMap<>();
        String valid="yes";
        while(valid.equals("yes")){
            System.out.println("Enter name:");
            String name=br.readLine();
            System.out.println("Enter wickets (separated by '|'):");
            String wickets=br.readLine();
            hmap.put(name, wickets);
            System.out.println("Do you want to add another player (yes/no)?");
            valid=br.readLine();
        }
        String s_valid="yes";
        while(s_valid.equals("yes")){
            System.out.println("Enter player name to search");
            String search=br.readLine();
            if(hmap.containsKey(search)){
                System.out.println("Wickets are:");
                String str=hmap.get(search);
                String[] arr=str.split("\\|");
                for(String a:arr){
                    System.out.println(a);
                }
            }
            else{
                System.out.println("No player found");
            }
            System.out.println("Do you want to search? (yes/no)");
            s_valid=br.readLine();
        }
    }
}

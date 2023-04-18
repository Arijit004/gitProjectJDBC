package practicingcodes;

import java.util.*;
import java.io.*;

public class AdvancedTreeSet2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number:");
        int n=Integer.parseInt(br.readLine());
        System.out.println("Enter details:");
        ArrayList<String>dets=new ArrayList<>();
        for(int i=0; i<n; i++){
            dets.add(br.readLine());
        }
        System.out.println();
        System.out.println("All details in ascending order:");
        SortedSet<String>plane=new TreeSet<>();
        for(String s:dets){
            String[] arr=s.split("\\|");
            plane.add(arr[0]);
        }
        Iterator it=plane.iterator();
        while(it.hasNext()){
            String p=(String)it.next();
            System.out.println(p);
            SortedSet<String>passengers=new TreeSet<>();
            for(String s:dets){
                if(s.contains(p)){
                    String[]arr=s.split("\\|");
                    passengers.add(arr[1]);
                }
            }
            Iterator it2=passengers.iterator();
            while(it2.hasNext()){
                String p2=(String)it2.next();
                System.out.println("--"+p2);
            }
        }
        
    }
}

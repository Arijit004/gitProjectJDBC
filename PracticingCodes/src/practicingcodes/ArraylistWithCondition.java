package practicingcodes;

import java.util.*;

public class ArraylistWithCondition {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<String>alist=new ArrayList<>();
        System.out.println("Enter the number of details:");
        int n=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the details:");
        for(int i=0; i<n; i++){
            String s=sc.nextLine();
            alist.add(s);
        }
        ArrayList<String>valid=new ArrayList<>();
        for(String s:alist){
            String[]arr=s.split("\\_");
            if(arr[1].equals("IT") || arr[1].equals("CSE") || arr[1].equals("ECE") ){
                if(arr[2].length()==7){
                    valid.add(s);
                }
            }
        }
        System.out.println();
        if(valid.isEmpty()){
            System.out.println("No valid participants");
        }
        else{
            System.out.println("All valid participants are:");
            for(String a:valid){
                System.out.println(a);
            }
        }
    }
}

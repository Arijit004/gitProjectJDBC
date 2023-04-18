package practicingcodes;

import java.util.*;

public class PracticingSet {
    public static void main(String[] args){
        LinkedHashSet<String>hset=new LinkedHashSet<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of clgs:");
        int n=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter clg details:");
        for(int i=0; i<n; i++){
            String s=sc.nextLine();
            hset.add(s);
        }
        System.out.println("Enter the clg number to be displayed:");
        int m=sc.nextInt();
        sc.nextLine();
        System.out.println();
        if(m>n){
            System.out.println("Invalid");
        }
        else{
            System.out.println("Clg details are:");
            int i=0;
            Iterator it=hset.iterator();
            while(it.hasNext() && i<m){
                System.out.println(it.next());
                i++;
            }
            System.out.println();
            System.out.println("Enter clg code to be searched:");
            int code=sc.nextInt();
            sc.nextLine();
            ArrayList<String>found=new ArrayList<>();
            int f=0;
            Iterator it2=hset.iterator();
            while(it2.hasNext()){
                String str=(String)it2.next();
                String[]arr=str.split("\\_");
                int c=Integer.parseInt(arr[2]);
                if(c==code){
                    f=1;
                    found.add(str);
                }
            }
            System.out.println();
            if(f==1){
                System.out.println("Clg code is found");
                for(String s:found){
                    System.out.println(s);
                }
            }
            else{
                System.out.println("invalid code");
            }
            
        }
    }
}

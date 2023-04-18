package practicingcodes;

import java.util.*;
import java.io.*;

class ItemType{
    private String name;
    private double deposit;
    private double costPerDay;
    public ItemType(String name, double deposit, double costPerDay){
        this.name=name;
        this.deposit=deposit;
        this.costPerDay=costPerDay;
    }
    @Override
    public String toString(){
        return String.format("%-20s%-20s%-20s", name, Double.toString(deposit), Double.toString(costPerDay));
    }
}
public class CustomArraylist {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ItemType>alist=new ArrayList<>();
        String valid="y";
        while(valid.equals("y")){
            System.out.println("Enter name:");
            String name=br.readLine();
            
            System.out.println("Enter deposit:");
            double deposit=Double.parseDouble(br.readLine());
            
            System.out.println("Enter costPerDay:");
            double cpd=Double.parseDouble(br.readLine());
            
            alist.add(new ItemType(name, deposit, cpd));
            
            System.out.println("Do you want to continue:");
            valid=br.readLine();
        }
        System.out.println();
        System.out.println("All elements");
        System.out.println(String.format("%-20s%-20s%-20s", "Name", "Deposit", "CostPerDay"));
        for(ItemType a:alist){
            System.out.println(a.toString());
        }
        
    }
}

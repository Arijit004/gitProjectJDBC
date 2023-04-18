package practicingcodes;

import java.util.*;

class Expense implements Comparable<Expense>{
    private String name;
    private int amount;
    public Expense(String name, int amount){
        this.name=name;
        this.amount=amount;
    }
    @Override
    public int compareTo(Expense e1){
        if(e1.amount==amount){
            return 0;
        }
        else if(amount<e1.amount){
            return 1;
        }
        else{
            return -1;
        }    
    }
    @Override
    public String toString(){
        return String.format("%-15s%-15s", name, Integer.toString(amount));
    }
}
public class AdvancedTreeSet {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String valid="yes";
        TreeSet<Expense>tset=new TreeSet<>();
        while(valid.equals("yes")){
            System.out.println("Enter expense category:");
            String category=sc.nextLine();
            System.out.println("Enter expense amount:");
            int amount=sc.nextInt();
            sc.nextLine();
            tset.add(new Expense(category, amount));
            System.out.println("Do you want to continue(yes/no)");
            valid=sc.nextLine();
        }
        System.out.println();
        System.out.println(String.format("%-15s%-15s","Category", "Amount"));
        Iterator it=tset.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
}

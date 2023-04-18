package practicingcodes;

import java.util.*;
import java.io.*;

class Details{
    String number;
    String startTime;
    String endTime;
    
    public Details(String number, String startTime, String endTime){
        this.number=number;
        this.startTime=startTime;
        this.endTime=endTime;
    }
}

public class HashMap1 {
    public static <K, V> K getKey(Map<K, V> map, V value){
        for(Map.Entry<K, V> entry:map.entrySet()){
            if (value.equals(entry.getValue())){
                return entry.getKey();
            }
        }
        return null;
    }
    
    public static void main(String[] args) throws Exception{
        File file=new File("C:\\Users\\Arijit\\Downloads\\input (1).txt");
        BufferedReader br=new BufferedReader(new FileReader(file));
        String st;
        SortedSet<String>mails=new TreeSet<>();
        HashMap<ArrayList<Details>, String>dets=new HashMap<>();
        ArrayList<String>all=new ArrayList<>();
        while((st=br.readLine())!=null){
            all.add(st);
            String[] arr=st.split("\\,");
            mails.add(arr[0]);
        }
        Iterator it=mails.iterator();
        while(it.hasNext()){
            String mail=(String)it.next();
            ArrayList<Details> det=new ArrayList<>();
            //String st1;
            for(String st1:all){
                if(st1.contains(mail)){
                    String[]arr=st1.split("\\,");
                    det.add(new Details(arr[1], arr[2], arr[3]));
                }
            }
            dets.put(det, mail);
        }
        
        System.out.println();
        Iterator it1=mails.iterator();
        while(it1.hasNext()){
            String m=(String)it1.next();
            System.out.println("Call made by "+m);
            for(String v:dets.values()){
                if(v.equals(m)){
                    ArrayList<Details>store=new ArrayList<>(getKey(dets, v));
                    for(Details d:store){
                        System.out.println("Number called: "+d.number+"  Call time: "+d.startTime);
                    }
                }
            }
        }
    }
}

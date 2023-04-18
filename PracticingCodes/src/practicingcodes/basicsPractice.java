package practicingcodes;

import java.util.Scanner;
import java.io.*;
class Event
{
    private String name;
    private String details;
    private String manager;

    /*public Event(){
		super();
                System.out.println(name+" "+details+" "+manager);
	}*/
    public Event(String name, String details, String manager)
    {
        this.name = name;
        this.details = details;
        this.manager = manager;
        
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
    public String getDetails() {
        return this.details;
    }
    
    public void setManager(String manager) {
        this.manager = manager;
    }
    public String getManager() {
        return this.manager;
    }
}
class EventBO
{
    public void saveToFile(Event event) throws Exception
    {
        //Fill your code here
        //event=new Event();
        FileWriter file=new FileWriter("event.txt");
        BufferedWriter br=new BufferedWriter(file);
        br.write("Event details");
        br.write("\nEvent name:"+event.getName());
        br.write("\nEvent details:"+event.getDetails());
        br.write("\nEvent manager:"+event.getManager());
        br.close();
    }
}

public class basicsPractice
{
	public static void main(String[] args) {
		//Fill your code here
		try{
			//Scanner sc=new Scanner(System.in);
                    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the event name");
		String name=br.readLine();
		System.out.println("Enter the event details");
		String details=br.readLine();
		System.out.println("Enter the event manager");
		String manager=br.readLine();
		Event e1=new Event(name, details, manager);
		EventBO ebo=new EventBO();
		ebo.saveToFile(e1);
                //Event e2=new Event();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
/**
 * StormStatServer class is main class that interacts with database of storms.  
 * 
 *  @author Willie Xu
 *	email: xuwillie1@gmail.com
 *	Class CSE 214-R10
 */

import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class StormStatServer {
	private static HashMap<String, Storm> database=new HashMap<>();
	public static void main(String[]args) {
		boolean quit=true;
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome to the StormStatServer, we may not be able to make it rain, "+
							"but we sure can tell you when it happened!\n");
		  try
	        {   
	            FileInputStream file = new FileInputStream("hurricane.ser");
	            ObjectInputStream inStream  = new ObjectInputStream(file);
	            database = (HashMap<String, Storm>)inStream .readObject();
	            inStream .close();
	            System.out.println("hurricane.ser was found and loaded.");
	        }
	        catch(IOException ex)
	        {
	    		System.out.println("No previous data found.\n");
	        }catch (ClassNotFoundException c) {
	        	System.out.println("No previous data found.\n");
	        }
		System.out.println("Menu:\n\tA) Add A Storm\n\tL) Look Up A Storm\n\tD) Delete A Storm\n" + 
				"\tE) Edit Storm Data\n\tR) Print Storms Sorted By Rainfall\n\tW) Print Storms by Windspeed\r\n" + 
				"\tX) Save and quit\n\tQ) Quit and delete saved data\n");
		while(quit) {
			System.out.print("Please enter an option: ");
			char choice= sc.nextLine().charAt(0);
			choice=Character.toLowerCase(choice);
			//Add A Storm
			if(choice=='a') {

				System.out.print("Please enter name: ");
				String name=sc.nextLine();
				name=name.toUpperCase();
				System.out.print("Please enter date: ");
				String date= sc.nextLine();
				if(!date.contains("-")&&date.length()!=10) {
					System.out.print("Please enter date: ");
					date= sc.nextLine();
				}
				System.out.print("Please enter precipitation (cm): ");
				double precipitation=(Double.parseDouble(sc.nextLine()));
				System.out.print("Please enter windspeed (km/h): ");
				double windspeed=(Double.parseDouble(sc.nextLine()));
				Storm temp= new Storm(name,precipitation,windspeed,date);
				database.put(name,temp);
				System.out.println(temp.getName()+" added.");
			}
			//Look Up A Storm
			if(choice=='l') {
				System.out.print("Please enter name: ");
				String name=sc.nextLine();
				name=name.toUpperCase();
				if(database.containsKey(name)) {
					System.out.println(database.get(name).toString());
				}else {
				System.out.println("Storm not found!");
				}
			}
			//Delete A Storm
			if(choice=='d') {
				System.out.print("Please enter a name: ");
				String name=sc.nextLine();
				name=name.toUpperCase();
				if(database.containsKey(name)) {
					database.remove(name);
				System.out.println("Storm "+name+" has been deleted.");
				}else {
				System.out.println("Storm does not exist!");
				}
			}
			//Edit Storm Data
			if(choice=='e') {
				System.out.print("Please enter a name: ");
				String name=sc.nextLine();
				name=name.toUpperCase();
				if (!database.containsKey(name)){
				System.out.println("Key not found.");
				}else {
					Storm temp= database.get(name);
					System.out.println("In Edit Mode, press enter without any input to leave data unchanged.");
					System.out.print("Please enter date: ");
					String date= sc.nextLine();
					if(date!="") {
						temp.setDate(date);
					}
					System.out.print("Please enter precipitation (cm): ");
					String p=sc.nextLine();
					if(p!="") {
						double precipitation=Double.parseDouble(p);
						temp.setPrecipitation(precipitation);
					}
					System.out.print("Please enter windspeed (km/h): ");
					String w=sc.nextLine();
					if(w!="") {
						double windspeed=Double.parseDouble(w);
						temp.setWindspeed(windspeed);
					}
				}
			}
			//Print Storms Sorted By Rainfall
			if(choice=='r') {
				Collection<Storm> values = database.values();
				ArrayList<Storm> listOfValues = new ArrayList<Storm>(values);
				Collections.sort(listOfValues, new PrecipitationComparator());
				System.out.printf("%-20s%-15s%-20s\n--------------------------------------------\n","Name","Windspeed","Rainfall");
				for(int i=0;i<listOfValues.size();i++) {
					listOfValues.get(i).print();
				}
			}
			//W-Print Storms by Windspeed
			if(choice=='w') {
				Collection<Storm> values = database.values();
				ArrayList<Storm> listOfValues = new ArrayList<Storm>(values);
				Collections.sort(listOfValues, new WindSpeedComparator());
				System.out.printf("%-20s%-15s%-20s\n--------------------------------------------\n","Name","Windspeed","Rainfall");
				for(int i=0;i<listOfValues.size();i++) {
					listOfValues.get(i).print();
				}
				
			}
			//Save and quit
			if(choice=='x') {
				 try
			        {   
			            FileOutputStream file = new FileOutputStream("hurricane.ser");
			            ObjectOutputStream outStream = new ObjectOutputStream(file);
			            outStream.writeObject(database);  
			            outStream.close();
						System.out.println("File saved to hurricane.ser; feel free to use the weather channel in the meantime.");
						quit=false;
			        }catch(IOException ex){
			            System.out.println("IOException error!");
			        }

			}
			//Quit and delete saved data
			if(choice=='q') {
				System.out.println("Goodbye, it's hard to hold an (electric) candle in the cold November (and April!) rain!.");
				quit=false;
			}
		}
	}
}

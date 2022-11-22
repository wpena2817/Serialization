/* This program will use Serialization to write and synthesize the presenter's
 * program. It will use and collect the following information: Name, Phone Number,
 * Date of Birth, and Email Address. It will create a menu-driven program with 5 options.
 * Author: Whitney P. ;
 * Assignment 11 
 */



import java.io.*;
import java.util.Scanner;

class Information implements Serializable{
    String name;
    String phoneNum;
    String DOB;
    String emailAdd;

    public Information(String name, String phoneNum, String DOB, String emailAdd) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.DOB = DOB;
        this.emailAdd = emailAdd;
    }



    public static void printdata(Information object){

        System.out.println("Name: " + object.name);
        System.out.println("Phone Number: " + object.phoneNum);
        System.out.println("Date of Birth: " + object.DOB);
        System.out.println("Email Address: " + object.emailAdd);
    }

}

public class SerializationHW{
    public static void main(String[] args) {
    	// Create Scanner
        Scanner kb = new Scanner(System.in);
        
        // Create file
        String filename = "Serialization.txt";
        
        // Declare variables
        int choice;

        // Show menu-driven 
        System.out.println("Welcome! Choose from the following options? " + "\n");
        System.out.println("1. Add information into a file.");
        System.out.println("2. Retrieve information from a file and display them.");
        System.out.println("3. Delete Information");
        System.out.println("4. Update Information");
        System.out.println("5. Exit.");
        System.out.println("(Enter the number for option chosen): ");

        while (true) {
            choice = kb.nextInt();

            switch (choice) {
                case 1: // Add information to into a file
                	
                	// Create object with corresponding input
                	Information objectCase1 = new Information("Whitney", "(630)373-7055", "03/28/1997", "whitneypena@gmail.com");
                	

                try {
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
					
					objectOutputStream.writeObject(objectCase1);
					
					System.out.println("Information has been added to file.");
				}
				catch (Exception e) {
					System.out.println("File not compatible.");
				}
                break;
            
                case 2: // Retrieve information from a file and display them
                	
                	try {
                		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
                		
                		Information name = (Information) objectInputStream.readObject();
                		System.out.println(name);
    				}
    				catch (Exception e) {
    					System.out.println("File not compatible.");
    				}
                break;
                
                case 3: // Delete information
                	
                	// Create object with corresponding input
                	Information objectCase3 = new Information("", "", "", "");
                	

                try {
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
					
					objectOutputStream.writeObject(objectCase3);
					
					System.out.println("Information from has been deleted from the file.");
				}
				catch (Exception e) {
					System.out.println("File not compatible.");
				}
                break;
                
                case 4: // Update information     
                	
                	// Create object with corresponding input
                	Information objectCase4 = new Information("Christopher", "(305)376-7856", "11/23/1996", "christophervelezmunoz@cncomusic.com");
                	

                try {
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
					
					objectOutputStream.writeObject(objectCase4);
					
					System.out.println("Information from has been updated from the file.");
				}
				catch (Exception e) {
					System.out.println("File not compatible.");
				}
                break;
                
                case 5: // Exit
                	System.out.println("You are now exiting the program...");
                	System.out.println("Program terminated.");
                	break;
            }
            
        }
    }
}
package fr.epita.Fundementalproject.consolelauncher;

import java.sql.SQLException;
import java.util.Scanner;

import fr.epita.Fundementalproject.business.CreateIdentity;
import fr.epita.Fundementalproject.business.DeleteIdentity;
import fr.epita.Fundementalproject.business.UpdateIdentity;
import fr.epita.Fundementalproject.services.jdbcDAO;

public class ConsoleLauncher {
	 public static void main(String[] args) {
		  // TODO Auto-generated method stub
		  System.out.println("Welcome to the IAM software");
		  Scanner scanner = new Scanner(System.in);
		  
		  //authentication
		  if(!authenticate(scanner)){
		   System.out.println("Wrong username or password!");
		   end(scanner);
		   return;
		  }
		  boolean continuer = true;
		  
		  while(continuer == true){
		  //menu
		  System.out.println("Please select an action:");
		  System.out.println("1. Create identity");
		  System.out.println("2. Modify identity");
		  System.out.println("3. Delete identity");
		  System.out.println("4. Quit");
		  String choice = scanner.nextLine();
		  
		  switch (choice) {
		  case "1":
			  //Create
			  CreateIdentity.execute(scanner);
		   	break;
		  case "2":
			  //Modify 
			  UpdateIdentity.execute(scanner);
			  break;
		  case "3":
			  //Delete
			  DeleteIdentity.execute(scanner);
			  break;
		  case "4":
			  //Quit
			  System.out.println("Thank you for using the application! Bye!");
			  continuer = false;
			  break;
		   
		  default:
		   System.out.println("Your choice is not recognized.");
		   break;
		  }
		  }
		  //end
		  end(scanner);
		 }
		 private static void end(Scanner scanner) {
		  System.out.println("Thanks for using this application, good bye!");
		  scanner.close();
		 }
		 private static boolean authenticate(Scanner scanner) {
		  boolean result = false;
		  System.out.println("Please type your login:");
		  String login = scanner.nextLine();
		  
		  System.out.println("Please type your password:");
		  String password = scanner.nextLine();
		  
		  jdbcDAO connection = null;
		  
		  try {
			connection = new jdbcDAO();
			result = connection.authenticate(login, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result; 
			
		  
		 }
		
}

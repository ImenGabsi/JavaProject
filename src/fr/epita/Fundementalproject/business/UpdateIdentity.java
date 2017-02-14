package fr.epita.Fundementalproject.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.Fundementalproject.model.Identity;
import fr.epita.Fundementalproject.services.jdbcDAO;

public class UpdateIdentity {
	
	public static void execute(Scanner scanner){
		System.out.println("Identity Modification");
		System.out.println("These are the identities:");
		 
		List<Identity> identities = new ArrayList<>();
		
		jdbcDAO connection = null;
		
		try {
			connection = new jdbcDAO();
			identities = connection.readAllIdentities();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(identities);
		System.out.println("Select a uid to modify");
		String uid = scanner.nextLine();
		System.out.println("Please input new displayname");
		String displayName = scanner.nextLine();
		System.out.println("Please input new email address");
		String email = scanner.nextLine();
		System.out.println("Please input new birthdate(yyyy-mm-dd)");
		String birthdate = scanner.nextLine();
		System.out.println("Please input new password");
		String password = scanner.nextLine();
		
		Identity identity = new Identity(uid,displayName,email, birthdate, password);
		
		try {
			connection.update(identity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Done updating!");
		
	}
	
}

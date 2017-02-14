package fr.epita.Fundementalproject.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.Fundementalproject.model.Identity;
import fr.epita.Fundementalproject.services.jdbcDAO;

public class DeleteIdentity {
	public static void execute(Scanner scanner){
		System.out.println("Identity Deletion");
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
		System.out.println("Select a uid to delete");
		String uid = scanner.nextLine();
		
		try {
			connection.delete(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Done deleting!");
		
	}
}

package fr.epita.Fundementalproject.business;

import java.sql.SQLException;
import java.util.Scanner;

import fr.epita.Fundementalproject.model.Identity;
import fr.epita.Fundementalproject.services.jdbcDAO;

public class CreateIdentity {
	public static void execute(Scanner scanner){
		System.out.println("Identity Creation");
		System.out.println("Please input the displayName");
		String displayName = scanner.nextLine();
		System.out.println("Please input the email address");
		String email = scanner.nextLine();
		System.out.println("Please input the birthdate(yyyy-mm-dd)");
		String birthdate = scanner.nextLine();
		System.out.println("Please input the password");
		String password = scanner.nextLine();
		
		Identity identity = new Identity("",displayName,email, birthdate, password);
		
		System.out.println("Success!!");
		jdbcDAO connection;
		try {
			connection = new jdbcDAO();
			connection.write(identity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Done!");
		
	}
}

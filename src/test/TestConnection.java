package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.Fundementalproject.model.Identity;
import fr.epita.Fundementalproject.services.jdbcDAO;

public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Identity> list = new ArrayList<>();
		try {
			jdbcDAO connection = new jdbcDAO();
			list = connection.readAllIdentities();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(list);
	}

}

package fr.epita.Fundementalproject.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.Fundementalproject.model.Identity;

public class jdbcDAO {

		 private Connection currentConnection;
		 /**
		  * @param connection
		  * @throws SQLException 
		  */
		 public jdbcDAO() throws SQLException{
		  
		   getConnection();
		  
		 }
		 
		 private Connection getConnection() throws SQLException {
		  try {
		   this.currentConnection.getSchema();
		  } catch (Exception e) {
		   // TODO read those information from a file
		   String user = "imen";
		   String password = "1992";
		   String connectionString = "jdbc:derby://localhost:1527/IMEN;create=true";
		   this.currentConnection = DriverManager.getConnection(connectionString, user, password);
		  }
		  return this.currentConnection;
		 }
		 private void releaseResources() {
		  try {
		   this.currentConnection.close();
		  } catch (Exception e) {
		   //TODO trace Exception
		  }
		 }
		 public List<Identity> readAllIdentities() throws SQLException {
		  List<Identity> identities = new ArrayList<>();
		  Connection connection = getConnection();
		  PreparedStatement statement = connection.prepareStatement("select * from IDENTITIES");
		  ResultSet rs = statement.executeQuery();
		  while (rs.next()) {
		   int uid = rs.getInt("IDENTITY_ID");
		   String displayName = rs.getString("IDENTITY_DISPLAYNAME");
		   String email = rs.getString("IDENTITY_EMAIL");
		   String birthdate = rs.getString("IDENTITY_BIRTHDATE");
		   String password = rs.getString("IDENTITY_PASSWORD");
		   Identity identity = new Identity(String.valueOf(uid), displayName, email,birthdate, password);
		   identities.add(identity);
		  }
		  return identities;
		 }
		 
		 public void write(Identity identity) throws SQLException {
		  Connection connection = getConnection();
		  String sqlInstruction = "INSERT INTO IDENTITIES(IDENTITY_DISPLAYNAME, IDENTITY_EMAIL, "
		    + "IDENTITY_BIRTHDATE, IDENTITY_PASSWORD) VALUES(?,?,?,?)";
		  PreparedStatement pstmt = connection.prepareStatement(sqlInstruction);
		  pstmt.setString(1, identity.getDisplayName());
		  pstmt.setString(2, identity.getEmail());
		  pstmt.setString(3, identity.getBirthDate());
		  pstmt.setString(4, identity.getPassword());
		  pstmt.execute();
		 }
		 
		 public void update(Identity identity) throws SQLException{
			 Connection connection = getConnection();
			  String sqlInstruction = "UPDATE IDENTITIES SET IDENTITY_DISPLAYNAME = ?, "
			  		+ " IDENTITY_EMAIL = ?, IDENTITY_BIRTHDATE = ?, IDENTITY_PASSWORD = ? WHERE IDENTITY_ID = ?";
			  PreparedStatement pstmt = connection.prepareStatement(sqlInstruction);
			  pstmt.setString(1, identity.getDisplayName());
			  pstmt.setString(2, identity.getEmail());
			  pstmt.setString(3, identity.getBirthDate());
			  pstmt.setString(4, identity.getPassword());
			  pstmt.setString(5, identity.getUid());
			  pstmt.execute();
		 }
		 public void delete(String id) throws SQLException{
			 Connection connection = getConnection();
			  String sqlInstruction = "DELETE FROM IDENTITIES WHERE IDENTITY_ID = ?";
			  PreparedStatement pstmt = connection.prepareStatement(sqlInstruction);
			  pstmt.setString(1, id);
			  pstmt.execute();
		 }
		 public boolean authenticate(String user, String password) throws SQLException{
			 	boolean result = false;
			 	Connection connection = getConnection();
			 	String sqlInstruction = "SELECT * FROM IDENTITIES WHERE IDENTITY_DISPLAYNAME = ? AND IDENTITY_PASSWORD = ? ";
				PreparedStatement pstmt = connection.prepareStatement(sqlInstruction);
				pstmt.setString(1, user);
				pstmt.setString(2, password);
				ResultSet rs =  pstmt.executeQuery();
				if(rs.next()){
					result = true;
				}
				return result;
		 }
		}

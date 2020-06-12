import java.sql.*;
import java.util.ArrayList;

public class Buyers extends ListFromDB {
	/*
	 * Buyers.java
	 * Inherits from ListFromDB.java
	 * Purpose: Extracts data and updates database for Buyers.
	 * @author Evangelia Papagiannaki, Eleni Polyzoidou.
	 */
	private ArrayList<Buyer> buyers = new ArrayList<Buyer>();
	
	/**
	 * Extracts data from database for Buyers and adds them into list buyers.
	 */
	@Override
	public void extractObjectDB() {
		Connection c = connect();
		try {

			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Client INNER JOIN Sells_to on Client.Id = Sells_to.ClientId");
			
			while (rs.next()) {
				
				Buyer b = new Buyer("","", "", "","","");
				b.setName(rs.getString("Name"));
				b.setLastName(rs.getString("LastName"));
				b.setId(rs.getString("Id"));
				b.setAFM(rs.getString("AFM"));
				b.setPhoneNumber(rs.getString("PhoneNumber"));
				b.setSellerId(rs.getString("SellerId"));
				buyers.add(b);			

			}
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Update buyers and inserts new records into arrays that are related to buyers.
	 */
	@Override
	public void updateObjectDB(){
		Connection c = connect();
		try {
			
			String insertIntoClient = "INSERT OR IGNORE INTO Client (Id, Name, LastName, AFM) VALUES (?,?,?,?,?);";    //SQL statement for insertion into array Client
			String insertIntoSells_to = "INSERT OR IGNORE INTO Sells_to (SellerId, ClientId) VALUES (?,?);";         //SQL statement for insertion into array Sells_to
			PreparedStatement statementClient = c.prepareStatement(insertIntoClient);
			PreparedStatement statementSells_to = c.prepareStatement(insertIntoSells_to);
			
			for (Buyer b:  buyers) {
				statementClient.setString(1 ,b.getId());
				statementClient.setString(2, b.getName());
				statementClient.setString(3, b.getLastName());
				statementClient.setString(4, b.getAFM());
				statementClient.setString(5, b.getPhoneNumber());
				
				statementSells_to.setString(1, b.getSellerId());
				statementSells_to.setString(2, b.getId());
				
				statementClient.executeUpdate();	
				statementSells_to.executeUpdate();
				
			}
			statementClient.close();
			statementSells_to.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Buyer> getBuyers()
	{
		return buyers;
	}


}

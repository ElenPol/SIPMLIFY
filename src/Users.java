import java.sql.*;
import java.util.ArrayList;
/**
* Users.java
* Inherits from ListFromDB.java
* Purpose: Extracts data and updates database for Users.
* @author Evangelia Papagiannaki, Eleni Polyzoidou.
*/
public class Users extends ListFromDB {
	private ArrayList<User> users = new ArrayList<User>();
	
	/**
	 * Extracts data, creates new Users and adds them to list users
	 */
	@Override
	public void extractObjectDB() {
		Connection c = connect();
		try {
			statement = c.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM User  WHERE id NOT IN (SELECT id FROM OrderManager)");
			while (rs.next()) {
				
				User us = new User();
				us.setFirstName(rs.getString("FirstName"));
				us.setSurName(rs.getString("LastName"));
				us.setPassword(rs.getString("Password"));
				us.setTelephone(rs.getString("Phonenumber"));
				us.setAFM(rs.getString("AFM"));
				us.setId(rs.getString("id"));
				us.setCompany(rs.getString("Company"));
				users.add(us);
			}
			for(User user: users)
			{
				int index = users.indexOf(user);
				if (user.getId().startsWith("ST")) {
					Stockkeeper st = new Stockkeeper(user.getFirstName(),user.getSurName(),user.getPassword(),user.getTelephone(),user.getAFM(),user.getId(),user.getCompany());
					users.set(index,st);
				}
				else {
					Seller se = new Seller (user.getFirstName(),user.getSurName(),user.getPassword(),user.getTelephone(),user.getAFM(),user.getId(),user.getCompany());
					users.set(index, se);
				}
			}
			statement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ResultSet results = statement.executeQuery("SELECT FirstName , LastName, Password,Phonenumber,AFM,User.id, Company,Regular,Season FROM User INNER JOIN OrderManager on User.id=OrderManager.Id");
			while (results.next()) {
				
				OrderManager om = new OrderManager("","","","","","","",true,"");
				om.setFirstName(results.getString("FirstName"));
				om.setSurName(results.getString("LastName"));
				om.setPassword(results.getString("Password"));
				om.setTelephone(results.getString("Phonenumber"));
				om.setAFM(results.getString("AFM"));
				om.setId(results.getString("id"));
				om.setCompany(results.getString("Company"));
				if (results.getString("Regular").equals("0")) 
					om.setRegular(true);
				else 
					om.setRegular(false);
				om.setSeason(results.getString("Season"));
				users.add(om);
				
			}
			statement.close();
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
	/**
 	 * Updates old records and inserts new ones into arrays OrderManager
	 */
	@Override
	public void updateObjectDB() {
		Connection c = connect();
		try {
			String updateOrderManager = "UPDATE OrderManager SET Regular = ?, Season = ? WHERE id = ?";
			PreparedStatement updateStatement = c.prepareStatement(updateOrderManager);
			for (User u : users) {
				if (u instanceof OrderManager) {
					OrderManager ord = (OrderManager) u;
					System.out.println(ord.getSeason());
					if (ord.getRegular()) { 
						updateStatement.setString(1, "0");
						updateStatement.setString(2, "");
					}else {
						updateStatement.setString(1, "1");
						updateStatement.setString(2, ord.getSeason());
					}
					
					updateStatement.setString(3, ord.getId());
					updateStatement.executeUpdate();
				}
			}
			updateStatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Gets the list of Users
	 * @return An ArrayList with Users
	 */
	public ArrayList<User> getUsers(){
		return users;
	}
}
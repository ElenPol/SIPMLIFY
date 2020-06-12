import java.sql.*;
import java.util.ArrayList;
/**
* Suppliers.java
* Inherits from ListFromDB.java
* Purpose: Extracts data and updates database for Suppliers.
* @author Evangelia Papagiannaki, Eleni Polyzoidou.
*/
public class Suppliers extends ListFromDB {
	private ArrayList<Supplier> suppliers = new ArrayList<>();
	
		
	/**
	 * Extracts data, creates new Suppliers and adds them to list suppliers
	 */
	@Override
	public void extractObjectDB() {
		Connection c = connect();
		try {

			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Supplier INNER JOIN Buys_from on Supplier.id = Buys_from.Supplier_Id");
			
			while (rs.next()) {
				
				Supplier s = new Supplier("", "", "", "", "","");
				s.setName(rs.getString("Name"));
				s.setLastName(rs.getString("LastName"));
				s.setId(rs.getString("id"));
				s.setPhoneNumber(rs.getString("PhoneNumber"));
				s.setAFM(rs.getString("AFM"));
				s.setOrderManagerId(rs.getString("OrderManagerId"));
				suppliers.add(s);
				
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
	/**
 	 * Updates old records and inserts new ones into arrays Supplier and  Buys_from
	 */
	@Override
	public void updateObjectDB() {
		Connection c = connect();
		try {
			
			String insertIntoSupplier = "INSERT OR IGNORE INTO Supplier (Id, Name, LastName, PhoneNumber, AFM) VALUES (?,?,?,?,?);";
			String insertIntoBuys_from = "INSERT OR IGNORE INTO Buys_from (Supplier_Id, OrderManagerId) VALUES (?,?) ;";
			PreparedStatement supplierStatement = c.prepareStatement(insertIntoSupplier);
			PreparedStatement buys_fromStatement = c.prepareStatement(insertIntoBuys_from);
			
			for (Supplier sup:  suppliers) {
				
				supplierStatement.setString(1 ,sup.getId());
				supplierStatement.setString(2, sup.getName());
				supplierStatement.setString(3, sup.getLastName());
				supplierStatement.setString(4, sup.getPhoneNumber());
				supplierStatement.setString(5, sup.getAFM());
				
				buys_fromStatement.setString(1,sup.getId());
				buys_fromStatement.setString(2, sup.getOrderManagerId());
				
				buys_fromStatement.executeUpdate();
				supplierStatement.executeUpdate();	
			}
			
			supplierStatement.close();
			buys_fromStatement.close();
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
	 * Gets the list of Suppliers
	 * @return An ArrayList with Suppliers
	 */
	public ArrayList<Supplier> getSuppliers(){
		return suppliers;
	}
	

}
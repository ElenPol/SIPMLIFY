import java.sql.*;
import java.util.ArrayList;
/**
* Supplies.java
* Inherits from ListFromDB.java
* Purpose: Extracts data and updates database for Supplies.
* @author Evangelia Papagiannaki, Eleni Polyzoidou.
*/
public class Supplies extends ListFromDB {
	ArrayList<Suppl> supplies = new ArrayList<>();
	/**
	 * Extracts data, creates new Suppl and adds them to list supplies
	 */
	@Override
	public void extractObjectDB() {
		Connection c = connect();
		try {
			
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Supplies");
			
			while (rs.next()) {

				Suppl s = new Suppl("", "", 0.0);
				s.setProductId(rs.getString("PFP_Id"));
				s.setSupplierId(rs.getString("Supplier_Id"));
				s.setPrice(rs.getDouble("Price"));
				supplies.add(s);
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
 	 * Updates old records and inserts new ones into arrays Supplies
	 */
	@Override
	public void updateObjectDB(){
		Connection c = connect();
		try {
			String insertIntoSupplies = "INSERT OR IGNORE INTO Supplies (Supplier_Id, PFP_Id, Price) VALUES (?,?,?);";
			PreparedStatement statementSupplies = c.prepareStatement(insertIntoSupplies);
			for(Suppl s: supplies) {
				statementSupplies.setString(1, s.getSupplierId());
				statementSupplies.setString(2, s.getProductId());
				statementSupplies.setDouble(3, s.getPrice());
				statementSupplies.executeUpdate();
			}
			statementSupplies.close();
			
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
	 * Gets the list of Suppl
	 * @return An ArrayList with Suppl
	 */
	public ArrayList<Suppl> getSupplies(){
		return supplies;
	}
 
}
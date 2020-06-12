import java.sql.*;
import java.util.ArrayList;
/**
* SupplierProducts.java
* Inherits from ListFromDB.java
* Purpose: Extracts data and updates database for SupplierProducts.
* @author Evangelia Papagiannaki, Eleni Polyzoidou.
*/
public class SupplierProducts extends ListFromDB {
	private ArrayList<SupplierProduct> supplierp = new ArrayList<>();
	/**
	 * Extracts data, creates new Orders and adds them to supplierp
	 */
	@Override
	public void extractObjectDB() {
		Connection c = connect();
		try {
			
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Product_for_purchase INNER JOIN OrderManager_Watches_Product "
					+ "ON Product_for_purchase.Id = OrderManager_Watches_Product.PFP_Id");

			while (rs.next()) {
				SupplierProduct sp = new SupplierProduct("", "","", 0.0, 0.0, 0.0, 0.0, 0, 0.0);
				sp.setName(rs.getString("Name"));
				sp.setId(rs.getString("Id"));
				sp.setOrderManagerId(rs.getString("OrderManagerId"));
				sp.setStockAmount(rs.getDouble("StockAmount"));
				sp.setMaxStockAmount(rs.getDouble("MaxStockAmount"));
				sp.setSafetyStock(rs.getDouble("SafetyStock"));
				sp.setAverageMonthlyConsumption(rs.getDouble("AverageMonthlyConsumption"));
				sp.setLeadtime(rs.getInt("Leadtime"));
				sp.setExpectedAmount(rs.getDouble("ExpectedAmount"));
				supplierp.add(sp);
				
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
 	 * Updates old records and inserts new ones into arrays Product_for_purchase and  OrderManager_Watches_Product
	 */
	@Override
	public void updateObjectDB() {
		Connection c = connect ();
		try {
			
			String insertIntoPFP = "INSERT OR IGNORE INTO Product_for_purchase (Id, Name, StockAmount, MaxStockAmount,"
					+ " SafetyStock, AverageMonthlyConsumption, Leadtime, ExpectedAmount)  "
				+ "VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement statementPFP = c.prepareStatement(insertIntoPFP);
			String insertIntoWatches = "INSERT OR IGNORE INTO OrderManager_Watches_Product (PFP_Id, OrderManagerId) "
				+ "VALUES (?,?);";
			PreparedStatement statementWatches = c.prepareStatement(insertIntoWatches);
			String updatePFP = "UPDATE Product_for_purchase SET  StockAmount = ?  , Leadtime = ? , "
					+ "ExpectedAmount = ?  WHERE id = ? ";
			PreparedStatement statementUpdate= c.prepareStatement(updatePFP);
			
			for (SupplierProduct sp:  supplierp) {
				
				statementPFP.setString(1 ,sp.getId());
				statementPFP.setString(2, sp.getName());
				statementPFP.setDouble(3, sp.getStockAmount());
				statementPFP.setDouble(4, sp.getMaxStockAmount());
				statementPFP.setDouble(5, sp.getSafetyStock());
				statementPFP.setDouble(6, sp.getAverageMonthlyConsumption());
				statementPFP.setInt(7, sp.getLeadtime());
				statementPFP.setDouble(8, sp.getExpectedAmount());
				
				statementWatches.setString(1, sp.getId());
				statementWatches.setString(2, sp.getOrderManagerId());
				
				statementUpdate.setDouble(1, sp.getStockAmount());
				statementUpdate.setDouble(2, sp.getLeadtime());
				statementUpdate.setDouble(3, sp.getExpectedAmount());
				statementUpdate.setString(4, sp.getId());
				
				statementUpdate.executeUpdate();
				statementPFP.executeUpdate();
				statementWatches.executeUpdate();
			}
			statementUpdate.close();
			statementPFP.close();
			statementWatches.close();
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
	 * Gets the list of SupplierProduct
	 * @return An ArrayList with SupplierProducts.
	 */
	public ArrayList<SupplierProduct> getSupplierProducts() {
		
		return supplierp;
	}
}
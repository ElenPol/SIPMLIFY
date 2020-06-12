import java.sql.*;
import java.util.ArrayList;
/**
 * CompanyProducts.java
 * Inherits from ListFromDB.java
 * Purpose: Manages the data from table Product_for_sale (in simplify.db).
 * @author Eleni Polyzoidou, Evangelia Papagiannaki.
 */
public class CompanyProducts extends ListFromDB {
	
	private ArrayList<CompanyProduct> companyp = new ArrayList<>();
	/**
	 * Extracts data, creates new CompanyProducts and adds them to list companyp
	 */
	@Override
	public void extractObjectDB() {
		
		Connection c = connect();
		try {
			
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Product_for_sale INNER JOIN Seller_Watches_Product "
					+ "ON Product_for_sale.Id=Seller_Watches_Product.PFS_ID");
			
			while (rs.next()) {
				CompanyProduct cp = new CompanyProduct("", "", "", 0.0, 0.0, 0.0, 0.0);     //creates new CompanyProduct and fills the attributes with data from
				cp.setName(rs.getString("Name"));
				cp.setId(rs.getString("Id"));
				cp.setSellerId(rs.getString("SellerId"));
				cp.setStockAmount(rs.getDouble("StockAmount"));
				cp.setMaxStockAmount(rs.getDouble("MaxStockAmount"));
				cp.setSafetyStock(rs.getDouble("SafetyStock"));
				cp.setPrice(rs.getDouble("Price"));
				companyp.add(cp);
				
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
 	* Updates old records and inserts new ones into arrays Product_for_sale and  Seller_Watches_Product
	 */
	public void updateObjectDB() {
		Connection c = connect();
		try {	
			String insertIntoPFS = "INSERT OR IGNORE INTO Product_for_sale (Id, Name, StockAmount, MaxStockAmount, SafetyStock, Price) VALUES (?,?,?,?,?,?);";
			PreparedStatement statementPFS = c.prepareStatement(insertIntoPFS);
			
			String insertIntoWatches = "INSERT OR IGNORE INTO Seller_Watches_Product (SellerId, PFS_Id) VALUES (?,?);";
			PreparedStatement statementWatches = c.prepareStatement(insertIntoWatches);
			
			String updatePFS = "UPDATE Product_for_sale SET  StockAmount = ?  , Price = ? WHERE id = ? ";
			PreparedStatement statementUpdate = c.prepareStatement(updatePFS);	
			
			for (CompanyProduct cp:  companyp) {	
				statementPFS.setString(1, cp.getId());
				statementPFS.setString(2, cp.getName());
				statementPFS.setDouble(3, cp.getStockAmount());
				statementPFS.setDouble(4, cp.getMaxStockAmount());
				statementPFS.setDouble(5, cp.getSafetyStock());
				statementPFS.setDouble(6, cp.getPrice());
				
				statementWatches.setString(1, cp.getSellerId());
				statementWatches.setString(2, cp.getId());
				
				statementUpdate.setDouble(1, cp.getStockAmount());
				statementUpdate.setDouble(2, cp.getPrice());
				statementUpdate.setString(3, cp.getId());
	
				statementUpdate.executeUpdate();
				statementPFS.executeUpdate();
				statementWatches.executeUpdate();	
			}
			statementUpdate.close();
			statementPFS.close();
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
	
	
	public ArrayList<CompanyProduct> getCompanyProducts() {
		return companyp;
	}
	
	

}

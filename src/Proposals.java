import java.sql.*;
import java.util.Random;
import java.util.ArrayList;
/**
* Proposals.java
* Inherits from ListFromDB.java
* Purpose: Extracts data and updates database for Proposals.
* @author Evangelia Papagiannaki, Eleni Polyzoidou.
*/
public class Proposals extends ListFromDB {
	private ArrayList<Order> proposals = new ArrayList<>();
	/**
	 * Extracts data, creates new Proposals and adds them to list proposals.
	 */
	@Override
	public void extractObjectDB() {
		Connection c = connect();
		try {
			
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT  Show.OrderManagerId as OrderManagerId,Forecast_Proposal.Quantity as Quantity,Forecast_Proposal.Supplier_Id as sId,\r\n" + 
					"Supplier.Name as sName, Supplier.AFM as sAFM,Forecast_Proposal.datee as Date, Supplies.Price as Price,Forecast_Proposal.TotalPrice as TotalPrice,Forecast_Proposal.PFP_Id as PFP_Id \r\n" + 
					"FROM Forecast_Proposal inner join Show on Forecast_Proposal.PFP_Id = Show.PFP_Id and Show.Date = Forecast_Proposal.datee\r\n" + 
					"inner join Supplier on Forecast_Proposal.Supplier_Id = Supplier.id\r\n" + 
					"inner join Supplies on Forecast_Proposal.PFP_Id = Supplies.PFP_Id  ");
			Statement stmt2 = c.createStatement();
			Statement stmt3 = c.createStatement();
			Statement stmt4 = c.createStatement();
		
			while (rs.next()) {
				
				Order o = new Order("", "", 0.0, "", "", "", "", 0, 0.0, 0.0, "", "","");
				
				Random rand = new Random();
				int n = rand.nextInt(9)*100;
				if (rs.getDouble("TotalPrice") != 0.0) {
					String OMId = "";
					OMId = rs.getString("OrderManagerId");
					o.setOrderManagerId(OMId);
					o.setOrderId("FOR"+ n);
					o.setQuantity(rs.getDouble("Quantity"));
					o.setSupplierId(rs.getString("sId"));
					o.setSupplierName(rs.getString("sName"));
					o.setSupplierAFM(rs.getString("sAFM"));
					o.setDate(rs.getString("Date"));
					o.setPrice(rs.getDouble("Price"));
					o.setTotalPrice(rs.getDouble("TotalPrice"));
					String productId = "";
					productId = rs.getString("PFP_Id");
					o.setProductId(productId);
					ResultSet rs2 = stmt2.executeQuery("SELECT Name FROM Product_for_purchase WHERE Id = " + productId);
					o.setProductName(rs2.getString("Name"));
					ResultSet rs3 = stmt3.executeQuery("SELECT Company FROM  User WHERE id = \"" + OMId + "\";");
					String company = "";
					company = rs3.getString("Company");
					ResultSet rs4 = stmt4.executeQuery("SELECT id FROM  User WHERE Company = \"" + company + "\" and id LIKE \"ST%\"");
					o.setStockkeeperId(rs4.getString("Id"));

					proposals.add(o);
				}
			}
			stmt.close();
			stmt2.close();
			stmt3.close();
			stmt4.close();
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
 	 * Updates old records and inserts new ones into arrays Forecast_Proposal and  Show
	 */
	@Override
	public void updateObjectDB(){
		Connection c = connect();
		try {
			String insertIntoForecastProp = "INSERT OR IGNORE INTO Forecast_Proposal (PFP_Id, datee, Quantity, Supplier_Id, PFPId, TotalPrice) VALUES (?,?,?,?,?,?);";
			PreparedStatement statementForecast = c.prepareStatement(insertIntoForecastProp);
			
			String updateForecastProp  = "UPDATE Forecast_proposal SET TotalPrice = ? WHERE PFP_Id = ? ";
			PreparedStatement statementUpdate = c.prepareStatement(updateForecastProp);
			
			String insertIntoShow = "INSERT OR IGNORE INTO Show (PFP_Id, Date, OrderManagerId) VALUES (?, ?, ?);";
			PreparedStatement statementShow = c.prepareStatement(insertIntoShow);
			
			for (Order or : proposals) {
				System.out.println(10);
				statementForecast.setString(1 ,or.getProductId());
				statementForecast.setString(2, or.getDate());
				statementForecast.setDouble(3, or.getQuantity());
				statementForecast.setString(4, or.getSupplierId());
				statementForecast.setString(5, or.getProductId());
				statementForecast.setDouble(6, or.getTotalPrice());
				
				if (or.getTotalPrice() == 0.0) {
					statementUpdate.setDouble(1, or.getTotalPrice());
					statementUpdate.setString(2, or.getProductId());
					statementUpdate.executeUpdate();
				}
				statementShow.setString(1, or.getProductId());
				statementShow.setString(2, or.getDate());
				statementShow.setString(3, or.getOrderManagerId());
				
				statementForecast.executeUpdate();
				statementShow.executeUpdate();
				
			}
			statementForecast.close();
			statementUpdate.close();
			statementShow.close();
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
	
	
	public ArrayList<Order> getProposals() {
		return proposals;
	}

}
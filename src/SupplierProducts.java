import java.sql.*;
import java.util.ArrayList;

public class SupplierProducts extends ListFromDB {
	ArrayList<SupplierProduct> supplierp = new ArrayList<>();
	
	public void extractObjectDB() {
		Connection c = null;
		Statement stmt = null;
		try {
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:simplify.db");
			System.out.println("SQLite DB connected");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Product_for_purchase");
			
			SupplierProduct sp = new SupplierProduct("", "", 0.0, 0.0, 0.0, 0.0, 0, 0.0);
			while (rs.next()) {
				
				sp.setName(rs.getString(Name));
				sp.setId(rs.getString(Id));
				sp.setStockAmount(rs.getDouble(StockAmount));
				sp.setMaxStockAmount(rs.getDouble(MaxStockAmount));
				sp.setSafetyStock(rs.getDouble(SafetyStock)));
				sp.setAverageMonthlyConsumption(rs.getDouble(AverageMonthlyConsumption));
				sp.setLeadtime(rs.getInt(Leadtime));
				sp.setExpectedAmount(rs.getDouble(ExpectedAmount));
				supplierp.add(sp);
				
			}
			
			c.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;


/**
 * Forecast.java
 * Purpose: The class produces proposals of orders for every product in SupplierProducts(list).
 * @author Polyzoidou Eleni, Gkouli Nikoleta
 */
public class Forecast {

	private double per;
	private OrderManager orderManager;
	
	public Forecast(OrderManager om){    
		 //get current date
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  Date date = new Date();
		  String datee = formatter.format(date);
		  
		  //checks if the forecast function has already run once the current day
		  boolean calcStart = true;
		  for (Order p : om.getProposals().getProposals()) {
			  if (p.getDate().equals(datee)) {
				  JOptionPane.showMessageDialog(null, "The Forecast calculation has already run for today!", "Forecast", JOptionPane.DEFAULT_OPTION);
				  calcStart = false;
				  break;
			  }
		  }
		
		  if (calcStart) {
			  orderManager = om;
			  ArrayList<SupplierProduct> prod = orderManager.getProducts().getSupplierProducts();
			  Suppliers suppliers = orderManager.getSuppliers();
			  Supplies supplies = orderManager.getSupplies();

			  boolean isTypeRegular = orderManager.getRegular();
		  
			  double stockAmount;
			  double expectedAmount;
			  double averageMonthlyConsumption;
			  int leadtime;
			  double safetyStock;
			  double maxStorageAmount;
		 
			  double amount = 0.0;
			  boolean flag = false; //checks if at least one proposal has been created
		  
			  for(SupplierProduct p : prod) {
				  stockAmount = p.getStockAmount();
				  expectedAmount = p. getExpectedAmount();
				  averageMonthlyConsumption = p. getAverageMonthlyConsumption();
				  leadtime = p. getLeadtime();
				  safetyStock = p. getSafetyStock();
				  maxStorageAmount = p.getMaxStockAmount();
		  

				  if(stockAmount + expectedAmount - averageMonthlyConsumption - leadtime <= safetyStock) {
				  
					  per = 1.0;
					  if (isTypeRegular) { 
						  amount = calculateOrder(stockAmount,expectedAmount,averageMonthlyConsumption,leadtime ,safetyStock,per);
					  }
					  else {
						  String season = om.getSeason();
						  per = Percentage(season);
						  amount = calculateOrder(stockAmount,expectedAmount,averageMonthlyConsumption,leadtime ,safetyStock,per);    
					  }
				  
					  Suppl s = new Suppl(p.getId(), "", 0.0);
					  for (Suppl sp : supplies.getSupplies()) {
						  if (p.getId().equals(sp.getProductId())) {
							  s.setSupplierId(sp.getSupplierId());
							  s.setPrice(sp.getPrice());
						  }  
					  } 
					  Supplier sup = new Supplier("", "", s.getSupplierId(), "", "", "");
					  for (Supplier sp : suppliers.getSuppliers()) {
						  if (s.getSupplierId().equals(sp.getId())) {
							  sup.setLastName(sp.getLastName());
							  sup.setAFM(sp.getAFM());
						  }

					  }
				  
				  
					  Random rand = new Random();
					  int n = rand.nextInt(9)*100;
					  //create new order
					  Order order = new Order(p.getOrderManagerId(), "FOR"+n, amount, s.getSupplierId(), sup.getLastName(), 
							  sup.getAFM(), datee, 0, s.getPrice(), amount*s.getPrice(),  p.getId(), p.getName(), " ");
					  //add the order in the proposals-list
					  om.getProposals().getProposals().add(order);
				  
					  if (amount + expectedAmount + stockAmount > maxStorageAmount) {
						  amount = maxStorageAmount - (expectedAmount + stockAmount);
					  }
				  
					  flag = true;
				  } 
			  
			  }

		  
			  if (flag) {
			  
				  JOptionPane.showMessageDialog(null, "Forecast calculation is completed!", "Forecast", JOptionPane.DEFAULT_OPTION);
			  }
			  else {
				  JOptionPane.showMessageDialog(null, "There is no product in deficit!", "Forecast", JOptionPane.DEFAULT_OPTION);

			  }

		  }	  
	}

	
	/**
	 * The method calculates an amount of every product that must been ordered.
	 * @param stockAmount
	 * @param expectedAmount
	 * @param averageMonthlyConsumption
	 * @param leadtime
	 * @param safetyStock
	 * @param per
	 * @return amount
	 */
	private double calculateOrder(double stockAmount,double expectedAmount,double averageMonthlyConsumption,double leadtime,double safetyStock,double per){   
		double amount = (safetyStock + 2*averageMonthlyConsumption + leadtime - stockAmount - expectedAmount)*per;
		return Math.round(amount);
		
	}	
	
	
	/**
	 * The method set the right value in per depends on the type of season company
	 * @param season
	 * @return per
	 */
	private double Percentage( String season){   
		//get current month
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String str = formatter.format(date);
		Integer month = Integer.parseInt(str.substring(5, 7));
		
		double per;
		if (((month>=3) && (month<9) && (season == "Spring - Summer"))||((month>=9) || (month<3) && (season == "Autumn - Winter"))){
			per = 1.2;
		}
		else {
			per = 0.7;
		}
		return per;
	}
}	

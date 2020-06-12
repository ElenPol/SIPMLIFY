import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Statistics.java
 * Purpose : Calculates the statistics to be displayed.
 * @author Fotiadou Vassiliki
 */
public class Statistics {
	
	private int monthIntervals;
	private Seller seller;
	private String[] options;
	private String firstMonth;
	private String[] months;
	private ArrayList<Double> value;
	private boolean orderExists;	//true if at least one order exists in order to display the selected chart  
	private JPanel panel;
	
	public Statistics(String[] options,String[] months){
		this.options = options;
		this.months = months;
		value = new ArrayList<Double>();
		orderExists = false;
	}
	
	/**
	 * Calculates the date for the chart,calls the function to calculate statistics and calls the function of the chosen chart from class CreateChart for the ordermanager
	 * @param om
	 */
	public void OrdererStat(OrderManager om) {
		firstMonth = options[4];
		int years;
		int fromMonth = 0;
		int toMonth = 0;
		
		years = Integer.parseInt(options[7]) - Integer.parseInt(options[5]);
		for(int i = 0; i< 12; i++){
			if(options[4].equals(months[i])){
				fromMonth = i;						//checks which months is fromMonth and which month is toMonth and keeps the index
			}
			if(options[6].equals(months[i])){
				toMonth = i;
			}
		}
		if(years == 0){
			monthIntervals = toMonth - fromMonth;
		}
		else if(years > 0){									
				monthIntervals = toMonth - fromMonth + years*12;			//calculates the month intervals
		}
		
		ArrayList <Order> orders = om.getOrders().getOrders();
		calcOMValue(orders, fromMonth, monthIntervals);
		
		for(int i = 0 ; i < value.size(); i++)
		{
			if(value.get(i) != 0.00)
			{
				orderExists = true;
			}
		}
		
		if(orderExists == true)
		{
			CreateChart ch = new CreateChart(months,options);
			
			if(options[3].equals("Pie Chart")){							//calls the function of the chosen chart from CreateChart class
				ch.pieChart(value,monthIntervals,firstMonth);
			}
			else if(options[3].equals("Line Chart")){
				ch.lineChart(value,monthIntervals,firstMonth);
			}
			else if(options[3].equals("Bar Chart")){
				ch.barChart(value,monthIntervals,firstMonth);
			}
			else if(options[3].equals("Matrix")){
				ch.matrixChart(value,monthIntervals,firstMonth);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(panel, "There are no orders in those dates!", "Statistics", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	/**
	 * Calculates the date for the chart,calls the function to calculate statistics and calls the function of the chosen chart from class CreateChart for the seller
	 * @param seller
	 */
	public void SupplierStat(Seller seller){ 
		firstMonth = options[4];
		int years;
		int fromMonth = 0;
		int toMonth = 0;
		
		years = Integer.parseInt(options[7]) - Integer.parseInt(options[5]);
		for(int i = 0; i< 12; i++){
			if(options[4].equals(months[i])){
				fromMonth = i;						//checks which months is fromMonth and which month is toMonth and keeps the index
			}
			if(options[6].equals(months[i])){
				toMonth = i;
			}
		}

		if(years == 0){
			monthIntervals = toMonth - fromMonth;
		}
		else if(years > 0) {
				monthIntervals = toMonth - fromMonth + years*12; 		//calculates the month intervals
		}
		
		ArrayList <Order> orders = seller.getOrders().getOrders();
		calcSellerValue(orders, fromMonth, monthIntervals);
		
		for(int i = 0 ; i < value.size(); i++)
		{
			if(value.get(i) != 0.00)
			{
				orderExists = true;
			}
		}
		
		if(orderExists == true)
		{
			CreateChart ch = new CreateChart(months,options);
			
			if(options[3].equals("Pie Chart")){							//calls the function of the chosen chart from CreateChart class
				ch.pieChart(value,monthIntervals,firstMonth);
			}
			else if(options[3].equals("Line Chart")){
				ch.lineChart(value,monthIntervals,firstMonth);
			}
			else if(options[3].equals("Bar Chart")){
				ch.barChart(value,monthIntervals,firstMonth);
			}
			else if(options[3].equals("Matrix")){
				ch.matrixChart(value,monthIntervals,firstMonth);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(panel, "There are no orders in those dates!", "Statistics", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * calculates the value for the charts for the seller
	 *@param orders
	 *@param parserMonth
	 *@param numOfMonths
	 */
	private void calcSellerValue(ArrayList<Order> orders, int parserMonth, int numOfMonths){
		double sum = 0;
		String date = new String();
		int year;
		
		year = Integer.parseInt(options[5]);
		//for every month
		for(int j = 0; j < numOfMonths+1; j++)
		{
			sum = 0;
			//after sum = 0; there is a date update 
			if(parserMonth+1 != 12){					
				date += String.valueOf(year);
					if(parserMonth < 9){
						date += "-0";		//if month < 9 the input of the month is 0x,x for the number of the month
					}
					else {
						date += "-";
					}
					date +=  String.valueOf(parserMonth+1);
			}
			else if(parserMonth+1 == 12){		//if 12 the month is december must update year
				parserMonth = 0;
				year++;
				date += String.valueOf(year);
				date += "-0";
				date +=  String.valueOf(parserMonth+1);	
			}
			for(int i = 0; i < orders.size(); i++)
			{
				//checks if the first 7 letters of string are the same as date given by the supplier
				if(date.equals(orders.get(i).getDate().substring(0,7))){
					if(options[1].equals("Date")){			 //if filter = date
						
						
						if(options[0].equals("Profit")){					//if profit quantity*price if purchases quantity only
							sum += (orders.get(i).getTotalPrice()); 
						}
						else if(options[0].equals("Purchases")){
							sum += orders.get(i).getQuantity();
						}
					}
					else if(options[1].equals("Product")){		//if filter = product
						
						if(options[2].equals(orders.get(i).getProductId())){
							
							
							if(options[0].equals("Profit")){				//if profit quantity*price if purchases quantity only
								sum += (orders.get(i).getTotalPrice()); 
							}
							else if(options[0].equals("Purchases")){
								sum += orders.get(i).getQuantity();
							}
						}
					}
					else if(options[1].equals("Client")){ 		//if filter =client
						
						if(options[2].equals(orders.get(i).getOrderManagerId())){
							
							
							if(options[0].equals("Profit")){			//if profit quantity*price if purchases quantity only
								sum += (orders.get(i).getTotalPrice()); 
							}
							else if(options[0].equals("Purchases")){
								sum += orders.get(i).getQuantity();
							}
						}		
					}
				}
			}
			
			value.add(sum);
			parserMonth += 1;
			date = new String();
		}	
			
	}
	
	/**
	 * calculates the value for the charts for the ordermanager
	 *@param orders
	 *@param parserMonth
	 *@param numOfMonths
	 */
	private void calcOMValue(ArrayList<Order> orders, int parserMonth, int numOfMonths)
	{
		double sum = 0;
		String date = new String();
		int year;
		
		year = Integer.parseInt(options[5]);
		
		//for every month
		for(int j = 0; j < numOfMonths+1; j++)
		{
			sum = 0;
			//after sum = 0; there is a date update 
			if(parserMonth+1 != 12){					
				date += String.valueOf(year);
					if(parserMonth < 9){
						date += "-0";		//if month < 9 the input of the month is 0x,x for the number of the month
					}
					else {
						date += "-";
					}
					date +=  String.valueOf(parserMonth+1);
			}
			else if(parserMonth+1 == 12){		//if 12 the month is december must update year
				parserMonth = 0;
				year++;
				date += String.valueOf(year);
				date += "-0";
				date +=  String.valueOf(parserMonth+1);	
			}
			for(int i = 0; i < orders.size(); i++)
			{
				//checks if the first 7 letters of string are the same as date given by the supplier
				if(date.equals(orders.get(i).getDate().substring(0,7))){
					if(options[1].equals("Date")){			 //if filter = date

						//if profit quantity*price if purchases quantity only
						if(options[0].equals("Cost")){
							sum += (orders.get(i).getTotalPrice()); 
						
						}
						else if(options[0].equals("Orders")){
							sum += orders.get(i).getQuantity();
						}
					}
					else if(options[1].equals("Product")){		//if filter = product
						if(options[2].equals(orders.get(i).getProductId())){
							
							//if profit quantity*price if purchases quantity only
							if(options[0].equals("Cost")){
								sum += (orders.get(i).getTotalPrice()); 
								
							}
							else if(options[0].equals("Orders")){
								sum += orders.get(i).getQuantity();
								
							}
						}
					}
					else if(options[1].equals("Supplier")){ 		//if filter = supplier
						if(options[2].equals(orders.get(i).getSupplierId())){
							
							//if profit quantity*price if purchases quantity only
							if(options[0].equals("Cost")){
								sum += (orders.get(i).getTotalPrice());
							}
							else if(options[0].equals("Orders")){
								sum += orders.get(i).getQuantity();
							}
						}		
					}
				}
			}
			value.add(sum);
			parserMonth += 1;
			date = new String();
		}
		
	}	
}

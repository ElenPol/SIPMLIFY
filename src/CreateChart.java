import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * CreateChart.java
 * Purpose : Displays the selected chart with the calculated values
 * @author Fotiadou Vassiliki
 */
public class CreateChart extends JFrame{
	
	private String[] months;
	private String[] options;

	public CreateChart(String[] months, String[] options){
		this.months = months;
		this.options = options;
	}
	
	/**
	 * Creates and displays the line chart.
	 * @param value
	 * @param numOfMonths
	 * @param firstMonth
	 */
	public void lineChart(ArrayList<Double> value, int numOfMonths, String firstMonth){
		
		int monthC = 0;
		int year;
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		year = Integer.parseInt(options[5]);
		for(int i = 0;  i < months.length; i++){
			if(firstMonth.equals(months[i])){
				monthC = i;
			}
		}
		
		for(int i = 0; i <value.size(); i++){
			
			dataset.addValue(value.get(i), String.valueOf(year), months[monthC]);		//data input
			
			if(monthC == 11){
				monthC = 0;
				year++;
			}
			else{
				monthC++;
			}	
		}
		
		String title = new String() ;
		if(options[0].equals("Profit")){
			title = "Profit";
		}
		else if(options[0].equals("Purchases")){
			title = "Purchases";
		}
		else if(options[0].equals("Cost")){
			title = "Cost";
		}
		else if(options[0].equals("Orders")){
			title = "Orders";
		}															//set line chart title
		if(options[1].contentEquals("Product")){
			title += " For Product With ID : ";
			title += options[2];
		}
		else if(options[1].contentEquals("Client")){
			title += " For Client With ID : ";
			title += options[2];
		}
		else if(options[1].contentEquals("Supplier")){
			title += " For Supplier With ID : ";
			title += options[2];
		}
		//create line chart
		JFreeChart lineChart = ChartFactory.createLineChart( title,"Date", "Value",dataset);		
		ChartFrame frame = new ChartFrame("Line Chart", lineChart);
		URL resource = getClass().getClassLoader().getResource( "windowLogo.png" );	//window icon
	    	Image icon = Toolkit.getDefaultToolkit().getImage(resource);  
	    	frame.setIconImage(icon);
		frame.setVisible(true);
		frame.setSize(1041, 653);		
		
	}
	
	/**
	 * Creates and displays the matrix chart.
	 * @param value
	 * @param numOfMonths
	 * @param firstMonth
	 */
	public void matrixChart(ArrayList<Double> value, int numOfMonths, String firstMonth){
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(136, 177, 179));
		panel.setBounds(100, 100, 584, 534);
		panel.setLayout(null);
		
		int monthC = 0;
		String date;
		int year;
		int size = value.size();
		String[][] data = new String[size][2];
		String[] columns = new String[2];
				
		year = Integer.parseInt(options[5]);
		
		for(int i = 0;  i < months.length; i++){
			if(firstMonth.equals(months[i])){
				monthC = i;
			}
		}
		for(int i = 0; i <value.size(); i++){						//data input 
			
			date = String.valueOf(year);
			date += " ";
			date += months[monthC];
			data[i][0] = date;
			data[i][1] = String.valueOf(value.get(i));
			if(monthC == 11){
				monthC = 0;
				year++;
			}
			else{
				monthC++;
			}
		}
		String title = new String() ;
		if(options[0].equals("Profit")){
				title = "Profit";
			}
		else if(options[0].equals("Purchases")){
				title = "Purchases";
			}
		else if(options[0].equals("Cost")){
				title = "Cost";
			}
		else if(options[0].equals("Orders")){
				title = "Orders";
			}													//sets name columns	(title)	
		if(options[1].equals("Product")){
				title += " For Product With ID : ";
				title += options[2];
			}
		else if(options[1].equals("Client")){
				title += " For Client With ID : ";
				title += options[2];
			}
		else if(options[1].equals("Supplier")){
				title += " For Supplier With ID : ";
				title += options[2];
			}	
			columns[0] = "Date";
			columns[1] = title;
			
		//creates jtable	
		JTable table = new JTable();										
		table.setModel(new DefaultTableModel(data, columns));
		table.setBounds(30,40,200,300); 
		table.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		table.setBackground(new Color(136, 177, 179));
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane();    							
		scroll = new JScrollPane();
		scroll = new JScrollPane();
		scroll.setBounds(53, 37, 924, 552);
		panel.add(scroll);
		scroll.setViewportView(table);
		this.setBackground(new Color(136, 177, 179));
		this.setContentPane(panel);
		this.setVisible(true);
		this.setTitle("Matrix Chart");
		URL resource3 = getClass().getClassLoader().getResource( "windowLogo.png" );
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(resource3));
		this.setBounds(100, 100, 1041, 653);
		this.setResizable(false);
		
	}
	
	/**
	 * Creates and displays the bar chart.
	 * @param value
	 * @param numOfMonths
	 * @param firstMonth
	 */
	public void barChart(ArrayList<Double> value, int numOfMonths, String firstMonth){
		int monthC = 0;
		int year;
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		year = Integer.parseInt(options[5]);
		
		for(int i = 0;  i < months.length; i++){
			if(firstMonth.equals(months[i])){
				monthC = i;
			}
		}																//data input (value,date)
		for(int i = 0; i <value.size(); i++){
			dataset.addValue(value.get(i), months[monthC], String.valueOf(year) );
			if(monthC == 11){
				monthC = 0;
				year++;
			}
			else{
				monthC++;
			}
		}
		
		String title = new String() ;
		if(options[0].equals("Profit")){
			title = "Profit";
		}
		else if(options[0].equals("Purchases")){
			title = "Purchases";
		}
		else if(options[0].equals("Cost")){
			title = "Cost";
		}
		else if(options[0].equals("Orders")){
			title = "Orders";
		}															//sets bar chart title
		if(options[1].equals("Product")){
			title += " For Product With ID : ";
			title += options[2];
		}
		else if(options[1].equals("Client")){
			title += " For Client With ID : ";
			title += options[2];
		}
		else if(options[1].equals("Supplier")){
			title += " For Supplier With ID : ";
			title += options[2];
		}
		//creates bar chart
		JFreeChart chart = ChartFactory.createBarChart(title, "Year" , "Value", dataset, PlotOrientation.VERTICAL, true, true, false); 
		ChartFrame frame = new ChartFrame("Bar Chart ",chart);
		URL resource2 = getClass().getClassLoader().getResource( "windowLogo.png" );	//window icon
	    	Image icon = Toolkit.getDefaultToolkit().getImage(resource2);  
	    	frame.setIconImage(icon);
		frame.setVisible(true);
		frame.setSize(1041, 653);			
	}	
	
	/**
	 * Creates and displays the pie chart.
	 * @param value
	 * @param numOfMonths
	 * @param firstMonth
	 */
	public void pieChart(ArrayList<Double> value, int numOfMonths, String firstMonth){
		int monthC = 0;
		String date;
		int year;
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		year = Integer.parseInt(options[5]);
		
		for(int i = 0;  i < months.length; i++){
			if(firstMonth.equals(months[i])){
				monthC = i;
			}
		}																//data input (value,date)
		for(int i = 0; i <value.size(); i++){
			date = String.valueOf(year);
			date += " ";
			date += months[monthC];
			dataset.setValue(date , value.get(i));
			if(monthC == 11){
				monthC = 0;
				year++;
			}
			else{
				monthC++;
			}
		}
		
		String title = new String() ;
		if(options[0].equals("Profit")){
			title = "Profit";
		}
		else if(options[0].equals("Purchases")){
			title = "Purchases";
		}
		else if(options[0].equals("Cost")){
			title = "Cost";
		}
		else if(options[0].equals("Orders")){
			title = "Orders";
		}															//sets pie chart title
		if(options[1].equals("Product")){
			title += " For Product With ID : ";
			title += options[2];
		}
		else if(options[1].equals("Client")){
			title += " For Client With ID : ";
			title += options[2];
		}
		else if(options[1].equals("Supplier")){
			title += " For Supplier With ID : ";
			title += options[2];
		}
		//creates pie chart
		JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, true);
		ChartFrame frame = new ChartFrame("Pie Chart ",chart);
		URL resource2 = getClass().getClassLoader().getResource( "windowLogo.png" );	//window icon
	    	Image icon = Toolkit.getDefaultToolkit().getImage(resource2);  
	    	frame.setIconImage(icon);
		frame.setVisible(true);
		frame.setSize(1041, 653);		
	}	
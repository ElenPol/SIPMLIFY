import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

/**
 * ShowProduct.java
 * Purpose: The class is the GUI for showing a single Product, either SupplierProduct or CompanyProduct. Provides the function of editting the product
 * @author Polyzoidou Eleni, Gkouli Nikoleta
 */

public class ShowProduct {

	private JFrame frame;
	private JButton editButton;
	private JTextField textName;
	private JTextField textId;
	private JTextField textStockAmount;
	private JTextField textSafetyStock;
	private JTextField textMaxStockAmount;
	private JTextField textPrice;
	private JTextField textAverageMonthlyConsu;
	private JTextField textLeadTime;
	private JTextField textExpectedAmount;
	private JLabel labelId;
	private JLabel labelName;
	private JLabel labelStockAmount;
	private JLabel labelSafetyStock;
	private JLabel labelMaxStockAmount;
	private JLabel labelAverageMonthlyConsu;
	private JLabel labelPrice;
	private JLabel labelLeadTime;
	private JLabel labelExpectedAmount;
	private JSeparator firstSeparator;
	private JSeparator secondSeparator;
	private JSeparator thirdSeparator;
	private JSeparator fourthSeparator;
	private JSeparator fifthSeparator;
	private JSeparator sixthSeparator;
	private JSeparator seventhSeparator;
	private JButton saveButton;
	protected  User user;
	
	public ShowProduct( User u, SupplierProduct spl){
	
		OrderManager user = (OrderManager) u;
		frame = new JFrame();
		frame.setBounds(100, 100, 1041, 653);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBounds(new Rectangle(100, 100, 1041, 653));
		frame.getContentPane().setBackground(new Color(136, 177, 179));
		frame.setTitle("Supplier Product");
		frame.setResizable(false);
		
		URL resource2 = getClass().getClassLoader().getResource( "windowLogo.png" );
    		Image icon = Toolkit.getDefaultToolkit().getImage(resource2);  
    		frame.setIconImage(icon);
		
		labelName = new JLabel("Name :");									     	 	//label for Name
		labelName.setBounds(42, 31, 137, 36);
		labelName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelName);
		
		labelId = new JLabel("ID :");										       		//label for Id
		labelId.setBounds(42, 90, 113, 36);
		labelId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelId);
		
		labelStockAmount = new JLabel("Stock Amount :");					      		//label for StockAmount
		labelStockAmount.setBounds(42, 150, 173, 36);
		labelStockAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelStockAmount);
		
		labelMaxStockAmount = new JLabel("Max Stock Amount :");				      		//label for MaxStockAmount
		labelMaxStockAmount.setBounds(42, 216, 287, 36);
		labelMaxStockAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelMaxStockAmount);
		
		labelSafetyStock = new JLabel("Safety Stock :");					      		//label for SafetyStock
		labelSafetyStock.setBounds(42, 280, 195, 36);
		labelSafetyStock.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelSafetyStock);
		
		labelAverageMonthlyConsu = new JLabel("Average Monthly Consumption :");   		//label for AverageMontlhyConsumption
		labelAverageMonthlyConsu.setBounds(42, 348, 343, 36);
		labelAverageMonthlyConsu.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelAverageMonthlyConsu);
		
		labelLeadTime= new JLabel("Lead Time :");							     		//label for LeadTime
		labelLeadTime.setBounds(42, 420, 173, 34);
		labelLeadTime.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelLeadTime);
		
		labelExpectedAmount = new JLabel("Expected Amount :");                 			 //label for ExpectedAmount
		labelExpectedAmount.setBounds(37, 488, 216, 36);
		labelExpectedAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelExpectedAmount);
		
		
		textId = new JTextField(spl.getId());							 //textField for id attribute
		textId.setBounds(637, 90, 188, 36);
		textId.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		textId.setEditable(false);
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		
		textName = new JTextField(spl.getName());						//textField for name attribute
		textName.setBounds(637, 31, 188, 36);
		textName.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		textName.setEditable(false);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		
		textStockAmount = new JTextField(""+spl.getStockAmount());            			//textField for stockAmount attribute
		textStockAmount.setBounds(637, 150, 188, 36);
		textStockAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		textStockAmount.setEditable(false);									  			//the value can not be changed
		frame.getContentPane().add(textStockAmount);
		textStockAmount.setColumns(10);
		
		textMaxStockAmount = new JTextField(""+spl.getMaxStockAmount());     			//textField for maxStockAmount attribute
		textMaxStockAmount.setBounds(637, 217, 188, 36);
		textMaxStockAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		textMaxStockAmount.setEditable(false);							//the value can not be changed
		frame.getContentPane().add(textMaxStockAmount);
		textMaxStockAmount.setColumns(10);
		
		textSafetyStock = new JTextField(""+spl.getSafetyStock());					//textField for SafetyStock
		textSafetyStock.setBounds(637, 280, 188, 36);
		textSafetyStock.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		textSafetyStock.setEditable(false);												//the value can not be changed
		frame.getContentPane().add(textSafetyStock);
		textSafetyStock.setColumns(10);
		
		textAverageMonthlyConsu = new JTextField(""+spl.getAverageMonthlyConsumption());    	//textField for averageMonthlyConsumption attribute
		textAverageMonthlyConsu.setBounds(636, 351, 189, 34);
		textAverageMonthlyConsu.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		textAverageMonthlyConsu.setEditable(false);												//the value can not be changed
		frame.getContentPane().add(textAverageMonthlyConsu);
		textAverageMonthlyConsu.setColumns(10);
		
		textLeadTime= new JTextField(""+spl.getLeadtime());                				//textField for leadTime attribute
		textLeadTime.setBounds(637, 420, 189, 36);
		textLeadTime.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		textLeadTime.setEditable(false);												//the value can not be changed
		frame.getContentPane().add(textLeadTime);
		textLeadTime.setColumns(10);
		
		textExpectedAmount = new JTextField(""+spl.getExpectedAmount());				//textField for expectedAmount attribute
		textExpectedAmount.setBounds(637, 489, 189, 36);
		textExpectedAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,20));
		textExpectedAmount.setEditable(false);											//the value can not be changed
		frame.getContentPane().add(textExpectedAmount);
		textExpectedAmount.setColumns(10);
		
		firstSeparator = new JSeparator();
		firstSeparator.setBounds(10, 77, 1015,  2);
		frame.getContentPane().add(firstSeparator);
		
		secondSeparator = new JSeparator();
		secondSeparator.setBounds(10, 137, 1015, 2);
		frame.getContentPane().add(secondSeparator);
		
		thirdSeparator = new JSeparator();
		thirdSeparator.setBounds(10, 197, 1015, 2);
		frame.getContentPane().add(thirdSeparator);
		
		fourthSeparator = new JSeparator();
		fourthSeparator.setBounds(10, 267, 1015, 2);
		frame.getContentPane().add(fourthSeparator);
		
		fifthSeparator = new JSeparator();
		fifthSeparator.setBounds(10, 335, 1015, 2);
		frame.getContentPane().add(fifthSeparator);
		
		sixthSeparator = new JSeparator();
		sixthSeparator.setBounds(10, 407, 1015, 2);
		frame.getContentPane().add(sixthSeparator);
		
		seventhSeparator = new JSeparator();
		seventhSeparator.setBounds(10, 475, 1015, 2);
		frame.getContentPane().add(seventhSeparator);
		
		saveButton = new JButton(" Save");
		saveButton.setEnabled(false);
		
		editButton = new JButton("Edit Product");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    textStockAmount.setEditable(true);
			    textLeadTime.setEditable(true);       //enables stockAmount, LeadTime, ExpectedAmount textField to change
	            	    textExpectedAmount.setEditable(true);
	           	    saveButton.setEnabled(true);
			}
		});
		editButton.setBounds(147, 579, 166, 36);
		frame.getContentPane().add(editButton);
		

	
		saveButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				
				boolean flag = checkForError();
				if (! flag) {
					if (! textStockAmount.getText().equals("" + spl.getStockAmount())) {                //if textStockAmount has changed, set the new value to stockAmount attribute
						spl.setStockAmount(Double.parseDouble(textStockAmount.getText()));
					}
					textStockAmount.setText("" + spl.getStockAmount());
						
						
					if ( !textLeadTime.getText().equals("" + spl.getLeadtime())) {						 //if textLeadTime has changed, set the new value to leadTime attribute
						spl.setLeadtime(Integer.parseInt(textLeadTime.getText()));
					}
					textLeadTime.setText("" + spl.getLeadtime());
						
						
					if ( !textExpectedAmount.getText().equals("" + spl.getExpectedAmount())) {			 //if textExpectedAmount has changed, set the new value to expectedAmount attribute
						spl.setExpectedAmount(Double.parseDouble(textExpectedAmount.getText()));
					}
					textExpectedAmount.setText("" + spl.getExpectedAmount());
					
					int index = user.getProducts().getSupplierProducts().indexOf(spl);
					user.editProduct(spl, index);
					textStockAmount.setEditable(false);
					textLeadTime.setEditable(false);
			       		textExpectedAmount.setEditable(false);
			                saveButton.setEnabled(false);
					
					JOptionPane.showMessageDialog(null, "Changes have been saved!");
				}
			}});
			saveButton.setBounds(636, 579, 166, 36);
			frame.getContentPane().add(saveButton);
			frame.setVisible(true);
   }
		
    
	public ShowProduct(User iu, CompanyProduct cp){ 
		Seller user = (Seller) iu;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1041, 653);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBounds(new Rectangle(100, 100, 1041, 653));
		frame.getContentPane().setBackground(new Color(136, 177, 179));
		frame.setResizable(false);
		frame.setTitle("Company Product");
		
		labelId = new JLabel(" ID :");								//label for Id
		labelId.setBounds(153, 112, 153, 33);
		labelId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelId);
		
		labelName = new JLabel(" Name :");							//label for Name
		labelName.setBounds(153, 34, 86, 33);
		labelName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelName);
		
		labelSafetyStock = new JLabel(" Safety stock :");					//label for SafetyStock
		labelSafetyStock.setBounds(153, 193, 179, 33);
		labelSafetyStock.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelSafetyStock);
		
		labelStockAmount = new JLabel(" Stock amount :");					//label for StockAmount
		labelStockAmount.setBounds(153, 277, 179, 35);
		labelStockAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelStockAmount);
		
		labelMaxStockAmount = new JLabel(" Max stock amount :");				//label for MaxStockAmount
		labelMaxStockAmount.setBounds(153, 369, 224, 33);
		labelMaxStockAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelMaxStockAmount);
		
		labelPrice = new JLabel(" Price :");							//label for Price
		labelPrice.setBounds(153, 462, 164, 33);
		labelPrice.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelPrice);
		
	
		textId = new JTextField(cp.getId());							//text for id attribute
		textId.setBounds(707, 112, 153, 33);
		textId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		textId.setEditable(false);								//the value can not be changed
		
		
		textName = new JTextField(cp.getName());						//text for Name attribute
		textName.setBounds(707, 34, 153, 33);
		textName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		textName.setEditable(false);								//the value can not be changed

		textSafetyStock = new JTextField("" + cp.getSafetyStock());				//text for safetyStock attribute
		textSafetyStock.setBounds(707, 193, 153, 33);
		textSafetyStock.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textSafetyStock);
		textSafetyStock.setColumns(10);
		textSafetyStock.setEditable(false);							//the value can not be changed
		
		textStockAmount = new JTextField("" + cp.getStockAmount());				//text for stockAmount attribute
		textStockAmount.setBounds(707, 277, 153, 33);
		textStockAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textStockAmount);
		textStockAmount.setColumns(10);
		textStockAmount.setEditable(false);							//value can not be changed
		
		textMaxStockAmount = new JTextField("" + cp.getMaxStockAmount());			//text for maxStockAmount attribute
		textMaxStockAmount.setBounds(707, 369, 153, 33);
		textMaxStockAmount.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textMaxStockAmount);
		textMaxStockAmount.setColumns(10);
		textMaxStockAmount.setEditable(false);              					//value can not be changed
		
		textPrice = new JTextField("" + cp.getPrice());						//text for price attribute
		textPrice.setBounds(707, 462, 153, 32);
		textPrice.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(textPrice);
		textPrice.setColumns(10);
		textPrice.setEditable(false);								//value can not be changed 
		
		firstSeparator = new JSeparator();
		firstSeparator.setBounds(10, 88, 1015,  2);
		frame.getContentPane().add(firstSeparator);
		
		secondSeparator = new JSeparator();
		secondSeparator.setBounds(10, 168, 1015, 2);
		frame.getContentPane().add(secondSeparator);
		
		thirdSeparator = new JSeparator();
		thirdSeparator.setBounds(10, 250, 1015, 2);
		frame.getContentPane().add(thirdSeparator);
		
		fourthSeparator = new JSeparator();
		fourthSeparator.setBounds(10, 335, 1015, 2);
		frame.getContentPane().add(fourthSeparator);
		
		fifthSeparator = new JSeparator();
		fifthSeparator.setBounds(10, 425, 1015, 2);
		frame.getContentPane().add(fifthSeparator);
		
		saveButton = new JButton("Save");
		
		editButton = new JButton("Edit ");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//enable textfileds stockamount,price and get new numbers
				textStockAmount.setEditable(true);
				textPrice.setEditable(true);
				saveButton.setEnabled(true);
			}
		});
		editButton.setBounds(197, 580, 180, 33);
		frame.getContentPane().add(editButton);
		
		
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag = checkForError();
				if (! flag) {
					if (! textStockAmount.getText().equals("" + cp.getStockAmount()) && !textStockAmount.getText().equals("")) {                //if textStockAmount has changed, set the new value to stockAmount attribute
						cp.setStockAmount(Double.parseDouble(textStockAmount.getText()));
					}
					textStockAmount.setText("" + cp.getStockAmount());
						
						
					if ( !textPrice.getText().equals("" + cp.getPrice()) && !textPrice.getText().equals("")) {                          //if textPrice has changed, set the new value to price attribute
						cp.setPrice(Double.parseDouble(textPrice.getText()));
					}
					textPrice.setText("" + cp.getPrice());
					int index = user.getProducts().getCompanyProducts().indexOf(cp);
					user.getProducts().getCompanyProducts().set(index, cp);
					textStockAmount.setEditable(false);
			        	textPrice.setEditable(false);
			        	saveButton.setEnabled(false); 
					
					JOptionPane.showMessageDialog(null, "Changes have been saved!");
				}
			}
		});
		saveButton.setBounds(654, 580, 146, 33);
		frame.getContentPane().add(saveButton);
		frame.setVisible(true);
	}
		
	


	/**
	 * Checks for error in the editable text fields
	 * @return  true if there are not errors, else false.
	 */
	private boolean checkForError(){
		boolean flag = false;
		if ( frame.getContentPane().isAncestorOf(textPrice)) {                                           //frame contains textPrice, this means that we are checking for errors for a CompanyProduct
			if (Double.parseDouble(textStockAmount.getText()) > Double.parseDouble(textMaxStockAmount.getText())) {
				JOptionPane.showMessageDialog(frame, "StockAmount value can not be larger than MaxStockAmount value");
				flag = true;
			}
			if (textStockAmount.getText().equals("") && textPrice.getText().equals("")) {				 //if all fields are empty, show error Message
				JOptionPane.showMessageDialog(frame, "All fields are empty");                            
				flag = true;
			}else {
				if (!textStockAmount.getText().matches("[0-9]+|[0-9]+[.]{1}[0-9]+") || !textPrice.getText().matches("[0-9]+|[0-9]+[.]{1}[0-9]+")) {           //fields should match  regex for integer and double number
					JOptionPane.showMessageDialog(frame, "Fields must contain digit");
					flag = true;
				}
			}
			
		}else {		//frame contains textPrice, this means that we are checking for errors for a SupplierProduct
			if (Double.parseDouble(textStockAmount.getText()) > Double.parseDouble(textMaxStockAmount.getText())) {
				JOptionPane.showMessageDialog(frame, "StockAmount value can not be larger than MaxStockAmount value");
				flag = true;
			}
			if (textStockAmount.getText().equals("") && textExpectedAmount.getText().equals("") && textLeadTime.getText().equals("")) {          //if all fields are empty, show error Message
				JOptionPane.showMessageDialog(frame,"All fields are empty");
				flag = true;
			}
			else {
				if (!textStockAmount.getText().matches("[0-9]+|[0-9]+[.]{1}[0-9]+") || !textLeadTime.getText().matches("[0-9]+") || !textExpectedAmount.getText().matches("[0-9]+|[0-9]+[.]{1}[0-9]+") ) {	//fields should match  regex for integer and double number
					JOptionPane.showMessageDialog(frame, "Fields must contain digit");
					flag = true;
				}
			}
		}
		return flag;	
	}
}

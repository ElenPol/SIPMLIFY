import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;

/**
 * SelectionGui.java
 * Purpose : Creates the GUI for user to select the statictics he wishes to see.
 * @author Fotiadou Vassiliki
 */

public class SelectionGui extends JFrame
{
	private String[] options; /*options[0] variable,options[1] filter,options[2] key,options[3] chart,options[4] from month,options[5] from year,options[6] to month,options[7] to year*/	 
	private Boolean errorFlag; //false if there is no error else true
	private OrderManager om;
	private Seller seller;
	private String user;
	private String[] months;
	private JFrame f;
	private JLabel var;
	private JLabel filter;
	private JLabel key;
	private JLabel IdChar;
	private JLabel chart;
	private JLabel from;
	private JLabel to;
	private JLabel message;
	private JLabel enterYear; 
	private JTextField yearTo;
	private JTextField Ekey;
	private JTextField yearFrom;
	private JComboBox<String> chartCb;
	private JComboBox<String> fromMonth;
	private JComboBox<String> toMonth;
	private JComboBox<String> varCb;
	private JComboBox<String> filterCb;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JButton b;
	
	public SelectionGui(OrderManager om){	
		this.om = om;
		user = "om";
		errorFlag = false;
		options = new String[8];
		months = new String [12];
		months[0] = "January";
		months[1] = "February";
		months[2] = "March";
		months[3] = "April";
		months[4] = "May";
		months[5] = "June";
		months[6] = "July";
		months[7] = "August";
		months[8] = "September";
		months[9] = "October";
		months[10] = "November";
		months[11] = "December";
	}

	public SelectionGui(Seller seller){	
		this.seller = seller;
		user = "seller";
		errorFlag = false;
		options = new String[8];
		months = new String [12];
		months[0] = "January";
		months[1] = "February";
		months[2] = "March";
		months[3] = "April";
		months[4] = "May";
		months[5] = "June";
		months[6] = "July";
		months[7] = "August";
		months[8] = "September";
		months[9] = "October";
		months[10] = "November";
		months[11] = "December";		
	}

	/**
	 * Creates GUI for options and calls the respective function from statistics class 
	 * if there is no error in the filled form
	 * */
	public void initialize() 
	{
		/*common gui*/
		String charts[] = {"","Pie Chart","Line Chart","Bar Chart","Matrix"};      //chart JComboBox data
		
		f = new JFrame();
		f.getContentPane().setBackground(new Color(136, 177, 179));
		
		URL resource2 = getClass().getClassLoader().getResource( "windowLogo.png" );	//window logo
    	Image icon = Toolkit.getDefaultToolkit().getImage(resource2);  
    	f.setIconImage(icon);
		
		var = new JLabel("Choose Variable :"); 
		var.setBounds(197, 45, 196, 30);											//variable JLabel
		var.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
		f.getContentPane().add(var);
		 
	   	filter = new JLabel("Choose Filter :");
	   	filter.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));					//filter JLabel
	   	filter.setBounds(197, 144, 196, 30);
		f.getContentPane().add(filter);
		

		key = new JLabel("Enter ID :");
		key.setBounds(197, 243, 196, 30);
		key.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));					//key(id) JLabel
		f.getContentPane().add(key);
		
		Ekey = new JTextField();
		Ekey.setBounds(504, 250, 264, 30);											//key(id) JTextField
		f.getContentPane().add(Ekey);
		
		IdChar = new JLabel("(6 characters)");
		IdChar.setFont(new Font("Helvetica Neue", Font.PLAIN, 10));					//id has to be 6 characters
		IdChar.setBounds(504, 282, 85, 13);
		f.getContentPane().add(IdChar);
		
		chart = new JLabel("Choose Chart : ");
		chart.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));					//chart JLabel
		chart.setBounds(197, 361, 196, 30);
		f.getContentPane().add(chart);
		
		chartCb = new JComboBox<String>(charts);
		chartCb.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));				//chart JComboBox input
		chartCb.setBounds(504, 367, 264, 30);
		f.getContentPane().add(chartCb);
		
	    from = new JLabel("From :");
	    from.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));      				//from month JLabel
	    from.setBounds(197, 470, 107, 26);
		f.getContentPane().add(from);
		
		fromMonth = new JComboBox<String>(months);
		fromMonth.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));   			//from month JComboBox
		fromMonth.setBounds(399, 476, 150, 26);
		f.getContentPane().add(fromMonth);
		
		to = new JLabel("To :");
		to.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));						//to month JLabel
		to.setBounds(197, 526, 46, 30);
		f.getContentPane().add(to);
		
		toMonth = new JComboBox<String>(months);
		toMonth.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));				//to month JComboBox
		toMonth.setBounds(399, 534, 150, 26);
		f.getContentPane().add(toMonth);
		
		enterYear = new JLabel("Enter Year :");
		setFont(new Font("Helvetica Neue", Font.PLAIN, 15));						//enter yearJLabel
		enterYear.setBounds(640, 449, 128, 20);
		f.getContentPane().add(enterYear);
	
		yearFrom = new JTextField();
		yearFrom.setBounds(604, 480, 164, 20);										//enter year "From" JTextfield
		f.getContentPane().add(yearFrom);
		yearFrom.setColumns(10);
		
		yearTo = new JTextField();
		yearTo.setColumns(10);
		yearTo.setBounds(604, 538, 164, 20);										//enter year "To" JTextfield
		f.getContentPane().add(yearTo);
		
		separator = new JSeparator();
		separator.setBounds(8, 106, 1007, 2);
		f.getContentPane().add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(8, 214, 1007, 2);
		f.getContentPane().add(separator_1);										//seperators
		
		separator_2 = new JSeparator();
		separator_2.setBounds(10, 318, 1007, 2);
		f.getContentPane().add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(8, 437, 1007, 2);
		f.getContentPane().add(separator_3);
		
		b = new JButton("Ok");
		b.setBounds(915, 573, 85, 21); 												//button
		f.getContentPane().add(b);
		
		if(user.equals("om")){					//if user is OrderManager
			
			String OMvariables[] = {"","Cost","Orders"};
			String OMfilter[] = {"","Date","Supplier","Product"};						//JComboBox data for OrderManager
			
			varCb = new JComboBox<String>(OMvariables);
			varCb.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));					//variable JComboBox Input
			varCb.setBounds(504, 45, 264, 30);    
		    f.getContentPane().add(varCb);  
		    
			filterCb = new JComboBox<String>(OMfilter);
			filterCb.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));				//filter JComboBox Input
			filterCb.setBounds(504, 144, 264, 30);
			f.getContentPane().add(filterCb);
			
			message = new JLabel("Enter ID only if chosen filter is product or supplier");
			message.setBounds(504, 236,300, 14);									//key GUI(filled only if chosen filter = product or supplier
			message.setFont(new Font("Helvetica Neue", Font.PLAIN, 10));
			f.getContentPane().add(message);
		
			
			b.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					options[0] = (String) varCb.getSelectedItem();
					options[1] =(String) filterCb.getSelectedItem();
					options[2] = Ekey.getText();					
					options[3] = (String) chartCb.getSelectedItem();						//gets selected options
					options[4] = (String) fromMonth.getSelectedItem();
					options[5] = yearFrom.getText();
					options[6] = (String) toMonth.getSelectedItem();
					options[7] = yearTo.getText();
					
					errorFlag = checkError(options); //calls checkError before calling respective function

					if(!errorFlag) {    					 //if errorFlag = false there is no error, calls respective function
						
						Statistics ord = new Statistics(options,months);
						ord.OrdererStat(om);
					}
				}
					
			});
		}
		else if(user.equals("seller")){									//if user is a Seller
			
			String Svariables[] = {"","Profit","Purchases"};			//JComboBox Data for Seller
			String Sfilter[] = {"","Date","Client","Product"};
			
			varCb = new JComboBox<String>(Svariables);
			varCb.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));			//variable JComboBox Input
			varCb.setBounds(504, 45, 264, 30);    
		   	f.getContentPane().add(varCb);  
		    
			filterCb = new JComboBox<String>(Sfilter);
			filterCb.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));		//filter JComboBox Input
			filterCb.setBounds(504, 144, 264, 30);
			f.getContentPane().add(filterCb);
			
			message = new JLabel("Enter ID only if chosen filter is product or supplier");
			message.setBounds(504, 236,300, 14);
			message.setFont(new Font("Helvetica Neue", Font.PLAIN, 10));
			f.getContentPane().add(message);
			
			b.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					
					options[0] = (String) varCb.getSelectedItem();
					options[1] =(String) filterCb.getSelectedItem();
					options[2] = Ekey.getText();
					options[3] = (String) chartCb.getSelectedItem();
					options[4] = (String) fromMonth.getSelectedItem();				//gets selected options
					options[5] = yearFrom.getText();
					options[6] = (String) toMonth.getSelectedItem();
					options[7] = yearTo.getText();
					
					errorFlag = checkError(options);     //calls checkError before calling respective function
					
					if(!errorFlag){									//if errorFlag = false there is no error, calls respective function
						
						Statistics sup = new Statistics(options, months);
						sup.SupplierStat(seller);	
					}		
				}
			});
		}
		f.setBounds(100, 100, 1041, 653);
		f.setTitle("Statistics");
		f.setLayout(null); 
		f.setVisible(true);
	}
	
		/**
		 * checks if there is an error in filled selection form 
		 *@param options
		 */
		private boolean checkError(String[] options){
			
			int fromMonth = 0;
			int toMonth = 0;
			boolean keyExists = false; //true if key(id) of options[3] input exists in database
			
			if(options[0].isEmpty()){		//checks variable input
				errorFlag = true;
				JOptionPane.showMessageDialog(null, "Variable Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			}
					
			if(options[1].isEmpty())
			{		//checks filter input
				errorFlag = true;
				JOptionPane.showMessageDialog(null, "Filter Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if(!options[1].equals("Date"))
				{ 	//checks key input
					if(options[2].isEmpty()){
						errorFlag = true;
						JOptionPane.showMessageDialog(null, "Key Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						if(options[2].length() != 6){			//checks if id is 6 characters
							errorFlag = true;
							JOptionPane.showMessageDialog(null, "Key Field Must Be 6 Characters", "Invalid Input",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
						    if((options[1].equals("Product") && (user.equals("om"))))
						    {
						    		 
							    	ArrayList<SupplierProduct> sProd = new ArrayList<>(om.getProducts().getSupplierProducts());
							    	int i = 0;
									while((i  < sProd.size()) && !keyExists){
							    		if(options[2].equals(sProd.get(i).getId())){
							    			keyExists = true;
							    		}
							    		i++;
							    	}
						    	 }
						    	 else if (options[1].equals("Supplier"))
						    	 {
						    		 
						    		 ArrayList <Supplier> supplier = new ArrayList<>(om.getSuppliers().getSuppliers());
						    		 int i = 0;
						    		 while( (i < supplier.size()) && !keyExists){
						    			 if(options[2].equals(supplier.get(i).getId()))
						    			 {
						    				 keyExists = true;
						    			 }
						    			 i++;
						    		 }
						    	 }
						    	 if((options[1].equals("Product") && (user.equals("seller")))) 
						    	 {
						    		 
							    	ArrayList<CompanyProduct> cProd = new ArrayList<>(seller.getProducts().getCompanyProducts());
							    	int i = 0;
							    	while((i < cProd.size()) && !keyExists){
							    		
							    		if(options[2].equals(cProd.get(i).getId())){
							    			keyExists = true;
							    		}
							    	}																		
						    	 }
						    	 else if (options[1].equals("Client")) 
						    	 {
						    		 
						    		 ArrayList <Buyer> buyer = new ArrayList<>(seller.getBuyers().getBuyers());
						    		 int i = 0;
						    		 while((i < buyer.size()) && !keyExists){
						    			 
						    			 if(options[2].equals(buyer.get(i).getId())){
						    				 
						    				 keyExists = true;
						    			 }
						    			 i++;
						    		 }
						    	 }
						     }
						     
						    
						}
					if((keyExists == false)){		//if keyExists = false id doesn't exist in database
				    	 errorFlag = true;
				    	 JOptionPane.showMessageDialog(null, "Key ID doesn't exist.", "Invalid Input",JOptionPane.ERROR_MESSAGE);		
				     }
					}	
					
				}
				
		     if(options[3].isEmpty()){			//checks chart input
				errorFlag = true;
				JOptionPane.showMessageDialog(null, "Chart Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);		
			}
		     
		     if(options[5].isEmpty()){			//checks year From input
		    	 JOptionPane.showMessageDialog(null, "Enter Year From Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
		     }
		     
		     if(options[7].isEmpty()){			//checks year to input
		    	 JOptionPane.showMessageDialog(null, "Enter Year To Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
		     }
		     if(options[5].compareTo(options[7]) > 0){		//checks if from year < to year
		    	 JOptionPane.showMessageDialog(null, "Wrong Year Input.\"From Year\" Later Than \"To Year\"", "Invalid Input",JOptionPane.ERROR_MESSAGE);
		     }
		     
		     if(options[5].compareTo(options[7])== 0){
				for(int i = 0; i< 12; i++){
					if(options[4].equals(months[i])){
						fromMonth = i;									//if (from year) == (to year) keeps the intex from 'fromMonth' and 'toMonth'to check if the date input is valid 
					}
					if(options[6].equals(months[i])){
						toMonth = i;
					}
				}
				
				if(fromMonth > toMonth){	
					errorFlag = true;
					JOptionPane.showMessageDialog(null,"Wrong Year Input.\"From Month\" Later Than \"To Month\"", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				}
				else if((fromMonth == toMonth) || ((toMonth - fromMonth) < 2)){		//at least two months apart to display statistics
					errorFlag = true;
					JOptionPane.showMessageDialog(null,"For the same year,month period must be at least two months apart", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				}
			}
			 
			if(!options[5].isEmpty()){		 //checks if year inputs are correct
				if(((Integer.parseInt(options[5])) < 2010) || (Integer.parseInt(options[5])) > 2040){
					errorFlag = true;
					JOptionPane.showMessageDialog(null,"Wrong \"From Year\"  input", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				}
			}
			
			if(!options[7].isEmpty()){
				if(((Integer.parseInt(options[7])) < 2010) || (Integer.parseInt(options[7])) > 2040){
					errorFlag = true;
					JOptionPane.showMessageDialog(null,"Wrong \"To Year\"  input", "Invalid Input",JOptionPane.ERROR_MESSAGE);
				}
			}
			return errorFlag;
		}				
}

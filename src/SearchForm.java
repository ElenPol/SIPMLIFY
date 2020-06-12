import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
/**
 * SearchForm.java
 * Purpose: Shows a GUI for searching .
 * @author Evangelia Papagiannaki.
 */
public class SearchForm extends JFrame{

	private JButton searchButton;
	private JLabel keyLabel;
	private JLabel chooseLabel;
	private JTextField key ;
	private User user ;
	private JList<String> list = new JList<String>(); 
	private ArrayList<String> slist = new ArrayList<String>();
	private DefaultListModel<String> model= new DefaultListModel<String>();
	
	public SearchForm(int type,User u){
		
		user = u;
		
		if (type == 1) {                    //sets the strings that are needed for searching an order
			slist.add("Order Id  ");
			slist.add("Supplier Id  ");
			slist.add("Product Id  ");
			slist.add("Product Name ");
			slist.add("Date  ");
			slist.add("Status");
		}else if (type == 2) {			//sets the strings that are needed for searching a SupplierProduct/CompanyProduct
			slist.add("Product Id");
			slist.add("Product Name");
			if (user instanceof OrderManager) {
				slist.add("Supplier Id");
			}
		}else {
			slist.add("Id ");			//sets the strings that are needed for searching a Buyer/Supplier
			slist.add("Name");
			slist.add("Last Name ");
			slist.add("AFM");
		}
		
		list.setModel(model);
		for(String s: slist) {
			model.addElement(s);
		}
		
		
		URL resource3 = getClass().getClassLoader().getResource( "windowLogo.png" );
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(resource3));
		
		chooseLabel = new JLabel("Choose Field");                                          
		chooseLabel.setFont(new Font("ÇelveticaNeue", Font.BOLD, 17));
		chooseLabel.setBounds(246, 141, 175, 41);
		this.getContentPane().add(chooseLabel);
		
		
		list.setFont(new Font("ÇelveticaNeue", Font.PLAIN, 15));
		list.setBounds(493, 61, 213, 167);
		list.setSelectionBackground(new Color(255, 152, 61));
		this.getContentPane().add(list);
		
		
		keyLabel = new JLabel("Enter an input value ");
		keyLabel.setFont(new Font("ÇelveticaNeue", Font.BOLD, 17));
		keyLabel.setBounds(246, 390, 181, 41);
		this.getContentPane().add(keyLabel);
		
		
		key = new JTextField("Type the text",20);
		key.setFont(new Font("ÇelveticaNeue",Font.PLAIN,15));
		key.setBounds(493, 396, 265, 25);
		key.setColumns(10);
		this.getContentPane().add(key);
		
		
		searchButton =  new JButton("Search");
		searchButton.setFont(new Font("ÇelveticaNeue", Font.PLAIN, 17));
		searchButton.setBounds(852, 573, 164, 30);
		this.getContentPane().add(searchButton);
		
		
		
		
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				boolean flag = checkForError();
				if (flag == false ) {	// if there are not errors in the form
					System.out.println(222);
					if (user instanceof OrderManager)  {                                   // if user is OrderManager
						OrderManager u = (OrderManager) user;
						if (type==1) {                                                    //searching for an Order
							u.searchForOrder(key.getText(),list.getSelectedIndex());
						} 
						else if (type==2) {                                               //searching for a SupplierProduct
							u.searchForProduct(key.getText(), list.getSelectedIndex());
						}
						else {                                                            //searching for a Supplier
							u.searchForSupplier(key.getText(),list.getSelectedIndex());
						}
					}
					else if (user instanceof Stockkeeper) {                               // if user is Stockkeeper
						Stockkeeper u = (Stockkeeper) user;
						if (type==1) {						                              // searching for an Order
							u.searchForOrder(key.getText(),list.getSelectedIndex());
						} 
					}
					else if (user instanceof Seller){                                    // if user is Seller 
						Seller u = (Seller) user;
						if (type==1){                                                    // searching for an Order
							u.searchForOrder(key.getText(),list.getSelectedIndex());
						} 
						else if (type==2) {                                              //searching for a CompanyProduct
							u.searchForProduct(key.getText(), list.getSelectedIndex());
						}
					}
				}
			}	
		});
		this.add(new JSeparator(SwingConstants.VERTICAL));
		this.getContentPane().setBackground(new Color(136, 177, 179));
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.setTitle("SearchForm");
		this.setBounds(100, 100, 1041, 653);
	
	}
	/*
	 * checks if there are any errors
	*/
	private boolean checkForError()
	{
		boolean flag = false;
		if(list.getSelectedIndex()==-1){                                                                                
			JOptionPane.showMessageDialog(this,"No field choosen");
			flag = true;
		}                                                                     
		if (key.getText().equals("Type the text") || key.getText().equals("")){                                     // if the key field does not have the correct input
			JOptionPane.showMessageDialog(this,"Invalid input in key field");
			flag = true;
		}                                                                                                         
		else if (list.getSelectedIndex() == 0 && (key.getText().length() != 6)) {                                      //if the user selected the first field from the list and key field does not have 6 characters
			JOptionPane.showMessageDialog(this,"Invalid input in key field.");	
			flag = true;
		}
		else if (list.getSelectedIndex() == 4 ) {                                                                     //if the user selected the fifth field from the field 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);
			if (sdf.parse(key.getText(), new ParsePosition(0)) == null) {                                             //if key field does not have the correct format for date
			    JOptionPane.showMessageDialog(this,"Invalid input in key field."); 
			    flag = true;
			}
		}
		else if (list.getSelectedIndex() == 5 &&( key.getText().length() != 1 || key.getText().matches("[0-4]{1}") == false)) {     //if sixth field was choosen from the list and key field length does not have 1 character or contain digits other than [0-4].	
			JOptionPane.showMessageDialog(this,"Invalid input in key field.");
			flag = true;
		}
		                                                                                                                                                                                               
		return flag;
	}
}
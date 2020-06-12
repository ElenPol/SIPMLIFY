import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;


/**
 * OrderForm.java
 * Purpose :  Creates the GUI for the Order Form and adds an order if there is no error in the filled fields. 
 * @author Manoli Christina
 */


public class OrderForm extends JFrame{
	
	private JPanel panel;
	private JButton btnAdd;
	private JLabel lblorderid;
	private JLabel lblSupplierid;
	private JLabel lblProductId;
	private JLabel lblQuantity ;
	private JTextField textFieldOid;
	private JTextField textFieldSid;
	private JTextField textFieldPid;
	private JTextField textFieldQ;
	private JTextField textFieldStKid;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JLabel lblStockkeeperId;
	
	
	public OrderForm(OrderManager om)
	{
		this.setTitle("Order Form");
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(136, 177, 179));

		URL resource3 = getClass().getClassLoader().getResource( "windowLogo.png" );
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(resource3));
		
		lblorderid = new JLabel("Order ID :");
		lblorderid.setBounds(207, 93, 157, 41);
		lblorderid.setFont(new Font("HelveticaNeue", Font.PLAIN, 24));
		
		lblSupplierid = new JLabel("Supplier ID:");
		lblSupplierid.setBounds(207, 194, 157, 41);
		lblSupplierid.setFont(new Font("HelveticaNeue", Font.PLAIN, 24));
		
		lblProductId = new JLabel("Product ID :");
		lblProductId.setBounds(207, 293, 157, 33);
		lblProductId.setFont(new Font("HelveticaNeue", Font.PLAIN, 24));
		
		lblQuantity = new JLabel("Quantity : ");
		lblQuantity.setBounds(207, 463, 121, 41);
		lblQuantity.setFont(new Font("HelveticaNeue", Font.PLAIN, 24));
		
		
		textFieldOid = new JTextField();
		textFieldOid.setToolTipText("Insert the Order ID you want");
		textFieldOid.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		textFieldOid.setBounds(533, 98, 247, 36);
		textFieldOid.setColumns(10);
		
		textFieldSid = new JTextField();
		textFieldSid.setToolTipText("Insert the Supplier ID you want");
		textFieldSid.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		textFieldSid.setBounds(533, 201, 247, 34);
		textFieldSid.setColumns(10);
		
		textFieldPid = new JTextField();
		textFieldPid.setToolTipText("Insert the Product ID you want");
		textFieldPid.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		textFieldPid.setBounds(533, 293, 247, 33);
		textFieldPid.setColumns(10);
		
		textFieldQ = new JTextField();
		textFieldQ.setToolTipText("Insert the Quantity you want");
		textFieldQ.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		textFieldQ.setBounds(533, 470, 247, 34);
		panel.add(textFieldQ);
		textFieldQ.setColumns(10);
		
		panel.setLayout(null);
		panel.add(lblorderid);
		panel.add(textFieldOid);
		panel.add(lblSupplierid);
		panel.add(textFieldSid);
		panel.add(lblProductId);
		panel.add(lblQuantity);
		panel.add(textFieldPid);
		panel.add(textFieldQ);
		
		btnAdd = new JButton("Add");
		btnAdd.setToolTipText("Add this new order");
		btnAdd.setFont(new Font("HelveticaNeue", Font.PLAIN, 17));
		btnAdd.setBounds(909, 572, 116, 41);
		panel.add(btnAdd);
		
		separator = new JSeparator();
		separator.setBounds(10, 172, 1015, 2);
		panel.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 265, 1015, 2);
		panel.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(10, 354, 1015, 2);
		panel.add(separator_2);

		separator_3 = new JSeparator();
		separator_3.setBounds(10, 450, 1015, 2);
		panel.add(separator_3);
		
		lblStockkeeperId = new JLabel("Stockkeeper ID :");
		lblStockkeeperId.setFont(new Font("HelveticaNeue", Font.PLAIN, 24));
		lblStockkeeperId.setBounds(207, 383, 201, 41);
		panel.add(lblStockkeeperId);
		
		textFieldStKid = new JTextField();
		textFieldStKid.setToolTipText("Insert the StockKeeper ID you want");
		textFieldStKid.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		textFieldStKid.setColumns(10);
		textFieldStKid.setBounds(533, 383, 247, 35);
		panel.add(textFieldStKid);
		
		btnAdd.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				//creating an order
				Order order = new Order();

				//having checked for errors
				if (checkForError(om))
				{
					//fill Order Manager Id
					order.setOrderManagerId(om.id);
					
					//fill Order Id
					order.setOrderId(textFieldOid.getText());; 			
					
					//fill Stockkeeper Id
					order.setStockkeeperId(textFieldStKid.getText());
					
					
					//fill  Quantity
					double Value = Double.parseDouble(textFieldQ.getText());
					order.setQuantity(Value);								
					
					
					//fill Supplier Id
					order.setSupplierId(textFieldSid.getText());
					
					for (Supplier s : om.getSuppliers().getSuppliers())		
					{
						//According to the given Supplier Id
						if (order.getSupplierId().equals(s.getId()))		
						{
							//fill Supplier Name
							order.setSupplierName(s.getName());
							
							//fill Supplier AFM
							order.setSupplierAFM(s.getAFM());
						}
					}
					
					//get today's date in the preferable format
					SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date(System.currentTimeMillis());
					//fill Date
					order.setDate(formatter.format(date));
					
					//fill status
					order.setStatus(1);
					
					//fill Product Id
					order.setProductId(textFieldPid.getText());
					
					for (SupplierProduct sp : om.getProducts().getSupplierProducts())	
					{
						//According to the given Product Id
						if (order.getProductId().equals(sp.getId()))
							//fill Product Name
							order.setProductName(sp.getName());
					}
					
					for(Suppl spl : om.getSupplies().getSupplies())
					{
						//According to the given Supplier Id and the given Product Id
						if(spl.getSupplierId().equals(order.getSupplierId()) && (spl.getProductId().equals(order.getProductId())))
							//fill Price
							order.setPrice(spl.getPrice());
					}
					
					//fill total price
					order.setTotalPrice(order.getPrice() * order.getQuantity());
				
					om.addOrder(order);
					JOptionPane.showMessageDialog(panel, "The order has been saved", "Order", JOptionPane.INFORMATION_MESSAGE);
				}
			}	
		});
		this.setVisible(true);
		this.getContentPane().add(panel);
		this.setResizable(false);
		this.setBounds(100, 100, 1041, 653);
	}
	
	
	/**
	 * Purpose : checks if there are any errors 
	 * @param om   a specific order manager
	 */
	private boolean checkForError(OrderManager om) {
		Component f = null;
		int i=0;
		
		
		if (textFieldOid.getText()!=null && textFieldSid.getText()!=null && textFieldPid.getText()!=null && textFieldStKid.getText()!=null)   //checking if the text fields aren't empty.
		{
			if (om.getOrders().getOrders().size()==0) i++;
			for (Order o : om.getOrders().getOrders())		
			{
				if (!textFieldOid.getText().equals(o.getOrderId())) i++;       //checking if the order id that was given doesn't already exist.
			}
			
			for (Supplier s : om.getSuppliers().getSuppliers())		
			{
				if (textFieldSid.getText().equals(s.getId())) i++;    			//checking if the supplier id that was given exists.
			}
			
			for (SupplierProduct sp : om.getProducts().getSupplierProducts())	
			{
				if (textFieldPid.getText().equals(sp.getId()))i++;				//checking if the product id that was given exists.

			}
			
			for(Suppl spl : om.getSupplies().getSupplies())
			{
				if(spl.getSupplierId().equals(textFieldSid.getText()) && (spl.getProductId().equals(textFieldPid.getText()))) i++;
			}
			
			//In order to check if the stock keeper id that was given actually exists we will have to extract the users from the database 
			Users us = new Users();
			us.extractObjectDB();
			for (User u : us.getUsers())
			{
				
				if (u.getId().contains("ST"))								//then we check which ones are stock keepers
				{
					
					if(u.id.equals(textFieldStKid.getText()))				//and we proceed to check if the given id matches one of the existing ids
					{
						
						if(u.getCompany().equals(om.getCompany())) i++;		//if it does exist then we check if this stock keeper is in the same company as the order manager
					}
				}
			}
		
		}
		
		if (isNumeric(textFieldQ.getText())) 						//checking if the quantity that was given isn't empty and is a double positive number.

		{
			if (Double.parseDouble(textFieldQ.getText())>0) i++;	//checking if the quantity that was given is a positive number.
		}

		if(i==6) return true; 										//if it passes all the checks then return true.
		else
		{
			JOptionPane.showMessageDialog(f, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	/**
	 * Purpose : Checks if the strnum isn't empty and is a double positive number.
	 * @param strnum     a string that is given
	 */
	private static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 * ProductForm.java
 * Purpose :  Creates the GUI for the Product Form and adds a product (supplierproduct or companyproduct) if there is no error in the filled fields. 
 * @author Fotiadou Vassiliki
 */
public class ProductForm extends JFrame{
	
	private JFrame frame;
	private User user; 
	private boolean errorFlag; //false if there are no errors else true

	
		public ProductForm(User user){
		this.user = user;
		
		JFrame frame = new JFrame();  
		frame.getContentPane().setBackground(new Color(136, 177, 179));
		frame.setBounds(100,100,1041, 653);
		
		URL resource2 = getClass().getClassLoader().getResource( "windowLogo.png" );	//window logo
    		Image icon = Toolkit.getDefaultToolkit().getImage(resource2);  
    		frame.setIconImage(icon);
    	
		JLabel nameLabel = new JLabel("Product Name :");
		nameLabel.setFont(new Font("Helvetica Neue", Font.PLAIN,20));			//name field and textfield
		nameLabel.setBounds(37, 56, 147, 21);
		frame.getContentPane().add(nameLabel);
					
		JTextField nameTXT = new JTextField();
		nameTXT.setBounds(205, 57, 191, 27);
		frame.getContentPane().add(nameTXT);
		nameTXT.setColumns(10);
		
		JLabel idLabel = new JLabel("Product  ID :");
		idLabel.setFont(new Font("Helvetica Neue", Font.PLAIN,20));				//id field ,textfield and 6 characters label
		idLabel.setBounds(562, 56, 139, 21);
		frame.getContentPane().add(idLabel);
		
		JTextField idTXT = new JTextField();
		idTXT.setColumns(10);
		idTXT.setBounds(763, 57, 191, 27);
		frame.getContentPane().add(idTXT);
		
		JLabel idMaxCharacters = new JLabel("(6 characters)");
		idMaxCharacters.setFont(new Font("Helvetica Neue", Font.PLAIN, 10));
		idMaxCharacters.setBounds(562, 65, 70, 30);
		frame.getContentPane().add(idMaxCharacters);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 132, 1017, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 297, 1017, 2);								//Separators
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 460, 1017, 2);
		frame.getContentPane().add(separator_2);
		
		JButton addButton = new JButton("Add");			
		addButton.setFont(new Font("Helvetic Neue", Font.PLAIN, 15));			//add button
		addButton.setBounds(936, 583, 78, 21);
		frame.getContentPane().add(addButton);

		if(user instanceof OrderManager ){
			
			OrderManager om = (OrderManager) user ;
			
			JLabel stockAmLabel = new JLabel("Stock Amount :");
			stockAmLabel.setFont(new Font("Helvetic Neue", Font.PLAIN,20));		//stock amount field and textfield
			stockAmLabel.setBounds(37, 197, 147, 21);
			frame.getContentPane().add(stockAmLabel);
			
			JTextField stockTXT = new JTextField();
			stockTXT.setColumns(10);
			stockTXT.setBounds(205, 198, 191, 27);
			frame.getContentPane().add(stockTXT);
			
			JLabel maxStockLabel = new JLabel("MaxStock Amount :");
			maxStockLabel.setFont(new Font("Helvetic Neue", Font.PLAIN,20));	//max stock amount field and textfield
			maxStockLabel.setBounds(562, 197, 178, 21);
			frame.getContentPane().add(maxStockLabel);
			
			JTextField maxStockTXT = new JTextField();
			maxStockTXT.setColumns(10);
			maxStockTXT.setBounds(763, 198, 191, 27);
			frame.getContentPane().add(maxStockTXT);
			
			JLabel safetyLabel = new JLabel("Safety Stock : ");
			safetyLabel.setFont(new Font("Helvetic Neue", Font.PLAIN,20));		//safety stock field and textfield
			safetyLabel.setBounds(37, 363, 147, 21);
			frame.getContentPane().add(safetyLabel);
			
			JTextField safetyTXT = new JTextField();
			safetyTXT.setColumns(10);
			safetyTXT.setBounds(205, 364, 191, 27);
			frame.getContentPane().add(safetyTXT);
			
			JLabel avMonConLabel = new JLabel("Average Monthly");
			avMonConLabel.setFont(new Font("Helvetic Neue", Font.PLAIN,20));	//average monthly consumption field and textfield
			avMonConLabel.setBounds(562, 360, 178, 27);
			frame.getContentPane().add(avMonConLabel);
			
			JLabel lblConsumption = new JLabel("Consumption  :");
			lblConsumption.setFont(new Font("Helvetic Neue", Font.PLAIN,20));
			lblConsumption.setBounds(562, 384, 178, 21);
			frame.getContentPane().add(lblConsumption);
			
			JTextField avMonTXT = new JTextField();
			avMonTXT.setColumns(10);
			avMonTXT.setBounds(763, 364, 191, 27);
			frame.getContentPane().add(avMonTXT);
			
			JLabel leadtimeLabel = new JLabel("Leadtime :");
			leadtimeLabel.setFont(new Font("Helvetic Neue", Font.PLAIN,20));	//leadtime field and textfield
			leadtimeLabel.setBounds(37, 523, 147, 21);
			frame.getContentPane().add(leadtimeLabel);
			
			JTextField leadtimeTXT = new JTextField();
			leadtimeTXT.setColumns(10);
			leadtimeTXT.setBounds(205, 524, 191, 27);
			frame.getContentPane().add(leadtimeTXT);
			
			JLabel expAmLabel = new JLabel("Expected Amount :");
			expAmLabel.setFont(new Font("Helvetic Neue", Font.PLAIN,20));		//expected amount field and textfield
			expAmLabel.setBounds(562, 520, 178, 27);
			frame.getContentPane().add(expAmLabel);
			
			JTextField expAmTXT = new JTextField();
			expAmTXT.setColumns(10);
			expAmTXT.setBounds(763, 524, 191, 27);
			frame.getContentPane().add(expAmTXT);	
			
			addButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String name = nameTXT.getText();
					String id = idTXT.getText();
					String stockAm = stockTXT.getText();
					String maxStock = maxStockTXT.getText();
					String safety = safetyTXT.getText();
					String avMonCon = avMonTXT.getText();
					String leadtime = leadtimeTXT.getText();
					String expAm = expAmTXT.getText();
					
					//calls checkErrorOM function before adding product 
					errorFlag = checkErrorOM(name,id,stockAm,maxStock,safety,avMonCon,leadtime,expAm);
					
					//if errorFlag = false there is no error, adds product in ArrayList Supplier Product
					if(!errorFlag){
						frame.setVisible(false);
							
						String omId = om.getId();
						SupplierProduct sup = new SupplierProduct(name,id,omId,Double.parseDouble(stockAm),Double.parseDouble(maxStock),
												  Double.parseDouble(safety),Double.parseDouble(avMonCon),Integer.parseInt(leadtime),Double.parseDouble(expAm));
						om.getProducts().getSupplierProducts().add(sup);
						}	
			     }
			});
			
			
		}
		else if(user instanceof Seller){
			
			Seller seller = (Seller ) user;
					
			JLabel lblPrice = new JLabel("Product Price :");
			lblPrice.setFont(new Font("Helvetica Neue", Font.PLAIN,20));		//product price field and textfield
			lblPrice.setBounds(37, 197, 147, 21);
			frame.getContentPane().add(lblPrice);
			
			JTextField priceTXT = new JTextField();
			priceTXT.setColumns(10);
			priceTXT.setBounds(205, 198, 191, 27);
			frame.getContentPane().add(priceTXT);
			
			JLabel safetyStock = new JLabel("Safety Stock :");
			safetyStock.setFont(new Font("Helvetica Neue", Font.PLAIN,20));		//safetyStock field and textfield
			safetyStock.setBounds(562, 197, 178, 21);
			frame.getContentPane().add(safetyStock);
			
			JTextField supplierIDTXT = new JTextField();
			supplierIDTXT.setColumns(10);
			supplierIDTXT.setBounds(763, 198, 191, 27);
			frame.getContentPane().add(supplierIDTXT);
			
			JLabel label = new JLabel("(6 characters)");
			label.setFont(new Font("Helvetica Neue", Font.PLAIN,10));
			label.setBounds(562, 216, 70, 21);
			frame.getContentPane().add(label);
			
			JLabel lblStockAmount = new JLabel("Stock Amount :");
			lblStockAmount.setFont(new Font("Helvetica Neue", Font.PLAIN,20));		//stock amount field and textfield
			lblStockAmount.setBounds(37, 363, 147, 21);
			frame.getContentPane().add(lblStockAmount);
			
			JTextField stockTXT = new JTextField();
			stockTXT.setColumns(10);
			stockTXT.setBounds(205, 364, 191, 27);
			frame.getContentPane().add(stockTXT);
			
			JLabel lblMaxstockAmount = new JLabel("Max Stock Amount :");
			lblMaxstockAmount.setFont(new Font("Helvetica Neue", Font.PLAIN,19));	//max stock amount field and textfield
			lblMaxstockAmount.setBounds(562, 360, 181, 27);
			frame.getContentPane().add(lblMaxstockAmount);
			
			JTextField maxStockTXT = new JTextField();
			maxStockTXT.setColumns(10);
			maxStockTXT.setBounds(763, 364, 191, 27);
			frame.getContentPane().add(maxStockTXT);
			
				
			addButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name = nameTXT.getText();
					String id = idTXT.getText();
					String price = priceTXT.getText();
					String supplierID = SupplierID.getText();
					String stockAm = stockTXT.getText();
					String maxStock = maxStockTXT.getText();
					String safety = safetyTXT.getText();
						
					//calls checkErrorSeller function before adding product
					errorFlag = checkErrorSeller(name,id,price,safety,stockAm,maxStock);
						
					//if errorFlag = false there is no error, adds product in ArrayList Company Product
					if(!errorFlag){
						frame.setVisible(false);
						CompanyProduct comp = new CompanyProduct(name,id,seller.getId(),Double.parseDouble(stockAm),Double.parseDouble(maxStock),
														Double.parseDouble(safety),Double.parseDouble(price));
						seller.getProducts().getCompanyProducts().add(comp);
					}
				    }
			});			
		}
		
		frame.setResizable(false);
		frame.setTitle("Product Form");
		frame.setLayout(null); 
		frame.setVisible(true);
	}
	
	/**
	 * Purpose : checks if there is an error in filled product form (user = ordermanager)
	 * @param name
	 * @param id
	 * @param stockAmount
	 * @param maxStockAmount
	 * @param safetyStock
	 * @param averageMonthlyConsumption
	 * @param leadtime
	 * @param expectedAmount
	 * @return errorFlag
	 */
	private boolean checkErrorOM(String name,String id,String stockAmount,String maxStockAmount,String safetyStock,
			String averageMonthlyConsumption,String leadtime,String expectedAmount){
		
		errorFlag = false;
		
		//checking if fields are empty
		
		if(name.isEmpty()){
			JOptionPane.showMessageDialog(null, "Name Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(id.isEmpty()){
			JOptionPane.showMessageDialog(null, "ID Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(stockAmount.isEmpty()){
			JOptionPane.showMessageDialog(null, "Stock Amount Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(maxStockAmount.isEmpty()){
			JOptionPane.showMessageDialog(null, "Max Stock Amount Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(safetyStock.isEmpty()){
			JOptionPane.showMessageDialog(null, "Safety Stock Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(averageMonthlyConsumption.isEmpty()){
			JOptionPane.showMessageDialog(null, "Average Monthly Consumption Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(leadtime.isEmpty()){
			JOptionPane.showMessageDialog(null, "Leadtime Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		if(expectedAmount.isEmpty()){
			JOptionPane.showMessageDialog(null, "Expected Amount Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		//checking if product already exists
		
		boolean exists = false;
		int i = 0;
		if(!(id.isEmpty())){
			SupplierProducts supP = new SupplierProducts();
			supP.extractObjectDB();
			ArrayList<SupplierProduct> supProduct = new ArrayList<SupplierProduct>(supP.getSupplierProducts());
			while((i < supProduct.size()) && !exists){
				if(id.equals(supProduct.get(i).getId())){
					exists = true;
				}
				i++;
			}
		}
		
		if(exists == true){
			JOptionPane.showMessageDialog(null, "A Product with the same ID already exists", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		//checking if there is a supplier that sells the product
		
		CompanyProducts comp = new CompanyProducts();
		comp.extractObjectDB();
		ArrayList<CompanyProduct> compP = new ArrayList<CompanyProduct>(comp.getCompanyProducts());
		exists = false;
		i = 0;
		while((i < compP.size()) && !exists){
			System.out.println(1);
			if(id.equals(compP.get(i).getId())){
				exists = true;
			}
			i++;
		}
		
		if(exists == false){
			JOptionPane.showMessageDialog(null, "There is no Supplier that provides this Product", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		else{
			//if a supplier sells the product then the product is added to supplies list
			
			for(i = 0; i < compP.size(); i++){
				if(id.equals(compP.get(i).getId())){
					String selId = compP.get(i).getSellerId();
					double price = compP.get(i).getPrice();
					Suppl s = new Suppl(id,selId,price);
					Supplies sup = new Supplies();
					sup.getSupplies().add(s);
				}
			}
		}	
		return errorFlag;
	}

	/**
	 * Purpose : checks if there is an error in filled product form (user = seller)
	 * @param name
	 * @param id
	 * @param price
	 * @param supplierId
	 * @param safetyStock
	 * @param stockAmount
	 * @param maxStockAmount
	 * @return errorFlag
	 */
	private boolean checkErrorSeller(String name, String id, String price, String safetyStock,String stockAmount,String maxStockAmount){
		
		errorFlag = false;
		
		// checks if all fields are filled
		if(name.isEmpty()){
			JOptionPane.showMessageDialog(null, "Product Name Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		if(id.isEmpty()){
			JOptionPane.showMessageDialog(null, "Product ID Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		if(price.isEmpty()){
			JOptionPane.showMessageDialog(null, "Product Price Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}

		
		if(stockAmount.isEmpty()){
			JOptionPane.showMessageDialog(null, "Stock Amount Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		if(maxStockAmount.isEmpty()){
			JOptionPane.showMessageDialog(null, "Max Stock Amount Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		if(safetyStock.isEmpty()){
			JOptionPane.showMessageDialog(null, "Safety Stock Field Must Be Filled", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}
		
		//checking if product already exists
		
		boolean exists = false;
		int i = 0;
		if(!(id.isEmpty())){
			CompanyProducts comP = new CompanyProducts();
			comP.extractObjectDB();
			ArrayList<CompanyProduct> compProduct = comP.getCompanyProducts();
			while((i < compProduct.size()) && !exists){
				if(id.equals(compProduct.get(i).getId())){
						exists = true;
				}
				i++;
			}
		}
				
		if(exists == true){
			JOptionPane.showMessageDialog(null, "A Product with the same ID already exists", "Invalid Input",JOptionPane.ERROR_MESSAGE);
			errorFlag = true;
		}

		return errorFlag;
	}
}
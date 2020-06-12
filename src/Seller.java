import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Seller.java
 * Purpose: The class represents the user: seller and contains its various methods
 * @author Bitsa Antouela
 * @see User
 */
public class Seller extends User {
	
	private CompanyProducts products;
	private Buyers buyers;
	
	//Constructor
	public Seller(String firstName, String surName, String password, String telephone, String AMA, String id, String company) {
		super(firstName, surName, password, telephone, AMA, id, company);
		this.products = new CompanyProducts();
		this.buyers = new Buyers();
	}

	/** 
	 * Calls the extractObjectDB() for the list orders, products, buyers and only keeps data that are related to the specific seller
	 */
	@Override
	public void initializeLists() {
		this.orders.getOrders().clear();
		this.orders.extractObjectDB();							// Extracts the orders from DB for the specific seller  
		ArrayList<Order> ord = new ArrayList<Order>();
		for (Order o: this.orders.getOrders()) {
			if(o.getSupplierId().equals(this.id))
				ord.add(o);
		}
		this.orders.getOrders().clear();
		this.orders.getOrders().addAll(ord);
		   
		this.products.getCompanyProducts().clear();
		this.products.extractObjectDB();                           // Extracts the products from DB for the specific seller      
		ArrayList<CompanyProduct> companyProducts = new ArrayList<CompanyProduct>();
		for (CompanyProduct comProd : this.products.getCompanyProducts()) {
			if ( comProd.getSellerId().equals(this.id) ) {
				companyProducts.add(comProd);
			}
		}
		this.products.getCompanyProducts().clear();
		this.products.getCompanyProducts().addAll(companyProducts);
		
		this.buyers.getBuyers().clear();
		this.buyers.extractObjectDB();							//Extracts the buyers for DB of the specific seller
		ArrayList<Buyer> supp = new ArrayList<Buyer>();
		for (Buyer buyer : this.buyers.getBuyers()) {
			if ( buyer.getSellerId().equals(this.id) ) {
				supp.add(buyer);
			}
		}
		this.buyers.getBuyers().clear();
		this.buyers.getBuyers().addAll(supp);
		 
	}
	
	/**
	 * Searches a key into the list of company products. If it is found then calls the PresentantionForm to show the results, else show error message  
	 * @param key		represents the string for searching
	 * @param column	represents the int for searching at a specific attribute
	 */
	public  void searchForProduct(String key, int column) {
		Boolean found=false;
		ArrayList<Object> cProductsKEY = new ArrayList<>();
		if(column==0) {                                     				 //1 for product id
			for( CompanyProduct compProd : products.getCompanyProducts()){
				if(compProd.getId().equals(key)){
						cProductsKEY.add(compProd);
						found=true;
					}
			}
		}
		else if (column==1) {                              					//2 for product name 
			for( CompanyProduct compProd : products.getCompanyProducts()){
				if(compProd.getName().equals(key)) {
					cProductsKEY.add(compProd);
					found=true;
				}
			}
		}
		else if (column==2) {                             					 //3 for supplier id ?? den uparxei
			for( CompanyProduct compProd : products.getCompanyProducts()){
				if(compProd.getSellerId().equals(key)) {   //prepei na yparxei kapoio getter 
					cProductsKEY.add(compProd);
					found=true;
				}
			}
		}
		
		Component frame = null;
		if (found) new PresentationForm(this, cProductsKEY);
		else JOptionPane.showMessageDialog(frame, "No result", "Inane error", JOptionPane.ERROR_MESSAGE);	
	}
	
	/**
	 * Adds a product to the product list
	 * @param product     product for adding in the list
	 */
	public void addProduct(CompanyProduct product) {
		products.getCompanyProducts().add(product);
	}
	
	/**
	 *  Adds the product that already exists and have been edited in the specific index position of list products
	 *  @param cp  		CompanyProduct that already exists and have been edited
	 *  @param index 	contains the index of the occurrence of the product
	 */
	public void editProduct(CompanyProduct cp, int index) {
		products.getCompanyProducts().add(index, cp);
	}
	
	
	/**
	 * Searches a key into the list of buyers. If it is found then calls the PresentantionForm to show the results, else show error message
	 * @param key		represents the string for searching
	 * @param column	represents the int for searching at a specific attribute
	 */
	public void searchForBuyer(String key, int column) {
		Boolean found=false;
		ArrayList<Object> buyersKEY = new ArrayList<>();
		if(column==1) {                                      //1 -> for buyer id
			for( Buyer b : buyers.getBuyers()){
				if(b.getId().equals(key))
					{
						buyersKEY.add(b);
						found=true;
					}
			}
		}
		else if (column==2) {                                //2 -> for name
			for( Buyer b : buyers.getBuyers()){
				if(b.getName().equals(key)) {
					buyersKEY.add(b);
					found=true;
				}
			}
		}
		else if (column==3) {                               //3 -> for last name 
			for( Buyer b : buyers.getBuyers()){
				if(b.getLastName().equals(key)) {
					buyersKEY.add(b);
					found=true;
				}
			}
		}
		else if (column==4) {                               //4 ->for buyer AFM
			for( Buyer b : buyers.getBuyers()){
				if(b.getAFM().equals(key)) {
					buyersKEY.add(b);
					found=true;
				}
			}
		}
		
		Component frame = null;
		if (found) new PresentationForm(this, buyersKEY);
		else JOptionPane.showMessageDialog(frame, "No result", "Inane error", JOptionPane.ERROR_MESSAGE);
	}
	/**
	* Updates the lists of a Seller 
	*/
	public void refresh() {
		ArrayList<Order> oldOrders = new ArrayList<Order>(this.orders.getOrders());
		this.orders.updateObjectDB();
		this.products.updateObjectDB();
		this.products.getCompanyProducts().clear();
		initializeLists();
		int count = 0 ;
		if (orders.getOrders().size() != oldOrders.size()) {
			JOptionPane.showMessageDialog(null, "You have new Orders","Information Message", JOptionPane.INFORMATION_MESSAGE);
		}
		for (Order newOrder: orders.getOrders()) {
			for (Order oldOrder: oldOrders) {
				if (newOrder.getOrderId().equals(oldOrder.getOrderId()) && newOrder.getStatus() != oldOrder.getStatus() ){
					count++;
				}
			}
		}
		if (count != 0 ) {
			JOptionPane.showMessageDialog(null, "Some orders have changed in order","Information Message", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	/** 
	 * Adds a buyer to the buyers list
	 * @param s  buyer that user wants to add to the list of buyers
	 */
	public void addBuyer(Buyer s) {
		buyers.getBuyers().add(s);
	}
	
	
	//Getters & Setters 
	public CompanyProducts getProducts() {
		return products;
	}

	public Buyers getBuyers() {
		return buyers;
	}

}

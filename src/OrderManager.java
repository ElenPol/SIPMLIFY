import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * OrderManager.java
 * Purpose: The class represents the user: OrderManager and contains its various methods
 * @author Bitsa Antouela
 * @see User
 */

public class OrderManager extends User {
	
	private boolean regular = false ;
	private String season ;
	private SupplierProducts products ;
	private Proposals proposals ;
	private Suppliers suppliers ;
	private Supplies supplies ;
	
	//Constructor
	public OrderManager(String firstName, String surName, String password, String telephone, String AMA, String id, String company, boolean regular, String season){
		super(firstName, surName, password, telephone, AMA, company, id);
		this.regular = regular;
		this.season = season;
		products = new SupplierProducts();
		proposals = new Proposals();
		suppliers = new Suppliers();
		supplies = new Supplies();
		
	}
	
	/** 
	 * Calls the extractObjectDB() for the list orders, products, suppliers, supplies, proposals and only keeps data that are related to the specific orderManager
	 */
	@Override
	public void initializeLists() {
		
		
		this.orders.getOrders().clear();
		this.orders.extractObjectDB();								//Extracts the orders from DB 
		ArrayList<Order> ord = new ArrayList<Order>();			
		for (Order o: this.orders.getOrders()) {
			if(o.getOrderManagerId().equals(this.id))
				ord.add(o);
		}
		this.orders.getOrders().clear();
		this.orders.getOrders().addAll(ord);
		   
		this.products.getSupplierProducts().clear();
		this.products.extractObjectDB();                           // Extracts the products from DB   
		ArrayList<SupplierProduct> supProducts = new ArrayList<SupplierProduct>();
		for (SupplierProduct supProd : this.products.getSupplierProducts()) {
			if ( supProd.getOrderManagerId().equals(this.id) ) {
				supProducts.add(supProd);
			}
		}
		this.products.getSupplierProducts().clear();
		this.products.getSupplierProducts().addAll(supProducts);
		
		this.suppliers.getSuppliers().clear();
		this.suppliers.extractObjectDB();							//Extracts the suppliers from DB 
		ArrayList<Supplier> supp = new ArrayList<Supplier>();
		for (Supplier suppl : this.suppliers.getSuppliers()) {
			if ( suppl.getOrderManagerId().equals(this.id) ) {
				supp.add(suppl);
			}
		}
		this.suppliers.getSuppliers().clear();
		this.suppliers.getSuppliers().addAll(supp);
		 
		this.proposals.getProposals().clear();
		this.proposals.extractObjectDB();							//Extracts the proposals from DB 
		ArrayList<Order> prop = new ArrayList<Order>();
		for (Order order: proposals.getProposals()) {
			if ( order.getOrderManagerId().equals(this.id)){
				prop.add(order);
			}
		}
		this.proposals.getProposals().clear();
		this.proposals.getProposals().addAll(prop);
		
		this.supplies.getSupplies().clear();
		supplies.extractObjectDB();									//Extracts the supplies for DB 
		ArrayList<Suppl> supll = new ArrayList<Suppl>();
		for (Suppl s : supplies.getSupplies()) {
			for (SupplierProduct sp: this.products.getSupplierProducts()) {
				if ( s.getProductId().equals(sp.getId())) {
					supll.add(s);
			}}
		}
		this.supplies.getSupplies().clear();
		this.supplies.getSupplies().addAll(supll);
		
		
	}
	
	/**
	 * Searches a key into the list of supplier products. If it is found then calls the PresentantionForm to show the results, , else show error message 
	 * @param key     represents the key for searching
	 * @param column  represents the int for searching at a specific attribute
	**/
	public void searchForProduct(String key, int column) {
		Boolean found=false;
		ArrayList<Object> productsKEY = new ArrayList<>();
		if(column == 0) {                                      				//1 for product id 
			for( SupplierProduct supProd : products.getSupplierProducts() ){
				if( supProd.getId().equals(key) ){
					productsKEY.add(supProd);
					found = true;
				}
			}
		}
		else if (column==1) {                              					//2 for product name 
			for( SupplierProduct supProd : products.getSupplierProducts() ){
				if(supProd.getName().equals(key)) {
					productsKEY.add(supProd);
					found=true;
				}
			}
		}
		else if (column==2) {                              					//3 for supplier id
			for( SupplierProduct supProd : products.getSupplierProducts() ){
				for (Suppl sup : supplies.getSupplies()) {
					if (key.equals(sup.getSupplierId())  && supProd.getId().contentEquals(sup.getProductId())) {
					productsKEY.add(supProd);
					found = true;
				}
			}
		}
		}
		Component frame = null;
		if (found) new PresentationForm(this, productsKEY);
		else JOptionPane.showMessageDialog(frame, "No result", "Inane error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Adds a product to the product list
	 * @param product     product for adding in the list
	 */
	public void addProduct(SupplierProduct product) {
		this.products.getSupplierProducts().add(product);
	}
	
	/**
	 *  Adds the product ,that already exists and have been edited, in the specific index position of list products
	 *  @param sp  		SupplierProduct that already exists and have been edited
	 *  @param index 	contains the index of the occurrence of the product
	 */
	public void editProduct(SupplierProduct sp, int index) {
		products.getSupplierProducts().set(index, sp);
	}
	
	/**
	 * Searches if the key is in the list of suppliers. If it is found then calls the PresentantionForm to show the results, else show error message
	 * @param key     the string that the user wants to search.
	 * @param column  an int that shows what the user wants to search
	 */
	public void searchForSupplier(String key, int column) {
		Boolean found=false;
		ArrayList<Object> suppliersKEY = new ArrayList<>();
		if(column == 0) {                                      		    //1 -> for supplier id
			for( Supplier suppl : suppliers.getSuppliers() ){
				if( suppl.getId().equals(key) ){
					suppliersKEY.add(suppl);
					found=true;
				}
			}
		}
		else if (column == 1) {                              		    //2 -> for supplier name 
			for( Supplier suppl : suppliers.getSuppliers() ){
				if(suppl.getName().equals(key)) {
					suppliersKEY.add(suppl);
					found=true;
				}
			}
		}
		else if (column ==  2) {                              			//3 -> for supplier last name 
			for( Supplier suppl : suppliers.getSuppliers() ){
				if(suppl.getLastName().equals(key)) {
					suppliersKEY.add(suppl);
					found=true;
				}
			}
		}
		else if (column == 3) {                              			//4 -> for supplier AFM
			for( Supplier suppl : suppliers.getSuppliers() ){
				if(suppl.getAFM().equals(key)) {
					suppliersKEY.add(suppl);
					found=true;
				}
			}
		}
		Component frame = null;
		if (found) new PresentationForm(this, suppliersKEY);
		else JOptionPane.showMessageDialog(frame, "No result", "Inane error", JOptionPane.ERROR_MESSAGE);
	}
	
	/** 
	 * Adds a supplier to the supplier list
	 * @param s  supplier that user wants to add to the list of suppliers
	 */
	public void addSupplier(Supplier s) {
		this.suppliers.getSuppliers().add(s);
	}
	
	
	/** 
	 * Adds the new Order to the orders list
	 *  @param order     The new Order that the user have made
	 */
	public void addOrder(Order order) {
		this.orders.getOrders().add(order);
	}
	
	/** 
	 * Sets true if the business is regular
	 *  @param flag      if true the business is regular , else false it is seasonal
	 *  */
	public void chooseBusinessType(boolean flag) {
		if ( flag == true ) {
			regular = true; 
		}
	}
	
	/** 
	 * Sets the season of the business
	 * @param seas     string that contains the season
	 */
	public void chooseBusinessSeason(String seas) {
		if (regular == false) {
			season = seas;
		}
	}
	/**
	 * Method refresh(): updates the lists of an OrderManager
	 */
	public void refresh() {
		ArrayList<Order> oldOrders = new ArrayList<Order>(this.orders.getOrders());
		
		orders.updateObjectDB();
		products.updateObjectDB();
		proposals.updateObjectDB();
		
		initializeLists();
		int count = 0 ;
		for (Order newOrder: orders.getOrders()) {
			for (Order oldOrder: oldOrders) {
				if (newOrder.getOrderId().equals(oldOrder.getOrderId()) && (newOrder.getStatus() != oldOrder.getStatus() || newOrder.getPrice() != oldOrder.getPrice() || newOrder.getQuantity() != oldOrder.getQuantity())){
					count++;
				}
			}
		}
		if (count != 0 ) {
			JOptionPane.showMessageDialog(null, "Some orders have changed in order","Pop up", JOptionPane.INFORMATION_MESSAGE);
		}	
		JOptionPane.showMessageDialog(null,  "The refresh has been completed", "Pop up", JOptionPane.INFORMATION_MESSAGE);
		
		Users users = new Users();
		users.extractObjectDB();
		for (User u : users.getUsers()) {
			System.out.println(u.getId() + this.getId());
			if (u.getId().equals(this.getId())) {
				int index = users.getUsers().indexOf(u);
				users.getUsers().set(index, this);
			}
		}
		users.updateObjectDB();
	}

	//getters and setters
	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public SupplierProducts getProducts() {
		return products;
	}

	public void setProducts(SupplierProducts products) {
		this.products = products;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Proposals getProposals() {
		return proposals;
	}

	public void setProposals(Proposals proposals) {
		this.proposals = proposals;
	}

	public Suppliers getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}

	public Supplies getSupplies() {
		return supplies;
	}

	public void setSupplies(Supplies supplies) {
		this.supplies = supplies;
	}

	public void setRegular(boolean b) {
		this.regular = b;
		
	}

	public boolean getRegular() {
		return regular;
	}

	
}
	
	

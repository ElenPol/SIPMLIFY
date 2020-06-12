import java.util.ArrayList;

/**
 * Stockkeeper.java
 * Purpose: The class represents the user: Stockkeeper and contains its various methods
 * @author Manoli Christina
 * @see User
 */

public class Stockkeeper extends User {

	//Constructor
	public Stockkeeper(String firstName, String surName, String password, String telephone, String aFM, String id, String company) {
		super(firstName, surName, password, telephone, aFM, id, company);
	}
	
	
	/** 
	 * Calls the extractObjectDB() for the list orders and only keeps data that are related to the specific Stockkeeper
	 */
	@Override
	public void initializeLists() {
		this.orders.getOrders().clear();
		this.orders.extractObjectDB();						//Extracts the orders from DB 
		ArrayList<Order> ord = new ArrayList<Order>();			
		for (Order o: this.orders.getOrders()) {
			if(o.getStockkeeperId().equals(this.id))
				ord.add(o);
		}
		this.orders.getOrders().clear();
		this.orders.getOrders().addAll(ord);
	}

	/**
	 * Method refresh(): updates the lists of a Stockkeeper
	 */
	@Override
	public void refresh() {
		
		this.orders.updateObjectDB();
		this.orders.getOrders().clear();
		this.initializeLists();
		
		
	}
}
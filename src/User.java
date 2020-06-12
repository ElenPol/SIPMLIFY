import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * User.java
 * Purpose: The class represents a general user and contains its various methods
 * @author Manoli Christina
 */
public class User {
	protected String firstName;
	protected String surName;
	protected String password;
	protected String telephone;
	protected String AFM;
	protected String id;
	protected String company;
	protected Orders orders;
	
	//Empty Constructor
	public User() {
	}

	//Constructor
	public User(String firstName, String surName, String password, String telephone, String aFM, String id, String company)
	{
		this.firstName = firstName;
		this.surName = surName;
		this.password = password;
		this.telephone = telephone;
		this.AFM = aFM;
		this.id = id;
		this.company = company;
		this.orders=new Orders();
	}

	//Empty method initializeLists()
	public void initializeLists()
	{
		
	}
	
	//Empty method refresh()
	public void refresh()
	{
		
	}
	
	/**
	 * Searches a key into the list of orders. If it is found then calls the PresentantionForm to show the results, else show error message  
	 * @param key		represents the string for searching
	 * @param column	represents the int for searching at a specific attribute
	 */
	public void searchForOrder(String key, int column)
	{
		
		Boolean found=false;
		ArrayList<Object> ordersKEY = new ArrayList<>();
		if(column==0) {                                     //0 for orderId
			for(Order o : this.orders.getOrders()){
				if(o.getOrderId().equals(key)){
						ordersKEY.add(o);
						found=true;
					}
			}
		}
		else if (column==1) {                              //1 for supplierId
			for(Order o : this.orders.getOrders()){
				if(o.getSupplierId().equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==2) {                              //2 for productId
			for(Order o : this.orders.getOrders()){
				if(o.getProductId().equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==3) {                              //3 for productName
			for(Order o : this.orders.getOrders())
			{
				if(o.getProductName().equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==4) {                              //4 for date
			for(Order o : this.orders.getOrders()){
				if(o.getDate().equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==5) {                             //5 for status
			int intkey = Integer.parseInt(key);
			for(Order o : this.orders.getOrders()){
				if(o.getStatus()==intkey) {
					ordersKEY.add(o);
					found = true;
				}
			}
		}
		
		Component frame = null;
		if (found) new PresentationForm(this, ordersKEY);
		else JOptionPane.showMessageDialog(frame, "No result", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 *  Adds the order, that already exists and have been edited, in the specific index position of list orders
	 *  @param o  		Order that already exists and have been edited
	 *  @param index 	contains the index of the occurrence of the order
	 */
	public void editOrder(Order o, int index)
	{
		orders.getOrders().set(index, o);
	}

	
	
	//getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAFM() {
		return AFM;
	}

	public void setAFM(String aFM) {
		AFM = aFM;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String getPhonenumber() {
		return null;
	}
}
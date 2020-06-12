public class Buyer {
	/**
	 *Buyer.java
	 * Purpose: Class that represents a client of a seller
	 * @author Vlasakoudi Christina
	 */
	private String name;
	private String lastName;
	private String id;
	private String AFM;
	private String phoneNumber;
	private String sellerId;
	
	//constructor
	public Buyer(String name,String lastName,String id,String AFM,String phoneNumber,String sellerId) {
	
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.AFM = AFM;
		this.phoneNumber = phoneNumber;
		this.sellerId = sellerId;
	}

	
	//getters and setters
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}

	public String getId() {
		return id;
	}

	public String getAFM() {
		return AFM;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;	
	}
	public void setId(String id) {
		this.id = id;	
	}
	public void setAFM(String afm) {
		this.AFM = afm;	
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
		
	}

	
}

public class Suppl {
	/**
	*Suppl.java
	* Purpose: Class that represents a supply which is a specific product that a specific supplier is selling
	 * @author Vlasakoudi Christina
	 */
	private String productId;
	private String supplierId;
	private double price;

	//constructor
	public Suppl(String productid,String supplierid,double price) {
	
		this.productId=productid;
		this.supplierId=supplierid;
		this.price = price;
}

	
	//getters and setters
	public String getProductId() {
		return productId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public double getPrice() {
		return price;
	}


	public void setProductId(String productId) {
		this.productId = productId;
		
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
		

	public void setPrice(double price) {
		this.price = price;
		
	}

	
	
}
public class SupplierProduct {
	/**
	 *SupplierProduct.java
	 *Purpose: Class that represents a product that an OrderManager is buying.
	 * @author Vlasakoudi Christina
	 */
	 private String name;
	 private String id;
	 private String orderManagerId; // the orderManagerId is needed in this class
	 private double stockAmount;
	 private double maxStockAmount;
	 private double safetyStock;
	 private double averageMonthlyConsumption;
	 private int leadtime;
	 private double expectedAmount;
	 
	 

	
	//Constructor 
	 public SupplierProduct(String name,String id,String orderManagerId,double stockAmount,double maxStockAmount,double safetyStock,double averageMonthlyConsumption,int leadtime,double expectedAmount) 
	 {
		 this.name = name;
		 this.id = id;
		 this.orderManagerId = orderManagerId;
		 this.stockAmount = stockAmount;
		 this.maxStockAmount = maxStockAmount;
		 this.safetyStock = safetyStock;
		 this.averageMonthlyConsumption = averageMonthlyConsumption;
		 this.leadtime = leadtime;
		 this.expectedAmount = expectedAmount;

     }

	
	//getters and setters
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public double getStockAmount() {
		return stockAmount;
	}

	public double getMaxStockAmount() {
		return maxStockAmount;
	}

	public double getSafetyStock() {
		return safetyStock;
	}

	public double getAverageMonthlyConsumption() {
		return averageMonthlyConsumption;
	}

	public int getLeadtime() {
		return leadtime;
	}

	public double getExpectedAmount() {
		return expectedAmount;
	}

	public void setExpectedAmount(double EA) {
		this.expectedAmount = EA;
		
	}

	public void setName(String name) {
		this.name = name;
		
	}

	public void setId(String id) {
		this.id = id;
		
	}

	public void setStockAmount(double sa) {
		this.stockAmount = sa;
	}

	public void setMaxStockAmount(double ma) {
		this.maxStockAmount = ma;
		
	}

	public void setAverageMonthlyConsumption(double amc) {
		this.averageMonthlyConsumption = amc;
		
	}

	public void setSafetyStock(double ss) {
		this.safetyStock = ss;
		
	}

	public void setLeadtime(int lt) {
		this.leadtime = lt;
	}

	public String getOrderManagerId() {
		return orderManagerId;
	}

	public void setOrderManagerId(String orderManagerId) {
		this.orderManagerId = orderManagerId;
	}

		 
      }
public class Order {
		/**
		 * Order.java
		 * Purpose: Class that represents an order 
		 * @author Vlasakoudi Christina
		 */
	
		
		private String orderManagerId;
		private String orderId;
		private double quantity;
		private String supplierId;
		private String supplierName;
		private String supplierAFM;
		private String date;
		private int status;
		private double price;
		private double totalPrice;
		private String productName;
		private String productId;
		private String stockkeeperId;
		
		
		
		//Constructor
		public Order(String orderManagerId,String orderId,double quantity,String supplierId,String supplierName,String supplierAFM,String date,int status,double price,double totalPrice,String productId,String productName,String stockkeeperId) 
		{
			this.orderManagerId = orderManagerId;
			this.orderId = orderId;
			this.quantity = quantity;
			this.supplierId = supplierId;
			this.supplierName = supplierName;
			this.supplierAFM = supplierAFM;
			this.date = date;
			this.status = status;
			this.price = price;
			this.totalPrice = totalPrice;
			this.productId = productId;
			this.productName = productName;
			this.stockkeeperId = stockkeeperId;
		}
		
		//Empty Constructor
		public Order() {
			
		}

		
		
		//getters and setters
		public String getOrderManagerId() {
			return orderManagerId;
		}


		public String getOrderId() {
			return orderId;
		}


		public double getQuantity() {
			return quantity;
		}


		public String getSupplierId() {
			return supplierId;
		}


		public String getSupplierName() {
			return supplierName;
		}


		public String getSupplierAFM() {
			return supplierAFM;
		}


		public String getDate() {
			return date;
		}
		

		public int getStatus() {
			return status;
		}


		public double getPrice() {
			return price;
		}


		public double getTotalPrice() {
			return totalPrice;
		}

		public String getProductName() {
			return productName;
		}
		
		public void setOrderManagerId(String orderManagerId) {
			this.orderManagerId = orderManagerId;
			
		}


		public void setOrderId(String orderId) {
			this.orderId = orderId;
			
		}


		public void setQuantity(double quantity) {
			this.quantity = quantity;
			
		}


		public void setSupplierId(String supplierId) {
			this.supplierId = supplierId;
			
		}


		public void setSupplierName(String supplierName) {
			this.supplierName = supplierName;
			
		}


		public void setSupplierAFM(String supplierAFM) {
			this.supplierAFM = supplierAFM;
			
		}


		public void setDate(String date) {
			this.date = date;
		}


		public void setStatus(int status) {
			this.status = status;
			
		}


		public void setPrice(double price) {
			this.price = price;
			
		}


		public void setTotalPrice(double totalprice) {
			this.totalPrice = totalprice;
			
		}


		public void setProductName(String productName) {
			this.productName = productName;
		}
		public void setProductId(String productid) {
			this.productId = productid;
			
		}


		public String getProductId() {
			return productId;
		}


		public void setStockkeeperId(String stockkeeperId) {
			this.stockkeeperId = stockkeeperId;
			
		}
		public String getStockkeeperId() {
			return stockkeeperId;
		}
			
		
		}

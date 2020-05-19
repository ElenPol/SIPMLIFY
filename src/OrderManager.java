
public class OrderManager extends User {
	
	private boolean regular = false ;
	private String season ;
	private SupplierProducts products ;
	private Orders orders ;
	private Proposals proposals ;
	private Suppliers suppliers ;
	private Supplies supplies ;
	
	//Constructor
	public OrderManager(String firstName, String surName, String password, String telephone, String AMA, String id, boolean regular, String season,String company) {
		super(firstName,surName,password,telephone,AMA,id,company);
		this.regular = regular;
		this.season = season;
		proposals = new Proposals();
		suppliers = new Suppliers();
		supplies = new Supplies();
	}
	
	

	/* Method initializeLists() : extracts the infomations from database 
	** and adds them into lists */
	public void initializeLists() {
		products.extractObjectDB();
		proposals.extractObjectDB();
		suppliers.extractObjectDB();
		supplies.extractObjectDB();
	}
	
	/* Method searchForProduct(): searches a product and calls a GUI to 
	** to show the results */
	public void searchForProduct(String key, int column) {
		for ( SupplierProduct prod : products ) {
			if (prod.equals(column) && prod.equals(key)){
				//calls GUI : PresentationForm
			}
		}
	}
	
	/* Method addProduct() : adds the parameter to the product list */
	public void addProduct(SupplierProduct product) {
		products.add(product);
	}
	
	/* Method editProduct() : adds the sp in the specific index position of list products */
	public void editProduct(SupplierProduct sp, int index) {
		products.add(index, sp);
	}
	
	/* Method searchForSupplier() : seasrches a supplier and calls a GUI to 
	** to show the results */
	public void searchForSupplier(String key, int column) {
		for ( Supplier sup : suppliers ) {
			if ( sup.equals(column) && sup.equals(key)) {
				//Calls GUI : PresentationForm
			}
		}
	}
	
	/* Method addSupplier() : adds the parameter to the supplier list*/
	public void addSupplier(Supplier s) {
		suppliers.add(s);
	}
	
	/* Method editSupplier() : adds the s to the specific index position of list suppliers*/
	public void editSupplier(Supplier s, int index) {
		suppliers.add(index, s);
	}
	
	/* Method addOrder() : adds the parameter to the orders list */
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	/* Method chooseBusinessType() : sets if the business is regular or not */
	public void chooseBusinessType(boolean flag) {
		if ( flag == true ) {
			regular = true; //if flag is true the business is regular
		}
	}
	
	/* Method chooseBusinessSeason() : sets the season of the business*/
	public void chooseBusinessSeason(String seas) {
		if (regular == false) {
			season = seas;
		}
	}

	//Getters & Setters
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
	
	

}

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Color;
import java.awt.Font;


/**
 * PresentationForm.java
 * Purpose : Creates the GUI for the Presentation Form and is used to present very briefly
 * a table consisting of data then the user chooses one and it opens in another GUI so they can see it in more detail.
 * It also allows the user to sort the table in ascending order or descending order
 * @author Manoli Christina
 */

public class PresentationForm extends JFrame{
	
	/**
	 * 
	 */
	private JPanel panel;
	private JTable table = new JTable();
	private JScrollPane scroll;
	private int n;
	
	
	public PresentationForm(User u, ArrayList <Object> objectList)
	{
		String[][] data = new String[objectList.size()][3];
		panel = new JPanel();
		panel.setBackground(new Color(136, 177, 179));
		panel.setBounds(100, 100, 584, 534);
		panel.setLayout(null);
		
		scroll = new JScrollPane();
		scroll.setBounds(53, 37, 924, 552);
		panel.add(scroll);
		
		URL resource3 = getClass().getClassLoader().getResource( "windowLogo.png" );
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(resource3));
	
		if (objectList.size() == 0) {
			JOptionPane.showMessageDialog(null, "There no records to show ","PresentantionForm", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			if (objectList.get(0) instanceof Order) {    //here we check if the objects in the list we have are of type Order
		
				n = 1;
				for (int i=0; i<objectList.size(); i++){
					Order temp = (Order) objectList.get(i);
					data[i][0]=temp.getProductName();
					data[i][1]=temp.getOrderId();
					data[i][2]=temp.getDate().substring(0,10);
				}
				table.setModel(new DefaultTableModel(data, new String[] {"Product Name", "Order ID", "Date"}));
			}
			else if (objectList.get(0) instanceof CompanyProduct) { //here we check if the objects in the list we have are of type CompanyProduct
		
				n = 2;
				for (int i=0; i<objectList.size(); i++){
					CompanyProduct temp = (CompanyProduct) objectList.get(i);
					data[i][0] = temp.getName();
					data[i][1] = temp.getId();
					data[i][2] = temp.getStockAmount()+"";
				}
				table.setModel(new DefaultTableModel(data, new String[] {"Product Name", "Product Id", "StockAmount"}));
			}
			else if (objectList.get(0) instanceof SupplierProduct) { //here we check if the objects in the list we have are of type SupplierProduct
		
				n = 3;
				for (int i=0; i<objectList.size(); i++){
					SupplierProduct temp = (SupplierProduct) objectList.get(i);
					data[i][0] = temp.getName();
					data[i][1] = temp.getId();
					data[i][2] = temp.getStockAmount()+"";
				}
				table.setModel(new DefaultTableModel(data, new String[] {"Product Name", "Product Id", "StockAmount"}));
			}
			else if (objectList.get(0) instanceof Supplier) { //here we check if the objects in the list we have are of type Supplier
		
				n = 4;
				for (int i = 0; i<objectList.size(); i++){
					Supplier temp = (Supplier) objectList.get(i);
					data[i][0] = temp.getName();
					data[i][1] = temp.getId();
					data[i][2] = temp.getAFM();
				}
				table.setModel(new DefaultTableModel(data, new String[] {"Supplier Name", "Supplier Id", "Supplier AFM"}));
			}
			else if (objectList.get(0) instanceof Buyer) { //here we check if the objects in the list we have are of type Buyer
		
				n = 5;
				for (int i=0; i<objectList.size(); i++){
					Buyer temp = (Buyer) objectList.get(i);
					data[i][0] = temp.getName();
					data[i][1] = temp.getId();
					data[i][2] = temp.getAFM();
				}
				table.setModel(new DefaultTableModel(data, new String[] {"Buyer Name", "Buyer Id", "Buyer AFM"}));
			}
			table.setFont(new Font("HelveticaNeue", Font.PLAIN, 17));
			table.setBackground(new Color(136, 177, 179));
			table.setFillsViewportHeight(true);
			table.setAutoCreateRowSorter(true);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setSelectionBackground(new Color(255, 152, 61));

			scroll.setViewportView(table);
		
		
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int index = table.getSelectedRow();
		        
					TableModel model = table.getModel();
		        
					String SelectedId = model.getValueAt(index, 1).toString();
					if(n==1){
						for(Object o : objectList){
							Order temp = (Order) o;
							if(temp.getOrderId().equals(SelectedId)) new ShowOrder(u, temp);
						}
					}
					else if (n==2){
						for(Object o : objectList){
							CompanyProduct temp = (CompanyProduct) o;
							if(temp.getId().equals(SelectedId)) new ShowProduct(u, temp);
						}
					}
					else if (n==3){
						for(Object o : objectList){
							SupplierProduct temp = (SupplierProduct) o;
							if(temp.getId().equals(SelectedId)) new ShowProduct(u, temp);
						}
					}
					else if(n==4){
						for(Object o : objectList){
							Supplier temp = (Supplier) o;
							if(temp.getId().equals(SelectedId)) new ShowBuyerSeller(temp);
						}
					}
					else if (n==5){
						for(Object o : objectList){
							Buyer temp = (Buyer) o;
							if(temp.getId().equals(SelectedId)) new ShowBuyerSeller(temp);
						}
					}
				}
			});
			this.setContentPane(panel);
			this.setVisible(true);
			this.setTitle("Presentation Form");
			this.setBounds(100, 100, 1041, 653);
			this.setResizable(false);
		}                 
	}
}
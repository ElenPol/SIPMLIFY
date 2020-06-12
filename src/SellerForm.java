import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * SellerForm.java
 * Purpose: The class is the GUI for showing the home page of a Seller.
 * @author Manoli Christina
 */

public class SellerForm extends JFrame{
	private JPanel panel;
	private JButton btnNewButton;
	private JLabel lblFirstName;
	private JLabel lblSurname ;
	private JLabel lblTelephone;
	private JLabel lblAfm;
	private JLabel lblId;
	private JSeparator firstSeparator;
	private JSeparator secondSeparator;
	private JSeparator thirdSeparator;
	private JSeparator fourthSeparator;
	private JMenuBar menuBar;
	private	JLabel firstNameJLbl;
	private	JLabel surNameJLbl;
	private	JLabel telephoneJLbl;
	private	JLabel idJLbl;
	private	JLabel afmJLbl;
	private JMenu menuSearchfor;
	private JMenuItem menuItemOrder;
	private JMenuItem menuItemProduct;
	private JMenuItem menuItemClient;
	private JMenu menuMyProduct;
	private JMenuItem menuItemAddProduct;
	private JMenuItem menuItemShowProducts;
	private JMenuItem menuMyOrders;
	private JMenuItem menuItemShowOrders;
	private JMenu menuMyClients;
	private JMenuItem menuItemShowClients;
	private JMenuItem menuItemAddClient;
	private JMenu menuStatistics;
	private JMenuItem menuItemSeeStatistics;
	
	
	public SellerForm(Seller s)
	{
		panel = new JPanel();
		panel.setBackground(new Color(136, 177, 179));
		panel.setLayout(null);
		
		URL resource3 = getClass().getClassLoader().getResource( "windowLogo.png" );
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(resource3));
		
		btnNewButton = new JButton("Refresh");
		btnNewButton.setFont(new Font("HelveticaNeue", Font.BOLD, 10));
		//btnNewButton.setIcon(new ImageIcon(this.getClass().getResource("refresg.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				s.refresh();
			}
		});
		btnNewButton.setBounds(936, 510, 89, 74);
		panel.add(btnNewButton);
		
		lblFirstName = new JLabel("First Name :");
		lblFirstName.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		lblFirstName.setBounds(225, 99, 159, 32);
		panel.add(lblFirstName);
		
		
		lblSurname = new JLabel("SurName:");
		lblSurname.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		lblSurname.setBounds(225, 192, 159, 32);
		panel.add(lblSurname);
		
		lblTelephone = new JLabel("Telephone :");
		lblTelephone.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		lblTelephone.setBounds(225, 272, 159, 32);
		panel.add(lblTelephone);
		
		lblAfm = new JLabel("AFM :");
		lblAfm.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		lblAfm.setBounds(225, 355, 159, 32);
		panel.add(lblAfm);
		
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		lblId.setBounds(225, 427, 159, 32);
		panel.add(lblId);
		
		
		firstSeparator = new JSeparator();
		firstSeparator.setBounds(24, 167, 984, 2);
		panel.add(firstSeparator);
		
		secondSeparator = new JSeparator();
		secondSeparator.setBounds(27, 246, 981, 2);
		panel.add(secondSeparator);
		
		thirdSeparator = new JSeparator();
		thirdSeparator.setBounds(27, 331, 981, 2);
		panel.add(thirdSeparator);
		
		fourthSeparator = new JSeparator();
		fourthSeparator.setBounds(30, 414, 981, 2);
		panel.add(fourthSeparator);
		
		
		firstNameJLbl = new JLabel(s.getFirstName());
		firstNameJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		firstNameJLbl.setBounds(608, 102, 226, 26);
		panel.add(firstNameJLbl);
		
		surNameJLbl= new JLabel(s.getSurName());
		surNameJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		surNameJLbl.setBounds(608, 195, 226, 26);
		panel.add(surNameJLbl);
		
		telephoneJLbl = new JLabel(s.getTelephone());
		telephoneJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		telephoneJLbl.setBounds(608, 275, 226, 26);
		panel.add(telephoneJLbl);
		
		afmJLbl = new JLabel(s.getAFM());
		afmJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		afmJLbl.setBounds(608, 358, 226, 26);
		panel.add(afmJLbl);
		
		idJLbl = new JLabel(s.getId());
		idJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		idJLbl.setBounds(608, 430, 226, 26);
		panel.add(idJLbl);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 228, 196));
		setJMenuBar(menuBar);
		
		
		menuSearchfor = new JMenu("Search for");
		menuSearchfor.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(menuSearchfor);
		
		menuItemOrder = new JMenuItem("Order");
		menuItemOrder.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		menuSearchfor.add(menuItemOrder);
		menuItemOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
	    	
				new SearchForm(1, s);
	    	}
		});
		
		menuItemProduct = new JMenuItem("Product");
		menuSearchfor.add(menuItemProduct);
		menuItemProduct.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		menuItemProduct.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    
				new SearchForm(2, s);

		    	}
			});
		          
		
		menuItemClient = new JMenuItem("Client");
		menuSearchfor.add(menuItemClient);
		menuItemClient.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		menuItemClient.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	
				new SearchForm(3, s);
		    	}
			});
		
	
		
		JLabel label = new JLabel("          ");
		menuBar.add(label);
		
		menuMyProduct = new JMenu("My Products");
		menuMyProduct.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(menuMyProduct);
		
		menuItemAddProduct = new JMenuItem("Add a Product");
		menuMyProduct.add(menuItemAddProduct);
		menuItemAddProduct.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		menuItemAddProduct.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	
		    	new ProductForm(s);
		    	}
			});

		
		menuItemShowProducts = new JMenuItem("Show Products");
		menuMyProduct.add(menuItemShowProducts);
		menuItemShowProducts.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		menuItemShowProducts.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	
		    	ArrayList<Object> temp = new ArrayList<>(s.getProducts().getCompanyProducts());
		    	new PresentationForm(s, temp);
		    	
		    	}
			});
		
		
		
		
		JLabel label_1 = new JLabel("          ");
		menuBar.add(label_1);
		
		menuMyOrders = new JMenu("My Orders");
		menuMyOrders.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(menuMyOrders);
		
		menuItemShowOrders = new JMenuItem("Show Orders");
		menuItemShowOrders.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		menuMyOrders.add(menuItemShowOrders);
		menuItemShowOrders.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	
		    	ArrayList<Object> temp = new ArrayList<>(s.getOrders().getOrders());
		    	new PresentationForm(s, temp);
		    	}
			});
		
		
		
		
		JLabel label_2 = new JLabel("          ");
		menuBar.add(label_2);
		
		menuMyClients = new JMenu("My Clients");
		menuMyClients.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(menuMyClients);
		
		menuItemAddClient = new JMenuItem("Add a Client");
		menuMyClients.add(menuItemAddClient);
		menuItemAddClient.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		menuItemAddClient.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	new BuyerForm(s);
		    	}
			});
		
		menuItemShowClients = new JMenuItem("Show Clients");
		menuMyClients.add(menuItemShowClients);
		menuItemShowClients.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		menuItemShowClients.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    
		    	ArrayList<Object> temp = new ArrayList<>(s.getBuyers().getBuyers());
		    	new PresentationForm(s, temp);
		    	
		    	}
			});
		
		JLabel label_3 = new JLabel("          ");
		menuBar.add(label_3);
		
		menuStatistics = new JMenu("My Statistics");
		menuStatistics.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(menuStatistics);
		
		menuItemSeeStatistics = new JMenuItem("See Statistics");
		menuStatistics.add(menuItemSeeStatistics);
		menuItemSeeStatistics.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		menuItemSeeStatistics.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    
		    	SelectionGui stat = new SelectionGui(s);
				stat.initialize();
		    	}
			});
		

		
		this.setVisible(true);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.setResizable(false);
		this.setBounds(100, 100, 1041, 653);
		this.setTitle("HomePage");
	}
}

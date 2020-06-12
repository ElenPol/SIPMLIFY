import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;


/**
 * OrderManagerForm.java
 * Purpose: The class is the GUI for showing the home page of an OrderManager.
 * @author Bitsa Antouela
 */

public class OrderManagerForm {
	private JFrame frame ;   //frame
	private	JMenuBar ordManagerJMenuBar;
	private	JMenu searchForJMn ;
	private	JMenu myProdJMn;
	private	JMenu myOrdersJMn;
	private	JMenu mySuppliersJMn;
	private	JMenu statisticsJMn;
	private	JMenu forecastJMn;
	private	JMenuItem searchForJMnItm;
	private	JMenuItem productsJMnItm;
	private	JMenuItem suppliersJMnItm ;
	private	JMenuItem addProdJMnItm;
	private	JMenuItem showProdJMnItm ;
	private	JMenuItem addOrderJMnItm;
	private	JMenuItem showOrdJMnItm;
	private	JMenuItem addSupplJMnItm;
	private	JMenuItem showSupplJMnItm;
	private JMenuItem showProposalsJMnItm;
	private	JLabel spaceLabel2;
	private	JLabel spaceLabel1 ;
	private	JLabel spaceLabel3;
	private	JLabel spaceLabel4;
	private	JLabel spaceLabel5;
	private	JPanel panel;
	private	JLabel firstNameJLbl;
	private	JLabel surNameJLbl;
	private	JLabel telephoneJLbl;
	private	JLabel idJLbl;
	private	JLabel typeOfBusinessJLbl;
	private	JLabel resultFirstNameJLbl;
	private	JLabel resultLastNameJLbl;
	private	JLabel resultTelephoneJLbl;
	private	JLabel resultAfmJLbl;
	private	JLabel resultIdJLbl;
	private	JLabel resultSeasonJLbl;
	private	JLabel afmJLbl;
	private	JMenu resultChangeBusinessTypeJMenu;
	private	JButton resultRefreshJBtn;
	private JMenuItem statisticsJMnItm;
	private JLabel businessTypeJLbl;
		
	
	public OrderManagerForm(OrderManager ordManager) {
		frame = new JFrame("Order Manager Menu");
		
		frame.setBounds(100, 100, 1041, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		URL resource2 = getClass().getClassLoader().getResource( "windowLogo.png" );		//window logo
    		Image icon = Toolkit.getDefaultToolkit().getImage(resource2);  
    		frame.setIconImage(icon);
    	
		frame.setResizable(true);
		ordManagerJMenuBar= new JMenuBar();
		ordManagerJMenuBar.setBackground(new Color(255, 228, 196));
		frame.setJMenuBar(ordManagerJMenuBar);
		
		searchForJMn = new JMenu("Search For");
		searchForJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		ordManagerJMenuBar.add(searchForJMn);
		
		
		searchForJMnItm = new JMenuItem("Orders");                                 //Searches for an order
		searchForJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		searchForJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchForm(1, ordManager);
			}
		});
		searchForJMn.add(searchForJMnItm);
		
		
		productsJMnItm = new JMenuItem("Products");                               // Searches for a product
		productsJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		productsJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchForm(2, ordManager);
			}
		});
		searchForJMn.add(productsJMnItm);
		
		
		suppliersJMnItm = new JMenuItem("Suppliers");                           //Searches for a supplier 
		suppliersJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		suppliersJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchForm(3, ordManager);
			}
		});
		searchForJMn.add(suppliersJMnItm);
		
		spaceLabel1 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel1);
		
		myProdJMn = new JMenu("My Products");
		myProdJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		ordManagerJMenuBar.add(myProdJMn);
		
		                                                          
		addProdJMnItm = new JMenuItem("Add a Product");                            //Shows the product form an adds it into the list 
		addProdJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		addProdJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductForm(ordManager);
			}
		});
		myProdJMn.add(addProdJMnItm);
		
		
		
		showProdJMnItm = new JMenuItem("Show a Product");						//Shows a specific product from presentation form 
		showProdJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		showProdJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> temp = new ArrayList<>(ordManager.getProducts().getSupplierProducts()); 			
				new PresentationForm(ordManager, temp);
			}
		});
		myProdJMn.add(showProdJMnItm);
		
		spaceLabel2 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel2);
		
		myOrdersJMn = new JMenu("My Orders");
		myOrdersJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		ordManagerJMenuBar.add(myOrdersJMn);
		
		/* Shows the order form an adds it into the list */
		addOrderJMnItm = new JMenuItem("Add an Order");
		addOrderJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20 ));
		addOrderJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OrderForm(ordManager);
			}
		});
		myOrdersJMn.add(addOrderJMnItm);
		
		
		showOrdJMnItm = new JMenuItem("Show an Order");          //Shows a specific order from presentation form 
		showOrdJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		showOrdJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> temp = new ArrayList<>(ordManager.getOrders().getOrders()); 			
				new PresentationForm(ordManager, temp);
			}
		});
		myOrdersJMn.add(showOrdJMnItm);
		
		spaceLabel3 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel3);
		
		mySuppliersJMn = new JMenu("My Suppliers ");
		mySuppliersJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		ordManagerJMenuBar.add(mySuppliersJMn);
		
		
		addSupplJMnItm = new JMenuItem("Add a Supplier");				// Shows the supplier form an adds it into the list 
		addSupplJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		addSupplJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SupplierForm(ordManager);
			}
		});
		mySuppliersJMn.add(addSupplJMnItm);
		
		
		showSupplJMnItm = new JMenuItem("Show Supplier");             // Shows a specific supplier from presentation form 
		showSupplJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		showSupplJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> temp = new ArrayList<>(ordManager.getSuppliers().getSuppliers()); 			
				new PresentationForm(ordManager, temp);
			}
		});
		mySuppliersJMn.add(showSupplJMnItm);
		
		
		spaceLabel4 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel4);
		
		statisticsJMn = new JMenu("Statistics");   											// Shows the statistics for order manager 
		statisticsJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		ordManagerJMenuBar.add(statisticsJMn);
		
		statisticsJMnItm = new JMenuItem("See Statistics");
		statisticsJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		statisticsJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectionGui stat = new SelectionGui(ordManager);
				stat.initialize();
			}
		});
		
		statisticsJMn.add(statisticsJMnItm);
		ordManagerJMenuBar.add(statisticsJMn);
		statisticsJMn = new JMenu("Statistics");   											// Shows the statistics for order manager 
		statisticsJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		
		
		
		spaceLabel5 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel5);
		
		forecastJMn = new JMenu("Forecast");
		forecastJMn.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		ordManagerJMenuBar.add(forecastJMn);
		
		JMenuItem calculate = new JMenuItem("Calculate");
		calculate.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> listofProposals = new ArrayList<>(ordManager.getProposals().getProposals());
				new Forecast(ordManager);
			}
		});
		forecastJMn.add(calculate);
		
		
		showProposalsJMnItm = new JMenuItem("Show Proposals");
		showProposalsJMnItm.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		showProposalsJMnItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> listofProposals = new ArrayList<>(ordManager.getProposals().getProposals());
				new PresentationForm(ordManager, listofProposals);
			}
		});
		forecastJMn.add(showProposalsJMnItm);
		  
	
		panel = new JPanel();
		panel.setBackground(new Color(136, 177, 179));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setVisible(true);
		
		firstNameJLbl = new JLabel("First Name :");
		firstNameJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 20));
		firstNameJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		firstNameJLbl.setBounds(225, 99, 159, 32);
		panel.add(firstNameJLbl);
		
		surNameJLbl = new JLabel("Surname :");
		surNameJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 20));
		surNameJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		surNameJLbl.setBounds(225, 192, 159, 32);
		panel.add(surNameJLbl);
		
		telephoneJLbl = new JLabel("Telephone :");
		telephoneJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 20));
		telephoneJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		telephoneJLbl.setBounds(225, 272, 159, 32);
		panel.add(telephoneJLbl);
		
		afmJLbl = new JLabel("AFM : ");
		afmJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 20));
		afmJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		afmJLbl.setBounds(225, 360, 159, 32);
		panel.add(afmJLbl);
		
		idJLbl = new JLabel("ID : ");
		idJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 20));
		idJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		idJLbl.setBounds(225, 432, 159, 32);
		panel.add(idJLbl);
		
		typeOfBusinessJLbl = new JLabel("Business Type : ");
		typeOfBusinessJLbl.setFont(new Font("HelveticaNeue", Font.BOLD, 20));
		typeOfBusinessJLbl.setHorizontalAlignment(SwingConstants.LEFT);
		typeOfBusinessJLbl.setBounds(225, 505, 159, 32);
		panel.add(typeOfBusinessJLbl);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 167, 984, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 246, 981, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(27, 331, 981, 2);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(30, 414, 981, 2);
		panel.add(separator_3);	
	
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(30, 480, 981, 2);
		panel.add(separator_4);
		
		resultFirstNameJLbl = new JLabel(ordManager.getFirstName());
		resultFirstNameJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultFirstNameJLbl.setBounds(608, 102, 226, 26);
		panel.add(resultFirstNameJLbl);
		
		resultLastNameJLbl = new JLabel(ordManager.getSurName());
		resultLastNameJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultLastNameJLbl.setBounds(608, 195, 226, 26);
		panel.add(resultLastNameJLbl);
		
		resultTelephoneJLbl = new JLabel(ordManager.getTelephone());
		resultTelephoneJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultTelephoneJLbl.setBounds(608, 275, 226, 26);
		panel.add(resultTelephoneJLbl);
		
		resultAfmJLbl = new JLabel(ordManager.getAFM());
		resultAfmJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultAfmJLbl.setBounds(608, 360, 226, 26);
		panel.add(resultAfmJLbl);
		
		resultIdJLbl = new JLabel(ordManager.getId());
		resultIdJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultIdJLbl.setBounds(608, 432, 226, 26);
		panel.add(resultIdJLbl);
		
		if (ordManager.getRegular()) {
			businessTypeJLbl = new JLabel("Regular");
		}else {
			businessTypeJLbl = new JLabel("Seasonal ");
		}
		
		businessTypeJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		businessTypeJLbl.setBounds(608, 505, 226, 26);
		panel.add(businessTypeJLbl);
		
		resultSeasonJLbl = new JLabel(ordManager.getSeason());
		resultSeasonJLbl.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultSeasonJLbl.setBounds(690, 505, 226, 26);
		panel.add(resultSeasonJLbl);
		
		spaceLabel5 = new JLabel("        ");
		ordManagerJMenuBar.add(spaceLabel5);      
		
		resultChangeBusinessTypeJMenu = new JMenu("Business Type");    
		resultChangeBusinessTypeJMenu.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20)); // Changes the type of business 
		
		JMenuItem changeBusinessTypeJMItem = new JMenuItem("BusinessType");
		changeBusinessTypeJMItem.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
		changeBusinessTypeJMItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame1 = new JFrame();
				frame1.setBounds(100, 100, 592, 327);
				frame1.setTitle("Business Type");
				frame1.getContentPane().setBackground(new Color(136, 177, 179));
				//frame1.getContentPane().setLayout(new GridLayout());
				
				URL resource2 = getClass().getClassLoader().getResource( "windowLogo.png" );
		    	Image icon = Toolkit.getDefaultToolkit().getImage(resource2);  
		    	frame1.setIconImage(icon);
		    	
				JLabel lblchange = new JLabel("Do you want to change your business type?");
				lblchange.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
				lblchange.setBounds(51, 22, 488, 31);
				frame1.getContentPane().add(lblchange);
				
				JButton btnRegular = new JButton("Regular");
				btnRegular.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
				btnRegular.setBounds(51, 249, 206, 31);
				frame1.getContentPane().add(btnRegular);
				btnRegular.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ordManager.setRegular(true);
						businessTypeJLbl.setText("Regular");
						resultSeasonJLbl.setText("");
						JOptionPane.showMessageDialog(frame, " The Type Of Business Has Changed To : Regular ", " Update ", JOptionPane.INFORMATION_MESSAGE);
					}
				});
				
				JButton btnSeasonal = new JButton("Seasonal");
				btnSeasonal.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
				btnSeasonal.setBounds(333, 249, 206, 31);
				frame1.getContentPane().add(btnSeasonal);
				btnSeasonal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						ordManager.setRegular(false);
						businessTypeJLbl.setText("Seasonal");
						
						JFrame frame2 = new JFrame();
						frame2.setTitle("Season");
						frame2.setBounds(100, 100, 556, 327);
						frame2.getContentPane().setBackground(new Color(136, 177, 179));
						frame2.getContentPane().setLayout(null);
						
						URL resource3 = getClass().getClassLoader().getResource( "windowLogo.png" );
				    		Image icon1 = Toolkit.getDefaultToolkit().getImage(resource3);  
				    		frame2.setIconImage(icon1);
				    	
						JLabel lblChooseSeasons = new JLabel("Choose Seasons :");
						lblChooseSeasons.setFont(new Font("HelveticaNeue", Font.PLAIN, 25));
						lblChooseSeasons.setBounds(171, 33, 201, 31);
						frame2.getContentPane().add(lblChooseSeasons);
						
						JButton btnAutumnWinter = new JButton(" Autumn - Winter");
						btnAutumnWinter.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
						btnAutumnWinter.setBounds(60, 247, 201, 33);
						frame2.getContentPane().add(btnAutumnWinter);
						btnAutumnWinter.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ordManager.setSeason(" Autumn - Winter");
								resultSeasonJLbl.setText(ordManager.getSeason());
								if (resultSeasonJLbl.getText() == " Autumn - Winter") {
									JOptionPane.showMessageDialog(frame, " The season changed to: Autumn - Winter", " Update ", JOptionPane.INFORMATION_MESSAGE);
								}
							}
						});
						
						JButton btnSpringSummer = new JButton(" Spring - Summer");
						btnSpringSummer.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
						btnSpringSummer.setBounds(305, 247, 201, 33);
						frame2.getContentPane().add(btnSpringSummer);
						btnSpringSummer.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ordManager.setSeason(" Spring - Summer");
								resultSeasonJLbl.setText(ordManager.getSeason());
								if (resultSeasonJLbl.getText() == " Spring - Summer") {
									JOptionPane.showMessageDialog(frame, " The season changed to: Spring - Summer", " Update ", JOptionPane.INFORMATION_MESSAGE);
								}
							}
						});
						frame2.setResizable(false);
						frame2.setLayout(null); 
						frame2.setVisible(true);	
					}
				});
				frame1.setLayout(null);
				frame1.setVisible(true);
			}
		});
		resultChangeBusinessTypeJMenu.add(changeBusinessTypeJMItem);
		ordManagerJMenuBar.add(resultChangeBusinessTypeJMenu);
		
		                                                                     
		resultRefreshJBtn = new JButton("Refresh");                     // Refreshes all the changes that has been made in the array lists to the database 
		resultRefreshJBtn.setFont(new Font("HelveticaNeue", Font.BOLD, 10));
		resultRefreshJBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordManager.refresh();
			}
		});
		resultRefreshJBtn.setBounds(936, 510, 89, 74);
		panel.add(resultRefreshJBtn);
		panel.setVisible(true);
		frame.setVisible(true);
		
	}
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * StockkeeperForm.java
 * Purpose: The class is the GUI for showing the home page of a Stockkeeper.
 * @author Manoli Christina
 */

public class StockkeeperForm extends JFrame{
   
	private JPanel panel;
	private JButton Refreshbutton;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblTelephone;
	private JLabel lblAFM ;
	private JLabel lblID;
	private JLabel resultName;
	private JLabel resultSurname;
	private JLabel resultTelephone;
	private JLabel resultAFM;
	private JLabel resultID;
	private JSeparator firstSeparator;
	private JSeparator secondSeparator;
	private JSeparator thirdSeparator;
	private JSeparator fourthSeparator;
	private JMenu mnSearchFor;
	private JMenuBar menuBar;
	private JMenuItem mntmOrder;
	

	public StockkeeperForm(Stockkeeper stk)
	{
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(136, 177, 179));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	
		URL resource3 = getClass().getClassLoader().getResource( "windowLogo.png" );
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(resource3));
		
		Icon icon = new ImageIcon("refresh.png");
		Refreshbutton = new JButton(icon);
		Refreshbutton.setToolTipText("Refresh your data");
		Refreshbutton.setBounds(947, 516, 78, 68);
		panel.add(Refreshbutton);
		
		lblName = new JLabel("First Name :");
		lblName.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		lblName.setBounds(225, 99, 159, 32);
		panel.add(lblName);
		
		lblSurname = new JLabel("SurName :");
		lblSurname.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		lblSurname.setBounds(225, 192, 159, 32);
		panel.add(lblSurname);
		
		lblTelephone = new JLabel("Telephone :");
		lblTelephone.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		lblTelephone.setBounds(225, 272, 159, 32);
		panel.add(lblTelephone);
		
		lblAFM = new JLabel("AFM :");
		lblAFM.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		lblAFM.setBounds(225, 355, 159, 32);
		panel.add(lblAFM);
		
		lblID = new JLabel("ID :");
		lblID.setFont(new Font("HelveticaNeue", Font.BOLD, 24));
		lblID.setBounds(225, 427, 159, 32);
		panel.add(lblID);
		
		
		resultName = new JLabel(stk.firstName);
		resultName.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultName.setBounds(608, 102, 226, 26);
		panel.add(resultName);
		
		resultSurname = new JLabel(stk.surName);
		resultSurname.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultSurname.setBounds(608, 195, 226, 26);
		panel.add(resultSurname);
		
		resultTelephone = new JLabel(stk.telephone);
		resultTelephone.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultTelephone.setBounds(608, 275, 226, 26);
		panel.add(resultTelephone);
		
		resultAFM = new JLabel(stk.AFM);
		resultAFM.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultAFM.setBounds(608, 358, 226, 26);
		panel.add(resultAFM);
		
		resultID = new JLabel(stk.id);
		resultID.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		resultID.setBounds(608, 430, 226, 26);
		panel.add(resultID);
		
		Refreshbutton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				stk.refresh();
			}	
		});
		
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
		
		
		this.setVisible(true);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.setResizable(false);
		this.setTitle("HomePage");
		this.setBounds(100, 100, 1041, 653);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBackground(new Color(255, 228, 196));

		
		mnSearchFor = new JMenu("Search for");
		mnSearchFor.setFont(new Font("HelveticaNeue", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(mnSearchFor);
		
		mntmOrder = new JMenuItem("Order");
		mntmOrder.setFont(new Font("HelveticaNeue", Font.ITALIC, 15));
		mnSearchFor.add(mntmOrder);

		mntmOrder.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
					new SearchForm(1, stk);
			}	
		});
	}
}

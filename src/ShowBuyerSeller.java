import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

/**
 * ShowBuyerSeller.java
 * Purpose: The class is the GUI for showing a single Buyer or Supplier.
 * @author Gkouli Nikoleta
 */

public class ShowBuyerSeller {
	private JFrame frame;
	private JLabel lblName;
	private JLabel lblLastName;
	private JLabel lblId;
	private	JLabel lblAfm;
	private	JLabel lblPhoneNumber;
	private JLabel labelName;
	private JLabel labelLastName;
	private JLabel labelId;
	private JLabel labelAfm;
	private JLabel labelPhoneNumber;
	private	JSeparator separator ;
	private	JSeparator separator_1;
	private JSeparator separator_2 ;
	private JSeparator separator_3;
		
	public ShowBuyerSeller(Object o){
		frame = new JFrame();
		frame.setBounds(100, 100, 1041, 653);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBounds(new Rectangle(100, 100, 1041, 653));
		frame.getContentPane().setBackground(new Color(136, 177, 179));
		frame.setResizable(false);
		
		URL resource2 = getClass().getClassLoader().getResource( "windowLogo.png" );
    		Image icon = Toolkit.getDefaultToolkit().getImage(resource2);  
    		frame.setIconImage(icon);
		
		lblName = new JLabel("First name :");
		lblName.setBounds(144, 70, 150, 32);
		lblName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblName);
		
		lblLastName = new JLabel("Last name :");
		lblLastName.setBounds(144, 170, 150, 32);
		lblLastName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblLastName);
		
		lblId = new JLabel("ID :");
		lblId.setBounds(144, 282, 150, 32);
		lblId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblId);
		
		lblAfm = new JLabel("AFM :");
		lblAfm.setBounds(144, 385, 150, 32);
		lblAfm.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblAfm);
		
		lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setBounds(144, 486, 270, 65);
		lblPhoneNumber.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(lblPhoneNumber);
		
		labelName = new JLabel();
		labelName.setBounds(613, 70, 190, 32);
		labelName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelName);
	
		labelLastName = new JLabel();
		labelLastName.setBounds(613, 170, 264, 32);
		labelLastName.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelLastName);
	
		labelId = new JLabel();
		labelId.setBounds(613, 282, 190, 32);
		labelId.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelId);
	
		labelAfm = new JLabel();
		labelAfm.setBounds(613, 385, 190, 32);
		labelAfm.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelAfm);

		
		labelPhoneNumber = new JLabel();
		labelPhoneNumber.setBounds(613, 494, 190, 32);
		labelPhoneNumber.setFont(new Font("HelveticaNeue", Font.PLAIN,24));
		frame.getContentPane().add(labelPhoneNumber);
		
		separator = new JSeparator();
		separator.setBounds(10, 245, 1015,2);
		frame.getContentPane().add(separator);
	
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 349, 1015, 2);
		frame.getContentPane().add(separator_1);
	
		separator_2 = new JSeparator();
		separator_2.setBounds(10, 455, 1015, 2);
		frame.getContentPane().add(separator_2);
	
		separator_3 = new JSeparator();
		separator_3.setBounds(10, 132, 1015, 2);
		frame.getContentPane().add(separator_3);
		
		if (o instanceof Buyer) {
			Buyer byr = (Buyer) o;
		
			frame.setTitle("Buyer Information");
			labelName.setText(byr.getName());
			labelLastName.setText(byr.getLastName());
			labelAfm.setText(byr.getAFM());
			labelId.setText(byr.getId());
			labelPhoneNumber.setText(byr.getPhoneNumber());
			
		}else if (o instanceof Supplier) {
			Supplier supplier = (Supplier) o;
			
			frame.setTitle("Supplier information");
			labelName.setText(supplier.getName());
			labelLastName.setText(supplier.getLastName());
			labelAfm.setText(supplier.getAFM());
			labelId.setText(supplier.getId());
			labelPhoneNumber.setText(supplier.getPhoneNumber());
			
		}
		frame.setVisible(true);
	}
	
	
}

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

/**LogginForm.java
 * Purpose : Displays the GUI of a loggin form when a user wants to enter the system.
 * The user enters their username and password, and the system, either: authenticates them successfully redirecting the user
 * to OrderManagerForm() or SellerForm() or StockkeeperForm()
 * or shows message
 * @author Vlasakoudi Christina
 */
public class LogginForm extends JFrame{
    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private JLabel lblUserName;
    private JLabel lblPassword;
    private JLabel imagelbl;
    private JPasswordField passwordField;
    private JButton btnNewButton; 
    private boolean errorFlag;//false if there is no error else true
	private User user;
	
    public LogginForm() {
    	this.user = new User();
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(136, 177, 179));
        
    	lblUserName = new JLabel(" Username :");           //Username label
    	lblUserName.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
    	lblUserName.setBounds(175, 387, 145, 40);
    	frame.getContentPane().add(lblUserName);
    	
    	lblPassword = new JLabel("Password :");          //password label
    	lblPassword.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
    	lblPassword.setBounds(175, 453, 150, 46);
    	frame.getContentPane().add(lblPassword);
    	
    	textField = new JTextField();          //name textfield
    	textField.setBounds(367, 401, 219, 25);
    	frame.getContentPane().add(textField);
    	textField.setColumns(10);
    		
    	btnNewButton = new JButton("Log In");          //button loggin
    	btnNewButton.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
    	btnNewButton.setBounds(420, 547, 109, 40);
    	frame.getContentPane().add(btnNewButton);
    	
    	URL resource = getClass().getClassLoader().getResource( "organisedorders.png" );
    	ImageIcon image = new ImageIcon( resource );
    	imagelbl = new JLabel(image);
    	imagelbl.setBounds(120, 36, 535, 316);
    	frame.getContentPane().add(imagelbl);
    	
    	URL resource2 = getClass().getClassLoader().getResource( "windowLogo.png" );
    	Image icon = Toolkit.getDefaultToolkit().getImage(resource2);  
    	frame.setIconImage(icon);  
    	
    		
    	passwordField = new JPasswordField();           //password textfield
    	passwordField.setBounds(367, 470, 219, 25);
    	frame.getContentPane().add(passwordField);
    		
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				
                String Userid = textField.getText();
    			char[] password = passwordField.getPassword();
    			String Userspassword = new String(password);
    			if( checkError(Userid,Userspassword) ){
    				if (Userid.startsWith("OR")) {
     				    OrderManager or = (OrderManager) user;
     				    or.initializeLists();
    					new OrderManagerForm(or) ;	
    					frame.setVisible(false);
    					frame.dispose();
    					
    				}else if(Userid.startsWith("SE")) {
    					Seller se = (Seller) user;
    					se.initializeLists();
    					new SellerForm(se);
    					frame.setVisible(false);
    					frame.dispose();
    					
    					
    				}else if(Userid.contains("ST")) {
    					Stockkeeper st = (Stockkeeper) user;
    					st.initializeLists();
    					new StockkeeperForm(st);
    					frame.setVisible(false);
    					frame.dispose();
    					
    				}
    			}
    	}});
    	
    	frame.setBounds(100, 100, 811, 677); 
		frame.setTitle("Login");
		frame.setResizable(false);
		frame.setLayout(null); 
		frame.setVisible(true);
    				
    	}
    	/**
    	 * Checks if the user sets the correct username and password		
    	 * @param Userid			username
    	 * @param userspassword		the password 
    	 * @return 					true if the user has given the correct username and password
    	 */
    	private boolean checkError(String Userid,String userspassword ) {
    		
    		errorFlag = false;
			Users users = new Users();
			users.extractObjectDB();
			for(User u : users.getUsers()){
				
				if (u.getId().equals(Userid)){
					if (userspassword.length() < 8) 
						 JOptionPane.showMessageDialog(panel, "Password length should be between 8 characters"); 
					else{
						if (userspassword.equals(u.getPassword())) {
							user = u;
							return errorFlag = true ;
						}else if( !(userspassword.contains("!") || userspassword.contains(".") || userspassword.contains(",") || userspassword.contains("*"))){
						  JOptionPane.showMessageDialog(panel, "Password should contain at least one special character ");
					     
					   	 }else if (! userspassword.matches(".*[0-9].*")){
						   JOptionPane.showMessageDialog(panel, "Password should at least contain one digit");
						   
			            	    	}else{ 
					            int count1 = 0; 
					            for (int i = 65; i <= 90; i++) {               // checking capital letters 
					  
					                char c = (char)i;                         // type casting 
					                String str1 = Character.toString(c); 
					                if ( u.getPassword().contains(str1))
					                    count1 = 1;
					            } 
					            int count2 = 0; 
					            for (int i = 90; i <= 122; i++) {              // checking small letters 
					  
					                char c = (char)i;                          // type casting 
					                String str1 = Character.toString(c); 
					                if ( u.getPassword().contains(str1)) { 
					                    count2 = 1; 
					                } 
					            } 
					            if (count2 == 0 || count1 ==0) 
					            	 JOptionPane.showMessageDialog(this, "Password should contain at least one lowercase letter(a-z) and uppercase letter(A-Z)", "Loggin", JOptionPane.DEFAULT_OPTION); 
					        }
					}
				}
			}
			if (errorFlag == false) {
				JOptionPane.showMessageDialog(this, "Invalid username or password", "Loggin", JOptionPane.DEFAULT_OPTION);
			}
    		return errorFlag;
    }
}    

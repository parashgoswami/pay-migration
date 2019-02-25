package matfin.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class Login extends JFrame {

	private Container container= getContentPane();
	private JLabel loginIdLbl = new JLabel("Login Id :");
	private JLabel passwordLbl = new JLabel("Password:");	
	private JTextField loginTxt = new JTextField();
	private JPasswordField passwordTxt = new JPasswordField();
	private JButton loginBtn = new JButton("LOGIN");
	private JButton resetBtn = new JButton("RESET");
	
	public Login() {
		setTitle("LOGIN :: MATFIN");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(130, 130, 450, 250);
		container.setBackground(new Color(255, 245, 238));		
		container.setLayout(null);
		setUpUi();
			
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processLogin();
			}			
		});
		
				
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFormAction();
			}			
		});
				
	}
	
    private void setUpUi() {
    	loginIdLbl.setForeground(new Color(72, 61, 139));
    	loginIdLbl.setFont(new Font("Arial", Font.BOLD, 12));
    	loginIdLbl.setBounds(22, 45, 89, 22);
    	container.add(loginIdLbl);
    	
    	loginTxt.setBorder(new CompoundBorder(new LineBorder(new Color(191, 205, 219)), null));
		loginTxt.setBackground(new Color(255, 255, 224));
		loginTxt.setBounds(136, 43, 120, 20);	
		loginTxt.setColumns(10);
		container.add(loginTxt);
		
    	passwordLbl.setForeground(new Color(72, 61, 139));
    	passwordLbl.setFont(new Font("Arial", Font.BOLD, 12));
    	passwordLbl.setBounds(22, 93, 89, 14);
    	container.add(passwordLbl);
    	
    	passwordTxt.setBackground(new Color(255, 255, 224));
		passwordTxt.setBorder(new LineBorder(new Color(191, 205, 219)));
		passwordTxt.setBounds(136, 91, 120, 20);
		container.add(passwordTxt);
    	
		loginBtn.setBounds(90, 140, 89, 23);
		container.add(loginBtn);
		
		resetBtn.setBounds(204, 140, 89, 23);
		container.add(resetBtn);
    	
		
    }
    
	private void clearFormAction() {
		loginTxt.setText("");
		passwordTxt.setText("");
		loginTxt.requestFocus();
		
	}
	
	
	
	private void processLogin() {
		String login = loginTxt.getText().trim();
		String password = String.valueOf(passwordTxt.getPassword()).trim();
		
		if(login.equals("admin") && password.equals("neepco")){
			PayImageMigration payImageFrm = new PayImageMigration();
			payImageFrm.setVisible(true);
			dispose();
			
		}else {
			JOptionPane.showMessageDialog(this, "Inavlid Login ID/Password", "Error", JOptionPane.ERROR_MESSAGE);
		}
						
	}

}

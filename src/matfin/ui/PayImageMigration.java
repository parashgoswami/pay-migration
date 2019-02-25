package matfin.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.Panel;
import java.awt.Label;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import matfin.bo.PayImageMigrationBO;

public class PayImageMigration extends JFrame {
	private Container container= getContentPane();
	private JPanel statusPane;
	private JLabel serverLbl=new JLabel("Server IP");;
	private JLabel portLbl = new JLabel("Port");
	private JLabel userIdLbl = new JLabel("User Id");
	private JLabel pwdLbl = new JLabel("Password");
	private JLabel yearLbl = new JLabel("Year");
	private JLabel monthLbl = new JLabel("Month");
	private JTextField serverTxt = new JTextField();
	private JTextField portTxt = new JTextField();;
	private JTextField userIdTxt = new JTextField();;
	private JPasswordField pwdTxt = new JPasswordField();
	private JComboBox<String> yearCombo;
	
	private JComboBox monthCombo = new JComboBox();
	private JLabel statusLbl = new JLabel();
	private JButton processBtn = new JButton("PROCESS");
	private JButton resetBtn = new JButton("RESET");
	private JProgressBar progressBar = new JProgressBar();
	private JPanel statusPanel = new JPanel();
	
	
	public PayImageMigration() {
		
		setTitle("MATFIN :: Pay Image Migration");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 520, 350);
		
		container.setBackground(new Color(255, 245, 238));		
		container.setLayout(null);
		setUpUi();
		
		processBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				progressBar.setVisible(true);
				processBtn.setEnabled(false);
				statusLbl.setText("Processing...");
				statusLbl.setVisible(true);
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				migrationAction();			
			}
		});
		
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();	
			}
		});
		
	}
	
	
	private void resetForm() {
		serverTxt.setText("");
		portTxt.setText("");
		userIdTxt.setText("");
		pwdTxt.setText("");
	
		yearCombo.setSelectedIndex(0);;
		monthCombo.setModel(new MonthComboBoxModel(setupMonths()));
		serverTxt.requestFocus();
	}
	private void migrationAction() {
		
		int count =0;
		String url=serverTxt.getText().trim();
		String port=portTxt.getText().trim();
		String userId=userIdTxt.getText().trim();
		String password=String.valueOf(pwdTxt.getPassword()).trim();
		String year=(String)yearCombo.getSelectedItem();
	    Month mon =(Month) monthCombo.getSelectedItem();
	    String month = mon.getId();
	    
	    //---
	    
	    SwingWorker<String, Integer> sw = new SwingWorker<String, Integer>() {

			@Override
			protected String doInBackground() throws Exception {
				String res;
				int count = new PayImageMigrationBO().migrate(url,port,userId,password,year.trim()+month.trim());
				publish(count);	
				
				if (count ==0) {					
					res="Error: 0 rows migated.";					
					
				}else {
					res="Success:"+count +" rows migated.";					
				}
				
				
				return res;
			}

			@Override
			protected void process(List<Integer> chunks) {
				int val = chunks.get(chunks.size()-1);
				statusLbl.setText(String.valueOf(val));
			}

			@Override
			protected void done() {
				try {
					String result = get();
					statusLbl.setText(result);
					setCursor(null);
					progressBar.setVisible(false);
					processBtn.setEnabled(true);
				}catch (InterruptedException e) {
					e.printStackTrace();
			    }catch (ExecutionException e) {
					e.printStackTrace();
			    }			
			};			
	
	};
	sw.execute();
	 
	}

	private void setUpUi() {
		serverLbl.setBounds(29, 30, 55, 14);
		container.add(serverLbl);
		
		serverTxt.setBorder(new CompoundBorder(new LineBorder(new Color(191, 205, 219)), null));
		serverTxt.setBackground(new Color(255, 248, 220));
		serverTxt.setBounds(120, 28, 120, 20);
		container.add(serverTxt);
		
		portLbl.setBounds(260, 30, 30, 14);
		container.add(portLbl);
		
		portTxt.setBorder(new CompoundBorder(new LineBorder(new Color(191, 205, 219)), null));
		portTxt.setBackground(new Color(255, 248, 220));
		portTxt.setBounds(300, 28, 66, 20);
		container.add(portTxt);
		
		userIdLbl.setBounds(29, 80, 55, 14);		
		container.add(userIdLbl);
		
		userIdTxt.setBorder(new CompoundBorder(new LineBorder(new Color(191, 205, 219)), null));
		userIdTxt.setBackground(new Color(255, 248, 220));
		userIdTxt.setBounds(120, 78, 120, 20);
		container.add(userIdTxt);
		
		
		pwdLbl.setBounds(29, 130, 60, 14);		
		container.add(pwdLbl);
		
		pwdTxt.setBorder( new CompoundBorder(new LineBorder(new Color(191, 205, 219)), null));
		pwdTxt.setBackground(new Color(255, 248, 220));
		pwdTxt.setBounds(120, 128, 120, 20);
		container.add(pwdTxt);
		
		yearLbl.setBounds(29, 180, 48, 14);		
		container.add(yearLbl);
		
		yearCombo = createYearCombo();
		yearCombo.setBorder( new CompoundBorder(new LineBorder(new Color(191, 205, 219)), null));
		yearCombo.setBackground(new Color(255, 248, 220));
		yearCombo.setBounds(120, 178, 120, 20);
		container.add(yearCombo);
		
		monthLbl.setBounds(260, 180, 48, 14);		
		container.add(monthLbl);
		
		Month[] months = setupMonths();
		MonthComboBoxModel model = new MonthComboBoxModel(months);
		monthCombo.setModel(model);
		monthCombo.setBackground(new Color(255, 248, 220));
		monthCombo.setBounds(300, 178, 120, 20);		
	    container.add(monthCombo);
		
		processBtn.setBounds(80, 230, 95, 23);
		container.add(processBtn);
		
		resetBtn.setBounds(200, 230, 95, 23);
		container.add(resetBtn);
		statusPanel.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), null));
		
		statusPanel.setBackground(SystemColor.control);		
		statusPanel.setBounds(-5, 286, 520, 35);		
		statusPanel.setLayout(null);
		
		container.add(statusPanel);
		progressBar.setBounds(337, 8, 130, 14);
		progressBar.setIndeterminate(true);
		progressBar.setVisible(false);
		statusPanel.add(progressBar);	
		
		statusLbl.setBounds(80, 8, 180, 14);	
		progressBar.setVisible(false);
		statusPanel.add(statusLbl);
		
	}
	
	private JComboBox<String> createYearCombo() {		
	    final JComboBox<String> cbox = new JComboBox<String>();
	    int currentYear = Calendar.getInstance().get(Calendar.YEAR);	  
	    cbox.addItem(Integer.toString(currentYear));
	    cbox.addItem(Integer.toString(currentYear-1));	    
	    return cbox;	    
	}
	
	private Month[] setupMonths() {
		return new Month[] {
				new Month("01","January"),
				new Month("02","February"),
				new Month("03","March"),
				new Month("04","April"),
				new Month("05","May"),
				new Month("06","June"),
				new Month("07","July"),
				new Month("08","August"),
				new Month("09","September"),
				new Month("10","October"),
				new Month("11","November"),
				new Month("12","December"),
		};
		
	}
}

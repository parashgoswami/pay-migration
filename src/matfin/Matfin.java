package matfin;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import matfin.ui.Login;
import matfin.ui.PayImageMigration;

public class Matfin {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {

						UIManager.setLookAndFeel(
								// UIManager.getSystemLookAndFeelClassName());
								"javax.swing.plaf.metal.MetalLookAndFeel");
						// "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					} catch (UnsupportedLookAndFeelException e) {}
					
					Login loginFrm = new Login();
					loginFrm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}

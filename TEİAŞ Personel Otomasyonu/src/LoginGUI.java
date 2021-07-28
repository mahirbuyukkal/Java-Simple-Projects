import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;

public class LoginGUI extends JFrame {

	private JPanel w_pane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setTitle("TE\u0130A\u015E Personel Otomasyon Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 508);
		w_pane = new JPanel();
		w_pane.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("logo.png")));
		lbl_logo.setBounds(578, 11, 89, 84);
		w_pane.add(lbl_logo);
		
		JLabel lblNewLabel = new JLabel("TE\u0130A\u015E 16. B\u00F6lge M\u00FCd\u00FCrl\u00FC\u011F\u00FC Personel Otomasyon Sistemi");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setBounds(129, 110, 419, 32);
		w_pane.add(lblNewLabel);
		
		JTabbedPane w_tabpane = new JTabbedPane(JTabbedPane.TOP);
		w_tabpane.setBounds(10, 180, 657, 278);
		w_pane.add(w_tabpane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		w_tabpane.addTab("Yetkili Giriþi", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblTc = new JLabel("T.C. Kimlik Numaran\u0131z:");
		lblTc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblTc.setBounds(52, 43, 161, 32);
		panel.add(lblTc);
		
		JLabel lblifre = new JLabel("\u015Eifre:");
		lblifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblifre.setBounds(52, 100, 161, 32);
		panel.add(lblifre);
		
		textField = new JTextField();
		textField.setBounds(223, 46, 304, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(223, 100, 304, 32);
		panel.add(textField_1);
	}
}

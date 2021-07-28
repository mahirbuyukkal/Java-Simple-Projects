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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame {

	private JPanel w_pane;
	private JTextField fld_yetkiliTc;
	private JTextField fld_yetkiliPass;
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
		w_pane.setBackground(new Color(215, 228, 242));
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
		
		JPanel w_yetkiliLogin = new JPanel();
		w_yetkiliLogin.setBackground(new Color(255, 250, 250));
		w_tabpane.addTab("Yetkili Giriþi", null, w_yetkiliLogin, null);
		w_yetkiliLogin.setLayout(null);
		
		JLabel lblTc = new JLabel("T.C. Kimlik Numaran\u0131z:");
		lblTc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblTc.setBounds(52, 43, 161, 32);
		w_yetkiliLogin.add(lblTc);
		
		JLabel lblifre = new JLabel("\u015Eifre:");
		lblifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblifre.setBounds(52, 100, 161, 32);
		w_yetkiliLogin.add(lblifre);
		
		fld_yetkiliTc = new JTextField();
		fld_yetkiliTc.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		fld_yetkiliTc.setBounds(223, 46, 304, 32);
		w_yetkiliLogin.add(fld_yetkiliTc);
		fld_yetkiliTc.setColumns(10);
		
		fld_yetkiliPass = new JTextField();
		fld_yetkiliPass.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		fld_yetkiliPass.setColumns(10);
		fld_yetkiliPass.setBounds(223, 100, 304, 32);
		w_yetkiliLogin.add(fld_yetkiliPass);
		
		JButton btn_yetkiliLogin = new JButton("Giri\u015F Yap");
		btn_yetkiliLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_yetkiliLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btn_yetkiliLogin.setBounds(223, 175, 131, 32);
		w_yetkiliLogin.add(btn_yetkiliLogin);
		
		JButton btn_register = new JButton("Yeni Kay\u0131t");
		btn_register.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btn_register.setBounds(396, 175, 131, 32);
		w_yetkiliLogin.add(btn_register);
		
		JPanel w_muhendisLogin = new JPanel();
		w_muhendisLogin.setBackground(new Color(255, 250, 250));
		w_tabpane.addTab("Mühendis Giriþi", null, w_muhendisLogin, null);
		w_muhendisLogin.setLayout(null);
		
		JLabel lblTc_1 = new JLabel("T.C. Kimlik Numaran\u0131z:");
		lblTc_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblTc_1.setBounds(51, 43, 161, 32);
		w_muhendisLogin.add(lblTc_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(222, 46, 304, 32);
		w_muhendisLogin.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(222, 100, 304, 32);
		w_muhendisLogin.add(textField_1);
		
		JLabel lblifre_1 = new JLabel("\u015Eifre:");
		lblifre_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblifre_1.setBounds(51, 100, 161, 32);
		w_muhendisLogin.add(lblifre_1);
		
		JButton btn_muhendisLogin = new JButton("Giri\u015F Yap");
		btn_muhendisLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btn_muhendisLogin.setBounds(222, 175, 304, 32);
		w_muhendisLogin.add(btn_muhendisLogin);
	}
}

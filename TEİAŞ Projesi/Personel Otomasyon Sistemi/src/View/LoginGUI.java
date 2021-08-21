package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import Helper.*;
import Model.Muhendis;
import Model.Yetkili;

public class LoginGUI extends JFrame {

	private JPanel w_pane;
	private JTextField fld_muhendisTc;
	private JPasswordField fld_muhendisPass;
	private JPasswordField fld_yetkiliPass;
	private JTextField fld_yetkiliTc;
	private DBConnection conn = new DBConnection();

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 520);
		w_pane = new JPanel();
		w_pane.setBackground(new Color(240, 248, 255));
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("logo.png")));
		lbl_logo.setBounds(618, 10, 69, 75);
		w_pane.add(lbl_logo);
		
		JLabel lblNewLabel = new JLabel("TE\u0130A\u015E 16. B\u00F6lge M\u00FCd\u00FCrl\u00FC\u011F\u00FC Personel Otomosyon Sistemi");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel.setBounds(154, 115, 394, 25);
		w_pane.add(lblNewLabel);
		
		JTabbedPane w_tabpane = new JTabbedPane(JTabbedPane.TOP);
		w_tabpane.setBounds(0, 177, 687, 305);
		w_pane.add(w_tabpane);
		
		JPanel w_doktorLogin = new JPanel();
		w_doktorLogin.setBackground(new Color(176, 196, 222));
		w_tabpane.addTab("Yetkili Giriþi", null, w_doktorLogin, null);
		w_doktorLogin.setLayout(null);
		
		JButton btn_yetkiliLogin = new JButton("Giri\u015F Yap");
		btn_yetkiliLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fld_yetkiliTc.getText().length() == 0 || fld_yetkiliPass.getText().length() == 0) {
					
					Helper.showMsg("fill");
				}else {
					
					try {
						Connection con = conn.connDb();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM user");
						while(rs.next()) {
							
							if(fld_yetkiliTc.getText().equals(rs.getString("tcno")) && fld_yetkiliPass.getText().equals(rs.getString("password"))) {
								
								if(rs.getString("type").equals("Yetkili")) {
									Yetkili ymuhendis = new Yetkili();
									ymuhendis.setId(rs.getInt("id"));
									ymuhendis.setPassword("password");
									ymuhendis.setTcno(rs.getString("tcno"));
									ymuhendis.setName(rs.getString("name"));
									ymuhendis.setType(rs.getString("type"));
									YetkiliGUI yGUI = new YetkiliGUI(ymuhendis);
									yGUI.setVisible(true);
									dispose();
								}
								
								if(rs.getString("type").equals("Mühendis")) {
									Muhendis muhendis = new Muhendis();
									muhendis.setId(rs.getInt("id"));
									muhendis.setPassword("password");
									muhendis.setTcno(rs.getString("tcno"));
									muhendis.setName(rs.getString("name"));
									muhendis.setType(rs.getString("type"));
									MuhendisGUI mGUI = new MuhendisGUI(muhendis);
									mGUI.setVisible(true);
									dispose();
								}
								
							}
						}
						
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		btn_yetkiliLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btn_yetkiliLogin.setBounds(223, 198, 350, 37);
		w_doktorLogin.add(btn_yetkiliLogin);
		
		JLabel lblTcNumaranz_1 = new JLabel("T.C. Numaran\u0131z: ");
		lblTcNumaranz_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblTcNumaranz_1.setBounds(68, 64, 114, 25);
		w_doktorLogin.add(lblTcNumaranz_1);
		
		JLabel lblifre_1 = new JLabel("\u015Eifre: ");
		lblifre_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblifre_1.setBounds(68, 128, 114, 25);
		w_doktorLogin.add(lblifre_1);
		
		fld_yetkiliPass = new JPasswordField();
		fld_yetkiliPass.setBounds(223, 125, 350, 37);
		w_doktorLogin.add(fld_yetkiliPass);
		
		fld_yetkiliTc = new JTextField();
		fld_yetkiliTc.setColumns(10);
		fld_yetkiliTc.setBounds(223, 61, 350, 37);
		w_doktorLogin.add(fld_yetkiliTc);
		
		JPanel w_muhendisLogin = new JPanel();
		w_muhendisLogin.setBackground(new Color(176, 196, 222));
		w_tabpane.addTab("Staj Öðrenci", null, w_muhendisLogin, null);
		w_muhendisLogin.setLayout(null);
		
		JLabel lblTcNumaranz = new JLabel("T.C. Numaran\u0131z: ");
		lblTcNumaranz.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblTcNumaranz.setBounds(66, 63, 114, 25);
		w_muhendisLogin.add(lblTcNumaranz);
		
		JLabel lblifre = new JLabel("\u015Eifre: ");
		lblifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblifre.setBounds(66, 127, 114, 25);
		w_muhendisLogin.add(lblifre);
		
		fld_muhendisTc = new JTextField();
		fld_muhendisTc.setBounds(221, 60, 350, 37);
		w_muhendisLogin.add(fld_muhendisTc);
		fld_muhendisTc.setColumns(10);
		
		fld_muhendisPass = new JPasswordField();
		fld_muhendisPass.setBounds(221, 124, 350, 37);
		w_muhendisLogin.add(fld_muhendisPass);
		
		JButton btn_register = new JButton("Kay\u0131t Ol");
		btn_register.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btn_register.setBounds(221, 197, 164, 37);
		w_muhendisLogin.add(btn_register);
		
		JButton btn_muhendisLogin = new JButton("Giri\u015F Yap");
		btn_muhendisLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btn_muhendisLogin.setBounds(407, 197, 164, 37);
		w_muhendisLogin.add(btn_muhendisLogin);
	}
}

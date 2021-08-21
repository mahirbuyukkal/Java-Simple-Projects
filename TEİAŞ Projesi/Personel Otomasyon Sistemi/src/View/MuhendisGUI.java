package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.Muhendis;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import com.toedter.calendar.JDateChooser;

import Helper.Helper;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class MuhendisGUI extends JFrame {

	private JPanel w_pane;
	private static Muhendis muhendis = new Muhendis();
	private JTable table_whour;
	private DefaultTableModel whourModel;
	private Object[] whourData = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MuhendisGUI frame = new MuhendisGUI(muhendis);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MuhendisGUI(Muhendis muhendis) throws SQLException {
		
		whourModel = new DefaultTableModel();
		Object[] colWhour = new Object[2];
		colWhour[0] = "ID";
		colWhour[1] = "Tarih";
		whourModel.setColumnIdentifiers(colWhour);
		whourData = new Object[2];
		for(int i=0; i<muhendis.getWhourList(muhendis.getId()).size(); i++) {
			whourData[0] = muhendis.getWhourList(muhendis.getId()).get(i).getId();
			whourData[1] = muhendis.getWhourList(muhendis.getId()).get(i).getId();
			whourModel.addRow(whourData);
		}
		
		
		setResizable(false);
		setTitle("TE\u0130A\u015E Personel Otomasyon Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 533);
		w_pane = new JPanel();
		w_pane.setBackground(new Color(240, 248, 255));
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnNewButton.setBounds(540, 26, 138, 33);
		w_pane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Hoþgeldin Sayýn: " + muhendis.getName());
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 27, 389, 28);
		w_pane.add(lblNewLabel);
		
		JTabbedPane w_tab = new JTabbedPane(JTabbedPane.TOP);
		w_tab.setBounds(0, 95, 771, 400);
		w_pane.add(w_tab);
		
		JPanel w_whour = new JPanel();
		w_whour.setBackground(new Color(176, 224, 230));
		w_tab.addTab("Personel Çalýþma Saatleri", null, w_whour, null);
		w_whour.setLayout(null);
		
		JDateChooser select_date = new JDateChooser();
		select_date.setBounds(10, 10, 163, 35);
		w_whour.add(select_date);
		
		JComboBox select_time = new JComboBox();
		select_time.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		select_time.setModel(new DefaultComboBoxModel(new String[] {"09:00","10:00","12:00","13:30","14:30"}));
		select_time.setBounds(183, 10, 62, 35);
		w_whour.add(select_time);
		
		JButton btn_addWhour = new JButton("Ekle");
		btn_addWhour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = "";
				try {
					date = sdf.format(select_date.getDate());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(date.length() == 0) {
					Helper.showMsg("Lütfen geçerli bir tarih giriniz !");
					
				}else {
					String time = " " + select_time.getSelectedItem().toString() + ":00";
					String selectDate = date + time;
					try {
						boolean control = muhendis.addWhour(muhendis.getId(), muhendis.getName(), selectDate);
						if(control) {
							Helper.showMsg("success");
							updateWhourModel(muhendis);
						}else {
							Helper.showMsg("error");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				
			}
		});
		btn_addWhour.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		btn_addWhour.setBounds(666, 10, 90, 35);
		w_whour.add(btn_addWhour);
		
		JScrollPane w_scrollWhour = new JScrollPane();
		w_scrollWhour.setBounds(0, 55, 766, 318);
		w_whour.add(w_scrollWhour);
		
		table_whour = new JTable(whourModel);
		w_scrollWhour.setViewportView(table_whour);
	}
	
	public void updateWhourModel(Muhendis muhendis) throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_whour.getModel();
		clearModel.setRowCount(0);
		for(int i=0; i<muhendis.getWhourList(muhendis.getId()).size(); i++) {
			whourData[0] = muhendis.getWhourList(muhendis.getId()).get(i).getId();
			whourData[1] = muhendis.getWhourList(muhendis.getId()).get(i).getWdate();
			whourModel.addRow(whourData);
		}
		
		
	}
	
	
	
}

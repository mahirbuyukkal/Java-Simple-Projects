package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.*;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Helper.*;
import javax.swing.JComboBox;

public class YetkiliGUI extends JFrame {

	static Yetkili yetkili = new Yetkili();
	Staj staj = new Staj();
	private JPanel w_pane;
	private JTextField fld_pName;
	private JTextField fld_pTcno;
	private JTable table_personel;
	private DefaultTableModel muhendisModel = null;
	private Object[] muhendisData = null;
	private JTextField fld_personelID;
	private JTable table_stajyer;
	private JTextField fld_bolumName;
	private DefaultTableModel stajModel = null;
	private Object[] stajData = null;
	private JTable table_worker;
	private JTextField fld_pPass;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YetkiliGUI frame = new YetkiliGUI(yetkili);
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
	public YetkiliGUI(Yetkili yetkili) throws SQLException {
		
		// Muhendis Model
		muhendisModel = new DefaultTableModel();
		Object[] colMuhendisName = new Object[4];
		colMuhendisName[0] = "ID";
		colMuhendisName[1] = "Ad Soyad";
		colMuhendisName[2] = "TC No";
		colMuhendisName[3] = "Bölüm";
		muhendisModel.setColumnIdentifiers(colMuhendisName);
		muhendisData = new Object[4];
		for(int i=0; i < yetkili.getMuhendisList().size(); i++){
			
			muhendisData[0] = yetkili.getMuhendisList().get(i).getId();
			muhendisData[1] = yetkili.getMuhendisList().get(i).getName();
			muhendisData[2] = yetkili.getMuhendisList().get(i).getTcno();
			muhendisData[3] = yetkili.getMuhendisList().get(i).getPassword();
			muhendisModel.addRow(muhendisData);
		}
		
		// Staj Model
		
		stajModel = new DefaultTableModel();
		Object[] colStaj = new Object[2];
		colStaj[0] = "ID";
		colStaj[1] = "Bölüm Adý";
		stajModel.setColumnIdentifiers(colStaj);
		stajData = new Object[2];
		for(int i=0; i<staj.getList().size(); i++) {
			stajData[0] = staj.getList().get(i).getId();
			stajData[1] = staj.getList().get(i).getName();
			stajModel.addRow(stajData);
		}
		
		// Woker model
		
		DefaultTableModel workerModel = new DefaultTableModel();
		Object[] colWorker = new Object[2];
		colWorker[0] = "ID";
		colWorker[1] = "Ad Soyad";
		workerModel.setColumnIdentifiers(colWorker);
		Object[] workerData = new Object[2];
		
		
		setTitle("TE\u0130A\u015E Personel Otomasyon Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 502);
		w_pane = new JPanel();
		w_pane.setBackground(new Color(240, 248, 255));
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hoþgeldiniz, Sayýn " + yetkili.getName());
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 22, 389, 28);
		w_pane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnNewButton.setBounds(540, 21, 138, 33);
		w_pane.add(btnNewButton);
		
		JTabbedPane w_tab = new JTabbedPane(JTabbedPane.TOP);
		w_tab.setBounds(10, 60, 668, 395);
		w_pane.add(w_tab);
		
		JPanel w_personel = new JPanel();
		w_personel.setBackground(new Color(176, 196, 222));
		w_tab.addTab("Personel Yönetimi", null, w_personel, null);
		w_personel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ad Soyad:");
		lblNewLabel_1.setBounds(478, 10, 79, 23);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		w_personel.add(lblNewLabel_1);
		
		fld_pName = new JTextField();
		fld_pName.setBounds(477, 35, 177, 33);
		fld_pName.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		w_personel.add(fld_pName);
		fld_pName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("T.C. No:");
		lblNewLabel_1_1.setBounds(478, 78, 79, 23);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		w_personel.add(lblNewLabel_1_1);
		
		fld_pTcno = new JTextField();
		fld_pTcno.setBounds(477, 103, 177, 33);
		fld_pTcno.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		fld_pTcno.setColumns(10);
		w_personel.add(fld_pTcno);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("B\u00F6l\u00FCm:");
		lblNewLabel_1_1_1.setBounds(478, 146, 79, 23);
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		w_personel.add(lblNewLabel_1_1_1);
		
		JButton btn_addPersonel = new JButton("Ekle");
		btn_addPersonel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fld_pName.getText().length() == 0 || fld_pPass.getText().length() == 0 || fld_pTcno.getText().length() == 0) {
					
					Helper.showMsg("fill");
				}else {
					
					try {
						boolean control = yetkili.addPersonel(fld_pTcno.getText(), fld_pPass.getText(), fld_pName.getText());
						if(control) {
							Helper.showMsg("success");
							fld_pName.setText(null);
							fld_pTcno.setText(null);
							fld_pPass.setText(null);
							updatePersonelModel();
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_addPersonel.setBounds(478, 216, 176, 33);
		btn_addPersonel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		w_personel.add(btn_addPersonel);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Kullan\u0131c\u0131 ID:");
		lblNewLabel_1_1_2.setBounds(478, 259, 79, 23);
		lblNewLabel_1_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		w_personel.add(lblNewLabel_1_1_2);
		
		JButton btn_delPersonel = new JButton("Sil");
		btn_delPersonel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fld_personelID.getText().length() == 0) {
					Helper.showMsg("Lütfen geçerli bir personel seçiniz !");
				}else {
					if(Helper.confirm("sure")) {
						int selectID = Integer.parseInt(fld_personelID.getText());
						try {
							boolean control = yetkili.deletePersonel(selectID);
							if(control) {
								Helper.showMsg("success");
								fld_personelID.setText(null);
								updatePersonelModel();
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btn_delPersonel.setBounds(478, 321, 176, 33);
		btn_delPersonel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		w_personel.add(btn_delPersonel);
		
		JScrollPane w_scrollPersonel = new JScrollPane();
		w_scrollPersonel.setBounds(10, 10, 457, 344);
		w_personel.add(w_scrollPersonel);
		
		table_personel = new JTable(muhendisModel);
		w_scrollPersonel.setViewportView(table_personel);
		
		fld_personelID = new JTextField();
		fld_personelID.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		fld_personelID.setColumns(10);
		fld_personelID.setBounds(478, 278, 177, 33);
		w_personel.add(fld_personelID);
		
		fld_pPass = new JTextField();
		fld_pPass.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		fld_pPass.setColumns(10);
		fld_pPass.setBounds(478, 168, 177, 33);
		w_personel.add(fld_pPass);
		
		
		table_personel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					fld_personelID.setText(table_personel.getValueAt(table_personel.getSelectedRow(), 0).toString());
				}catch(Exception ex) {
					//hata yok
				}
				
			}
		});
		
		JPanel w_stajyer = new JPanel();
		w_stajyer.setBackground(new Color(176, 196, 222));
		w_tab.addTab("Staj Öðrencileri", null, w_stajyer, null);
		w_stajyer.setLayout(null);
		
		JScrollPane w_scrollStajyer = new JScrollPane();
		w_scrollStajyer.setBounds(10, 35, 234, 319);
		w_stajyer.add(w_scrollStajyer);
		
		table_stajyer = new JTable(stajModel);
		w_scrollStajyer.setViewportView(table_stajyer);
		
		fld_bolumName = new JTextField();
		fld_bolumName.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		fld_bolumName.setColumns(10);
		fld_bolumName.setBounds(254, 35, 155, 33);
		w_stajyer.add(fld_bolumName);
		
		JLabel lbl_BolumAd = new JLabel("B\u00F6l\u00FCm Ekle");
		lbl_BolumAd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lbl_BolumAd.setBounds(255, 10, 130, 23);
		w_stajyer.add(lbl_BolumAd);
		
		JScrollPane w_scrollStaj = new JScrollPane();
		w_scrollStaj.setBounds(419, 35, 234, 319);
		w_stajyer.add(w_scrollStaj);
		
		table_worker = new JTable();
		w_scrollStaj.setViewportView(table_worker);
		
		JButton btn_addBolum = new JButton("Ekle");
		btn_addBolum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fld_bolumName.getText().length() == 0) {
					Helper.showMsg("fill");
				}else {
					try {
						if(staj.addStaj(fld_bolumName.getText())) {
							Helper.showMsg("success");
							fld_bolumName.setText(null);
							updateStajModel();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_addBolum.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btn_addBolum.setBounds(254, 78, 155, 33);
		w_stajyer.add(btn_addBolum);
		
		JComboBox select_muhendis = new JComboBox();
		select_muhendis.setBounds(254, 271, 155, 33);
		for(int i=0; i<yetkili.getMuhendisList().size(); i++) {
			select_muhendis.addItem(new Item(yetkili.getMuhendisList().get(i).getId(), yetkili.getMuhendisList().get(i).getName()));
		}
		select_muhendis.addActionListener(e -> {
			JComboBox c = (JComboBox) e.getSource();
			Item item = (Item) c.getSelectedItem();
			System.out.println(item.getKey() + " : " + item.getValue());
		});
		w_stajyer.add(select_muhendis);
		
		JButton btn_addWorker = new JButton("Ekle");
		btn_addWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selRow = table_stajyer.getSelectedRow();
				if(selRow >= 0) {
					String selStaj = table_stajyer.getModel().getValueAt(selRow, 0).toString();
					int selStajID = Integer.parseInt(selStaj);
					Item muhendisItem = (Item) select_muhendis.getSelectedItem();
					try {
						boolean control = yetkili.addWorker(muhendisItem.getKey(), selStajID);
						if(control) {
							Helper.showMsg("success");
						}else {
							Helper.showMsg("error");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					Helper.showMsg("Lütfen bir bölüm giriniz !");
				}
			}
		});
		btn_addWorker.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btn_addWorker.setBounds(254, 314, 155, 33);
		w_stajyer.add(btn_addWorker);
		
		JLabel lbl_BolumAd_1 = new JLabel("B\u00F6l\u00FCm Ad\u0131");
		lbl_BolumAd_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lbl_BolumAd_1.setBounds(255, 156, 130, 23);
		w_stajyer.add(lbl_BolumAd_1);
		
		JButton btn_workerSelect = new JButton("Se\u00E7");
		btn_workerSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selRow = table_stajyer.getSelectedRow();
				if(selRow >= 0) {
					String selStaj = table_stajyer.getModel().getValueAt(selRow, 0).toString();
					int selStajID = Integer.parseInt(selStaj);
					DefaultTableModel clearModel = (DefaultTableModel) table_worker.getModel();
					clearModel.setRowCount(0);
					try {
						for(int i=0; i<yetkili.getStajMuhendisList(selStajID).size(); i++) {
							workerData[0] = yetkili.getStajMuhendisList(selStajID).get(i).getId();
							workerData[1] = yetkili.getStajMuhendisList(selStajID).get(i).getName();
							workerModel.addRow(workerData);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					table_worker.setModel(workerModel);
				}else {
					Helper.showMsg("Lütfen bir bölüm seçiniz !");
				}
			}
		});
		btn_workerSelect.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btn_workerSelect.setBounds(254, 183, 155, 33);
		w_stajyer.add(btn_workerSelect);
		
		JLabel lbl_BolumAd_1_1 = new JLabel("Se\u00E7");
		lbl_BolumAd_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lbl_BolumAd_1_1.setBounds(254, 244, 154, 23);
		w_stajyer.add(lbl_BolumAd_1_1);
		
		JLabel lbl_BolumAd_2 = new JLabel("Staj \u00D6\u011Frenci B\u00F6l\u00FCmleri");
		lbl_BolumAd_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lbl_BolumAd_2.setBounds(70, 10, 114, 23);
		w_stajyer.add(lbl_BolumAd_2);
		
		JLabel lbl_BolumAd_2_1 = new JLabel("Staj \u00D6\u011Frencileri");
		lbl_BolumAd_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lbl_BolumAd_2_1.setBounds(494, 10, 85, 23);
		w_stajyer.add(lbl_BolumAd_2_1);
		
		table_personel.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getType() == TableModelEvent.UPDATE) {
					int SelectID = Integer.parseInt(table_personel.getValueAt(table_personel.getSelectedRow(), 0).toString());
					String selectName = table_personel.getValueAt(table_personel.getSelectedRow(), 1).toString();
					String selectTcno = table_personel.getValueAt(table_personel.getSelectedRow(), 2).toString();
					String selectPass = table_personel.getValueAt(table_personel.getSelectedRow(), 3).toString();
					
					try {
						boolean control = yetkili.updatePersonel(SelectID, selectTcno, selectPass, selectName);
						if(control) {
							Helper.showMsg("success");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
			
		});
	}
	
	public void updatePersonelModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_personel.getModel();
		clearModel.setRowCount(0);
		
		for(int i=0; i < yetkili.getMuhendisList().size(); i++){
			
			muhendisData[0] = yetkili.getMuhendisList().get(i).getId();
			muhendisData[1] = yetkili.getMuhendisList().get(i).getName();
			muhendisData[2] = yetkili.getMuhendisList().get(i).getTcno();
			muhendisData[3] = yetkili.getMuhendisList().get(i).getPassword();
			muhendisModel.addRow(muhendisData);
		}
		
	}
	
	public void updateStajModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_stajyer.getModel();
		clearModel.setRowCount(0);
		for(int i=0; i<staj.getList().size(); i++) {
			stajData[0] = staj.getList().get(i).getId();
			stajData[1] = staj.getList().get(i).getName();
			stajModel.addRow(stajData);
		}
	}
}

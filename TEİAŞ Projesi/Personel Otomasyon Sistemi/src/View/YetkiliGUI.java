package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Yetkili;

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

public class YetkiliGUI extends JFrame {

	static Yetkili yetkili = new Yetkili();
	private JPanel w_pane;
	private JTextField fld_pName;
	private JTextField fld_pTcno;
	private JPasswordField fld_pPass;
	private JTable table_personel;
	private DefaultTableModel muhendisModel = null;
	private Object[] muhendisData = null;
	private JTextField fld_personelID;
	

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
		
		muhendisModel = new DefaultTableModel();
		Object[] colMuhendisName = new Object[4];
		colMuhendisName[0] = "ID";
		colMuhendisName[1] = "Ad Soyad";
		colMuhendisName[2] = "TC No";
		colMuhendisName[3] = "Þifre";
		muhendisModel.setColumnIdentifiers(colMuhendisName);
		muhendisData = new Object[4];
		for(int i=0; i < yetkili.getMuhendisList().size(); i++){
			
			muhendisData[0] = yetkili.getMuhendisList().get(i).getId();
			muhendisData[1] = yetkili.getMuhendisList().get(i).getName();
			muhendisData[2] = yetkili.getMuhendisList().get(i).getTcno();
			muhendisData[3] = yetkili.getMuhendisList().get(i).getPassword();
			muhendisModel.addRow(muhendisData);
		}
		
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
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u015Eifre:");
		lblNewLabel_1_1_1.setBounds(478, 146, 79, 23);
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		w_personel.add(lblNewLabel_1_1_1);
		
		fld_pPass = new JPasswordField();
		fld_pPass.setBounds(478, 173, 176, 33);
		w_personel.add(fld_pPass);
		
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
		clearModel.setRowCount(0); // rowlar silinir
		
		for(int i=0; i < yetkili.getMuhendisList().size(); i++){
			
			muhendisData[0] = yetkili.getMuhendisList().get(i).getId();
			muhendisData[1] = yetkili.getMuhendisList().get(i).getName();
			muhendisData[2] = yetkili.getMuhendisList().get(i).getTcno();
			muhendisData[3] = yetkili.getMuhendisList().get(i).getPassword();
			muhendisModel.addRow(muhendisData);
		}
		
	}
	
}

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
import javax.swing.JButton;

public class YetkiliGUI extends JFrame {

	static Yetkili yetkili = new Yetkili();
	private JPanel w_pane;

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
	 */
	public YetkiliGUI(Yetkili yetkili) {
		setTitle("TE\u0130A\u015E Personel Otomasyon Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 502);
		w_pane = new JPanel();
		w_pane.setBackground(new Color(176, 196, 222));
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
	}

}

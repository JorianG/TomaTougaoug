package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class PanierVide extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanierVide frame = new PanierVide();
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
	public PanierVide() {
		setTitle("Panier vide");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PanierVide.class.getResource("/images/TomaTougaoug.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPanierVide = new JLabel("Votre panier est vide");
		lblPanierVide.setForeground(new Color(0, 0, 0));
		lblPanierVide.setBackground(new Color(255, 255, 255));
		lblPanierVide.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPanierVide.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPanierVide);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOK.setForeground(new Color(0, 128, 0));
		panel.add(btnOK);
	}
}

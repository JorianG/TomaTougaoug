package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
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
public class SupPanier extends JFrame {

	private JPanel contentPane;
	protected static boolean suppPanier = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupPanier frame = new SupPanier();
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
	public SupPanier() {
		setTitle("Supprimer le panier");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SupPanier.class.getResource("/images/TomaTougaoug.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSuppression = new JLabel("Voulez-vous supprimer votre panier?");
		lblSuppression.setForeground(new Color(0, 0, 0));
		lblSuppression.setBackground(new Color(255, 255, 255));
		lblSuppression.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSuppression.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSuppression);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		
		JButton btnOui = new JButton("Oui");
		btnOui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ihm.Panier.viderTable();
				ihm.Panier.btnValider.setEnabled(false);
				dispose();
				
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suppPanier = false;
				dispose();
			}
		});
		btnAnnuler.setForeground(new Color(255, 0, 0));
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnAnnuler);
		btnOui.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOui.setForeground(new Color(0, 128, 0));
		panel.add(btnOui);
	}
}

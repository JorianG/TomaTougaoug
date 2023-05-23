package ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class Acceuil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil frame = new Acceuil();
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
	public Acceuil() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Acceuil.class.getResource("/images/TomaTougaoug.png")));
		setTitle("TomaTougaoug");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 80, 600, 800 );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		header.setMaximumSize(new Dimension(32767, 50));
		contentPane.add(header, BorderLayout.WEST);
		
		JLabel titre = new JLabel("Commandez vos tomates");
		titre.setForeground(new Color(0, 255, 0));
		titre.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 25));
		titre.setHorizontalAlignment(SwingConstants.LEFT);
		titre.setIcon(new ImageIcon(Acceuil.class.getResource("/images/TomaTougaoug.png")));
		header.add(titre);
		
		JPanel panier = new JPanel();
		panier.setBackground(new Color(255, 128, 64));
		panier.setSize(new Dimension(80, 40));
		panier.setForeground(new Color(255, 128, 64));
		header.add(panier);
		
		JLabel txtPanier = new JLabel("Panier");
		txtPanier.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPanier.setIcon(new ImageIcon(Acceuil.class.getResource("/images/panier.png")));
		panier.add(txtPanier);
		
		JLabel eurPanier = new JLabel("0.00€");
		eurPanier.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panier.add(eurPanier);
		
		JPanel footer = new JPanel();
		contentPane.add(footer, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

	}

}

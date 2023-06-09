package ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Conseil extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conseil frame = new Conseil();
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
	public Conseil() {
		setTitle("Conseil de culture");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Conseil.class.getResource("/images/TomaTougaoug.png")));
		
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnValider.setForeground(new Color(0, 128, 0));
		btnValider.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		contentPane.add(btnValider, BorderLayout.SOUTH);
		
		JPanel titre = new JPanel();
		contentPane.add(titre, BorderLayout.CENTER);
		titre.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnconseilsDeCulturern = new JTextPane();
		txtpnconseilsDeCulturern.setEditable(false);
		txtpnconseilsDeCulturern.setForeground(new Color(0, 128, 0));
		txtpnconseilsDeCulturern.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		txtpnconseilsDeCulturern.setText(ihm.Accueil.bdTomates.CONSEILS_DE_CULTURE_TITRE);
		titre.add(txtpnconseilsDeCulturern, BorderLayout.NORTH);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setToolTipText("");
		titre.add(scrollPane, BorderLayout.CENTER);
		
		JTextPane txtpnA = new JTextPane();
		txtpnA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnA.setText(ihm.Accueil.bdTomates.CONSEILS_DE_CULTURE);

		scrollPane.setViewportView(txtpnA);
		
		JPanel panelHeader = new JPanel();
		contentPane.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Conseil.class.getResource("/images/TomaTougaoug.png")));
		panelHeader.add(lblLogo, BorderLayout.WEST);
		
		JLabel lblTitre = new JLabel("Conseil de Culture");
		lblTitre.setForeground(new Color(255, 0, 0));
		lblTitre.setFont(new Font("Brush Script MT", Font.PLAIN, 40));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		panelHeader.add(lblTitre, BorderLayout.CENTER);
	}

}


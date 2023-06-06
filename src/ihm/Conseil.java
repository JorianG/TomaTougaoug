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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ihm.Acceuil.main(null);
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnconseilsDeCulturern = new JTextPane();
		txtpnconseilsDeCulturern.setEditable(false);
		txtpnconseilsDeCulturern.setForeground(new Color(0, 128, 0));
		txtpnconseilsDeCulturern.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		txtpnconseilsDeCulturern.setText("Conseils de culture\r\nSemis : mars-avril\r\nRepiquage : après les gelées\r\nRécolte : juillet à septembre, voire octobre");
		panel.add(txtpnconseilsDeCulturern, BorderLayout.NORTH);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setToolTipText("");
		panel.add(scrollPane);
		
		JTextPane txtpnA = new JTextPane();
		txtpnA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnA.setText("Les tomates sont frileuses !\r\n\r\nExposition : Les tomates sont originaires d’Amérique du Sud…et leurs gènes s’en souviennent !\r\nRéservez-leur l’endroit le mieux ensoleillé de votre jardin.\r\n\r\nSemis : Démarrez vos semis en petite terrine dès mars / avril (15/20° nuit et jour) dans du terreau à semis, couvrez vos graines de 0,5 cm, tassez doucement et maintenez humide. Repiquez vos semis lorsqu’ils font 5 cm, dans des godets avec du terreau 1/3 de fumier ou du compost , enterrez jusqu’au première feuilles.\r\n\r\nAprès les Saints de glaces, plantez vos pieds de tomates dès qu’ils auront atteint 15 cm, enterrez-les jusqu’aux premières feuilles en pleine terre dans un trou avec du fumier, du compost ou quelques feuilles d’ortie si besoin, installez vos tuteurs espacés de 70 cm.\r\nArrosez abondamment les 3 premiers jours, arrêtez les 15 jours suivants puis arrosez régulièrement.\r\n\r\nPensez à pailler ! ainsi vous garderez beaucoup plus facilement la terre humide et espacerez les désherbages.\r\n\r\nMaladies pouvant toucher les tomates: mildiou (ne pas arroser les feuilles et supprimer celles qui touchent le sol).\r\n\r\nPlantez du basilic entre vos pieds de tomates, ils s’entraident l’un l’autre…");

		scrollPane.setViewportView(txtpnA);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Conseil.class.getResource("/images/TomaTougaoug.png")));
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("Conseil de Culture");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Brush Script MT", Font.PLAIN, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1, BorderLayout.CENTER);
	}

}

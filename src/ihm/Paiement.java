package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modele.Client;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Paiement extends JFrame {

	private static JPanel contentPane;
	private static JTextField textFieldNom;
	private static JTextField textFieldPrenom;
	private static JTextField textFieldAdresse1;
	private static JTextField textFieldAdresse2;
	private static JTextField textFieldCP;
	private static JTextField textFieldVille;
	private static JTextField textFieldTel;
	private static JTextField textFieldMail;
	private static List<JTextField> listField;
	private JRadioButton rdbtnCreditCard;
	private JRadioButton rdbtnPaypal;
	private JRadioButton rdbtnCheque;
	public static int radioSelected;
	public static JCheckBox chckbxNewsletter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paiement frame = new Paiement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 * teste si tous les champs obligatoire du formulaire sont remplis
	 */
	public static boolean testFullFill() {
		for (JTextField tf: listField) {
			if (tf.getText().isEmpty() && tf.getName() != "Adresse2") {
				return false;
			}
		}
		return true;
	}
	
	public static void addClient() {
		ihm.Accueil.bdTomates.getLesClients().add(new Client(textFieldNom.getText(), textFieldPrenom.getText(), textFieldAdresse1.getText(), 
				textFieldAdresse2.getText(), textFieldCP.getText(), textFieldVille.getText(), textFieldTel.getText(), textFieldMail.getText(),
				radioSelected, chckbxNewsletter.isSelected()));
	}
	
	/**
	 * Create the frame.
	 */
	public Paiement() {
		setTitle("Formulaire de paiement");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Paiement.class.getResource("/images/TomaTougaoug.png")));
		setBounds(100, 100, 764, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Vos coordonnées");
		lblNewLabel.setIcon(new ImageIcon(Paiement.class.getResource("/images/TomaTougaoug.png")));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {275, 18, 235, 185, 0};
		gbl_panel.rowHeights = new int[] {25, 25, 25, 25, 25, 25, 25};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblNom = new JLabel("*Nom :");
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.fill = GridBagConstraints.BOTH;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 0;
		panel.add(lblNom, gbc_lblNom);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		textFieldNom = new JTextField();
		GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
		gbc_textFieldNom.fill = GridBagConstraints.BOTH;
		gbc_textFieldNom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNom.gridx = 2;
		gbc_textFieldNom.gridy = 0;
		panel.add(textFieldNom, gbc_textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.BOTH;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 0;
		panel.add(label_1, gbc_label_1);
		
		JLabel lblPrenom = new JLabel("*Prénom :");
		lblPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.fill = GridBagConstraints.BOTH;
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.gridx = 0;
		gbc_lblPrenom.gridy = 1;
		panel.add(lblPrenom, gbc_lblPrenom);
		
		JLabel label_2 = new JLabel("");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.BOTH;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 1;
		panel.add(label_2, gbc_label_2);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		GridBagConstraints gbc_textFieldPrenom = new GridBagConstraints();
		gbc_textFieldPrenom.fill = GridBagConstraints.BOTH;
		gbc_textFieldPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrenom.gridx = 2;
		gbc_textFieldPrenom.gridy = 1;
		panel.add(textFieldPrenom, gbc_textFieldPrenom);
		
		JLabel label_3 = new JLabel("");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.BOTH;
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 3;
		gbc_label_3.gridy = 1;
		panel.add(label_3, gbc_label_3);
		
		JLabel lblAdresse1 = new JLabel("*Adresse 1 :");
		lblAdresse1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAdresse1 = new GridBagConstraints();
		gbc_lblAdresse1.fill = GridBagConstraints.BOTH;
		gbc_lblAdresse1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse1.gridx = 0;
		gbc_lblAdresse1.gridy = 2;
		panel.add(lblAdresse1, gbc_lblAdresse1);
		
		JLabel label_4 = new JLabel("");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.fill = GridBagConstraints.BOTH;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 2;
		panel.add(label_4, gbc_label_4);
		
		textFieldAdresse1 = new JTextField();
		textFieldAdresse1.setColumns(10);
		GridBagConstraints gbc_textFieldAdresse1 = new GridBagConstraints();
		gbc_textFieldAdresse1.fill = GridBagConstraints.BOTH;
		gbc_textFieldAdresse1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse1.gridx = 2;
		gbc_textFieldAdresse1.gridy = 2;
		panel.add(textFieldAdresse1, gbc_textFieldAdresse1);
		
		JLabel label_5 = new JLabel("");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.fill = GridBagConstraints.BOTH;
		gbc_label_5.insets = new Insets(0, 0, 5, 0);
		gbc_label_5.gridx = 3;
		gbc_label_5.gridy = 2;
		panel.add(label_5, gbc_label_5);
		
		JLabel lblAdresse2 = new JLabel("Adresse 2 :");
		lblAdresse2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAdresse2 = new GridBagConstraints();
		gbc_lblAdresse2.fill = GridBagConstraints.BOTH;
		gbc_lblAdresse2.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse2.gridx = 0;
		gbc_lblAdresse2.gridy = 3;
		panel.add(lblAdresse2, gbc_lblAdresse2);
		
		JLabel label_6 = new JLabel("");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.fill = GridBagConstraints.BOTH;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 1;
		gbc_label_6.gridy = 3;
		panel.add(label_6, gbc_label_6);
		
		textFieldAdresse2 = new JTextField();
		textFieldAdresse2.setName("Adresse2");
		textFieldAdresse2.setColumns(10);
		GridBagConstraints gbc_textFieldAdresse2 = new GridBagConstraints();
		gbc_textFieldAdresse2.fill = GridBagConstraints.BOTH;
		gbc_textFieldAdresse2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse2.gridx = 2;
		gbc_textFieldAdresse2.gridy = 3;
		panel.add(textFieldAdresse2, gbc_textFieldAdresse2);
		
		JLabel label_7 = new JLabel("");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.fill = GridBagConstraints.BOTH;
		gbc_label_7.insets = new Insets(0, 0, 5, 0);
		gbc_label_7.gridx = 3;
		gbc_label_7.gridy = 3;
		panel.add(label_7, gbc_label_7);
		
		JLabel lblCP = new JLabel("*Code Postal :");
		lblCP.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblCP = new GridBagConstraints();
		gbc_lblCP.fill = GridBagConstraints.BOTH;
		gbc_lblCP.insets = new Insets(0, 0, 5, 5);
		gbc_lblCP.gridx = 0;
		gbc_lblCP.gridy = 4;
		panel.add(lblCP, gbc_lblCP);
		
		JLabel label_8 = new JLabel("");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.fill = GridBagConstraints.BOTH;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 1;
		gbc_label_8.gridy = 4;
		panel.add(label_8, gbc_label_8);
		
		textFieldCP = new JTextField();
		textFieldCP.setColumns(10);
		GridBagConstraints gbc_textFieldCP = new GridBagConstraints();
		gbc_textFieldCP.fill = GridBagConstraints.BOTH;
		gbc_textFieldCP.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCP.gridx = 2;
		gbc_textFieldCP.gridy = 4;
		panel.add(textFieldCP, gbc_textFieldCP);
		
		JLabel label_9 = new JLabel("");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.fill = GridBagConstraints.BOTH;
		gbc_label_9.insets = new Insets(0, 0, 5, 0);
		gbc_label_9.gridx = 3;
		gbc_label_9.gridy = 4;
		panel.add(label_9, gbc_label_9);
		
		JLabel lblVille = new JLabel("*Ville :");
		lblVille.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblVille = new GridBagConstraints();
		gbc_lblVille.fill = GridBagConstraints.BOTH;
		gbc_lblVille.insets = new Insets(0, 0, 5, 5);
		gbc_lblVille.gridx = 0;
		gbc_lblVille.gridy = 5;
		panel.add(lblVille, gbc_lblVille);
		
		JLabel label_10 = new JLabel("");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.fill = GridBagConstraints.BOTH;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 1;
		gbc_label_10.gridy = 5;
		panel.add(label_10, gbc_label_10);
		
		textFieldVille = new JTextField();
		textFieldVille.setColumns(10);
		GridBagConstraints gbc_textFieldVille = new GridBagConstraints();
		gbc_textFieldVille.fill = GridBagConstraints.BOTH;
		gbc_textFieldVille.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVille.gridx = 2;
		gbc_textFieldVille.gridy = 5;
		panel.add(textFieldVille, gbc_textFieldVille);
		
		JLabel label_11 = new JLabel("");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.fill = GridBagConstraints.BOTH;
		gbc_label_11.insets = new Insets(0, 0, 5, 0);
		gbc_label_11.gridx = 3;
		gbc_label_11.gridy = 5;
		panel.add(label_11, gbc_label_11);
		
		JLabel lblTel = new JLabel("*Téléphone :");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblTel = new GridBagConstraints();
		gbc_lblTel.fill = GridBagConstraints.BOTH;
		gbc_lblTel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTel.gridx = 0;
		gbc_lblTel.gridy = 6;
		panel.add(lblTel, gbc_lblTel);
		
		JLabel label_12 = new JLabel("");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.fill = GridBagConstraints.BOTH;
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 1;
		gbc_label_12.gridy = 6;
		panel.add(label_12, gbc_label_12);
		
		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		GridBagConstraints gbc_textFieldTel = new GridBagConstraints();
		gbc_textFieldTel.fill = GridBagConstraints.BOTH;
		gbc_textFieldTel.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTel.gridx = 2;
		gbc_textFieldTel.gridy = 6;
		panel.add(textFieldTel, gbc_textFieldTel);
		
		JLabel label_13 = new JLabel("");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.fill = GridBagConstraints.BOTH;
		gbc_label_13.insets = new Insets(0, 0, 5, 0);
		gbc_label_13.gridx = 3;
		gbc_label_13.gridy = 6;
		panel.add(label_13, gbc_label_13);
		
		JLabel lblMail = new JLabel("*Email :");
		lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.fill = GridBagConstraints.BOTH;
		gbc_lblMail.insets = new Insets(0, 0, 0, 5);
		gbc_lblMail.gridx = 0;
		gbc_lblMail.gridy = 7;
		panel.add(lblMail, gbc_lblMail);
		
		JLabel label_14 = new JLabel("");
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.fill = GridBagConstraints.BOTH;
		gbc_label_14.insets = new Insets(0, 0, 0, 5);
		gbc_label_14.gridx = 1;
		gbc_label_14.gridy = 7;
		panel.add(label_14, gbc_label_14);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		GridBagConstraints gbc_textFieldMail = new GridBagConstraints();
		gbc_textFieldMail.fill = GridBagConstraints.BOTH;
		gbc_textFieldMail.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldMail.gridx = 2;
		gbc_textFieldMail.gridy = 7;
		panel.add(textFieldMail, gbc_textFieldMail);
		
		listField = new LinkedList<JTextField>();
		listField.add(textFieldNom);
		listField.add(textFieldPrenom);
		listField.add(textFieldAdresse1);
		listField.add(textFieldAdresse2);
		listField.add(textFieldCP);
		listField.add(textFieldVille);
		listField.add(textFieldTel);
		listField.add(textFieldMail);
		
		
		JLabel label_15 = new JLabel("");
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.fill = GridBagConstraints.BOTH;
		gbc_label_15.gridx = 3;
		gbc_label_15.gridy = 7;
		panel.add(label_15, gbc_label_15);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel mode_paiement = new JPanel();
		mode_paiement.setBackground(new Color(192, 192, 192));
		mode_paiement.setPreferredSize(new Dimension(10, 70));
		panel_1.add(mode_paiement, BorderLayout.NORTH);
		mode_paiement.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPaiement = new JLabel("Mode de paiement");
		lblPaiement.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPaiement.setHorizontalAlignment(SwingConstants.CENTER);
		mode_paiement.add(lblPaiement, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		mode_paiement.add(panel_4, BorderLayout.CENTER);
		
		rdbtnCreditCard = new JRadioButton("Carte de crédit");
		rdbtnCreditCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnCreditCard.setSelected(true);
				rdbtnPaypal.setSelected(false);
				rdbtnCheque.setSelected(false);
				radioSelected = 0;
			}
		});
		rdbtnCreditCard.setSelected(true);
		rdbtnCreditCard.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnCreditCard.setBackground(new Color(192, 192, 192));
		panel_4.add(rdbtnCreditCard);
		
		rdbtnPaypal = new JRadioButton("Paypal");
		rdbtnPaypal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnCreditCard.setSelected(false);
				rdbtnPaypal.setSelected(true);
				rdbtnCheque.setSelected(false);
				radioSelected = 1;
			}
		});
		rdbtnPaypal.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnPaypal.setBackground(new Color(192, 192, 192));
		panel_4.add(rdbtnPaypal);
		
		rdbtnCheque = new JRadioButton("Paiement par chèque");
		rdbtnCheque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnCreditCard.setSelected(false);
				rdbtnPaypal.setSelected(false);
				rdbtnCheque.setSelected(true);
				radioSelected = 2;
			}
		});
		rdbtnCheque.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnCheque.setBackground(new Color(192, 192, 192));
		panel_4.add(rdbtnCheque);
		
		JPanel spacer = new JPanel();
		spacer.setBackground(new Color(240, 240, 240));
		spacer.setPreferredSize(new Dimension(30, 30));
		spacer.setMinimumSize(new Dimension(10, 30));
		panel_1.add(spacer, BorderLayout.CENTER);
		
		JPanel news = new JPanel();
		news.setBackground(new Color(240, 240, 240));
		news.setPreferredSize(new Dimension(10, 120));
		panel_1.add(news, BorderLayout.SOUTH);
		news.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNewsletter = new JPanel();
		panelNewsletter.setBackground(new Color(192, 192, 192));
		panelNewsletter.setPreferredSize(new Dimension(10, 70));
		news.add(panelNewsletter, BorderLayout.NORTH);
		panelNewsletter.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewsletter = new JLabel("Newsletter");
		lblNewsletter.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewsletter.setFont(new Font("Verdana", Font.PLAIN, 16));
		panelNewsletter.add(lblNewsletter, BorderLayout.NORTH);
		
		JLabel lblTexteNewsletter = new JLabel("Souhaitez vous vous abonner à notre newsletter ?");
		lblTexteNewsletter.setHorizontalAlignment(SwingConstants.CENTER);
		panelNewsletter.add(lblTexteNewsletter, BorderLayout.CENTER);
		
		chckbxNewsletter = new JCheckBox("S'abonner à la newsletter");
		chckbxNewsletter.setSelected(true);
		chckbxNewsletter.setBackground(new Color(192, 192, 192));
		chckbxNewsletter.setHorizontalAlignment(SwingConstants.CENTER);
		panelNewsletter.add(chckbxNewsletter, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		news.add(panel_3, BorderLayout.SOUTH);
		
		JButton btnFacture = new JButton("Facture");
		btnFacture.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!testFullFill()) {
					ihm.ChampsManquantsF.main(null);
				} else {
					addClient();
					ihm.facture.main(ihm.Accueil.bdTomates.getLesClients().get(ihm.Accueil.bdTomates.getLesClients().size()-1));
				}
			}
		});
		btnFacture.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnFacture.setIcon(new ImageIcon(Paiement.class.getResource("/images/panier.png")));
		panel_3.add(btnFacture);
	}

}

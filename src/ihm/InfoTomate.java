package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modele.EPanier;
import modele.GenerationArticles;
import modele.Tomate;
import modele.Tomates;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoTomate extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JSpinner spinner;


	/**
	 * Launch the application.
	 */
	public static void main(Tomate args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoTomate frame = new InfoTomate(args);
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
	@SuppressWarnings("unchecked")
	public InfoTomate(Tomate tomate) {
		
		setBounds(100, 100, 669, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel(tomate.getDésignation());
		lblNewLabel.setPreferredSize(new Dimension(46, 40));
		lblNewLabel.setFont(new Font("Kunstler Script", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(4, 1, 150, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1);
		
		JLabel Image = new JLabel("");
		Image.setIcon(new ImageIcon(InfoTomate.class.getResource("/images/Tomates200x200/"+ tomate.getNomImage() + ".jpg")));
		
		panel.add(Image);
		
		JLabel lblapparantée = new JLabel("Tomate apparentée");
		panel.add(lblapparantée);
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
				    ihm.InfoTomate.main(ihm.Acceuil.bdTomates.getTomate((String) list.getSelectedValue()));
				    dispose();
				  }
			}
		});
		list.setModel(new AbstractListModel() {
		String[] values = tomate.getTomatesApparentéesString();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setVisibleRowCount(tomate.getTomatesApparentées().size());
		panel.add(list);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setPreferredSize(new Dimension(10, 50));
		panel_1.add(panel_4_1, BorderLayout.NORTH);
		
		JTextPane txtpnAa = new JTextPane();
		txtpnAa.setText(tomate.getDescription());
		panel_1.add(txtpnAa, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setMinimumSize(new Dimension(50, 10));
		panel_1.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		panel_2.setLayout(new GridLayout(0, 4, 10, 10));
		
		JLabel lblQuantite = new JLabel("Quantité : ");
		lblQuantite.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblQuantite);
		
		JSpinner spinner = new JSpinner();
		panel_2.add(spinner);
		spinner.setBounds(new Rectangle(0, 0, 10, 0));
		spinner.setMinimumSize(new Dimension(50, 20));
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner.setValue(1);
	
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean modif = false;
				for (EPanier article: ihm.Acceuil.listPanier) {
					if (article.getTomate().getDésignation() == tomate.getDésignation()) {
						System.out.println("ça fait le taf");
						article.addNombre((int) spinner.getValue());
						ihm.Panier.calcValPanier(); 
						ihm.Acceuil.eurPanier.setText(ihm.Panier.valPanier+"€");
						modif = true;
					}
				}
				if (!modif) {
					ihm.Acceuil.listPanier.add(new EPanier(tomate, (int) spinner.getValue()));
					ihm.Panier.calcValPanier(); 
					ihm.Acceuil.eurPanier.setText(ihm.Panier.valPanier+"€");
				}
				dispose();
			}
		});
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(100, 10));
		panel_3.setSize(new Dimension(900, 0));
		panel_1.add(panel_3, BorderLayout.WEST);
		
		if (tomate.isDisponible()) {
			lblNewLabel_1.setText("En Stock");
		} else {
			lblNewLabel_1.setText("Epuisée");

		}
	}

}

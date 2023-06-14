package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modele.EPanier;
import modele.Tomate;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
	@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
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
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{90, 0};
		gbl_panel.rowHeights = new int[] {50, 92, 50, 92, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel Image = new JLabel("");
		Image.setIcon(new ImageIcon(InfoTomate.class.getResource("/images/Tomates200x200/"+ tomate.getNomImage() + ".jpg")));
		
		GridBagConstraints gbc_Image = new GridBagConstraints();
		gbc_Image.fill = GridBagConstraints.BOTH;
		gbc_Image.insets = new Insets(0, 0, 5, 0);
		gbc_Image.gridx = 0;
		gbc_Image.gridy = 1;
		panel.add(Image, gbc_Image);
		
		JLabel lblapparantée = new JLabel("Tomate apparentée");
		GridBagConstraints gbc_lblapparantée = new GridBagConstraints();
		gbc_lblapparantée.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblapparantée.insets = new Insets(0, 0, 5, 0);
		gbc_lblapparantée.gridx = 0;
		gbc_lblapparantée.gridy = 2;
		panel.add(lblapparantée, gbc_lblapparantée);
		
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
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 3;
		panel.add(list, gbc_list);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel space_top = new JPanel();
		space_top.setPreferredSize(new Dimension(10, 50));
		panel_1.add(space_top, BorderLayout.NORTH);
		
		JPanel South = new JPanel();
		South.setMinimumSize(new Dimension(50, 10));
		panel_1.add(South, BorderLayout.SOUTH);
		
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
		South.setLayout(new GridLayout(0, 4, 10, 10));
		
		JLabel lblQuantite = new JLabel("Quantité : ");
		lblQuantite.setHorizontalAlignment(SwingConstants.RIGHT);
		South.add(lblQuantite);
		
		JSpinner spinner = new JSpinner();
		South.add(spinner);
		spinner.setBounds(new Rectangle(0, 0, 10, 0));
		spinner.setMinimumSize(new Dimension(50, 20));
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner.setValue(1);
	
		South.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean modif = false;
				for (EPanier article: ihm.Acceuil.listPanier.getPanier()) {
					if (article.getTomate().getDésignation() == tomate.getDésignation()) {
						ihm.Acceuil.listPanier.modifierAjoutExistant(tomate.getDésignation(), (int) spinner.getValue());
						ihm.Panier.calcValPanier(); //TODO 
						ihm.Acceuil.eurPanier.setText(ihm.Panier.valPanier+"€");
						modif = true;
					}
				}
				if (!modif) {
					ihm.Acceuil.listPanier.ajouter(tomate, (int) spinner.getValue());
					ihm.Panier.calcValPanier(); 
					ihm.Acceuil.eurPanier.setText(ihm.Panier.valPanier+"€");
				}
				dispose();
			}
		});
		South.add(btnNewButton_1);
		
		JPanel space_west = new JPanel();
		space_west.setPreferredSize(new Dimension(100, 10));
		space_west.setSize(new Dimension(900, 0));
		panel_1.add(space_west, BorderLayout.WEST);
		
		JPanel Center_container = new JPanel();
		panel_1.add(Center_container, BorderLayout.CENTER);
		Center_container.setLayout(new BorderLayout(0, 0));
		
		JPanel south = new JPanel();
		Center_container.add(south, BorderLayout.SOUTH);
		south.setLayout(new GridLayout(3, 2, 20, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(30, 10));
		Center_container.add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		Center_container.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JTextPane desc = new JTextPane();
		desc.setText(tomate.getDescription());
		panel_3.add(desc);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 60));
		panel_3.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(3, 1, 40, 7));
		
		JLabel lblNewLabel_4 = new JLabel(tomate.getSousTitre());
		panel_4.add(lblNewLabel_4);
		JLabel Prix = new JLabel("Prix : "+tomate.getPrixTTC()+ "€ pour "+ tomate.getNombreDeGraines()+" graines");
		panel_4.add(Prix);
		
		JLabel Quantité = new JLabel();
		panel_4.add(Quantité);
		

		
		if (tomate.isDisponible()) {
			lblNewLabel_1.setText("En Stock");
		} else {
			lblNewLabel_1.setText("Epuisée");

		}
	}

}

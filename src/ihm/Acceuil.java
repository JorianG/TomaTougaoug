package ihm;
import modele.Tomates;
import modele.GenerationArticles;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modele.Tomate;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;

import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Acceuil extends JFrame {
	
	
	
	private JPanel contentPane;
	private DefaultTableModel modeleTable;
	private Tomates bdTomates = GenerationArticles.generationDeBaseDesTomates();
	private JTable table;
	public List<Tomate> instBd = bdTomates.getLesTomates();
	private JComboBox comboCat;
	private JComboBox comboCouleur;
	
	
	private class article{
		public article(Tomate t, int nb) {
			Tomate tomate = t;
			int nombre = nb;
			
		}
	}
	
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
		//main
		
		
		
	}
	private class ImageRender extends DefaultTableCellRenderer {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			String photoName = "/images/Tomates40x40/"+ value.toString()+".jpg";
			JLabel lab = new JLabel();
			lab.setText("");
			//System.out.println(photoName);
			lab.setIcon( new ImageIcon(Acceuil.class.getResource(photoName)));
				
			
			return lab;
		}
		
	}
	public void emptyTable() {
		this.modeleTable.setRowCount(0);
	}
	
	/**
	 * Fill the table on the landing pages according to the filters applied
	 * @param couleur
	 * @param type
	 */
	public void fillTable() {
		emptyTable();
		for(int i =0; i < instBd.size(); i++) {
			//ImageIcon icon = new ImageIcon("/images/TomaTougaoug.png" );
			//System.out.println("/images.Tomates40x40/"+ instBd.get(i).getNomImage()+".jpg");
			System.out.println(instBd.get(i).getCouleur().getDenomination());
			if(instBd.get(i).getTypeGraine().getDenomination().equals(comboCat.getSelectedItem()) && instBd.get(i).getCouleur().getDenomination().equals(comboCouleur.getSelectedItem())) {
				modeleTable.addRow(new Object[] {instBd.get(i).getDésignation(),
						instBd.get(i).getPrixTTC() + " € pour " + instBd.get(i).getNombreDeGraines() + " graines",
						instBd.get(i).getNomImage() });
			}
			
		}
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
		
		JPanel footer = new JPanel();
		contentPane.add(footer, BorderLayout.SOUTH);
		footer.setLayout(new BorderLayout(0, 0));
		
		JPanel Left = new JPanel();
		FlowLayout flowLayout = (FlowLayout) Left.getLayout();
		footer.add(Left, BorderLayout.CENTER);
		
		JLabel tomate = new JLabel("Catégorie : ");
		Left.add(tomate);
		
		
		/**
		 * Combo box pour le choix de la couleur filtree
		 * ________________________________________________________________________________
		 */
		comboCat = new JComboBox<Object>();
		comboCat.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				fillTable();
			}
		});
		comboCat.setModel(new DefaultComboBoxModel(modele.TypeTomate.getAllTypeTomate()));
		//comboCat.setModel(new DefaultComboBoxModel(new String[] {modele.TypeTomate.TOMATES.getDenomination(),modele.TypeTomate.TOMATES_CERISES.getDenomination()}));
		Left.add(comboCat);
		comboCat.setSelectedIndex(0);
		
		/**
		 * __________________________________________________________________________________		
		 */
		
		JLabel Couleur = new JLabel("Couleur :");
		Couleur.setHorizontalAlignment(SwingConstants.RIGHT);
		Left.add(Couleur);
		
		/**
		 * Combo box pour le choix de la couleur filtree
		 * ________________________________________________________________________________
		 */
		comboCouleur = new JComboBox();
		comboCouleur.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				fillTable();
			}
		});
		comboCouleur.setModel(new DefaultComboBoxModel(modele.Couleur.getAllCouleur()));
		Left.add(comboCouleur);
		comboCouleur.setSelectedIndex(0);
		/**
		 * __________________________________________________________________________________		
		 */
		JPanel Right = new JPanel();
		footer.add(Right, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("p");
		Right.add(btnNewButton);
		
		JButton Info = new JButton("Plus d'info");
		Info.setMargin(new Insets(7, 22, 7, 22));
		Right.add(Info);
		
		JPanel header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);
		
		JLabel titre = new JLabel("Commandez vos tomates");
		titre.setIcon(new ImageIcon(Acceuil.class.getResource("/images/TomaTougaoug.png")));
		titre.setHorizontalAlignment(SwingConstants.LEFT);
		titre.setForeground(Color.GREEN);
		titre.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 23));
		header.add(titre);
		
		JPanel panier = new JPanel();
		panier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ihm.Panier.main(null);;
			}
		});
		panier.setSize(new Dimension(80, 40));
		panier.setForeground(new Color(255, 128, 64));
		panier.setBackground(new Color(255, 128, 64));
		header.add(panier);
		
		JLabel txtPanier = new JLabel("Panier");
		txtPanier.setIcon(new ImageIcon(Acceuil.class.getResource("/images/panier.png")));
		txtPanier.setFont(new Font("Tahoma", Font.BOLD, 12));
		panier.add(txtPanier);
		
		JLabel eurPanier = new JLabel("0.00€");
		eurPanier.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panier.add(eurPanier);
		
		
		modeleTable = new DefaultTableModel(
                new Object[] {"NOM", "PRIX", "IMAGE"}, 0);
		
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JTable table = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
		table.setShowHorizontalLines(true);
		table.setShowGrid(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(modeleTable);
		table.getColumnModel().getColumn(2).setCellRenderer(new ImageRender());
		table.setRowHeight(50);
		table.setEnabled(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println(instBd.get(table.getSelectedRow()));
			}
		});
		scrollPane.setViewportView(table);
		
		
		
		
		fillTable();
		
	}

}

package ihm;

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
import javax.swing.table.DefaultTableModel;

import modele.Tomate;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Acceuil extends JFrame {
	
	
	
	private JPanel contentPane;
	private DefaultTableModel modeleTable;
	private JTable table;
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
	
	public void emptyTable(int n) {
		this.modeleTable.setRowCount(1);
	}
	
	public void remplirTable() {
		
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
		
		JComboBox comboBox = new JComboBox();
		Left.add(comboBox);
		
		JLabel Couleur = new JLabel("Couleur :");
		Couleur.setHorizontalAlignment(SwingConstants.RIGHT);
		Left.add(Couleur);
		
		JComboBox comboBox_1 = new JComboBox();
		Left.add(comboBox_1);
		
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
		
		
		this.table = new JTable(modeleTable);
        table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,null));
        table.setModel(modeleTable);
        modeleTable.addRow(
                new Object[] {"NOM", "PRIX", "IMAGE"});
        table.setEnabled(false);
		contentPane.add(table, BorderLayout.CENTER);
		
		
		
	}

}

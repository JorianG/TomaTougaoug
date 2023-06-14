package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modele.EPanier;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class Panier extends JFrame {
	
	private JPanel contentPane;
	private static DefaultTableModel modeleTable;
	private static JTextField textFieldST;
	protected static JButton btnValider;
	private JTextField textFieldExpe;
	private static JTextField textFieldTotal;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panier frame = new Panier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static float round(float val) {
		return  (float) Math.round(val * 100) / 100; 
	}
	
	public static boolean isFloatString(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.' || str.charAt(i) == ',') {
				System.out.println("ll");
				return true;
			}
		}
		return false;
	}
	
	public static String stringToFloat(String str) {
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ',') {
				res = res+".";
			} else {
				res = res+str.charAt(i);
			}
		}
		return res;
	}
	
	public static void fillTable() {
		modeleTable.setRowCount(0);
		for (EPanier t: ihm.Accueil.listPanier.getPanier()) {
			modeleTable.addRow(new Object[] {t.getTomate().getNomImage(), t.getTomate().getDésignation(), (float) t.getNombre(), t.getTomate().getPrixTTC(), round((float) (t.getNombre()*t.getTomate().getPrixTTC()))});
		}
	}
	
	
	private class ImageRender extends DefaultTableCellRenderer {

		/**
		 * 
		 */
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			String photoName = "/images/Tomates40x40/"+ value.toString()+".jpg";
			JLabel lab = new JLabel();
			lab.setText("");
			//System.out.println(photoName);
			lab.setIcon( new ImageIcon(Accueil.class.getResource(photoName)));
			return lab;
		}	
	}
	
	public static void recalcul() {
		ihm.Accueil.listPanier.setValPanier(0F);
		for (int i = 0; i < modeleTable.getRowCount(); i++) {
			if (modeleTable.getValueAt(i, 2) instanceof String) {
				if (!isFloatString((String) modeleTable.getValueAt(i, 2))) {
					float val = (float) Integer.parseInt((String) modeleTable.getValueAt(i, 2)) * (float) modeleTable.getValueAt(i, 3);
					ihm.Accueil.listPanier.addValPanier(val);
					Object[] data = new Object[] {
							modeleTable.getValueAt(i, 0),
							modeleTable.getValueAt(i, 1),
							modeleTable.getValueAt(i, 2),
							modeleTable.getValueAt(i, 3),
							round(val)
					};
					modeleTable.removeRow(i);
					modeleTable.insertRow(i, data);	
					updateListPanier();
				} else {
					float val = (float) Float.parseFloat(stringToFloat((String) modeleTable.getValueAt(i, 2))) * (float) modeleTable.getValueAt(i, 3);
					ihm.Accueil.listPanier.addValPanier(val);
					Object[] data = new Object[] {
							modeleTable.getValueAt(i, 0),
							modeleTable.getValueAt(i, 1),
							modeleTable.getValueAt(i, 2),
							modeleTable.getValueAt(i, 3),
							round(val)
					};
					modeleTable.removeRow(i);
					modeleTable.insertRow(i, data);	
					updateListPanier();
				}
			} else {
				float val = (float) modeleTable.getValueAt(i, 2) * (float) modeleTable.getValueAt(i, 3);
				ihm.Accueil.listPanier.addValPanier(val);
				Object[] data = new Object[] {
						modeleTable.getValueAt(i, 0),
						modeleTable.getValueAt(i, 1),
						modeleTable.getValueAt(i, 2),
						modeleTable.getValueAt(i, 3),
						round(val)
				};
				modeleTable.removeRow(i);
				modeleTable.insertRow(i, data);	
			}	
		}
		textFieldST.setText(""+ihm.Accueil.listPanier.getValPanier()+"€");
		textFieldTotal.setText(""+(ihm.Accueil.listPanier.getValTotal())+"€");
		
	}
	
	
	public static void updateListPanier() { 
		for (int i = 0; i < modeleTable.getRowCount(); i++) {
			for (EPanier article: ihm.Accueil.listPanier.getPanier()) {
				if (article.getTomate().getDésignation() == modeleTable.getValueAt(i, 1)) {
					if (!isFloatString((String) modeleTable.getValueAt(i, 2))) {
						ihm.Accueil.listPanier.modifierSaisie(article.getTomate().getDésignation(), Integer.parseInt((String) modeleTable.getValueAt(i, 2)));
					} else {
						ihm.Accueil.listPanier.modifierSaisie(article.getTomate().getDésignation(), (int) Float.parseFloat((String) modeleTable.getValueAt(i, 2)));
					}
				}
			}
		}
	}

	public static void viderTable() {
		ihm.Accueil.listPanier.supprimer(); 
		modeleTable.setRowCount(0);
		recalcul();
		ihm.Accueil.eurPanier.setText("0.0€");
	}
	
	/**
	 * Create the frame.
	 */

	public Panier() {
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitre = new JLabel("Votre Panier");
		lblTitre.setIcon(new ImageIcon(Panier.class.getResource("/images/panier.png")));
		contentPane.add(lblTitre, BorderLayout.NORTH);
		
		modeleTable = new DefaultTableModel(
				new Object[] {"Image", "Produit", "Quantit\u00E9", "Prix/u", "Total"}, 0) {
				boolean[] canEdit = new boolean[] {false, false, true, false, false};
				@Override
				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return canEdit[columnIndex];
				}
		};

		
		
		JPanel south = new JPanel();
		south.setBounds(new Rectangle(0, 0, 0, 100));
		south.setBorder(null);
		contentPane.add(south, BorderLayout.SOUTH);
		south.setLayout(new BorderLayout(0, 0));
		
		JButton btnRecaculer = new JButton("Recalculer");
		btnRecaculer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				recalcul();
			}
		});
		south.add(btnRecaculer, BorderLayout.WEST);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		south.add(panelMenu, BorderLayout.SOUTH);
		panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnValider = new JButton("Valider");
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnValider.isEnabled()) {
					ihm.Paiement.main(null);
					dispose();
				}
			}
		});
		panelMenu.add(btnValider);
		
		JButton btnVider = new JButton("Vider");
		btnVider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ihm.SupPanier.main(null);
			}
		});
		panelMenu.add(btnVider);
		
		JButton btnContinuer = new JButton("Continuer");
		btnContinuer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		panelMenu.add(btnContinuer);
		
		JPanel panelTotal = new JPanel();
		south.add(panelTotal, BorderLayout.EAST);
		panelTotal.setLayout(new GridLayout(3, 2, 5, 5));
		
		JLabel lblST = new JLabel("Sous-total : ");
		panelTotal.add(lblST);
		
		textFieldST = new JTextField();
		textFieldST.setBorder(null);
		textFieldST.setEditable(false);
		panelTotal.add(textFieldST);
		textFieldST.setColumns(10);
		
		JLabel lblExpedition = new JLabel("Frais expédition :");
		panelTotal.add(lblExpedition);
		
		textFieldExpe = new JTextField();
		textFieldExpe.setText("4.50€");
		textFieldExpe.setBorder(null);
		textFieldExpe.setEditable(false);
		panelTotal.add(textFieldExpe);
		textFieldExpe.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total :");
		panelTotal.add(lblTotal);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setBorder(null);
		textFieldTotal.setEditable(false);
		panelTotal.add(textFieldTotal);
		textFieldTotal.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(modeleTable);
		table.setEnabled(true);
		table.setRowHeight(40);
		table.getColumnModel().getColumn(0).setCellRenderer(new ImageRender());
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(table);
		
		modeleTable.addRow(new Object[] {1,2,(float) 3, (float) 4, 5});
		fillTable();
		recalcul();
	}

}

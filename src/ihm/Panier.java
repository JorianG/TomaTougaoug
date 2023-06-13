package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;

import modele.EPanier;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Panier extends JFrame {
	
	protected static float valPanier = 0;
	private JPanel contentPane;
	private static DefaultTableModel modeleTable;
	private static JTextField textFieldST;
	protected static JButton btnNewButton_1;
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
	
	public static void fillTable() {
		modeleTable.setRowCount(0);
		for (EPanier t: ihm.Acceuil.listPanier) {
			modeleTable.addRow(new Object[] {t.getTomate().getNomImage(), t.getTomate().getDésignation(), (float) t.getNombre(), t.getTomate().getPrixTTC(), round((float) (t.getNombre()*t.getTomate().getPrixTTC()))});
		}
	}
	
	public static void calcValPanier() {
		valPanier = 0F;
		for (EPanier e: ihm.Acceuil.listPanier) {
			valPanier += round(e.getNombre()*e.getTomate().getPrixTTC());
		}
	}
	
	public static void recalcul() {
		valPanier = 0;
		for (int i = 0; i < modeleTable.getRowCount(); i++) {
			if (modeleTable.getValueAt(i, 2) instanceof String) {
				float val = (float) Integer.parseInt((String) modeleTable.getValueAt(i, 2)) * (float) modeleTable.getValueAt(i, 3);
				valPanier += val;
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
				float val = (float) modeleTable.getValueAt(i, 2) * (float) modeleTable.getValueAt(i, 3);
				valPanier += val;
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
		valPanier = round(valPanier);
		float total = (float) (valPanier+4.50);
		textFieldST.setText(""+valPanier+"€");
		textFieldTotal.setText(""+(total)+"€");
		
	}
	
	
	public static void updateListPanier() {
		for (int i = 0; i < modeleTable.getRowCount(); i++) {
			for (EPanier article: ihm.Acceuil.listPanier) {
				if (article.getTomate().getDésignation() == modeleTable.getValueAt(i, 1)) {
					article.setNombre(Integer.parseInt((String) modeleTable.getValueAt(i, 2)));
				}
			}
		}
	}

	public static void viderTable() {
		ihm.Acceuil.listPanier.clear();
		modeleTable.setRowCount(0);
		recalcul();
		ihm.Acceuil.eurPanier.setText("0.0€");
	}
	
	/**
	 * Create the frame.
	 */

	@SuppressWarnings("serial")
	public Panier() {
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Votre Panier");
		lblNewLabel.setIcon(new ImageIcon(Panier.class.getResource("/images/panier.png")));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
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
		
		JButton btnNewButton = new JButton("Recalcul");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				recalcul();
			}
		});
		south.add(btnNewButton, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		south.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnNewButton_1.isEnabled()) {
					dispose();
					//TODO paiement
				}
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Vider");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ihm.SupPanier.main(null);
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Continuer");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		panel_1.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		south.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(3, 2, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Sous-total : ");
		panel_2.add(lblNewLabel_1);
		
		textFieldST = new JTextField();
		textFieldST.setBorder(null);
		textFieldST.setEditable(false);
		panel_2.add(textFieldST);
		textFieldST.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Frais expédition :");
		panel_2.add(lblNewLabel_2);
		
		textFieldExpe = new JTextField();
		textFieldExpe.setText("4.50€");
		textFieldExpe.setBorder(null);
		textFieldExpe.setEditable(false);
		panel_2.add(textFieldExpe);
		textFieldExpe.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Total :");
		panel_2.add(lblNewLabel_3);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setBorder(null);
		textFieldTotal.setEditable(false);
		panel_2.add(textFieldTotal);
		textFieldTotal.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(modeleTable);
		table.setEnabled(true);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(table);
		
		modeleTable.addRow(new Object[] {1,2,(float) 3, (float) 4, 5});
		fillTable();
		recalcul();
	}

}

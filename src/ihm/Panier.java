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
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.table.DefaultTableModel;

import modele.Tomate;
import modele.Tomates;
import modele.EPanier;
import modele.GenerationArticles;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.ScrollPaneConstants;

public class Panier extends JFrame {
	
	private Tomates test;
	private JPanel contentPane;
	private DefaultTableModel modeleTable;
	private JTextField textFieldST;
	private JTextField textFieldExpe;
	private JTextField textFieldTotal;
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
	
	public void fillTable() {
		System.out.println("bibou uwu");
		this.modeleTable.setRowCount(0);
		// TODO recupérer les séléctions
		for (EPanier t: ihm.Acceuil.listPanier) {
			this.modeleTable.addRow(new Object[] {t.getTomate().getNomImage(), t.getTomate().getDésignation(), (float) t.getNombre(), t.getTomate().getPrixTTC(), (float) (t.getNombre()*t.getTomate().getPrixTTC())});
		}
	}
	
	public void recalcul() {
		System.out.println(this.modeleTable.getRowCount());
		float sum = 0;
		for (int i = 0; i < this.modeleTable.getRowCount(); i++) {
			float val = (float) this.modeleTable.getValueAt(i, 2) * (float) this.modeleTable.getValueAt(i, 3);
			sum += val;
			Object[] data = new Object[] {
					this.modeleTable.getValueAt(i, 0),
					this.modeleTable.getValueAt(i, 1),
					this.modeleTable.getValueAt(i, 2),
					this.modeleTable.getValueAt(i, 3),
					val
			};
			this.modeleTable.removeRow(i);
			this.modeleTable.insertRow(i, data);
			
		}
		float total = (float) (sum+4.50);
		this.textFieldST.setText(""+sum+"€");
		this.textFieldTotal.setText(""+(total)+"€");
	}
	
	public void viderTable() {
		// Ajouter le pop-up de confirmation
		ihm.Acceuil.listPanier.clear();
		this.modeleTable.setRowCount(0);
		recalcul();
	}
	
	/**
	 * Create the frame.
	 */

	public Panier(Tomates test) {
		this.test = test;
<<<<<<< Updated upstream

=======
		
>>>>>>> Stashed changes
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Votre Panier");
		lblNewLabel.setIcon(new ImageIcon(Panier.class.getResource("/images/panier.png")));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		modeleTable = new DefaultTableModel(
				new Object[] {"Image", "Produit", "Quantit\u00E9", "Prix/u", "Total"}, 0);
		
		JPanel south = new JPanel();
		south.setBounds(new Rectangle(0, 0, 0, 100));
		south.setBorder(null);
		contentPane.add(south, BorderLayout.SOUTH);
		south.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Recacul");
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
		
		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				//TODO paiement
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Vider");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viderTable();
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
		table.setEnabled(false);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(table);
		
		modeleTable.addRow(new Object[] {1,2,(float) 3, (float) 4, 5});
		fillTable();
		recalcul();
	}

}

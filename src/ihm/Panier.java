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
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panier extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modeleTable;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		this.modeleTable.setRowCount(1);
	}
	
	/**
	 * Create the frame.
	 */
	public Panier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Votre Panier");
		lblNewLabel.setIcon(new ImageIcon(Panier.class.getResource("/images/panier.png")));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		modeleTable = new DefaultTableModel(
				new Object[] {"Image", "Produit", "Quantit\u00E9", "Total"}, 0);
		
		JTable table = new JTable(modeleTable);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Image", "Produit", "Quantit\u00E9", "Total"},
				{"0", "0", "1213", "0"},
				{null, "0", "0", "0"},
			},
			new String[] {
				"Image", "Produit", "Quantit\u00E9", "Total"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setEnabled(false);
		
		contentPane.add(table, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(new Rectangle(0, 0, 0, 100));
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Recacul");
		panel.add(btnNewButton, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_1 = new JButton("Valider");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Vider");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillTable();
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Continuer");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(3, 2, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Sous-total : ");
		panel_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setEditable(false);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Frais expédition :");
		panel_2.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setEditable(false);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Total :");
		panel_2.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setEditable(false);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
	}

}

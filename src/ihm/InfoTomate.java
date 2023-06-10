package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class InfoTomate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(Tomate args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Tomates test = GenerationArticles.generationDeBaseDesTomates();
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
	public InfoTomate(Tomate tomate) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Annuler");
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		panel_2.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNomTomate = new JLabel(tomate.getDésignation());
		panel.add(lblNomTomate);
		
		JLabel lblNewLabel_1 = new JLabel("Description");
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/images/Tomates200x200/"+ tomate.getNomImage()+".jpg"));
		panel.add(lblNewLabel);
		
		textField = new JTextField(tomate.getDescription());
		textField.setColumns(10);
		panel.add(textField);
		
		if (tomate.isDisponible()) {
			JLabel lblstock = new JLabel("En Stock");
			panel.add(lblstock);
		} else {
			JLabel lblstock = new JLabel("Epuisée");
			panel.add(lblstock);
		}
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
	}

}

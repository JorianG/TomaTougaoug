package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ChampsManquantsF extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChampsManquantsF frame = new ChampsManquantsF();
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
	public ChampsManquantsF() {
		setTitle("Champs manquants");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChampsManquantsF.class.getResource("/images/TomaTougaoug.png")));
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTexte = new JPanel();
		contentPane.add(panelTexte, BorderLayout.CENTER);
		panelTexte.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Tout les champs ne sont pas complété");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelTexte.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Complétez les champ avec *");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelTexte.add(lblNewLabel);
		
		JPanel panelBouton = new JPanel();
		contentPane.add(panelBouton, BorderLayout.SOUTH);
		
		JButton btnButtonOk = new JButton("OK");
		btnButtonOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		panelBouton.add(btnButtonOk);
	}

}

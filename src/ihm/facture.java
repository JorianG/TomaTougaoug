package ihm;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JProgressBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class facture extends JFrame {

    private JPanel contentPane;
    private JTextPane txtpnFacture; // Déclaration de la variable txtpnFacture

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    facture frame = new facture();
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
    public facture() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("Facture");
        lblNewLabel.setIcon(new ImageIcon(facture.class.getResource("/images/TomaTougaoug.png")));
        contentPane.add(lblNewLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton annulerButton = new JButton("Annuler");
        panel.add(annulerButton);
        annulerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Ferme la fenêtre de facture
            }
        });

        JButton imprimerButton = new JButton("Imprimer");
        panel.add(imprimerButton);
        imprimerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // impression de la facture
            }
        });

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_1 = new JLabel("Merci de votre visite");
        lblNewLabel_1.setForeground(Color.RED);
        panel_1.add(lblNewLabel_1, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel_1.add(scrollPane);

        txtpnFacture = new JTextPane();
        scrollPane.setViewportView(txtpnFacture);

        genererContenuFacture(txtpnFacture); // Appel de la méthode pour générer le contenu de la facture
    }

    private void genererContenuFacture(JTextPane txtpnFacture) {
        // Générer le contenu de la facture en fonction des commandes choisies

        // Exemple de contenu de facture
        String contenuFacture = "Commande 1 : Tomates cerises - Quantité : 5 - Prix unitaire : 2€\n"
                + "Commande 2 : Tomates beefsteak - Quantité : 3 - Prix unitaire : 3€\n"
                + "Commande 3 : Tomates cocktail - Quantité : 2 - Prix unitaire : 1.5€\n"
                + "Total : 18.5€";

        txtpnFacture.setText(contenuFacture); // Afficher le contenu de la facture dans le JTextPane
    }
}




			
		
	

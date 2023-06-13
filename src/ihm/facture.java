package ihm;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;

import modele.Client;
import modele.EPanier;
import modele.PrintRectangle;
import modele.Tomate;

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
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class facture extends JFrame {

	private Client client;
	
    private JPanel contentPane;
    private static JTextPane txtpnFacture; // Déclaration de la variable txtpnFacture

    /**
     * Launch the application.
     */
    public static void main(Client client) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    facture frame = new facture(client);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public String affichagePanierFacture() {
    	String str = "";
    	for (int i = 0; i < ihm.Acceuil.listPanier.size(); i++) {
    		Tomate tomate = ihm.Acceuil.listPanier.get(i).getTomate();
    		int nb = ihm.Acceuil.listPanier.get(i).getNombre();
    		str = str+""+(i+1)+""+" : "+tomate.getDésignation()+", quantité commandé : "+nb+" €, Prix TTC : "+tomate.getPrixTTC()+" €, Sous Total : "+ihm.Panier.round(tomate.getPrixTTC()*nb)+" €\n";
    	}
    	return str;
    }

    
    public static void impression() {
        // Récupère un PrinterJob
        PrinterJob job = PrinterJob.getPrinterJob();
        // Définit son contenu à imprimer
        job.setPrintable(new PrintRectangle(txtpnFacture.getText()));
        // Affiche une boîte de choix d'imprimante
        if (job.printDialog()){
           try {
              // Effectue l'impression
              job.print();
           } catch (PrinterException ex) {
              ex.printStackTrace();
           }
        }
    }
    
    /**
     * Create the frame.
     */
    public facture(Client client) {
    	this.client = client;
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
        imprimerButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		impression();
        	}
        });
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
        System.out.println(client);
        genererContenuFacture(txtpnFacture); // Appel de la méthode pour générer le contenu de la facture
    }

    private void genererContenuFacture(JTextPane txtpnFacture) {
        // Générer le contenu de la facture en fonction des commandes choisies

        // Exemple de contenu de facture
        String contenuFacture = "					SARL Tomatougaoug\n"
                + "					Vente de graines de tomates\n"
                + "					133 Avenue de Rangeuil\n"
                + "					31400 Toulouse\n"
        		+ "					France\n"
        		+ "					Tel : 0734256542\n"
        		+ "					Mail : tomatougaoug@gmail.com\n\n\n"
			+ "Information Client :\n"
			+ ""+client.getNom()+" "+client.getPrenom()+"\n"
			+ ""+client.getAdresse1()+"\n"
			+ ""+client.getAdresse2()+"\n"
			+ "téléphone : "+client.getTelephone()+"\n"
			+ "email : "+client.getEmail()+"\n"
			+ "Moyen de paiement par "+client.getPaiement()+"\n\n\n" // todo refaire getPaiement
			+ "Votre Commande : \n\n"
			+ ""+affichagePanierFacture()+"\n\n"
			+ "Votre commande               :  "+ihm.Panier.valPanier+" €\n"
			+ "Expédition Forfait France :  4.5 €\n"
			+ "Prix Total TTC                     :  "+(ihm.Panier.round((float) (ihm.Panier.valPanier+4.5)))+" €";

        txtpnFacture.setText(contenuFacture); // Afficher le contenu de la facture dans le JTextPane
    }
}




			
		
	

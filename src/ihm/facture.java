package ihm;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modele.Client;
import modele.PrintRectangle;
import modele.Tomate;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
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
    	for (int i = 0; i < ihm.Accueil.listPanier.taille(); i++) {
    		Tomate tomate = ihm.Accueil.listPanier.getPanier().get(i).getTomate();
    		int nb = ihm.Accueil.listPanier.getPanier().get(i).getNombre();
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

        JLabel lblHeader = new JLabel("Facture");
        lblHeader.setIcon(new ImageIcon(facture.class.getResource("/images/TomaTougaoug.png")));
        contentPane.add(lblHeader, BorderLayout.NORTH);

        JPanel panelBouton = new JPanel();
        contentPane.add(panelBouton, BorderLayout.SOUTH);
        panelBouton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton annulerButton = new JButton("Annuler");
        panelBouton.add(annulerButton);
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
        panelBouton.add(imprimerButton);
        imprimerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // impression de la facture
            }
        });

        JPanel panelFacture = new JPanel();
        contentPane.add(panelFacture, BorderLayout.CENTER);
        panelFacture.setLayout(new BorderLayout(0, 0));

        JLabel lblMerci = new JLabel("Merci de votre visite");
        lblMerci.setForeground(Color.RED);
        panelFacture.add(lblMerci, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panelFacture.add(scrollPane);

        txtpnFacture = new JTextPane();
        scrollPane.setViewportView(txtpnFacture);
        txtpnFacture.setEditable(false);
        genererContenuFacture(txtpnFacture); // Appel de la méthode pour générer le contenu de la facture
    }

    private void genererContenuFacture(JTextPane txtpnFacture) {
        // Générer le contenu de la facture en fonction des commandes choisies

        // Exemple de contenu de facture
    	String contenuFacture = "";
    	if (client.getAdresse2() == "") {
    		contenuFacture = "					SARL Tomatougaoug\n"
                    + "					Vente de graines de tomates\n"
                    + "					133 Avenue de Rangeuil\n"
                    + "					31400 Toulouse\n"
            		+ "					France\n"
            		+ "					Tel : 0734256542\n"
            		+ "					Mail : tomatougaoug@gmail.com\n\n\n"
    			+ "Information Client :\n"
    			+ ""+client.getNom()+" "+client.getPrenom()+"\n"
    			+ ""+client.getAdresse1()+"\n"
    			+ "téléphone : "+client.getTelephone()+"\n"
    			+ "email : "+client.getEmail()+"\n"
    			+ "Moyen de paiement par "+client.getPaiement()+"\n\n\n"
    			+ "Votre Commande : \n\n"
    			+ ""+affichagePanierFacture()+"\n\n"
    			+ "Votre commande               :  "+ihm.Accueil.listPanier.getValPanier()+" €\n"
    			+ "Expédition Forfait France :  4.5 €\n"
    			+ "Prix Total TTC                     :  "+ihm.Accueil.listPanier.getValTotal()+" €\n";
    	} else {
    		contenuFacture = "					SARL Tomatougaoug\n"
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
    			+ "Moyen de paiement par "+client.getPaiement()+"\n\n\n"
    			+ "Votre Commande : \n\n"
    			+ ""+affichagePanierFacture()+"\n\n"
    			+ "Votre commande               :  "+ihm.Accueil.listPanier.getValPanier()+" €\n"
    			+ "Expédition Forfait France :  4.5 €\n"
    			+ "Prix Total TTC                     :  "+ihm.Accueil.listPanier.getValTotal()+" €\n";
    	}
        

        txtpnFacture.setText(contenuFacture); // Afficher le contenu de la facture dans le JTextPane
    }
}




			
		
	

package modele;

public class Client {
	private String nom;
	private String prenom;
	private String adresse1;
	private String adresse2;
	private String codePostal;
	private String ville;
	private String telephone;
	private String email;
	/*
	0 : carte de crédit (default)
	1 : paypal
	2 : paiemennt par chèque
	 */
	private int paiement;
	private boolean newsletter;
	
	public Client(String nom, String prenom, String adresse1, String adresse2, String codePostal,
				  String ville, String telephone, String email, int paiement, boolean newsletter) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.email = email;
		this.paiement = paiement;
		this.newsletter = newsletter;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse1() {
		return adresse1;
	}

	public String getAdresse2() {
		return adresse2;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getEmail() {
		return email;
	}

	public String getPaiement() {
		if (paiement == 0) {
			return "Carte de crédit";
		} else if (paiement == 1) {
			return "Paypal";
		} else {
			return "Chèques";
		}
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}

	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPaiement(int paiement) {
		this.paiement = paiement;
	}

	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}
}

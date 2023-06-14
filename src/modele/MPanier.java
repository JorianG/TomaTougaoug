package modele;

import java.util.LinkedList;
import java.util.List;

public class MPanier {
	private List<EPanier> panier;
	
	public MPanier() {
		this.panier = new LinkedList<EPanier>();
	}
	
	public void ajouter(Tomate tomate, int nombre) {
		this.panier.add(new EPanier(tomate, nombre));
	}
	
	public void supprimer() {
		this.panier.clear();
	}
	
	public void modifierSaisie(String designation, int nombre) {
		// ptet un return String
		for (int i = 0; i < this.panier.size(); i++) {
			if (this.panier.get(i).getTomate().getDésignation() == designation) {
				this.panier.get(i).getTomate();
				this.panier.get(i).setNombre(nombre);
			}
		}
	}
	
	public void modifierAjoutExistant(String designation, int nombre) {
		for (int i = 0; i < this.panier.size(); i++) {
			if (this.panier.get(i).getTomate().getDésignation() == designation) {
				this.panier.get(i).getTomate();
				this.panier.get(i).addNombre(nombre);
			}
		}
	}
	
	public int taille() {
		return this.panier.size();
	}
	
	public List<EPanier> getPanier() {
		return this.panier;
	}
}

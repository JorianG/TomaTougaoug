package modele;

import java.util.LinkedList;
import java.util.List;

public class MPanier {
	private List<EPanier> panier;
	private float valPanier;
	
	public MPanier() {
		this.panier = new LinkedList<EPanier>();
		this.valPanier = 0F;
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
	
	public void addValPanier(float nombre) {
		this.valPanier += nombre;
	}
	
	public void setValPanier(float nombre) {
		this.valPanier = nombre;
	}
	
	public float getValPanier() {
		calcValPanier();
		return round(this.valPanier);
	}
	
	public void calcValPanier() {
		valPanier = 0F; // TODO
		for (EPanier e: this.panier) {
			valPanier += round(e.getNombre()*e.getTomate().getPrixTTC());
		}
	}
	
	public float getValTotal() {
		calcValPanier();
		return round((float) (getValPanier()+4.5));
	}
	
	private float round(float val) {
		return (float) Math.round(val * 100) / 100;
	}
}

package modele;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Tomate {
	
	private TypeTomate typeGraine;
	private Couleur couleur;
	private String designation;
	private String sousTitre;
	private String nomImage;
	private String description;
	private int nombreDeGraines;
	private float prixTTC;
	private boolean disponible;
	private List<Tomate> tomatesApparentees;
	
	public Tomate(TypeTomate typeGraine, Couleur couleur, String designation, String sousTitre, String nomImage, String description,
			int nombreDeGraines, float prixTTC) {
		this.typeGraine = typeGraine;
		this.couleur = couleur;
		this.designation = designation;
		this.sousTitre = sousTitre;
		this.nomImage = nomImage;
		this.description = description;
		this.nombreDeGraines = nombreDeGraines;
		this.prixTTC = prixTTC;
		this.setDisponible(true);
		this.tomatesApparentees = new LinkedList<Tomate>();
	}

	public TypeTomate getTypeGraine() {
		return typeGraine;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public String getDesignation() {
		return designation;
	}

	public String getNomImage() {
		return nomImage;
	}

	public String getDescription() {
		return description;
	}

	public int getNombreDeGraines() {
		return nombreDeGraines;
	}

	public float getPrixTTC() {
		return prixTTC;
	}
	
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	public String getSousTitre() {
		return sousTitre;
	}

	public void setSousTitre(String sousTitre) {
		this.sousTitre = sousTitre;
	}
	
	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		if (!this.isDisponible()) {
			res.append("EPUISE ! ");
		}
		res.append(this.getTypeGraine().getDenomination() + ',');
		res.append(this.getCouleur().getDenomination() + ',');
		res.append(this.getDesignation() + ',');
		res.append(this.nombreDeGraines + " graines" + ',');
		res.append(String.valueOf(this.getPrixTTC()) + " €" + ',');
		res.append("Image : " + this.getNomImage());
		return res.toString();
	}
	
	public String toStringAvecDescription() {
		return this.toString() + '\n' + this.getDescription();
	}
	
	public String toStringAvecTomatesApparentees() {
		StringBuffer res = new StringBuffer(this.toString());
		res.append("\n Tomates apparentees : ");
		for (Tomate graine: this.getTomatesApparentees()) {
			res.append(graine.getDesignation() + " ");
		}
		return res.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tomate other = (Tomate) obj;
		return Objects.equals(designation, other.designation);
	}
	
	public List<Tomate> getTomatesApparentees() {
		return tomatesApparentees;
	}

	public void addTomateApparentee(Tomate tomate) {
		this.tomatesApparentees.add(tomate);
	}

}

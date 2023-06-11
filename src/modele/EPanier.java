package modele;

public class EPanier {
	private int nombre;
	private Tomate tomate;
	
	public EPanier(Tomate tomate, int nombre) {
		this.tomate = tomate;
		this.nombre = nombre;
	}
	
	public int getNombre() {
		return this.nombre;
	}
	
	public Tomate getTomate() {
		return this.tomate;
	}
	
	public String toString() {
		return this.tomate.toString() + ", " + this.nombre;
	}
}

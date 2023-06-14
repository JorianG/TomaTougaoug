package modele;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MPanierTest {
	
	private Tomates bd = GenerationArticles.generationDeBaseDesTomates();
	private MPanier panier;
	
	@Before
	public void setUp() {
		this.panier = new MPanier();
	}

	@Test
	public void testAjouter() {
		panier.ajouter(bd.getLesTomates().get(0), 1);
		assertEquals(1, panier.taille());
	}
	
	@Test
	public void testSupprimer() {
		for (Tomate tomate: bd.getLesTomates()) {
			this.panier.ajouter(tomate, 1);
		}
		assertEquals(bd.getLesTomates().size(), panier.taille());
		panier.supprimer();
		assertEquals(0, panier.taille());
	}
	
	@Test
	public void testModifierAjoutExistant() {
		panier.ajouter(bd.getLesTomates().get(0), 1);
		assertEquals(1, panier.getPanier().get(0).getNombre());
		panier.modifierAjoutExistant(bd.getLesTomates().get(0).getDésignation(), 41);
		assertEquals(42, panier.getPanier().get(0).getNombre());
	}
	
	@Test
	public void testModifierSaisie() {
		panier.ajouter(bd.getLesTomates().get(0), 1);
		assertEquals(1, panier.getPanier().get(0).getNombre());
		panier.modifierSaisie(bd.getLesTomates().get(0).getDésignation(), 41);
		assertEquals(41, panier.getPanier().get(0).getNombre());
	}

}

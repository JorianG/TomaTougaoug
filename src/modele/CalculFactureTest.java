package modele;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculFactureTest {
	
	private Tomates bd = GenerationArticles.generationDeBaseDesTomates();
	private MPanier panier;
	private float val;
	private float total;
	
	private float round(float val) {
		return (float) Math.round(val * 100) / 100;
	}
	
	@Before
	public void setUp() {
		this.panier = new MPanier();
		val = 0F;
		for (int i = 0; i < 10; i++) {
			val += round(bd.getLesTomates().get(i).getPrixTTC()*7);
			panier.ajouter(bd.getLesTomates().get(i), 7);
		}
		total = round((float) (val+4.5));
		System.out.println(val);
		System.out.println(total);
	}
	
	@Test
	public void testCalcValPanier() {
		panier.calcValPanier();
		System.out.println("t1"+panier.getValPanier());
		assertTrue(val == panier.getValPanier());
	}
	
	@Test
	public void testCalcValTotal() {
		System.out.println("t2"+panier.getValTotal());
		assertTrue(total == panier.getValTotal());
	}

}

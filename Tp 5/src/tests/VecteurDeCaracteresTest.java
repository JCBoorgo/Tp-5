package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import structures.VecteurDeCaracteres;

public class VecteurDeCaracteresTest {
	VecteurDeCaracteres v1, v2, v3;

	@Before
	public void setUp() throws Exception {
		// v1 sera le tableau par défaut
		v1 = new VecteurDeCaracteres();
		char[] c1 = {'A', 'B', 'C'};
		v2 = new VecteurDeCaracteres(c1);
		char[] c2 = {'1', '2', '3', '4', '5', '6'};
		v3 = new VecteurDeCaracteres(c2);
	}

	@Test
	public void testVecteurDeCaracteres() {
		System.out.println(v1.toString());
		// Fonctionne
	}

	@Test
	public void testVecteurDeCaracteresCharArray() {
		assertTrue(v2.toString().equals("Table de correspondance = [A, B, C, ]"));
		assertTrue(v3.toString().equals("Table de correspondance = [1, 2, 3, 4, 5, 6, ]"));
	}

	@Test
	public void testGetCaractere() {
		assertTrue(v1.getCaractere(2) == 'C');
		assertTrue(v2.getCaractere(0) == 'A');
		assertTrue(v3.getCaractere(5) == '6');
		
	}

	@Test
	public void testGetIndice() {
		assertTrue(v1.getIndice('K') == 10);
		assertTrue(v2.getIndice('K') == -1);
		assertTrue(v2.getIndice('B') == 1);
		assertTrue(v3.getIndice('1') == 0);
	}

	@Test
	public void testGetTaille() {
		assertTrue(v1.getTaille() == 28);
		assertTrue(v2.getTaille() == 3);
		assertTrue(v3.getTaille() == 6);
	}

	@Test
	public void testToString() {
		assertTrue(v2.toString().equals("Table de correspondance = [A, B, C, ]"));
		assertTrue(v3.toString().equals("Table de correspondance = [1, 2, 3, 4, 5, 6, ]"));
	}

}

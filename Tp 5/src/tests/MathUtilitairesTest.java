package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utilitaires.MathUtilitaires;

public class MathUtilitairesTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFact() {
		assertTrue(MathUtilitaires.fact(0) == 1);
		assertTrue(MathUtilitaires.fact(1) == 1);
		assertTrue(MathUtilitaires.fact(2) == 2);
		assertTrue(MathUtilitaires.fact(4) == 24);
		assertTrue(MathUtilitaires.fact(7) == 5040);
		assertTrue(MathUtilitaires.fact(10) == 3628800);
	}

	@Test
	public void testModulo() {
		// + mod +
		assertTrue(MathUtilitaires.modulo(7, 3) == 1);
		// + mod -
		assertTrue(MathUtilitaires.modulo(15, -4) == -1);
		// - mod +
		assertTrue(MathUtilitaires.modulo(-26, 4) == 2);
		// - mod -
		assertTrue(MathUtilitaires.modulo(-40, -7) == -5);
	}

	@Test
	public void testDiviseursDe() {
		assertTrue(MathUtilitaires.diviseursDe(5).toString().equals("[1, 5]"));
		assertTrue(MathUtilitaires.diviseursDe(8).toString().equals("[1, 2, 4, 8]"));
		assertTrue(MathUtilitaires.diviseursDe(9).toString().equals("[1, 3, 9]"));
		assertTrue(MathUtilitaires.diviseursDe(1).toString().equals("[1]"));
		assertTrue(MathUtilitaires.diviseursDe(-3).toString().equals("[1, 3]"));
	}

	@Test
	public void testEstPremier() {
		assertFalse(MathUtilitaires.estPremier(1));
		assertTrue(MathUtilitaires.estPremier(2));
		assertTrue(MathUtilitaires.estPremier(3));
		assertTrue(MathUtilitaires.estPremier(5));
		assertFalse(MathUtilitaires.estPremier(6));
		assertTrue(MathUtilitaires.estPremier(11));
	}

	@Test
	public void testXPremier() {
		assertTrue(MathUtilitaires.xPremier(1) == null);
		assertTrue(MathUtilitaires.xPremier(2).toString().equals("[2]"));
		assertTrue(MathUtilitaires.xPremier(10).toString().equals("[2, 3, 5, 7]"));
		assertTrue(MathUtilitaires.xPremier(21).toString().equals("[2, 3, 5, 7, 11, 13, 17, 19]"));
	}

	@Test
	public void testXPremierEntreEux() {
		assertTrue(MathUtilitaires.xPremierEntreEux(4, 8).toString().equals("[5, 7]"));
		assertTrue(MathUtilitaires.xPremierEntreEux(3, 11).toString().equals("[3, 4, 5, 6, 7, 8, 9, 10]"));
		assertTrue(MathUtilitaires.xPremierEntreEux(13, 21).toString().equals("[13, 16, 17, 19, 20]"));
	}

	@Test
	public void testPGCD() {
		assertTrue(MathUtilitaires.PGCD(3, 5) == 1);
		assertTrue(MathUtilitaires.PGCD(8, 4) == 4);
		assertTrue(MathUtilitaires.PGCD(15, 21) == 3);
		assertTrue(MathUtilitaires.PGCD(28, 16) == 4);
		assertTrue(MathUtilitaires.PGCD(1, 1) == 1);
		assertTrue(MathUtilitaires.PGCD(5, 5) == 5);
		assertTrue(MathUtilitaires.PGCD(0, 5) == 0);
	}

	@Test
	public void testAlea() {
		/*
		 * System.out.println("De 1 à 6, 20 picks"); for (int i = 0; i < 20;
		 * i++){ System.out.println(MathUtilitaires.alea(1, 6)); }
		 * System.out.println("De 3 à 9, 25 picks"); for (int i = 0; i < 25;
		 * i++){ System.out.println(MathUtilitaires.alea(3, 9)); }
		 */
		// FONCTIONNE
	}
}

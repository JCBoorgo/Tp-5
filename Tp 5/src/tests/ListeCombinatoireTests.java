package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import structures.ListeCombinatoire;

public class ListeCombinatoireTests {
	ListeCombinatoire l1, l2, l3, l4;

	@Before
	public void setUp() throws Exception {
		l1 = new ListeCombinatoire(1, 5, 2);
		l2 = new ListeCombinatoire(1, 10, 3);
		l3 = new ListeCombinatoire(2, 6, 3);
		// Celui-là a plus l'air de ce qu'on va utiliser
		l4 = new ListeCombinatoire(1, 20, 4);
	}

	@Test
	public void test() {
		System.out.println(l1.toString());
		System.out.println(l2.toString());
		System.out.println(l3.toString());
		System.out.println(l4.toString());
		// FONCTIONNE.
		// Toutes les combinaisons ont été vérifiées, promis.
		// Les autres méthodes ne seront pas testées en tant que tel, vu que le
		// toString et le constructeur touchent à tout
	}

}

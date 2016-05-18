package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.ConstructeurException;
import structures.ListeMatricesChiffrement;
import utilitaires.MatriceUtilitaires;

public class ListeMatricesChiffrementTest {
	ListeMatricesChiffrement l1, l2, l3;

	@Before
	public void setUp() throws Exception {
		l1 = new ListeMatricesChiffrement(1, 15, 3, 28);
		l2 = new ListeMatricesChiffrement(1, 12, 2, 23);
		l3 = new ListeMatricesChiffrement(3, 19, 2, 34);
	}

	@Test
	public void testListeMatricesChiffrement() {
		try {
			ListeMatricesChiffrement t1 = new ListeMatricesChiffrement(-3, 6, 3, 28);
			fail();
		} catch (ConstructeurException e) {

		}
		try {
			ListeMatricesChiffrement t1 = new ListeMatricesChiffrement(9, 1, 3, 28);
			fail();
		} catch (ConstructeurException e) {

		}
		try {
			ListeMatricesChiffrement t1 = new ListeMatricesChiffrement(1, 15, -1, 28);
			fail();
		} catch (ConstructeurException e) {

		}
		try {
			ListeMatricesChiffrement t1 = new ListeMatricesChiffrement(1, 15, 3, -8);
			fail();
		} catch (ConstructeurException e) {

		}
	}

	@Test
	public void testGetNombreMatricesCandidates() {
		// Ok, plan de test: on system.out le nombre, si le nombre est gros on
		// compte que ça passe
		System.out.println(l1.getNombreMatricesCandidates());
		System.out.println(l2.getNombreMatricesCandidates());
		System.out.println(l3.getNombreMatricesCandidates());
		// Ouais ok ça passe.
	}

	@Test
	public void testChoisirMatriceCouranteInt() {
		// Ça va être du system.out ça aussi
		System.out.println("Choix des matrices courantes");
		l1.choisirMatriceCourante(958);
		System.out.println(MatriceUtilitaires.toStringMat(l1.getCopieMatriceCourante()));
		l2.choisirMatriceCourante(345);
		System.out.println(MatriceUtilitaires.toStringMat(l2.getCopieMatriceCourante()));
		l3.choisirMatriceCourante(958);
		System.out.println(MatriceUtilitaires.toStringMat(l3.getCopieMatriceCourante()));
		// Fonctionne
	}

	@Test
	public void testGetCopieMatriceCourante() {
		// Ça va être du system.out ça aussi
		System.out.println("Copies des matrices courantes");
		l1.choisirMatriceCourante(958);
		System.out.println(MatriceUtilitaires.toStringMat(l1.getCopieMatriceCourante()));
		l2.choisirMatriceCourante(345);
		System.out.println(MatriceUtilitaires.toStringMat(l2.getCopieMatriceCourante()));
		l3.choisirMatriceCourante(958);
		System.out.println(MatriceUtilitaires.toStringMat(l3.getCopieMatriceCourante()));
		// Fonctionne
	}

	@Test
	public void testGetMatriceCouranteInverseHill() {
		// Ça va être du system.out ça aussi
		System.out.println("Matrices inverses");
		l1.choisirMatriceCourante(958);
		System.out.println(MatriceUtilitaires.toStringMat(l1.getMatriceCouranteInverseHill()));
		l2.choisirMatriceCourante(345);
		System.out.println(MatriceUtilitaires.toStringMat(l2.getMatriceCouranteInverseHill()));
		l3.choisirMatriceCourante(958);
		System.out.println(MatriceUtilitaires.toStringMat(l3.getMatriceCouranteInverseHill()));
		// Semble fonctionnel
	}

}

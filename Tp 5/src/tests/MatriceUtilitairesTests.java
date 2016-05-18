package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utilitaires.MatriceUtilitaires;

public class MatriceUtilitairesTests {
	int[][] m1, m2, m3;

	@Before
	public void setUp() throws Exception {
		m1 = new int[2][2];
		m1[0][0] = 7;
		m1[1][0] = 3;
		m1[0][1] = 5;
		m1[1][1] = 2;
		m2 = new int[3][3];
		m2[0][0] = 6;
		m2[0][1] = 2;
		m2[0][2] = 9;
		m2[1][0] = 5;
		m2[1][1] = 4;
		m2[1][2] = 5;
		m2[2][0] = 1;
		m2[2][1] = 3;
		m2[2][2] = 7;
		m3 = new int[4][4];
		m3[0][0] = 4;
		m3[0][1] = 6;
		m3[0][2] = 1;
		m3[0][3] = 2;
		m3[1][0] = 3;
		m3[1][1] = 4;
		m3[1][2] = 9;
		m3[1][3] = 7;
		m3[2][0] = 8;
		m3[2][1] = 1;
		m3[2][2] = 2;
		m3[2][3] = 9;
		m3[3][0] = 1;
		m3[3][1] = 6;
		m3[3][2] = 7;
		m3[3][3] = 2;
	}

	@Test
	public void testGetDeterminant() {
		assertTrue(MatriceUtilitaires.getDeterminant(m1) == -1);
		assertTrue(MatriceUtilitaires.getDeterminant(m2) == 117);
		assertTrue(MatriceUtilitaires.getDeterminant(m3) == -279);
	}

	@Test
	public void testGetMatMineur() {
		System.out.println("Mineures");
		System.out.println(MatriceUtilitaires.toStringMat(m2));
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatMineur(0, 0, m2)));
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatMineur(1, 0, m2)));
		// Fonctionne
	}

	@Test
	public void testGetMatCofacteurs() {
		System.out.println("Cofacteurs");
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatCofacteurs(m1)));
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatCofacteurs(m2)));
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatCofacteurs(m3)));
		// Fonctionne
	}

	@Test
	public void testGetMatTranspose() {
		System.out.println("Transposées");
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatTranspose(m1)));
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatTranspose(m2)));
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatTranspose(m3)));
		// Fonctionne
	}
	
	@Test
	public void testGetMatAdjointe() {
		System.out.println("Adjointes");
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatAdjointe(m1)));
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatAdjointe(m2)));
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatAdjointe(m3)));
		// Fonctionne
	}
	
	@Test
	public void testGetMatMultScalaire() {
		System.out.println("Multipliées par un scalaire");
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatMultScalaire(m1, 2)));
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatMultScalaire(m2, -1)));
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatMultScalaire(m3, 5)));
		// Fonctionne
	}
	
	@Test
	public void testGetMatModuloX() {
		System.out.println("Modulos");
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatModuloX(m1, 3)));
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatModuloX(m2, 5)));
		System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatModuloX(m3, 2)));
		// Fonctionne
	}
	
	@Test
	public void testGetDeterminantInverseHill() {
		assertTrue(MatriceUtilitaires.getDeterminantInverseHill(-32, 27) == 16);
		assertTrue(MatriceUtilitaires.getDeterminantInverseHill(5221, 27) == 19);
		assertTrue(MatriceUtilitaires.getDeterminantInverseHill(18, 27) == 0);
	}

}

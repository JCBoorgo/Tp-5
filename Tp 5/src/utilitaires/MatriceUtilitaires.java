package utilitaires;

import java.util.Iterator;
import java.util.TreeSet;

public class MatriceUtilitaires {

	/**
	 * Calcule le déterminant d'une matrice carrée de N X N.
	 *
	 * ATTENTION ; Il existe plusieurs façons de calculer un déterminant, il
	 * faut faire de la recherche.
	 *
	 * Devrait être une méthode récursive...
	 *
	 * @param mat
	 *            la matrice carrée pour les calculs.
	 *
	 * @return le déterminant de la matrice.
	 */
	public static int getDeterminant(int[][] mat) {
		int temp = 0;
		int nbFois = mat.length - 2;
		if (nbFois != 0) {
			for (int i = 0; i < mat.length; i++) {
				int mult = (int) (mat[i][0] * Math.pow(-1, i));
				temp += mult * getDeterminant(getMatMineur(i, 0, mat));
			}
		} else {
			temp = (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]);
		}
		return temp;
	}

	/**
	 * Calcule le déterminant inverse du chiffre de Hill selon la force brute.
	 *
	 * @param valDet
	 *            déterminant de la matrice d'origine
	 * @param valMod
	 *            la valeur du modulo pour le calcul
	 *
	 * @return la valeur du déterminant inverse ou 0
	 */
	public static int getDeterminantInverseHill(int valDet, int valMod) {
		TreeSet<Integer> premiers = (TreeSet<Integer>) MathUtilitaires.xPremierEntreEux(1, valMod);
		boolean fini = false;
		Iterator<Integer> iter = premiers.iterator();
		int retour = 0;
		while (!fini && iter.hasNext()) {
			Integer temp = iter.next();
			if ((MathUtilitaires.modulo((temp * valDet), valMod)) == 1) {
				fini = true;
				retour = temp;
			}
		}
		return retour;
	}

	/**
	 * Retourne la matrice carrée des cofacteurs N X N d'une matrice carrée N X
	 * N reçue, utile pour déterminer la matrice adjointe.
	 *
	 * @param mat
	 *            la matrice d'origine
	 *
	 * @return la matrice carrée des cofacteurs de la matrice d'origine
	 */
	public static int[][] getMatCofacteurs(int[][] mat) {
		int[][] matTemp = new int[mat.length][mat.length];
		if (mat.length == 2) {
			matTemp[0][0] = mat[1][1];
			matTemp[1][1] = mat[0][0];
			matTemp[0][1] = mat[1][0] * -1;
			matTemp[1][0] = mat[0][1] * -1;
		} else {
			int mult = 0;
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat.length; j++) {
					mult = (int) Math.pow(-1, i + j);
					matTemp[i][j] = mult * getDeterminant(getMatMineur(i, j, mat));
				}
			}
		}
		return matTemp;
	}

	/**
	 * Retourne la matrice M X N transposée à partir d'une matrice N X M reçue.
	 *
	 * La matrice transposée d'une matrice est obtenue en échangeant les lignes
	 * et les colonnes.
	 *
	 * @param mat
	 *            la matrice d'origine
	 *
	 * @return la matrice carrée M X N transposée
	 */
	public static int[][] getMatTranspose(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int[][] transposee = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				transposee[j][i] = mat[i][j];
			}
		}
		return transposee;
	}

	/**
	 * Retourne la matrice N X N adjointe à partir d'une matrice N X N reçue.
	 *
	 * Est la matrice transposée des cofacteurs de la matrice d'origine.
	 *
	 * @param mat
	 *            la matrice d'origine
	 *
	 * @return la matrice carrée N X N adjointe
	 */
	public static int[][] getMatAdjointe(int[][] mat) {
		return getMatTranspose(getMatCofacteurs(mat));
	}

	/**
	 * Retourne la matrice carrée (N-1) X (N-1) mineure d'une matrice carrée N X
	 * N reçue.
	 *
	 * Est la matrice carrée résultante, lorsque l'on supprime toutes les
	 * valeurs de la ligne et de la colonne reçues, à partir la matrice
	 * d'origine reçue.
	 *
	 * @param ligne
	 *            la ligne de valeurs à supprimer
	 * @param col
	 *            la colonne de valeurs à supprimer
	 * @param mat
	 *            la matrice d'origine
	 *
	 * @return la matrice carrée (N-1) X (N-1) mineure résultante
	 *
	 */
	public static int[][] getMatMineur(int ligne, int col, int[][] mat) {
		int m = mat.length;
		int[][] mineur = new int[m - 1][m - 1];
		for (int i = 0; i < m; i++) {
			if (i != ligne) {
				if (i < ligne) {
					for (int j = 0; j < m; j++) {
						if (j != col) {
							if (j < col) {
								mineur[i][j] = mat[i][j]; // standard
							} else {
								mineur[i][j - 1] = mat[i][j]; // colonne sautée
							}
						}
					}
				} else {
					for (int j = 0; j < m; j++) {
						if (j != col) {
							if (j < col) {
								mineur[i - 1][j] = mat[i][j]; // ligne sautée
							} else {
								mineur[i - 1][j - 1] = mat[i][j]; // ligne+colonne
																	// sautées
							}
						}
					}
				}
			}
		}
		return mineur;
	}

	/**
	 * Retourne une matrice N X M résultante de la multiplication d'un scalaire
	 * reçu avec chaque membre d'une matrice N X M reçue
	 *
	 * @param mat
	 *            la matrice d'origine
	 * @param pScalaire
	 *            le scalaire
	 *
	 * @return la matrice résultante de la multiplication avec un scalaire
	 */
	public static int[][] getMatMultScalaire(int[][] mat, float pScalaire) {
		int m = mat.length;
		int n = mat[0].length;
		int[][] multipliee = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				multipliee[i][j] = Math.round(mat[i][j] * pScalaire);
			}
		}
		return multipliee;
	}

	/**
	 * Retourne une matrice N X M résultante de l'application d'un modulo reçu
	 * sur chaque membre d'une matrice N X M reçue
	 *
	 * @param mat
	 *            la matrice d'origine
	 * @param pMod
	 *            le modulo à appliquer
	 *
	 * @return la matrice résultante de l'application d'un modulo
	 */
	public static int[][] getMatModuloX(int[][] mat, int pMod) {
		int m = mat.length;
		int n = mat[0].length;
		int[][] modulee = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				modulee[i][j] = MathUtilitaires.modulo(mat[i][j], pMod);
			}
		}
		return modulee;
	}

	/**
	 * Permet de produire une chaîne de caractères pour l'affichage d'une
	 * matrice N X M dans la console. Très utile pour faire des tests.
	 *
	 * <pre>
	 *  Exemple d'affichage voulu:
	 *
	 *  [6, 1, -5]
	 *  [-2, -5, 4]
	 *  [-3, 3, -1]
	 * </pre>
	 *
	 * @param pMat
	 *            la matrice N X M à afficher
	 *
	 * @return la chaîne de caractères
	 */
	public static String toStringMat(int[][] pMat) {
		String s = "";
		for (int i = 0; i < pMat.length; i++) {
			s += "[";
			for (int j = 0; j < pMat[i].length; j++) {
				s += pMat[i][j] + ", ";
			}
			s += "]\n";
		}
		return s;
	}
}

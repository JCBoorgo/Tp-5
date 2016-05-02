package utilitaires;

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
	// TODO getDeterminant - MANDAT 2 - Compléter le code de la méthode
	public static int getDeterminant(int[][] mat) {
		return 0;
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
	// TODO getDeterminantInverseHill - MANDAT 2 - Compléter le code de la
	// méthode
	public static int getDeterminantInverseHill(int valDet, int valMod) {
		return 0;
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
	// TODO getMatCofacteurs - MANDAT 2 - Compléter le code de la méthode
	public static int[][] getMatCofacteurs(int[][] mat) {
		return null;
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
	// TODO getMatTranspose - Compléter le code de la méthode
	public static int[][] getMatTranspose(int[][] mat) {
		return null;
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
	// TODO getMatAdjointe - MANDAT 2 - Compléter le code de la méthode
	public static int[][] getMatAdjointe(int[][] mat) {
		return null;
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
	// TODO getMatMineur - Compléter le code de la méthode
	private static int[][] getMatMineur(int ligne, int col, int[][] mat) {
		return null;
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
	// TODO getMatMultScalaire - Compléter le code de la méthode
	public static int[][] getMatMultScalaire(int[][] mat, float pScalaire) {
		return null;
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
	// TODO getMatModuloX - Compléter le code de la méthode
	public static int[][] getMatModuloX(int[][] mat, int pMod) {
		return null;
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
	// TODO toStringMat - Compléter le code de la méthode
	public static String toStringMat(int[][] pMat) {
		return "";
	}
}

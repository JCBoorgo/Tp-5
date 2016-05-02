package structures;

public interface iMatrice {

	/**
	 * Permet de choisir une matrice au hasard parmi les matrices disponibles
	 * dans une liste de matrices candidates, comme matrice courante.
	 */
	public void choisirMatriceCourante();

	/**
	 * Choisir, selon l'index reçu, la matrice courante à partir d'une liste de
	 * matrices
	 *
	 * @param pIndex
	 *            l'index de la matrice voulue
	 */
	public void choisirMatriceCourante(int pIndex);

	/**
	 * Permet d'obtenir une copie de la matrice courante, pas le pointeur.
	 *
	 * @return une copie de la matrice courante ou null si pas de matrice
	 *         courante
	 */
	public int[][] getCopieMatriceCourante();

	/**
	 * Permet d'obtenir la matrice inverse pour le chiffre de Hill basé sur une
	 * copie de la matrice courante.
	 *
	 * @return Le pointeur sur la matrice inverse pour le chiffre de Hill ou
	 *         null si pas de matrice courante.
	 */
	public int[][] getMatriceCouranteInverseHill();

	/**
	 * Obtenir le nombre de matrices disponibles dans la liste de matrices.
	 *
	 * @return le nombre de matrices disponibles
	 */
	public int getNombreMatricesCandidates();
}

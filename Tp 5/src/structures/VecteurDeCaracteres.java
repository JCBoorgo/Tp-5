package structures;

import java.util.*;

import exceptions.ConstructeurException;

/**
 * Classe qui permet de produire une liste de caractères selon une constante ou
 * selon un tableau de caractères reçu.
 *
 * @author Jocelyn
 *
 */

public class VecteurDeCaracteres {

	private static final char[] TAB_CHAR = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '-' };

	private List<Character> tableCaracteres = null;

	/**
	 * Constructeur sans paramètre. Permet de remplir un tableau indexé de
	 * caractères avec les caractères de A à Z, l'espace et le "-". Met tous les
	 * caractères en majuscule.
	 *
	 * Utilise le constructeur avec paramètres
	 *
	 * @throws ArrayIndexOutOfBoundsException
	 */
	// TODO tests
	public VecteurDeCaracteres() throws ConstructeurException {
		this.tableCaracteres = new LinkedList<Character>();
		for (int i = 0; i < TAB_CHAR.length; i++) {
			this.tableCaracteres.add(TAB_CHAR[i]);
		}
	}

	/**
	 * Constructeur avec paramètre. Permet de remplir un tableau indexé de
	 * caractères à partir du tableau de "char" reçu. Met tous les caractères en
	 * majuscule.
	 */
	// TODO tests
	public VecteurDeCaracteres(char[] tabChar) throws ConstructeurException {
		this.tableCaracteres = new LinkedList<Character>();
		for (int i = 0; i < tabChar.length; i++) {
			this.tableCaracteres.add(tabChar[i]);
		}
	}

	/**
	 * Retourne le caractère selon l'index
	 *
	 * @param index
	 *            l'index du caractère
	 *
	 * @return le caractère selon l'index
	 *
	 * @throws ArrayIndexOutOfBoundsException
	 */
	// TODO tests
	public char getCaractere(int index) throws ArrayIndexOutOfBoundsException {
		return this.tableCaracteres.get(index);
	}

	/**
	 * Retourne l'indice du caractère reçu selon le vecteur de caractères
	 *
	 * @param car
	 *            le caractère à trouver
	 *
	 * @return l'indice du caractère ou -1 si le caractères n'est pas trouvé
	 */
	// TODO tests
	public int getIndice(char car) {
		return this.tableCaracteres.indexOf(car);
	}

	/**
	 * La taille du vecteur de caractères
	 *
	 * @return la taille
	 */
	// TODO tests
	public int getTaille() {
		return this.tableCaracteres.size();
	}

	/**
	 * Permet de construire une chaîne de caractère structurée pour afficher les
	 * infos d'un objet VecteurDeCaracteres
	 *
	 * <pre>
	 * Exemple de sortie voulue:
	 *
	 * TableDeCorrespondance = [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,  , -]
	 * </pre>
	 */
	// TODO tests
	// TODO y'a une erreur qui pop ici.
	@Override
	public String toString() {
		ListIterator temp = this.tableCaracteres.listIterator(0);
		String s = "";
		while (temp.hasNext()) {
			s += (String) temp.next();
			s += ", ";
		}
		return "Table de correspondance = " + "[" + s + "]";
	}
}

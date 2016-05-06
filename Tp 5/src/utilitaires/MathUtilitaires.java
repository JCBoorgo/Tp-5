package utilitaires;

import java.util.SortedSet;
import java.util.TreeSet;

public class MathUtilitaires {

	/**
	 * Calcule de la factorielle d'une valeur > ou = à 1. Pourrait être récursif
	 *
	 * @param valFact
	 *            la valeur
	 *
	 * @return la valeur de la factorielle pour la valeur reçue.
	 */
	// TODO tests
	public static double fact(int valFact) {
		double retour = 0;
		if (valFact == 1) {
			retour = 1;
		} else {
			retour = valFact * fact(valFact - 1);
		}
		return retour;
	}

	/**
	 * Retourne le modulo de valeurs positive ou négative reçue.
	 *
	 * Attention : Vérifier vos résultats surtout pour des valeurs négatives!!!
	 * la calculatrice de Goolge donne les bons résultats
	 *
	 * @param pVal
	 *            la valeur
	 * @param pMod
	 *            le modulo
	 *
	 * @return la valeur du modulo.
	 *
	 * @throws ArithmeticException
	 *             pour la division par zéro.
	 */
	// TODO tests
	public static int modulo(int pVal, int pMod) throws ArithmeticException {
		int temp = pVal;
		if (pMod == 0) {
			throw new ArithmeticException();
		} else {
			if (pVal > 0) {
				while (temp >= pMod) {
					temp -= pMod;
				}
			} else {
				while (temp < 0) {
					temp += pMod;
				}
			}
		}
		return temp;
	}

	/**
	 * Retourne un ensemble des diviseurs positifs distincts d'une valeur
	 * positive ou négative entière.
	 *
	 * @param pVal
	 *            , la valeur
	 *
	 * @return un ensemble de diviseurs positifs ou null si la valeur est 0
	 *         (infinité de valeurs).
	 */
	// TODO tests
	public static SortedSet<Integer> diviseursDe(int pVal) {
		int nombre = Math.abs(pVal);
		int limite = (int) Math.floor(Math.sqrt(pVal));
		TreeSet<Integer> liste = new TreeSet<Integer>();
		if (nombre != 0) {
			for (int i = 1; i <= limite; i++) {
				if (nombre % i == 0) {
					liste.add(new Integer(i));
					liste.add(new Integer(nombre / i));
				}
			}
		} else {
			liste = null;
		}
		return liste;
	}

	/**
	 * Retourne vrai si la valeur reçue est un nombre premier.
	 *
	 * Un nombre premier est plus grand que 1 et admet exactement deux diviseurs
	 * distincts entiers et positifs qui sont alors 1 et lui-même.
	 *
	 * @param pVal
	 *            , la valeur
	 *
	 * @return vrai si la valeur reçue est un nombre premier, faux sinon
	 */
	// TODO tests
	public static boolean estPremier(int pVal) {
		SortedSet<Integer> diviseurs = diviseursDe(pVal);
		return (diviseurs.size() == 2);
	}

	/**
	 * Retourne un ensemble des X nombres premiers entre 1 et la valeur reçue.
	 *
	 * @param pVal
	 *            la valeur
	 *
	 * @return un ensemble des X nombres premiers ou null si aucun nombre
	 *         premier trouvé.
	 */
	// TODO tests
	public static SortedSet<Integer> xPremier(int pVal) {
		TreeSet<Integer> liste = new TreeSet<Integer>();
		for (int i = 1; i <= pVal; i++) {
			if (estPremier(i)) {
				liste.add(new Integer(i));
			}
		}
		return liste;
	}

	/**
	 * Retourne l'ensemble des nombres qui sont "premier entre eux" avec la
	 * valeur valRef reçue. La valeur valDepart reçue étant la valeur de départ
	 * de la recherche de ces nombres.
	 *
	 * En mathématiques, on dit que des entiers a et b sont premiers entre eux,
	 * si leur plus grand commun diviseur est égal à 1 ; en d'autres termes,
	 * s'ils n'ont aucun diviseur autre que 1 et –1 en commun. De manière
	 * équivalente, ils sont premiers entre eux si, et seulement si, ils n'ont
	 * aucun facteur premier en commun.
	 *
	 * Exemple : l'ensemble des nombres qui sont "premier entre eux" avec 26 en
	 * partant de 1 est {1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25}
	 *
	 * @param valDepart
	 *            la valeur de départ. Avant de chercher les "premier entre eux"
	 *            , si valDepart est négative, la mettre à 1.
	 * @param valRef
	 *            la valeur de référence.
	 *
	 * @return un ensemble des X nombres "premiers entres eux" avec valRef à
	 *         partir de valDepart reçue ou null.
	 */
	// TODO tests
	public static SortedSet<Integer> xPremierEntreEux(int valDepart, int valRef) {
		int debut = valDepart;
		if (valDepart < 0) {
			debut = 1;
		}
		SortedSet<Integer> diviseurs = diviseursDe(valRef);
		SortedSet<Integer> premiers = new TreeSet<Integer>();
		if (valDepart <= 1) {
			premiers.add(new Integer(1));
		}
		for (int i = debut; i < valRef; i++) {
			if (!diviseurs.contains(new Integer(i))) {
				premiers.add(new Integer(i));
			}
		}

		return (premiers.size() == 0) ? null : premiers;
	}

	/**
	 * Retourne le Plus Grand Commun Diviseur entre deux nombres
	 *
	 * Il est possible d'utiliser la division euclidienne récursive pour trouver
	 * le PGCD (Plus Grand Commun Diviseur)
	 *
	 * @param pVal1
	 *            une valeur
	 * @param pVal2
	 *            une autre valeur
	 *
	 * @return le PGCD ou 0
	 */
	// TODO tests
	public static int PGCD(int pVal1, int pVal2) {
		SortedSet<Integer> diviseurs1 = diviseursDe(pVal1);
		SortedSet<Integer> diviseurs2 = diviseursDe(pVal2);
		int compteur = (pVal1 < pVal2) ? pVal1 : pVal2;
		int nombre = 1;
		boolean fin = false;
		while (!fin) {
			if ((diviseurs1.contains(new Integer(compteur)) && diviseurs2.contains(new Integer(compteur)))) {
				nombre = compteur;
				fin = true;
			} else if (compteur == 1) {
				fin = true;
			}
		}
		return nombre;
	}

	/**
	 * Retourne aléatoirement une valeur entière entre 2 valeurs reçues. Inverse
	 * le min et le max s'ils ne sont pas correctes.
	 *
	 * @param pMin
	 *            une valeur
	 * @param pMax
	 *            une autre valeur
	 *
	 * @return la valeur générée aléatoirement.
	 */
	// TODO tests
	public static int alea(int pMin, int pMax) {
		int nombre = 0;
		if (pMin < pMax) {
			nombre = (int) Math.floor(Math.random() * (pMax - pMin + 1) + pMin);
		} else {
			nombre = (int) Math.floor(Math.random() * (pMin - pMax + 1) + pMax);
		}
		return nombre;
	}

	/**
	 * Calcule le nombre de combinaisons différentes possibles si l'on choisi un
	 * nombre d'éléments dans un ensemble sans remise, sans tenir compte de
	 * l'ordre et sans répétition.
	 *
	 * Voir "Wikipédia"
	 *
	 * @param nbrElement
	 *            le nombre d'élément dans l'ensemble
	 * @param nbrElementPris
	 *            longueur des combinaisons ou le nombre d'éléments pris pour
	 *            chaque combinaison.
	 *
	 * @return le nombre de combinaison possible.
	 */
	//TODO tests...?
	public static int nbrCombinaison(int nbrElement, int nbrElementPris) {
		return (int) ((MathUtilitaires.fact(nbrElement) / MathUtilitaires.fact(nbrElement - nbrElementPris))
				/ MathUtilitaires.fact(nbrElementPris));
	}
}

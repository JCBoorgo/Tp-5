package structures;

import java.util.SortedSet;
import java.util.StringTokenizer;

import exceptions.ConstructeurException;
import utilitaires.MathUtilitaires;
import utilitaires.MatriceUtilitaires;

public class MessageChiffrerDechiffrer implements iCrypto {
	public static final float POURCENTAGE_ACCEPTABLE = 0.7f;
	public static final char CAR_DE_COMPLEMENT = ' ';

	private VecteurDeCaracteres vecCaracteres = null;
	private ListeMatricesChiffrement listeMatricesCandidates = null;
	private SortedSet<String> dico = null;

	/**
	 * Constructeur, permet d'affecter les différents attributs à partir des
	 * objets reçus en entrée. Avant d'affecter les attributs de la classe avec
	 * les objets reçus en entrée, il faut valider ces derniers (<> null et pas
	 * vide).
	 *
	 * @param vecCars
	 *            la tables de caractères pour la correspondance lors de
	 *            l'encodage et du décodage.
	 * @param listeMats
	 *            liste des matrices candidates.
	 * @param dico
	 *            liste des mots pour la validation lors du décodage.
	 *
	 * @throws ConstructeurException
	 */
	public MessageChiffrerDechiffrer(VecteurDeCaracteres vecCars, ListeMatricesChiffrement listeMats,
			SortedSet<String> dico) throws ConstructeurException {
		if (validerDico(dico) && validerMatsEncodage(listeMats) && validerVecCaracteres(vecCars)) {
			setDico(dico);
			setMatsEncodage(listeMats);
			setVecCaracteres(vecCars);
		} else {
			throw new ConstructeurException();
		}
	}

	private void setVecCaracteres(VecteurDeCaracteres pVec) {
		if (validerVecCaracteres(pVec)) {
			this.vecCaracteres = pVec;
		}
	}

	private void setMatsEncodage(ListeMatricesChiffrement listeMats) {
		if (validerMatsEncodage(listeMats)) {
			this.listeMatricesCandidates = listeMats;
		}
	}

	private void setDico(SortedSet<String> dico) {
		if (validerDico(dico)) {
			this.dico = dico;
		}
	}

	private static boolean validerVecCaracteres(VecteurDeCaracteres pVec) {
		return ((pVec != null) && (pVec.getTaille() > 0));
	}

	private static boolean validerMatsEncodage(ListeMatricesChiffrement listeMats) {
		return ((listeMats != null) && (listeMats.getNombreMatricesCandidates() > 0));
	}

	private static boolean validerDico(SortedSet<String> dico) {
		return ((dico != null) && !dico.isEmpty());
	}

	/**
	 * Obtenir la matrice courante qui a été utilisé par l'encodage ou le
	 * décodage. Très utile pour les tests.
	 *
	 * @return la matrice courante utilisée à partir de l'objet
	 *         "listeMatricesCandidates".
	 */
	public int[][] getMatriceCourante() {
		return listeMatricesCandidates.getCopieMatriceCourante();
	}

	@Override
	public boolean validerMessageSelonDico(String message, float pourcentageDeReussite) {
		String[] mots = message.trim().split("\\s");
		int nbCaracteres = 0;
		int caracteresEgaux = 0;
		for (int i = 0; i < mots.length; i++) {
			nbCaracteres += mots[i].length();
			if (dico.contains(mots[i].toLowerCase())) {
				caracteresEgaux += mots[i].length();
			}
		}
		float pourcentage = caracteresEgaux / nbCaracteres;
		return pourcentage > pourcentageDeReussite;
	}

	@Override
	public String ajusterMessageBrute(String message, int longVoulue) {
		String s = message;
		while (s.length() < longVoulue) {
			s += CAR_DE_COMPLEMENT;
		}
		return s;
	}

	public String codeDecode(String message, int[][] matrice) {
		int dimension = listeMatricesCandidates.getDimension();
		String texteModifie = "";
		String boutDeTexte = "";
		// ajuster la taille du message
		int tailleMessage = message.length() + (dimension - (MathUtilitaires.modulo(message.length(), dimension)));
		String messageAjuste = null;
		if (tailleMessage != (message.length() + dimension)) {
			messageAjuste = ajusterMessageBrute(message, tailleMessage);
		} else {
			messageAjuste = message;
			tailleMessage -= dimension;
		}
		// Nombre de fois qu'on va multiplier
		int nbPaquetsDeLettre = tailleMessage / dimension;
		// On commence le traitement
		for (int i = 0; i < nbPaquetsDeLettre; i++) {
			// Bout à traiter
			boutDeTexte = messageAjuste.substring(i * dimension, (i + 1) * dimension);
			// Tableau contenant les index de lettres à traiter
			int[] tabValLettres = new int[dimension];
			for (int j = 0; j < dimension; j++) {
				tabValLettres[j] = vecCaracteres.getIndice(boutDeTexte.charAt(j));
			}
			// Tableau avec nouvelles valeurs de lettres
			int[] tabLettresModifiees = new int[dimension];
			// Multiplier le stuff
			for (int j = 0; j < dimension; j++) {
				for (int k = 0; k < dimension; k++) {
					tabLettresModifiees[j] += matrice[j][k] * tabValLettres[k];
				}
			}
			// Faire les modulo
			for (int j = 0; j < dimension; j++) {
				tabLettresModifiees[j] = MathUtilitaires.modulo(tabLettresModifiees[j], vecCaracteres.getTaille());
			}
			// Convertir indices en lettres
			char[] tabLettresFinales = new char[dimension];
			for (int j = 0; j < dimension; j++) {
				tabLettresFinales[j] = vecCaracteres.getCaractere(tabLettresModifiees[j]);
			}
			// Ajouter les lettres à la string du message
			for (int j = 0; j < dimension; j++) {
				texteModifie += tabLettresFinales[j];
			}
		}
		return texteModifie;
	}

	@Override
	public String encoder(String message) {
		// Setter la matrice courante
		String s = codeDecode(message, getMatriceCourante());
		return s;
	}

	@Override
	public String decoder(String message) {
		// Setter la matrice inverse de Hill
		int[][] matrice = listeMatricesCandidates.getMatriceCouranteInverseHill();
		String s = codeDecode(message, matrice);
		s = s.trim();
		return s;
	}
}

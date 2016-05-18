package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.SortedSet;

import org.junit.Before;
import org.junit.Test;

import exceptions.ConstructeurException;
import structures.ListeMatricesChiffrement;
import structures.MessageChiffrerDechiffrer;
import structures.VecteurDeCaracteres;
import utilitaires.FichierUtilitaires;

public class MessageChiffrerDechiffrerTest {
	SortedSet<String> dico = FichierUtilitaires.lireDictionnaire(new File("dictionnaire.txt"));
	VecteurDeCaracteres vecCaracteres = new VecteurDeCaracteres();
	MessageChiffrerDechiffrer m1;

	@Before
	public void setUp() throws Exception {
		m1 = new MessageChiffrerDechiffrer(vecCaracteres, new ListeMatricesChiffrement(1, 20, 2, 28), dico);
	}

	@Test
	public void testMessageChiffrerDechiffrer() {
		try {
			MessageChiffrerDechiffrer t1 = new MessageChiffrerDechiffrer(null,
					new ListeMatricesChiffrement(1, 20, 2, 28), dico);
			fail();
		} catch (ConstructeurException e) {

		}
		try {
			MessageChiffrerDechiffrer t2 = new MessageChiffrerDechiffrer(vecCaracteres,
					new ListeMatricesChiffrement(1, 20, 2, 28), null);
			fail();
		} catch (ConstructeurException e) {

		}
		try {
			MessageChiffrerDechiffrer t3 = new MessageChiffrerDechiffrer(vecCaracteres,
					new ListeMatricesChiffrement(-1, 20, 2, 28), dico);
			fail();
		} catch (ConstructeurException e) {

		}
	}

	@Test
	public void testValiderMessageSelonDico() {
		// Vrais mots
		assertTrue(m1.validerMessageSelonDico("Salut ce message devrait fonctionner", 0.99f));
		// CLAIREMENT pas des vrais mots
		assertFalse(m1.validerMessageSelonDico("lkasjd porjdn skjyajhbqmn rd", 0.01f));
	}

	@Test
	public void testAjusterMessageBrute() {
		String s1 = m1.ajusterMessageBrute("le chat", 13);
		assertTrue(s1.length() == 13);
		String s2 = m1.ajusterMessageBrute("un message pour tester", 42);
		assertTrue(s2.length() == 42);
	}

	@Test
	public void testEncoder() {
		// Des system.out de messages
		System.out.println(m1.encoder("check le message"));
		System.out.println(m1.encoder("un autre brillant texte"));
		System.out.println(m1.encoder("un dernier pour valider"));
	}

	@Test
	public void testDecoder() {
		String s1 = "check le message";
		String s2 = m1.decoder(m1.encoder(s1));
		assertTrue(s1.toUpperCase().equals(s2));
		String s3 = "juste pour tester la machine et les choses";
		String s4 = m1.decoder(m1.encoder(s3));
		assertTrue(s3.toUpperCase().equals(s4));
	}

}

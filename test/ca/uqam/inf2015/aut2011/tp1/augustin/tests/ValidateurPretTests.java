/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqam.inf2015.aut2011.tp1.augustin.tests;

import ca.uqam.inf2015.aut2011.tp1.augustin.Pret;
import ca.uqam.inf2015.aut2011.tp1.augustin.RemboursementPretAvecErreur;
import ca.uqam.inf2015.aut2011.tp1.augustin.ValidateurPret;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Developer
 */
public class ValidateurPretTests {

    /**
     * 
     */
    public ValidateurPretTests() {
    }

    /**
     * 
     * @throws Exception
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    /**
     * 
     * @throws Exception
     */
    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * 
     */
    @Before
    public void setUp() {
    }

    /**
     * 
     */
    @After
    public void tearDown() {
    }

    /**
     * 
     */
    @Test
    public void estValideRetourneFauxAvecUnPretNull() {
        ValidateurPret validateur = new ValidateurPret(null);

        assertEquals(false, validateur.estValide());
        assertEquals("La demande de prêt est null.", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }

    /**
     * 
     */
    @Test
    public void estValideRetourneVraiAvecUnPretValideEtAucunErreur() {
        Pret pretValide = creerPretValide();
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(true, validateur.estValide());
        assertEquals("", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }

    /**
     * 
     */
    @Test
    public void estValideRetourneFauxAvecUnTauxInteretInferieurAZero() {
        Pret pretValide = creerPretValide();
        pretValide.tauxInteret = -1;
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(false, validateur.estValide());
        assertEquals("Taux d'intérêt inférieur à zéro.", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }

    /**
     * 
     */
    @Test
    public void estValideRetourneVraiAvecUnTauxInteretAZero() {
        Pret pretValide = creerPretValide();
        pretValide.tauxInteret = 0;
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(true, validateur.estValide());
        assertEquals("", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }

    /**
     * 
     */
    @Test
    public void estValideRetourneVraiAvecUnTauxInteretSuperieurAZero() {
        Pret pretValide = creerPretValide();
        pretValide.tauxInteret = 1;
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(true, validateur.estValide());
        assertEquals("", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }

    //Tests pour montant
    
    
    /**
     * 
     */
    @Test
    public void estValideRetourneFauxAvecMontantInferieurAZero() {
        Pret pretValide = creerPretValide();
        pretValide.montant = -1;
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(false, validateur.estValide());
        assertEquals("Le montant est inférieur à zéro.", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }

    /**
     * 
     */
    @Test
    public void estValideRetourneVraiAvecMontantAZero() {
        Pret pretValide = creerPretValide();
        pretValide.montant = 0;
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(true, validateur.estValide());
        assertEquals("", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }

    /**
     * 
     */
    @Test
    public void estValideRetourneVraiAvecMontantSuperieurAZero() {
        Pret pretValide = creerPretValide();
        pretValide.montant = 1;
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(true, validateur.estValide());
        assertEquals("", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }
    
     //Test pour nombre d'années
    
    
    /**
     * 
     */
    @Test
    public void estValideRetourneFauxAvecUnNombreAnneeInferieurAUn() {
        Pret pretValide = creerPretValide();
        pretValide.nombreAnnee = 0;
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(false, validateur.estValide());
        assertEquals("Le nombre d'année est inférieur à un.", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }

    /**
     * 
     */
    @Test
    public void estValideRetourneVraiAvecUnNombreAnneesAUn() {
        Pret pretValide = creerPretValide();
        pretValide.nombreAnnee = 1;
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(true, validateur.estValide());
        assertEquals("", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }

    /**
     * 
     */
    @Test
    public void estValideRetourneVraiAvecUnNombreAnneesSuperieurAUn() {
        Pret pretValide = creerPretValide();
        pretValide.nombreAnnee = 2;
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(true, validateur.estValide());
        assertEquals("", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }
    
     //Test pour Frequence paiement
    
    
    /**
     * 
     */
    @Test
    public void estValideRetourneFauxAvecFreqRemboursementInferieurAUn() {
        Pret pretValide = creerPretValide();
        pretValide.frequenceRemboursement = 0;
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(false, validateur.estValide());
        assertEquals("La fréquence de remboursement est inférieur à un.", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }

    /**
     * 
     */
    @Test
    public void estValideRetourneVraiAvecFreqPaiementAUn() {
        Pret pretValide = creerPretValide();
        pretValide.frequenceRemboursement = 1;
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(true, validateur.estValide());
        assertEquals("", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }

    /**
     * 
     */
    @Test
    public void estValideRetourneVraiAvecFreqPaiementSuperieurAUn() {
        Pret pretValide = creerPretValide();
        pretValide.frequenceRemboursement = 2;
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(true, validateur.estValide());
        assertEquals("", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }
    
     //Faire pour frequence de composition
    
    
    /**
     * 
     */
    @Test
    public void estValideRetourneFauxAvecFreqCompositionInferieurAUn() {
        Pret pretValide = creerPretValide();
        pretValide.frequenceComposition = 0;
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(false, validateur.estValide());
        assertEquals("La fréquence de composition est inférieur à un.", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }

    /**
     * 
     */
    @Test
    public void estValideRetourneVraiAvecFreqCompositionAUn() {
        Pret pretValide = creerPretValide();
        pretValide.frequenceComposition = 1;
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(true, validateur.estValide());
        assertEquals("", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }

    /**
     * 
     */
    @Test
    public void estValideRetourneVraiAvecFreqCompositionSuperieurAUn() {
        Pret pretValide = creerPretValide();
        pretValide.tauxInteret = 2;
        ValidateurPret validateur = new ValidateurPret(pretValide);

        assertEquals(true, validateur.estValide());
        assertEquals("", obtenirErreursDeValidation(validateur.produireRemboursementPretAvecErreurs()));
    }   
    
    
    private String obtenirErreursDeValidation(RemboursementPretAvecErreur remboursementEnErreur) {
        return remboursementEnErreur.erreursDeValidation;
    }

    private Pret creerPretValide() {
        Pret pretValide = new Pret();
        pretValide.id = "Test 1";
        pretValide.description = "Premier Test";
        pretValide.montant = 100000;
        pretValide.nombreAnnee = 25;
        pretValide.frequenceRemboursement = 12;
        pretValide.tauxInteret = 6;
        pretValide.frequenceComposition = 2;
        return pretValide;
    }
}

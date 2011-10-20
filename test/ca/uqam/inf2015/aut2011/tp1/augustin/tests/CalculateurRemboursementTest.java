/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqam.inf2015.aut2011.tp1.augustin.tests;

import ca.uqam.inf2015.aut2011.tp1.augustin.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Myriam Allard
 */
public class CalculateurRemboursementTest {

    /**
     * 
     */
    public CalculateurRemboursementTest() {
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
     * @param liste
     * @return
     */
    public Amortissement obtenirDernierAmortissement(ArrayList<Amortissement> liste) {
        return liste.get(liste.size() - 1);
    }

    /**
     * 
     */
    @Test
    public void calculerRemboursementCommeDansExemple() {
        Pret demandeDePret = new Pret();
        demandeDePret.id = "Test 1";
        demandeDePret.description = "Premier test";
        demandeDePret.montant = 100000;
        demandeDePret.nombreAnnee = 25;
        demandeDePret.frequenceRemboursement = 12;
        demandeDePret.tauxInteret = 6;
        demandeDePret.frequenceComposition = 2;

        CalculateurDemandeHypothecaire calculateur = new CalculateurRemboursement();
        RemboursementPret remboursement = calculateur.produireRemboursement(demandeDePret);

        Amortissement testDernierAmort = obtenirDernierAmortissement(remboursement.amortissement);

        assertEquals(300, testDernierAmort.periode, 0);
        assertEquals(0, testDernierAmort.capitalFin, 0);
        assertEquals(demandeDePret.montant, testDernierAmort.versementCapitalCumulatif, 0);

        Amortissement TestPremiAmor = remboursement.amortissement.get(0);
        assertEquals(1, TestPremiAmor.periode, 0);
        assertEquals(100000, TestPremiAmor.capitalDebut, 0);
        assertEquals(639.81, TestPremiAmor.versementTotal, 0);
        assertEquals(493.86, TestPremiAmor.versementInteret, 0);
        assertEquals(145.95, TestPremiAmor.versementCapital, 0);
        assertEquals(99854.05, TestPremiAmor.capitalFin, 0);
        assertEquals(639.81, TestPremiAmor.versementTotalCumulatif, 0);
        assertEquals(493.86, TestPremiAmor.versementInteretCumulatif, 0);
        assertEquals(145.95, TestPremiAmor.versementCapitalCumulatif, 0);
    }

    /**
     * 
     */
    @Test
    public void calculerRemboursementSansInteret() {
        Pret demandeDePret = new Pret();
        demandeDePret.id = "Test 2";
        demandeDePret.description = "Test Interet a 0";
        demandeDePret.montant = 300000;
        demandeDePret.nombreAnnee = 10;
        demandeDePret.frequenceRemboursement = 6;
        demandeDePret.tauxInteret = 0;
        demandeDePret.frequenceComposition = 1;

        CalculateurDemandeHypothecaire calculateur = new CalculateurRemboursement();
        RemboursementPret remboursement = calculateur.produireRemboursement(demandeDePret);

        Amortissement testDernierAmort = obtenirDernierAmortissement(remboursement.amortissement);

        assertEquals(60, testDernierAmort.periode, 0);
        assertEquals(0, testDernierAmort.capitalFin, 0);
        assertEquals(5000, testDernierAmort.capitalDebut, 0);
        assertEquals(5000, testDernierAmort.versementTotal, 0);
        assertEquals(0, testDernierAmort.versementInteret, 0);
        assertEquals(5000, testDernierAmort.versementCapital, 0);
        assertEquals(0, testDernierAmort.capitalFin, 0);
        assertEquals(300000, testDernierAmort.versementTotalCumulatif, 0);
        assertEquals(0, testDernierAmort.versementInteretCumulatif, 0);
        assertEquals(300000, testDernierAmort.versementCapitalCumulatif, 0);

        Amortissement TestPremiAmor = remboursement.amortissement.get(0);
        assertEquals(1, TestPremiAmor.periode, 0);
        assertEquals(300000, TestPremiAmor.capitalDebut, 0);
        assertEquals(5000, TestPremiAmor.versementTotal, 0);
        assertEquals(0, TestPremiAmor.versementInteret, 0);
        assertEquals(5000, TestPremiAmor.versementCapital, 0);
        assertEquals(295000, TestPremiAmor.capitalFin, 0);
        assertEquals(5000, TestPremiAmor.versementTotalCumulatif, 0);
        assertEquals(0, TestPremiAmor.versementInteretCumulatif, 0);
        assertEquals(5000, TestPremiAmor.versementCapitalCumulatif, 0);
    }

    /**
     * 
     */
    @Test
    public void calculerRemboursementMontantPretAZero() {
        Pret demandeDePret = new Pret();
        demandeDePret.id = "Test 3";
        demandeDePret.description = "Test montant a 0";
        demandeDePret.montant = 0;
        demandeDePret.nombreAnnee = 5;
        demandeDePret.frequenceRemboursement = 2;
        demandeDePret.tauxInteret = 0;
        demandeDePret.frequenceComposition = 3;

        CalculateurDemandeHypothecaire calculateur = new CalculateurRemboursement();
        RemboursementPret remboursement = calculateur.produireRemboursement(demandeDePret);

        Amortissement testDernierAmort = obtenirDernierAmortissement(remboursement.amortissement);

        assertEquals(10, testDernierAmort.periode, 0);
        assertEquals(0, testDernierAmort.capitalFin, 0);
        assertEquals(0, testDernierAmort.capitalDebut, 0);
        assertEquals(0, testDernierAmort.versementTotal, 0);
        assertEquals(0, testDernierAmort.versementInteret, 0);
        assertEquals(0, testDernierAmort.versementCapital, 0);
        assertEquals(0, testDernierAmort.capitalFin, 0);
        assertEquals(0, testDernierAmort.versementTotalCumulatif, 0);
        assertEquals(0, testDernierAmort.versementInteretCumulatif, 0);
        assertEquals(0, testDernierAmort.versementCapitalCumulatif, 0);

        Amortissement TestPremiAmor = remboursement.amortissement.get(0);
        assertEquals(1, TestPremiAmor.periode, 0);
        assertEquals(0, TestPremiAmor.capitalDebut, 0);
        assertEquals(0, TestPremiAmor.versementTotal, 0);
        assertEquals(0, TestPremiAmor.versementInteret, 0);
        assertEquals(0, TestPremiAmor.versementCapital, 0);
        assertEquals(0, TestPremiAmor.capitalFin, 0);
        assertEquals(0, TestPremiAmor.versementTotalCumulatif, 0);
        assertEquals(0, TestPremiAmor.versementInteretCumulatif, 0);
        assertEquals(0, TestPremiAmor.versementCapitalCumulatif, 0);
    }
}


package ca.uqam.inf2015.aut2011.tp1.augustin;

import java.io.File;


/**
 * La classe main du logiciel 
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public class Main {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        if (!parametresEntrantSontValides(args)) {
            afficherUsageAttenduDesParametres();
            return;
        }
        try {
            DepotDemandesDePret depotSource = construireDepotDemandeDePret(args[0]);
            DepotResultatsDemandesDePret depotDestination = construireDepotResultatsDemandeDePret(args[1]);

            GestionnaireHypothecaire gestionnaire = new GestionnaireHypothecaire(depotSource, depotDestination, new CalculateurRemboursement());
            gestionnaire.traiterDemandesDePrets();
        } catch (IllegalArgumentException iae) {
            afficherErreurEtUsage(iae);
        } catch (SecurityException se) {
            afficherErreurEtUsage(se);
        }
    }

    private static void afficherErreurEtUsage(Exception iae) {
        afficherUsageAttenduDesParametres();
        System.out.println(iae.getLocalizedMessage());
    }

    private static DepotPretDepuisFichiers construireDepotDemandeDePret(String repertoireSource) {
        return new DepotPretDepuisFichiers(new ConvertisseurFichierJsonVersPret(), repertoireSource);
    }

    private static DepotResultatsDemandesDePret construireDepotResultatsDemandeDePret(String repertoireDestination) {
        return new DepotResultatsDemandesVersFichiers(new ConvertisseurRemboursementPretVersJson(), repertoireDestination);
    }

    private static boolean parametresEntrantSontValides(String[] args) {
        return !nombreDeParametresEstNullOuDifferentDeDeux(args);
    }

    private static boolean nombreDeParametresEstNullOuDifferentDeDeux(String[] args) {
        return args == null || args.length != 2;
    }

    private static void afficherUsageAttenduDesParametres() {
        System.out.println("USAGE: RepertoireSource RepertoireDestination");
    }
}

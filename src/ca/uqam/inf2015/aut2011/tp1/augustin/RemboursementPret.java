
package ca.uqam.inf2015.aut2011.tp1.augustin;

import java.util.ArrayList;


/**
 *
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public class RemboursementPret extends Pret {

    /**
     * 
     */
    public double versementPeriodique;
    /**
     * 
     */
    public ArrayList<Amortissement> amortissement;

    /**
     * 
     * @param demande
     */
    public RemboursementPret(Pret demande) {
        assignerValeursSiDemandeEstNonNull(demande);
        amortissement = new ArrayList<Amortissement>();
    }

    private void assignerValeursSiDemandeEstNonNull(Pret demande) {
        if (demande != null) {
            super.id = demande.id;
            super.description = demande.description;
            super.frequenceComposition = demande.frequenceComposition;
            super.frequenceRemboursement = demande.frequenceRemboursement;
            super.montant = demande.montant;
            super.nombreAnnee = demande.nombreAnnee;
            super.tauxInteret = demande.tauxInteret;
        }
    }
}

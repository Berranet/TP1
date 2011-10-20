
package ca.uqam.inf2015.aut2011.tp1.augustin;


/**
 * Cette interface est pour le calcule de la demande hypothecaire
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public interface CalculateurDemandeHypothecaire {
    /**
     * 
     * @param pret
     * @return
     */
    RemboursementPret produireRemboursement(Pret pret);
}

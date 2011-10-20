
package ca.uqam.inf2015.aut2011.tp1.augustin;


/**
 *
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public interface DepotResultatsDemandesDePret {
    /**
     * 
     * @param identifiant
     * @param remboursement
     */
    void Sauvegarder(String identifiant, RemboursementPret remboursement);
}

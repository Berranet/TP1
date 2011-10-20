
package ca.uqam.inf2015.aut2011.tp1.augustin;


/**
 *
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public class RemboursementPretAvecErreur extends RemboursementPret {

    /**
     * 
     */
    public String erreursDeValidation;

    /**
     * 
     * @param remboursement
     * @param erreursDeValidation
     */
    public RemboursementPretAvecErreur(Pret remboursement, String erreursDeValidation) {
        super(remboursement);
        this.erreursDeValidation = erreursDeValidationSiNonNullAutrementChaineVide(erreursDeValidation);
    }

    private String erreursDeValidationSiNonNullAutrementChaineVide(String erreursDeValidation) {
        return erreursDeValidation != null ? erreursDeValidation : "";
    }
}

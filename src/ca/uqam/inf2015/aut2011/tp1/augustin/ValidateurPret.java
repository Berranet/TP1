
package ca.uqam.inf2015.aut2011.tp1.augustin;


/**
 *
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public class ValidateurPret {

    Pret demandeCourante;
    String erreursDeValidation;
    boolean estValide;

    /**
     * 
     * @param demandeAValider
     */
    public ValidateurPret(Pret demandeAValider) {
        demandeCourante = demandeAValider;
        erreursDeValidation = "";
    }

    /**
     * 
     * @return
     */
    public boolean estValide() {
        validerSiPretEstNull();
        if (estValide) {
            validerMontantEstInferieurAZero();
            validerAnneeEstInferieurAUn();
            validerSiTauxInteretEstInferieurAZero();
            validerFrequenceRemboursementEstInferieurAUn();
            validerFrequenceCompositionEstInferieurAUn();           
        }

        return estValide;
    }

    /**
     * 
     * @return
     */
    public RemboursementPretAvecErreur produireRemboursementPretAvecErreurs() {
        return new RemboursementPretAvecErreur(demandeCourante, erreursDeValidation);
    }

    private void validerSiPretEstNull() {
        if (demandeCourante != null) {
            estValide = true;
        } else {
            erreursDeValidation += "La demande de prêt est null.";
            estValide = false;
        }
    }
    
    private void validerSiTauxInteretEstInferieurAZero()            
    {
        if (demandeCourante.tauxInteret < 0)
        {
            estValide = false;
            erreursDeValidation += "Taux d'intérêt inférieur à zéro.";
        }
    }
    
    private void validerMontantEstInferieurAZero()            
    {
        if (demandeCourante.montant < 0)
        {
            estValide = false;
            erreursDeValidation += "Le montant est inférieur à zéro.";
        }
    }
    
    private void validerAnneeEstInferieurAUn()            
    {
        if (demandeCourante.nombreAnnee < 1)
        {
            estValide = false;
            erreursDeValidation += "Le nombre d'année est inférieur à un.";
        }
    }
    private void validerFrequenceRemboursementEstInferieurAUn()            
    {
        if (demandeCourante.frequenceRemboursement < 1)
        {
            estValide = false;
            erreursDeValidation += "La fréquence de remboursement est inférieur à un.";
        }
    }
    private void validerFrequenceCompositionEstInferieurAUn()            
    {
        if (demandeCourante.frequenceComposition < 1)
        {
            estValide = false;
            erreursDeValidation += "La fréquence de composition est inférieur à un.";
        }
    }
}

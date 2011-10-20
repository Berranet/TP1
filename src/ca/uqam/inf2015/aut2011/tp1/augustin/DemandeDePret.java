
package ca.uqam.inf2015.aut2011.tp1.augustin;


/**
 * Cette classe est pour la demande de prêt. Elle possède deux paramètres 
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public class DemandeDePret {

    private String identifiantDeLaSource;
    private Pret demandeDePret;

    /**
     * 
     * @param sourceDeLaDemande
     * @param pret
     */
    public DemandeDePret(String sourceDeLaDemande, Pret pret) {
        identifiantDeLaSource = sourceDeLaDemande;
        demandeDePret = pret;
    }

    /**
     * @return L'identifiant de la demande à la source.
     */
    public String getIdentifiant() {
        return identifiantDeLaSource;
    }

    /**
     * @return La demande de prêt.
     */
    public Pret getPret() {
        return demandeDePret;
    }
}


package ca.uqam.inf2015.aut2011.tp1.augustin;

import java.util.ArrayList;


/**
 *
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public class GestionnaireHypothecaire {

    DepotDemandesDePret depotDesDemandes;
    DepotResultatsDemandesDePret depotDesResultats;
    CalculateurDemandeHypothecaire calculateur;

    /**
     * 
     * @param depotDemandes
     * @param depotResultats
     * @param calculateurDeDemande
     */
    public GestionnaireHypothecaire(DepotDemandesDePret depotDemandes, DepotResultatsDemandesDePret depotResultats, CalculateurDemandeHypothecaire calculateurDeDemande) {
        depotDesDemandes = depotDemandes;
        depotDesResultats = depotResultats;
        calculateur = calculateurDeDemande;
    }

    /**
     * 
     */
    public void traiterDemandesDePrets() {
        ArrayList<DemandeDePret> demandes = depotDesDemandes.ObtenirListe();
        for (DemandeDePret demande : demandes) {
            RemboursementPret remboursement = validerEtProduireRemboursement(demande);
            depotDesResultats.Sauvegarder(demande.getIdentifiant(), remboursement);
        }
    }

    private RemboursementPret validerEtProduireRemboursement(DemandeDePret demande) {
        ValidateurPret validateurDePret = creerValidateurPourDemande(demande);

        RemboursementPret remboursement;
        if (validateurDePret.estValide()) {
            remboursement = calculateur.produireRemboursement(validateurDePret.demandeCourante);
        } else {
            remboursement = validateurDePret.produireRemboursementPretAvecErreurs();
        }
        return remboursement;
    }

    private ValidateurPret creerValidateurPourDemande(DemandeDePret demande) {
        return new ValidateurPret(demande.getPret());
    }
}

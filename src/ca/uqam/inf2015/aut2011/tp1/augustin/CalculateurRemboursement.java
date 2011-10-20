package ca.uqam.inf2015.aut2011.tp1.augustin;


/**
 * Cette classe est pour faire le calcule de tous les besoins du loigiciel.
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public class CalculateurRemboursement implements CalculateurDemandeHypothecaire {
    
    private double arrondirDeuxDecimale (double nombre){    
        return (double)Math.round(nombre*100)/100;
    }
    private double calculerVersementPeriodique(double interetPeriodique, int nbVersement, double montantPret) {
        
        double paiement = 0;         
        if (interetPeriodique != 0){
            double denominateur = (double) (1 - Math.pow((1 + interetPeriodique), -nbVersement));
            paiement = montantPret * interetPeriodique / denominateur;
        } else {
            paiement = montantPret/nbVersement;
        }
        return arrondirDeuxDecimale(paiement);
    }

    private double calculerInteretPeriodique(int freqComposition, double interet, int freqPaimentAnnuel) {

        double interetComposee = Math.pow(1 + interet / freqComposition, (double) freqComposition / freqPaimentAnnuel) - 1;
       
        return interetComposee;
    }

/// Section Pour l'amortissement
    private double calculerVersementInteret(double interetParPaiement, double resteCapital) {
        return arrondirDeuxDecimale (interetParPaiement * resteCapital);
    }

    private double calculerVersementCapital(double versementInteret, double versement) {
         return arrondirDeuxDecimale (versement - versementInteret);
    }

    private double calculerCapitalFin(double capitalFinPrecedent, double versementCapitalCourant) {
        return arrondirDeuxDecimale (capitalFinPrecedent - versementCapitalCourant);
    }

    private double calculerTotalCumulatif(double cumulatifPrecedent, double versementCourant) {
        return arrondirDeuxDecimale (cumulatifPrecedent + versementCourant);
    }

    private double calculerInteretCumulatif(double InteretCumulPrecedent, double versInteretCourant) {
        return arrondirDeuxDecimale (InteretCumulPrecedent + versInteretCourant);
    }

    private double calculerCapitalCumulatif(double capitalCumulPrecedent, double versCapitalCourant) {
        return arrondirDeuxDecimale (capitalCumulPrecedent + versCapitalCourant);
    }
    
    /**
     * 
     * @param pret
     * @return
     */
    @Override
    public RemboursementPret produireRemboursement(Pret pret) {
        
        RemboursementPret remboursement = new RemboursementPret(pret);
        double interetPeriodique = calculerInteretPeriodique(pret.frequenceComposition, pret.tauxInteret/100, pret.frequenceRemboursement);
                //Initialiser
        Amortissement amortPrecedent = new Amortissement(); 
        amortPrecedent.capitalFin = pret.montant;
        amortPrecedent.capitalDebut = pret.montant;
        amortPrecedent.versementTotal = calculerVersementPeriodique(interetPeriodique, pret.frequenceRemboursement*pret.nombreAnnee, pret.montant);
        
        int nbDePeriode = pret.nombreAnnee * pret.frequenceRemboursement;
        
        for (int periode = 1; periode <= nbDePeriode; periode++) {
            Amortissement amortCourant = new Amortissement();
            amortCourant.periode = periode;
            amortCourant.capitalDebut = amortPrecedent.capitalFin;
            amortCourant.versementInteret = calculerVersementInteret(interetPeriodique, amortCourant.capitalDebut);
            amortCourant.versementInteretCumulatif = calculerInteretCumulatif(amortPrecedent.versementInteretCumulatif, amortCourant.versementInteret); 
            
            // Gerer le dernier versement
            if ( periode == nbDePeriode) {
                amortCourant.versementCapital = amortPrecedent.capitalFin;
                amortCourant.versementTotal = arrondirDeuxDecimale (amortCourant.versementCapital + amortCourant.versementInteret);            
            } else {
                amortCourant.versementTotal = amortPrecedent.versementTotal;      
                amortCourant.versementCapital = calculerVersementCapital(amortCourant.versementInteret, amortCourant.versementTotal);
            }
            amortCourant.capitalFin = calculerCapitalFin(amortPrecedent.capitalFin, amortCourant.versementCapital);
            amortCourant.versementTotalCumulatif = calculerTotalCumulatif(amortPrecedent.versementTotalCumulatif, amortCourant.versementTotal);
            amortCourant.versementCapitalCumulatif = calculerCapitalCumulatif(amortPrecedent.versementCapitalCumulatif, amortCourant.versementCapital);
          
            remboursement.amortissement.add(amortCourant);
            amortPrecedent = amortCourant;              
        }

        return remboursement;
    }
}
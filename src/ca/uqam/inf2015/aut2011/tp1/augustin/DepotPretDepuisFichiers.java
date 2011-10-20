
package ca.uqam.inf2015.aut2011.tp1.augustin;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;


/**
 *
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public class DepotPretDepuisFichiers implements DepotDemandesDePret {

    private ConvertisseurFichierVersPret convertisseur;
    private File emplacementDesFichiers;

    /**
     * 
     * @param convertisseur
     * @param repertoire
     */
    public DepotPretDepuisFichiers(ConvertisseurFichierVersPret convertisseur, String repertoire) {
        File repertoireAValider = new File(repertoire);
        ValidateurRepertoire.assurerRepertoireExisteEtPermissionsSuffisantes(repertoireAValider);
        emplacementDesFichiers = repertoireAValider;
        this.convertisseur = convertisseur;
    }

    /**
     * 
     * @return
     */
    @Override
    public ArrayList<DemandeDePret> ObtenirListe() {
        ArrayList<DemandeDePret> demandesDePret = new ArrayList<DemandeDePret>();

        File[] listeFichiers = emplacementDesFichiers.listFiles(new FiltreFichierJson());

        if (listeFichiers != null) {
            for (File fichier : listeFichiers) {
                Pret pretCourant = convertirFichierJsonVersPret(fichier);
                if (pretCourant != null) {
                    demandesDePret.add(new DemandeDePret(fichier.getName(), pretCourant));
                }
            }
        }
        return demandesDePret;
    }

    private Pret convertirFichierJsonVersPret(File fichierAConvertir) {
        return convertisseur.versPret(fichierAConvertir);
    }
}

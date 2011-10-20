
package ca.uqam.inf2015.aut2011.tp1.augustin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * La classe suivante est pour récupérer tous les calcules que les autres classe on calculer 
 * est convertir les données afin de les écrires en format Json (@see FiltreFichierJson)
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public class DepotResultatsDemandesVersFichiers implements DepotResultatsDemandesDePret {

    File emplacementDesFichiers;
    ConvertisseurRemboursementPretVersString convertisseur;

    /**
     * 
     * @param convertisseur
     * @param repertoire
     */
    public DepotResultatsDemandesVersFichiers(ConvertisseurRemboursementPretVersString convertisseur, String repertoire) {
        File repertoireAValider = new File(repertoire);
        ValidateurRepertoire.assurerRepertoireExisteEtPermissionsSuffisantes(repertoireAValider);
        emplacementDesFichiers = repertoireAValider;
        this.convertisseur = convertisseur;
    }

    /**
     * 
     * @param identifiant
     * @param remboursement
     */
    @Override
    public void Sauvegarder(String identifiant, RemboursementPret remboursement) {

        File fichierDestination = new File(emplacementDesFichiers, identifiant);
        try {
            String remboursementASauvegarder = convertisseur.versString(remboursement);
            FileWriter writer = new FileWriter(fichierDestination);
            writer.write(remboursementASauvegarder);
            writer.close();
        } catch (IOException ex) {
            System.out.println("Impossible d'écrire le fichier: " + fichierDestination.getPath());

        }
    }
}

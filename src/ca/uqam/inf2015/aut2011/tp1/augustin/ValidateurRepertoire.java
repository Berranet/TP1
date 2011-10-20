
package ca.uqam.inf2015.aut2011.tp1.augustin;

import java.io.File;


/**
 *
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public class ValidateurRepertoire {
    /**
     * 
     * @param repertoireAValider
     */
    public static void assurerRepertoireExisteEtPermissionsSuffisantes(File repertoireAValider) {
        try {
            assurerCheminExiste(repertoireAValider);
            assurerCheminEstUnRepertoire(repertoireAValider);
        } catch (SecurityException ex) {
           throw new IllegalArgumentException("Vous n'avez pas les permissions nécessaire pour accéder au chemin spécifié. Répertoire: " + repertoireAValider);
        }
    }

    private static void assurerCheminEstUnRepertoire(File repertoireAValider) throws IllegalArgumentException {
        if (!repertoireAValider.isDirectory()) {
           throw new IllegalArgumentException("Le chemin spécifié ne représente pas un répertoire. Répertoire: " + repertoireAValider.getPath());
        }
    }

    private static void assurerCheminExiste(File repertoireAValider) throws IllegalArgumentException {
        if (!repertoireAValider.exists()) {
           throw new IllegalArgumentException("Le chemin spécifié n'existe pas. Répertoire: " + repertoireAValider.getPath());
        }
    }
}

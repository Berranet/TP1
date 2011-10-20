
package ca.uqam.inf2015.aut2011.tp1.augustin;

import java.io.File;
import java.io.FilenameFilter;


/**
 * la classe filtre fichier Json est pour en fait de vérifier l'extension des fichiers 
 * afin qu'il soit juste des fichier JSON.
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public class FiltreFichierJson implements FilenameFilter {

    /**
     * 
     * @param dir
     * @param name
     * @return
     */
    public boolean accept(File dir, String name) {
        return (name.endsWith(".json"));
    }
}

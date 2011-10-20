
package ca.uqam.inf2015.aut2011.tp1.augustin;

import java.io.File;


/**
 *
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public interface ConvertisseurFichierVersPret {

    /**
     * 
     * @param fichierAConvertir
     * @return
     */
    Pret versPret(File fichierAConvertir);
}


package ca.uqam.inf2015.aut2011.tp1.augustin;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Cette classe est pour lire les fichier JSON qui se trouvent dans un répertoire définis. 
 * Pas la suite la classe va convertir tous les données de ces fichiers en objets afin que 
 * la classe Classe (@Link CalculateurRemboursement) peut fair les calcure nécessaire. 
 * 
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public class ConvertisseurFichierJsonVersPret implements ConvertisseurFichierVersPret {

    /**
     * 
     * @param fichierAConvertir
     * @return
     */
    @Override
    public Pret versPret(File fichierAConvertir) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fichierAConvertir.getPath()));
            Pret pret = new Gson().fromJson(br, Pret.class);
            return pret;
        } catch (FileNotFoundException ex) {
            System.out.println("Impossible de lire le fichier " + fichierAConvertir.getPath());
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                Logger.getLogger(ConvertisseurFichierJsonVersPret.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}

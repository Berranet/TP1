
package ca.uqam.inf2015.aut2011.tp1.augustin.poc;

import ca.uqam.inf2015.aut2011.tp1.augustin.Pret;
import ca.uqam.inf2015.aut2011.tp1.augustin.RemboursementPret;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


/**
 *
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public class GsonTest {
        /**
     * @param args the command line arguments
     * @throws IOException  
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Pret y = new Pret();        
        y.id = "identifiant";
        
        Writer writer = new FileWriter("Output.json");
        
        Gson gson = new GsonBuilder().create();
        gson.toJson(y, writer);
        writer.close();
        
    }
}

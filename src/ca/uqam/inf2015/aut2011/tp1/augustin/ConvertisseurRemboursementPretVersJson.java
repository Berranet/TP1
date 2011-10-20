
package ca.uqam.inf2015.aut2011.tp1.augustin;

import com.google.gson.Gson;


/**
 *
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public class ConvertisseurRemboursementPretVersJson implements ConvertisseurRemboursementPretVersString {

    /**
     * 
     * @param remboursement
     * @return
     */
    @Override
    public String versString(RemboursementPret remboursement) {
        return new Gson().toJson(remboursement);
    }
}

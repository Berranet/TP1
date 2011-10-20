
package ca.uqam.inf2015.aut2011.tp1.augustin;


/**
 * la classe Pret possède les variable qui vont être utiles pour le calcule. De plus
 * les données qui se trouvent dans le fichier JSON vont être transférer en objet.
 * @see ConvertisseurFichierJsonVersPret
 * 
 * @author Stephane Lapointe
 * @author Myriam Allard 
 * @author Berra Mohamed
 */
public class Pret {
    /**
     * Variable de type String pour définir id 
     */
    public String id;
    /**
     * Variable de type integer pour définir la description
     */
    public String description;
    /**
     * Variable de type integer pour définir le montant
     */
    public double montant;
    /**
     * Variable de type integer pour définir le nombre d'annee
     */
    public int nombreAnnee;
    /**
     * Variable de type integer pour définir la frequence de remboursement
     */
    public int frequenceRemboursement;
    /**
     * Variable de type integer pour définir le taux d'interet
     */
    public double tauxInteret;
    /**
     * Variable de type integer pour définir la  frequence composition
     */
    public int frequenceComposition;
}

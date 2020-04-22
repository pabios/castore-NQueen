import org.sat4j.tools.*;

import org.sat4j.specs.ISolver;
import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.TimeoutException;


/**
 * Interface générique d'un accès séquenciel de modèle 1 d'élemnts de type T
 */
public interface AccesSequentielModele1<T> {

    /**
     * Initialisation du parcours.
     */
    public void demarrer();

    /**
     * Passage à l'élément suivant
     */
    public void avancer();

    /**
     * vrai ssi la séquence est épuisée
     * @return
     */
    public boolean finDeSequence();

    /**
     * renvoie l'élément courant
     * @return
     */
    public T elementCourant();
    
    

}

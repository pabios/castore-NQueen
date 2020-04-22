import java.io.File;
import org.sat4j.tools.*;

import org.sat4j.specs.IProblem;
import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.TimeoutException;



/**
 * objectif lire le contenu d'une sequence et restitue son element COurant
 */
public class AccesModele1 implements AccesSequentielModele1<Integer> {

        private int liste[];
        private int l;

        /**
         * Constructeur qui prend en parametre  la sequence
         * @param tab la sequence
         */
         public AccesModele1(int tab[]) {
             this.liste = tab;

         }

        public void demarrer() {
            this.l = 0;
        }

        public void avancer() {
           this.l = this.l + 1;
        }


        public boolean finDeSequence() {
            return (l == liste.length);
        }

        public Integer elementCourant() {
             return (liste[l]);
        }
}

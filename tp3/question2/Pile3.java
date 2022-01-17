package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
    private int capacite;

    public Pile3() {
        this(6);
    }

    public Pile3(int taille) {
        if (taille < 0)
            taille = 6;

        this.capacite = taille;
        this.v = new Vector<>();
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        v.addElement(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return v.remove(v.size() - 1);        
    }

    public Object sommet() throws PileVideException {
        return v.lastElement();
    }

    public int taille() {
        return this.v.size();
    }

    public int capacite() {
        return this.capacite;
    }

    public boolean estVide() {
        return this.v.isEmpty();
    }

    public boolean estPleine() {
        System.out.println(v.size());
        if (this.capacite == v.size()) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = this.taille() - 1; i >= 0; i--) {
            sb.append(v.get(i).toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (o != null && o instanceof Pile3) {
            Pile3 pile = (Pile3)o;
            return pile.v.equals(this.v);
        }
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}

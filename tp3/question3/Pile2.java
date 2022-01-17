package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        if (taille < 0)
            taille = 6;

        this.capacite = taille;
        this.stk = new Stack<>();
    }

    public Pile2(){
        this(6);
    }

    public void empiler(T o) throws PilePleineException{
        if (estPleine())
            throw new PilePleineException();
        stk.push(o);
    }

    public T depiler() throws PileVideException{
        if (estVide())
            throw new PileVideException();
        return stk.pop();
    }

    public T sommet() throws PileVideException{
        if (estVide())
            throw new PileVideException();
        return stk.lastElement();
    }
    
    public boolean estPleine() {
        System.out.println(stk.size());
        if (this.capacite == stk.size()) {
            return true;
        }
        return false;
    }
    
    public boolean estVide() {
        return stk.isEmpty();
    }

    public int taille() {
        return stk.size();
    }

    public int capacite() {
        return this.capacite;
    }
    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile

} // Pile2

import java.util.Iterator;
import java.util.Stack;
import material.Position;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DANI
 */
public class PreOrderIterator<E> implements Iterator<Position<E>>{
    private Tree<E> arbol;
    private Stack<Position<E>> pila = new Stack<>();

    public PreOrderIterator(Tree<E> t) {
        this.arbol = t;
        if(!arbol.isEmpty())
            pila.push(arbol.root());
    }

    public PreOrderIterator(Tree<E> t, Position<E> p) {
        this.arbol = t;
    }
    

    @Override
    public boolean hasNext() {
       return !pila.empty();
    }

    @Override
    public Position<E> next() {
        Position<E> nodo = pila.pop();
        Iterable<? extends Position<E>> children = arbol.children(nodo);
        for (Position<E> position : children) {
            pila.push(position);
        }
        return nodo;
    }
    
}

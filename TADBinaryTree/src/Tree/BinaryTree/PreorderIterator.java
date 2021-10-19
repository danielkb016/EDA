/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.BinaryTree;

import java.util.Iterator;
import java.util.Stack;
import material.Position;

/**
 *
 * @author DANI
 */
public class PreorderIterator<J> implements Iterator<Position<J>> {
    private Tree<J> arbol;
    private Position<J> nodo;
    private Stack<Position<J>> pila = new Stack<>();
    
    public PreorderIterator (Tree<J> t ){
        arbol = t;
        if(!arbol.isEmpty()){
            nodo = arbol.root();
            pila.push(nodo);
        }
    
    }
    public PreorderIterator(Tree<J> t , Position<J> p){
        arbol = t;
        pila.push(p);
    }

    @Override
    public boolean hasNext() {
        return !pila.isEmpty();
    }

    @Override
    public Position<J> next() { //Depende del orden de los hijos
        Position<J> nodo = pila.pop();
        Iterable<? extends Position<J>> children = arbol.children(nodo);
        for (Position<J> position : children) {
            pila.push(position); 
        }
        return nodo;
    }
    
    
}

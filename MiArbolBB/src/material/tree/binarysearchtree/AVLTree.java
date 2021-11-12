/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.tree.binarysearchtree;

import java.util.Iterator;
import material.Position;

/**
 *
 * @author d.cabezas.2017
 */
public class AVLTree <E> implements BinarySearchTree<E>{
    private LinkedBinarySearchTree<E> tree = new LinkedBinarySearchTree<>();
     public Position<E> desequilibrio(E value) {
        
    }
    private class AVLInfo<T> implements Comparable<AVLInfo<T>>, Position<T>{

        @Override
        public int compareTo(AVLInfo<T> t) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public T getElement() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    }
    
    @Override
    public Position<E> find(E value) {
       return tree.find(value);
    }

    @Override
    public Iterable<? extends Position<E>> findAll(E value) {
        return tree.findAll(value);
    }

    @Override
    public Position<E> insert(E value) {
        Position<E>
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Position<E> pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<? extends Position<E>> rangeIterator(E m, E M) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Position<E>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

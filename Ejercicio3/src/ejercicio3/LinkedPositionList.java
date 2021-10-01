/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.util.Iterator;
import material.Position;

/**
 *
 * @author DANI
 * @param <E>
 */
public class LinkedPositionList<E> implements MyListBetter<E> {
    private LinkedPositionList<E> head,tail;
    private int size;
       private class DLinkedNode<T> implements Position<T>{
        private T element ;    
        private DLinkedNode<T> next;
        private DLinkedNode<T> prev;

        public DLinkedNode(T element, DLinkedNode<T> next, DLinkedNode<T> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public DLinkedNode<T> getNext() {
            return next;
        }

        public void setNext(DLinkedNode<T> next) {
            this.next = next;
        }

        public DLinkedNode<T> getPrev() {
            return prev;
        }

        public void setPrev(DLinkedNode<T> prev) {
            this.prev = prev;
        }
        
        @Override
        public T getElement() {
            return element;
        }
        
        
        
        
        
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isempty() {
        return size == 0;
    }

    @Override
    public Position<E> add(E value) {
           
    }

    @Override
    public Position<E> addAfter(Position<E> pos, E value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> addBefore(Position<E> pos, E value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(Position<E> pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> set(Position<E> pos, E value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> search(E value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(E value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Position<E>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
   
    
}

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
 */
public class LinkedPosPrac <E> implements MyListBetter <E> {
    
    private DLinkedNode <E>  head,tail;
    private int size;
    
    private class DLinkedNode <T> implements Position<T>{
            private DLinkedNode <T> next, prev;
            private T element;

        public DLinkedNode(DLinkedNode<T> next, DLinkedNode<T> prev, T element) {
            this.next = next;
            this.prev = prev;
            this.element = element;
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
   
    private DLinkedNode<E> checkPosition(Position<E> p){
        if(p == null || !(p instanceof DLinkedNode))
            throw new RuntimeException("Invalid position");
        else
            return (DLinkedNode<E>) p;
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
        DLinkedNode <E> aux = new DLinkedNode<>(head,null,value);
        
        if (head == null){
            head = aux; 
             tail = aux;
        }else {
            aux.next = head;
            head.setPrev(aux);
        }
        size++;
        head = aux;
                
        return  aux;
    }

    @Override
    public Position<E> addAfter(Position<E> pos, E value) {
       DLinkedNode<E> aux = checkPosition(pos);
       DLinkedNode <E> node = new DLinkedNode<> (null,aux,value);
       
       if(head == null){
          return null;
       }else if(aux == tail){
           tail = node;
       }
       else{
          aux.next = node;
          node.next = aux.next;
          aux.next.prev = node;
       }
       return node;
    }
    

    @Override
    public Position<E> addBefore(Position<E> pos, E value) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public E remove(Position<E> pos) {
        
    }

    @Override
    public Position<E> get() {
        if (isempty())
            throw new RuntimeException();
        return this.head;
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

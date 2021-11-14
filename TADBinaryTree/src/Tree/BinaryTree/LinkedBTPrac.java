/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.BinaryTree;

import java.util.Iterator;
import material.Position;

/**
 *
 * @author DANI
 */
public class LinkedBTPrac<E> implements BinaryTree<E> {
    private BTnode<E> root;
    private BTnode<E> CheckPosition(Position<E> v) {
        if(v != null && v instanceof BTnode)
            return (BTnode<E>) v;
        throw new RuntimeException();
        
    }
    private class BTnode<V> implements Position<V>{
    private V element;
    private BTnode<V> parent,left,right;

        public BTnode(V element, BTnode<V> parent, BTnode<V> left, BTnode<V> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public V getElement() {
            return element;
        }

        public void setElement(V element) {
            this.element = element;
        }

        public BTnode<V> getParent() {
            return parent;
        }

        public void setParent(BTnode<V> parent) {
            this.parent = parent;
        }

        public BTnode<V> getLeft() {
            return left;
        }

        public void setLeft(BTnode<V> left) {
            this.left = left;
        }

        public BTnode<V> getRight() {
            return right;
        }

        public void setRight(BTnode<V> right) {
            this.right = right;
        }
    
        
    
    }

    @Override
    public Position<E> left(Position<E> v) {
        BTnode<E> node = CheckPosition(v);
        if(node.getLeft() == null)
            throw new RuntimeException();
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> v) {
        BTnode<E> node = CheckPosition(v);
        if(node.getRight() == null)
            throw new RuntimeException();
        return node.getRight();
    }

    @Override
    public boolean hasLeft(Position<E> v) {
        BTnode<E> node = CheckPosition(v);
        return node.getLeft() != null;
          
    }

    @Override
    public boolean hasRight(Position<E> v) {
          BTnode<E> node = CheckPosition(v);
        return node.getRight() != null;
    }

    @Override
    public boolean isInternal(Position<E> v) {
         BTnode<E> node = CheckPosition(v);
         return !isLeaf(node);
    }

    @Override
    public boolean isLeaf(Position<E> p) {
        BTnode<E> node = CheckPosition(p);
        return node.getLeft() != null || node.getRight() != null;
    }

    @Override
    public boolean isRoot(Position<E> p) {
         BTnode<E> node = CheckPosition(p);
        return node.getParent() == null;
    }

    @Override
    public Position<E> root() {
       return this.root;
    }

    @Override
    public E replace(Position<E> p, E e) {
          BTnode<E> node = CheckPosition(p);
          if(node == null)
              throw new RuntimeException();
          E aux = node.getElement();
          node.setElement(e);
          return aux;
    }

    @Override
    public Position<E> sibling(Position<E> p) {
          BTnode<E> node = CheckPosition(p);          
              
          BTnode<E> parent = node.getParent();
          if(isRoot(node) || !hasLeft(parent) || !hasRight(parent))
              throw new RuntimeException("No hay hermanos");
          if(parent.getLeft() == node)
              return parent.getRight();
          else
              return parent.getLeft();
    }

    @Override
    public Position<E> addRoot(E e) {
        if(this.root() != null)
            throw new RuntimeException();
        return new BTnode<>(e,null,null,null);
    }

    @Override
    public Position<E> insertLeft(Position<E> p, E e) {
        BTnode<E> node = CheckPosition(p); 
        if(hasLeft(node))
            throw new RuntimeException();
        BTnode<E> aux = new BTnode<> (e,node,null,null);
        node.setLeft(aux);
        return aux;
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(Position<E> p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void swap(Position<E> p1, Position<E> p2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attachLeft(Position<String> h, BinaryTree<String> t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attachRight(Position<String> h, BinaryTree<String> t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BinaryTree<String> subTree(Position<String> h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> parent(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Position<E>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

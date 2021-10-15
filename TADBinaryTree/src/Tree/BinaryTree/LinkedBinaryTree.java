
package Tree.BinaryTree;

import java.util.Iterator;
import material.Position;

/**
 *
 * @author mayte
 */
public class LinkedBinaryTree<E> implements BinaryTree<E>{
    
    
    
    private BTNode<E> checkPosition(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private class BTNode<V> implements Position<V>{
        private V element;
        private BTNode<V> parent,left,right;

        public BTNode(V element, BTNode<V> parent, BTNode<V> left, BTNode<V> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public BTNode<V> getParent() {
            return parent;
        }

        public void setParent(BTNode<V> parent) {
            this.parent = parent;
        }

        public BTNode<V> getLeft() {
            return left;
        }

        public void setLeft(BTNode<V> left) {
            this.left = left;
        }

        public BTNode<V> getRight() {
            return right;
        }

        public void setRight(BTNode<V> right) {
            this.right = right;
        }
        public void setElement(BTNode<V> e){
            this.element = (V) e;
        }
        
        
        @Override
        public V getElement() {
            return element;
        }

}
    
    private BTNode<E> root;
    
    @Override
    public Position<E> left(Position<E> v) {
        BTNode<E> nodo = checkPosition(v);
        if(nodo.left == null)
            throw new RuntimeException("No tiene hijo izquierdo");
        return nodo.getLeft();
    }

    @Override
    public Position<E> right(Position<E> v) {
         
        BTNode<E> nodo = checkPosition(v);
        if(nodo.right == null)
            throw new RuntimeException("No tiene hijo derecho");
        return nodo.getRight();
    

    }

    @Override
    public boolean hasLeft(Position<E> v) {
        BTNode<E> nodo = checkPosition(v);
        return nodo.getLeft() != null;
    }

    @Override
    public boolean hasRight(Position<E> v) {
        BTNode<E> nodo = checkPosition(v);
        return nodo.getRight() != null;
    }

    @Override
    public boolean isInternal(Position<E> v) {
     
        return (this.hasLeft(v) || this.hasRight(v));
    }

    @Override
    public boolean isLeaf(Position<E> p) {
        return !isInternal(p);
    }

    @Override
    public boolean isRoot(Position<E> p) {
       BTNode<E> nodo = checkPosition(p);
       return nodo.getParent() == null;
    }

    @Override
    public Position<E> root() {
        return this.root;
    }

    @Override
    public E replace(Position<E> p, E e) {
        BTNode<E> nodo = checkPosition(p);
        E aux = nodo.getElement();
        nodo.setElement(e);
        return aux;
     
    }
    private boolean esHijoDerecho(BTNode<E> parent,BTNode<E> child ){
        return parent.getRight() == child;
    
    }
    @Override
    public Position<E> sibling(Position<E> p) {
          BTNode<E> nodo = checkPosition(p);
          if( isRoot(p))
              throw new RuntimeException();
          if(hasLeft(nodo.getParent())&& hasRight(nodo.getParent()))
              if(left(nodo.getParent()) == nodo)
                  return right(nodo.getParent());
              else
                return left(nodo.getParent());
          else
              throw new RuntimeException();
              
    }

    @Override
    public Position<E> addRoot(E e) {
       if(this.root != null)
           throw new RuntimeException();
       return new BTNode<> (e,null,null,null);
    }

    @Override
    public Position<E> insertLeft(Position<E> p, E e) {
          BTNode<E> nodo = checkPosition(p);
          if(this.hasLeft(p))
              throw new RuntimeException();
          BTNode nuevo = new BTNode<>(e,nodo,null,null);
          nodo.setLeft(nuevo);
          return nuevo;
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) {
        BTNode<E> nodo = checkPosition(p);
          if(this.hasRight(p))
              throw new RuntimeException();
          BTNode nuevo = new BTNode<>(e,nodo,null,null);
          nodo.setRight(nuevo);
          return nuevo;
    }

    @Override
    public E remove(Position<E> p) {
        BTNode<E> nodo = checkPosition(p);
        if (isRoot(p))
            root = null;
        else
            if(esHijoDerecho(nodo.getParent(), nodo))
                nodo.getParent().setRight(null);
            else
                nodo.getParent().setLeft(null);
        return nodo.getElement();
    }

    @Override
    public void swap(Position<E> p1, Position<E> p2) {
        BTNode<E> nodo1 = checkPosition(p1);
        BTNode<E> nodo2 = checkPosition(p2);
        
    }

    @Override
    public boolean isEmpty() {
        return root == null;
        
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

    public void attachLeft(Position<String> h, LinkedBinaryTree<String> t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void attachRight(Position<String> h, LinkedBinaryTree<String> t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedBinaryTree<String> subTree(Position<String> h) {
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

   
}

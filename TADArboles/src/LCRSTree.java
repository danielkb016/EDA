

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import material.Position;

/**
 *
 * @author mayte
 * @param <E>
 */
public class LCRSTree<E> implements NAryTree<E> {

   

    LCRSnode<E> root;

    private LCRSnode<E> CheckPosition(Position<E> v) {
        if(v != null && v instanceof LCRSnode)
            return (LCRSnode<E>) v;
        else
            throw new RuntimeException();
    }

    private int descendientes(LCRSnode<E> node) {
      int cont = 0;
        LCRStreeIterator<E> iter = new LCRStreeIterator<>(this);
        while(iter.hasNext()){
            cont++;
        }
        return cont;
        
    }

    private class LCRStreeIterator<E>  implements Iterator<Position<E>> {
        private Queue <Position<E>> iterador = new LinkedList<>();
         private LCRSTree<E> tree;
        public LCRStreeIterator(LCRSTree<E> tr ) {
            if (tr.isEmpty())
           throw new RuntimeException("No es iterable");
           tree = tr;
           iterador.add(tr.root());           
        }
        
       
        @Override
        public boolean hasNext() {
           return !iterador.isEmpty();
        }

        @Override
        public Position<E> next() {
           Position<E> p = iterador.poll(); 
            Iterable<? extends Position<E>> children = tree.children(p);
            for (Position<E> position : children) {
                iterador.add(position);
            }
          return p;
        }
       
    }
    
    private class LCRSnode<T> implements Position<T>{
    private LCRSnode<T> parent,hijo,hermano;
    private T element;

        

        public LCRSnode(LCRSnode<T> parent, LCRSnode<T> hijo, LCRSnode<T> hermano, T element) {
            this.parent = parent;
            this.hijo = hijo;
            this.hermano = hermano;
            this.element = element;
        }

      

        public LCRSnode<T> getParent() {
            return parent;
        }

        public void setParent(LCRSnode<T> parent) {
            this.parent = parent;
        }

        public LCRSnode<T> getHijo() {
            return hijo;
        }

        public void setHijo(LCRSnode<T> hijo) {
            this.hijo = hijo;
        }

        public LCRSnode<T> getHermano() {
            return hermano;
        }

        public void setHermano(LCRSnode<T> hermano) {
            this.hermano = hermano;
        }
    
        public void setElement(T e){
            this.element = e;
        }
        @Override
        public T getElement() {
           return element;
        }

        
    
}

    @Override
    public Position<E> addRoot(E e) {
        if(isEmpty())
              throw new RuntimeException();
        root = new LCRSnode<E>(null,null,null,e);
        return root;
        
    }

    @Override
    public Position<E> add(E element, Position<E> p) {
          LCRSnode<E> node = CheckPosition(p);
          LCRSnode<E> hijo = node.getHijo();
          LCRSnode<E> aux = new LCRSnode<>(node,null,null,element);
          if(hijo == null)
              node.setHijo(aux);
          else{
              while(hijo.getHermano() != null)
                  hijo = hijo.getHermano();
              hijo.setHermano(aux);
            }
        return aux;
    }

    @Override
    public Position<E> add(E element, Position<E> p, int n) {
        int cont = 2;
        LCRSnode<E> node = CheckPosition(p);
          LCRSnode<E> hijo = node.getHijo();
          LCRSnode<E> aux = new LCRSnode<>(node,null,null,element);
          if(n == 1){
                aux.setHermano(hijo);
                node.setHijo(aux);
           }
          else{
              while(hijo != null && cont < n){
                  hijo = hijo.getHermano();
                  cont++;
              }
              if(hijo == null)
                  throw new RuntimeException("n > numero de hijos");
              aux.setHermano(hijo.getHermano());
              hijo.setHermano(aux);
              
            }
        return aux;
    }

    @Override
    public void swapElements(Position<E> p1, Position<E> p2) {
        LCRSnode<E> node1 = CheckPosition(p1);
        LCRSnode<E> node2 = CheckPosition(p2);
        LCRSnode<E> aux = node1;
        node1 = node2;
        node2 = aux;
    }

    @Override
    public E replace(Position<E> p, E e) {
        LCRSnode<E> node = CheckPosition(p);
        E aux = node.getElement();
        node.setElement(e);
        return aux;
    }

    @Override
    public void remove(Position<E> p) {
        LCRSnode<E> node = CheckPosition(p);
        if(isRoot(node)){
            root = null;
        }
        else{
            LCRSnode<E> padre = node.getParent();
            if(node == padre.getHijo()){
                padre.setHijo(node.getHermano());
            }
            else{
                LCRSnode<E> aux = padre.getHijo();
                while(aux.getHermano() != node)
                    aux = aux.getHermano();
                aux.setHermano(node.getHermano());
            }
        }
    }

    @Override
    public NAryTree<E> subTree(Position<E> v) {
       LCRSnode<E> node = CheckPosition(v);
       remove(v);
       node.setHermano(null);
       node.setParent(null);
       LCRSTree<E> newTree = new LCRSTree<>();
       newTree.root = node;
       return newTree;
        
    }

    @Override
    public void attach(Position<E> p, NAryTree<E> t) {
         if (!( t instanceof LCRSTree))
            throw new RuntimeException();
        LCRSTree<E> tree =(LCRSTree<E>) t;
        if(p == null){          
           this.root = tree.root;
        }else{
            LCRSnode<E> node = CheckPosition(p);
            LCRSnode<E> hijo = node.getHijo();
            if(hijo == null){
                node.setHijo(tree.root);
            }else{
                while(hijo.getHermano() != null){
                    hijo = hijo.getHermano();
                }
                hijo.setHermano(tree.root);
            }
        }
    }

    @Override
    public boolean isEmpty() {
       return root == null;
    }

    @Override
    public Position<E> root() {
       return this.root;
    }

    @Override
    public Position<E> parent(Position<E> v) {
        LCRSnode<E> node = CheckPosition(v);
        if (isRoot(node)) 
            throw new RuntimeException();
        return node.getParent();
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isInternal(Position<E> v) {
       LCRSnode<E> node = CheckPosition(v);
       return node.getHijo() != null && node.getParent() != null;
            
    }

    @Override
    public boolean isLeaf(Position<E> v) {
        LCRSnode<E> node = CheckPosition(v);
        return node.getHijo() == null;
    }

    @Override
    public boolean isRoot(Position<E> v) {
       LCRSnode<E> node = CheckPosition(v);
       return node == root;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return new LCRStreeIterator(this);
    }

    public int size() {
        if( isEmpty())
            return 0;
        else
            return descendientes(root);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.tree.binarysearchtree;

import java.util.*;
import material.*;
import material.tree.*;
import material.tree.binarytree.*;


/**
 *
 * @author mayte
 * @param <E>
 */
public class LinkedBinarySearchTree<E> implements BinarySearchTree<E> {
    
    private LinkedBinaryTree<E> tree;
    private int size;
    private Comparator<E> comparador;

    public LinkedBinarySearchTree(Comparator<E> comparador) {
        if(comparador == null){
            this.comparador = new DefaultComparator();
            
        }else{
            this.comparador = comparador;
        }
        tree = new LinkedBinaryTree<>();
        size = 0;
    }

    public LinkedBinarySearchTree() {
        this(null);
    }
    
    private Position<E> busca (E value, Position<E> pos){
        int i = comparador.compare(value, pos.getElement());
        if((i < 0) && (tree.hasLeft(pos))){
            return busca(value, tree.left(pos));
        }else if(i > 0){
            return busca(value, tree.right(pos));
        }else
            return pos;
    }
    
    @Override
    public Position<E> find(E value) {
      if (!tree.isEmpty()) {
          Position <E> p = busca(value, tree.root());
          if (comparador.compare(value,p.getElement()) == 0)
              return p;
      } 
       
        return null;
    }

    @Override
    public Iterable<? extends Position<E>> findAll(E value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> insert(E value) {
        Position<E> p = null ;
        if(isEmpty())
           p = tree.addRoot(value);
        else{
            Position<E> pos = busca(value, tree.root());
            while((comparador.compare(value, pos.getElement()) == 0) && (tree.hasRight(pos))){
                    pos = busca(value, tree.right(pos));
                if( comparador.compare(value, pos.getElement()) < 0){
                     p = tree.insertLeft(pos, value);
                }else{
                     p = tree.insertRight(pos, value);
                }
            }
        }
        size++;
        return p ;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;  //Return tree.isEmpty();
    }
    
    private Position<E> minium(Position<E> right) {
        Position<E> p = right;
        while(tree.hasLeft(right)){
            p = tree.left(p);
        }
        return p;
    }
    
    public Position <E>  Sucesor(Position<E> p){
        if(tree.hasRight(p)){
            return minium(tree.right(p));
        }
        return null;
    }
    @Override
    public void remove(Position<E> pos) {
        if (tree.isLeaf(pos) || (!tree.hasLeft(pos) || (!tree.hasRight(pos)))){
            tree.remove(pos);
        }else{
            
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }
   
    @Override
    public Iterable<? extends Position<E>> rangeIterator(E m, E M) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return new InorderBinaryTreeIterator(tree);
    }

    
    
}

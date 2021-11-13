
import java.util.ArrayList;
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
public class LinkedTree<E> implements NAryTree<E>{
    
    private TreeNode<E> root;
    private int size = 0;

    private TreeNode<E> CheckPosition(Position<E> p) {
        if(p != null && p instanceof TreeNode)
            return (TreeNode<E>) p;
        throw new RuntimeException();
    }
    private class TreeNode<V> implements Position<V>{
        private V element;
        private TreeNode<V> parent;
        private List<TreeNode<V>> children;
        

        public TreeNode(V element, TreeNode<V> parentn) {
            this.element = element;
            this.parent = parent;
            
        }

        public TreeNode<V> getParent() {
            return parent;
        }

        public void setParent(TreeNode<V> parent) {
            this.parent = parent;
        }

        public List<TreeNode<V>> getChildren() {
            return children;
        }

        public void setChildren(List<TreeNode<V>> children) {
            this.children = children;
        }
        public void setElement(V e){
            this.element = e;
        }
        @Override
        public V getElement() {
            return element;
        }
    
    }
    
    
    private class LinkedTreeIterator<E> implements Iterator<Position<E>> { 

        private Queue<Position<E>> iterador = new LinkedList<>();  //forma natural (por niveles)
        private LinkedTree<E> tree;
        public LinkedTreeIterator(LinkedTree<E> tr){
            if( tr.isEmpty())
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
            TreeNode<E> node = (TreeNode<E>) iterador.poll();
            iterador.addAll(node.getChildren());
            return node;
        }
    
    }
    
    
    @Override
    public Position<E> addRoot(E e) {
        if(!isEmpty())
            throw new RuntimeException("El arbol no es vacio");
        root = new TreeNode(e,null);
        size++;
        return root;
    }

    @Override
    public Position<E> add(E element, Position<E> p) {
        TreeNode<E> node = CheckPosition(p);
        if(node.getChildren() == null)
            node.setChildren(new ArrayList<TreeNode<E>>());
        TreeNode<E> hijo = new TreeNode<E>(element,node);
        node.getChildren().add(hijo);
        size++;
        return hijo;
    }

    @Override
    public Position<E> add(E element, Position<E> p, int n) {
        TreeNode<E> node = CheckPosition(p);
        if(node.getChildren() == null)
            node.setChildren(new ArrayList<TreeNode<E>>());
        TreeNode<E> hijo = new TreeNode<E>(element,node);
        if(node.getChildren().size() < n)
            throw new RuntimeException();
        node.getChildren().add(n, node);
        size++;
        return hijo;
    }

    @Override
    public void swapElements(Position<E> p1, Position<E> p2) {
        TreeNode<E> node1 = CheckPosition(p1);
        TreeNode<E> node2 = CheckPosition(p2);
        
        TreeNode<E> aux = (TreeNode<E>) p1;
        p1 = p2;
        p2 = aux;
    }

    @Override
    public E replace(Position<E> p, E e) {
        TreeNode<E> node = CheckPosition(p);
        E element = node.getElement();
        node.setElement(e);
        return element;
    }

    @Override
    public void remove(Position<E> p) {
        TreeNode<E> node = CheckPosition(p);
        if(isRoot(node))
            this.root = null;
        node.getParent().getChildren().remove(node);
        size--;
    }

    @Override
    public NAryTree<E> subTree(Position<E> v) {
       TreeNode<E> node = CheckPosition(v);
       LinkedTree<E> nuevo = new LinkedTree<>();
       nuevo.root = node;
       return nuevo;
    }

    @Override
    public void attach(Position<E> p, NAryTree<E> t) {
        throw new UnsupportedOperationException("Not supported yeti."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return this.root() == null;
    }
    private int descendientes(TreeNode<E> node){
        int cont = 1;
        List<TreeNode<E>> hijos = node.getChildren();
        for (TreeNode<E> hijo : hijos) {
            if(hijo.getChildren().isEmpty())
                cont++;
            else
                cont = cont + descendientes(hijo);
            
        }
    return cont;
    }
     public int size() {
         if( isEmpty())
             return 0;
         else
            return  descendientes(root);
    }
   
    @Override
    public Position<E> root() {
        return this.root;
    }

    @Override
    public Position<E> parent(Position<E> v) {
        TreeNode<E> node = CheckPosition(v);
        if(this.isRoot(node))
            throw new RuntimeException();
        return node.getParent();
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isInternal(Position<E> v) {
         TreeNode<E> node = CheckPosition(v);
         return node.getElement() != null && !node.getChildren().isEmpty();
    }

    @Override
    public boolean isLeaf(Position<E> v) {
        TreeNode<E> node = CheckPosition(v);
        return !node.getChildren().isEmpty();
    }

    @Override
    public boolean isRoot(Position<E> v) {
         TreeNode<E> node = CheckPosition(v);
         return this.root == node;
    }

    @Override
    public Iterator<Position<E>> iterator() {
       return new LinkedTreeIterator<>(this);
    }



}


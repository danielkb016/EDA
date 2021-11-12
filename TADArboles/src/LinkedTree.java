
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import material.Position;

/**
 *
 * @author mayte
 * @param <E>
 */
public class LinkedTree<E> implements NAryTree<E>{
    
    private TreeNode<E> root;

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
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    }
    @Override
    public Position<E> addRoot(E e) {
        if(!isEmpty())
            throw new RuntimeException("El arbol no es vacio");
        root = new TreeNode(e,null);
        return root;
    }

    @Override
    public Position<E> add(E element, Position<E> p) {
        TreeNode<E> node = CheckPosition(p);
        if(node.getChildren() == null)
            node.setChildren(new ArrayList<TreeNode<E>>());
        TreeNode<E> hijo = new TreeNode<E>(element,node);
        node.getChildren().add(hijo);
        
        return hijo;
    }

    @Override
    public Position<E> add(E element, Position<E> p, int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void swapElements(Position<E> p1, Position<E> p2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E replace(Position<E> p, E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Position<E> p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NAryTree<E> subTree(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attach(Position<E> p, NAryTree<E> t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> root() {
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
    public boolean isInternal(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLeaf(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isRoot(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Position<E>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}


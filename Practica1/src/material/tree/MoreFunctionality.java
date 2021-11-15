
package material.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import material.Position;
import material.tree.narytree.NAryTree;

/**
 *
 * @author mayte
 * @param <T>
 */
public class MoreFunctionality<T> {
  
        
    /**
     * This method recives a NArytree and returns a List with the elements of the 
     * tree that can be seen if the tree is viewed from the left side.
     * @param tree
     * @return 
     */
    
    public List<T> leftView(NAryTree<T> tree){
         List<Position> lista = new ArrayList<>();
         Queue<Position> cola = new LinkedList<>();
         cola.add(tree.root());
         lista.add(tree.root());
         
         while(!cola.isEmpty()){
             Queue<Position> listaAux = new LinkedList<>();
             while(!cola.isEmpty()){
                  listaAux.add((Position) tree.children(cola.poll()));
                  
             }
             cola.clear();
             cola = listaAux;
             lista.add(cola.peek());
         }
             
        return (List<T>) lista;
    
    }

   /**
     * This method recives a NArytree and returns a List with the elements of the 
     * tree that can be seen if the tree is viewed from the right side.
     * @param tree
     * @return 
     */
    public List<T> rightView(NAryTree<T> tree){
        
        List<Position> lista = new ArrayList<>();
         Queue<Position> cola = new LinkedList<>();
         cola.add(tree.root());
         lista.add(tree.root());
         
         while(!cola.isEmpty()){
             Queue<Position> listaAux = new LinkedList<>();
             while(!cola.isEmpty()){
                  listaAux.add((Position) tree.children(cola.poll()));
                  
             }
             cola.clear();
             cola = listaAux;
            Object[] ta = cola.toArray();
             lista.add((Position) ta[ta.length-1]);
             
         }
             
        return (List<T>) lista;
    
    }
}

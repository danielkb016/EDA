
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author d.cabezas.2017
 */
public class Parcial {
       public List<T> leftView(NAryTree<T> tree){
         List<Position> lista = new ArrayList<>();
         Queue<Position> cola = new java.util.LinkedList<>();
         cola.add(tree.root());
         lista.add(tree.root());
         
         while(!cola.isEmpty()){
             Queue<Position> listaAux = new java.util.LinkedList<>();
             while(!cola.isEmpty()){
                  listaAux.add((Position) tree.children(cola.poll()));
                  
             }
             cola.clear();
             cola = listaAux;
             lista.add(cola.peek());
         }
             
        return (List<T>) lista;
    
    }
       private class LinkedTreeIterator<E> implements Iterator<Position<E>> { 

        private Queue<Position<E>> iterador = new java.util.LinkedList<>();  //forma natural (por niveles)
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
       public static List antecesors(Tree t, Position node) {
        if (t == null || node ==null)
            throw new RuntimeException();
       ArrayList<Object> lista = new ArrayList<>();
        if(t.parent(node) != null){
            Position aux = t.parent(node);    
            while(!t.isRoot(aux)){                
                lista.add(aux.getElement());
                aux = t.parent(aux); 
            }
            lista.add(aux.getElement());
        }
            return lista;
    }
/*
    public static int Altura_Arbol(Tree t) {
       if(t == null || t.isEmpty())
           throw new RuntimeException();
        Iterator it = t.iterator();
        int cont = 0;
        while(it.hasNext()){
            Position aux = (Position) it.next();
            if(t.isLeaf(aux))
               if(cont < antecesors(t,aux).size())
                cont = antecesors(t,aux).size();     
        }
        return cont;
    }
 */
    public static int degree(Tree t) {
        int contador = 0;
        Iterator it = t.iterator();

        while(it.hasNext()){
            Position n = (Position) it.next();
            Iterable c = t.children(n);
            int contaux = 0;
            for (Object o : c) {
                contaux++;
            }
            if(contaux > contador){
                contador = contaux;
            }
        }
        return contador;
    }

    public static boolean isIsogram(String word){
        HashMap<String,Integer> mapa = new HashMap<>();
        String[] lista = word.split("");
        for (String e : lista) {
            if(mapa.containsKey(e))
                mapa.put(e, mapa.get(e)+1);
            else
                mapa.put(e, 1);
        }
        Collection<Integer> val = mapa.values();
        for (Integer i : val) {
            if(i > 1)
                return false;
        }
        return true;
    }
}

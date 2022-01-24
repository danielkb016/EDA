package material.graphs;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import material.Position;
import material.tree.Tree;
import material.tree.narytree.LinkedTree;
import material.*;
import material.utils.Pair;

/**
 *
 * @author jvelez
 * @param <V>
 * @param <E>
 */
public class Recorridos_v2<V, E> {

    /**
     * Devuelve el árbol que se genera al realizar el recorrido en profundidad
     * 
     * @param graph
     * @param source
     * @return 
     */
    
    public Tree<Vertex<V>> depthTravel(Graph<V,E> graph, Vertex<V> source){
        if(graph == null || source == null)
            throw new RuntimeException();
        LinkedTree<Vertex<V>> arbol = new LinkedTree<>();
        HashMap<Vertex<V>,Position<Vertex<V>>> visitados = new HashMap<>();
        
        Collection<? extends Vertex<V>> conjunto_vertices = graph.vertices();
        Collection<? extends Edge<E>> conjunto_aristas = graph.edges();
        
        visitados.put(source, arbol.addRoot(source));
        Stack<Pair<Vertex<V>, Iterator<Edge<E>>>> pila = new Stack<>();
        Iterator<Edge<E>> it = (Iterator<Edge<E>>) graph.incidentEdges(source).iterator();
        Pair<Vertex<V>, Iterator<Edge<E>>> par = new Pair<>(source, it);
        pila.push(par);
        
        while(!pila.isEmpty()){
            par =  pila.peek();
            Iterator<Edge<E>> second = par.getSecond();
            boolean nuevo = false;
            Vertex<V> nodo = null;
            while(second.hasNext() && !nuevo){
                nodo = graph.opposite(par.getFirst(), second.next());
                nuevo = visitados.containsKey(nodo);
            }
             
            if(nuevo){
                visitados.put(nodo, arbol.add(nodo,  visitados.get(par.getFirst())));
                it = (Iterator<Edge<E>>) graph.incidentEdges(nodo).iterator();
                pila.push(new Pair<>(nodo, it));
            }else
                pila.pop();
        }
        return arbol;
    }
    
    /**
     * Devuelve el árbol que se genera al realizar el recorrido en anchura
     * 
     * @param graph
     * @param source
     * @return 
     */
    
    public Tree<Vertex<V>> widthTravel(Graph<V,E> graph, Vertex<V> source){
          //Variables necesarias para el funcionamiento del algoritmo
        Set<Vertex<V>> visitados = new HashSet<>();
        Set<Edge<E>> descubrimiento = new HashSet<>();
        Set<Edge<E>> cross = new HashSet<>();
        Stack<Pair<Vertex<V>, Iterator<Edge<E>>>> pila = new Stack<>();
        LinkedTree<Vertex<V>> tree = new LinkedTree<>();
        LinkedList<Pair<Vertex<V>, Iterator<Edge<E>>>> cola = new LinkedList<>();
        Map<Vertex<V>,Position<Vertex<V>>> mapa = new HashMap<>();
        
        //inicializamos variables 
        visitados.add(source);
        cola.addLast(new Pair(source, graph.incidentEdges(source).iterator()));
        mapa.put(source, tree.addRoot(source));
        
        while(!cola.isEmpty()){
            Pair<Vertex<V>, Iterator<Edge<E>>> par = cola.pollFirst();
            Iterator<Edge<E>> ite= par.getSecond();
            Vertex<V> nodo = par.getFirst();
            while(ite.hasNext()){
                Edge<E> ari = ite.next();
                if((!descubrimiento.contains(ari)) && (!cross.contains(ari))){
                    Vertex<V> otro = graph.opposite((nodo), ari);
                    if(visitados.contains(otro))
                        cross.add(ari);
                    else{
                        visitados.add(otro);
                        cola.addLast(new Pair(otro, graph.incidentEdges(otro).iterator()));
                        descubrimiento.add(ari);
                        mapa.put(otro, tree.add(otro, mapa.get(nodo)));
                    }
                }
            }
            
        
        }
        
        return tree;
        
    }
    
    /**
     * Get the path between two vertex with minimun number of nodes.
     *
     * @param graph
     * @param startVertex
     * @param endVertex
     * @return The edge list
     */
    public List<Edge<E>> getPath(Graph<V, E> graph, Vertex<V> startVertex, Vertex<V> endVertex) {
       throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Devuelve el conjunto de vértices visitados al hacer un recorrido en profundidad partiendo de root
     * @param g
     * @param root
     * @return 
     */
    public Set<Vertex<V>> traverse(Graph<V, E> g, Vertex<V> root) {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

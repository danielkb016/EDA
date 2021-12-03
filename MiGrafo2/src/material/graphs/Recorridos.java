package material.graphs;

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
import material.utils.Pair;

/**
 *
 * @author jvelez
 * @param <V>
 * @param <E>
 */
public class Recorridos<V, E> {

    /**
     * Devuelve el árbol que se genera al realizar el recorrido en profundidad
     * 
     * @param graph
     * @param source
     * @return 
     */
    
    public Tree<Vertex<V>> depthTravel(Graph<V,E> graph, Vertex<V> source){
        //Variables necesarias para el funcionamiento del algoritmo
        Set<Vertex<V>> visitados = new HashSet<>();
        Set<Edge<E>> descubrimiento = new HashSet<>();
        Set<Edge<E>> back = new HashSet<>();
        Stack<Pair<Vertex<V>, Iterator<Edge<E>>>> pila = new Stack<>();
        LinkedTree<Vertex<V>> tree = new LinkedTree<>();
        Map<Vertex<V>,Position<Vertex<V>>> mapa = new HashMap<>();
        
        //Inicializacion de las variables
        visitados.add(source);
        pila.push(new Pair(source,graph.incidentEdges(source).iterator()));
        mapa.put(source,tree.addRoot(source));
        
        while(!pila.isEmpty()){
            Pair<Vertex<V>, Iterator<Edge<E>>> par = pila.peek();
            Iterator<Edge<E>> ite = par.getSecond();
            Vertex<V> nodo = par.getFirst();
            boolean salir = false;
            while(ite.hasNext() && !salir){
                Edge<E> ari = ite.next();
                if((!descubrimiento.contains((ari)) && (!back.contains(ari)))){
                    Vertex<V> otro = graph.opposite(nodo, ari);
                    salir = !visitados.contains(otro);
                    if(salir){
                        visitados.add(otro);
                        pila.push(new Pair( otro, graph.incidentEdges(otro).iterator()));
                        descubrimiento.add(ari);
                        mapa.put(otro, tree.add(otro, mapa.get(nodo)));
                        
                    }else{
                        back.add(ari);
                    }
                }
            }
            if (!salir)
                pila.pop();
        }
        
        return tree;
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

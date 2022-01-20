
package material.graphs;

import java.util.Collection;
<<<<<<< HEAD
import java.util.List;

/**
 *
 * @author mayte
 * @param <V>
 * @param <E>
 */
public class ELGraph<V,E> implements Graph<V,E> {

    @Override
    public Collection<? extends Vertex<V>> vertices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<? extends Edge<E>> edges() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<? extends Edge<E>> incidentEdges(Vertex<V> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vertex<V>> endVertices(Edge<E> edge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Edge<E> areAdjacent(Vertex<V> v1, Vertex<V> v2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V replace(Vertex<V> vertex, V vertexValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E replace(Edge<E> edge, E edgeValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vertex<V> insertVertex(V value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V removeVertex(Vertex<V> vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
=======
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author mayte
 * @param <V>
 * @param <E>
 */
public class ELGraph<V,E> implements Graph<V,E> {

    private ELVertex<V> checkVertex(Vertex<V> v1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private class ELVertex<T> implements Vertex<T>{
        private T value;
        private Set<ELEdge<E>> misAristas = new HashSet<>();
        public void setValue(T value){
            this.value = value;
        }
        
        @Override
        public T getElement() {
            return value;
        }

     

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ELVertex<?> other = (ELVertex<?>) obj;
            if (!Objects.equals(this.value, other.value)) {
                return false;
            }
            return true;
        }
        
    }
    
    private class ELEdge<G> implements Edge<G>{
        
        private ELVertex<V> start;
        private ELVertex<V> end; 
        private G value;
        

        public ELEdge(ELVertex<V> start, ELVertex<V> end, G value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        public void setValue(G value) {
            this.value = value;
        }
        
        @Override
        public G getElement() {
           return value;
        }

       
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ELEdge<?> other = (ELEdge<?>) obj;
            if (!this.start.equals(other.start) || !this.start.equals(other.end)){
                return false;
            }
            if (!this.end.equals(other.end) || !this.end.equals(other.start)) {
                return false;
            }
            
            return true;
        }
        
    }
    
    private Set<ELVertex<V>> nodos;
    private Set<ELEdge<E>> aristas;

    public ELGraph() {
        this.nodos = new HashSet<>();
        this.aristas = new HashSet<>();
    }
    
    
    
    @Override
    public Collection<? extends Vertex<V>> vertices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<? extends Edge<E>> edges() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<? extends Edge<E>> incidentEdges(Vertex<V> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vertex<V>> endVertices(Edge<E> edge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Edge<E> areAdjacent(Vertex<V> v1, Vertex<V> v2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V replace(Vertex<V> vertex, V vertexValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E replace(Edge<E> edge, E edgeValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vertex<V> insertVertex(V value) {
       ELVertex<V> nodo = new ELVertex<>();
       nodo.setValue(value);
       nodos.add(nodo);
       return nodo;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeValue) {
        ELVertex<V> nodo1 = checkVertex(v1);
        ELVertex<V> nodo2 = checkVertex(v2);
        
        if(!nodos.contains(nodo1) || !nodos.contains(nodo2))
            throw new RuntimeException("Rómpete");
        ELEdge<E> arista = new ELEdge<>(nodo1,nodo2,edgeValue);
        if(aristas.contains(arista))
            aristas.remove(arista);
        aristas.add(arista);
        return arista;
    }

    @Override
    public V removeVertex(Vertex<V> vertex) {
        ELVertex<V> nodo = checkVertex(vertex);
        
        
        return null;
        
>>>>>>> origin/main
    }

    @Override
    public E removeEdge(Edge<E> edge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


package material.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

    private ELVertex<V> checkVertex(Vertex<V> v) {
        if(v == null || ! (v instanceof ELVertex))
            throw new RuntimeException("No es un vertice valido");
        else
            return (ELVertex<V>) v;
    }

    private ELEdge<E> checkEdge(Edge<E> e) {
        if(e == null || !(e instanceof ELEdge))
            throw new RuntimeException("No es una arista válida");
        else
            return (ELEdge<E>) e;
    }
    private class ELVertex<K> implements Vertex<K>{
        
        private K element;

        public ELVertex(K element) {
            this.element = element;
        }

        public void setElement(K element) {
            this.element = element;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 47 * hash + Objects.hashCode(this.element);
            return hash;
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
            if (!Objects.equals(this.element, other.element)) {
                return false;
            }
            return true;
        }
        
        @Override
        public K getElement() {
            return element;
        }


}
    private class ELEdge<K> implements Edge<K>{
        private K element;
        private ELVertex origen;
        private ELVertex destino;

        public ELEdge(K element, ELVertex origen, ELVertex destino) {
            this.element = element;
            this.origen = origen;
            this.destino = destino;
        }

        public ELVertex getOrigen() {
            return origen;
        }

        public void setOrigen(ELVertex origen) {
            this.origen = origen;
        }

        public ELVertex getDestino() {
            return destino;
        }
        public void setElement(K e){
            element = e;
        }
        public void setDestino(ELVertex destino) {
            this.destino = destino;
        }

        @Override
        public int hashCode() {
            int hash = 7;
           
            hash = 97 * hash + Objects.hashCode(this.origen);
            hash = 97 * hash + Objects.hashCode(this.destino);
            return hash;
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
           
            if (!Objects.equals(this.origen, other.origen)) {
                return false;
            }
            if (!Objects.equals(this.destino, other.destino)) {
                return false;
            }
            return true;
        }

        @Override
        public K getElement() {
            return element;
        }
        
       
     
       
    
    }
    
    private final Set<Vertex<V>> conjuntoNodos = new HashSet<>();
    private final Set<ELEdge<E>> conjuntoAristas = new HashSet<>();

    
    
    
    @Override
    public Collection<? extends Vertex<V>> vertices() {
      return Collections.unmodifiableCollection(conjuntoNodos);
      
    }

    @Override
    public Collection<? extends Edge<E>> edges() {
        return Collections.unmodifiableCollection(conjuntoAristas);
    }

    @Override
    public Collection<? extends Edge<E>> incidentEdges(Vertex<V> v) {
        ELVertex<V> aux = checkVertex(v);
        if(!conjuntoNodos.contains(aux))
            throw new RuntimeException();
        
        Set<ELEdge<E>> aristasIncidentes = new HashSet<>();
        for (ELEdge<E> e : conjuntoAristas) {
            if(aux == e.getOrigen() || aux == e.getDestino())
                aristasIncidentes.add(e);
        }
        return Collections.unmodifiableCollection(aristasIncidentes); 
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
       ELVertex<V> nodo =  checkVertex(v);
       ELEdge<E> arista = checkEdge(e);
       
       if(!conjuntoAristas.contains(arista) || !conjuntoNodos.contains(nodo))
           throw new RuntimeException("Nodo o arista introducido no valido");
       
       if(arista.getDestino() == nodo)
           return arista.getOrigen();
       else
           return arista.getDestino();
    }

    @Override
    public List<Vertex<V>> endVertices(Edge<E> edge) { //Devuelve los dos vertices que forman parte de una arista
        ELEdge<E> aux = checkEdge(edge);
        ArrayList<Vertex<V>> lista = new ArrayList<>();
        if(aux.getDestino()!= null)
            lista.add(aux.getDestino());
        if(aux.getOrigen() != null)
            lista.add(aux.getOrigen());
        return lista;
       
    }

    @Override
    public Edge<E> areAdjacent(Vertex<V> v1, Vertex<V> v2) {
        ELVertex<V> nodo1 = checkVertex(v1);
        ELVertex<V> nodo2 = checkVertex(v2);
        
        for (ELEdge<E> arista : conjuntoAristas) {
            if(arista.getDestino() == nodo1 || arista.getOrigen() == nodo1){
                if(arista.getDestino() == nodo2 || arista.getOrigen() == nodo2)
                    return arista;
            
            }
        }
        return null;
    }

    @Override
    public V replace(Vertex<V> vertex, V vertexValue) {
       ELVertex<V> nodo = checkVertex(vertex);
       V element = nodo.getElement();
       nodo.setElement(vertexValue);
       return element;
      
       
    }

    @Override
    public E replace(Edge<E> edge, E edgeValue) {
        ELEdge<E> arista = checkEdge(edge);
       E element = arista.getElement();
       arista.setElement(edgeValue);
       return element;
    }

    @Override
    public Vertex<V> insertVertex(V value) {
        ELVertex<V> nodo = new ELVertex<>(value);
        conjuntoNodos.add(nodo);
        return nodo;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeValue) {
        ELVertex<V> nodo1 = checkVertex(v1);
        ELVertex<V> nodo2 = checkVertex(v2);
        ELEdge<E> newArista = new ELEdge<>(edgeValue,nodo1, nodo2);
        conjuntoAristas.add(newArista);
        return newArista;
    }

    @Override
    public V removeVertex(Vertex<V> vertex) {
         ELVertex<V> nodo = checkVertex(vertex);
        Collection<? extends Edge<E>> lista = this.incidentEdges(nodo);
        conjuntoAristas.removeAll(lista);
        conjuntoNodos.remove(nodo);
        return nodo.getElement();
         
         
    }

    @Override
    public E removeEdge(Edge<E> edge) {
         ELEdge<E> arista = checkEdge(edge);
         conjuntoAristas.remove(arista);
         return arista.getElement();
         
       
    }
}

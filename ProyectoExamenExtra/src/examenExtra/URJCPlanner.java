package examenExtra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import material.graphs.BreadthSearch;
import material.graphs.ELGraph;
import material.graphs.Edge;
import material.graphs.Graph;
import material.graphs.Vertex;
import material.utils.Pair;

/**
 *
 * @author mayte
 */
public class URJCPlanner {
    
   
    private Graph<Town,Road> grafo = new ELGraph<>();
    private HashMap<Town, Vertex<Town>> mapa = new HashMap<>();
     /**
     * Create a Town
     * @param townName name of the town
     * @return the created Town
     */
    public Town addTown(String townName) {
        if( townName == null)
            throw new RuntimeException("El nombre no puede ser nulo");
        Town NewTown = new Town(townName);
        Vertex<Town> insertVertex = grafo.insertVertex(NewTown);
        mapa.put(NewTown, insertVertex);
        return NewTown;
    }
    
    /**
     * Connect two towns with a road
     * @param t1 town 1
     * @param t2 town 2
     * @param kms kilometers
     * @return The road that links the two towns
     */
    public Road connectTowns(Town t1, Town t2, int kms) {
       if(t1 == null || t2 == null || mapa.get(t1) == null || mapa.get(t2) == null)
           throw new RuntimeException("Town introducido no existe");
       Road newRoad = new Road(kms);
       grafo.insertEdge(mapa.get(t1), mapa.get(t2), newRoad);
       return newRoad;
    }
    
    /**
     * @param t1 town 1
     * @param t2 town 2
     * @return The road that links the two towns
     */
    public Road getRoad(Town t1, Town t2) {
        Collection<? extends Edge<Road>> incidentEdges = grafo.incidentEdges(mapa.get(t1));
        if(t1 == null || t2 == null || mapa.get(t1) == null || mapa.get(t2) == null)
            throw new RuntimeException("Parámetros no válidos");
        Vertex<Town> Vtown1 = mapa.get(t1); //nodo t1
        Vertex<Town> Vtown2 = mapa.get(t2); //nodo t2
        for (Edge<Road> e : incidentEdges) { //busqueda de todos los edges incidentes en Vtown1
            if(grafo.opposite(Vtown1, e) == Vtown2 ) //Si el nodo opuesto es Vtown2, retorno roud
                return e.getElement();
        }
        return null; //En caso contrario retorno null
    }
    
    /**
     * 
     * @param origin town
     * @param dest town
     * @return The sequence of towns from origin to dest both included.
     */
    public Collection <Pair<Town,Integer>> traceRoute(Town origin, Town dest) {
        BreadthSearch<Town,Road> busqueda = new BreadthSearch<>();
        List<Pair<Town,Integer>> lista = new ArrayList<>();
        
        Vertex<Town> Vorigin = mapa.get(origin);
        Vertex<Town> Vdest = mapa.get(dest);
                
        Vertex<Town> aux = Vorigin;        
        Integer kmAcumulados = 0; //Para acumular los km de las rutas anteriores
        
        List<Edge<Road>> path = busqueda.getPath(grafo, Vorigin, Vdest);
        lista.add(new Pair(aux,kmAcumulados));//Añadimos a la lista el origen desde el que vamos a salir con 0 Kms
        
        
        for (Edge<Road> edge : path) {
            
            aux = grafo.opposite(aux, edge);//Calculo del nodo opuesto al Road
            Pair newPair = new Pair(aux, kmAcumulados += edge.getElement().getKms()); //Guardo los Kms acumulados de las rutas que ya hemos realizado para legar al objetivo
            lista.add(newPair); //Se añade la pareja de destino + Kms acumulados
        }
        return lista;
    }
}

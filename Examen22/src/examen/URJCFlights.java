package examen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import material.graphs.BreadthSearch;
import material.graphs.Edge;
import material.graphs.Graph;
import material.graphs.Vertex;
import material.utils.Pair;

/**
 *
 * @author mayte
 */
public class URJCFlights {
    
    
    /**
     * Adds a new airfield to the company
     * @param novel
     */
    Graph<Pair<Airport,Flight>,Integer> grafo;
    HashMap<Airport, Vertex<Pair<Airport,Flight>>> mapa = new HashMap<>();
    
    public void newAirport(Airport novel){
        if(novel == null)
            throw new RuntimeException("Aeropuerto vacío");
        Pair<Airport,Flight> pair = new Pair<>(novel,null);
        Vertex<Pair<Airport, Flight>> insertVertex = grafo.insertVertex(pair);
        mapa.put(novel, insertVertex);
       
    }
    
    /**
     * Adds new connections between company's airfields 
     * @param novel
     * @param links
     */
    public void newConnection(Airport novel, List<Pair<Airport,Integer>> links){
        if(novel == null || links == null)
            throw new RuntimeException("Aeropuerto o lista invalida");
        for (Pair<Airport, Integer> l : links) {
            if(!mapa.containsKey(l.getFirst()))
                throw new RuntimeException("Aeropuerto no registrado");
            grafo.insertEdge(mapa.get(novel),mapa.get(l.getFirst()) , l.getSecond());
        }
        
        
    }
    
    /**
     * Adds a new flight from the airport passed as a parameter. 
     * The flight can only be added if there is a connection to the destination airport.
     * @param airfield     
     * @param flight     
     */
    public void newFlight(Airport airfield, Flight flight){
        if( grafo.incidentEdges(mapa.get(airfield)).contains(flight.getArrival())){
            mapa.get(airfield).getElement().getFirst().addVuelos(flight);
        }
             
    }
    
    /**
     * Returns the list of all airports to which flights can be added.
     * @param departure
     * @return 
     */
    public List<Airport> availableAirportsConnection(Airport departure){
        Collection<? extends Edge<Integer>> incidentEdges = grafo.incidentEdges(mapa.get(departure));
        List<Airport> lista = new ArrayList<>();
        for (Edge<Integer> i : incidentEdges) {
            lista.add(grafo.opposite(mapa.get(departure), i).getElement().getFirst());
        }
            return lista;
        
        
    }
   
    /**
     * Returns the list of available flights from the airport
     * @param departure     
     * @return      
     */
    public List<Flight> availableFlights(Airport departure){
        return mapa.get(departure).getElement().getFirst().getListaVuelos();
    }
    
    /**
     * Returns the list of flights that are available from the origin airport to the destination airport. 
     * If no flights are available, null is returned.
     * @param departure     
     * @param destination     
     * @return      
     */
    public List<Flight> searchItinerary(Airport departure, Airport destination){
      List<Flight> lista = new ArrayList<>();
      List<Flight> listaAux = new ArrayList<>();
      BreadthSearch<Pair<Airport,Flight>,Integer> search = new BreadthSearch<>();
      List<Edge<Integer>> path = search.getPath(grafo, mapa.get(departure), mapa.get(destination));
      if(path.isEmpty())
          return null;
        Vertex<Pair<Airport, Flight>> aux = mapa.get(departure);
        
      listaAux.addAll(mapa.get(departure).getElement().getFirst().getListaVuelos());
        for (Edge<Integer> edge : path) {
          Vertex<Pair<Airport, Flight>> opposite = grafo.opposite(aux, edge);
          listaAux = opposite.getElement().getFirst().getListaVuelos();
          for (Flight f : listaAux) {
            if(f.getArrival() == aux.getElement().getFirst() && f.getDeparture() == opposite.getElement().getFirst())
                lista.add(f);
        }
        }
        return lista;
    }  
}

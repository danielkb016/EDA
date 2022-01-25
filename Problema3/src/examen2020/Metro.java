package examen2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import material.graphs.BreadthSearch;
import material.graphs.ELGraph;
import material.graphs.Edge;
import material.graphs.Vertex;



/**
 *
 * @author mayte
 */
public class Metro {
    
    private ELGraph<String,Boolean> grafo = new ELGraph<>();
    private HashMap<Integer,Line> mapaLineas = new HashMap<>();
    private HashMap<String, Vertex<String>> mapaPosiciones = new HashMap<>();
    private HashMap< Vertex<String>,String> mapaPosiciones2 = new HashMap<>();
    /**
    * Return the number of lines in the Metro.
    * @return the number of lines. 
    */
    public int numberOfLines(){
      return mapaLineas.size();
    }
    
    /**
    * Get one line.
    * @param i The identifier of the line.
    * @return the Line which is corresponding with the identifier. 
    */
    public Line getLine(int lineNumber){
        return mapaLineas.get(lineNumber);
    }
    
    /**
    * Add a new line to the Metro.
    * @return the identifier of the new line. 
    */
    public int addLine(){
        
        mapaLineas.put(mapaLineas.size()+1, new Line());
        return mapaLineas.size();
    }
    
    /**
    * Add a new station to the line. Is possible that 
    * one station belongs to two lines or more.
    * @param l The identifier of the line.
    * @param station The name of the station.  
    */
    //Añade una nueva estacion a una línea de metro
    public void addStationToLine(int lineNumber, String stationName){
        String estacionAnterior = mapaLineas.get(lineNumber).addEstacion(stationName);
        if(!mapaPosiciones.containsKey(stationName)){
            Vertex<String> insertVertex = grafo.insertVertex(stationName);
            mapaPosiciones.put(stationName, insertVertex);   
            mapaPosiciones2.put(insertVertex,stationName);  
        }
        if(estacionAnterior != null)
            grafo.insertEdge(mapaPosiciones.get(estacionAnterior), mapaPosiciones.get(stationName),Boolean.TRUE );
    }
    
    /**
    * Get the minimum path between two stations.
    * @param startStationName The name of station at the beginning of the way.
    * @param endStationName The name of the final station.
    * @return A list with the sequence of the stations between the first and
    * the last station. 
    */
    public List<String> pathBetweenStations(String startStationName, String endStationName){
        BreadthSearch<String, Boolean> busqueda = new BreadthSearch<>();
        List<Edge<Boolean>> path = busqueda.getPath(grafo, mapaPosiciones.get(startStationName), mapaPosiciones.get(endStationName));
        List<String> lista = new ArrayList<>();
        lista.add(startStationName);
        Vertex<String> nodo = mapaPosiciones.get(startStationName);
        for (Edge<Boolean> edge : path) {
            
            Vertex<String> opposite = grafo.opposite(nodo, edge);
             
                lista.add(mapaPosiciones2.get(opposite));
            
        }
        return lista;
    }
}

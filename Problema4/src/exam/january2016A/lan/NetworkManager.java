package exam.january2016A.lan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import material.graphs.BreadthSearch;
import material.graphs.ELGraph;
import material.graphs.Edge;
import material.graphs.Vertex;


/**
 *
 * @author jvelez
 */
public class NetworkManager {
    private ELGraph<Host, Integer> grafo = new ELGraph<>();
    private HashMap<Host,Vertex<Host>> mapa = new HashMap<>();
    private HashMap<Vertex<Host>,Host> mapa2 = new HashMap<>();
    /**
     * Adds a terminal to the network.
     *
     * @param terminal The terminal to be added.
     * @param router The router in which the terminal is added
     * @param bps The bits per second of the connection between the router and
     * the terminal.
     */
    public void addTerminal(Terminal terminal, Router router, int bps) {
        if( terminal == null || router == null)
            throw new RuntimeException();
        if(!grafo.vertices().contains(mapa.get(router)))
            throw new RuntimeException();
        Vertex<Host> vertice = grafo.insertVertex(terminal);
        mapa.put(router, vertice);
        mapa2.put(vertice, router);
        grafo.insertEdge(vertice, mapa.get(router), bps);
    }

    /**
     * Adds a router to the network
     *
     * @param router The router to be added.
     * @param routerList The router list to which ths router is connected
     * @param bps The bps for each router in routerList
     */
    public void addRouter(Router router, List<Router> routerList, List<Integer> bps) {
       if(  router == null)
            throw new RuntimeException();
       
        Vertex<Host> nodo = grafo.insertVertex(router);
        mapa.put(router, nodo);
        mapa2.put(nodo, router);
        if( routerList != null && !routerList.isEmpty()){
            if(routerList.size() != bps.size())
                throw new RuntimeException();
           Iterator<Integer> it = bps.iterator();
            for (Router r : routerList) {
                grafo.insertEdge(nodo, mapa.get(r),it.next());
                
            }
        }
    }    

    /**
     * @param r
     * @return the routers connected to the router r
     */
    List<Router> getRouters(Router r) {
        Collection<? extends Edge<Integer>> listaAristas = grafo.incidentEdges(mapa.get(r));
        ArrayList<Router> lista = new ArrayList<>();
        for (Edge<Integer> l : listaAristas) {
            Vertex<Host> nodo = grafo.opposite(mapa.get(r), l);
            if(mapa2.get(nodo) instanceof Router){
                lista.add((Router) nodo);
            }   
        }
        return lista;
    }

    /**
     * @param t
     * @return the router connected to the terminal t
     */
    Router getRouter(Terminal t) {
        Collection<? extends Edge<Integer>> listaAristas = grafo.incidentEdges(mapa.get(t));
       
        for (Edge<Integer> l : listaAristas) {
            Vertex<Host> opposite = grafo.opposite(mapa.get(t), l);
            if(mapa2.get(opposite) instanceof Router)
                return (Router) opposite;
        }
        return null;
    }

    /**
     *
     * @param t1
     * @param t2
     * @return Return the number of jumps between t1 and t2
     */
    public int findHops(Terminal t1, Terminal t2) {
        
        BreadthSearch search = new BreadthSearch();
        Vertex<Host> nodo1 = mapa.get(t1);
        Vertex<Host> nodo2 = mapa.get(t2);
        if (nodo1 == null || nodo2 == null)
            throw new RuntimeException();
        return search.getPath(grafo, nodo1, nodo2).size();
        
    }
}

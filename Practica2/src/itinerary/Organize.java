
package itinerary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import material.Pair;

/**
 *
 * @author mayte
 */
public class Organize {
    
    private HashMap<String,String> it = new HashMap<>();
    public Organize (List<Pair<String,String>> lista){
        
        
        for (Pair<String, String> p : lista) {
            it.put(p.getFirst(), p.getSecond());
        }
        
        
        
    }
    
    /**
     * Returns the itinerary to travel or thrown an exception
     * @return 
     */
    public List<String> itineratio(){
        List<String> lista = new ArrayList<>();
        Set<String> keySet = it.keySet();
        String origen = null;
        for (String s : keySet) {       
            if(!it.values().contains(s))
                origen = s;
        }
        lista.add(origen);
        String destino = origen;
        while(it.containsKey(it.get(destino))){
            
            lista.add(it.get(destino));
            destino = it.get(destino);
        }
        lista.add(it.get(destino));
        return lista;
    }
}

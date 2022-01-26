package examen;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mayte
 */
public class Airport {
    private List<Flight> listaVuelos = new ArrayList<>();
    private String nombre;
    Airport(String airport) {
       this.nombre = airport;
    }

    public List<Flight> getListaVuelos() {
        return listaVuelos;
    }

    public void addVuelos(Flight Vuelo) {
       this.listaVuelos.add(Vuelo);
    }
    
    
    
}

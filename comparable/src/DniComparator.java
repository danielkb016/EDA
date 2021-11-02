
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author d.cabezas.2017
 */
public class DniComparator implements Comparator {

    @Override
    public int compare(Object t, Object t1) {
        if (t == null || t1 == null)
            throw new RuntimeException("Es nulo ");
        if (!(t1 instanceof Persona) || !(t instanceof Persona))
            throw new RuntimeException();
        Persona p = (Persona) t;
        Persona p1 = (Persona) t1;
        
        String dni = p.getDni();
        String dni2 = p1.getDni();
        
        if(dni.equals(dni2))
              return 0;
        else 
            return dni.compareTo(dni2);
        
    }

  
}

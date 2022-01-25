package examen2020;

import java.util.ArrayList;



/**
 *
 * @author mayte
 */
public class Line {
   
    private ArrayList<String> linea ;

    public Line() {
        linea = new ArrayList<>();
    }

   

    public String addEstacion (String s){
        String anterior = null; //Para devolver la estacion anterior de la insertada
        if(!linea.isEmpty())
           anterior = linea.get(linea.size()-1);
        linea.add(s);
        return anterior;
    }
    
    /**
     * Return all the names of the stations in the line.
     * @return A string with the sequence of all stations in the line. 
     */
    @Override
    public String toString(){
        return linea.toString();
    }
   
    
}

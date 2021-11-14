/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode;

import java.util.HashMap;

/**
 *
 * @author DANI
 */
public class HashCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Armando", "guerra", 01234567);
        Alumno alumno2 = new Alumno("Elena", "Nito del Bosque", 76543210);
        Alumno alumno3 = new Alumno("Aitor", "Menta", 76543210);
        
        HashMap<Alumno, Float> mapa = new HashMap<>();
    
        mapa.put(alumno1, new Float (7.0));
        mapa.put(alumno2, new Float (8.0));
        mapa.put(alumno3, new Float (9.0));
        mapa.get(alumno1);
    }
    
}

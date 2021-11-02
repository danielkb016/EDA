
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author d.cabezas.2017
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List <Persona> lista = new ArrayList<>();
        Persona p1 = new Persona("Pupu","zas","01234560y",2);
        Persona p2 = new Persona("Popo","lez","01234561q",21);
        Persona p3 = new Persona("Papa","uza","01234562p",20);
        Persona p4 = new Persona("Pepe","pez","01234563a",120);
        Persona p5 = new Persona("Pepe","pez","01234565s",12);
        Persona p6 = new Persona("Pepe","pez","01234564a",190);
             
        lista.add(p1);lista.add(p2);lista.add(p3);lista.add(p4);lista.add(p5);lista.add(p6);
        
        System.out.println("Sin orden \n" + lista.toString());
        Collections.sort(lista);
        System.out.println("Orden edad \n" + lista.toString());
        Collections.sort(lista, new DniComparator());
        System.out.println("Orden DNI \n" + lista.toString());
    }
    
}


import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author d.cabezas.2017
 */
public class Persona implements Comparable{
    
    private final String name,lastName, dni ;
    private int edad;

    public Persona(String name, String lastName, String dni, int edad) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
     public void actualizaEdad() {
        this.edad++;
    }
    
   
    public String getName() {
        return name;
    }

  

    public String getLastName() {
        return lastName;
    }

    

    public String getDni() {
        return dni;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.lastName);
        hash = 59 * hash + Objects.hashCode(this.dni);
        hash = 59 * hash + this.edad;
        return hash;
    }

  

  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
       
        if (Objects.equals(this.dni, other.dni)) {
            return true;
        }else{
             return false;
        }
      
    }

    @Override
    public int compareTo(Object t) { //Devolvemos 0 si son iguales, -1 si el objeto que le pasamos es menor
        if (this == null || ! (t instanceof Persona))
            throw new RuntimeException("Es nulo o no es una persona");
        
        final Persona other = (Persona) t;
        
        if (this.edad == other.getEdad())
            return 0;
        else if (edad < other.getEdad())
             return -1;
        else
             return 1;
    }

    @Override
    public String toString() {
        return  "name= " + name + ", lastName= " + lastName + ", dni= " + dni + ", edad= " + edad + " \n ";
    }
    
    
}

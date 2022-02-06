
package examenExtra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import material.utils.Pair;

/**
 *
 * @author mayte
 */
public class MultidimensionalTable <T> {    
  /*
    HashMap formado por una pareja de integers simulando las coordenadas y un elemento del
    tipo T
  */
    HashMap<Pair<Integer,Integer>,T> matriz = new HashMap<>();
    /**
     * Insert the value passed by parameter in the specified row and column.
     * If the cell contains a previous value, the old value is overwritten.
     * @param row
     * @param col
     * @param value 
     */
    public void insert(int row, int col, T value){
        if(value == null) //Si el valor T es nulo no se acepta, y se lanza una excepción
            throw new RuntimeException("Coordenadas no validas");
        Pair aux = new Pair(row, col);
        if(matriz.containsKey(aux))//Si ya contiene un valor en esas coordenadas, se actualiza el valor
            System.out.println("El valor se va actualizar");
        matriz.put(aux, value); 
        
        for(int i = 0; i < row; i++){ //Rellenamos la matriz hasta las coordenadas introducidas a null
            for(int j = 0; j < col; j++){
                Pair aux2 = new Pair(i,j);
                if(matriz.get(aux2) != null) //Si no tiene ningún elemento lo ponemos a null
                    matriz.put(aux,null);
            }
        }
            
    }

    /**
     * 
     * @param row
     * @param col
     * @return The value stored in the specified row and column or null if the
     * cell is empty. 
     */
    public T get(int row, int col){
        Pair aux = new Pair(row, col);
        if(!matriz.containsKey(aux))
            throw new RuntimeException("Ningún elemento en las coordenadas insertadas");
        return  matriz.get(aux);
    }

    /**
     * @return a pair of integers with the values of the max row and max column
     * of the inserted cells.
     */
    public Pair<Integer,Integer> shape() {
        Integer contRow = 0;
        Integer contCol =0;
        Integer int1 = 0;
        Integer int2 = 0;
        Pair aux1 = new Pair(contCol, 0);
        Pair aux2 = new Pair(0, contRow);
        /* Se recorre la matriz entera, si existe algun elemento que no sea null 
            (inicialmente se inicializan a null hasta las coordenadas introducidas) 
            se gusrdan esas coordenadas y se actualizan hasta encontrar el elemento que mas 
            tamaño de corrdenadas tenga.
        */
        while(matriz.containsKey(aux1)){
            while(matriz.containsKey(aux2)){
                if(matriz.get(aux2) != null)
                    int1 = contRow;
                aux2.setSecond(contRow++);
            }
            if(matriz.get(aux1) != null)
                    int2 = contRow;
            aux1.setSecond(contCol++);
        }
        return new Pair(int1,int2);
    }
    
    /**
     * Delete the value of a cell specified by row and column.
     * @param row
     * @param col
     */
    public void delete(int row, int col){
        Pair aux = new Pair(row, col);
        if(matriz.containsKey(aux))
            matriz.put(aux, null); //Para borrar pondremos el valor a null
    }
    
    /**
     * 
     * @param col The column to be retrieved.
     * @return The column specified in the parameter as a List. 
     */
    public List<T> getColum(int col){
        Integer cont = 0;
        List<T> lista = new ArrayList<>();
        Pair aux = new Pair(cont, col);
        while(matriz.get(aux) != null){
            lista.add(matriz.get(aux));
            aux.setFirst(cont++);
        }
            return lista;
    }

    /**
     * 
     * @param row The row to be retrieved.
     * @return The row specified in the parameter as a List. 
     */
    public List<T> getRow(int row){
         Integer cont = 0;
        List<T> lista = new ArrayList<>();
        Pair aux = new Pair(row, cont);
        while(matriz.get(aux) != null){
            lista.add(matriz.get(aux));
            aux.setSecond(cont++);
        }
            return lista;
    
    }


    /**
     * 
     * @param col The column to be deleted.
     * @return The column specified in the parameter as a List. 
     */
    public void deleteColum(int col){
        Integer cont = 0;
        Pair aux = new Pair(cont, col);
        while(matriz.get(aux) != null){
            matriz.remove(aux); //Para borrar, en este casop eliminaremos completamente las posiciones de la columna
            aux.setFirst(cont++);
        }
            
    }

    /**
     * 
     * @param row The row to be deleted.
     * @return The row specified in the parameter as a List. 
     */
    public void deleteRow(int row){
        Integer cont = 0;   
        Pair aux = new Pair(row, cont);
        while(matriz.get(aux) != null){
            matriz.remove(aux); //Al igual que en el anterior se elimina completamente las posiciones de la fila
            aux.setSecond(cont++);
        }
    }

}

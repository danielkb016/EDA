/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mayte
 */
public class FloatArrayList implements FloatList{
   
    private final Float[] vector;
    private int pos;
    private final int MAX;

    public FloatArrayList(int MAX) {
        this.MAX = MAX;
        vector = new Float[MAX];
        pos = 0;
    }
    
    
    @Override
    public int size() {
        return pos;
    }

    @Override
    public boolean isempty() {
        return pos == 0;
    }

    @Override
    public void add(Float value) {
      if(pos > MAX){
        vector[pos] = value;
        pos++;
      }
    }

    @Override
    public void add(int index, Float value) {
      if(pos < MAX){
          for(int i = pos; i > index; i--){
              vector[i] = vector[i-1];
          }
          vector[index] = value;
          pos++;
      }
    }

    @Override
    public Float remove() {
        if(isempty())
            throw new RuntimeException();
        pos--;
        return vector[pos+1];
    }

    @Override
    public Float remove(int index) {
         if(isempty())
            throw new RuntimeException();
         Float aux = vector[index];
         for(int i = index; i < pos; i++){
             vector[i] = vector [i+1];
         }
         pos--;
         return aux;
    }

    @Override
    public Float get() {
       return vector[pos];
    }

    @Override
    public Float get(int index) {
      return vector[index];
    }

    @Override
    public int search(Float value) {
         if (isempty())
            return 0;
        int cont = 1;
        int i = pos-1;
        while ((i > 0) && (!value.equals(vector[i]))){
            i--;
            cont++;
        }
        if (!value.equals(vector[i]))
            return 0;
        else
            return cont;
    }

    @Override
    public boolean contains(Float value) {
     return search(value) != 0;
    }
    
}

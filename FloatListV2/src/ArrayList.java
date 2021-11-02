
import java.util.Objects;



/**
 *
 * @author mayte
 * @param <F>
 */
public class ArrayList<F> implements List<F>{
    
    private final F[] vector;
    private int pos;
    private final int MAX;
    
    public ArrayList(int tam){
        MAX = tam;
        vector = (F[]) new Object[MAX];
        pos = 0;
    }
    
    @Override
    public int size() {
        return pos;
    }

    @Override
    public boolean isempty() {
        return (pos == 0);
    }

    @Override
    public void add(F value) {
        vector[pos] = value;
        pos++;
    }

    private void limits(int index){
        if ((index < 1) || (index > pos +1 ))
            throw new RuntimeException("The index is out of limits.");
    }
    
    @Override
    public void add(int index, F value) {
        limits(index);
        int mov = pos;
        for(int i = 1; i < index; i++){
            vector[mov] = vector[mov-1];
            mov--;
        }
        vector[mov] = value;
        pos++;
    }

    @Override
    public F remove() {
        if (isempty())
            throw new RuntimeException("It is not allowed remove elements froma empty list.");
        pos--;
        F value = vector[pos];        
        return value;
    }

    @Override
    public F remove(int index) {
        if ((isempty())||(index > pos))
            throw new RuntimeException("This operation can not do it.");
        F value = vector[pos-index];
        for (int i = pos-index; i < (pos-1); i++){
            vector[i] = vector[i+1];
        }
        pos--;
        return value;
    }

    @Override
    public F get() {
        if (isempty())
            throw new RuntimeException("There is not element in the list.");
        return vector[pos-1];
    }

    @Override
    public F get(int index) {
        if ((isempty())||(index > pos))
            throw new RuntimeException("There is not element in the list.");
        return vector[pos-index];
    }

    @Override
    public boolean search(F value) {
        if (isempty())
            return false;
        int cont = 1;
        int i = pos-1;
        while ((i > 0) && (!value.equals(vector[i]))){
            i--;
            cont++;
        }
        if (!value.equals(vector[i]))
            return false;
        else
            return true;
    }

    @Override
    public boolean contains(F value) {
        return (search(value) );
    }

    
    
}

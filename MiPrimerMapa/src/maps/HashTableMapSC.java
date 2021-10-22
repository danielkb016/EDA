package maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * Separate chaining table implementation of hash tables. Note that all
 * "matching" is based on the equals method.
 *
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 * @param <K> The key
 * @param <V> The stored value
 */
public class HashTableMapSC<K, V> implements Map<K, V> {
    
    private class HashEntry<T, U> implements Entry<T, U> {

        private final T key;
        private U value;
        
        
        public HashEntry(T k, U v) {
           key = k;
           value = v;
        }

        @Override
        public U getValue() {
            return value;
        }

        @Override
        public T getKey() {
           return key;
        }

        public U setValue(U val) {
            U aux = value;
            value = val;
            return aux;
        }


        @Override
        public boolean equals(Object o) {
            if (!(o instanceof HashEntry))
                return false;
            HashEntry aux = (HashEntry) o;
            if(!(aux.getKey().getClass() == this.key.getClass()) || !(aux.getValue().getClass() == this.value.getClass()))
            if(aux.getKey().equals(this.key) && ( aux.getValue().equals(this.value)))
                    return true;
           
            return false;
            
            
        }

        

        /**
         * Entry visualization.
         */
        @Override
        public String toString() {
           return key.toString() + " " + value.toString();
        }
    }

    private class HashTableMapIterator<T, U> implements Iterator<Entry<T, U>> {

        //Ejercicio 2.2
        public HashTableMapIterator(ArrayList<HashEntry<T, U>>[] map, int numElems) {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        private void goToNextElement() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public Entry<T, U> next() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public void remove() {
            // NO HAY QUE IMPLEMENTARLO
            throw new UnsupportedOperationException("Not implemented.");
        }
    }

    private class HashTableMapKeyIterator<T, U> implements Iterator<T> {

        public HashTableMapKeyIterator(HashTableMapIterator<T, U> it) {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public void remove() {
            // NO HAY QUE IMPLEMENTARLO
            throw new UnsupportedOperationException("Not implemented.");
        }
    }

    private class HashTableMapValueIterator<T, U> implements Iterator<U> {

        public HashTableMapValueIterator(HashTableMapIterator<T, U> it) {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public U next() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not implemented.");
        }
    }

    /**
     * Creates a hash table
     */
    private  int prime = 109345121;
    private int capacity,size;
    private ArrayList<HashEntry<K,V>> bucket[];
    private int shift,scale;
    
    public HashTableMapSC() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Creates a hash table.
     *
     * @param cap initial capacity
     */
    public HashTableMapSC(int cap) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Creates a hash table with the given prime factor and capacity.
     *
     * @param p prime number
     * @param cap initial capacity
     */
    public HashTableMapSC(int p, int cap) {
       prime = p;
       capacity = cap;
       bucket = new ArrayList[capacity];
    }

    /**
     * Hash function applying MAD method to default hash code.
     *
     * @param key Key
     * @return
     */
    protected int hashValue(K key) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Returns the number of entries in the hash table.
     *
     * @return the size
     */
    @Override
    public int size() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Returns whether or not the table is empty.
     *
     * @return true if the size is 0
     */
    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Returns the value associated with a key.
     *
     * @param key
     * @return value
     */
    @Override
    public V get(K key) throws IllegalStateException {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Put a key-value pair in the map, replacing previous one if it exists.
     *
     * @param key
     * @param value
     * @return value
     */
    @Override
    public V put(K key, V value) throws IllegalStateException {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Removes the key-value pair with a specified key.
     *
     * @param key
     * @return
     */
    @Override
    public V remove(K key) throws IllegalStateException {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Returns an iterable object containing all of the keys.
     *
     * @return
     */
    @Override
    public Iterable<K> keys() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Returns an iterable object containing all of the values.
     *
     * @return
     */
    @Override
    public Iterable<V> values() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Returns an iterable object containing all of the entries.
     *
     * @return
     */
    @Override
    public Iterable<Entry<K, V>> entries() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Determines whether a key is valid.
     *
     * @param k Key
     */
    protected void checkKey(K k) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Increase/reduce the size of the hash table and rehashes all the entries.
     * @param newCap
     */
    protected void rehash(int newCap) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

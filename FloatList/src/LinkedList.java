
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DANI practica examen modificado
 */
public class LinkedList implements FloatList{
    private int size;
    private FloatNode head;
    
    private class FloatNode{
        private Float element;
        private FloatNode next;

        public FloatNode(Float element, FloatNode next) {
            this.element = element;
            this.next = next;
        }

        public Float getElement() {
            return element;
        }

        public void setElement(Float element) {
            this.element = element;
        }

        public FloatNode getNext() {
            return next;
        }

        public void setNext(FloatNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "FloatNode{" + "element=" + element + ", next=" + next + '}';
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
            final FloatNode other = (FloatNode) obj;
            if (!Objects.equals(this.element, other.element)) {
                return false;
            }
            return true;
        }
        
    }

    public LinkedList() {
           this.head = null;
        this.size = 0;
    }
   
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isempty() {
        return this.size == 0;
    }

    @Override
    public void add(Float value) {
        FloatNode aux = new FloatNode(value, head);
        head = aux;
        size++;
        
    }

    @Override
    public void add(int index, Float value) {
        if ( index >= size || index < 0 )
               throw new RuntimeException();
        FloatNode node = new FloatNode(value,null);  
        FloatNode aux = head;
        for(int i = 0; i < index -1 ; i++){
            aux = aux.next;           
        }
        
        node.next = aux.next;
        aux.next = node;
        

    }

    @Override
    public Float remove() {
        if ( isempty() ){
            throw new RuntimeException();
        }
        FloatNode aux = head;
        head = head.next;
        size--;
        return aux.element;
    }

    @Override
    public Float remove(int index) {
        if ( index >= size )
               throw new RuntimeException();
        FloatNode aux = head;
        FloatNode prev = null;
        for(int i = 0; i < index ; i++){
            prev = aux; 
            aux = head.next;
             
        }
        prev.next = aux.next;
        return aux.getElement();
        
    }

    @Override
    public Float get() {
       if (isempty())
           throw new RuntimeException();
        return this.head.getElement();
    }

    @Override
    public Float get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(Float value) {
        boolean encontrado = false;
        
        if (isempty())
             throw new RuntimeException();
        FloatNode aux = head;
        while ( encontrado == false && aux.next != null){
            if (aux.element.equals(value))
                encontrado = true;
            else
                 aux = aux.next;
            
        
        }
            return encontrado;
        
    }

    @Override
    public boolean contains(Float value) {
        return search(value);
    }

    @Override
    public String toString() {
        return "LinkedList{" + "size=" + size + ", head=" + head + '}';
    }
    
}

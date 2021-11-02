/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mayte
 */
public class FloatLinkedList implements FloatList{

    private class FloatNode{ //Creación de clase interna privada (solo visible dentro de la clase) para el nodo
        private float element;
        private FloatNode next;
        public FloatNode(float e, FloatNode n){
            this.element = e;
            this.next = n;
        }

        public float getElement() {
            return element;
        }

        public void setElement(float element) {
            this.element = element;
        }

        public FloatNode getNext() {
            return next;
        }

        public void setNext(FloatNode next) {
            this.next = next;
        }
        
    }         
      
    private FloatNode head;
    private int size;
    
    public FloatLinkedList(){
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
        FloatNode node = new FloatNode(value,this.head);
        this.head = node;
        size++;
    }

    @Override
    public void add(int index, Float value) {
        if (index <= 0 || index > this.size + 1 )
            throw new RuntimeException("posicion no valida");
        
        if (index == 1){
            add(value);
        }
            
        else{
               FloatNode aux = this.head;
               for (int i=1;i<=index-1;i++){
                   aux = aux.next;
                
               }
               FloatNode node = new FloatNode(value,aux.next);
            aux.next=node;
            size++;
                
        }
                
        
        
    
    }

    @Override
    public Float remove() {
        if (this.isempty()) 
            throw new RuntimeException("Lista vacia");
       
        FloatNode node = this.head;
        size--;
        this.head = node.next;
        return node.element;
        
    }

    @Override
    public Float remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Float get() {
        if (this.isempty()) 
            throw new RuntimeException("Lista vacia");
       
        return head.element;
    }

    @Override
    public Float get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(Float value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Float value) {
        return search(value) ;
    }
    
}

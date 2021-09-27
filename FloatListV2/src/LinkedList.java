/**
 *
 * @author mayte
 * @param <F>
 */
public class LinkedList<F> implements List<F>{



    private class Node<T>{
       
        private T elem;
        private Node next;

        public T getElem() {
            return elem;
        }

        public void setElem(T elem) {
            this.elem = elem;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
        
        public Node(T e, Node sig){
            this.elem = e;
            this.next = sig;
        }        
             
    }
    
    private Node<F> forward(int index){
        if ((index < 1) || (index > (size + 1)))
            throw new RuntimeException("The index is out of limits.");
        Node ant = null;
        Node act = head;
        for (int i = 1; i < index; i++){
            ant = act;
            act = act.getNext();
        }
        return ant;
    }
    
    private int size;
    private Node<F> head;
    
    public LinkedList(){
        this.size = 0;
        this.head = null;
    }
    
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isempty() {
        return (this.size == 0);
    }

    @Override
    public void add(F value) {
        Node aux = new Node(value, head);
        this.head = aux;
        this.size++;
    }

     
    @Override
    public void add(int index, F value) {
        Node ant = forward(index);
        if (ant == null)
            add(value);
        else{
            Node aux = new Node(value, ant.getNext());
            this.size++;
            ant.setNext(aux);
        }          
    }

    @Override
    public F remove() {
        if (this.isempty())
            throw new RuntimeException("It is not allowed remove elements from a empty list.");
        Node aux = head;
        size--;
        head = head.getNext();
        return (F) aux.getElem();
    }

    
    @Override
    public F remove(int index) {
        Node ant = forward(index);
        if (ant == null)
            return remove();
        else{
            this.size--;
            Node aux = ant.getNext();
            ant.setNext(aux.getNext()); 
            return (F) aux.getElem();
        }
    }

    @Override
    public F get() {
        if (this.isempty())
             throw new RuntimeException("The index is out of limits.");
        return head.getElem();
    }

    @Override
    public F get(int index) {
        Node ant = forward(index+1);
        return (F) ant.getElem();        
    }

    @Override
    public int search(F value) {
        if (isempty())
            return 0;
        Node aux = head;
        int i = 1;
        while ((i < size) && (!aux.getElem().equals(value))){
            aux = aux.getNext();
            i++;
        }
        if ((i < size)||(aux.getElem().equals(value)))
            return i;
        return 0;
    }

    @Override
    public boolean contains(F value) {
       return (search(value) != 0);
    }
    
}

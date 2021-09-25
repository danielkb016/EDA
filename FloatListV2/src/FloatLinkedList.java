/**
 *
 * @author mayte
 */
public class FloatLinkedList implements FloatList{

    private class FloatNode{
       
        private Float elem;
        private FloatNode next;

        public Float getElem() {
            return elem;
        }

        public void setElem(Float elem) {
            this.elem = elem;
        }

        public FloatNode getNext() {
            return next;
        }

        public void setNext(FloatNode next) {
            this.next = next;
        }
        
        public FloatNode(Float e, FloatNode sig){
            this.elem = e;
            this.next = sig;
        }        
             
    }
    
    private FloatNode forward(int index){
        if ((index < 1) || (index > (size + 1)))
            throw new RuntimeException("The index is out of limits.");
        FloatNode ant = null;
        FloatNode act = head;
        for (int i = 1; i < index; i++){
            ant = act;
            act = act.getNext();
        }
        return ant;
    }
    
    private int size;
    private FloatNode head;
    
    public FloatLinkedList(){
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
    public void add(Float value) {
        FloatNode aux = new FloatNode(value, head);
        this.head = aux;
        this.size++;
    }

     
    @Override
    public void add(int index, Float value) {
        FloatNode ant = forward(index);
        if (ant == null)
            add(value);
        else{
            FloatNode aux = new FloatNode(value, ant.getNext());
            this.size++;
            ant.setNext(aux);
        }          
    }

    @Override
    public Float remove() {
        if (this.isempty())
            throw new RuntimeException("It is not allowed remove elements from a empty list.");
        FloatNode aux = head;
        size--;
        head = head.getNext();
        return aux.getElem();
    }

    
    @Override
    public Float remove(int index) {
        FloatNode ant = forward(index);
        if (ant == null)
            return remove();
        else{
            this.size--;
            FloatNode aux = ant.getNext();
            ant.setNext(aux.getNext()); 
            return aux.getElem();
        }
    }

    @Override
    public Float get() {
        if (this.isempty())
             throw new RuntimeException("The index is out of limits.");
        return head.getElem();
    }

    @Override
    public Float get(int index) {
        FloatNode ant = forward(index+1);
        return ant.getElem();        
    }

    @Override
    public int search(Float value) {
        if (isempty())
            return 0;
        FloatNode aux = head;
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
    public boolean contains(Float value) {
       return (search(value) != 0);
    }
    
}

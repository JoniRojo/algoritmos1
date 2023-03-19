package practica2.Colas;

public class ColaLista<T> implements Cola<T> {
    private Nodo<T> front;
    private Nodo<T> back;
    private int size;

    /*
     * [front          back] 
     * front back a puntan a lo mismo al principio
     * para encolar back -> ultimo hasta el momento, dps utlhastael monete -> utlimoposta y back tmb lo apunta
     * para desencolar front -> front.getnext
     */
    public ColaLista(){
        front = back = null;
        size = 0;
    }

    public boolean esVacia() {
        return size==0;
    }

    public void vaciar() {
        front = back = null;
        size = 0;
    }

    public T getTope() {
        return front.getItem();
    }

    public void encolar(T x) {
        if(esVacia()){
            front = back = new Nodo<T>(x);
        }else{
            back.setNext(new Nodo<T>(x));
            back= back.getNext();
        }
        size ++;
    }

    public T desencolar() {
        if(esVacia()){
            throw new IllegalStateException("La cola esta vacia!");
        }
        T bye = front.getItem();
        front = front.getNext();
        size --;
        return bye;
    }

    @Override
    public String toString(){
        Nodo<T> temp = front;
        String rdo = "[ ";
        for(int i=0;i<size;i++){
            rdo = rdo + (temp.getItem().toString());
            if(temp.getNext() != null){
                rdo = rdo + " , ";
                temp =  temp.getNext();
            }
        }
        rdo = rdo + " ]";
        return rdo;
    }
}
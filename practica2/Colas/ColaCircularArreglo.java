package practica2.Colas;

public class ColaCircularArreglo<T> implements Cola<T> {

    private static final int MAX=5;
    private T[] arreglo;
    private int size;
    private int init;   //comienzo de la cola
    private int end;    //apunta al primer lugar libre

    @SuppressWarnings("unchecked")

    public ColaCircularArreglo(){
        arreglo = (T []) new Object[MAX];
        init = end = size = 0;
    }

    public boolean esVacia() {
        return size==0;
    }

    public boolean estaLlena() {
        return size==MAX;
    }

    public void vaciar() {
        init = end = size = 0;
    }

    public T getTope() {
        if( esVacia()){
            throw new IllegalStateException("La pila esta vacia!");
        }
        return arreglo[init];
    }

    public int getInit(){
        return init;
    }
    
    public int getEnd(){
        return end;
    }

    public void encolar(T x) {
        if( size == MAX){
            throw new IllegalStateException("La cola esta llena!");
        }
        size++;
        arreglo[end]=x;     //end apunta al primer lugar libre
        end= (end+1) % MAX; //Aritmetica modular, end ahora apunta a end + 1 modulo el tamaño del arreglo
    }

    public T desencolar() {
        if( esVacia()){
            throw new IllegalStateException("La pila esta vacia!");
        }
        T bye = arreglo[init];
        init = (init+1) % MAX; //Aritmetica modular
        size--;
        return bye;
    }

    @Override
    public String toString(){
        String rdo = "[ ";
        int i;
        for(i=0; i<(size-1); i++){
            rdo = rdo + arreglo[i] + " | ";
        }
        if( size>0 ){
            rdo += arreglo[i] + " ]";
        }else{
            rdo = "[ ]";
        }
        return rdo;
    }

}

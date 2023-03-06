package practica2.Pilas;

public class PilaArreglo<T> implements Pila<T> {

    public static final int MAX=23;
    private T[] arreglo;
    private int elementos;

    @SuppressWarnings ("unchecked")
    public PilaArreglo(int capacidad){
        arreglo = (T []) (new Object[capacidad]);
        elementos = capacidad;
    }

    @SuppressWarnings ("unchecked")
    public PilaArreglo(){
        this(MAX);
        arreglo = (T []) (new Object[MAX]);
    }

    public boolean esVacia() {        
        return elementos == 0;
    }

    public void vaciar() {
        elementos=0;
        
    }

    public int longitud() {
        return elementos;
    }

    public void apilar(T n) {
        if(elementos == MAX){
            throw new IllegalStateException("La lista esta llena");
        }
        arreglo[elementos]=n; 
        elementos++;
    }

    public T desapilar() {
        if(!esVacia()){
            T desapilado = elemento(elementos-1);
            elementos--;
            return desapilado;
        }
        throw new IllegalStateException("La pila esta vacia");
    }

    @Override
    public T tope() {
        return arreglo[elementos-1];
    }

    @Override
    public String toString(){
        String rdo = "[ ";
        int i;
        for ( i = 0; i<elementos-1; i++){
            rdo = rdo + elemento(i) + " | ";
        }
        if(!esVacia()){
            rdo = rdo + elemento(i) + " ]";

        }else{
            rdo = "[ ]";
        }
        return rdo;
    }

    private T elemento(int index) {
        return (T) arreglo[index];
    }
}
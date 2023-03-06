package practica2.Pilas;

public class PilaArregloMem<T> implements Pila<T> {

    public static final int CAP_POR_DEF=20;
    private T[] arreglo;
    private int elementos;

    @SuppressWarnings ("unchecked")
    public PilaArregloMem(int capacidad){
        arreglo = (T []) (new Object[capacidad]);
        elementos = capacidad;
    }

    public PilaArregloMem(){
        this(CAP_POR_DEF);  //notar que este this llama al constructor anterior
    }

    @Override
    public T tope() {
        return arreglo[elementos-1];
    }

    public boolean esVacia() {        
        return elementos == 0;
    }

    public boolean estaLlena(){
        return elementos == arreglo.length;
    }

    public void vaciar() {
        elementos=0;
        
    }

    public int longitud() {
        return elementos;
    }

    public void apilar(T n) {
        if(estaLlena()){
            duplicar();
        }
        arreglo[elementos]=n; 
        elementos++;
    }

    @SuppressWarnings ("unchecked")
    private void duplicar(){
        Object[] temp = new Object[arreglo.length*2];    //podría aumentar menos el tamaño: sumando 10 por ejemplo
        System.arraycopy(arreglo, 0, temp, 0, arreglo.length); //copiame de arreglo, desde la pos 0 a temp en la pos 0, tantos elementos
        arreglo = (T[]) temp;
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

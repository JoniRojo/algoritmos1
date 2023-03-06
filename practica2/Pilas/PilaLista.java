package practica2.Pilas;

public class PilaLista<T> implements Pila<T> {

    private Nodo<T> tope;
    private int elementos;

    public PilaLista(){
        tope = null;
        elementos = 0;
    }

    public T tope(){
        return tope.getElem();
    }

    public boolean esVacia(){
        return (tope==null);
    }


    //el tope apunta al nuevo y el nuevo apunta al viejo
    public void apilar(T elem){
        Nodo<T> aux = new Nodo<>();
        aux.setElemento(elem);
        aux.setSiguiente(tope);
        tope=aux;
        elementos++;
    }

    public T desapilar(){
        if(esVacia())
            throw new IllegalStateException("desapilar: Pila vacia");
        T returnValue = tope.getElem();
        tope = tope.getSiguiente();
        elementos--;
        return returnValue;
    }

    public void vaciar() {
        elementos = 0;
        tope = null;
    }

    public int longitud() {
        return elementos;
    }

    public void mostrar(){
        Nodo<T> auxx = tope;
        System.out.println("{");
        while(auxx != null){
            System.out.println((auxx.getElem()).toString());
            auxx= auxx.getSiguiente();
        }
        System.out.println("}");
    }
    
}

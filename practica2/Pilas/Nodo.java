package practica2.Pilas;
//Uso para PilaLista
public class Nodo<T> {
    
    private Nodo<T> siguiente;
    private T elemento;

    public Nodo(){
        siguiente = null;
        elemento = null;
    }

    public Nodo(T e){
        siguiente = null;
        elemento = e;
    }

    public void setSiguiente(Nodo<T> siguiente2){
        siguiente = siguiente2;
    }

    public void setElemento(T elem){
        elemento = elem;
    }

    public Nodo<T> getSiguiente(){
        return siguiente;
    }

    public T getElem(){
        return elemento;
    }
}

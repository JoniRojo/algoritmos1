package practica2.Colas;

public class Nodo<T>{

    private Nodo<T> next;
    private T item;

    public Nodo(){
        next=null;
        item=null;
    }

    public Nodo(T e){
        next = null;
        item = e;
    }

    public void setNext(Nodo<T> next2){
        next = next2;
    }

    public void setItem(T elem){
        item=elem;
    }

    public Nodo<T> getNext(){
        return next;
    }

    public T getItem(){
        return item;
    }

}

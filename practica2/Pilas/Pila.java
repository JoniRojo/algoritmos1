package practica2.Pilas;

public interface Pila<T> {
    // PILA ultimo en entrar, primero en salir
    //Devuelve el tope de la pila
    public T tope();
    //true si la pila esta vacia
    public boolean esVacia();
    //vacia la pila
    public void vaciar();
    //devuelve la longitud de la pila
    public int longitud();
    // dado un elemento n de tipo generico T, lo apila en la pila
    public void apilar(T n);
    // desapila el tope de la pila
    public T desapilar();
}
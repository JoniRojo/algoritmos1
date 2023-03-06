package practica2.Colas;

public interface Cola<T> {
    //Primero que entra primero que sale
    //True si esta vacia la lista
    public boolean esVacia();
    //Agrega un elem a la cola, por la entrada
	public void encolar(T x);
    //Saca un elem de la cola por la salida
	public T desencolar();
    //Da el elemento del frente/tope
	public T getTope();
    //Vacia la cola
	public void vaciar();
}

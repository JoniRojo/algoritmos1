package practica5.Arboles.AVL;

public interface IDiccionario<T extends Comparable<?super T>> {
    public void insert(T x);
    public void remove(T x);
    public T search(T x);
}

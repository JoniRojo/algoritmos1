package practica5.Arboles.ABB;

//import abb.NodeTree;   ??

public interface IDiccionario<T extends Comparable<?super T>> {
    public void insert(T x);
    public void remove(T x);
    public T search(T x);
}

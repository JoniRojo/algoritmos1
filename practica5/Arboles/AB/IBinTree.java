package practica5.Arboles.AB;

import java.util.List;

public interface IBinTree<T extends Comparable <? super T>>{
    //Interface de un Arbol Binario
    public boolean isEmpty();
    public void clear();
    public int size();
    public int height();
    public T root();
    public List<T> toListInOrder();
    public List<T> toListPreOrder();
    public List<T> toListPostOrder();
    public boolean repOK();
}

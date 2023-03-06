package practica5.Arboles.ANario;

import java.util.List;

public interface INTree<T extends Comparable<? super T>> {
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

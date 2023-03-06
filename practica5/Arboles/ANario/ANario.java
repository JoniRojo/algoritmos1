package practica5.Arboles.ANario;

import java.util.List;

public class ANario<T extends Comparable<? super T>> implements INTree<T> {
    
    private NodeNario<T> root;
    private int size;

    public ANario(){
        root=null;
        size=0;
    }

    public ANario(T elem){
        root= new NodeNario<T>(elem);
        size=1;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        root=null;
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    //Calcular la altura, medio un bardo
    @Override
    public int height() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public T root() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> toListInOrder() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> toListPreOrder() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> toListPostOrder() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean repOK() {
        // TODO Auto-generated method stub
        return false;
    }
    
}

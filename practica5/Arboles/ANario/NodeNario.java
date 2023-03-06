package practica5.Arboles.ANario;

import java.util.List;

public class NodeNario<T> {
    private T value;                        //raiz
    private List<NodeNario<T>> children;    //lista de sus hijos

    public NodeNario(T value) {
        this.value = value;
    }

    public NodeNario(T value, List<NodeNario<T>> children) {
        this.value = value;
        this.children =  children;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<NodeNario<T>> getChildren() {
        return children;
    }

    public void setRight(List<NodeNario<T>> children) {
        this.children = children;
    }
}
package practica5.Arboles.AB;

public class NodeTree<T> {
    //Atributos de un nodo
    private T value;    //su valor
    private NodeTree<T> left;   //sus hijos
    private NodeTree<T> right;

    //Constructores
    public NodeTree(T value) {
        this.value = value;
    }

    public NodeTree(T value, NodeTree<T> left, NodeTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    //Geters y seters de value left y right
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeTree<T> getLeft() {
        return left;
    }

    public void setLeft(NodeTree<T> left) {
        this.left = left;
    }

    public NodeTree<T> getRight() {
        return right;
    }

    public void setRight(NodeTree<T> right) {
        this.right = right;
    }
}


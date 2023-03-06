package practica5.Arboles.ABB;

public class NodeTree<T> {
    private T value;
    private NodeTree<T> left;
    private NodeTree<T> right;

    public NodeTree(T value) {
        this.value = value;
    }

    public NodeTree(T value, NodeTree<T> left, NodeTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

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

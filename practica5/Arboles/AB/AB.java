package practica5.Arboles.AB;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AB<T extends Comparable<? super T>> implements IBinTree<T> {
    //Atributos
    private NodeTree<T> root;
    private int size;

    //Constructores
    public AB(){
        root = null;
        size = 0;
    }

    public AB(T elem){
        root = new NodeTree<T>(elem);
        size = 1;
    }

    public AB(T elem, AB<T> left, AB<T> right){
        root = new NodeTree<T>(elem, left.root, right.root);    //le doy el root de cada subarbol
        size = 1 + left.size + right.size;
    }

    //Metodos

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        return height2(root);
    }

    private int height2(NodeTree<T> root) {
        if(root == null){
            return 0;
        }
        int altura = (1 + Math.max(height2(root.getLeft()), height2(root.getRight())));
        return altura;     //1 + max entro la altura de los hijos
    }

    @Override
    public T root() {
        return root.getValue();
    }

    public NodeTree<T> getRoot() {
        return root;
    }
    
    //________________________________Pre, primero la raiz_______________________________________________________________________
    //Recursivo
    @Override
    public List<T> toListPreOrder() {
        return toListPreOrder(root,new LinkedList<T>());
    }

    public List<T> toListPreOrder(NodeTree<T> root, List<T> elements) {
        if(root!=null){
         elements.add(root.getValue());
            toListPreOrder(root.getLeft(), elements);
            toListPreOrder(root.getRight(),elements);
        }
        System.out.println(elements.toString());
        return elements;
    }
    //Iterativo
    public List<T> toListPreOrder2(NodeTree<T> root, List<T> elements) {
        //Para iterar en arboles, usare pilas
        Stack<NodeTree<T>> stack = new Stack<>();
        if(root == null){
            return elements;                                 
        }
        stack.push(root);
        while(!stack.isEmpty()){
            //Saco la raiz de la pila, guardandola en elements
            NodeTree<T> actual = stack.pop();
            elements.add(actual.getValue());
            //Primero pongo el hd ya que es una pila, si lo ultimo que apilo es un hi eso es lo que voy a popear dps primero
            if(actual.getRight()!=null){
                stack.push(actual.getRight());
            }
            if(actual.getLeft()!=null){
                stack.push(actual.getLeft());
            }
            //Entonces dps se va a popear el hi y asi hasta que no queden mas hi, luego,
            //como es una pila van a quedar para popearse los hd y al final el hd del root, y asi hasta que termine el lado derecho
        }
        System.out.println(elements.toString());
        return elements;
    }

    //________________________________InOrder, el medio la raiz__________________________________________________________________
    //Recursivo
    @Override
    public List<T> toListInOrder(){
        return toListInOrder(root, new LinkedList<>());
    }

    public List<T> toListInOrder(NodeTree<T> root, List<T> elements) {
        if(root != null){
            toListInOrder(root.getLeft(), elements);
         elements.add(root.getValue());
            toListInOrder(root.getRight(), elements);
        }
        System.out.println(elements.toString());
        return elements;
    }

    //Iterativo
    public List<T> toListInOrder2(NodeTree<T> root, List<T> elements){
        //Para iterar en arboles, usare pilas
        Stack<NodeTree<T>> stack = new Stack<>();
        if(root == null){
            return elements;                                 
        }
        stack.push(root);
        NodeTree<T> actual = root;
        while(!stack.isEmpty()){
            while(actual.getLeft()!=null){
                stack.push(actual.getLeft());
                actual = actual.getLeft();
            }
            //notar como el actual se va a quedar con null y no va a volver a pushear a la pila algo del hi
            //obvio dps cuando el actual tenga otro root, bueno ahi si
            actual = stack.pop();
            elements.add(actual.getValue());

            if(actual.getRight()!=null){
                stack.push(actual.getRight());
                actual = actual.getRight();
            }
        }
        System.out.println(elements.toString());
        return elements;
    }
    //________________________________Post, al final la raiz_______________________________________________________________________
    //Recursivo
    @Override
    public List<T> toListPostOrder() {
        return toListPostOrder(root,new LinkedList<T>());
    }

    public List<T> toListPostOrder(NodeTree<T> root, List<T> elements) {
        if(root!=null){
            toListPostOrder(root.getLeft(),elements);
            toListPostOrder(root.getRight(),elements);
            elements.add(root.getValue());
        }
        System.out.println(elements.toString());
        return elements;
    }

    //Iterativo
    public List<T> toListPostOrder2(NodeTree<T> root, List<T> elements) {
        Stack<NodeTree<T>> stack = new Stack<>();
        if(root == null){
            return elements;                                 
        }
        stack.push(root);
        NodeTree<T> actual = root;
        while(!stack.isEmpty()){
            if(actual.getRight()!=null){
                stack.push(actual.getRight());
            }
            if(actual.getLeft()!=null){
                stack.push(actual.getLeft());
            }
            actual = stack.pop();
            elements.add(actual.getValue());
        }
        System.out.println(elements.toString());
        return elements;
    }
    //______________________________________________________________________________________________________________________________
    @Override
    public boolean repOK() {
        return true;
    }

    @Override
    public String toString(){
        return toListInOrder().toString();
    }
}

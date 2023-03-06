package practica5.Arboles.AVL;

import java.util.LinkedList;
import java.util.List;

public class AVL<T extends Comparable<? super T>> implements IDiccionario<T>, IBinTree<T> {
    //Atributos
    private NodeTree<T> root;
    private int size;

    //Contructor
    public AVL(){           //AVL inicializado
        root=null;
        size=0;
    }

    public AVL(T elem){                     //ABB/AVL con raiz
        root = new NodeTree<T>(elem);
        size = 1;
    }

    //Metodos
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

    @Override
    public int height() {
        return height2(root);
    }

    private int height2(NodeTree<T> root){
        if(root == null)
            return 0;
        return 1 + Math.max(height2(root.getLeft()),height2(root.getRight()));      //1 + max entro la altura de los hijos
    }

    @Override
    public T root() {
        return root.getValue();
    }

    @Override
    public List<T> toListInOrder() {
        return toListInOrder(root, new LinkedList<>());
    }

    private List<T> toListInOrder(NodeTree<T> root, LinkedList<T> elements){
        if(root!=null){
            toListInOrder(root.getLeft(), elements);
            elements.add(root.getValue());
            toListInOrder(root.getRight(), elements);
        }

        return elements;
    }

    @Override
    public List<T> toListPreOrder() {
        return toListPreOrder(root, new LinkedList<>());
    }

    private List<T> toListPreOrder(NodeTree<T> root, LinkedList<T> elements){
        if(root!=null){
            elements.add(root.getValue());
            toListPreOrder(root.getLeft(), elements);
            toListPreOrder(root.getRight(), elements);
        }

        return elements;
    }

    @Override
    public List<T> toListPostOrder() {
        return toListPostOrder(root, new LinkedList<>());
    }

    private List<T> toListPostOrder(NodeTree<T> root, LinkedList<T> elements){
        if(root!=null){
            toListPostOrder(root.getLeft(), elements);
            toListPostOrder(root.getRight(), elements);
            elements.add(root.getValue());
        }

        return elements;
    }

    @Override
    public boolean repOK() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'repOK'");
    }

    @Override
    public void insert(T x){
        if(isEmpty()){
            root = new NodeTree<T>(x);
            size = 1;
        }else{
            insert(x,root);
        }
    }

    private void insert(T x, NodeTree<T> root) {
        if(x.compareTo(root.getValue()) < 0){   // x < root inserto lado izq
            if(root.getLeft() == null){
                root.setLeft(new NodeTree<T>(x));
                size++;
            }else
                insert(x, root.getLeft());     
        }    
        if(x.compareTo(root.getValue()) > 0){       // x > root inserto lado der
            if(root.getRight() == null){
                root.setRight(new NodeTree<T>(x));
                size++;
            }else
                insert(x, root.getRight());   
        }
        //si es el root, no hago nada
    }

    private void balancear(NodeTree<T> root) {
        
    }

    private int factorBalanceo(NodeTree<T> root){
        return ((height2(root.getLeft()))-(height2(root.getRight())));
    }

    private NodeTree<T> rotateRight(NodeTree<T> root){
        NodeTree result = root.getLeft();       //Paso 1 del profe   Result apunte al hi del root
        root.setLeft(result.getRight());      //Paso 2              hi del root sea el hd del result
        result.setRight(root);              //Paso 3                hd de result sea lo que apunta root
        return result;
    }

    private NodeTree<T> rotateLeft(NodeTree<T> root){
        NodeTree result = root.getRight();     //Paso 1 
        root.setRight(result.getLeft());       //Paso 2
        result.setLeft(root);                  //Paso 3
        return result;
    }

    @Override
    public void remove(T x) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public T search(T x) {
        return search(x, root);
    }

    private T search(T x, NodeTree<T> root) {
        if(root==null) return null;                         //buscar en un arbol vacio...
        if(x.compareTo(root.getValue())<0) return search(x, root.getLeft());        //el que busco es mas chico que mi raiz, busco a mi izq
        if(x.compareTo(root.getValue())>0) return search(x, root.getRight());       // ...
        return root.getValue();                             //cuando llegue aca, es xq lo encontre, y es mi root
    }

    @Override
    public String toString(){
        return new StringBuilder().append(toListInOrder()).toString();
    }

}
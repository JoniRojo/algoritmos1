package practica5.Arboles.ABB;

import java.util.LinkedList;
import java.util.List;

public class ABB<T extends Comparable <? super T>> implements IDiccionario<T>, IBinTree<T>  {
    //Atributos
    private NodeTree<T> root;
    private int size;

    //Constructores
    public ABB(){
        root = null;
        size = 0;
    }

    public ABB(T elem){
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

    //Recorridos recursivos
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
        return false;
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

    @Override
    public void remove(T x) {
        remove(x, root);
    }

    private NodeTree<T> remove (T x, NodeTree<T> root){
        if(isEmpty())
            throw new IllegalArgumentException("element not found");
        if(x.compareTo(root.getValue())<0)
            root.setLeft(remove(x, root.getLeft()));        //root.setLeft importantisimo, se va construyendo
        else if(x.compareTo(root.getValue())>0)
            root.setRight(remove(x, root.getRight()));
        else{       //no esta a la izq, no esta a la derecha, lo encontre!
                    //ahora solo debo ver como acomodo el arbol
            size --;
            if(root.getLeft() != null && root.getRight() != null){      //tengo tanto hi como hd, o subo el max del hi, o el min del hd
                root.setValue(findMin(root.getRight()).getValue());     //si subimos el min del hd
                root.setRight(removeMin(root.getRight()));              //dps hay que removerlo
            }else if(root.getLeft() != null){    //si izq hay algo y llego hasta este if, a la der no hay nada
                root=root.getLeft();            //por lo que debo pasar esto de izq arriba(al root actual)
            }else{
                root=root.getRight();       //si llego hasta, entonces a izq no habia nada, debo subir el hd al root actual, 
            }                               //si a la der no hay nada, entonces el que tengo que eliminar es una hoja, y esta bien que suba null
        }
        return root;                    //retorno root, que es lo que he construido
    }

    private NodeTree<T> findMin(NodeTree<T> root) {
        if(root!=null){
            while(root.getLeft() != null){
                root = root.getLeft();          //mientras tengo algo a la izq, me voy a la izq
            }                                   //sino devuelvo el root actual
        }       
        return root;                            //cuando a izq=null, encontre el minimo
    }

    private NodeTree<T> removeMin(NodeTree<T> root) {
        if(root.getLeft() != null){                     //si tengo algo a izq
            root.setLeft(removeMin(root.getLeft()));        //seteo el left con lo que me devuelva removeMin de la izq
            return root;
        }else{
            return root.getRight();                     //si no tengo nada, subo lo de la derecha a root, si a der no hay nada, entonces subira null
        }
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

    //Dado un arreglo, insertamos los elementos al arbol ABB, y luego lo insertamos de forma inOrder en otra lista
    static <T extends Comparable<? super T>> List<T> treeSort(List<T> elements){
        if(elements.size() == 0){
            return elements;
        }else{
            ABB<T> temp = new ABB<T>();
            for(int i=0; i<elements.size(); i++){
                temp.insert(elements.get(i));
            }
            List<T> sorted = temp.toListInOrder();
            return sorted;
        }
    }

    @Override
    public String toString(){
        return new StringBuilder().append(toListInOrder()).toString();
    }
}

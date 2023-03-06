package practica5.Arboles.AB;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        AB<Integer> arbolito = new AB<Integer>(1  ,  new AB<Integer>(2, new AB<Integer>(3),new AB<Integer>(null))  ,  new AB<Integer>(4, new AB<Integer>(5),new AB<Integer>(6)));
        /*              1           Preorder=  1 2 3 4 5 6
         *          2       4       Postorder= 3 2 5 6 4 1
         *       3    -  5     6    Inorder=   3 2 1 5 4 6
         */
        System.out.println("La altura del arbol es: "+ arbolito.height());
        System.out.println("El tamano del arbol es: "+ arbolito.size());
        System.out.print("InOrder recursivo: ");
        arbolito.toListInOrder(arbolito.getRoot(), new LinkedList<>());
        System.out.print("\nPreOrder recursivo: ");
        arbolito.toListPreOrder(arbolito.getRoot(), new LinkedList<>());
        System.out.print("\nPostOrder recursivo: ");
        arbolito.toListPostOrder(arbolito.getRoot(), new LinkedList<>());
        System.out.print("InOrder iterativo: ");
        arbolito.toListInOrder2(arbolito.getRoot(), new LinkedList<>());
        System.out.print("\nPreOrder iterativo: ");
        arbolito.toListPreOrder2(arbolito.getRoot(), new LinkedList<>());
        System.out.print("\nPostOrder iterativo: ");
        arbolito.toListPostOrder2(arbolito.getRoot(), new LinkedList<>()); //este no anda bien, los demas excelente.
        
    }
}

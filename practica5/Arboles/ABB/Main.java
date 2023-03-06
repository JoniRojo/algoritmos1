package practica5.Arboles.ABB;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ABB<Integer> arbolito = new ABB<Integer>(10);
        arbolito.insert(7);                                       //        10
        arbolito.insert(15);                                      //    7       15
        arbolito.insert(8);                                       //       8
        System.out.println("La altura del arbol es: "+ arbolito.height());
        System.out.println("El tamano del arbol es: "+ arbolito.size());

        System.out.println("Preorder: " + arbolito.toListPreOrder());
        System.out.println("Postorder: " + arbolito.toListPostOrder());
        System.out.println("Inorder: " + arbolito.toString());

        System.out.println("Devolve 7 si 7 esta: " + arbolito.search(7));
        System.out.println("Devolve 8 si 8 esta: " + arbolito.search(8));
        System.out.println("Devolve 10 si 10 esta: " + arbolito.search(10));
        System.out.println("Devolve 15 si 15 esta: " + arbolito.search(15));
        System.out.println("Devolve 11 si 11 esta: " + arbolito.search(11));

        arbolito.remove(8);
        System.out.println(arbolito.toString());
        arbolito.insert(8); 

        arbolito.remove(7);
        System.out.println(arbolito.toString());
        arbolito.insert(7); 

        arbolito.remove(10);
        System.out.println(arbolito.toString());
        arbolito.insert(10); 

        arbolito.remove(15);                        //no elimina 15, probe con traza a mano y deberia andar
        System.out.println(arbolito.toString());

        //TREE SORT
        LinkedList<Integer> desordenada = new LinkedList<>();
        for(int i= 20; i>0; i--){
            desordenada.add(i);
        }
        System.out.println(desordenada);
        var ordenada = ABB.treeSort(desordenada);
        System.out.println(ordenada);
    }
}

package practica2.Listas;

public class Main {
    public static void main(String[] args) {
        ListaCircular<Integer> l1 = new ListaCircular<Integer>();
        ListaCircular<Integer> l2 = new ListaCircular<Integer>();

        l1.agregar(1);
        l1.agregar(2);
        l1.agregar(4);
        System.out.println("La lista original: " + l1.toString());
        l1.insertar(3,2);
        System.out.println("La lista + 3: " +l1.toString());
        l1.insertar(6,1);
        System.out.println("La lista + 6: " + l1.toString());
        Integer eliminado = l1.eliminar(1);
        System.out.println("Eliminando el 6: " + l1.toString());
        System.out.println("El eliminado es: " + eliminado);

        l1.insertar(5,4);
        System.out.println("La lista + 5: " + l1.toString());
        l1.insertar(6,5);
        System.out.println("La lista + 6: " + l1.toString());
        l1.insertar(7,6);
        System.out.println("La lista + 7: " + l1.toString());

        l2.agregar(8);
        l2.agregar(9);
        l2.agregar(10);

        l1.agregarTodos(l2);
        System.out.println("Sumandole [8,9,10]: "+l1.toString());

        l1.insertar(0,0);
        System.out.println("Insertando en la cabeza: "+l1.toString());
        l1.eliminar(0);
        System.out.println("Eliminando la cabeza: "+l1.toString());

        System.out.println("El elemento en la posición 5 es: " + l1.obtener(5));
        
        ListaCircular<Integer> l3 = (ListaCircular<Integer>) l1.subLista(0, 6);   //recordar que el segundo índice es exclusivo
        System.out.println("Una sublista: "+l3.toString());

        System.out.println("Se encuentra el elemento 10? " + l1.contiene(10));
        
        System.out.println("Hasta ahora tiene " + l1.elementos() + " elementos");
        l1.vaciar();
        System.out.println("Vaciando la lista: " + l1.toString());
    }
}

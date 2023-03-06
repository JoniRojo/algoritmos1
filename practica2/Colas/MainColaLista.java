package practica2.Colas;


public class MainColaLista {
    public static void main(String[] args) {
        ColaLista<String> c1 = new ColaLista<String>();
        System.out.println(c1.toString());
        
        c1.encolar("1");
        System.out.println(c1.toString());
        c1.encolar("2");
        System.out.println(c1.toString());
        c1.encolar("3");
        System.out.println(c1.toString());
        c1.encolar("4");
        System.out.println(c1.toString());
        System.out.println("El desencolado es: " + c1.desencolar());
        System.out.println("La lista queda: " + c1.toString());
        System.out.println("El tope actualmente es: " + c1.getTope());
        System.out.println("La lista esta vacia? " + c1.esVacia());
        c1.vaciar();
        System.out.println("Vaciar, la lista queda: " + c1.toString());
        System.out.println("La lista esta vacia? " + c1.esVacia());
    }
}

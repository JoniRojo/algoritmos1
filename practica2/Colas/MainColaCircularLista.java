package practica2.Colas;

public class MainColaCircularLista {
    public static void main(String[] args) {
        ColaCircularLista<String> c1 = new ColaCircularLista<String>();
        c1.vaciar();

        System.out.println("Vaciar, la lista queda: " + c1.toString());
        System.out.println("La lista esta vacia? " + c1.esVacia());  

        //Nullpointer sin sentido... ver del blito
       

    }
}

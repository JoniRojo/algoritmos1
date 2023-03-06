package practica2.Colas;

public class MainColaCircularArreglo {
    public static void main(String[] args) {
        ColaCircularArreglo<Integer> c1 = new ColaCircularArreglo<Integer>();
        c1.vaciar();
        System.out.println(c1.toString());
        
        for(int i=1; i<6; i++){
            c1.encolar(i);
            System.out.println(c1.toString());
            System.out.println("Front= " + c1.getInit());
            System.out.println("Back= " + c1.getEnd());
        }
        
        System.out.println("El desencolado es: " + c1.desencolar());
        System.out.println("La lista queda: " + c1.toString());
        System.out.println("El tope actualmente es: " + c1.getTope());

        c1.encolar(11);
        System.out.println(c1.toString());
        System.out.println("Front= " + c1.getInit());
        System.out.println("Back= " + c1.getEnd());
        System.out.println("El desencolado es: " + c1.desencolar());

        c1.encolar(12);
        System.out.println(c1.toString());
        System.out.println("Front= " + c1.getInit());
        System.out.println("Back= " + c1.getEnd());
        System.out.println("El desencolado es: " + c1.desencolar());

        c1.encolar(13);
        System.out.println(c1.toString());
        System.out.println("Front= " + c1.getInit());
        System.out.println("Back= " + c1.getEnd());
        System.out.println("El desencolado es: " + c1.desencolar());

        c1.encolar(14);
        System.out.println(c1.toString());
        System.out.println("Front= " + c1.getInit());
        System.out.println("Back= " + c1.getEnd());
        System.out.println("El desencolado es: " + c1.desencolar());

        c1.encolar(15);
        System.out.println(c1.toString());
        System.out.println("Front= " + c1.getInit());
        System.out.println("Back= " + c1.getEnd());
        System.out.println("El desencolado es: " + c1.desencolar());

        System.out.println("La lista esta vacia? " + c1.esVacia());
        System.out.println("La lista esta llena? " + (c1.estaLlena())); //No

        c1.encolar(16);
        System.out.println(c1.toString());
        System.out.println("Front= " + c1.getInit());
        System.out.println("Back= " + c1.getEnd());

        System.out.println("La lista esta llena? " + (c1.estaLlena())); //Yes 

        c1.vaciar();
        System.out.println("Vaciar, la lista queda: " + c1.toString());
        System.out.println("La lista esta vacia? " + c1.esVacia());             

    }
}

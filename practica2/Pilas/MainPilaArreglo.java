package practica2.Pilas;

public class MainPilaArreglo{

    public static void main(String[] args) {
        PilaArreglo<Integer> a1 = new PilaArreglo<Integer>();
        
        a1.esVacia();
        a1.vaciar();
        System.out.println(a1.toString());
        a1.apilar(1);
        System.out.println(a1.toString());
        a1.apilar(2);
        System.out.println(a1.toString());
        Integer desapilado = a1.desapilar();
        System.out.println("El desapi es: " + desapilado);
        System.out.println(a1.toString());
        a1.apilar(2);
        System.out.println(a1.toString());
        System.out.println(a1.tope());
        System.out.println(a1.longitud());
        a1.vaciar();
        System.out.println(a1.toString());
        System.out.println(a1.tope()); //no lo contempla
    }
}

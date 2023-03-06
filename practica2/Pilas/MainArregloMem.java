package practica2.Pilas;

public class MainArregloMem {
    public static void main(String[] args) {
        PilaArregloMem<Integer> p1 = new PilaArregloMem<>();
        for(int i=0;i<100; i++){
            p1.apilar(i);
        }
        Number elemDesapilado = p1.desapilar();
        System.out.println(p1);
        
        System.out.println("El elemento desapilado es: " + elemDesapilado.toString());

        p1.vaciar();
        System.out.println(p1);
    }
}

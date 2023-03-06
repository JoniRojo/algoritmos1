package practica2.Colas;

public class MainColaArreglo {
    public static void main(String[] args) {
        ColaArreglo<Integer> c1 = new ColaArreglo<>();
        for(int i=0; i<10; i++){
            System.out.println(c1.toString());
            c1.encolar(i);
            System.out.println("Front= " + c1.getFront());
            System.out.println("Back= " + c1.getBack());
        }
        System.out.println("El desencolado es: " + c1.desencolar());
        System.out.println(c1.toString()); 
        System.out.println("Front= " + c1.getFront());
        System.out.println("Back= " + c1.getBack());   
        System.out.println("El desencolado es: " + c1.desencolar());
        System.out.println(c1.toString());
        System.out.println("Front= " + c1.getFront());
        System.out.println("Back= " + c1.getBack());   
        System.out.println("El desencolado es: " + c1.desencolar());
        System.out.println(c1.toString());
        System.out.println("Front= " + c1.getFront());
        System.out.println("Back= " + c1.getBack());   
        System.out.println("El desencolado es: " + c1.desencolar());
        System.out.println(c1.toString());
        System.out.println("Front= " + c1.getFront());
        System.out.println("Back= " + c1.getBack());   
        c1.encolar(1);                  //lo imprime mal pues el back ahora esta antes del front 
        System.out.println(c1.toString());
        System.out.println("Front= " + c1.getFront());
        System.out.println("Back= " + c1.getBack());
    }
}

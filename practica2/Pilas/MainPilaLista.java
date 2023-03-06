package practica2.Pilas;

public class MainPilaLista {
    public static void main(String[] args) {
        PilaLista<Integer> l1 = new PilaLista<Integer>();
        l1.mostrar();
        l1.apilar(1);
        l1.mostrar();
        l1.apilar(2);
        l1.mostrar();
        l1.apilar(3);
        l1.mostrar();
        l1.apilar(4);
        l1.mostrar(); // 4 3 2 1
        Integer n= l1.longitud();
        Integer i;
        for(i=0; i<n;i++){
            Integer desapilado = l1.desapilar();
            System.out.println("El elem desapilado es: " + desapilado.toString());
        }
        l1.mostrar();   
        l1.vaciar();
        l1.mostrar();

        //Copy&Paste
        PilaLista<String> l2 = new PilaLista<String>();
        PilaLista<String> l3 = new PilaLista<String>();

        l2.apilar("Primero");
        l2.mostrar();
        l2.apilar("Segundo");
        l2.mostrar();
        l2.apilar("Tercero");
        l2.mostrar();

        int x = l2.longitud();

        for(int y=0; i<x; y++){
            l3.apilar(l2.tope());
            l2.desapilar();
        }
        l3.mostrar();

        //PUEDO HACER REVERSA CON LISTA SIMPLEMENTE ENLAZADA?
    }
    
}

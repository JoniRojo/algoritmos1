package practica5.Sorting;

public class InsertionSort {
    public static <T extends Comparable<? super T>> void ordenar (T[] elementos){
        for(int i = 1; i < elementos.length ; i++ ){
            int pos = i;
            T desordenado= elementos[i];
            while((pos > 0) && desordenado.compareTo(elementos[pos-1]) < 0){
                elementos[pos] = elementos[pos-1];
                pos--;
            }
            elementos[pos]=desordenado;
        }
    }
}
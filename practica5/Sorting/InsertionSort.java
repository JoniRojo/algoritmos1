package practica5.Sorting;

public class InsertionSort {
    public static <T extends Comparable<? super T>> void ordenar (T[] elementos){
        for(int i = 1; i < elementos.length ; i++ ){                        //de i=1 a n
            int pos = i;                                                    //inic pos con i(primera vez es el segundo elemento)
            T desordenado= elementos[i];                                    //guardo ese elem a colocar
            while((pos > 0) && desordenado.compareTo(elementos[pos-1]) < 0){  //mientras pos>0 y el anterior sea mayor
                elementos[pos] = elementos[pos-1];                          //corres para adelante
                pos--;                                              
            }
            elementos[pos]=desordenado;                                     //coloco en la pos que corresponde
        }
    }
}
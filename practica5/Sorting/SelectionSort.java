package practica5.Sorting;

public class SelectionSort {
    public static <T extends Comparable<? super T>> void ordenar(T[] elementos){
        for(int i=0;i<elementos.length-1;i++){          //desde i=0 hasta n-1
            int minimo= i;                              //guardo el minimo
            for(int j=i; j<elementos.length;j++){       //desde j=i hasta n
                if(elementos[minimo].compareTo(elementos[j])>0){    //si encuentro uno mas chico
                    minimo = j;                         //mi nuevo min
                }
            }                                       //cuando salgo de ese for tengo el mas chico de esa pasada
            T aux = elementos[minimo];              //swapeo el la pos del nuevo min con la del i actual
            elementos[minimo] = elementos[i];
            elementos[i] = aux;
        }
    }
}

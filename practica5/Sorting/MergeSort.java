package practica5.Sorting;

public class MergeSort {
    public static <T extends Comparable<? super T>> void ordenar(T[] elementos){
        mergeSort(elementos,0,elementos.length-1);
    }
    private static <T extends Comparable<? super T>> void mergeSort(T[] elementos, int inic, int fin){
        if(inic < fin){
            int med = (inic + fin)/2;
            mergeSort(elementos,inic,med);
            mergeSort(elementos,med+1,fin);
            merge(elementos,inic,med,fin);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<? super T>> void merge(T[] elementos, int inic, int med, int fin){
        int izq = inic;
        int der = med + 1;
        int i = 0;
        while(izq<=med && der <= fin){
            if(elementos[izq].compareTo(elementos[der])<=0){
                swap(elementos, inic + i, izq);
                izq++;
                i++;
            }else{
                swap(elementos, inic + i, der);
                der++;
                i++;
            }
        }
        /*
        while(izq <= med){
            temp[i++] = elementos[izq++];
        }
        while(der <= fin){
            temp[i++] = elementos[der++];
        }
        for(i = 0; i<size; i++){
            elementos[inic+i] = (T) temp[i];
        }
        */
    }

    private static <T extends Comparable<? super T>>void swap(T[] elementos, int i, int j){
        T aux= elementos[i];
        elementos[i] = elementos[j];
        elementos[j] = aux;
    }
}


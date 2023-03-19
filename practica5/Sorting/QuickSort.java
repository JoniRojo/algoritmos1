package practica5.Sorting;

public class QuickSort {
    public static <T extends Comparable<? super T>> void ordenar(T[] elementos){
        quickSort(elementos,0,elementos.length-1);
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] elementos, int min, int max){
        if(min < max){
            int p = particionar(elementos, min, max);
            quickSort(elementos, min, p);
            quickSort(elementos,p+1,max);
        }
    }

    public static <T extends Comparable<? super T>> int particionar(T[] elementos,int min, int max){
        int menores= min;
        int iguales= min;
        int mayores = max+1;

        T pivot= elementos[(min + max)/2];
        while(iguales<mayores){
            if(elementos[iguales].compareTo(pivot)==0) iguales++;
            else if(elementos[iguales].compareTo(pivot)<0){
                swap(elementos,iguales,menores);
                iguales++;
                menores++;
            }
            else if(elementos[iguales].compareTo(pivot)>0){
                mayores--;
                swap(elementos,iguales,mayores);
            }
        }

        return menores;
    }

    private static <E extends Comparable <? super E>> void swap(E[] elementos, int i, int j) {
        if(i < 0 || j > elementos.length)
            throw new IllegalArgumentException("indices fuera de rango");
            
        E aux = elementos[i];
        elementos[i] = elementos[j];
        elementos[j] = aux;
    }
}


package practica5.Sorting;

public class CountingSort {
    public static Integer[] ordenar (Integer[] elementos, int k){
        return countingSort(elementos,elementos.length,k);
    }

    public static Integer[] countingSort(Integer[] elementos,int n, int k){
        Integer[] b = new Integer[n];
        Integer[] c = new Integer[k+1];
        for(int i = 0; i<=k ; i++)
            c[i] = 0;
        for(int i = 0; i < n; i++){
            c[elementos[i]] = c[elementos[i]] + 1;
        }
        for(int i = 1; i <= k; i++){
            c[i] = c[i] + c[i-1];
        }
        for(int i = n-1; i >= 0; i--){
            b[c[elementos[i]]-1] = elementos[i];
            c[elementos[i]] = c[elementos[i]] - 1;
        }   
        return b;
    }
}

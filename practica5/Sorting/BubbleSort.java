package practica5.Sorting;

public class BubbleSort {
    public static <T extends Comparable<? super T>> void ordenar(T[] elementos){
        boolean ordenado = false;
        for(int i= 0; i<elementos.length-1 && !ordenado;i++){       //para(i=0, i<n siendo n la cant de elems ^ !ordenado)
            ordenado = true;                                        //ordenado = true   de esta forma con una pasada si ya esta ordenado listo
            for(int j = 0; j< (elementos.length-1) - i ; j++){      //para j desde 0 a n
                if(elementos[j].compareTo(elementos[j+1])>0){       //si dos elem estan desordenados
                    T aux = elementos[j];                           //los swapeo y ordenado = false
                    elementos[j] = elementos[j+1];
                    elementos[j+1] = aux;
                    ordenado = false;
                }
            }
        }
    }
}

/*   Ventajas:  Inplace(no uliliza memoria extra)
 *              Con una pasada, puede saber si el arreglo esta ordenado
 *              Se puede usar en un contexto donde te van vinienedo los elementos(es online)
 *              Es estable
 *   Desventajas: En la practica no se usa, es uno de los mas ineficientes
 * 
 *      Ver formula de tiempo de ejecucion 0(n^2) theta
 *      Peor caso, mismas comparaciones que intercambios
 *      Mas intercambios que el selection sort
 *      n^2 intercambios y n^2 comparaciones
 */     
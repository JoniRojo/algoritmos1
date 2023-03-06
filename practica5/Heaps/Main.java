package practica5.Heaps;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<Integer>();
        heap.insert(10);
        heap.insert(80);
        heap.insert(40);
        heap.insert(100);
        heap.insert(30);
        heap.insert(50);
        heap.insert(90);
        heap.insert(70);
        heap.insert(60);
        heap.insert(20);
        heap.insert(5);
        heap.insert(35);
        System.out.println(heap);
        System.out.println("El elimidado es: " + heap.remove());
        System.out.println(heap);

        System.out.println("<<Heap Sort>>");
        List<Integer> desordenada = new ArrayList<Integer>();
        for(int i=0; i<20; i++){
            desordenada.add(i);
        }
        System.out.println("La lista ingresada: "+desordenada);
        var ordenada = Heap.heapSort(desordenada);
        System.out.println("La lista quedo: "+ordenada);
    }
}
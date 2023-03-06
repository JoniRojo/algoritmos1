package practica5.Heaps;

import java.util.List;
import java.util.LinkedList;

public class Heap<T extends Comparable<? super T>> {
    //Atributos
    private static int MAX = 20;
    private T[] arreglo;
    private int size;

    //Constructor
    public Heap(){
        this(MAX);
    }

    public Heap(int n){
        arreglo = (T[]) new Comparable[n];
        size=0;
    }

    //Metodos
    public boolean estaVacio(){
        return size==0;
    }

    public boolean estaLleno(){
        return size == arreglo.length;
    }

    public void insert(T e){            //Invariante, los hijos son mas chicos que el padre. raiz > hi hd
        if(estaLleno())
            throw new IllegalStateException("Heap is full");
        int i = size;           //seteo i en la pos del insertado
        arreglo[size] = e;      //size es primer slot libre
        size++;                 //lo coloco al final, pero ahora falta ver si hay que hacer bubbleup o no
        while(i>0 && arreglo[padre(i)].compareTo(arreglo[i])<0){        //mientras tenga elementos y el padre del que puse sea mas chico
            swap(arreglo, padre(i), i);                                 //swapeo
            i = padre(i);                                               //actaulizao mi i a donde acabo de swapear
        }
    }

    private void swap(T[] arreglo, int i, int j) {
        T aux = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = aux;
    }

    private int padre(int i) {      //de hijo, sea izq o der, padre devuelve la pos del padre
        return (i-1)/2;
    }
    
    private int hijoIzq(int i){     //desde la pos de un padre, hijoIzq devuelve la pos del hi
        return i*2 + 1;
    }

    private int hijoDer(int i){     //desde la pos de un padre, hijoDer devuelve la pos del hd
        return i*2 + 2;
    }

    public T remove(){              //remove es como desencolar, saca el elemento con mayor prioridad
        if(estaVacio())
            throw new IllegalStateException("El heap esta vacio");
        swap(arreglo, 0, size-1);           //intercambio el primero con el ultimo(mas abajo a la der)
        size--;                                //remuevo el elemento con las prioridad
        //ahora debo checkear que se cumpla el invariante burbujeando para abajo, bubbledown
        int i=0;                                //arranco desde arriba ahora 
        while((hijoDer(i)<size && arreglo[i].compareTo(arreglo[hijoDer(i)])<0)||(hijoIzq(i)<size && arreglo[i].compareTo(arreglo[hijoIzq(i)]) < 0) ){
                    //mientras tenga hijo der y sea mas grande que mi i O mientras tenga hijo izq y sea mas grande que mi i
                    //recordemos que mi i, es ese que subi que estaba abajo a la der
            //identifiquemos por cual hay que swapear
            if((arreglo[i].compareTo(arreglo[hijoDer(i)]) < 0)&&(arreglo[i].compareTo(arreglo[hijoDer(i)]) < 0)){   //si ambos son mas grande que mi i
                if(arreglo[hijoIzq(i)].compareTo(arreglo[hijoDer(i)])< 0 ){     //si mi hi es mas chico que el hd
                    swap(arreglo, i, hijoDer(i));                               //swapeo entonces el hd
                    i = hijoDer(i);
                }else{
                    swap(arreglo, i, hijoIzq(i));                               //sino por hi
                    i = hijoIzq(i);
                }
            }else if (arreglo[i].compareTo(arreglo[hijoIzq(i)]) < 0){     //si mi hi es mas grande que yo
                swap(arreglo, i, hijoIzq(i));                      //swapeo y actualizo mi i
                i = hijoIzq(i);
            }
            else if(arreglo[i].compareTo(arreglo[hijoDer(i)]) < 0){
                swap(arreglo, i, hijoDer(i));
                i = hijoDer(i);
            }
        }
        return arreglo[size];   //devuelvo el eliminado(mayor prioridad)    
    }

    /* static List<Integer> heapSort(ArrayList<Integer> elements){
        if(elements.size() == 0){
            return elements;
        }else{
            Heap<Integer> heapTemp = new Heap<>(elements.size());
            for(int i=0; i<elements.size(); i++){
                heapTemp.insert(elements.get(i));
            }
            System.out.println("Heap:"+ heapTemp);
            List<Integer> sorted = new ArrayList<>();
            for(int i = 0; i < elements.size(); i++){
                sorted.add(heapTemp.remove());
            }
            return sorted;
        }
    } */
    
    static <T extends Comparable<? super T>> List<T> heapSort(List<T> elements){
        if(elements.size() == 0){
            return elements;
        }else{
            Heap<T> heapTemp = new Heap<>(elements.size());
            for(int i=0; i<elements.size(); i++){
                heapTemp.insert(elements.get(i));
            }
            System.out.println("Heap:"+ heapTemp);
            List<T> sorted = new LinkedList<>();
            for(int i = 0; i < elements.size(); i++){
                sorted.add(heapTemp.remove());
            }
            return sorted;
        }
    }

    public String toString(){
        StringBuilder str = new StringBuilder("[ ");
        for(int i = 0; i<size-1; i++){
            str.append(arreglo[i] + ", ");
        }
        if(estaVacio()){
            str.append("]");
        }else{
            str.append(arreglo[size-1] + " ]");
        }
        return str.toString();
    }
}
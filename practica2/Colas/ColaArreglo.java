package practica2.Colas;

public class ColaArreglo<T> implements Cola<T>{


    /*
    En esta implementacion [Front                   Back] por el back entran, es decir aumentas el back
                                                          por el front salen, tmb aunmentas el front
    Tiene un increment que si el sig es fuera de rango, le pone 0, entonces como que encola al principio
    */

    private T[] arreglo;
    private int  size;
    private int  front;
    private int  back;
    private static final int MAX = 10;

    @SuppressWarnings("unchecked")

    public ColaArreglo( ){
        arreglo = (T []) new Object[MAX];
        vaciar();
    }

    public int getFront(){
        return front;
    }
        
    public int getBack(){
        return back;
    }

    public boolean esVacia( ){
        return size == 0;
    }

    public void vaciar( ){
        size = 0;
        front = 0;
        back = -1;
    }

    //dequeue, el que esta primero juira
    public T desencolar(){
        if( esVacia() )
                throw new IllegalStateException( "Arreglo vacio" );
                //    throw new UnderflowException( "Arreglo vacio" );
        size--;

        T returnValue = arreglo[front];
        front = increment(front);
        return returnValue;
    }


    public T getTope() {
        if(esVacia()) {
            throw new IllegalStateException( "Arreglo vacio" );
            //    throw new UnderflowException( "Arreglo vacio" );
        }
        return arreglo[front];
    }

    //agregue uno a la cola, enqueue
    public void encolar( T x ){
        if( size == arreglo.length )
            doubleQueue( );
        back = increment( back );
        arreglo[back] = x;
        size++;
    }

    private int increment( int x ){
        if( ++x == arreglo.length )
            x = 0;
        return x;
    }
    
    /**
     * Internal method to expand arreglo. aux es el nuevo arreglo
     */
    @SuppressWarnings("unchecked")
    private void doubleQueue( ){
        T [] aux = (T []) new Object[ arreglo.length * 2 ];
            // Copy elements that are logically in the queue
        for( int i = 0; i < size; i++, front = increment( front ) )
            aux[ i ] = arreglo[ front ];

        arreglo = aux;
        front = 0;
        back = size - 1;
    }

    @Override 
    public String toString() {   
            String rdo = "[ ";
             int i;
             for( i = front; i <back; i++ ) {
                 rdo += arreglo[i] + " | ";
             }
            
            if( size>0 ){
                rdo += arreglo[i] + " ]";
            }else{
                rdo = "[ ]";
            }
             return rdo;
    }

}

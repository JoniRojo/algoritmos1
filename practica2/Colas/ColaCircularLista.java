package practica2.Colas;

public class ColaCircularLista<T> implements Cola<T> {

    private Nodo<T> end; //apunta al final de la cola, el siguiente apunta al comienzo de la cola
    private int size;       
    
    public ColaCircularLista(){
        end=null;
        size=0;
    }

    public boolean esVacia() {
        return size==0;
    }
    
    public void vaciar() {
        end=null;
        size=0;
    }

    public T getTope() {
        return end.getNext().getItem();
    }

    public T getInit(){
        return end.getNext().getItem();
    }
    
    public T getEnd(){
        return end.getItem();
    }


    public void encolar(T x) {
        Nodo<T> aux = new Nodo<T>();
        aux.setItem(x);                 //A ese nuevo nodo, le pongo el item pasado por parametro

        if(esVacia()){
            aux.setNext(aux);           //si la cola esta vacia, el siguiente es el mismo
        }else{                          //sino, se agrega el nodo a la lista
            aux.setNext(end.getNext()); //el nuevo nodo, su siguiente deber ser el init
            end.setNext(aux);           //el siguiente del final actual es el nuevo nodo
        }
        end=aux;                        //el end debe ser el nuevo nodo
        size++;
    }

    public T desencolar() {
        if (size==0){
            throw new IllegalStateException("Cola vacia");
        }
        size--;
        T bye = end.getNext().getItem();        
        end.setNext(end.getNext().getNext());
        return bye;
    }

    @Override
	public String toString(){
		StringBuilder cadena = new StringBuilder("[ ");
		Nodo<T> temp= end.getNext();
		while(temp!=end){
			cadena.append(temp.getItem() + ", ");
			temp= temp.getNext();
		}
		if(esVacia()){
			cadena.append("]");
		}else{
			cadena.append(end.getItem() + " ]" );
		}
		return cadena.toString();
	}
}

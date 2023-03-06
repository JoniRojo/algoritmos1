package practica2.Listas;

public class ListaCircular<T> implements ILista<T> {
    
    private Nodo<T> end;
    private int size;

    public ListaCircular(){
        end = null;
        size = 0;
    }

    @Override
    public boolean agregar(T elem) {
        Nodo<T> nuevo = new Nodo<T>(elem);
        if( esVacia()){
            nuevo.setSiguiente(nuevo);
        }else{
            end.setSiguiente(nuevo);
            nuevo.setSiguiente(end.getSiguiente());
        }
        end = nuevo;
        size++;
        return true;
    }

    //Este me pedía el ejercicio 12...
    @Override
    public boolean agregarTodos(ILista<T> otraLista) {
        ListaCircular<T> otra = (ListaCircular<T>) otraLista;
        Nodo<T> temp = otra.end.getSiguiente();
        otra.end.setSiguiente(this.end.getSiguiente());
        this.end.setSiguiente(temp);
        this.end = otra.end;
        this.size += otra.size;
        return true;
    }

    @Override
    public boolean insertar(T elem, int indice) {
        if (indice < 0 || indice > size)
            throw new IndexOutOfBoundsException();

        Nodo<T> nuevo = new Nodo<T>(elem);

        if(indice == 0){
            nuevo.setSiguiente(end.getSiguiente());
            end.setSiguiente(nuevo);
            size++;
        }else{
            if(indice==size){                 //inserte el nuevo ultimo
                agregar(elem);
            }else{
                Nodo<T> aux = goTo(indice-1);
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
                size++;
            }
        }
        return true;
    }

    private Nodo<T> goTo(int pos){
        Nodo<T> temp = end.getSiguiente();  //pararlo en el primero
        for(int i=0; i<pos;i++)
            temp = temp.getSiguiente();
        return temp;
    }

    @Override
    public T eliminar(int indice) {
        T returnValue;
        if (indice < 0 || indice >= size)
            throw new IndexOutOfBoundsException();
        if (esVacia())
            throw new IllegalStateException();
        
        if(indice == 0){
            returnValue = end.getSiguiente().getElem();
            end.setSiguiente(end.getSiguiente().getSiguiente());
        }else{
            Nodo<T> aux = goTo(indice-1);
            returnValue = aux.getSiguiente().getElem();
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
        }
        size--;
        return returnValue;
    }

    @Override
    public T obtener(int indice) {
        return goTo(indice).getElem();
    }

    @Override
    public ILista<T> subLista(int desdeInd, int hastaInd) {
        if (desdeInd < 0 || desdeInd >= size || hastaInd < 0 || hastaInd >= size || hastaInd < desdeInd)
            throw new IndexOutOfBoundsException();
        Nodo<T> desdeNodo = goTo(desdeInd);
        Nodo<T> hastaNodo = goTo(hastaInd);
        ListaCircular<T> subLista = new ListaCircular<T>();
        while(desdeNodo!=hastaNodo){
            subLista.agregar(desdeNodo.getElem());
            desdeNodo = desdeNodo.getSiguiente(); 
        }
        subLista.size=hastaInd-desdeInd;
        return subLista;
    }

    @Override
    public boolean contiene(T elem) {
        Nodo<T> aux = end.getSiguiente(); //paras al principio
        for(int i=0;i<size;i++){
           if (elem.equals(aux.getElem()))
                return true;
           aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public void vaciar() {
        end=null;
        size = 0;
    }

    @Override
    public int elementos() {
        return size;
    }

    @Override
    public boolean esVacia() {
        return size==0;
    }

    @Override
    public boolean repOK() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
	public String toString(){
		StringBuilder cadena = new StringBuilder("[ ");
        if(esVacia()){
            cadena.append("]");
        }else{
            Nodo<T> temp= end.getSiguiente();
            while(temp!=end){
                cadena.append(temp.getElem() + ", ");
                temp= temp.getSiguiente();
            }
            cadena.append(end.getElem() + " ]" );
        }

		return cadena.toString();
	}
}

package practica5.Grafos;

/*
 * Un arco es lo que conecta dos nodos/vertices
 * Para nuestra implementacion, vertice podremos agregar un adyacente llamando a arco con un vertice
 * Por lo que un arco es:  (( -----> vertice B )) que es llamado desde un vertice A . agregar adyacente (vertice B)  
 */
public class Arco<T>{

    private Vertice<T> to;      //guarda en to el vertice al que conecta
    private int peso;           //su peso
    private boolean visitado;   //podemos tambien marcar arcos, buscar para que problema era esto, lo dijo castro

    //Constructor
    public Arco(Vertice<T> v, int p){
        to = v;
        peso = p;
        visitado= false;
    }

    //Devuelve el vertice que conecta
    public Vertice<T> getTo() {
        return to;
    }

    //Devuelve el peso del marco
    public int getPeso() {
        return peso;
    }

    //Marca el arco
    public void marcar() {
        visitado = true;
    }

    // xq getPos????????
    public String toString(){
        return "-> [ V"+ to.getPos() + " ]"; 
    }
}

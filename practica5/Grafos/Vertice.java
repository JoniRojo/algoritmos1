package practica5.Grafos;

import java.util.LinkedList;
import java.util.List;

/*
 * Clase Nodo o Vertice
 * En esta implementacion un vertice tendra su informacion, su posicion, si esta visitado o no
 * y una lista de adyacentes(una lista de arcos, ya que estos arcos tiene el adyacente guardado(getTo))
 */
public class Vertice<T>{
    
    private Integer pos;            //posicion del vertice
    private T info;                 //data del nodo
    private boolean visitado;       //true si esta marcado
    private List<Arco<T>> adj;      //su lista de arcos

    public Vertice(T informacion, Integer p){
        info = informacion;
        adj = new LinkedList<Arco<T>>();
        visitado = false;
        pos = p;
    }

    public Integer getPos(){
        return pos;
    }

    public T getInfo() {
        return info;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void marcar() {
        this.visitado = true;
    }

    public List<Arco<T>> getAdj() {
        return adj;
    }
    //Pasas el vertice al cual queres agregar como adyacente del que lo llama
    public void nuevoAdyacente(Vertice<T> v, int p){
        adj.add(new Arco<T>(v,p));
    }

    //Te devuelve un adyacente no visitado
    public Vertice<T> AdyacenteNoVisitado(){
        for(Arco<T> arco: adj){                     //para cada arco en adj(adyacentes)
            if(!arco.getTo().isVisitado())          //si el vertice al que apunta el arco no esta visitado
                return arco.getTo();                //retornar el vertice
        }
        return null;
    }

    public int weight(Vertice<T> w){
        for(Arco<T> arco : adj){                            //para cada arco en adj(adyacentes)
            if(arco.getTo().getPos().equals(w.getPos()))    //si en mis adyacentes encuentro w
                return arco.getPeso();                      //retorno el peso del arco
        }
        return 999999;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("{ V" + pos + " }");
        for(Arco<T> arco : adj)
            str.append(arco.toString());
        str.append("-> //\n");
        return str.toString();
    }

}

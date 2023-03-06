package practica5.Grafos;
import java.util.List;

//------------------------------------------------//
//         INTERFAZ GENERICO DE GRAFOS           //
//-----------------------------------------------//

/*
 * Un grafo tiene nodos o vertices conectado por arcos con o sin peso/costo dirigidos o no dirigidos
 */

public interface IGrafo<T> {
    //Anadime un arco del nodo x a y con peso w
    public void añadirArco(Integer x, Integer y, int w);

    public int numeroDeVertices();

    public int numeroDeArcos();

    //True si y es adyacente de x
    public boolean adj(Integer x, Integer y);

    //Recorridos del grafo desde un nodo inicial x??
    public List<String> BFS(Integer x);
    public List<String> DFS(Integer x);
}
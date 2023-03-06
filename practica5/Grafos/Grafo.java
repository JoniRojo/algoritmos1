package practica5.Grafos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Grafo<T> implements IGrafo<T>{

    private Map<Integer, Vertice<T>> vertices;  //mapear Int→Vertice<T>
    private int numVertices;
    private int numArcos;

    public Grafo(){ 
        vertices = new HashMap<Integer, Vertice<T>>();          //preguntar esto vertices es un map pero lo creo con hashmap    ???
        numVertices = 0;
        numArcos = 0;
    }

    //agrego un vertice al nodo con info
    public void añadirVertice(T info){
        numVertices++;                                                      
        vertices.put(numVertices,new Vertice<T>(info,numVertices));     //en vertices pongo, pos/indix y creo nuevo vertice con info y pos
    }

    //agregar un arco desde el nodo x a y con peso w
    @Override
    public void añadirArco(Integer x, Integer y, int w) {
        if(vertices.containsKey(x) && vertices.containsKey(y)){ //si ambos vertices tienen una clave
            vertices.get(x).nuevoAdyacente(vertices.get(y), w); //desde vertice x llamo a nuevoady con "y" y el peso
            numArcos++;
        }
        else{
            throw new IllegalStateException("Hay al menos un vertice que no existe");
        }
    }

    @Override
    public int numeroDeVertices() {
        return numVertices;
    }

    @Override                                                                           
    public int numeroDeArcos() {
        return numArcos;
    }

    //dados dos keys de vertices, te digo si son adyacentes(si hay un arco que los une)
    @Override                                                                           
    public boolean adj(Integer x, Integer y) {
        for(Arco<T> arco : vertices.get(x).getAdj()){       //de vertices obtengo el que tenga key x, y obetengo sus adyacentes
                                                            // para cada arco de esos adyacentes hago tal cosa ?? 
            if(arco.getTo().getPos().equals(y))         //si a algun adyacente(que es un arco con la info)... si algun arco de estos, el to es y              
                return true;                        //retorno true, sino false
        }
        return false;
    }

    //DFS RECURSIVA
    //public void dfs(vertex v)
    // process(v)
    // mark(v)
    // for all adyacentes w de v sin marcar{
    //    dfs(w)
    // }
    @Override
    public List<String> DFS(Integer x) {            //le paso desde el nodo que vamos a hacer el dfs(la key no el nodo/vertice)
        if (! vertices.containsKey(x))              //si en mi lista de nodos no esta la clave
            throw new IllegalArgumentException("No existe un vértice con posicion" + x);       //tiro exepcion
        return DFS(vertices.get(x), new LinkedList<String>());          //sino llamo a dfs con el vertice en si, y la lista donde estara el dfs
    }

    private List<String> DFS (Vertice<T> x, List<String> lista){
        lista.add("V" + x.getPos());                //proceso, agrego su key a la lista
        x.marcar();                                 //marco
        for(Arco<T> arco: x.getAdj()){              //para todos los adyacentes de x sin marcar, para todos esos arcos    
            if(!arco.getTo().isVisitado())          //si el vertice que apunta el arco no esta marcado
                DFS(arco.getTo(),lista);            //llamo a dfs con ese vertice y le paso la lista
        }
        return lista;                               //retorno la lista
    }
    
    /**
     * DFS NO RECURSIVA CON PILAS
     * public void dfs(vertex x)
     * Stack pila
     * pila.push(x)
     * mark(x)
     * process(x)
     * while(!pila.isEmpty())
     *    Vertice w = get pila.tope().UnvisitedAdj()
     *    if(w != null){        //hay adj no visitados
     *          pila.push(w)
     *          mark(w)
     *          process(w) 
     *    }else{
     *          pila.pop() 7yhn
     *    }
     */

    public List<String> DFSi(Integer x){
        if (! vertices.containsKey(x))            
            throw new IllegalArgumentException("No existe un vértice con posicion" + x);       
        return DFSi(vertices.get(x));
    }

    private List<String> DFSi(Vertice<T> x) {
        List<String> lista = new LinkedList<>();            //creo la lista donde pongo el resultado
        Stack<Vertice<T>> pila = new Stack<>();             //creo una pila
        pila.push(x);                                       //pusheo x a la pila
        x.marcar();                                         //lo marco
        lista.add("V" + x.getPos());                        //lo proceso
        while(!pila.isEmpty()){                             //mientras la lista no este vacia
            Vertice<T> tope = pila.peek();                  //tomo el tope de la pila sin sacarlo de ella
            Vertice<T> w = tope.AdyacenteNoVisitado();      //en w guardo un adyacente no visitado
            if(w!= null){                                   //si tengo alguno
                pila.push(w);                               //lo pusheo en la pila
                w.marcar();                                 //lo marco
                lista.add("V" + w.getPos());                //lo proceso
            }else{
                pila.pop();                                 //sino lo saco de la pila
            }
        }
        return lista;                                       //retorno la lista
    }

    /**BFS CON COLAS
     * public void BFS(vertex x)
     * Queue<> cola
     * cola.enqueue(x)
     * mark(x)
     * while(!cola.isEmpty()){  
     *      vertice w = cola.dequeue()
     *      process(w);
     *      for all vertices adyacentes no marcados a w {
     *          cola.enqueue(x)
     *          mark(x)
     *      }
     * }
     */
    public List<String> BFS(Integer x){
        return BFS(vertices.get(x));
    }
    
    public List<String> BFS(Vertice<T> x) {
        Queue<Vertice<T>> cola = new LinkedList<>();        //creo una nueva cola
        List<String> lista = new LinkedList<>();            //creo una lista de resultado
        cola.add(x);                                        //agrego el vertice x inicial a la cola
        x.marcar();                                         //lo marco
        while(!cola.isEmpty()){                             //mientras la cola no este vacia
            Vertice<T> w = cola.poll();                    // toma y saca de la cola
            lista.add("V" + w.getPos());                   //procesa
            Vertice<T> u = w.AdyacenteNoVisitado();         //guardo en un vertice u, un adyacente de w
            while(u != null){                               //mieentras tenga adyacentes
                cola.add(u);                                //lo agrego a la cola
                u.marcar();                                 //lo marco
                u = w.AdyacenteNoVisitado();                 //y sigo encolando adyacentes
            }
        }
        return lista;
    }

    /**
     * warshall Nat → Nat → Nat → Nat
     * warshall i j 0 = weight(i,j)
     * warshall i j k = min (warshall i j k-1) {(warshall i k k-1) + (warshall k j k-1)} 
     */
    
    public int warshall(Integer x, Integer y){          //le paso ambas keys de los vertices
        if(!vertices.containsKey(x) || !vertices.containsKey(y)) 
            throw new IllegalArgumentException("warshall: Alguno de los dos nodos no existe");
        return warshall(x, y, numVertices);         //mi k primeros nodos van a ser todos, corta.
    }
    
    
    private int warshall(Integer x, Integer y, int k){
        if(k == 0){                             //si mi k es 0
            return vertices.get(x).weight(vertices.get(y));     //es el peso del arco directo entre estos
        }else{
            return Math.min(warshall(x,y,k-1), ( warshall(x,k,k-1) + warshall(k,y,k-1) ) );     //ver apunte si no se entiende
            //el min entre ir por los primeros k-1 nodos,yy el cam mas corto de ir de x a k mas el de ir de k a y(pasando p/los primeros k-1 nodos)
        }
    }

    //otra forma de llamar a warshall se ve....
    public int warshall2(Integer x, Integer y){
        if(!vertices.containsKey(x) || !vertices.containsKey(y))            //chequeo que ambas keys existan
            throw new IllegalArgumentException("warshall: Alguno de los dos nodos no existe");
        int n = numVertices;                                // mi k es el numdenodos

        matrices rdo = warshall(new int[n+1][n+1], new int[n+1][n+1]);      //
        
        imprimirCamino(x,y,rdo.path);                           //

        return rdo.d[x][y];                                 //
    }

    private matrices warshall(int[][] d, int[][] path){         //en dist se guarda las distancias y en path los caminos
        int n= numVertices;             //n cantidad de nodos
        //inicializar el path y el dist
        for(int i= 1; i<=n ; i++){      //filas
            for(int j=1; j<=n; j++){    //columnas
                int w = vertices.get(i).weight(vertices.get(j));    //guardo en w el peso directo de ir de i a j
                d[i][j] = w;                        //guardo en la pos correspondiente el costo
                path[i][j] = -1;                    //en path pongo -1
                if(0 < w && w < 999999){            //si es un peso valido
                    path[i][j] = i;                 //pongo en la pos correspondiente de path el i
                }
            }
        }
        for(int k=1;k<=n;k++){                      //todos los k posibles
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(d[i][k] + d[k][j] < d[i][j]){
                        d[i][j] = d[i][k] + d[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
        return new matrices(path,d);
    }

    private void imprimirCamino(Integer x, Integer y, int[][] path){
        System.out.print("V"+ y + " <- ");
        int previo = path[x][y];
        while(previo != x){
            System.out.print("V"+ previo + " <- ");
            previo = path[x][previo];
        }
        System.out.println("V"+ x);
    }
    
    /*
    public int dijkstra(Integer x, Vertice<T>[] path, int[] d){
        for(int i= 0; i< numVertices; i++){
            path[i] = null;
            d[i] = 999999; 
        }
        d[x]=0;
        Set<Vertice<T>> S = new Set<>();
        PriorityQueue<Vertice<T>> q = new PriorityQueue<Vertice<T>>(vertices.values());
        while(!q.isEmpty()){
            Vertice<T> u = q.remove();
            S.add(u);
            for(Arco<T> arco: u.getAdj()){
                Vertice<T> y = arco.getTo();
                if(!S.pertenece(y)){
                    if(d[u.getPos()]+ u.weight(y) < d[y.getPos()]){
                        d[y.getPos()] = d[u.getPos()]+ u.weight(y);
                        path[y.getPos()] = u;
                        q.changeKey(y, d[y.getPos()]);
                    }
                }
            }
        }

        return 0;
    }
    */

    public String toString(){
        String str = new String();
        for(Vertice<T> nodo : vertices.values())
            str += nodo.toString();
        return str;
    }

    public class matrices{
        public int[][] path;
        public int[][] d;

        public matrices(int[][] path, int[][]d){
            this.path = path;
            this.d = d;  
        }
    }

}
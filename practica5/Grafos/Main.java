package practica5.Grafos;

public class Main {
    public static void main(String[] args) {
        Grafo<Integer> grafiti = new Grafo<Integer>();

        //-----------------------------------//
        //     Se añaden los vertices        //
        //-----------------------------------//
        grafiti.añadirVertice(1);
        grafiti.añadirVertice(2);
        grafiti.añadirVertice(3);
        grafiti.añadirVertice(4);
        grafiti.añadirVertice(5);

        //-----------------------------------//
        //       Se añaden los arcos         //
        //-----------------------------------//
        grafiti.añadirArco(1, 2, 1);
        grafiti.añadirArco(1, 5, 6);
        grafiti.añadirArco(2, 3, 2);
        grafiti.añadirArco(3, 4, 1);
        grafiti.añadirArco(4, 5, 1);
        grafiti.añadirArco(2, 5, 0);

        System.out.println(grafiti);

        //----------- RECORRIDOS ------------//
        //System.out.println("DFS: " + grafiti.DFS(1));
        //System.out.println("DFSi: " + grafiti.DFSi(1));
        System.out.println("BFS: " + grafiti.BFS(1));


        //------- CAMINO MÁS CORTO ---------//
        //System.out.println(grafiti.warshall(1,5));
        System.out.println(grafiti.warshall2(1,5));
        
    }
}

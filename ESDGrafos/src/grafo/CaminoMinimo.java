/*
La clase GrafMatPesorepresenta un grafo valorado. La matriz de pesos contiene el costede 
cada arco, o bien INFINITOsi no hay arco entre dos vértices. Además, el método pesoArco()
devuelve el peso o coste de un arco (se puede consultar la clase en la página web del libro). 
Se escribe la clase CaminoMinimopara implementar el algoritmo y operaciones auxiliares. 
Los arrays ultimo[]y D[]representan la información asociada a cada vértice: el último vértice 
en el camino y el coste mínimo, siendo el vértice el índice del array.El conjunto Fde vértices se 
representa mediante un arrayde tipo boolean, de tal forma que si el vértice ise incluye en F, 
entonces F[i]se pone a true(verdadero).
 */

package grafo;

/**
 *AM11098
 */



public class CaminoMinimo {
    private double [][] Pesos;
    private int [] ultimo;
    private double [] D;
    private boolean [] F;
    private int s, n; 
    
    public CaminoMinimo(GrafoMatriz gp, int origen) //constructor
    {
        n = gp.getNumVerts(); //Numero de vertices
        s = origen;           //Vertice origen
        Pesos = gp.matPeso;   //Matriz Pesos
        ultimo = new int [n]; //Ultimo vertice visitado
        D = new double [n];   //Acumula pesos
        F = new boolean [n];  //Acumula asosiaciones y visitas
    }
    
    
    public void caminoMinimos() //algoritmo de Dijkstra :v
    {
        // valores iniciales
        for (int i = 0; i < n; i++)
        {
            F[i] = false;
            D[i] = Pesos[s][i]; //Guarda pesos de Vertice a evaluar
            ultimo[i] = s;  //vertices de origen
        }
        F[s] = true; 
        D[s] = 0; //Peso de si mismo CERO
        // Pasos para marcar los n-1 vértices 
        for (int i = 1; i < n; i++)
        {
            int v = minimo(); /* selecciona vértice no marcado de menor distancia */
            F[v] = true; //Nuevo Pivote F
            // actualiza distanciade vértices no marcados 
            for (int w = 1; w < n; w++){
                if (!F[w])
                    if ((D[v] + Pesos[v][w]) < D[w]) //Hasta encontrar peso menor 
                                                     //con respecto al ultimo encontrado
                    {
                        D[w] = D[v] + Pesos[v][w]; //Acumula pesos
                        ultimo[w] = v; //Asigna nuevo menor encontrado
                    }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("costo minimo a "+i+": "+D[i]); //Imprime costos minimos
        }
    }
    
    private int minimo() //Devuelve camino minimo 
    {
        double mx = 100000.0;/*GrafoMatriz.INFINITO;*/ //para marcar camino infinito e.e xD
        int v = 1;
        for (int j = 1; j < n; j++)
            if (!F[j] && (D[j]<= mx))// F == false Y D <= inf
            {
                mx = D[j];
                v = j; //Camino minimo del vector D
            }
        System.out.println("Minimo"+ v);
        return  v;
    }
    
    
    
    public void recuperaCamino(int v) //recupera caminos posibles del ultimo al ultimo recursividad :v
    {
        int anterior = ultimo[v];
        if (v != s) //Mientras sea Diferente de donde se quiere ir
        {
            recuperaCamino(anterior); // vuelve al último del último
            System.out.print("-> V"+ v); //imprime recursivamente
        }
        else 
            System.out.print("V"+ s);
    }
    
    //Otro recuperaCamino
    public void ruta(int j){ //Metodo para explicito de caminos creo es mas entendible asi
        if(j!=s){ //Mientras sea Diferente de donde se quiere ir
            ruta(ultimo[j]); //va al ultimo del ultimo
            if(D[j] != 100000) //Camino resultado diferente de infinito
                System.out.println("Se recorrio de "+ultimo[j]+" a "+j);  //imprime recursivamente
            else
                System.out.println("\nNo es posible llegar a ese destino desde el origen: "+s);
        }
    }
    
    
    
    
    
    
}

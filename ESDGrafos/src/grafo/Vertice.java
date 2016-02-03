/*
La clase Verticere presenta un nodo del grafo, con su nombre (String) y número asignado. 
El constructor inicializa el nombre y pone como número de vértice -1; el método que añade el 
vértice al grafo establece el número que le corresponda.
 */

package grafo;

/**
 *AM11098
 */

public class Vertice {
    
    String nombre;
    int numVertice;
    InformacionGrafo info;
    
    public Vertice(String x) //COnstructor
    {
        nombre = x;
        numVertice = -1;
    }
    
    public String nomVertice() // devuelve identificador del vértice
    {
        return nombre;
    }
    
    public boolean equals(Vertice n) // true, si dos vértices son iguales
    {
        return nombre.equals(n.nombre);
    }
    
    public void asigVert(int n) // establece el número de vértices/// Se hace desde el metodo que lo invoca
    {
        numVertice = n;
    }
    
    @Override
    public String toString() // características del vértice
    {
        return nombre + " (" + numVertice + ")";
    }
}

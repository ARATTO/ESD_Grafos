/*
La clase GrafoMatriz define la matriz de adyacencia, el array de vértices y los métodos 
para añadir nodos y arcos al grafo.
 */

package grafo;

/**
 *AM11098
 */

public class GrafoMatriz {
    int numVerts;
    static int maxVerts = 20; //Maximo de vertices PRESTABLECIDO
    Vertice [] verts;
    int [][] matAd;
    double [][] matPeso;
    
    public GrafoMatriz() //Constructor sin parametro
    {
        this(maxVerts); //Invoca constructor con parametro
    }
    
    public GrafoMatriz(int mx) //Constructor con parametro 
    {
        matAd = new int [mx][mx];
        matPeso = new double [mx][mx];
        verts = new Vertice[mx];
        
        for (int i = 0; i < mx; i++){
            for (int j = 0; i < mx; i++){ 
                matAd[i][j] = 0;
            }
        }
        for (int i = 0; i < mx; i++){
            for (int j = 0; j < mx; j++){
                matPeso[i][j] = 1000000; //inicializa con infinitos
            }
        }
        numVerts = 0;
    }
    
    public void nuevoVertice (String nom)
    {
        boolean esta = numVertice(nom) >= 0;
        if (!esta) 
        {
            Vertice v = new Vertice(nom); 
            v.asigVert(numVerts);
            verts[numVerts++] = v;
        }
    } 


    public int numVertice(String vs) //numVertice() busca el vértice en el array. Devuelve-1 si no lo encuentra
    {
        Vertice v = new Vertice(vs);
        boolean encontrado = false;
        int i = 0;
        
        for (; (i < numVerts) && !encontrado;)
        {
            encontrado = verts[i].equals(v);
            if (!encontrado) i++ ; 
        }
        
        return (i < numVerts) ? i : -1 ;
    }
    
    
    public void nuevoArco(String a, String b, double peso)throws Exception
    {
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        
        if (va < 0 || vb < 0) {
            throw new Exception ("Vértice no existe");
            }
        else{
            matAd[va][vb] = 1;
            matAd[vb][va] = 1; //Si va a ser NO DIRIGIDA DEJAR ESTO
            matPeso[va][vb] = peso;
            matPeso[vb][va] = peso; //Si va a ser NO DIRIGIDA DEJEMOS ESOT
        }
    }
    
    
    
    public boolean adyacente(String a, String b)throws Exception
    {
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);

        if (va < 0 || vb < 0) {
            throw new Exception ("Vértice no existe");
        }
        else{
            return matAd[va][vb] == 1;
        }
    }

    public int[][] getMatAd() {
        return matAd;
    }

    public double[][] getMatPeso() {
        return matPeso;
    }

    public int getNumVerts() {
        return numVerts;
    }
    
    
}



package tareaesdgrafos;
import grafo.*;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
/**
 *AM11098
 */
public class TareaESDGrafos {

    public static void main(String[] args) throws Exception{
        DecimalFormat df = new DecimalFormat("0.00");
        int mx;
        boolean x;
        
        GrafoMatriz V = new GrafoMatriz(); 
        
        //Inicializacion de Vertices o Nodos
        V.nuevoVertice("Catedral");
        V.nuevoVertice("USAM");
        V.nuevoVertice("Tecnologica");
        V.nuevoVertice("A.B");
        V.nuevoVertice("NSS");
        V.nuevoVertice("UFG");
        V.nuevoVertice("Modular");
        V.nuevoVertice("Pedagogica");
        V.nuevoVertice("UES");
        V.nuevoVertice("Panamericana");
        V.nuevoVertice("Cristiana");
        V.nuevoVertice("Politecnica");
        V.nuevoVertice("Evangelica");
        V.nuevoVertice("Don Bosco");
        V.nuevoVertice("Luterana");
        
        //Inicializacion de Arcos
        V.nuevoArco("Catedral", "USAM", 1.5);
        V.nuevoArco("USAM", "Tecnologica", 1.4);
        V.nuevoArco("Tecnologica", "A.B", 1.9);
        V.nuevoArco("A.B", "NSS", 0.5);
        V.nuevoArco("NSS", "UFG", 1.2);
        V.nuevoArco("UFG", "Modular", 1.2);
        V.nuevoArco("Catedral", "Luterana", 3.6);
        V.nuevoArco("Catedral", "Don Bosco", 7.2);
        V.nuevoArco("Catedral", "Cristiana", 1.7);
        V.nuevoArco("Cristiana", "Politecnica", 0.9);
        V.nuevoArco("Catedral", "Pedagogica", 3.9);
        V.nuevoArco("Tecnologica", "Pedagogica", 2.7);
        V.nuevoArco("A.B", "UES", 1.8);
        V.nuevoArco("Pedagogica", "UES", 1.4);
        V.nuevoArco("UFG", "Panamericana", 1.4);
        V.nuevoArco("Panamericana", "Evangelica", 2.7);
        V.nuevoArco("Modular", "Evangelica", 3.0);
        
        /*
        GrafoMatriz v1 = new GrafoMatriz();
        v1.nuevoVertice("A");
        System.out.println(v1.numVertice("A"));
        v1.nuevoVertice("B");
        System.out.println(v1.numVertice("B"));
        v1.nuevoVertice("C");
        System.out.println(v1.numVertice("C"));
        
        
        v1.nuevoArco("A", "B", 1.0); //Donde llega, De Donde viene, peso
        x = v1.adyacente("B", "A");
        System.out.println("Son adyacentes?"+x);
        
        v1.nuevoArco("B", "C", 1.0);
        x = v1.adyacente("C", "B");
        System.out.println("Son adyacentes?"+x);
        
        v1.nuevoArco("A", "C", 5.0);
        */
        
        mx = V.getNumVerts(); //Nuemro de Vertices o Nodos
        
        //Imprime Matriz de pesos
        double [][] Pesos;
        Pesos = new double [mx][mx];
        Pesos = V.getMatPeso();
        
        for (int i = 0; i < mx; i++){
            for (int j = 0; j < mx; j++){
                
                
                if(Pesos[j][i] == 1000000.0){
                 System.out.print("- "+"INF"+" -");
             }   
             else{
             System.out.print("- "+Pesos[j][i]+" -");
            }
            }
            System.out.println("\n");
        }
        
        //Imprime Matriz Adyacencia
        int [][] Adya;
        Adya = new int [mx][mx];
        Adya = V.getMatAd();
        
        for (int i = 0; i < mx; i++){
            for (int j = 0; j < mx; j++){
                
            
                 System.out.print("- "+Adya[j][i]+" -");
             }   
        
            
            System.out.println("\n");
        }
        
        
        //JOptionPane.showMessageDialog(null, Adya);
        
        // CAMBIEN LOS VALORES PARA IR DE UN GRAFO A OTRO Y CORRANLO 
        //ME DIO WUEBA CREAR VARIABLES Xd
        
        ///Recorrido Dijsktraffjs :v
        
        
        
        
        
        
        
        
        
        CaminoMinimo CM = new CaminoMinimo(V, 0); //Donde esta?
        CM.caminoMinimos(); //Imprime costos minimos
        
        CM.recuperaCamino(5); //A que vertice quiere ir? Imprime camino 
        CM.ruta(5); //A que vertice quiere ir? camino mas explicito
        
        
        
        
        
        
        
    }
}

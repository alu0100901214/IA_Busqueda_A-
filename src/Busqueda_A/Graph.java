
package Busqueda_A;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Sergio Gonz�lez Guerra
 *
 */
// Clase que representa un Grafo no dirigido.
public class Graph {
	
	private ArrayList<Node> nodes_ = new ArrayList<Node>();	// Guarda una Lista con todos los nodos del Grafo.
	private int nArches_;									// N�mero total de arcos del Grafo.
	
	// Constructor vac�o.
	public Graph(){}
	// Constructor que lee los ficheros y los interpreta para guardar la informaci�n del Grafo y sus Heur�sticas.
	public Graph(File archive1, File archive2) throws IOException {
		FileReader fr1 = new FileReader(archive1);
		BufferedReader br1 = new BufferedReader(fr1);
		String cad = "";
		
		// Leo la primera l�nea con el n�mero de nodos.
		cad = br1.readLine();
		int n = Integer.parseInt(cad);
		
		// A�ado los nodos a la lista de nodos.
		for (int i = 0; i < n; i++) {
			Node auxNode = new Node(i+1);
			nodes_.add(auxNode);
		}
		
		int a = 0;
		int b = a+1;
		
		while((cad = br1.readLine()) != null) {
			if(Double.parseDouble(cad) != -1) {	
				Arc auxArc = new Arc();
				auxArc.setCost(Double.parseDouble(cad));
				auxArc.setStart(nodes_.get(a));
				auxArc.setEnd(nodes_.get(b));
				nArches_++;
				nodes_.get(a).addArc(auxArc);
				auxArc = new Arc();
				auxArc.setCost(Double.parseDouble(cad));
				auxArc.setStart(nodes_.get(b));
				auxArc.setEnd(nodes_.get(a));
				nodes_.get(b).addArc(auxArc);
			}
			
			if(b<n-1) {
				b++;
			}else {
				a++;
				b=a+1;
			}
		}
		br1.close();
		
		// Leo el archivo de heur�sticas y las a�ado a sus nodos correspondientes.
		
		FileReader fr2 = new FileReader(archive2);
		BufferedReader br2 = new BufferedReader(fr2);
		cad = "";
		
		cad = br2.readLine();
		n = Integer.parseInt(cad);
		
		for (int i = 0; i < n; i++) {
			cad = br2.readLine();
			nodes_.get(i).setHeuristic(Double.parseDouble(cad));
		}
		
		
		br2.close();
		
	}
	
	//Getters
	public ArrayList<Node> getNodes() { return nodes_; }
	public Node getNode(int i) { return nodes_.get(i); }
	public int getNArches() { return nArches_; } 
	
	// Setters 
	public void addNode(Node node) { nodes_.add(node); }
	
	// Devuelve un String con el contenido de la clase.
	public String toString() {
		String cad="\\n\\n GRAFO\\n\\n";
		for (int i = 0; i < nodes_.size(); i++) {
			cad += nodes_.get(i).toString();
		}
		cad += "\n\n HEUR�STICAS\n\n";
		for (int j = 0; j < nodes_.size(); j++) {
			cad += nodes_.get(j).getVal() + " - " + nodes_.get(j).getHeuristic() + "\n";
		}
		
		return cad;
	}
}

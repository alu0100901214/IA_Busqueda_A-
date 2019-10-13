
package Busqueda_A;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Sergio González Guerra
 *
 */
public class Graph {
	
	private ArrayList<Node> nodes_ = new ArrayList<Node>();
	
	public Graph(){}
	
	public Graph(File archive) throws IOException {
		FileReader fr = new FileReader(archive);
		BufferedReader br = new BufferedReader(fr);
		String cad = "";
		
		// Leo la primera línea con el número de nodos.
		cad = br.readLine();
		int n = Integer.parseInt(cad);
		
		// Añado los nodos a la lista de nodos.
		for (int i = 0; i < n; i++) {
			Node auxNode = new Node(i+1);
			nodes_.add(auxNode);
		}
		
		int a = 0;
		int b = a+1;
		
		while((cad = br.readLine()) != null) {
			if(cad != "-1") {	// MIRAR
				Arc auxArc = new Arc();
				auxArc.setCost(Double.parseDouble(cad));
				auxArc.setStart(nodes_.get(a));
				auxArc.setEnd(nodes_.get(b));
				
				nodes_.get(a).addArc(auxArc);
			}
			
			if(b<n-1) {
				b++;
			}else {
				a++;
				b=a+1;
			}
				
		}
	}
	
	//Getters
	public ArrayList<Node> getNodes() { return nodes_; }
	
	// Setters 
	public void addNode(Node node) { nodes_.add(node); }
	
	public String toString() {
		String cad="";
		for (int i = 0; i < nodes_.size(); i++) {
			cad += nodes_.get(i).toString();
		}
		
		return cad;
	}
}

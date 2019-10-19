
package Busqueda_A;

import java.io.File;
import java.io.IOException;
/**
 * @author Sergio González Guerra
 *
 */
public class main {
	
	public static void main(String[] args) throws IOException{
	 	
		System.out.println("\nGRAFO:\n");
		File archive = new File(args[0]);
		Graph graph = new Graph(archive);
		System.out.println(graph);
		
	}

}

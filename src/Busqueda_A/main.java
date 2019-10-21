
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
		File archive1 = new File(args[0]);
		File archive2 = new File(args[1]);
		Graph graph = new Graph(archive1, archive2);
		System.out.println(graph);
		
	}

}

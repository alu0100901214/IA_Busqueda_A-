
package Busqueda_A;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * @author Sergio González Guerra
 *
 */
public class main {
	
	public static void main(String[] args) throws IOException{
	 	
		System.out.println("\nGRAFO:\n");
		File archive1 = new File(args[0]);
		File archive2 = new File(args[1]);
		
		int start, end = 0;
		System.out.println(" Introduce start node: ");
		Scanner sc = new Scanner(System.in);
		String cad = sc.nextLine();
		start = Integer.parseInt(cad);
		System.out.println(" Introduce end node: ");
		sc = new Scanner(System.in);
		cad = sc.nextLine();
		end = Integer.parseInt(cad);
		AStarSearch as = new AStarSearch(archive1, archive2, start, end);
		System.out.println(as.getGraph());
		
	}

}

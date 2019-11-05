
package Busqueda_A;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * @author Sergio González Guerra
 *
 */
// Clase principal que inicia el programa.
public class main {
	
	public static void main(String[] args) throws IOException{
	 	
		// Carga los ficheros de los primeros 2 argumentos.
		File archive1 = new File(args[0]);
		File archive2 = new File(args[1]);
		
		int start, end = 0;
		System.out.println(" Introduce el Nodo de comienzo: ");
		Scanner sc = new Scanner(System.in);
		String cad = sc.nextLine();
		start = Integer.parseInt(cad);
		System.out.println(" Introduce el Nodo final: ");
		sc = new Scanner(System.in);
		cad = sc.nextLine();
		end = Integer.parseInt(cad);
		AStarSearch as = new AStarSearch(archive1, archive2, start, end);
		as.writeResults();
		sc.close();
		
	}

}

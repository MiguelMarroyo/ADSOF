package Testers;

import practica5.Function;
import practica5.TextConsole;

/**
 * 
 * Prueba la funcionalidad del apartado 2
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */
public class TesterP3 {

	
	public static void main(String[] args){
		
		TextConsole consola = new TextConsole();
		
		// Creacion de nuevos comandos
		Function fun1 = (h)-> System.out.println(h);
		Function fun2 = (h) -> System.out.println("Saludos" + h);
		
		consola.addCommands("Hola", fun1);
		consola.addCommands("Saludos", fun2);
				
		consola.run(); // Ejecucion de la consola
		
		System.out.println("Fin del tester");
		
	}
	
	
}


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
	
		String hola = "Saludos profesor";
		
		Function fun1 = (h)-> System.out.println(h);
		
		consola.addCommands("Hola", fun1);
		
		consola.run();
		
		
		fun1.execute(hola);

		// Creacion de nuevos comandos
		
		System.out.println("Fin");
		
		
		// Ejecucion de la consola
		
	}
	
	
	
	
}


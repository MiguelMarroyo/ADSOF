package practica5;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Define la consola de comandos
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */
public class TextConsole{
	
	
	private Map<String, Function> commands;
	
	public TextConsole(){
		this.commands = new HashMap<String, Function>();
	}
	
	
	/**
	 * Bucle de la consola
	 */
	public void run(){
		
		while(true){
			
			
			
		}
		
		
	}
	
	/**
	 * Anade comandos a la consola
	 * @param name Nombre del comando
	 * @param op Funcion que realiza
	 */
	public void addCommands(String name, Function op){
		
		commands.put(name, op);
		
		
	}
	
	

}

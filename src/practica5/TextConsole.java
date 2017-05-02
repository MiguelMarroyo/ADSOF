package practica5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
	@SuppressWarnings("resource")
	public void run(){
		
		Scanner scanner = new Scanner(System.in);
		
		while(true){

			System.out.println("Introduzca el nombre del comando y sus argumentos");
			
			String comando = scanner.nextLine();
			
			String[] comandos = comando.split(" ");
			
			// Si se introduce un enter: return (fin)
			if(comando.isEmpty()){
				return;
			}
			
			Function func = commands.get(comandos[0]);
			
			func.execute(comandos[1]);
			
		}
		
		
	}
	
	/**
	 * Anade comandos a la consola
	 * @param name Nombre del comando
	 * @param op Funcion que realiza
	 */
	public void addCommands(String name, Function op){
		
		commands.put(name, op);
		return;
		
	}
	
	

}
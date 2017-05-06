package practica5;

import java.util.ArrayList;
import java.util.Date;
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
	
	private Task tareaActual;
	private Tasks tareasTotales;
	
	private Date startDate;
	private Date endDate;
	
	private int segundos;
	
	/**
	 * Constructor de la clase TextConsole
	 */
	public TextConsole(){
		
		this.commands = new HashMap<String, Function>();
		this.tareasTotales = new Tasks();
		
		
		// Creacion de lambdas
		Function fun1 = (h) -> this.start(h[0]);
		
		
		// Anadir lambdas
		this.addCommands("start", fun1);
		
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
			
			if (func == null){
				
				System.out.println("Comandos disponibles:");
				
				ArrayList<String> lista = new ArrayList<String>(commands.keySet());
				
				for (String nombre : lista){
					
					System.out.println(nombre);
					
				}
				
			}else
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
	
	/**
	 * Crea e inicia una tarea
	 * @param taskName Nombre de la tarea
	 */
	private void start(String taskName){
		
		// Buscamos la tarea (por si ya existe)
		
		Task newTask = tareasTotales.buscarTarea(taskName);
		
		if (newTask == null){
			
			this.tareasTotales.newTask(taskName);
			
		}
		
		startDate = new Date(); // Iniciamos el contador
		
		
		
		
	}
	
	
	

}

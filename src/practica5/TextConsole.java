package practica5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
		Function fun2 = (h) -> this.stop();
		Function fun3 = (h) -> this.addEstimate(h[0]);
		Function fun4 = (h) -> this.spend(h[0]);
		Function fun5 = (h) -> this.parent(this.tareasTotales.buscarTarea(h[0]));
		Function fun6 = (h) -> this.list();
		Function fun7 = (h) -> this.status(h[0]);
		
		// Anadir funciones
		this.addCommands("start", fun1);
		this.addCommands("stop", fun2);
		this.addCommands("addEstimate", fun3);
		this.addCommands("spend", fun4);
		this.addCommands("parent", fun5);
		this.addCommands("list", fun6);
		this.addCommands("status", fun7);
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
				
			}else{
				
				if(comandos.length == 1){
					func.execute();
				}else
					func.execute(comandos[1]);
			}
				
							
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
		
		if(tareaActual != null){
			
			stop(); // Si ya existe una tarea previa, stop
			
		}
		
		tareaActual = tareasTotales.buscarTarea(taskName); // Asignamos la tarea creada (o ya existente) como tarea actual
		
		
	}
	
	/**
	 * Detiene la tarea actual anadiendo el tiempo dedicado transcurrido desde el inicio
	 */
	private void stop(){
		
		endDate = new Date();
		
		segundos = (int)((endDate.getTime() - startDate.getTime()) / 1000); // Calculamos los segundos transcurridos
		
		tareaActual.cambiarDedicado(segundos); // cambiar el tiempo dedicado
		
		tareaActual = null; // eliminamos la tarea
		
		return;
		
		
	}
	
	/**
	 * Anade/resta tiempo estimado a la tarea actual
	 * @param minutos Minutos a anadir/restar
	 */
	private void addEstimate (String minutos){
		
		int tiempo = Integer.parseInt(minutos);
		
		tareaActual.cambiarEstimado(tiempo);
		
		return;
		
	}
	
	/**
	 * Anade/resta tiempo dedicado a la tarea actual
	 * @param minutos Minutos a anadir/restar
	 */
	private void spend (String minutos){
		
		int tiempo = Integer.parseInt(minutos);
		
		tareaActual.cambiarDedicado(tiempo);
		
		return;
	}
	
	/**
	 * Cambia la tarea padre de la tarea actual
	 * @param parentTask Nueva tarea padre
	 */
	private void parent (Task parentTask){
		
		if (parentTask == null){
			
			tareaActual.setParent(null);
			return;
			
		}
		
		tareaActual.setParent(parentTask);
		
		return;
		
	}
	
	/**
	 * Muestra la lista de tareas existentes (alfabeticamente)
	 */
	private void list(){
		
		HashSet<Task> tareas = tareasTotales.getTareas();
		
		List<Task> sortedList = new ArrayList<Task>(tareas);
		Collections.sort(sortedList);
		
		System.out.println(sortedList);
		
	}
	
	/**
	 * Muestra el estado de la tarea taskName o de la actual
	 * @param taskName Nombre de la tarea
	 */
	private void status (String taskName){
		
		if(taskName == null){
			
			System.out.println("Tarea actual: " + tareaActual.getName());
			
			if(tareaActual.getParent() == null){
				System.out.println("Tarea padre: Ninguna tarea asignada");
			}else
				System.out.println("Tarea padre: " + tareaActual.getParent().getName());
			
			System.out.println("Tiempo estimado: " + tareaActual.getEstimated().getValue().toString());
			System.out.println("Tiempo dedicado: " + tareaActual.getDedicated().getValue().toString());
			return;
			
		}
		
		Task tarea = tareasTotales.buscarTarea(taskName);
		System.out.println("Tarea: " + tarea.getName());
		
		if(tarea.getParent() == null){
			System.out.println("Tarea padre: Ninguna tarea asignada");
		}else
			System.out.println("Tarea padre: " + tarea.getParent().getName());
		
		
		System.out.println("Tiempo estimado: " + tarea.getEstimated().getValue().toString());
		System.out.println("Tiempo dedicado: " + tarea.getDedicated().getValue().toString());
		
		return;
		
		
	}

}

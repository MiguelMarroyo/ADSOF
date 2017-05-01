package Testers;
import Codigo.DefaultPropertyObserver;
import Codigo.Task;
import Codigo.Tasks;

/**
 * 
 * Prueba la funcionalidad del apartado 2
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */
public class TesterP2 {
	
	public static void main(String[] args){
		
		// Crear tasks
		Tasks tareas = new Tasks();
		
		// Crear tarea
		tareas.newTask("tarea");
		
		try{
			
			tareas.newTask("TAREA");
			
		}catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		// Anadir subtarea a la ya creada
		tareas.newTask("subtarea");
		
		Task subtarea = tareas.buscarTarea("subtarea");
		
		tareas.buscarTarea("tarea").addTask(subtarea);
		
		// Intentar anadir subtarea como padre de tarea
		try{
			tareas.buscarTarea("tarea").setParent(subtarea);
		}catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		DefaultPropertyObserver obs1 = new DefaultPropertyObserver();
		
		tareas.buscarTarea("tarea").getEstimated().addObserver(obs1);;
		tareas.buscarTarea("tarea").getEstimated().incrementTime(5);
		
		
		return;
		
	}

}

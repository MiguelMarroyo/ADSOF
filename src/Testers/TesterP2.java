package Testers;
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
		
		// Crear tarea -> Estimado = 10; Dedicado = 2
		tareas.newTask("tarea");
		
		try{
			
			tareas.newTask("TAREA");
			
		}catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		// Anadir subtarea a la ya creada -> El tiempo de "tarea" se debe ver modificado: Estimado = 20; Dedicado = 4
		tareas.newTask("subtarea");
		
		Task subtarea = tareas.buscarTarea("subtarea");
		
		tareas.buscarTarea("tarea").addTask(subtarea);
		
		// Intentar anadir subtarea como padre de tarea
		try{
			tareas.buscarTarea("tarea").setParent(subtarea);
		}catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		subtarea.cambiarEstimado(2); // Estimado de tarea = 22
		
		// Eliminamos la subtarea -> El tiempo de "tarea" se debe ver modificado
		tareas.buscarTarea("tarea").removeTask(subtarea);
		
		
		return;
		
	}

}

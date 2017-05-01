package Codigo;
import java.util.HashSet;
 
/**
 * 
 * Permite añadir o eliminar propiedades observables. Hereda de DefaultObservableProperty
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */ 
public class Tasks {
 
    private static Tasks Tasks = getInstance();
    private  HashSet<Task> tareas = new HashSet<Task>();
 
    public static Tasks getInstance(){
         
         if(Tasks == null){
             
            Tasks = new Tasks();
        }
         
        return Tasks;
    }
     
    /***
     * Crea una tarea con nombre indicado
     * @param taskName nombre de la tarea
     * @return nuevaTarea
     */
    public Task newTask(String taskName) throws IllegalArgumentException{

    	if (buscarTarea(taskName) != null){
    		throw new IllegalArgumentException("Tarea " + taskName + " ya existente");
    	}
    	
    	Task nuevaTarea = new Task(taskName);
    	
    	tareas.add(nuevaTarea);
    	
    	return nuevaTarea;
         
    }
     
    /**
     * Busca una tarea por nombre
     * @param tarea Nombre de la tarea
     * @return la tarea si esta, null en caso contrario
     */
    public Task buscarTarea(String tarea){
        
    	for (Task o : tareas) {
            
    		if (o.getName().equalsIgnoreCase(tarea)){
            	return o;
            }
        }
    	
    	return null;
         
    }
     
}
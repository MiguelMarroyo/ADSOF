import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Clase para definir una tarea
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */
public class Task implements ITask{
     
    private String nombre;
     
    private  HashSet<Task> subtareas = new HashSet<Task>();
     
    /**
     * Constructor de la clase Task
     * @param nom
     */
    public Task(String nom){
        
    	this.nombre = nom;
         
    }

	@Override
	public String getName() {
		return nombre;
	}



	@Override
	public boolean addTask(Task t) {
		return false;
	}



	@Override
	public boolean removeTask(Task t) {
		return false;
	}



	@Override
	public Set<Task> getTasks() {
		return null;
	}



	@Override
	public boolean containsTask(Task t) {
		return false;
	}



	@Override
	public Task getParent() {
		return null;
	}



	@Override
	public void setParent(Task parent) {
		
	}



	@Override
	public AdjustableTime getEstimated() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public AdjustableTime getDedicated() {
		// TODO Auto-generated method stub
		return null;
	}
    
   
 
}
import java.util.Set;

/**
 * 
 * Interfaz para las tareas
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */
public interface ITask {
	 	
	String getName();
	boolean addTask(Task t);
    boolean removeTask(Task t);
    Set<Task> getTasks();
    boolean containsTask(Task t);
    Task getParent();
    void setParent(Task parent);
    AdjustableTime getEstimated();
    AdjustableTime getDedicated();

}

import java.util.Collections;
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
     
    private Set<Task> subtareas = new HashSet<Task>();
    
    private Task padre;
    
    private AdjustableTime estimado;
    private AdjustableTime dedicado;
     
    /**
     * Constructor de la clase Task
     * @param nom
     */
    public Task(String nom){
        
    	this.nombre = nom;
    	this.padre = null;
    	this.estimado = null;
    	this.dedicado= null;
         
    }

	@Override
	public String getName() {
		return nombre;
	}

	@Override
	public boolean addTask(Task t) {
		
		if (t.getParent() != null){
			throw new IllegalArgumentException("La tarea ya esta contenida en otra tarea");
		}
		
		// Si esta anadida, false
		if(this.containsTask(t)){
			return false;
		}
		
		t.setParent(this);
		
		return subtareas.add(t);
		
	}

	@Override
	public boolean removeTask(Task t) {
		
		t.setParent(null);
		
		return subtareas.remove(t);
	}

	@Override
	public Set<Task> getTasks() {
		return Collections.unmodifiableSet(subtareas);
	}

	@Override
	public boolean containsTask(Task t) {
		
		// Comprobar si la tarea esta incluida directamente
		for (Task o : subtareas) {
            
    		if (o.getName().equals(t.getName())){
            	return true;
            }
        }
    	
		// Comprobar si la tarea esta incluida indirectamente
		for (Task o : subtareas) {
            
			for (Task b: o.getTasks()){

				if(b.getName().equals(t.getName())){
					return true;
				}
				
			}

        }
		
		// Si no esta directa o indirectamente, false
		return false;
		
	}

	@Override
	public Task getParent() {
		return padre;
	}

	@Override
	public void setParent(Task parent) {
		
		// Si el padre esta contenido en la tarea, exception
		if(this.containsTask(parent)){
			
			throw new IllegalArgumentException("La tarea " + parent.getName() + " esta contenida dentro de " + this.getName());
		}
		
		this.getParent().removeTask(this);
		
		parent.addTask(this);
		
		this.padre = parent;
		
		return;
		
	}

	@Override
	public AdjustableTime getEstimated() {
		return estimado;
	}

	@Override
	public AdjustableTime getDedicated() {
		return dedicado;
	}
    
   
 
}
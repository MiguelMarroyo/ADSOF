package Codigo;
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
public class Task{
     
    private String nombre;
     
    private Set<Task> subtareas = new HashSet<Task>();
    
    private Task padre;
    
    private AdjustableTime estimado;
    private AdjustableTime dedicado;
     
    DefaultPropertyObserver obsEstimado = new DefaultPropertyObserver();
    DefaultPropertyObserver obsDedicado = new DefaultPropertyObserver();
    
    /**
     * Constructor de la clase Task
     * @param nom Nombre de la tarea
     */
    public Task(String nom){
        
    	this.nombre = nom;
    	this.padre = null;
    	this.estimado = new ModifyObserver(10);
    	this.dedicado= new ModifyObserver(2);
    	
    	estimado.addObserver(obsEstimado);
    	dedicado.addObserver(obsDedicado);
    }

	/**
	 * Obtiene el nombre de la subtarea
	 * @return nombre
	 */
	public String getName() {
		return nombre;
	}

	/**
	 * Anade una subtarea
	 * @param t Subtarea a anadir
	 * @return true si se anade correctamente, false en caso contrario
	 */
	public boolean addTask(Task t) {
		
		if (t.getParent() != null){
			throw new IllegalArgumentException("La tarea ya esta contenida en otra tarea");
		}
		
		// Si esta anadida, false
		if(this.containsTask(t)){
			return false;
		}
		
		t.setParent(this);
		
		// Cambiamos los tiempos de la tarea contenedora
		this.estimado.incrementTime(t.getEstimated().getValue());
		
		this.dedicado.incrementTime(t.getDedicated().getValue());
		
		return subtareas.add(t);
		
	}

	/**
	 * Elimina una subtarea
	 * @param t Tarea a eliminar
	 * @return true si se elimina correctamente, false en caso contrario
	 */
	public boolean removeTask(Task t) {
		
		t.setParent(null);
		
		this.estimado.incrementTime(-(t.getEstimated().getValue()));
		
		this.dedicado.incrementTime(-(t.getDedicated().getValue()));
		
		return subtareas.remove(t);
	}

	/**
	 * Obtiene la lista de subtareas
	 * @return subtareas
	 */
	public Set<Task> getTasks() {
		return Collections.unmodifiableSet(subtareas);
	}

	/**
	 * Comprueba si ya esta contenida la tarea
	 * @param t Tarea a comprobar
	 * @return true si esta contenida, false en caso contrario
	 */
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

	/**
	 * Obtiene la tarea padre
	 * @return padre
	 */
	public Task getParent() {
		return padre;
	}

	/**
	 * Cambia la tarea padre la la tarea invocadora
	 * @param parent Nuevo padre
	 */
	public void setParent(Task parent) {
		
		// Si el padre esta contenido en la tarea, exception
		if(this.containsTask(parent)){
			
			throw new IllegalArgumentException("La tarea " + parent.getName() + " esta contenida dentro de " + this.getName());
		}
		
		this.padre = parent;
		
		return;
		
	}
	
	/**
	 * Obtiene el tiempo restante estimado de la tarea
	 * @return estimado
	 */
	public AdjustableTime getEstimated() {
 		return estimado;
	}

	/**
	 * Obtiene el tiempo dedicado a la tarea
	 * @return dedicado
	 */
	public AdjustableTime getDedicated() {
		return dedicado;
	}
    
	/**
	 * Permite cambiar el tiempo estimado
	 * @param value Valor de tiempo
	 */
	public void cambiarEstimado(int value){
		
		this.estimado.incrementTime(value);
		
		if(padre != null){
			
			padre.getEstimated().incrementTime(value);
			
			if(padre.getParent() != null){
				padre.getParent().cambiarEstimado(value);
			}

		}
		
		return;
		
	}
	
	/**
	 * Permite cambiar el tiempo dedicado
	 * @param value Valor de tiempo
	 */
	public void cambiarDedicado(int value){
		
		this.dedicado.incrementTime(value);
		
		if(padre != null){
			
			padre.getDedicated().incrementTime(value);
			
			if(padre.getParent() != null){
				padre.getParent().cambiarDedicado(value);
			}

		}
		
		return;
		
		
	}
	

}
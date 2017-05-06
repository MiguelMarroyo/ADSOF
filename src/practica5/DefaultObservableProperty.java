package practica5;
import java.util.ArrayList;

/**
 * 
 * Implementa ObservableProperty
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */
public abstract class DefaultObservableProperty<V> implements ObservableProperty<V>{
	
	private V valor;
	private ArrayList<PropertyObserver<V>> observadores = new ArrayList<PropertyObserver<V>>();
	
	/**
	 * Constructor de la clase DefaultObservablProperty
	 * @param value Valor inicial
	 */
	public DefaultObservableProperty(V value){
		
		this.valor = value;
		
		
	}
	
	/**
	 * Obtiene el valor
	 * @return valor
	 */
	public V getValue(){
		return valor;
		
	}
	
	/**
	 * Anade un observador
	 */
	public void addObserver(PropertyObserver<V> o) {
		
		observadores.add(o);
		return;

	}
	
	/**
	 * Elimina un observador
	 */
	public void removeObserver(PropertyObserver<V> o){
		
		observadores.remove(o);
		return;
		
	}
	
	
	/**
	 * Cambia el valor
	 * @param newValue Nuevo valor
	 * @return true si ha cambiado el valor, false en caso contrario
	 */
	protected boolean setValue(V newValue) {

		// Si el valor no ha cambiado, false
		if (newValue == valor){
			return false;
		}
		
		V valorviejo = valor;
		valor = newValue;
		
		
		// Si el valor ha cambiado, notificamos a los observadores
		for (PropertyObserver<V> obs : observadores) {
            obs.propertyChanged(this, valorviejo);
        }
		
		// Cambiamos el valor al nuevo valor
		
		
		return true;
		
		
	}
	
	@Override
	public String toString(){
		return valor.toString();
	}
	
}

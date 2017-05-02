package practica5;
/**
 * 
 * Interfaz PropertyObserver
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */
public interface PropertyObserver<V> {
	
	void propertyChanged(ObservableProperty<V> property, V oldValue);

}

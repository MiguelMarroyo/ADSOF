/**
 * 
 * Interfaz ObservableProperty
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */
public interface ObservableProperty<V> {
	
	V getValue();
	void addObserver(PropertyObserver<V> o);
	void removeObserver(PropertyObserver<V> o);
	
}
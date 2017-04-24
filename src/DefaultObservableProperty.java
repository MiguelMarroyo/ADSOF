/**
 * 
 * Implementa ObservableProperty
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */
public abstract class DefaultObservableProperty<V> implements ObservableProperty<V>{

	protected boolean setValue(V newValue) {
		return false;
	}
	
}

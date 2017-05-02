package practica5;
/**
 * 
 * Extiende la interfaz ObservableProperty
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */
public interface AdjustableTime extends ObservableProperty<Integer>{
	
	void incrementTime(int inc);

}
package Codigo;
/**
 * 
 * Implementa la interfaz PropertyObserver
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */
public class DefaultPropertyObserver implements PropertyObserver<Integer>{

	@Override
	public void propertyChanged(ObservableProperty<Integer> property, Integer oldValue) {
					
		System.out.println("El tiempo viejo es: " + oldValue + " y el tiempo nuevo es: " + property.getValue());

		
	}

}

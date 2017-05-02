package practica5;

/**
 * 
 * Define la interfaz funcional Function
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */
@FunctionalInterface
public interface Function {

	void execute(String ...args) throws IllegalArgumentException;

}
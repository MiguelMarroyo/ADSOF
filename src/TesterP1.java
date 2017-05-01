/**
 * 
 * Prueba la funcionalidad del apartado 1
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */
public class TesterP1 {

	public static void main(String[] args){
		
		// Crear observers
		DefaultPropertyObserver obs1 = new DefaultPropertyObserver();
		DefaultPropertyObserver obs2 = new DefaultPropertyObserver();
		
		ModifyObserver observado = new ModifyObserver(2);
		
		// Anadir observers
		observado.addObserver(obs1);
		observado.addObserver(obs2);
		
		// Cambiar value
		observado.incrementTime(-1); // Valor = 1
		
		observado.incrementTime(9); // Valor = 10 
		
		observado.incrementTime(-10); // Valor = 0
		
		try{
			observado.incrementTime(-1); // Exception ya que el valor es negativo
		}catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		return;
		
	}
	
	
}

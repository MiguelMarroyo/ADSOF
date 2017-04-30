/**
 * 
 * Permite añadir o eliminar propiedades observables. Hereda de DefaultObservableProperty
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */
public class ModifyObserver extends DefaultObservableProperty<Integer> implements AdjustableTime{

	/**
	 * Constructor de la clase ModifyObserver
	 * @param valor Valor inicial
	 */
	public ModifyObserver(int valor){
		
		super(valor);
		
	}
	
	
	@Override
	public void incrementTime(int inc) throws IllegalArgumentException{
		
		// Al anadir se suma valor
		
		// Al eliminar se resta valor
		if(getValue() < 0){
			
			throw new IllegalArgumentException("Valor menor que cero");
			
		}
		
	}

}

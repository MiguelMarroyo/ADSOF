package Codigo;
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
		
		int valueaux = 0;
		
		valueaux = getValue(); // Cogemos el valor inicial y le sumamos el inc
		
		valueaux += inc;
		
		this.setValue(valueaux);
		
		if(getValue() < 0){
			
			throw new IllegalArgumentException("Valor menor que cero");
			
		}
		
		return;
		
	}

}

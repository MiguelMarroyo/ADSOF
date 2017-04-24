/**
 * 
 * Permite añadir o eliminar propiedades observables
 * 
 * @author Miguel Angel Marroyo Bouzada miguel.marroyo@estudiante.uam.es
 *         Angelica L Jimenez Monar angelical.jimenez@estudiante.uam.es
 *
 */
public class ModifyObservable extends DefaultObservableProperty<Integer> implements AdjustableTime{

	private Integer value;
	private PropertyObserver<Integer> observer;
	
	public ModifyObservable(){
		
		super(0);
		
	}
	
	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public void addObserver(PropertyObserver<Integer> o) {
		observer = o;
		return;
		
	}

	@Override
	public void removeObserver(PropertyObserver<Integer> o) {
		observer = null;
		return;
		
	}

	@Override
	public void incrementTime(int inc) {
		// TODO Auto-generated method stub
		
	}

}

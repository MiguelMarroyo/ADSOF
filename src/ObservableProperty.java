public interface ObservableProperty<V> {
	
	V getValue();
	
	void addObserver(PropertyObserver<V> o);
	
	void removeObserver(PropertyObserver<V> o);
	
}
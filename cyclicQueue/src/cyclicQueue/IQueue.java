package cyclicQueue;

public interface IQueue<T> {

	public abstract void put(T obj);

	public abstract T get();

	public abstract int getSize();
	
	public abstract boolean isEmpty();

}
package datastructures.Queue;

public interface IQueue<K extends Comparable <K>, V> {
  
  public void enqueue(K key, V value);

  public boolean isEmpty();

  public V dequeue();

  public V peek();
}
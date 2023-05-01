package datastructures.Stack;

public interface StackInterface<K extends Comparable <K>, V> {

  public void push(K key,V value);

  public V pop();

  public boolean isEmpty();

  public V top();
  
}
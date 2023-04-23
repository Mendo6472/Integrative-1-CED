package datastructures.Hashtable;
import datastructures.Node;

public interface IHashTable<K extends Comparable <K>, V> {
    public void insert(K key, V value);
    public Node<K, V> search(K key);
    public V searchValue(K key);
    public void delete(K key);
}

package datastructures.Heap;

public interface PriorityQueue <K extends Comparable <K>,V>{
    public Node<K,V> maximum();
    public void insert(K key, V value);
    public Node<K, V> extractMax();
    public void increaseKey(int i, K key);
}

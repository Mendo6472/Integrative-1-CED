package datastructures.Hashtable;
import datastructures.Node;

public class HashTable<K extends Comparable <K>, V> implements IHashTable<K, V>{

    private final int SIZE;
    private Node<K,V>[] nodes;

    public HashTable(int m) {
        this.SIZE = m;
        this.nodes = new Node[SIZE];
    }

    @Override
    public void insert(K key, V value) {
    Node<K,V> newNode = new Node<K, V>(key, value);
        int i = key.hashCode()%SIZE;
        if (nodes[i] == null){
            nodes[i] = newNode;
        }else{
            Node<K, V> temp = nodes[i];
            nodes[i] = newNode;
            nodes[i].setNext(temp);
        }
    }

    @Override
    public Node<K, V> search(K key) {
        int i = key.hashCode()%SIZE;
        if(nodes[i] == null) return null;
        if(nodes[i].getKey().compareTo(key) == 0) return nodes[i];
        return search(key, nodes[i].getNext());
    }

    private Node<K, V> search (K key, Node<K, V> current){
        if(current == null) return null;
        if(current.getKey().compareTo(key) == 0) return current;
        return search(key, current.getNext());
    }

    public V searchValue(K key){
        Node<K, V> node = search(key);
        if(node != null){
            return node.getValue();
        }
        return null;
    }

    @Override
    public void delete(K key) {
        Node<K, V> node = search(key);
        if (node == null) return;
        int i = key.hashCode()%SIZE;
        if(node.getPrevious() == null){
            if(node.getNext() == null){
                nodes[i] = null;
            } else{
                nodes[i] = node.getNext();
                nodes[i].setPrevious(null);
            }
        } else if(node.getNext() == null){
            node.getPrevious().setNext(null);
        } else {
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
        }


    }
}

package datastructures.Queue;
import datastructures.Node;

public class Queue<K extends Comparable <K>, V> implements IQueue<K, V>{
  
  private Node<K, V> first;

  public Queue() {
    
  }

  public void enqueue(K key, V value) {
    Node<K,V> node = new Node<K,V>(key, value);
    if(first == null){
      first = node;
    } else {
      enqueue(node, first);
    }
  }

  private void enqueue(Node<K,V> node, Node<K, V> current){
    if (current.getNext() == null){
      current.setNext(node);
      node.setPrevious(current);
      return;
    }
    enqueue(node, current.getNext());
  }

  public boolean isEmpty() {
    return (first != null)?false:true;
  }

  public V dequeue(){
    if(first == null) return null;
    V value = first.getValue();
    if(first.getNext() == null){
      first = null;
    } else {
      first.getNext().setPrevious(null);
      first = first.getNext();
    }
    return value;
  }

  public V peek(){
    return (first != null)?first.getValue():null;
  }

}
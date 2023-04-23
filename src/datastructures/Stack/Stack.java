package datastructures.Stack;
import datastructures.Node;

public class Stack<K extends Comparable <K>, V> implements StackInterface<K, V> {

  private Node<K,V> last;

  public Stack() {
    
  }

  public boolean isEmpty() {
    return (last != null)?false:true;
  }
  
  public void push(K key, V value) {
    Node<K, V> node = new Node<K, V>(key, value);
    if(last == null) {
      last = node;
      return;
    }
    last.setNext(node);
    node.setPrevious(last);
    last = node;
  }

  public V top(){
    return (last != null)?last.getValue():null;
  }

  public V pop(){
    if(isEmpty()) return null;
    V value = last.getValue();
    if(last.getPrevious() == null){
      last = null;
      return value;
    }
    last.getPrevious().setNext(null);
    last = last.getPrevious();
    return value;
  }
  
}
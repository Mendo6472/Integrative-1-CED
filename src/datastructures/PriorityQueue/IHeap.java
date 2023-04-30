package datastructures.Heap;

import java.util.ArrayList;

public interface IHeap<K extends Comparable <K>, V> {
    public void maxHeapify(int i);
    public void buildMaxHeap();
    public void heapSort();
    public int getDad(int i);
    public int getLeft(int i);
    public int getRight(int i);
    public ArrayList<Node<K,V>> getHeap();
}

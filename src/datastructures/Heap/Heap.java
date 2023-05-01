package datastructures.Heap;
import datastructures.Node;

import java.util.ArrayList;

public class Heap<K extends Comparable <K>, V> implements IHeap<K,V>{
    int heapSize;
    ArrayList<Node<K,V>> arr;

    public Heap(){
        arr = new ArrayList<>();
    }

    @Override
    public void maxHeapify(int i) {
        int largest = i;
        int l = getLeft(i);
        int r = getRight(i);
        if (l < heapSize && arr.get(l).getKey().compareTo(arr.get(i).getKey()) > 0){
            largest = l;
        }
        if (r < heapSize && arr.get(r).getKey().compareTo(arr.get(largest).getKey()) > 0){
            largest = r;
        }
        if (largest != i){
            Node<K, V> temp = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, temp);
            maxHeapify(largest);
        }
    }

    @Override
    public void buildMaxHeap() {
        heapSize = arr.size();
        for (int i = (arr.size() / 2) - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    @Override
    public void heapSort() {
        buildMaxHeap();
        for (int i = arr.size() - 1; i >= 1; i--) {
            Node<K, V> temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);
            heapSize -= 1;
            maxHeapify(0);
        }
    }

    public void showHeap(){
        for (Node<K,V> node : arr) {
            System.out.print(node.getValue() + " ");
        }
        System.out.println();
    }

    @Override
    public int getDad(int i) {
        i += 1;
        if(i == 0){
            return i;
        }else{
            return (i/2) - 1;
        }
    }

    @Override
    public int getLeft(int i) {
        i += 1;
        return (i*2) - 1;
    }

    @Override
    public int getRight(int i) {
        i += 1;
        return i*2;
    }

    @Override
    public ArrayList<Node<K,V>> getHeap(){
        return arr;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int newHeapSize) {
        this.heapSize = newHeapSize;
    }
}

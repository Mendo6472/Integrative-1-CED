package datastructures.PriorityQueue;

import datastructures.Node;
import model.InputPriority;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    PriorityQueue<Integer, String> priorityQueue;
    PriorityQueue<InputPriority, String> entrancePriorityQueue;


    void setupStage1(){
        priorityQueue = new Heap<>();
    }

    void setupStage2(){
        entrancePriorityQueue = new Heap<>();
    }

    @Test
    void insertTest() {
        setupStage1();
        Integer key = 3;
        String value = "Alejandro";
        priorityQueue.insert(key, value);
    }

    @Test
    void insertTenNodesTests(){
        setupStage1();
        priorityQueue.insert(1, "A");
        priorityQueue.insert(2, "B");
        priorityQueue.insert(3, "C");
        priorityQueue.insert(4, "D");
        priorityQueue.insert(5, "E");
        priorityQueue.insert(6, "F");
        priorityQueue.insert(7, "G");
        priorityQueue.insert(8, "H");
        priorityQueue.insert(9, "I");
        priorityQueue.insert(10, "J");
    }

    @Test
    void insertInputPriorityKeyTest(){
        setupStage2();
        InputPriority key = new InputPriority("no","no",10F,"F5",10);
        String value = "F5";
        entrancePriorityQueue.insert(key, value);
    }

    @Test
    void extractMaxTest() {
        setupStage1();
        Integer key = 3;
        String value = "Alejandro";
        priorityQueue.insert(key, value);
        Node<Integer, String> max = priorityQueue.extractMax();
        assertEquals(max.getKey(), key);
        assertEquals(max.getValue(), value);
    }

    @Test
    void extractMaxOfTenTest(){
        setupStage1();
        Integer maxKey = 10;
        String maxValue = "H";
        priorityQueue.insert(9, "A");
        priorityQueue.insert(7, "B");
        priorityQueue.insert(8, "C");
        priorityQueue.insert(3, "D");
        priorityQueue.insert(5, "E");
        priorityQueue.insert(1, "F");
        priorityQueue.insert(2, "G");
        priorityQueue.insert(maxKey, maxValue);
        priorityQueue.insert(4, "I");
        priorityQueue.insert(6, "J");
        Node<Integer, String> max = priorityQueue.extractMax();
        assertEquals(max.getKey(), maxKey);
        assertEquals(max.getValue(), maxValue);
    }

    @Test
    void extractMaxInputPriorityTest(){
        setupStage2();
        InputPriority minKey = new InputPriority("no","no",10F,"A5",50);
        InputPriority midKey = new InputPriority("yes","no",20F,"C3",30);
        InputPriority maxKey = new InputPriority("yes","yes",30F,"E1",10);
        String maxValue = "E1";
        entrancePriorityQueue.insert(minKey, "A5");
        entrancePriorityQueue.insert(maxKey, maxValue);
        entrancePriorityQueue.insert(midKey, "C3");
        Node<InputPriority, String> max = entrancePriorityQueue.extractMax();
        assertEquals(max.getValue(), maxValue);
        assertEquals(max.getKey(), maxKey);
    }
}
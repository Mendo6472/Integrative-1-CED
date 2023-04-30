package datastructures.Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    IQueue<Integer, String> queue;
    IQueue<String, String> stringQueue;

    void setupStage1(){
        queue = new Queue<>();
    }

    void setupStage2(){
        stringQueue = new Queue<>();
    }
    @Test
    void enqueueTest() {
        setupStage1();
        Integer key = 2;
        String value = "Julian";
        queue.enqueue(key, value);
        assertFalse(queue.isEmpty());
    }

    @Test
    void enqueueTenNodesTest(){
        setupStage1();
        queue.enqueue(1, "A");
        queue.enqueue(2, "B");
        queue.enqueue(3, "C");
        queue.enqueue(4, "D");
        queue.enqueue(5, "E");
        queue.enqueue(6, "F");
        queue.enqueue(7, "G");
        queue.enqueue(8, "H");
        queue.enqueue(9, "I");
        queue.enqueue(10, "J");
        assertFalse(queue.isEmpty());
    }

    @Test
    void enqueueStringKeyTest(){
        setupStage2();
        String key = "A";
        String value = "A";
        stringQueue.enqueue(key,value);
        assertFalse(stringQueue.isEmpty());
    }

    @Test
    void dequeueTest() {
        setupStage1();
        Integer key = 2;
        String value = "Julian";
        queue.enqueue(key, value);
        String dequeuedValue = queue.dequeue();
        assertEquals(value, dequeuedValue);
        assertTrue(queue.isEmpty());
    }

    @Test
    void dequeueOneOfThreeTest(){
        setupStage1();
        Integer key = 2;
        String value = "Julian";
        queue.enqueue(key, value);
        queue.enqueue(3, "Alejo");
        queue.enqueue(4, "Santiago");
        String dequeuedValue = queue.dequeue();
        assertEquals(value, dequeuedValue);
        assertFalse(queue.isEmpty());
    }

    @Test
    void dequeueStringKeyTest(){
        setupStage2();
        String key = "A";
        String value = "Alejo";
        stringQueue.enqueue(key,value);
        String dequeuedValue = stringQueue.dequeue();
        assertEquals(value, dequeuedValue);
        assertTrue(stringQueue.isEmpty());
    }

    @Test
    void peekTest() {
        setupStage1();
        Integer key = 2;
        String value = "Julian";
        queue.enqueue(key, value);
        String peekedValue = queue.peek();
        assertEquals(value, peekedValue);
        assertFalse(queue.isEmpty());
    }

    @Test
    void peekOneOfThreeTest(){
        setupStage1();
        Integer key = 2;
        String value = "Julian";
        queue.enqueue(key, value);
        queue.enqueue(3, "Alejo");
        queue.enqueue(4, "Santiago");
        String peekedValue = queue.peek();
        assertEquals(value, peekedValue);
        assertFalse(queue.isEmpty());
    }

    @Test
    void peekStringKeyTest(){
        setupStage2();
        String key = "A";
        String value = "Alejo";
        stringQueue.enqueue(key,value);
        String peekedValue = stringQueue.peek();
        assertEquals(value, peekedValue);
        assertFalse(stringQueue.isEmpty());
    }

}
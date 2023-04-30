package datastructures.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    StackInterface<Integer, String> stack;
    StackInterface<String, String> stringStack;

    void setupStage1(){
        stack = new Stack<>();
    }

    void setupStage2(){
        stringStack = new Stack<>();
    }
    @Test
    void pushTest() {
        setupStage1();
        Integer key = 2;
        String value = "Julian";
        stack.push(key, value);
        assertFalse(stack.isEmpty());
    }

    @Test
    void pushTenNodesTest(){
        setupStage1();
        stack.push(1, "A");
        stack.push(2, "B");
        stack.push(3, "C");
        stack.push(4, "D");
        stack.push(5, "E");
        stack.push(6, "F");
        stack.push(7, "G");
        stack.push(8, "H");
        stack.push(9, "I");
        stack.push(10, "J");
        assertFalse(stack.isEmpty());
    }

    @Test
    void pushStringKeyTest(){
        setupStage2();
        String key = "A";
        String value = "A";
        stringStack.push(key,value);
        assertFalse(stringStack.isEmpty());
    }

    @Test
    void popTest() {
        setupStage1();
        Integer key = 2;
        String value = "Julian";
        stack.push(key, value);
        String poppedValue = stack.pop();
        assertEquals(value, poppedValue);
        assertTrue(stack.isEmpty());
    }

    @Test
    void popOneOfThreeTest(){
        setupStage1();
        Integer key = 2;
        String value = "Julian";
        stack.push(3, "Alejo");
        stack.push(4, "Santiago");
        stack.push(key, value);
        String poppedValue = stack.pop();
        assertEquals(value, poppedValue);
        assertFalse(stack.isEmpty());
    }

    @Test
    void popStringKeyTest(){
        setupStage2();
        String key = "A";
        String value = "Alejo";
        stringStack.push(key,value);
        String poppedValue = stringStack.pop();
        assertEquals(value, poppedValue);
        assertTrue(stringStack.isEmpty());
    }

    @Test
    void topTest() {
        setupStage1();
        Integer key = 2;
        String value = "Julian";
        stack.push(key, value);
        String topValue = stack.top();
        assertEquals(value, topValue);
        assertFalse(stack.isEmpty());
    }

    @Test
    void topOneOfThreeTest(){
        setupStage1();
        Integer key = 2;
        String value = "Julian";
        stack.push(3, "Alejo");
        stack.push(4, "Santiago");
        stack.push(key, value);
        String topValue = stack.pop();
        assertEquals(value, topValue);
        assertFalse(stack.isEmpty());
    }

    @Test
    void topStringKeyTest(){
        setupStage2();
        String key = "A";
        String value = "Alejo";
        stringStack.push(key,value);
        String topValue = stringStack.top();
        assertEquals(value, topValue);
        assertFalse(stringStack.isEmpty());
    }

}
package datastructures.HashTable;

import datastructures.Node;
import model.Passenger;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    private IHashTable<Integer, String> hashTable;
    private IHashTable<Integer, Passenger> passengerHashTable;

    void setupStage1(){
        hashTable = new HashTable<>(5);
    }

    void setupStage2(){
        passengerHashTable = new HashTable<>(5);
    }

    @Test
    void insertOneNodeTest(){
        setupStage1();
        hashTable.insert(3, "Santiago");
    }

    @Test
    void insertTenNodesTest(){
        setupStage1();
        hashTable.insert(3, "A");
        hashTable.insert(2, "B");
        hashTable.insert(10, "C");
        hashTable.insert(4, "D");
        hashTable.insert(20, "E");
        hashTable.insert(1, "F");
        hashTable.insert(5, "G");
        hashTable.insert(6, "H");
        hashTable.insert(8, "I");
        hashTable.insert(9, "J");
    }

    @Test
    void insertWithPassengerValue(){
        setupStage2();
        Integer key = 3;
        Passenger passenger = new Passenger("F1","Santiago","no","no",10,10);
        passengerHashTable.insert(key, passenger);
    }

    @Test
    void addOneSearchOneTest(){
        setupStage1();
        Integer key = 1;
        String value = "Alejandro";
        hashTable.insert(key, value);
        Node<Integer, String> foundNode = hashTable.search(key);
        assertEquals(foundNode.getKey(), key);
        assertEquals(foundNode.getValue(), value);
    }

    @Test
    void searchNonExistentKey(){
        setupStage1();
        Integer key = 2;
        String value = "B";
        hashTable.insert(key, value);
        assertNull(hashTable.search(10));
    }

    @Test
    void searchWithPassengerHashTableTest(){
        setupStage2();
        Integer key = 3;
        Passenger value = new Passenger("F1","Santiago","no","no",10,10);
        passengerHashTable.insert(key, value);
        Node<Integer, Passenger> foundNode = passengerHashTable.search(key);
        assertEquals(foundNode.getKey(), key);
        assertEquals(foundNode.getValue(), value);
    }

    @Test
    void addOneSearchOneValueTest(){
        setupStage1();
        Integer key = 1;
        String value = "Alejandro";
        hashTable.insert(key, value);
        String foundValue = hashTable.searchValue(key);
        assertEquals(foundValue, value);
    }

    @Test
    void searchValueOfNonExistentKeyTest(){
        setupStage1();
        Integer key = 2;
        String value = "B";
        hashTable.insert(key, value);
        assertNull(hashTable.searchValue(5));
    }

    @Test
    void searchValueWithPassengerHashTableTest(){
        setupStage2();
        Integer key = 3;
        Passenger value = new Passenger("F1","Santiago","no","no",10,10);
        passengerHashTable.insert(key, value);
        Passenger foundValue = passengerHashTable.searchValue(key);
        assertEquals(foundValue, value);
    }

    @Test
    void addAndDeleteTest(){
        setupStage1();
        Integer key = 1;
        String value = "Alejandro";
        hashTable.insert(key, value);
        hashTable.delete(key);
        assertNull(hashTable.search(key));
    }

    @Test
    void addThreeAndDeleteOneTest(){
        setupStage1();
        Integer key = 2;
        String value = "B";
        hashTable.insert(1, "A");
        hashTable.insert(key, value);
        hashTable.insert(3, "C");
        hashTable.delete(key);
        assertNull(hashTable.search(key));
        assertEquals(hashTable.search(1).getKey(), 1);
        assertEquals(hashTable.search(3).getKey(), 3);
    }

    @Test
    void deleteNonExistentKeyTest(){
        setupStage1();
        Integer key = 2;
        String value = "B";
        hashTable.insert(key, value);
        hashTable.delete(3);
        Node<Integer, String> foundNode = hashTable.search(key);
        assertEquals(foundNode.getKey(), key);
        assertEquals(foundNode.getValue(), value);
    }
}
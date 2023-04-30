package model;

import datastructures.HashTable.HashTable;
import datastructures.Node;
import datastructures.PriorityQueue.PriorityQueue;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    Controller controller;
    HashTable<String, Passenger> hashtable;
    PriorityQueue<InputPriority, String> inQueue;
    PriorityQueue<OutputPriority, String> outQueue;

    //Tests are made using the passenger list from data/file.txt
    //Put that file on src/data to run the tests

    void setupStage1() throws Exception{
        controller = new Controller();
        hashtable = controller.getPassengersHash();
        inQueue = controller.getPassengersInputQueue();
        outQueue = controller.getPassengersOutputQueue();
    }


    @Test
    void passengersAddedToHashTest() throws Exception{
        setupStage1();
        Node<String, Passenger> foundNode = hashtable.search("A1");
        assertEquals(foundNode.getKey(), "A1");
        assertEquals(foundNode.getValue().getSeat(), "A1");
        assertEquals(foundNode.getValue().getFullName(), "Santiago Valencia García");
        assertEquals(foundNode.getValue().getHighClass(), "yes");
        assertEquals(foundNode.getValue().getVulnerable(), "yes");
        assertEquals(foundNode.getValue().getMiles(), 10);
    }

    @Test
    void allPassengersAddedToHashTest() throws Exception{
        setupStage1();
        Node<String, Passenger> firstPassenger = hashtable.search("B4");
        Node<String, Passenger> secondPassenger = hashtable.search("A1");
        Node<String, Passenger> thirdPassenger = hashtable.search("C5");
        assertEquals(firstPassenger.getKey(), "B4");
        assertEquals(secondPassenger.getKey(), "A1");
        assertEquals(thirdPassenger.getKey(), "C5");
        //First Passenger
        assertEquals(firstPassenger.getValue().getSeat(), "B4");
        assertEquals(firstPassenger.getValue().getFullName(), "Alejandro Londoño Bermúdez");
        assertEquals(firstPassenger.getValue().getHighClass(), "yes");
        assertEquals(firstPassenger.getValue().getVulnerable(), "no");
        assertEquals(firstPassenger.getValue().getMiles(), 10);
        //Second Passenger
        assertEquals(secondPassenger.getValue().getSeat(), "A1");
        assertEquals(secondPassenger.getValue().getFullName(), "Santiago Valencia García");
        assertEquals(secondPassenger.getValue().getHighClass(), "yes");
        assertEquals(secondPassenger.getValue().getVulnerable(), "yes");
        assertEquals(secondPassenger.getValue().getMiles(), 10);
        //Third Passenger
        assertEquals(thirdPassenger.getValue().getSeat(), "C5");
        assertEquals(thirdPassenger.getValue().getFullName(), "Julián Andrés Mendoza Castro");
        assertEquals(thirdPassenger.getValue().getHighClass(), "yes");
        assertEquals(thirdPassenger.getValue().getVulnerable(), "no");
        assertEquals(thirdPassenger.getValue().getMiles(), 10);
    }

    @Test
    void passengersAddedToInputQueueTest() throws Exception{
        setupStage1();
        Node<InputPriority, String> firstPassenger = inQueue.extractMax();
        //C5;Julián Andrés Mendoza Castro;yes;no;10
        assertEquals(firstPassenger.getKey().getSeat(), "C5");
        assertEquals(firstPassenger.getKey().getHighClass(), "yes");
        assertEquals(firstPassenger.getKey().getVulnerable(), "no");
        assertEquals(firstPassenger.getKey().getMiles(), 10);
        assertEquals(firstPassenger.getValue(), firstPassenger.getKey().getSeat());
    }

    @Test
    void allPassengerAddedToInputQueueInCorrectOrderTest() throws Exception{
        setupStage1();
        Node<InputPriority, String> firstPassenger = inQueue.extractMax();
        Node<InputPriority, String> secondPassenger = inQueue.extractMax();
        Node<InputPriority, String> thirdPassenger = inQueue.extractMax();
        assertEquals(firstPassenger.getValue(), "C5");
        assertEquals(secondPassenger.getValue(), "B4");
        assertEquals(thirdPassenger.getValue(), "A1");

        //First Passenger
        assertEquals(firstPassenger.getKey().getSeat(), "C5");
        assertEquals(firstPassenger.getKey().getHighClass(), "yes");
        assertEquals(firstPassenger.getKey().getVulnerable(), "no");
        assertEquals(firstPassenger.getKey().getMiles(), 10);

        //Second Passenger
        assertEquals(secondPassenger.getKey().getSeat(), "B4");
        assertEquals(secondPassenger.getKey().getHighClass(), "yes");
        assertEquals(secondPassenger.getKey().getVulnerable(), "no");
        assertEquals(secondPassenger.getKey().getMiles(), 10);

        //Third Passenger
        assertEquals(thirdPassenger.getKey().getSeat(), "A1");
        assertEquals(thirdPassenger.getKey().getHighClass(), "yes");
        assertEquals(thirdPassenger.getKey().getVulnerable(), "yes");
        assertEquals(thirdPassenger.getKey().getMiles(), 10);

    }

    @Test
    void passengersAddedToOutputQueueTest() throws Exception{
        setupStage1();
        Node<OutputPriority, String> firstPassenger = outQueue.extractMax();
        assertEquals(firstPassenger.getKey().getSeat(), "A1");
        assertEquals(firstPassenger.getValue(), firstPassenger.getKey().getSeat());
    }

    @Test
    void allPassengerAddedToOutputQueueInCorrectOrderTest() throws Exception{
        setupStage1();
        Node<OutputPriority, String> firstPassenger = outQueue.extractMax();
        Node<OutputPriority, String> secondPassenger = outQueue.extractMax();
        Node<OutputPriority, String> thirdPassenger = outQueue.extractMax();
        assertEquals(firstPassenger.getValue(), "A1");
        assertEquals(secondPassenger.getValue(), "B4");
        assertEquals(thirdPassenger.getValue(), "C5");

        //First Passenger
        assertEquals(firstPassenger.getKey().getSeat(), "A1");

        //Second Passenger
        assertEquals(secondPassenger.getKey().getSeat(), "B4");

        //Third Passenger
        assertEquals(thirdPassenger.getKey().getSeat(), "C5");

    }


}
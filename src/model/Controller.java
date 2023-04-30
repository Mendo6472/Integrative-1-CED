package model;

import datastructures.HashTable.HashTable;
import datastructures.PriorityQueue.Heap;
import datastructures.Node;

import java.io.*;

public class Controller {
    int rows;
    int seatsPerRow;
    HashTable<String, Passenger> passengersHash = new HashTable<>(5);
    Heap<InputPriority, String> passengersQueue = new Heap<>();

    public Controller() throws IOException {
        fillPassengers();
    }

    private void fillPassengers() throws IOException {
        String urlFile = "src/data/file.txt";
        FileReader file = new FileReader(urlFile);
        BufferedReader buffer = new BufferedReader(file);
        String currentLine;
        int lineNumber = 0;

        while((currentLine = buffer.readLine()) != null) {
            lineNumber += 1;
            if (lineNumber == 1){
                rows = Integer.parseInt(currentLine);
            }else if(lineNumber == 2){
                seatsPerRow = Integer.parseInt(currentLine);
            }else{
                String[] passenger;
                passenger = currentLine.split(";");
                passengersHash.insert(passenger[0] , new Passenger(passenger[0], passenger[1], passenger[2], passenger[3], Long.parseLong(passenger[4]), lineNumber-2));
                passengersQueue.insert(new InputPriority(passenger[2], passenger[3], Float.parseFloat(passenger[4]), passenger[0], lineNumber-2), passenger[0]);
            }
        }
        passengersQueue.buildMaxHeap();
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public HashTable<String,Passenger> getPassengersHash() {
        return this.passengersHash;
    }

    public void setPassengersHash(HashTable<String,Passenger> passengersHash) {
        this.passengersHash = passengersHash;
    }

    public Heap<InputPriority,String> getPassengersQueue() {
        return this.passengersQueue;
    }

    public void setPassengersQueue(Heap<InputPriority,String> passengersQueue) {
        this.passengersQueue = passengersQueue;
    }
}
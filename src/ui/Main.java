package ui;

import datastructures.HashTable.HashTable;
import datastructures.PriorityQueue.Heap;
import model.*;
import datastructures.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner sc;
    static Controller controller;


    public static void main(String[] args) throws IOException {
        init();
        int option = -1;
        do {
            try {
                showMenuUi();
                option = Integer.parseInt(sc.next());
                optionChooser(option);
            } catch (NumberFormatException exception) {
                System.out.println("Has ingresado una opcion no valida");
            }
        }while (option != 0);
    }

    static void init() throws IOException {
        sc = new Scanner(System.in);
        controller = new Controller();
    }

    static void showMenuUi(){
        System.out.println("Que deseas hacer?");
        System.out.println("1. Ver lista de entrada");
        System.out.println("2. Ver lista de salida");
        System.out.println("0. Salir del programa");
    }

    static void optionChooser(int option){
        switch (option){
            case 1 -> showInputQueue();
            case 2 -> showOutputQueue();
            case 0 -> System.out.println("Hasta luego");
            default -> System.out.println("Opcion no valida.");
        }
    }

    static void showInputQueue(){
        Heap<InputPriority, String> inputQueue = controller.getPassengersInputQueue();
        HashTable<String, Passenger> passengerHashtable = controller.getPassengersHash();
        int totalSeats = controller.getRows() * controller.getSeatsPerRow();
        System.out.println("-------------------------------");
        for(int i = 0; i < totalSeats; i++){
            String seat = inputQueue.extractMax().getValue();
            String passengerName = passengerHashtable.searchValue(seat).getFullName();
            System.out.println(i+1  + ". " + passengerName + ", Asiento " + seat);
        }
        System.out.println("-------------------------------");
    }

    static void showOutputQueue(){
        Heap<OutputPriority, String> outputQueue = controller.getPassengersOutputQueue();
        HashTable<String, Passenger> passengerHashtable = controller.getPassengersHash();
        int totalSeats = controller.getRows() * controller.getSeatsPerRow();
        System.out.println("-------------------------------");
        for(int i = 0; i < totalSeats; i++){
            String seat = outputQueue.extractMax().getValue();
            String passengerName = passengerHashtable.searchValue(seat).getFullName();
            System.out.println(i+1  + ". " + passengerName + ", Asiento " + seat);
        }
        System.out.println("-------------------------------");
    }

}

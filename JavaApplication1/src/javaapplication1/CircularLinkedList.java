/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author poker
 */
public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int size;

    // Constructor de la clase CircularLinkedList
    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    // Método para agregar un procedimiento a la lista
    public void addProcedure(Procedure procedure) {
        Node newNode = new Node(procedure);
             // Verificación si la lista está vacía
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.setNext(head);
        } else {
            tail.setNext(newNode);
            newNode.setNext(head);
            tail = newNode;
        }
        size++;
    }
   // Método para obtener un procedimiento en el índice dado de la lista
    public Procedure getProcedureAt(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getProcedure();
    }

    // Método para verificar si la lista está vací
    public boolean isEmpty() {
        return size == 0;
    }
// Método para mostrar los procedimientos en la lista
    public void displayProcedures() {
        if (head == null) {
            return;
        }
        Node current = head;
        int index = 0;
        do {
            System.out.println(index + ": " + current.getProcedure().getName());
            current = current.getNext();
            index++;
        } while (current != head);
    }
}

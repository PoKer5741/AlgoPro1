/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author poker
 */
public class Node {
    private Procedure procedure;
    private Node next;

    public Node(Procedure procedure) {
        this.procedure = procedure;
        this.next = null;
    }
// Método para obtener el procedimiento almacenado en el nodo
    public Procedure getProcedure() {
        return procedure;
    }
    // Método para obtener el siguiente nodo en la lista
    public Node getNext() {
        return next;
    }
// Método para establecer el siguiente nodo en la lista
    public void setNext(Node next) {
        this.next = next;
    }
}

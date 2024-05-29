/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author poker
 */
public class Procedure {
    private String name;
    private String content;

    public Procedure(String name, String content) {
        this.name = name;
        this.content = content;
    }
// Método para obtener el nombre del procedimiento
    public String getName() {
        return name;
    }
// Método para obtener el contenido del procedimiento
    public String getContent() {
        return content;
    }
}

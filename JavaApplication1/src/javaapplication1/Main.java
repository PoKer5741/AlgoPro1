/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;
import java.util.Scanner;

/**
 *
 * @author poker
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la ruta del archivo .java: ");
        String filePath = scanner.nextLine();

        // Lee el contenido del archivo
        JavaFileReader reader = new JavaFileReader(filePath);
        String fileContent = reader.readFile();

        if (fileContent != null) {
            // Analiza el contenido del archivo para extraer los procedimientos
            CodeAnalyzer analyzer = new CodeAnalyzer(fileContent);
            CircularLinkedList proceduresList = analyzer.extractProcedures();

            if (proceduresList.isEmpty()) {
                System.out.println("No se encontraron procedimientos en el archivo.");
            } else {
                boolean exit = false;
                while (!exit) {
                    System.out.println("\nMenú de Procedimientos:");
                    proceduresList.displayProcedures();

                    System.out.print("\nSeleccione el número del procedimiento para ver su complejidad o 'q' para salir: ");
                    String input = scanner.nextLine();

                    if (input.equals("q")) {
                        exit = true;
                    } else {
                        try {
                            int index = Integer.parseInt(input);
                            Procedure procedure = proceduresList.getProcedureAt(index);
                            if (procedure != null) {
                                // Calcula la complejidad del procedimiento seleccionado
                                ComplexityCalculator calculator = new ComplexityCalculator(procedure.getContent());
                                String complexity = calculator.calculateComplexity();
                                System.out.println("Complejidad del procedimiento '" + procedure.getName() + "': " + complexity);
                            } else {
                                System.out.println("Índice no válido.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada no válida. Por favor ingrese un número o 'q' para salir.");
                        }
                    }
                }
            }
        } else {
            System.out.println("No se pudo leer el archivo.");
        }
    }
}

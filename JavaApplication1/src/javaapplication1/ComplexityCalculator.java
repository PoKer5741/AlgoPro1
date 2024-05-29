/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author por Diego
 */




public class ComplexityCalculator {
    private String procedureContent;

    public ComplexityCalculator(String procedureContent) {
        this.procedureContent = procedureContent;
    }

    // Método para calcular la complejidad del procedimiento
    public String calculateComplexity() {
        // Contadores para varios elementos de control de flujo en el procedimiento
        int forLoops = countOccurrences("for\\s*\\(");
        int whileLoops = countOccurrences("while\\s*\\(");
        int ifStatements = countOccurrences("if\\s*\\(");
        int recursiveCalls = countRecursiveCalls();
  // Determinación de la complejidad basada en los contadores
        if (forLoops == 0 && whileLoops == 0 && recursiveCalls == 0) {
            return "O(1)";
        } else if (forLoops == 1 && whileLoops == 0 && recursiveCalls == 0) {
            return "O(n)";
        } else if (forLoops > 1 || whileLoops > 1) {
            return "O(n^" + Math.max(forLoops, whileLoops) + ")";
        } else if (containsQuadraticPattern()) {
            return "O(n^2)";
        } else if (recursiveCalls > 0 && countBinarySplits()) {
            return "O(2^n)";
        } else if (containsLogarithmicPattern()) {
            return "O(log n)";
        } else {
            return "Complejidad no determinada";
        }
    }

       // Método para contar las ocurrencias de un patrón en el contenido del procedimiento
    private int countOccurrences(String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(procedureContent);
        int count = 0;
        while (m.find()) {
            count++;
        }
        return count;
    }
     // Método para contar las llamadas recursivas en el procedimiento
    private int countRecursiveCalls() {
        Pattern pattern = Pattern.compile("(void|\\w+)\\s+(\\w+)\\s*\\(");
        Matcher matcher = pattern.matcher(procedureContent);
        if (matcher.find()) {
            String procedureName = matcher.group(2);
            return countOccurrences(procedureName + "\\s*\\(");
        } else {
            return 0;
        }
    }
  // Método para verificar si el procedimiento contiene divisiones binarias
    private boolean countBinarySplits() {
        Pattern pattern = Pattern.compile("if\\s*\\(.+?\\)\\s*\\{");
        Matcher matcher = pattern.matcher(procedureContent);
        return matcher.find();
    }
    // Método para verificar si el procedimiento contiene un patrón logarítmico
    private boolean containsLogarithmicPattern() {
        return procedureContent.contains("/ 2") || procedureContent.contains(">> 1");
    }
// Método para verificar si el procedimiento contiene un patrón cuadrático
    private boolean containsQuadraticPattern() {
        return procedureContent.contains("for") && procedureContent.contains(";") &&
               procedureContent.contains("<") && procedureContent.contains("=");
    }
}

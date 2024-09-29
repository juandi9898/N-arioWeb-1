/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juand
 */
public class arbolNary {
Nodo raiz;  // Raíz del árbol

    // Constructor que inicializa el árbol con la raíz nula
    public arbolNary() {
        raiz = null;
    }

    // Método para asignar la raíz del árbol
    public void asignarRaiz(int valor) {
        raiz = new Nodo(valor);  // Crea un nodo raíz con el valor dado
    }
    
     // Método para agregar un hijo a un nodo existente
    public Nodo buscarNodo(Nodo nodo, int valor) {
        if (nodo == null) {
            return null;
        }
        if (nodo.valor == valor) {
            return nodo;
        }
        for (Nodo hijo : nodo.hijos) {
            Nodo encontrado = buscarNodo(hijo, valor);
            if (encontrado != null) {
                return encontrado;
            }
        }
        return null;
    }
    
        public void agregarHijo(int padreValor, int hijoValor) {
        Nodo padre = buscarNodo(raiz, padreValor);
        if (padre != null) {
            padre.agregarHijo(new Nodo(hijoValor));
        } else {
            System.out.println("Nodo padre no encontrado.");
        }
    }


    // Método para recorrer el árbol en preorden y devolver como String
    public String getRecorridoPreorden() {
        StringBuilder sb = new StringBuilder();  // Crea un StringBuilder
        recorridoPreordenRecursivo(raiz, sb);   // Llama al método recursivo, pasando el StringBuilder
        return sb.toString();  // Devuelve la cadena construida
    }

    // Método recursivo para el recorrido en preorden
    private void recorridoPreordenRecursivo(Nodo nodo, StringBuilder sb) {
        if (nodo == null) {
            return;
        }

        // Agrega el valor del nodo actual al StringBuilder
        sb.append(nodo.valor).append(" ");  // Agrega el valor y un espacio

        // Recorre todos los hijos del nodo actual
        for (Nodo hijo : nodo.hijos) {
            recorridoPreordenRecursivo(hijo, sb);  // Llama recursivamente para cada hijo
        }
    }
    
    
    
    //Añadimos un getter para consultar la raiz desde el Servlet cuando hacemos la comprobación de que exista el padre antes de hacer la insercción

    public Nodo getRaiz() {
        return raiz;
    }
    
    
    
    
    
   
    
    
}

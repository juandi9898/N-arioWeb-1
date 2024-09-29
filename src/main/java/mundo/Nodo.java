/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sistemas
 */
public class Nodo {

    int valor;  // El valor del nodo
    List<Nodo> hijos;  // Lista de nodos hijos

    // Constructor que inicializa el valor del nodo y crea una lista vacía de hijos
    public Nodo(int valor) {
        this.valor = valor;
        hijos = new ArrayList<>();  // La lista de hijos empieza vacía
    }

    // Método para agregar un hijo al nodo actual
    public void agregarHijo(Nodo hijo) {
        hijos.add(hijo);  // Agrega el nodo hijo a la lista de hijos
    }
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mundo.arbolNary;

/**
 *
 * @author Juan Diego Botina y Janier David Acosta  
 */
@WebServlet(name = "SvArbolN", urlPatterns = {"/SvArbolN"})
public class SvArbolN extends HttpServlet {

    private arbolNary arbol = new arbolNary();  // Instancia del árbol

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvArbolN</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvArbolN at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("action");

        String raizAsignar = request.getParameter("asignarRaiz");
        String padre = request.getParameter("agregarAlPadre");
        String hijo = request.getParameter("agregarHijo");

        /* System.out.println("-------------------------------------------------");
    System.out.println("Comprobando si llegan correctamente los valores");
    System.out.println("Raiz: " + raizAsignar);
    System.out.println("Padre: " + padre);
    System.out.println("Hijo: " + hijo);
         */
        System.out.println("Accion: " + accion);//Pruebas para saber si estaba llegando bien el valor de la acción

        
        
        
        // Asignar la raíz si no está vacía
        if (raizAsignar != null) {
            int valorRaiz = Integer.parseInt(raizAsignar);
            arbol.asignarRaiz(valorRaiz);
        }
        // Agregar hijo a un nodo padre si ambos están especificados

        int valorPadre = Integer.parseInt(padre);
        int valorHijo = Integer.parseInt(hijo);
        if (arbol.buscarNodo(arbol.getRaiz(), valorPadre) != null) {
            arbol.agregarHijo(valorPadre, valorHijo); // Si el padre existe, agregar el hijo
            request.setAttribute("arbol", arbol);
            request.getRequestDispatcher("arbol.jsp").forward(request, response);

        } else {
            // Si el padre no existe, mostrar un mensaje de error y un botón para regresar
            if (accion.equals("InicializarArbol")) {
                request.setAttribute("MensajeError", "El padre digitado no existe");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (accion.equals("AgregarNodo")) {
                request.setAttribute("MensajeError", "El padre digitado no existe");
                request.setAttribute("arbol", arbol);
                request.getRequestDispatcher("arbol.jsp").forward(request, response);

                

            }
        }

        // Redirigir al JSP para mostrar el árbol actualizado
        //Cuando quiera imprimir la raiz, y sus nodos, debo llamar al metodo getRecorrido Preorden, que me devuelve el StringBuilder separado por comas, de ahi solo imprimo cierto en html
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

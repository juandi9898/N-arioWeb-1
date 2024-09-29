<%-- 
    Document   : index
    Created on : 28/09/2024, 7:56:11 p. m.
    Author     : Juan Diego Botina y Janier David Acosta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="lib/header.jsp" %>

<br>

<div class="contenido" style="margin-top: 120px" >
    <div class="text-center">
        <h1 class="text-primary">Árboles N-arios</h1>
    </div>

    <div class="container p-4 justify-content-center" style="max-width: 500px;">

        <div class="card  card-body">

            <form action="SvArbolN" method="POST">
                <div class="mb-3">
                    <input type="hidden" name="action" value="InicializarArbol">
                    <input type="number" class="form-control" id="asignarRaiz" name="asignarRaiz"  placeholder="Asignar Raiz">
                </div>
                <div class="mb-3">
                    <input type="number" class="form-control" id="agregarAlPadre" name="agregarAlPadre" placeholder="Agregar Hijo al Nodo">
                </div>
                <div class="mb-3">
                    <input type="number" class="form-control" id="agregarHijo" name="agregarHijo" placeholder="AgregarHijo">
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </div>
            </form>
            <br>
            <% if (request.getAttribute("MensajeError") != null) {%>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <%= request.getAttribute("MensajeError")%>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <% }%>
            
            
            
        </div>
    </div>
</div>
            
            <div class="text-center" style="margin-top: 20px;">
                <h2 class="text-primary">Integrantes</h2>
                <br>
                <p>Juan Diego Botina Realpe</p>
                <p>Janier David Acosta Morales</p>
            </div>

<%@include file="lib/footer.jsp" %>

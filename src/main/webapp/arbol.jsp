<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="lib/header.jsp" %>
<%@ page import="mundo.arbolNary" %>

<div class="text-center">
<h1 class="text-success">Salidas</h1>
</div>
<p><%
        mundo.arbolNary arbol = (mundo.arbolNary) request.getAttribute("arbol");
        
        if (arbol != null) {
            out.println("Recorrido en preorden: " + arbol.getRecorridoPreorden());
        } else {
            out.println("El árbol no ha sido inicializado.");
        }
    %>
</p>

<!-- Contenedor para el canvas que permite scroll horizontal -->
<div style="overflow-x: auto; white-space: nowrap;">
    <canvas id="treeCanvas"  height="200" style="border:none;"></canvas>
</div>

<script>
// Obtener el recorrido en preorden del árbol
const preorden = '<%= arbol != null ? arbol.getRecorridoPreorden().trim().replace(" ", ",") : "" %>';
const values = preorden.split(",").map(Number); // Convertimos la salida en un array de números

const canvas = document.getElementById('treeCanvas');
const ctx = canvas.getContext('2d');
ctx.clearRect(0, 0, canvas.width, canvas.height); // Limpiar el canvas antes de dibujar

// Tamaño de las cajas
const boxWidth = 200; // Ancho de cada caja
const boxHeight = 100; // Alto de cada caja
const padding = 10; // Espaciado interno para el texto
const spacing = 0; // Espacio entre las cajas (ajusta este valor según sea necesario)

// Función para obtener un color aleatorio que no sea negro ni demasiado oscuro
function getRandomColor() {
    const letters = '0123456789ABCDEF';
    let color;
    do {
        color = '#';
        for (let i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        }
    } while (isColorTooDark(color)); // Asegúrate de que el color no sea demasiado oscuro
    return color;
}

// Función para verificar si un color es demasiado oscuro
function isColorTooDark(color) {
    const r = parseInt(color.slice(1, 3), 16);
    const g = parseInt(color.slice(3, 5), 16);
    const b = parseInt(color.slice(5, 7), 16);
    // Usamos la fórmula de luminosidad
    const luminosity = (0.299 * r + 0.587 * g + 0.114 * b);
    return luminosity < 100; // Puedes ajustar este umbral a tu gusto
}

// Función para dibujar un rectángulo con esquinas redondeadas
function drawRoundedRect(ctx, x, y, width, height, radius) {
    ctx.beginPath();
    ctx.moveTo(x + radius, y);
    ctx.lineTo(x + width - radius, y);
    ctx.quadraticCurveTo(x + width, y, x + width, y + radius);
    ctx.lineTo(x + width, y + height - radius);
    ctx.quadraticCurveTo(x + width, y + height, x + width - radius, y + height);
    ctx.lineTo(x + radius, y + height);
    ctx.quadraticCurveTo(x, y + height, x, y + height - radius);
    ctx.lineTo(x, y + radius);
    ctx.quadraticCurveTo(x, y, x + radius, y);
    ctx.closePath();
    ctx.fill(); // Rellenar el rectángulo
    ctx.stroke(); // Dibujar el contorno
}
const totalCanvasWidth = values.length * (boxWidth + spacing) + 50;
canvas.width = totalCanvasWidth;

// Dibujar los nodos en el canvas
values.forEach((value, index) => {
    const x = 50 + index * (boxWidth + spacing); // Posición X de cada nodo
    const y = 50; // Posición Y fija
    const color = getRandomColor(); // Obtiene un color aleatorio

    ctx.fillStyle = color; // Establece el color de relleno
    ctx.strokeStyle = '#000'; // Establece el color del contorno (negro)
    ctx.lineWidth = 2; // Grosor de la línea del contorno

    drawRoundedRect(ctx, x, y, boxWidth, boxHeight, 20); // Dibuja el rectángulo con esquinas redondeadas

    ctx.fillStyle = '#000'; // Establece el color del texto (negro)
    ctx.fillText(value, x + boxWidth / 2 - padding, y + boxHeight / 2 + padding); // Escribe el número dentro del rectángulo
});
</script>
<div class="text-center">
    <h2 class="text-success">Añadir hijo a nodo</h2>
</div>

<div class="container p-4 d-flex justify-content-center" style="max-width: 500px;">
    <div class="card card-body">
        <form action="SvArbolN" method="POST">
            
            <input type="hidden" name="action" value="AgregarNodo">
            
            <div class="mb-3">
                <input type="number" class="form-control" id="agregarAlPadre" name="agregarAlPadre" placeholder="Agregar Hijo al Nodo">
            </div>
            <div class="mb-3">
                <input type="number" class="form-control" id="agregarHijo" name="agregarHijo" placeholder="Agregar Hijo">
            </div>
            <div class="text-center">
            <button type="submit" class="btn btn-success">Enviar</button>
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
            
              <div class="text-center" style="margin-top: 20px;">
                <h2 class="text-secondary">Integrantes</h2>
                <br>
                <p>Juan Diego Botina Realpe</p>
                <p>Janier David Acosta Morales</p>
            </div>
<%@include file="lib/footer.jsp" %>

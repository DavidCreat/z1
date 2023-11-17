// app.js

document.addEventListener("DOMContentLoaded", function() {
    obtenerDatosPersonas();
});

function obtenerDatosPersonas() {
    // Realizar una solicitud a la API en el servidor
    fetch("/api/personas")
        .then(response => response.json())
        .then(datosPersonas => mostrarDatosEnPagina(datosPersonas))
        .catch(error => console.error("Error al obtener datos:", error));
}

function mostrarDatosEnPagina(datosPersonas) {
    var listaPersonas = document.getElementById("listaPersonas");

    datosPersonas.forEach(function(persona) {
        var li = document.createElement("li");
        li.textContent = `Nombre: ${persona.nombre}, Apellido: ${persona.apellido}, Número: ${persona.numero}, Dirección: ${persona.direccion}`;
        listaPersonas.appendChild(li);
    });
}
document.addEventListener("DOMContentLoaded", function() {
    const urlParams = new URLSearchParams(window.location.search);
    const zapatoId = urlParams.get('id'); // Obtener el ID del zapato de la URL

    obtenerDatosZapato(zapatoId);
});

function obtenerDatosZapato(zapatoId) {
    fetch(`/api/zapatos/${zapatoId}`)
        .then(response => response.json())
        .then(zapato => mostrarDatosZapato(zapato))
        .catch(error => console.error("Error al obtener datos del zapato:", error));
}

function mostrarDatosZapato(zapato) {
    const imagenZapato = document.getElementById('imagenZapato');
    const nombreZapato = document.getElementById('nombreZapato');
    const descripcionZapato = document.getElementById('descripcionZapato');


    imagenZapato.src = `recursos/img/${zapato.imagen}`;
    imagenZapato.alt = zapato.nombre;
    nombreZapato.textContent = zapato.nombre;
    descripcionZapato.textContent = zapato.descripcion;
}
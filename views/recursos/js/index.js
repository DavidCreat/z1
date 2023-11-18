document.addEventListener("DOMContentLoaded", function () {
    const slides = document.querySelectorAll(".slideshow li span");
    let currentSlide = 0;

    function showSlide(index) {
        slides[currentSlide].style.opacity = 0;
        currentSlide = (index + slides.length) % slides.length;
        slides[currentSlide].style.opacity = 1;
    }

    function startSlideshow() {
        setInterval(function () {
            showSlide(currentSlide + 1);
        }, 5000); // Cambia de imagen cada 5 segundos (ajusta según tus necesidades)
    }

    showSlide(currentSlide);
    startSlideshow();
});

/* GIF SCROLL */
document.addEventListener("DOMContentLoaded", function () {
    const scrollIndicator = document.querySelector(".scroll-down-indicator");

    // Cuando se hace scroll hacia abajo, oculta el indicador de scroll
    window.addEventListener("scroll", function () {
        if (window.scrollY > 0) {
            scrollIndicator.style.display = "none";
        } else {
            scrollIndicator.style.display = "block";
        }
    });
});


/*pagina zapatos */
document.addEventListener("DOMContentLoaded", function () {
    // Obtén los elementos de los filtros y el contenedor del inventario
    const colorFilter = document.getElementById("color-filter");
    const brandFilter = document.getElementById("brand-filter");
    const sizeFilter = document.getElementById("size-filter");
    const priceFilter = document.getElementById("price-filter");
    const inventory = document.getElementById("inventory");

    // Datos de inventario (reemplaza esto con tus datos reales)
    const inventoryData = [
        { color: "negro", brand: "nike", size: "36", price: 70.000 },
        { color: "blanco", brand: "adidas", size: "37", price: 60.000 },
        { color: "azul", brand: "adidas", size: "37", price: 60.000 },
        { color: "rojo", brand: "adidas", size: "37", price: 80.000 },
        { color: "negro", brand: "adidas", size: "37", price: 90.000 },
        // Agrega más datos según tu base de datos
    ];
    // Función para formatear números a dos decimales
function formatPrice(price) {
    return price.toFixed(3);
}

 // Función para actualizar el inventario según los filtros
 function updateInventory() {
    const filteredData = inventoryData.filter(item => {
        const colorMatch = colorFilter.value === "" || item.color === colorFilter.value;
        const brandMatch = brandFilter.value === "" || item.brand === brandFilter.value;
        const sizeMatch = sizeFilter.value === "" || item.size === sizeFilter.value;
        const priceMatch = priceFilter.value === "" || item.price <= parseInt(priceFilter.value);
        return colorMatch && brandMatch && sizeMatch && priceMatch;
    });

    // Limpiar el contenido del inventario
    inventory.innerHTML = "";

    if (filteredData.length === 0) {
        // Mostrar un mensaje si no hay productos que coincidan
        const noMatchMessage = document.createElement("p");
        noMatchMessage.textContent = "No hay productos que coincidan con los filtros.";
        inventory.appendChild(noMatchMessage);
    } else {
        // Crear elementos de producto basados en los datos filtrados
        filteredData.forEach(item => {
            const productDiv = document.createElement("div");
            productDiv.classList.add("product-card");
            productDiv.setAttribute("data-color", item.color);
            productDiv.setAttribute("data-brand", item.brand);
            productDiv.setAttribute("data-size", item.size);
            productDiv.setAttribute("data-price", item.price);

            // Estructura del producto basado en tu ejemplo
            productDiv.innerHTML = `
                <div class="card">
                    <figure>
                        <img src="https://www.numbersneakers.com/Files/117970/Img/02/824413-01-jpg-big.jpg" alt="Tenis">
                    </figure>
                    <section class="details">
                        <div class="min-details">
                            <h1>Tenis<span>${item.brand}</span></h1>
                            <h1 class="price">$${formatPrice(item.price)} COP</h1>
                        </div>
                        <a href="#" class="btn">SABER MAS</a>
                    </section>
                </div>
            `;
            inventory.appendChild(productDiv);
        });
    }
}

    // Agregar event listeners a los filtros
    colorFilter.addEventListener("change", updateInventory);
    brandFilter.addEventListener("change", updateInventory);
    sizeFilter.addEventListener("change", updateInventory);
    priceFilter.addEventListener("input", updateInventory);

    // Llamar a updateInventory para mostrar el inventario inicialmente
    updateInventory();
});

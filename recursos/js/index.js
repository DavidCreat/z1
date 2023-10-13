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

// detalle-producto.js
let quantity = 1;

function getMaxStock() {
    const stockElement = document.getElementById('stock-disponible');
    return parseInt(stockElement.getAttribute('data-stock')) || 10;
}

function increaseQuantity() {
    const maxStock = getMaxStock();
    if (quantity < maxStock) {
        quantity++;
        document.getElementById('quantity').value = quantity;
    }
}

function decreaseQuantity() {
    if (quantity > 1) {
        quantity--;
        document.getElementById('quantity').value = quantity;
    }
}

// Inicializar cuando el documento esté listo
document.addEventListener('DOMContentLoaded', function() {
    // Tu código de inicialización aquí si es necesario
});
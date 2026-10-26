const API_URL = 'http://localhost:8080/api/pedidos';

async function cargarPedidos() {
    try {
        const respuesta = await fetch(API_URL);
        const pedidos = await respuesta.json();
        const tabla = document.getElementById('tablaPedidos');
        tabla.innerHTML = '';

        pedidos.forEach(pedido => {
            const fila = document.createElement('tr');
            fila.innerHTML = `
                <td>${pedido.id}</td>
                <td>${pedido.cliente}</td>
                <td>${pedido.nombreZona}</td>
                <td>Q${pedido.totalPedido.toFixed(2)}</td>
                <td>Q${pedido.costoEnvio.toFixed(2)}</td>
                <td><strong>Q${pedido.totalFinal.toFixed(2)}</strong></td>
                <td>${pedido.estado}</td>
                <td><button onclick="eliminarPedido(${pedido.id})" style="background:red; color:white; border:none; padding:5px; border-radius:3px; cursor:pointer;">Eliminar</button></td>
            `;
            tabla.appendChild(fila);
        });
    } catch (error) {
        console.error("Error al cargar pedidos:", error);
    }
}

document.getElementById('formPedido').addEventListener('submit', async (e) => {
    e.preventDefault();
    const nuevoPedido = {
        cliente: document.getElementById('cliente').value,
        direccion: document.getElementById('direccion').value,
        totalPedido: parseFloat(document.getElementById('totalPedido').value),
        zonaEntregaId: parseInt(document.getElementById('zonaEntregaId').value)
    };

    try {
        const respuesta = await fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(nuevoPedido)
        });

        const mensajeDiv = document.getElementById('mensaje');

        if (respuesta.ok) {
            mensajeDiv.className = 'mensaje exito';
            mensajeDiv.innerText = '✅ Pedido registrado exitosamente';
            document.getElementById('formPedido').reset();
            cargarPedidos();
        } else {
            mensajeDiv.className = 'mensaje error';
            mensajeDiv.innerText = '❌ Error al registrar. Verifique los datos.';
        }
    } catch (error) {
        console.error("Error al registrar:", error);
    }
});

async function eliminarPedido(id) {
    if (confirm('¿Está seguro de eliminar este pedido?')) {
        try {
            const respuesta = await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
            if (respuesta.ok) {
                alert('Pedido eliminado correctamente');
                cargarPedidos();
            }
        } catch (error) {
            console.error("Error al eliminar:", error);
        }
    }
}

async function cargarIndicador() {
    const hoy = new Date().toISOString().split('T')[0];
    try {
        const respuesta = await fetch(`${API_URL}/facturado/${hoy}`);
        const total = await respuesta.json();
        document.getElementById('totalFacturado').innerText = `Q${total.toFixed(2)}`;
    } catch (error) {
        console.error("Error al calcular indicador:", error);
    }
}

document.addEventListener('DOMContentLoaded', () => {
    cargarPedidos();
    cargarIndicador();
});
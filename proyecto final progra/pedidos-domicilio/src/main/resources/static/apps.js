const API_URL = 'http://localhost:8080/api/pedidos';

function escapeHTML(str) {
    return str.replace(/[&<>'"]/g, tag => ({
        '&': '&amp;', '<': '&lt;', '>': '&gt;', "'": '&#39;', '"': '&quot;'
    }[tag]));
}

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
                <td>${escapeHTML(pedido.cliente)}</td>
                <td>${pedido.nombreZona}</td>
                <td>Q${pedido.totalPedido.toFixed(2)}</td>
                <td>Q${pedido.costoEnvio.toFixed(2)}</td>
                <td><strong>Q${pedido.totalFinal.toFixed(2)}</strong></td>
                <td>${pedido.estado}</td>
                <td>
                    <select onchange="cambiarEstado(${pedido.id}, this.value)" style="padding:5px; border-radius:3px;">
                        <option value="">Cambiar...</option>
                        <option value="EN_RUTA">EN_RUTA</option>
                        <option value="ENTREGADO">ENTREGADO</option>
                        <option value="CANCELADO">CANCELADO</option>
                    </select>
                </td>
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
            cargarIndicador();
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
                cargarIndicador();
            }
        } catch (error) {
            console.error("Error al eliminar:", error);
        }
    }
}

async function cambiarEstado(id, nuevoEstado) {
    if (!nuevoEstado) return;
    try {
        const respuesta = await fetch(`${API_URL}/${id}/estado?estado=${nuevoEstado}`, {
            method: 'PATCH'
        });

        if (respuesta.ok) {
            cargarPedidos();
            cargarIndicador();
        } else {
            const errorData = await respuesta.json();
            alert("⚠️ " + (errorData.error || "Error al cambiar estado"));
        }
    } catch (error) {
        console.error("Error al cambiar estado", error);
        alert("❌ Error de conexión al intentar cambiar el estado.");
    }
}

async function cargarIndicador() {
    const hoy = new Date().toISOString().split('T')[0];
    try {
        const respuesta = await fetch(`${API_URL}/facturado/${hoy}`);
        const total = await respuesta.json();
        const totalSeguro = total ? total : 0.0;
        document.getElementById('totalFacturado').innerText = `Q${totalSeguro.toFixed(2)}`;
    } catch (error) {
        console.error("Error al calcular indicador:", error);
        document.getElementById('totalFacturado').innerText = `Q0.00`;
    }
}

async function cargarZonas() {
    try {
        const respuesta = await fetch('http://localhost:8080/api/zonas');
        const zonas = await respuesta.json();
        const select = document.getElementById('zonaEntregaId');
        select.innerHTML = '<option value="">Seleccione una Zona</option>';

        zonas.forEach(zona => {
            const option = document.createElement('option');
            option.value = zona.id;
            option.text = `${zona.nombre} (Costo: Q${zona.costo.toFixed(2)})`;
            select.appendChild(option);
        });
    } catch (error) {
        console.error("Error al cargar zonas:", error);
    }
}

document.addEventListener('DOMContentLoaded', () => {
    cargarPedidos();
    cargarIndicador();
    cargarZonas();
});
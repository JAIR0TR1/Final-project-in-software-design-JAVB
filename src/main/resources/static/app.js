const BASE_URL = 'http://localhost:8080/api';

document.addEventListener('DOMContentLoaded', () => {
    cargarLibros();
    cargarUsuarios();
    cargarPrestamos();
    
    // Event Listeners para Formularios
    document.getElementById('form-libro').addEventListener('submit', guardarLibro);
    document.getElementById('form-usuario').addEventListener('submit', guardarUsuario);
    document.getElementById('form-prestamo').addEventListener('submit', realizarPrestamo);
});

// NAVEGACIÓN
function showSection(sectionId) {
    document.querySelectorAll('.section').forEach(s => s.style.display = 'none');
    document.getElementById(`sec-${sectionId}`).style.display = 'block';
    
    if (sectionId === 'prestamos') {
        cargarLibrosDisponibles();
        cargarUsuariosSelect();
    }
}

// MODALES
function openModal(modalId) { document.getElementById(modalId).style.display = 'block'; }
function closeModal(modalId) { document.getElementById(modalId).style.display = 'none'; }

// --- LIBROS ---
async function cargarLibros() {
    const res = await fetch(`${BASE_URL}/libros`);
    const libros = await res.json();
    const tbody = document.getElementById('tbody-libros');
    tbody.innerHTML = '';
    
    libros.forEach(lib => {
        tbody.innerHTML += `
            <tr>
                <td>${lib.titulo}</td>
                <td>${lib.autor}</td>
                <td>${lib.genero}</td>
                <td>${lib.anioPublicacion}</td>
                <td><span class="badge ${lib.disponible ? 'badge-success' : 'badge-danger'}">${lib.disponible ? 'Disponible' : 'Prestado'}</span></td>
                <td>
                    <button class="btn btn-danger" onclick="eliminarLibro('${lib.id}')">Eliminar</button>
                </td>
            </tr>
        `;
    });
}

async function guardarLibro(e) {
    e.preventDefault();
    const libro = {
        titulo: document.getElementById('lib-titulo').value,
        autor: document.getElementById('lib-autor').value,
        isbn: document.getElementById('lib-isbn').value,
        genero: document.getElementById('lib-genero').value,
        anioPublicacion: parseInt(document.getElementById('lib-anio').value),
        disponible: true
    };

    await fetch(`${BASE_URL}/libros`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(libro)
    });

    closeModal('modal-libro');
    document.getElementById('form-libro').reset();
    cargarLibros();
}

async function eliminarLibro(id) {
    if (confirm('¿Eliminar este libro?')) {
        await fetch(`${BASE_URL}/libros/${id}`, { method: 'DELETE' });
        cargarLibros();
    }
}

// --- USUARIOS ---
async function cargarUsuarios() {
    const res = await fetch(`${BASE_URL}/usuarios`);
    const usuarios = await res.json();
    const tbody = document.getElementById('tbody-usuarios');
    tbody.innerHTML = '';
    
    usuarios.forEach(u => {
        tbody.innerHTML += `
            <tr>
                <td>${u.nombre}</td>
                <td>${u.email}</td>
                <td>${u.numeroCarnet}</td>
                <td>${u.telefono}</td>
                <td>
                    <button class="btn btn-danger" onclick="eliminarUsuario('${u.id}')">Eliminar</button>
                </td>
            </tr>
        `;
    });
}

async function guardarUsuario(e) {
    e.preventDefault();
    const usuario = {
        nombre: document.getElementById('usu-nombre').value,
        email: document.getElementById('usu-email').value,
        numeroCarnet: document.getElementById('usu-carnet').value,
        telefono: document.getElementById('usu-telefono').value,
        fechaRegistro: new Date().toISOString().split('T')[0]
    };

    await fetch(`${BASE_URL}/usuarios`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(usuario)
    });

    closeModal('modal-usuario');
    document.getElementById('form-usuario').reset();
    cargarUsuarios();
}

async function eliminarUsuario(id) {
    if (confirm('¿Eliminar este usuario?')) {
        await fetch(`${BASE_URL}/usuarios/${id}`, { method: 'DELETE' });
        cargarUsuarios();
    }
}

// --- PRÉSTAMOS ---
async function cargarPrestamos() {
    const res = await fetch(`${BASE_URL}/prestamos/activos`);
    const prestamos = await res.json();
    const tbody = document.getElementById('tbody-prestamos');
    tbody.innerHTML = '';
    
    prestamos.forEach(p => {
        tbody.innerHTML += `
            <tr>
                <td>${p.nombreUsuario}</td>
                <td>${p.tituloLibro}</td>
                <td>${new Date(p.fechaPrestamo).toLocaleDateString()}</td>
                <td>
                    <button class="btn btn-success" onclick="devolverLibro('${p.id}')">Devolver</button>
                </td>
            </tr>
        `;
    });
}

async function cargarLibrosDisponibles() {
    const res = await fetch(`${BASE_URL}/libros/disponibles`);
    const libros = await res.json();
    const select = document.getElementById('select-libros');
    select.innerHTML = '<option value="">Seleccione un libro...</option>';
    libros.forEach(l => {
        select.innerHTML += `<option value="${l.id}">${l.titulo} - ${l.autor}</option>`;
    });
}

async function cargarUsuariosSelect() {
    const res = await fetch(`${BASE_URL}/usuarios`);
    const usuarios = await res.json();
    const select = document.getElementById('select-usuarios');
    select.innerHTML = '<option value="">Seleccione un usuario...</option>';
    usuarios.forEach(u => {
        select.innerHTML += `<option value="${u.id}">${u.nombre} (${u.numeroCarnet})</option>`;
    });
}

async function realizarPrestamo(e) {
    e.preventDefault();
    const data = {
        usuarioId: document.getElementById('select-usuarios').value,
        libroId: document.getElementById('select-libros').value
    };

    try {
        const res = await fetch(`${BASE_URL}/prestamos/prestar`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });
        
        if (!res.ok) {
            const error = await res.json();
            throw new Error(error.message || 'Error al realizar el préstamo');
        }

        cargarPrestamos();
        cargarLibros();
        cargarLibrosDisponibles();
        document.getElementById('form-prestamo').reset();
    } catch (err) {
        alert(err.message);
    }
}

async function devolverLibro(id) {
    await fetch(`${BASE_URL}/prestamos/devolver/${id}`, { method: 'PUT' });
    cargarPrestamos();
    cargarLibros();
}

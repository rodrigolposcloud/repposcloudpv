<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Punto de Venta Inteligente - Información</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Font Awesome -->
<link rel="stylesheet"
 href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>
body {
    background: linear-gradient(135deg, #003471, #0059b3);
    color: #fff;
    font-family: 'Segoe UI', Arial, sans-serif;
}

.section-title {
    text-align: center;
    margin: 60px 0 30px;
}

.section-title h2 {
    font-weight: bold;
}

.card {
    background: rgba(255,255,255,0.12);
    backdrop-filter: blur(8px);
    border: none;
    border-radius: 18px;
    box-shadow: 0 20px 40px rgba(0,0,0,0.35);
    color: #fff;
    height: 100%;
}

.card i {
    font-size: 42px;
    color: #00e676;
    margin-bottom: 15px;
}

.card-title {
    font-weight: bold;
}

.badge-custom {
    background: #00c853;
}

footer {
    margin-top: 60px;
    padding: 15px;
    font-size: 12px;
    text-align: center;
    opacity: .7;
}
</style>
</head>

<body>

<div class="container">

    <!-- ¿QUÉ ES? -->
    <div class="section-title">
        <h2>¿Qué es Punto de Venta Inteligente?</h2>
        <p class="opacity-75">
            Plataforma web para automatizar y controlar las operaciones de venta
        </p>
    </div>

    <div class="row justify-content-center mb-4">
        <div class="col-md-10">
            <div class="card p-4 text-center">
                <p>
                    <strong>Punto de Venta Inteligente (POV)</strong> es una plataforma web diseñada
                    para automatizar y controlar las operaciones de venta de misceláneas,
                    tiendas, comercios y empresas.
                </p>
                <p>
                    Permite registrar productos mediante código de barras, generar tickets digitales
                    con QR, controlar inventarios y facilitar la facturación electrónica desde una
                    interfaz sencilla y eficiente.
                </p>
            </div>
        </div>
    </div>

    <!-- FUNCIONALIDADES -->
    <div class="section-title">
        <h2>Funcionalidades Principales</h2>
    </div>

    <div class="row g-4">

        <div class="col-md-4">
            <div class="card p-4 text-center">
                <i class="fas fa-barcode"></i>
                <h5 class="card-title">Control de Productos</h5>
                <ul class="list-unstyled mt-3">
                    <li>✔ Registro por código de barras</li>
                    <li>✔ Precios, descuentos y stock</li>
                    <li>✔ Inventarios en tiempo real</li>
                </ul>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card p-4 text-center">
                <i class="fas fa-cash-register"></i>
                <h5 class="card-title">Ventas Rápidas</h5>
                <ul class="list-unstyled mt-3">
                    <li>✔ Captura ágil de ventas</li>
                    <li>✔ Cálculo automático</li>
                    <li>✔ Historial completo</li>
                </ul>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card p-4 text-center">
                <i class="fas fa-file-pdf"></i>
                <h5 class="card-title">Ticket Digital PDF</h5>
                <ul class="list-unstyled mt-3">
                    <li>✔ Generación automática</li>
                    <li>✔ Diseño profesional</li>
                    <li>✔ Almacenamiento digital</li>
                </ul>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card p-4 text-center">
                <i class="fas fa-qrcode"></i>
                <h5 class="card-title">QR de Facturación</h5>
                <ul class="list-unstyled mt-3">
                    <li>✔ QR único por ticket</li>
                    <li>✔ Acceso directo</li>
                    <li>✔ Cumplimiento fiscal</li>
                </ul>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card p-4 text-center">
                <i class="fab fa-whatsapp"></i>
                <h5 class="card-title">Envío de Tickets</h5>
                <ul class="list-unstyled mt-3">
                    <li>✔ WhatsApp, SMS y correo</li>
                    <li>✔ Sin papel</li>
                    <li>✔ Ahorro de costos</li>
                </ul>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card p-4 text-center">
                <i class="fas fa-building"></i>
                <h5 class="card-title">Administración Empresarial</h5>
                <ul class="list-unstyled mt-3">
                    <li>✔ Empresas y sucursales</li>
                    <li>✔ Usuarios y perfiles</li>
                    <li>✔ Multi punto de venta</li>
                </ul>
            </div>
        </div>

    </div>

    <!-- PARA QUIÉN -->
    <div class="section-title">
        <h2>¿Para quién es este sistema?</h2>
    </div>

    <div class="row g-3 text-center">
        <div class="col-md-2 col-6"><span class="badge badge-custom p-2">Misceláneas</span></div>
        <div class="col-md-2 col-6"><span class="badge badge-custom p-2">Abarrotes</span></div>
        <div class="col-md-2 col-6"><span class="badge badge-custom p-2">Comercios</span></div>
        <div class="col-md-3 col-6"><span class="badge badge-custom p-2">Negocios familiares</span></div>
        <div class="col-md-3 col-12"><span class="badge badge-custom p-2">Empresas multisucursal</span></div>
    </div>

    <!-- BENEFICIOS -->
    <div class="section-title">
        <h2>Beneficios para tu Negocio</h2>
    </div>

    <div class="row g-4">
        <div class="col-md-3"><div class="card p-3 text-center">✅ Cobro más rápido</div></div>
        <div class="col-md-3"><div class="card p-3 text-center">✅ Menos errores</div></div>
        <div class="col-md-3"><div class="card p-3 text-center">✅ Control total</div></div>
        <div class="col-md-3"><div class="card p-3 text-center">✅ Imagen profesional</div></div>
    </div>

    <!-- TECNOLOGÍA -->
    <div class="section-title">
        <h2>Tecnología que Crece Contigo</h2>
    </div>

    <div class="row justify-content-center">
        <div class="col-md-10">
            <div class="card p-4 text-center">
                <p>
                    Arquitectura escalable y segura, preparada para:
                </p>
                <p>
                    ☁ Implementación en la nube · 💳 Modelo de suscripción · 📱 Expansión móvil · 🧾 Facturación electrónica
                </p>
            </div>
        </div>
    </div>

</div>

<footer>
    © 2026 – Punto de Venta Inteligente · Desarrollado por RodrigoIA
</footer>

</body>
</html>

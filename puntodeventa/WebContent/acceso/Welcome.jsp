<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Punto de Venta Inteligente</title>

<!-- Bootstrap 5 -->
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

/* ===== NAVBAR ===== */
.navbar {
    background: rgba(0,0,0,0.35);
    backdrop-filter: blur(6px);
}

/* ===== HERO ===== */
.hero {
    padding: 80px 20px 40px;
    text-align: center;
}

.hero h1 {
    font-size: 42px;
    font-weight: bold;
}

.hero p {
    font-size: 18px;
    opacity: 0.9;
}

/* ===== BOTÓN ===== */
.btn-start {
    background: #00c853;
    border-radius: 30px;
    padding: 14px 35px;
    font-size: 18px;
    color: #fff;
    text-decoration: none;
    transition: all .3s;
}

.btn-start:hover {
    background: #00e676;
    transform: scale(1.05);
}

/* ===== CARRUSEL ===== */
.carousel-item {
    padding: 40px;
}

.carousel-box {
    background: rgba(255,255,255,0.12);
    backdrop-filter: blur(8px);
    border-radius: 18px;
    padding: 40px;
    box-shadow: 0 20px 40px rgba(0,0,0,.35);
}

.carousel-box i {
    font-size: 50px;
    margin-bottom: 20px;
    color: #00e676;
}

/* ===== FOOTER ===== */
footer {
    margin-top: 40px;
    padding: 15px;
    font-size: 12px;
    text-align: center;
    opacity: 0.7;
}
</style>
</head>

<body>

<!-- ===== NAVBAR ===== -->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top">
  <div class="container">
    <a class="navbar-brand fw-bold" href="#">Punto de Venta</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="menu">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item"><a class="nav-link active" href="#">Principal</a></li>
        <li class="nav-item"><a class="nav-link" href="informaciondo">Informacion</a></li>
        <li class="nav-item"><a class="nav-link" href="suscripcionesdo">Suscripciones</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Contacto</a></li>
      </ul>
    </div>
  </div>
</nav>

<!-- ===== HERO ===== -->
<section class="hero container">
    <h1>Punto de Venta Inteligente</h1>
    <p>Control total de productos, ventas y facturación electrónica</p>

    <a href="homeaction" class="btn-start mt-3 d-inline-block">
        <i class="fas fa-sign-in-alt"></i> Iniciar Sistema
    </a>
</section>

<!-- ===== CARRUSEL ===== -->
<div id="pvCarousel" class="carousel slide container mt-4" data-bs-ride="carousel">
  <div class="carousel-inner">

    <div class="carousel-item active">
      <div class="carousel-box text-center">
        <i class="fas fa-barcode"></i>
        <h3>Productos con Código de Barras</h3>
        <p>Registro rápido, control de precios y manejo de inventarios en tiempo real.</p>
      </div>
    </div>

    <div class="carousel-item">
      <div class="carousel-box text-center">
        <i class="fas fa-cash-register"></i>
        <h3>Ventas Ágiles</h3>
        <p>Cobros rápidos, control de ventas y generación automática de tickets digitales.</p>
      </div>
    </div>

    <div class="carousel-item">
      <div class="carousel-box text-center">
        <i class="fas fa-qrcode"></i>
        <h3>QR para Facturación Electrónica</h3>
        <p>Cada ticket genera un QR único para facturar de forma sencilla.</p>
      </div>
    </div>

    <div class="carousel-item">
      <div class="carousel-box text-center">
        <i class="fas fa-paper-plane"></i>
        <h3>Envío Digital</h3>
        <p>Envía tickets por WhatsApp, SMS o correo electrónico.</p>
      </div>
    </div>

    <div class="carousel-item">
      <div class="carousel-box text-center">
        <i class="fas fa-store"></i>
        <h3>Administración Empresarial</h3>
        <p>Gestión de empresas, sucursales, usuarios y clientes.</p>
      </div>
    </div>

  </div>

  <button class="carousel-control-prev" type="button" data-bs-target="#pvCarousel" data-bs-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#pvCarousel" data-bs-slide="next">
    <span class="carousel-control-next-icon"></span>
  </button>
</div>

<!-- ===== FOOTER ===== -->
<footer>
    © 2026 – Punto de Venta Inteligente <br>
    Desarrollado por RodrigoIA – Uso comercial autorizado
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Planes y Suscripciones - Punto de Venta</title>

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
    margin: 60px 0 40px;
}

.section-title h2 {
    font-weight: bold;
}

.plan-card {
    background: rgba(255,255,255,0.12);
    backdrop-filter: blur(8px);
    border-radius: 20px;
    box-shadow: 0 20px 40px rgba(0,0,0,0.35);
    padding: 40px 30px;
    text-align: center;
    height: 100%;
    transition: transform .3s;
}

.plan-card:hover {
    transform: scale(1.05);
}

.plan-card.popular {
    border: 2px solid #00e676;
}

.plan-title {
    font-size: 24px;
    font-weight: bold;
}

.plan-price {
    font-size: 42px;
    font-weight: bold;
    margin: 20px 0;
}

.plan-price span {
    font-size: 16px;
    opacity: .8;
}

.plan-features {
    list-style: none;
    padding: 0;
    margin: 25px 0;
}

.plan-features li {
    margin: 10px 0;
}

.btn-plan {
    padding: 14px 35px;
    border-radius: 30px;
    font-size: 18px;
    text-decoration: none;
    display: inline-block;
}

.btn-basic {
    background: #00c853;
    color: #fff;
}

.btn-basic:hover {
    background: #00e676;
}

.btn-premium {
    background: #ffc107;
    color: #000;
}

.btn-premium:hover {
    background: #ffca2c;
}

.badge-popular {
    background: #00e676;
    color: #000;
    font-size: 12px;
    padding: 6px 10px;
    border-radius: 12px;
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

    <!-- TITULO -->
    <div class="section-title">
        <h2>Planes y Suscripciones</h2>
        <p class="opacity-75">
            Elige el plan ideal para tu negocio y comienza a vender hoy mismo
        </p>
    </div>

    <!-- PLANES -->
    <div class="row justify-content-center g-4">

        <!-- PLAN 6 MESES -->
        <div class="col-md-4">
            <div class="plan-card">
                <i class="fas fa-store fa-3x mb-3 text-success"></i>
                <div class="plan-title">Plan ANUAL</div>
                <div class="plan-price">
                    $6,200 <span>/ 12 meses</span>
                </div>

                <ul class="plan-features">
                    <li>✔ Punto de venta completo</li>
                    <li>✔ Control de productos Y Clientes</li>
                    <li>✔ Control de Ventas</li>                    
                    <li>✔ Tickets venta digital en PDF</li>
                    <li>✔ Código QR para facturación</li>
                   	<li>✔ Soporte básico</li>
                </ul>

                <a href="#" class="btn-plan btn-basic">
                    <i class="fas fa-check-circle"></i> Suscribirme
                </a>
            </div>
        </div>

        <!-- PLAN 12 MESES -->
        <div class="col-md-4">
            <div class="plan-card popular">
                <span class="badge-popular mb-3 d-inline-block">
                    ⭐ Más Popular
                </span>
                <i class="fas fa-building fa-3x mb-3 text-warning"></i>
                <div class="plan-title">Plan Anual en Desarrollo</div>
                <div class="plan-price">
                    $12,700 <span>/ 12 meses</span>
                </div>

                <ul class="plan-features">
                    <li>✔ Todo lo del plan semestral</li>
                    <li>✔ Empresas y sucursales ilimitadas</li>
                    <li>✔ Usuarios y perfiles</li>
                    <li>✔ Historial completo de ventas</li>
                    <li>✔ Tickets y QR ilimitados</li>
                    <li>✔ Preparado para nube</li>
                    <li>✔ Soporte prioritario</li>
                </ul>

                <a href="suscripciondo" class="btn-plan btn-premium">
                    <i class="fas fa-star"></i> Elegir Plan
                </a>
            </div>
        </div>

    </div>

    <!-- TEXTO FINAL -->
    <div class="section-title mt-5">
        <p class="opacity-75">
            Sin contratos forzosos · Sin impresoras · Sin papel · Listo para crecer contigo
        </p>
    </div>

</div>

<footer>
    © 2026 – Punto de Venta Inteligente · Suscripciones comerciales
</footer>

</body>
</html>

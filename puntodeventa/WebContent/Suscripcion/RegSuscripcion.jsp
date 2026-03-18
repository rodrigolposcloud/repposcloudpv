<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="es">
<head>

<meta charset="UTF-8">
<title>Suscripción POS Cloud</title>

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

<script src="https://openpay.s3.amazonaws.com/openpay.v1.min.js"></script>
<script src="https://openpay.s3.amazonaws.com/openpay-data.v1.min.js"></script>

<style>

body{
background:#f4f7fb;
font-family: 'Segoe UI',sans-serif;
}

.contenedor{

max-width:850px;
margin:auto;
margin-top:40px;
background:white;
padding:40px;
border-radius:14px;
box-shadow:0 10px 30px rgba(0,0,0,0.1);

}

.titulo{

font-size:28px;
font-weight:600;
margin-bottom:30px;
color:#1c2b4a;
text-align:center;

}

.plan{

border:2px solid #e5e9f2;
border-radius:12px;
padding:20px;
cursor:pointer;
transition:0.3s;

}

.plan:hover{

border-color:#3a8dff;
background:#f5f9ff;

}

.plan-activo{

border-color:#3a8dff;
background:#eef5ff;

}

.btn-pagar{

background:#3a8dff;
border:none;
padding:12px 35px;
font-size:16px;

}

footer{

text-align:center;
margin-top:30px;
color:#777;
font-size:13px;

}

</style>

</head>

<body>

<div class="contenedor">

<div class="titulo">
Suscripción Sistema POS Cloud
</div>

<form id="payment-form">

<div class="row mb-3">

<div class="col-md-6">
<label>Empresa</label>
<input type="text" class="form-control">
</div>

<div class="col-md-6">
<label>Correo</label>
<input type="email" class="form-control">
</div>

</div>

<div class="row mb-3">

<div class="col-md-6">
<label>Usuario</label>
<input type="text" class="form-control">
</div>

<div class="col-md-6">
<label>Password</label>
<input type="password" class="form-control">
</div>

</div>

<h5 class="mt-4">Plan</h5>

<div class="row mb-4">

<div class="col-md-6">

<div class="plan plan-activo">

<h4>12 Meses</h4>
<p>$2,400 MXN</p>

</div>

</div>

<div class="col-md-6">

<div class="plan">

<h4>24 Meses</h4>
<p>$4,100 MXN</p>

</div>

</div>

</div>

<h5>Tarjeta</h5>

<div class="row mb-3">

<div class="col-md-6">
<label>Nombre del Titular</label>
<input type="text" data-openpay-card="holder_name" class="form-control">
</div>

<div class="col-md-6">
<label>Número Tarjeta</label>
<input type="text" data-openpay-card="card_number" class="form-control">
</div>

</div>

<div class="row mb-3">

<div class="col-md-4">
<label>Mes</label>
<input type="text" data-openpay-card="expiration_month" class="form-control">
</div>

<div class="col-md-4">
<label>Año</label>
<input type="text" data-openpay-card="expiration_year" class="form-control">
</div>

<div class="col-md-4">
<label>CVV</label>
<input type="text" data-openpay-card="cvv2" class="form-control">
</div>

</div>

<div class="text-center">

<button class="btn btn-pagar" type="button" id="pay-button">
Pagar Suscripción
</button>

</div>

</form>

<footer>

© 2026 POS Cloud  
Todos los derechos reservados

</footer>

</div>

<script>

OpenPay.setId('TU_MERCHANT_ID');
OpenPay.setApiKey('TU_PUBLIC_KEY');
OpenPay.setSandboxMode(true);

document.getElementById("pay-button").onclick = function(){

OpenPay.token.extractFormAndCreate(
'payment-form',
success,
error);

}

function success(response){

var token=response.data.id;

alert("Token generado: "+token);

/* enviar token a tu servidor Java */

}

function error(response){

alert("Error en pago");

}

</script>

</body>
</html>
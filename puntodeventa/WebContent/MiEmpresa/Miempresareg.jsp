<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="es">
<head>

<meta charset="UTF-8">
<title>Empresa</title>

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

<style>

body{
background: linear-gradient(135deg,#d9ecff,#f5f9ff);
font-family: Arial;
}

.contenedor{

max-width:950px;
margin:auto;
margin-top:30px;
background:white;
padding:35px;
border-radius:12px;
box-shadow:0 10px 25px rgba(0,0,0,0.15);

}

.titulo{

font-size:26px;
font-weight:bold;
color:#0d6efd;
text-align:center;
margin-bottom:25px;

}

footer{

text-align:center;
margin-top:35px;
color:#777;
font-size:13px;

}

</style>

</head>

<body>

<div class="contenedor">

<div class="titulo">
 <h5> Registro de Empresa, Comercio, Tienda, Miscelanea, Almacen </h5>
</div>

<form action="guardarEmpresa" method="post">

<!-- DATOS EMPRESA, COMERCIO, TIENDA, MISCELANEA, ALMACEN -->

<div class="row mb-3">

<div class="col-md-6">
<label>Nombre Empresa</label>
<input type="text" name="nomempresa" id="nomempresa"  value="<s:property value="nomempresa"/>"  maxlength="120" class="form-control" required>
</div>

<div class="col-md-6">
<label>Razón Social</label>
<input type="text" name="razonsocial" id="razonsocial"  value="<s:property value="razonsocial"/>"  maxlength="120"  class="form-control" required>
</div>

</div>

<div class="row mb-3">

<div class="col-md-4">
<label>RFC</label>
<input type="text" name="rfc" id="rfc"  value="<s:property value="rfc"/>"  maxlength="20"  class="form-control" required>
</div>

<div class="col-md-4">
<label>Teléfono</label>
<input type="text" name="telefono" id="telefono"  value="<s:property value="telefono"/>"  maxlength="50"  class="form-control" required>
</div>

<div class="col-md-4">
<label>Correo Electrónico</label>
<input type="email" name="correo" id="correo"  value="<s:property value="correo"/>"  maxlength="120" class="form-control" required>
</div>

</div>

<hr>

<h5 class="text-primary">Dirección</h5>

<div class="row mb-3">

<div class="col-md-6">
<label>Calle</label>
<input type="text" name="domicilio" id="domicilio"  value="<s:property value="domicilio"/>"  maxlength="120" class="form-control" required>
</div>

<div class="col-md-2">
<label>Número</label>
<input type="text" name="numero" id="numero"  value="<s:property value="numero"/>"  maxlength="10" class="form-control" required>
</div>

<div class="col-md-4">
<label>Colonia</label>
<input type="text" name="colonia" id="colonia"  value="<s:property value="colonia"/>"  maxlength="50" class="form-control" required>
</div>

</div>

<div class="row mb-3">

<div class="col-md-4">
<label>Ciudad</label>
<input type="text" name="ciudad" id="ciudad"  value="<s:property value="ciudad"/>"  maxlength="50" class="form-control" required>
</div>

<div class="col-md-4">
<label>Estado</label>
<input type="text" name="estado" id="estado"  value="<s:property value="estado"/>"  maxlength="50" class="form-control" required>
</div>

<div class="col-md-4">
<label>Código Postal</label>
<input type="text" name="codpostal" id="codpostal"  value="<s:property value="codpostal"/>"  maxlength="20" class="form-control" required>
</div>

</div>

<br>

 <div class="alert alert-success" role="alert">
 Todos los Datos son obligatorios. 
 Seran utilizados en :
 a) Ticket de Venta.
 b) Facturacion Electronica.
</div>

<br>

<div class="text-center">

<button type="submit" class="btn btn-primary px-4">
Guardar
</button>

	<button type="button" class="btn btn-dark" onclick="window.location.href='homesdo?idempresa=<%out.print(session.getAttribute("idempresa"));%>'">
	    Regresar
	</button> 

</div>

</form>

<footer>

© 2026 – Sistema Punto de Venta desarrollado por Rodrigo  
Assisted Development AI 

</footer>

</div>

</body>

</html>
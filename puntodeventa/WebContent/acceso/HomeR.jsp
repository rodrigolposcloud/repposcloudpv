<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
	Map<String, Object> sessions = ActionContext.getContext().getSession();
	String idiusuario = ((String) sessions.get("idusuario"));
	String idempresa = ((String) sessions.get("idempresa"));
	String idrol = ((String) sessions.get("idrol"));
	String loguin = ((String) sessions.get("loguin"));
	String nombre = ((String) sessions.get("nombre"));
	String estatus = ((String) sessions.get("estatus"));
	String nomempresa = ((String) sessions.get("nomempresa"));
	String razonsocial = ((String) sessions.get("razonsocial"));
	String rfc = ((String) sessions.get("rfc"));
	String nombrerol = ((String) sessions.get("nombrerol"));	
	String descripcion = ((String) sessions.get("descripcion")); //descripcion rol
%>
    
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Punto de Venta | Inicio</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<style>
    html, body {
        height: 100%;
        margin: 0;
        font-family: 'Segoe UI', Arial, Helvetica, sans-serif;
        background: linear-gradient(135deg, #003471, #0059b3);
    }

    /* ===== HEADER ===== */
    .navbar {
        background: rgba(0, 0, 0, 0.15);
        border: none;
        border-radius: 0;
        box-shadow: 0 4px 15px rgba(0,0,0,0.25);
    }

    .navbar-brand,
    .navbar-text,
    .navbar-nav > li > a {
        color: #ffffff !important;
    }

    /* ===== CONTENEDOR GENERAL ===== */
    .container {
        margin-top: 30px;
    }

    /* ===== INFO BOX ===== */
    .info-box {
        background: rgba(255,255,255,0.15);
        backdrop-filter: blur(8px);
        color: #fff;
        padding: 25px;
        border-radius: 14px;
        box-shadow: 0 10px 30px rgba(0,0,0,0.35);
    }

    .info-box h3 {
        margin-top: 0;
        font-weight: 600;
    }

    /* ===== CARDS ===== */
    .card {
        background: rgba(255,255,255,0.95);
        border-radius: 16px;
        padding: 30px 20px;
        text-align: center;
        box-shadow: 0 15px 35px rgba(0,0,0,0.25);
        cursor: pointer;
        transition: all 0.35s ease;
        margin-bottom: 25px;
        min-height: 160px;
    }

    .card:hover {
        transform: translateY(-8px) scale(1.03);
        box-shadow: 0 25px 50px rgba(0,0,0,0.35);
    }

    .card span {
        font-size: 46px;
        color: #003471;
        margin-bottom: 15px;
        display: block;
    }

    .card h4 {
        font-weight: 600;
        color: #003471;
        margin-top: 10px;
    }

    /* ===== FOOTER ===== */
    footer {
        margin-top: 50px;
        padding: 20px;
        text-align: center;
        font-size: 12px;
        color: rgba(255,255,255,0.75);
    }

    /* ===== BOTÓN LOGOUT ===== */
    .btn-danger {
        border-radius: 20px;
        padding: 4px 12px;
    }
</style>


</head>
<body>

  
<!-- HEADER -->
<nav class="navbar">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <span class="glyphicon glyphicon-cloud"></span>
            </a>
        </div>

        <p class="navbar-text navbar-right">
            Usuario: <strong><%out.print(session.getAttribute("loguin"));%></strong> |
            Rol: <strong><%out.print(session.getAttribute("nombrerol"));%></strong>
            &nbsp;
            <a href="logout" class="btn btn-danger btn-xs">
                Cerrar sesión
            </a>
        </p>
    </div>
</nav>

<div class="container">

    <!-- BIENVENIDA -->
    <div class="info-box">
        <h3>Bienvenido al Sistema Punto de Venta</h3>
        <p>
            Representante: <strong><%out.print(session.getAttribute("nombre"));%></strong><br>        	
            Empresa: <strong><%out.print(session.getAttribute("nomempresa"));%></strong><br>
            Razon Social: <strong><%out.print(session.getAttribute("razonsocial"));%></strong><br>
            R.F.C: <strong><%out.print(session.getAttribute("rfc"));%></strong><br>
        </p>
    </div>

    <br>

    <!-- ACCESOS RAPIDOS -->
    <div class="row">

        <div class="col-sm-4">
            <div class="card" onclick="location.href='listventasdo?idempresa=<%out.print(session.getAttribute("idempresa"));%>'">
                <span class="glyphicon glyphicon-shopping-cart"></span>
                <h4>Ventas</h4>
            </div>
        </div>

        <div class="col-sm-4">
      
            <div class="card" onclick="location.href='listaproductosdo?idempresa=<%out.print(session.getAttribute("idempresa"));%>'">
                <span class="glyphicon glyphicon-barcode"></span>
                <h4>Productos</h4>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="card" onclick="location.href='listaclientesdo?idempresa=<%out.print(session.getAttribute("idempresa"));%>'">
                <span class="glyphicon glyphicon-user"></span>
                <h4>Clientes</h4>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="card" onclick="location.href='informedo?idempresa=<%out.print(session.getAttribute("idempresa"));%>'">
                <span class="glyphicon glyphicon-stats"></span>
                <h4>Infornes</h4>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="card" onclick="location.href='miempresado?idempresa=<%out.print(session.getAttribute("idempresa"));%>'">
                <span class="glyphicon glyphicon-home"></span>
                <h4>MiEmpresa</h4>
            </div>
        </div>

        <!-- CONFIGURACION (VISIBLE SOLO PARA ADMIN) -->
        <div class="col-sm-4">
            <div class="card" onclick="location.href='configuracion.action'">
                <span class="glyphicon glyphicon-cog"></span>
                <h4>Configuración</h4>
            </div>
        </div>

    </div>

</div>

<!-- FOOTER -->
<footer>
    © 2026 – Sistema Punto de Venta desarrollado por Rodrigo.<br>
    Uso autorizado únicamente para fines comerciales del licenciatario.
</footer>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>
</html>

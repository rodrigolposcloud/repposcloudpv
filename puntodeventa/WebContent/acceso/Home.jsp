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
    background: #eef3f9;
}

/* ===== HEADER ===== */
.navbar {
    background: #191970;
    border: none;
    border-radius: 0;
    box-shadow: 0 3px 10px rgba(0,0,0,0.2);
}

.navbar-brand,
.navbar-text,
.navbar-nav > li > a {
    color: #ffffff !important;
}

/* ===== CONTENEDOR ===== */

.container{
    margin-top:30px;
}

/* ===== CAJA BIENVENIDA ===== */

.info-box{

    background:#E6E6FA;
    border-radius:12px;
    padding:25px;

    box-shadow:0 5px 15px rgba(0,0,0,0.1);

}

.info-box h3{

    margin-top:0;
    color:#0d6efd;
    font-weight:600;

}

/* ===== TARJETAS ===== */

.card{

    background:#ffffff;

    border-radius:12px;

    box-shadow:0 6px 20px rgba(0,0,0,0.15);

    overflow:hidden;

    cursor:pointer;

    transition:all .3s;

}

.card:hover{

    transform:translateY(-6px);

    box-shadow:0 12px 30px rgba(0,0,0,0.2);

}

/* ===== HEADER TARJETA ===== */

.card:before{

    content:"";

    display:block;

    height:40px;

    background:#191970;

}

/* ===== ICONO ===== */

.card span{

    font-size:48px;

    color:#0d6efd;

    display:block;

    text-align:center;

    padding:25px 0 10px 0;

}

/* ===== FOOTER TARJETA ===== */

.card h4{

    background:#E6E6FA;

    margin:0;

    padding:15px;

    font-weight:600;

    color:#333;

    text-align:center;

    border-top:1px solid #e4e6ea;

}

/* ===== FOOTER GENERAL ===== */

footer{

    margin-top:50px;

    padding:20px;

    text-align:center;

    font-size:12px;

    color:#191970;

}

/* ===== BOTON ===== */

.btn-danger{

    border-radius:20px;

    padding:4px 12px;

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

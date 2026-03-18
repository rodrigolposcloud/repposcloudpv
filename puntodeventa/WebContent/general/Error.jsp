<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Error del Sistema</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
body{
    background-color:#f4f6f8;
}
.error-box{
    margin-top:100px;
    padding:40px;
    background:#fff;
    border-radius:8px;
    box-shadow:0 4px 12px rgba(0,0,0,.15);
}
.icon-error{
    font-size:40px;
    color:#d9534f;
}
</style>
</head>

<body>

<div class="container text-center">
    <div class="col-md-6 col-md-offset-3 error-box">

        <span class="glyphicon glyphicon-remove-circle icon-error"></span>

        <h2 class="text-danger">¡Error Verifique!</h2>

        <p class="lead">
				1.- El usuario no existe. 
				2.- El usuario o Contraseña son INCORRECTOS.
				3.- El usuario no cuenta con permisos.
				4.- O Llame al Administrador de Sistemas.
       </p>

        <hr>

        <a href="homeaction"
           class="btn btn-warning btn-lg">
           <span class="glyphicon glyphicon-arrow-left"></span>
           Regresar
        </a>

    </div>
</div>

</body>
</html>

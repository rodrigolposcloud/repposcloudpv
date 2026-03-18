<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%
	
		Map<String, Object> sessions = ActionContext.getContext().getSession();
		String idiusuario = ((String) sessions.get("idusuario"));
		String idempresa = ((String) sessions.get("idempresa"));
		String idrol = ((String) sessions.get("idrol"));
%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Operación Exitosa</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
body{
    background-color:#f4f6f8;
}
.msg-box{
    margin-top:100px;
    padding:40px;
    background:#fff;
    border-radius:8px;
    box-shadow:0 4px 12px rgba(0,0,0,.1);
}
.icon-success{
    font-size:70px;
    color:#28a745;
}
</style>
</head>

<body>

<div class="container text-center">
    <div class="col-md-6 col-md-offset-3 msg-box">

        <span class="glyphicon glyphicon-ok-circle icon-success"></span>

        <h2 class="text-success">Operacion realizada correctamente</h2>

        <p class="lead"> Cliente Eliminado <br> </p>
        <hr>
        <a href="listaclientesdo?idempresa=<%out.print(session.getAttribute("idempresa"));%>"
           class="btn btn-primary btn-lg">
           <span class="glyphicon glyphicon-arrow-left"></span>
           Regresar
        </a>

    </div>
</div>

</body>
</html>

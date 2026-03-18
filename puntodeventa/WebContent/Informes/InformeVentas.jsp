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
<title>Informe de Ventas</title>

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<style>

body{

background:#eef3f9;
font-family:Arial;

}

.panel{

background:white;
padding:30px;
border-radius:10px;
box-shadow:0px 4px 15px rgba(0,0,0,0.1);

}

.titulo{

font-size:28px;
font-weight:bold;
color:#0d6efd;
margin-bottom:25px;

}

.tarjeta{

border-radius:10px;
box-shadow:0 4px 10px rgba(0,0,0,0.1);
overflow:hidden;

}

.tarjeta-header{

padding:10px;
font-weight:bold;
color:white;
text-align:center;

}

.tarjeta-icono{

font-size:45px;
padding:20px;
text-align:center;
color:#555;

}

.tarjeta-valor{

font-size:28px;
font-weight:bold;
padding:10px;
text-align:center;

}

.ventas{
background:#28a745;
}

.realizadas{
background:#007bff;
}

.productos{
background:#6c757d;
}

.canceladas{
background:#dc3545;
}

</style>

</head>

<body>

<div class="container mt-4">

<div class="panel">

<div class="titulo text-center">
Informe de Ventas
</div>

<!-- FILTRO -->

<form action="informeaction" method="post">
<input name="idempresa" type="hidden" value= <%out.print(session.getAttribute("idempresa"));%> />

<div class="row mb-4">

			<div class="col-md-3">
			<label>Fecha Inicial</label>
			<input type="date"  name="fechainicial" class="form-control">
			</div>
			
			<div class="col-md-3">
			<label>Fecha Final</label>
			<input type="date" name="fechafinal" class="form-control">
			</div>

			<div class="col-md-4 d-flex align-items-end">
			
					<button class="btn btn-primary me-2">
					Aceptar
					</button>
					
					<button type="button" class="btn btn-dark" onclick="window.location.href='homesdo?idempresa=<%out.print(session.getAttribute("idempresa"));%>'">
					    Regresar
					</button>                
					
			</div>

</div>

</form>

<!-- TARJETAS -->

<div class="row">

		<!-- TOTAL VENTAS -->

			<div class="col-md-3">
			
						<div class="tarjeta">
						
						<div class="tarjeta-header ventas">
						Total Ventas
						</div>
						
						<div class="tarjeta-icono">
						<i class="bi bi-cash-stack"></i>
						</div>
						
						<div class="tarjeta-valor text-success">
						$ <strong> <s:property value="totalventas"/> </strong> 
						</div>
						
						</div>
			
			</div>


			<!-- VENTAS REALIZADAS -->
			
			<div class="col-md-3">
			
				<div class="tarjeta">
				
				<div class="tarjeta-header realizadas">
				Ventas Realizadas
				</div>
				
				<div class="tarjeta-icono">
				<i class="bi bi-receipt"></i>
				</div>
				
				<div class="tarjeta-valor text-primary">
				<strong> <s:property value="ventarealizadas"/> </strong>
				</div>
				
				</div>
			
			</div>


<!-- PRODUCTOS VENDIDOS -->

			<div class="col-md-3">
			
			<div class="tarjeta">
			
					<div class="tarjeta-header productos">
					Productos Vendidos
					</div>
					
					<div class="tarjeta-icono">
					<i class="bi bi-box-seam"></i>
					</div>
					
					<div class="tarjeta-valor">
					<strong> <s:property value="productosvendidos"/> </strong>
					</div>
					
			</div>
			
			</div>


		<!-- VENTAS CANCELADAS -->
		
		<div class="col-md-3">
		
				<div class="tarjeta">
				
				<div class="tarjeta-header canceladas">
				Ventas Canceladas
				</div>
				
				<div class="tarjeta-icono">
				<i class="bi bi-x-circle"></i>
				</div>
				
				<div class="tarjeta-valor text-danger">
				<strong> <s:property value="ventacanceladas"/> </strong>
				</div>
				
				</div>
				
		</div>
		
		</div>
	</div>
		
</div>

<!-- ================= AVISO LEGAL ================= -->
<footer class="text-center mt-4 text-muted">
<small>
© 2026 – Sistema Punto de Venta desarrollado por RodrigoIA.  
Uso autorizado únicamente para fines comerciales del licenciatario.  
Prohibida su reproducción, modificación o distribución sin autorización expresa.
</small>
</footer>



</body>

</html>
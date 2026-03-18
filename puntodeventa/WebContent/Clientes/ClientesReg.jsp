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
    <title>Registrar Clientes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h4>Registrar Cliente</h4>
        </div>

        <div class="card-body">
            <form role="form" id="clientesAction" name="clientesAction" action="clientesAction" method="POST">
			<input name="opcion" type="hidden" value="1" />
			<input name="idusuario" type="hidden" value=<%out.print(session.getAttribute("idusuario"));%> />
			<input name="idempresa" type="hidden" value= <%out.print(session.getAttribute("idempresa"));%> />

                <div class="mb-3">
                    <label class="form-label">Código de Barras del Cliente</label>
                  <input  type="text" name="codebarcliente" id="codebarcliente"
                   class="form-control" placeholder="Codigo Barras" maxlength="20"
                   required autofocus>
                </div>

                <div class="mb-3">
                    <label class="form-label">Nombre del Cliente</label>
                    <input type="text" name="nomcliente" id="nomcliente" class="form-control"
                    placeholder="Nombre del Cliente" maxlength="120" required autofocus>
                </div>

                <div class="row mb-3">
                    <div class="col-md-4">
                        <label class="form-label">Razon Social</label>
                        <input type="text" name= "razonsocialc" id="razonsocialc" class="form-control"
                               maxlength="120" placeholder="Razon Social" required autofocus>
                    </div>

                    <div class="col-md-4">
                        <label class="form-label">R.F.C</label>
                        <input type="text"  name = "rfcclie" id="rfcclie" class="form-control"
                              maxlength="20" placeholder="R.F.C" required autofocus>
                    </div>

                    <div class="col-md-4">
                        <label class="form-label">Telefono(s) o Celular</label>
                        <input type="text" name = "telefonoc" id="telefonoc" class="form-control" 
                        maxlength="50" placeholder="Tels." required autofocus>
                    </div>
					
					 <div class="col-md-8">
                        <label class="form-label">Domicilio</label>
                        <input type="text" name="domicilioc" id="domicilioc" class="form-control"
                    		maxlength="120"  placeholder="Domicilo" required autofocus>
                    </div>                    
               </div>

                <div class="text-end">
					<button type="button" class="btn btn-dark" onclick="window.location.href='listaclientesdo?idempresa=<%out.print(session.getAttribute("idempresa"));%>'">
					    Regresar
					</button>                
                    <button type="reset" class="btn btn-secondary">Limpiar</button>
                    <button type="submit" class="btn btn-success">Guardar Cliente</button>
                </div>

            </form>
        </div>
    </div>
</div>

</body>
</html>

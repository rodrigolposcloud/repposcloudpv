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
<title>Visor de Ticket</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<style>
body{
    background:#0f172a;
    color:white;
}
.panel{
    border-radius:12px;
}
.btn{
    margin-right:5px;
}
</style>
</head>

<body>

<div class="container">

    <div class="panel panel-primary">
        <div class="panel-heading">
            🎫 Visor de Ticket — Folio: <s:property value="folioventa"/>
        </div>

        <div class="panel-body text-center">

            <!-- 🔥 BOTONES -->
            <div class="btn-group">

                <a class="btn btn-info"
                   target="_blank"
                   href="descargarTicketPdf?folioventa=<s:property value='folioventa'/>">
                   📥 Descargar
                </a>

                <button class="btn btn-success" onclick="imprimirTicket()">
                    🖨 Imprimir
                </button>

                <button class="btn btn-warning" onclick="enviarWhats()">
                    📱 WhatsApp
                </button>

                <button class="btn btn-primary" onclick="enviarCorreo()">
                    📧 Correo
                </button>

            </div>

            <hr>

            <!-- 🔥 VISOR -->
            <iframe
                src="descargarTicketPdf?folioventa=<s:property value='folioventa'/>"
                width="100%"
                height="650px"
                style="border-radius:10px;">
            </iframe>

        </div>
    </div>

</div>


<!-- ================= MODAL ENVIAR CORREO ================= -->
<div class="modal fade" id="modalCorreo" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">

      <form id="formCorreo"
            method="post"
            action="enviarCorreoTicket">

        <div class="modal-header" style="background:#337ab7;color:white;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">📧 Enviar Ticket por Correo</h4>
        </div>

        <div class="modal-body">

          <!-- folio oculto -->
          <input type="hidden"
                 name="folioventa"
                 value="<s:property value='folioventa'/>">

          <div class="form-group">
            <label>Correo electrónico del cliente</label>
            <input type="email"
                   name="correoCliente"
                   id="correoCliente"
                   class="form-control"
                   placeholder="cliente@correo.com"
                   required>
          </div>

        </div>

        <div class="modal-footer">
          <button type="submit" class="btn btn-success">
            🚀 Enviar
          </button>

          <button type="button"
                  class="btn btn-danger"
                  data-dismiss="modal">
            ❌ Cancelar
          </button>
        </div>

      </form>

    </div>
  </div>
</div>

<!-- =====ORDEN IDEAL Y CORRECTO DEBE SER EN HTML ================= -->
<!-- ======= ️1.jQuery ======= -->
<!-- ======= 2️. Bootstrap JS ======= -->
<!-- ======= 3️. MIS scripts ======= -->


<!-- jQuery (OBLIGATORIO PARA BOOTSTRAP 3) -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<!-- Bootstrap JS -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>



<script>

function imprimirTicket(){
    window.frames[0].focus();
    window.frames[0].print();
}

function enviarWhats(){
    let folio = "<s:property value='folioventa'/>";
    let url = "https://wa.me/?text=Ticket%20de%20venta%20folio%20" + folio;
    window.open(url, "_blank");
}

function enviarCorreo(){
    $("#modalCorreo").modal("show");
}

window.onload = function () {

    // esperar a que cargue el PDF embebido
    setTimeout(function () {
        window.print();
    }, 1200);

};
</script>

</body>
</html>
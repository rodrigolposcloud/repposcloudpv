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
<title>Punto de Venta | Ventas</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
 href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
<link rel="stylesheet"
 href="https://cdn.datatables.net/buttons/2.4.1/css/buttons.dataTables.min.css">


<style>
    body {
        background-color: #f4f6f8;
        font-family: Arial, Helvetica, sans-serif;
    }

    .panel-heading {
        font-size: 18px;
        font-weight: bold;
    }

    .table th {
        background-color: #003471;
        color: #fff;
        text-align: center;
        vertical-align: middle;
    }

    .table td {
        vertical-align: middle;
    }

    .btn-icon {
        padding: 4px 8px;
    }
</style>



</head>
<body>

<div class="container-fluid">

    <div class="panel panel-default">
        <div class="panel-heading">
            📦 Ventas del Dia a Dia
            
            <a href="homesdo?idempresa=<%out.print(session.getAttribute("idempresa"));%>" class="btn btn-dark btn-sm pull-right">
                - Salir
            </a>
            <a href="ventasdo?idempresa=<%out.print(session.getAttribute("idempresa"));%>" class="btn btn-success btn-sm pull-right">
                + IR a Ventas
            </a>
        </div>

        <div class="panel-body">

            <!-- BUSCADOR POR CODIGO DE BARRAS -->
            <div class="row">
                <div class="col-md-4">
					<input type="text" id="buscador" name = "buscador"
					 class="form-control"
					 placeholder="Buscar Folio Venta..."
					 autofocus
					 autocomplete="off">
             	</div>
            </div>

            <br>

            <div class="table-responsive">
				<table id="example"
								class="display table table-sm table-hover table-head-bg-info"
								role="grid" aria-describedby="add-row_info">
					<thead class="text-center">
                        <tr>
                            <th>No.</th>
                            <th>FolioVenta</th>
                            <th>Total</th>
                            <th>Descuento</th>
                            <th>TotalPagado</th>
                            <th>PagoenEfectivo</th>
                            <th>Cambio</th>
                            <th>FecVenta</th>
                            <th>Estatus</th>
                            <th>FecCancel</th>
                            <th>Motivo</th>
                            <th>Accion</th>
                            <th>Cliente</th>
                            <th>Idemp</th>
                        </tr>
                    </thead>

							<tbody class="text-capitalize">
								<s:iterator value="listaventas" id="list">
									<tr>
										<td><s:property value="idventa" /></td>
										<td scope="row"><s:property value="folioventa" /></td>
										<td><s:property value="total" /></td>
										<td><s:property value="descuento" /></td>
										<td><s:property value="totalapagar" /></td>
										<td><s:property value="pagoefectivo" /></td>
										<td><s:property value="cambio" /></td>
										<td><s:property value="fecventa" /></td>
										<td><s:property value="estatusv" /></td>										
										<td><s:property value="feccancelacion" /></td>
										<td><s:property value="motivocancelacion" /></td>
										<td class="text-center">
											<button type="button"
											        class="btn btn-warning btn-xs btnCancelar"
											        data-id="<s:property value='folioventa'/>"  
											        >
											    <span class="glyphicon glyphicon-remove"></span>
											</button>
											<button type="button"
											        class="btn btn-info btn-xs btnVerTicket"
											        data-folio="<s:property value='folioventa'/>">
											    <span class="glyphicon glyphicon-print"></span> 
											    Ticket
											</button>
										</td>
										<td><s:property value="nomcliente" /></td>
										<td><s:property value="idempresa" /></td>
									</tr>
								</s:iterator>
                   			</tbody>

                </table>
            </div>

        </div>
    </div>

</div>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<!-- Bootstrap -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<!-- DataTables -->
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

<!-- Buttons -->
<script src="https://cdn.datatables.net/buttons/2.4.1/js/dataTables.buttons.min.js"></script>
<script src="https://cdn.datatables.net/buttons/2.4.1/js/buttons.html5.min.js"></script>

<!-- Export -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/vfs_fonts.js"></script>


<!-- MODAL CANCELAR VENTA -->
<div class="modal fade" id="modalCancelar" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      
      <form method="post" action="cancelarVenta">
        
        <div class="modal-header bg-danger text-white">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Cancelar Venta</h4>
        </div>

        <div class="modal-body">

          <input type="hidden" name="idventa" id="idventaModal">
          <input type="hidden" name="folioventa" id="folioventa">

          <div class="form-group">
            <label>Fecha Cancelación</label>
            <input type="text" class="form-control"
                   name="feccancelacion"
                   id="fechaActual"
                   readonly>
          </div>

          <div class="form-group">
            <label>Motivo de Cancelación</label>
            <textarea class="form-control"
                      name="motivocancelacion"
                      rows="3"
                      required></textarea>
          </div>

        </div>

        <div class="modal-footer">
          <button type="submit" class="btn btn-danger">
            Confirmar Cancelación
          </button>
          <button type="button" class="btn btn-primary"
                  data-dismiss="modal">
            Descartar
          </button>
        </div>

      </form>

    </div>
  </div>
</div>



<script>
$(function () {

    var table = $('#example').DataTable({
        dom: 'Bfrtip',
        buttons: [
            { extend: 'excelHtml5', text: '📗 Excel' },
            { extend: 'pdfHtml5', text: '📕 PDF' },
            { extend: 'csvHtml5', text: '📘 CSV' }
        ],
        language: {
            search: "Buscar:",
            lengthMenu: "Mostrar _MENU_ registros",
            info: "Mostrando _START_ a _END_ de _TOTAL_",
            paginate: { next: "Siguiente", previous: "Anterior" }
        }
    });

    $('#buscador').on('keyup', function () {
        table.search(this.value).draw();
    });

});


// bOTON cANCELAR 

$(document).on("click", ".btnCancelar", function () {

    var folioventa = $(this).data("id");
    $("#folioventa").val(folioventa);

    // Fecha actual
    var fecha = new Date();
    var yyyy = fecha.getFullYear();
    var mm = String(fecha.getMonth() + 1).padStart(2, '0');
    var dd = String(fecha.getDate()).padStart(2, '0');

    var fechaFormateada = yyyy + "-" + mm + "-" + dd;

    $("#fechaActual").val(fechaFormateada);

    $("#modalCancelar").modal("show");

});


//===== VIZUALIZAR TICKET =====
$(document).on("click", ".btnVerTicket", function () {

    var folioventa = $(this).data("folio");

    // URL hacia tu visor
    var url = "verTicketVenta?folioventa=" + folioventa;

    window.open(url, "_blank");
});

</script>

</body>
</html>

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
<title>Punto de Venta | Clientes</title>
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
            📦Listado de Clientes
            
            <a href="homesdo" class="btn btn-dark btn-sm pull-right">
                - Salir
            </a>
            <a href="clientesaction" class="btn btn-success btn-sm pull-right">
                + Nuevo Cliente
            </a>
        </div>

        <div class="panel-body">

            <!-- BUSCADOR POR CODIGO DE BARRAS -->
            <div class="row">
                <div class="col-md-4">
					<input type="text" id="buscador" name = "buscador"
					 class="form-control"
					 placeholder="Escanear código..."
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
                            <th>Código de Barras</th>
                            <th>Cliente</th>
                            <th>RazonSocial</th>
                            <th>RFC</th>
                            <th>Telefono</th>
                            <th>Domicilio</th>
                            <th>FechaReg</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>

							<tbody class="text-capitalize">
								<s:iterator value="listaclientes" id="list">
									<tr>
										<td><s:property value="idcliente" /></td>
										<td scope="row"><s:property value="codebarcliente" /></td>
										<td><s:property value="nomcliente" /></td>
										<td><s:property value="razonsocialc" /></td>
										<td><s:property value="rfcclie" /></td>
										<td><s:property value="telefonoc" /></td>
										<td><s:property value="domicilioc" /></td>
										<td><s:property value="fechacreacionc" /></td>
										<td class="text-center">
										    <a href="eliminarCliente?idcliente=<s:property value='idcliente'/> & idempresa = <s:property value='idempresa'/> "
										       class="btn btn-danger btn-xs"
										       onclick="return confirm('¿Eliminar producto?');">
										        <span class="glyphicon glyphicon-trash"></span>
										    </a>
										</td>

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
</script>

</body>
</html>

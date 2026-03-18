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
<title>Punto de Venta</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
		body { background:#f4f6f9; }
		h1 { font-size:2.5rem; }
		input { font-size:1.1rem; }
		.ticket { font-size:12px; }


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

		.header-venta {
		    background: linear-gradient(90deg, #003471, #0d6efd);
		    color: white;
		    border-radius: 6px;
		    padding: 10px 15px;
		}

</style>

</head>

<body>

<div class="container-fluid mt-3">
<form role="form" id="ventasaction" name="ventasaction"
 action="ventasaction" method="POST" onsubmit="return prepararVenta();">
			<input name="opcion" type="hidden" value="1" />
			<input name="idusuario" type="hidden" value=<%out.print(session.getAttribute("idusuario"));%> />
			<input name="idempresa" type="hidden" value= <%out.print(session.getAttribute("idempresa"));%> />

			<!-- ===== CAMPOS REALES PARA EL ACTION ===== -->
			<!-- =====		name = lo que lee el Action ===== -->
			<!-- =====		id =   lo que usa JavaScript  ===== -->
			
			<input type="hidden" name="total" id="totalAction">
			<input type="hidden" name="descuento" id="descuentoAction">
			<input type="hidden" name="totalapagar" id="totalapagar">
			<input type="hidden" name="pagoefectivo" id="pagoefectivo">
			<input type="hidden" name="cambio" id="cambio">
			<input type="hidden" name="fecventa" id="fecventa">
			<input type="hidden" name="folioventa" id="folioventa">
			<input type="hidden" name="detalleVenta" id="detalleVentaInput">
			


<div class="row">

<div class="card shadow mb-3">
<div class="row header-venta mb-3 align-items-center">
		  <div class="col-md-4">
		    <label>Cliente</label>
		    <select class="form-control" name="idcliente">
		      <s:iterator value="listaclientesv">
		        <option value="<s:property value='idcliente'/>">
		          <s:property value="nomcliente"/>
		        </option>
		      </s:iterator>
		    </select>
		  </div>
		  <div class="col-md-4 text-center">
		    <strong>Fecha:</strong> <%= new java.util.Date() %>
		  </div>
		
		  <div class="col-md-4 text-end">
		    <strong>Folio:</strong> VTA-0000000
		    <a href="listventasdo?idempresa=<%out.print(session.getAttribute("idempresa"));%>" class="btn btn-dark btn-sm pull-right">
                	- Salir
            </a>
		  </div>

		</div>
 

 

</div>


<div class="col-md-4">
  <div class="card shadow mb-3">
    <div class="card-header bg-info text-white text-center">
      <h4>Escanear Producto</h4>
    </div>
    <div class="card-body">
		<input id="codigoInput"
		class="form-control form-control-lg mb-2"
		placeholder="Código de barras"
		onkeypress="agregarProducto(event)"
		autofocus>

			<input id="cantidadInput"
       		 type="number"
       		 class="form-control form-control-lg mb-2"
       		 value="1" min="1"		
       		 onkeypress="agregarProducto(event)"
				autofocus>

       
			<div class="card shadow">
				<div class="card-body">
			<p>Total: <strong id="totalLabel">$0.00</strong></p>
			
			<label>Descuento</label>
			<input id="descuento" type="number" class="form-control mb-2"
			oninput="calcularTotalFinal()">
			
			<p>Total a pagar:</p>
			<h1 class="text-success" id="totalFinal">$0.00</h1>
			
			<label>Pago efectivo</label>
			<input id="pago" type="number" class="form-control mb-2"
			oninput="calcularCambio()">
			
			<p>Cambio: <strong id="cambioLabel">$0.00</strong></p>
						        
			<button type="submit" class="btn btn-success">Cobrar / Imprimir</button>
 
		</div>
	</div>

    </div>
  </div>
</div>


<div class="col-md-8">
  <div class="card shadow">
    <div class="card-header bg-info text-white">
      <h4>Detalle de Venta</h4>
    </div>
    <div class="card-body p-0">
      <table class="table table-bordered mb-0">
        <thead class="table-dark">
          <tr>
            <th>Código</th>
            <th>Producto</th>
            <th>Precio</th>
            <th>Cant</th>
            <th>Subtotal</th>
            <th></th>
          </tr>
        </thead>
        <tbody id="detalleVenta"></tbody>
      </table>
    </div>
 
	 <div class="text-end mb-2">
	    <button type="button"
	            class="btn btn-success btn-sm"
	            onclick="exportarDetalleExcel()">
	        📊 Exportar a Excel
	    </button>
	</div>
 
 
  </div>
</div>






</div>
</form>


<button class="btn btn-info mb-2"
data-bs-toggle="collapse"
data-bs-target="#catalogo">
📦 Ver catálogo
</button>

<div id="catalogo" class="collapse">
  <!-- tu DataTable aquí -->
            <div class="table-responsive">
				<table id="example"
								class="display table table-sm table-hover table-head-bg-info"
								role="grid" aria-describedby="add-row_info">
					<thead class="text-center">
                        <tr>
                            <th>No.</th>
                            <th>Código de Barras</th>
                            <th>Producto</th>
                           	<th>Precio Venta</th>
                       </tr>
                    </thead>
					<tbody class="text-capitalize">
						<s:iterator value="listaproductosv" id="list">
							<tr>
								<td><s:property value="idproducto" /></td>
								<td scope="row"><s:property value="codigobarrasp" /></td>
								<td><s:property value="producto" /></td>
								<td><s:property value="precioventa" /></td>
							</tr>
						</s:iterator>
                 	</tbody>

                </table>
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

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<!-- Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- DataTables -->
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

<script>

window.onload = function () {
    let fecha = new Date().toISOString().slice(0, 19).replace("T", " ");
    document.getElementById("fecventa").value = fecha;

    // provisional (luego DB)
    document.getElementById("folioventa").value = "VTAND1001";
};


/* ================== ESTADO GLOBAL ================== */
let carrito = {};
let total = 0;

/* ================== AGREGAR PRODUCTO ================== */
function agregarProducto(e) {
    if (e.key !== "Enter") return;
    e.preventDefault();

    let codigo = document.getElementById("codigoInput").value.trim();
    let cantidad = parseInt(document.getElementById("cantidadInput").value) || 1;

    if (codigo === "") return;

    // Buscar producto en DataTable
    let fila = $("#example tbody tr").filter(function () {
        return $(this).find("td:eq(1)").text().trim() === codigo;
    });

    if (fila.length === 0) {
        alert("Producto no encontrado");
        return;
    }

    let producto = fila.find("td:eq(2)").text();
    let precio = parseFloat(fila.find("td:eq(3)").text());

    if (carrito[codigo]) {
        carrito[codigo].cantidad += cantidad;
    } else {
        carrito[codigo] = {
            producto: producto,
            precio: precio,
            cantidad: cantidad
        };
    }

    renderDetalle();

    document.getElementById("codigoInput").value = "";
    document.getElementById("cantidadInput").value = 1;
}


/* ================== RENDER TABLA ================== */
function renderDetalle() {
    let html = "";
    total = 0;

    for (let codigo in carrito) {
        let item = carrito[codigo];
        let subtotal = item.precio * item.cantidad;
        total += subtotal;

        html +=
        "<tr>" +
          "<td>" + codigo + "</td>" +
          "<td>" + item.producto + "</td>" +
          "<td>$" + item.precio.toFixed(2) + "</td>" +
          "<td class='text-center'>" + item.cantidad + "</td>" +
          "<td>$" + subtotal.toFixed(2) + "</td>" +
          "<td>" +
            "<button class='btn btn-danger btn-sm' onclick=\"eliminarProducto('" + codigo + "')\">❌</button>" +
          "</td>" +
        "</tr>";
    }

    // 🟢 UI
    document.getElementById("detalleVenta").innerHTML = html;
    document.getElementById("totalLabel").innerText = "$" + total.toFixed(2);

    // 🟢 Action
    document.getElementById("totalAction").value = total.toFixed(2);
 
    calcularTotalFinal();
}

/* ================== ELIMINAR ================== */
function eliminarProducto(codigo) {
    if (!confirm("¿Eliminar producto?")) return;
    delete carrito[codigo];
    renderDetalle();
}

/* ================== TOTALES ================== */
function calcularTotalFinal() {
    let descuento = parseFloat(document.getElementById("descuento").value) || 0;
    let totalFinal = total - descuento;
    if (totalFinal < 0) totalFinal = 0;

    document.getElementById("totalFinal").innerText =
        "$" + totalFinal.toFixed(2);

    // 🔽 ACTION
    document.getElementById("descuentoAction").value = descuento.toFixed(2);
    document.getElementById("totalapagar").value = totalFinal.toFixed(2);

    calcularCambio();
}


function calcularCambio() {
    let pago = parseFloat(document.getElementById("pago").value) || 0;
    let descuento = parseFloat(document.getElementById("descuento").value) || 0;
    let totalFinal = total - descuento;
    let cambio = pago - totalFinal;
    if (cambio < 0) cambio = 0;

    document.getElementById("cambioLabel").innerText =
        "$" + cambio.toFixed(2);

    // 🔽 ACTION
    document.getElementById("pagoefectivo").value = pago.toFixed(2);
    document.getElementById("cambio").value = cambio.toFixed(2);
}

function prepararVenta() {
    let detalle = [];

    for (let codigo in carrito) {
        let item = carrito[codigo];
        detalle.push({
            codigoprod: codigo,
            producto: item.producto,
            precio: item.precio,
            cantidad: item.cantidad,
            subtotal: (item.precio * item.cantidad).toFixed(2)
        });
    }

    document.getElementById("detalleVentaInput").value =
        JSON.stringify(detalle);

    return true; // permite submit
}

/* ======= SE EXPORTA EL DETALLE DE VENTA A EXCEL ================== */


function exportarDetalleExcel() {

    let tabla = document.getElementById("detalleVenta");

    if (!tabla || tabla.rows.length === 0) {
        alert("No hay datos para exportar");
        return;
    }

    let html = `
    <table border="1">
        <tr>
            <th>Código</th>
            <th>Producto</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Subtotal</th>
        </tr>`;

    for (let i = 0; i < tabla.rows.length; i++) {
        let celdas = tabla.rows[i].cells;

        html += "<tr>";
        html += "<td>" + celdas[0].innerText + "</td>";
        html += "<td>" + celdas[1].innerText + "</td>";
        html += "<td>" + celdas[2].innerText + "</td>";
        html += "<td>" + celdas[3].innerText + "</td>";
        html += "<td>" + celdas[4].innerText + "</td>";
        html += "</tr>";
    }

    html += "</table>";

    let uri = 'data:application/vnd.ms-excel;charset=utf-8,' + encodeURIComponent(html);

    let link = document.createElement("a");
    link.href = uri;
    link.download = "detalle_venta.xls";
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
}
</script>



</body>
</html>
        
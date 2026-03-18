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
    <title>Registro de Productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <script>
        function calcularPrecioVenta() {
            let preciocompra = parseFloat(document.getElementById("preciocompra").value) || 0;
            let impuesto = parseFloat(document.getElementById("impuesto").value) || 0;

            let precioventa = preciocompra + (preciocompra * impuesto / 100);

            document.getElementById("precioventa").value = precioventa.toFixed(2);
        }
    </script>
</head>

<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h4>Registro de Productos</h4>
        </div>

        <div class="card-body">
            <form role="form" id="productosdo" name="productosdo" action="productosdo" method="POST">
			<input name="opcion" type="hidden" value="1" />
			<input name="idusuario" type="hidden" value=<%out.print(session.getAttribute("idusuario"));%> />
			<input name="idempresa" type="hidden" value= <%out.print(session.getAttribute("idempresa"));%> />

                <div class="mb-3">
                    <label class="form-label">Código de Barras</label>
                  <input  type="text" name="codigobarrasp" id="codigobarrasp"
                   class="form-control" placeholder="Codigo Barras"
                   required autofocus>
                </div>

                <div class="mb-3">
                    <label class="form-label">Nombre del Producto</label>
                    <input type="text" name="producto" id="producto" class="form-control"
                    placeholder="Nombre del Producto" required autofocus>
                </div>

                <div class="row mb-3">
                    <div class="col-md-4">
                        <label class="form-label">Precio de Compra ($)</label>
                        <input type="number" step="0.01" name= "preciocompra" id="preciocompra" class="form-control"
                               oninput="calcularPrecioVenta()">
                    </div>

                    <div class="col-md-4">
                        <label class="form-label">Impuesto (%)</label>
                        <input type="number" step="0.01" name = "impuesto" id="impuesto" class="form-control"
                               value="16" oninput="calcularPrecioVenta()">
                    </div>

                    <div class="col-md-4">
                        <label class="form-label">Precio de Venta ($)</label>
                        <input type="number" step="0.01" name = "precioventa" id="precioventa" class="form-control" readonly>
                    </div>
					 <div class="col-md-4">
                        <label class="form-label">Stock</label>
                        <input type="number" name="stock" id="stock" class="form-control"
                    placeholder="stock" required autofocus>
                    </div>                    
   
					<div class="col-md-4">
						<label class="form-label">Categoria</label> 
						<select
							class="form-control" name="categoria" id="categoria" required>
							<option value="Botana">BOTANA</option>
							<option value="Dulces">DULCES</option>
							<option value="Bebidas">BEBIDAS</option>
							<option value="Limpieza">LIMPIEZA</option>
							<option value="Abarrotes">ABARROTES</option>
							<option value="Medicamentos">MEDICAMENTOS</option>
							<option value="Papeleria">PAPELERIA</option>
							<option value="Herramientas">HERRAMIENTAS</option>
							<option value="Computo">COMPUTO-ELECTRONICA</option>
							<option value="Otros">OTROS</option>
						</select>
						<div class="invalid-feedback">Es Requerido</div>
					</div>
   
                    
                </div>

                <div class="text-end">
					<button type="button" class="btn btn-dark" onclick="window.location.href='listaproductosdo?idempresa=<%out.print(session.getAttribute("idempresa"));%>'">
					    Regresar
					</button>                
                    <button type="reset" class="btn btn-secondary">Limpiar</button>
                    <button type="submit" class="btn btn-success">Guardar Producto</button>
                </div>

            </form>
        </div>
    </div>
</div>

</body>
</html>

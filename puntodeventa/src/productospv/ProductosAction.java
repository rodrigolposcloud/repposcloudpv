package productospv;



import com.opensymphony.xwork2.ActionSupport;

import conexion.EjecutaSQLAction;




public class ProductosAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String idproducto;
	private String idempresa;
	private String idusuario;
	private String codigobarrasp;
	private String producto;
	private String preciocompra;
	private String impuesto;
	private String precioventa;
	private String categoria;
	private String stock;
	private String fecregistro;

	private String opcion;

	String existe="";
	String sqlQuery="";	
	

	
	public String execute() throws Exception{
	      //Clase que ejecuta transactions
	      EjecutaSQLAction sqleje = new EjecutaSQLAction();
		  
			      try {
				      sqlQuery="INSERT INTO PUNTOVENTA.TBLPRODUCTOS VALUES(0,"+idempresa+","+idusuario+","+codigobarrasp+",'"+producto+"',"+
				      		  ""+preciocompra+","+impuesto+","+precioventa+ ",'"+ categoria+ "',"+ stock + ",NOW());";
				       	System.out.println("EL QUERY ES:::::"+sqlQuery);	   
				        existe=sqleje.EjecutaSQL(sqlQuery);
				      
			    	} catch (ArithmeticException e) {
			    	    // Código para manejar la excepción
			    	    System.out.println("Error: No se pudo insertar producto.");
			    	    System.out.println("Detalles: " + e.getMessage());
			    	    return "inicio";
			    	}

			      return "success"; 
   
		
	}


	public String getIdproducto() {
		return idproducto;
	}


	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}


	public String getIdempresa() {
		return idempresa;
	}


	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}


	public String getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}


	public String getCodigobarrasp() {
		return codigobarrasp;
	}


	public void setCodigobarrasp(String codigobarrasp) {
		this.codigobarrasp = codigobarrasp;
	}


	public String getProducto() {
		return producto;
	}


	public void setProducto(String producto) {
		this.producto = producto;
	}


	public String getPreciocompra() {
		return preciocompra;
	}


	public void setPreciocompra(String preciocompra) {
		this.preciocompra = preciocompra;
	}


	public String getImpuesto() {
		return impuesto;
	}


	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}


	public String getPrecioventa() {
		return precioventa;
	}


	public void setPrecioventa(String precioventa) {
		this.precioventa = precioventa;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getStock() {
		return stock;
	}


	public void setStock(String stock) {
		this.stock = stock;
	}


	public String getFecregistro() {
		return fecregistro;
	}


	public void setFecregistro(String fecregistro) {
		this.fecregistro = fecregistro;
	}

	
	
	public String getOpcion() {
		return opcion;
	}


	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}



}

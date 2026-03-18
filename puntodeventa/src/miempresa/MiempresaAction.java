package miempresa;



import com.opensymphony.xwork2.ActionSupport;

import conexion.EjecutaSQLAction;

/*Inicio POS Cloud
 *RodrigoIA
 */



public class MiempresaAction extends ActionSupport {

	private static final long serialVersionUID = 1L;



	private String idempresa;
	private String nomempresa;
	private String razonsocial;
	private String telefono;
	private String rfc;
	private String domicilio; 
	private String estatus;
	private String fechacreacion;
	private String correo;
	private String numero;
	private String colonia;
	private String ciudad;
	private String estado;
	private String codpostal;
	

	private String opcion;

	String existe="";
	String sqlQuery="";	
	

	
	public String execute() throws Exception{
	      //Clase que ejecuta transactions
	      EjecutaSQLAction sqleje = new EjecutaSQLAction();
		  
			      try {

			    	  sqlQuery =" INSERT INTO puntoventa.tblempresa(idempresa, " +
			    	  "nomempresa,razonsocial,telefono,rfc,domicilio,estatus,fechacreacion," +
			    	  " correo,numero,colonia,ciudad, estado,codpostal) VALUES (0," +
			    	  " '"+nomempresa+",'"+razonsocial+"','"+telefono+"','"+rfc+"','"+domicilio+"','A'," +
			    	  " NOW(),'"+correo+"','"+numero+"','"+colonia+"','" + ciudad +"','"+ estado+"','"+codpostal+"')";			    	  
				      System.out.println("SE EJECUTO TRANSACTION::::"+sqlQuery);	   
				        existe=sqleje.EjecutaSQL(sqlQuery);
				      
			    	} catch (ArithmeticException e) {
			    	    // Código para manejar la excepción
			    	    System.out.println("Error: No se pudo insertar miempresa.");
			    	    System.out.println("Detalles: " + e.getMessage());
			    	    return "inicio";
			    	}

			      return "success"; 
   
		
	}

	public String getIdempresa() {
		return idempresa;
	}


	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}


	public String getNomempresa() {
		return nomempresa;
	}


	public void setNomempresa(String nomempresa) {
		this.nomempresa = nomempresa;
	}


	public String getRazonsocial() {
		return razonsocial;
	}


	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getRfc() {
		return rfc;
	}


	public void setRfc(String rfc) {
		this.rfc = rfc;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	public String getEstatus() {
		return estatus;
	}


	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


	public String getFechacreacion() {
		return fechacreacion;
	}


	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getColonia() {
		return colonia;
	}


	public void setColonia(String colonia) {
		this.colonia = colonia;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getCodpostal() {
		return codpostal;
	}


	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}


	public String getOpcion() {
		return opcion;
	}


	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}



}

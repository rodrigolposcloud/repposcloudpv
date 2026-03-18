package clientespv;



import com.opensymphony.xwork2.ActionSupport;

import conexion.EjecutaSQLAction;




public class ClientesAction extends ActionSupport {

	private static final long serialVersionUID = 1L;


	private String idcliente;
	private String idempresa;
	private String codebarcliente;
	private String nomcliente;
	private String razonsocialc;
	private String telefonoc;
	private String domicilioc;
	private String rfcclie;
	private String fechacreacionc;

	private String opcion;

	String existe="";
	String sqlQuery="";	
	

	
	public String execute() throws Exception{
	      //Clase que ejecuta transactions
	      EjecutaSQLAction sqleje = new EjecutaSQLAction();
		  
			      try {
				      sqlQuery="INSERT INTO PUNTOVENTA.tblcliente VALUES(0,"+idempresa+","+codebarcliente+",'"+nomcliente+"','"+razonsocialc+"',"+
				      		  "'"+telefonoc+"','"+domicilioc+"','"+rfcclie+ "'" + ",NOW());";
				       	System.out.println("SE EJECUTO TRANSACTION::::"+sqlQuery);	   
				        existe=sqleje.EjecutaSQL(sqlQuery);
				      
			    	} catch (ArithmeticException e) {
			    	    // Código para manejar la excepción
			    	    System.out.println("Error: No se pudo insertar cliente.");
			    	    System.out.println("Detalles: " + e.getMessage());
			    	    return "inicio";
			    	}

			      return "success"; 
   
		
	}

	public String getIdcliente() {
		return idcliente;
	}



	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}



	public String getIdempresa() {
		return idempresa;
	}



	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}



	public String getCodebarcliente() {
		return codebarcliente;
	}



	public void setCodebarcliente(String codebarcliente) {
		this.codebarcliente = codebarcliente;
	}



	public String getNomcliente() {
		return nomcliente;
	}



	public void setNomcliente(String nomcliente) {
		this.nomcliente = nomcliente;
	}



	public String getRazonsocialc() {
		return razonsocialc;
	}



	public void setRazonsocialc(String razonsocialc) {
		this.razonsocialc = razonsocialc;
	}



	public String getTelefonoc() {
		return telefonoc;
	}



	public void setTelefonoc(String telefonoc) {
		this.telefonoc = telefonoc;
	}



	public String getDomicilioc() {
		return domicilioc;
	}



	public void setDomicilioc(String domicilioc) {
		this.domicilioc = domicilioc;
	}



	public String getRfcclie() {
		return rfcclie;
	}



	public void setRfcclie(String rfcclie) {
		this.rfcclie = rfcclie;
	}



	public String getFechacreacionc() {
		return fechacreacionc;
	}



	public void setFechacreacionc(String fechacreacionc) {
		this.fechacreacionc = fechacreacionc;
	}



	public String getOpcion() {
		return opcion;
	}


	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}



}

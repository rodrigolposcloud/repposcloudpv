package ventaspv;


import com.opensymphony.xwork2.ActionSupport;

import conexion.EjecutaSQLAction;
/*
Sistema POS Cloud
Desarrollado por RODRIGOVL Technologies
con Arquitectura asistida por IA
© 2026 Todos los derechos reservados
	 */

public class CancelaVentasAction extends ActionSupport {

	private static final long serialVersionUID = 1L;


	private String idempresa;
	private String folioventa;
	private String feccancelacion;
	private String motivocancelacion;
	private String estatusv;
	
	
	public String execute() throws Exception{
		
	      //Clase que ejecuta los querys
	      EjecutaSQLAction sqleje = new EjecutaSQLAction();

			 String miquery = "";

	      try {
		      //Actualizo datos de la venta
		      miquery ="UPDATE PUNTOVENTA.TBLVENTAS SET estatusv = 'C', feccancelacion='" + feccancelacion + "' , motivocancelacion='" + motivocancelacion + "' " +
		    		  	" WHERE  folioventa='"+ folioventa+"'";
		      sqleje.EjecutaSQL(miquery);
		      
	    	} catch (ArithmeticException e) {
	    	    // Código para manejar la excepción
	    	    System.out.println("Error: No se pudo cancelar la venta.");
	    	    System.out.println("Detalles: " + e.getMessage());
	    	}

	      return "success"; 	       
		
	}

	
	
	public String getIdempresa() {
		return idempresa;
	}






	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}






	public String getFolioventa() {
		return folioventa;
	}






	public void setFolioventa(String folioventa) {
		this.folioventa = folioventa;
	}






	public String getFeccancelacion() {
		return feccancelacion;
	}






	public void setFeccancelacion(String feccancelacion) {
		this.feccancelacion = feccancelacion;
	}






	public String getMotivocancelacion() {
		return motivocancelacion;
	}






	public void setMotivocancelacion(String motivocancelacion) {
		this.motivocancelacion = motivocancelacion;
	}






	public String getEstatusv() {
		return estatusv;
	}






	public void setEstatusv(String estatusv) {
		this.estatusv = estatusv;
	}




	
	
	
}

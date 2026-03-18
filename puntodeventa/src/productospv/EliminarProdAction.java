package productospv;


import com.opensymphony.xwork2.ActionSupport;
import conexion.EjecutaSQLAction;


public class EliminarProdAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String idempresa;
	private String idproducto;
	
	
	public String execute() throws Exception{
		
	      //Clase que ejecuta los querys
	      EjecutaSQLAction sqleje = new EjecutaSQLAction();

			 String miquery = "";

	      try {
		      //Actualizo datos de la venta
		      miquery ="DELETE FROM PUNTOVENTA.TBLPRODUCTOS WHERE idproducto = "+ idproducto + 
		    		  " AND idempresa = " + idempresa;
		      sqleje.EjecutaSQL(miquery);
		      
	    	} catch (ArithmeticException e) {
	    	    // Código para manejar la excepción
	    	    System.out.println("Error: No se pudo eliminar producto.");
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


	public String getIdproducto() {
		return idproducto;
	}



	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

















	
	
	
}

package Informes;
//Elaborado por RodrigolazoIA...

/*
Sistema POS Cloud
Desarrollado por RODRIGOVL Technologies
con Arquitectura asistida por IA
© 2026 Todos los derechos reservados
	 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.opensymphony.xwork2.ActionSupport;

import conexion.Conexion;
import conexion.Util;
//import java.text.SimpleDateFormat;
//import java.util.Date;

public class InformeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String idempresa;
	private String totalventas;
	private String ventarealizadas;
	private String ventacanceladas;
	private String productosvendidos;
	private String fechainicial;
	private String fechafinal;


	
	public String execute() throws Exception{
			System.out.println("FECHAS recibidas-----FI-"+fechainicial+" ----FF-"+fechafinal); 
/*
		//(Parsear) Analizamos la cadenas de fechas e interpretamos 
		// su estructura dd/mm/yyyy.
 		SimpleDateFormat parseamos = new SimpleDateFormat("dd/MM/yyyy");

 		// Aqui le damos formato o transformamos en: yyyy/MM/dd para la consulta 
 		// por fechas y la interprete mysql.
 		SimpleDateFormat formateamos = new SimpleDateFormat("YYYY-MM-dd");
 		
 			Date fechaini = parseamos.parse(fechainicial);
 			fechainicial = formateamos.format(fechaini);	
 			Date fechafin = parseamos.parse(fechafinal);
 			fechafinal = formateamos.format(fechafin);	

 			System.out.println("FECHAS PARSEADAS-----FI-"+fechainicial+" ----FF-"+fechafinal); 
 			
 	 */		
 			//Querys Totales
		totalventas 	= InfoTotalVentas(idempresa,fechainicial,fechafinal);
		ventarealizadas = infoVentasRealizadas(idempresa,fechainicial,fechafinal);
		ventacanceladas = infoVentasCanceladas(idempresa,fechainicial,fechafinal);
		productosvendidos = infoProductosVendidos(idempresa,fechainicial,fechafinal);

		
	      return "success";	  
		
	}


	
	public String   InfoTotalVentas  (String idempresa, String fechainicial, String fechafinal) throws Exception{

		//Llamamos al metodo que nos crea la conexion 
		Conexion con = new Conexion();
        Connection conexion = con.getConexionMYSQL();
        Statement set = null; 
	    ResultSet rs = null;     
	     
	        StringBuffer stQuery1 = new StringBuffer();
	        stQuery1.append(" SELECT sum(v.totalapagar) totalventas FROM puntoventa.tblventas v WHERE v.idempresa= "+ idempresa +
	        				"     AND v.estatusv in ('A','F') AND v.fecventa >= '" + fechainicial + "' AND v.fecventa <= '" + fechafinal + "';");
	        System.out.println("informes: "+stQuery1);       
	        set = conexion.createStatement();  
	        rs = set.executeQuery(stQuery1.toString()); 

		try {
			
		
			while ( rs.next())  
			{
	
				totalventas = (Util.getValueWithoutNulls(rs.getString("totalventas")!=null?rs.getString("totalventas"):"0"));
			}
			rs.close();
			conexion.close();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			conexion.close();
			
		}
		
		finally{
			try{
			if(conexion!=null)
		    {conexion.close();
			System.out.println("Conexion cerrada informes");}
			}catch (Exception e){
				System.out.println("STENMENT SQL EXECUTE:."+e.getCause()+"-->"+e.getMessage());
			}
		}
		
		
		return totalventas;
	}

	
	public String   infoVentasRealizadas  (String idempresa, String fechainicial, String fechafinal) throws Exception{

		//Llamamos al metodo que nos crea la conexion 
		Conexion con = new Conexion();
        Connection conexion = con.getConexionMYSQL();
        Statement set = null; 
	    ResultSet rs = null;     
	     
	        StringBuffer stQuery1 = new StringBuffer();
	        stQuery1.append(" SELECT count(v.folioventa) ventarealizadas FROM puntoventa.tblventas v WHERE  v.idempresa="+ idempresa + 
	        		 " AND v.estatusv in ('A','F') AND v.fecventa >= '" + fechainicial + "' AND v.fecventa <= '" + fechafinal + "';");
	        System.out.println("informes: "+stQuery1);       
	        set = conexion.createStatement();  
	        rs = set.executeQuery(stQuery1.toString()); 

		try {
			
		
			while ( rs.next())  
			{
	
				ventarealizadas = (Util.getValueWithoutNulls(rs.getString("ventarealizadas")!=null?rs.getString("ventarealizadas"):"0"));

			}
			rs.close();
			conexion.close();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			conexion.close();
			
		}
		
		finally{
			try{
			if(conexion!=null)
		    {conexion.close();
			System.out.println("Conexion cerrada informes");}
			}catch (Exception e){
				System.out.println("STENMENT SQL EXECUTE:."+e.getMessage());
			}
		}
		
		
		return ventarealizadas;
	}

	
	public String   infoVentasCanceladas  (String idempresa, String fechainicial, String fechafinal) throws Exception{

		//Llamamos al metodo que nos crea la conexion 
		Conexion con = new Conexion();
        Connection conexion = con.getConexionMYSQL();
        Statement set = null; 
	    ResultSet rs = null;     
	     
	        StringBuffer stQuery1 = new StringBuffer();
	        stQuery1.append(" SELECT count(v.folioventa) ventacanceladas " + 
	        				"  FROM puntoventa.tblventas v WHERE v.idempresa= " + idempresa + " AND  v.estatusv = 'C' " +
	        				"  AND v.fecventa >= '" + fechainicial + "' AND v.fecventa <= '" + fechafinal + "';");
	        System.out.println("informes: "+stQuery1);       
	        set = conexion.createStatement();  
	        rs = set.executeQuery(stQuery1.toString()); 

		try {
			
		
			while ( rs.next())  
			{
	
				ventacanceladas = (Util.getValueWithoutNulls(rs.getString("ventacanceladas")!=null?rs.getString("ventacanceladas"):"0"));

			}
			rs.close();
			conexion.close();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			conexion.close();
			
		}
		
		finally{
			try{
			if(conexion!=null)
		    {conexion.close();
			System.out.println("Conexion cerrada informes");}
			}catch (Exception e){
				System.out.println("STENMENT SQL EXECUTE:."+e.getCause()+"-->"+e.getMessage());
			}
		}
		
		
		return ventacanceladas;
	}		
	
	
	public String   infoProductosVendidos  (String idempresa, String fechainicial, String fechafinal) throws Exception{

		//Llamamos al metodo que nos crea la conexion 
		Conexion con = new Conexion();
        Connection conexion = con.getConexionMYSQL();
        Statement set = null; 
	    ResultSet rs = null;     
	     
	        StringBuffer stQuery1 = new StringBuffer();
	        stQuery1.append(" SELECT sum(dt.cantidad) productosvendidos FROM puntoventa.tbldetalleventa dt " + 
	        " INNER JOIN puntoventa.tblventas v  ON dt.folioventa = v.folioventa WHERE v.idempresa= " + idempresa 
	        + " AND v.estatusv in ('A','F')  AND v.fecventa >= '" + fechainicial + "' AND v.fecventa <= '" + fechafinal + "';");
	        System.out.println("informes: "+stQuery1);       
	        set = conexion.createStatement();  
	        rs = set.executeQuery(stQuery1.toString()); 

		try {
			
		
			while ( rs.next())  
			{
	
				productosvendidos = (Util.getValueWithoutNulls(rs.getString("productosvendidos")!=null?rs.getString("productosvendidos"):"0"));


			}
			rs.close();
			conexion.close();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			conexion.close();
			
		}
		
		finally{
			try{
			if(conexion!=null)
		    {conexion.close();
			System.out.println("Conexion cerrada informes");}
			}catch (Exception e){
				System.out.println("STENMENT SQL EXECUTE:.-->"+e.getMessage());
			}
		}
		
		
		return productosvendidos;
	}
	
	
	
	
	
	
	
	public String getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}


	public String getTotalventas() {
		return totalventas;
	}



	public void setTotalventas(String totalventas) {
		this.totalventas = totalventas;
	}



	public String getVentarealizadas() {
		return ventarealizadas;
	}



	public void setVentarealizadas(String ventarealizadas) {
		this.ventarealizadas = ventarealizadas;
	}



	public String getVentacanceladas() {
		return ventacanceladas;
	}



	public void setVentacanceladas(String ventacanceladas) {
		this.ventacanceladas = ventacanceladas;
	}



	public String getProductosvendidos() {
		return productosvendidos;
	}



	public void setProductosvendidos(String productosvendidos) {
		this.productosvendidos = productosvendidos;
	}

	public String getFechainicial() {
		return fechainicial;
	}



	public void setFechainicial(String fechainicial) {
		this.fechainicial = fechainicial;
	}



	public String getFechafinal() {
		return fechafinal;
	}



	public void setFechafinal(String fechafinal) {
		this.fechafinal = fechafinal;
	}


	
	
	

}

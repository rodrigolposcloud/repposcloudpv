package conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


import conexion.Conexion;


/*
Sistema POS Cloud
Desarrollado por RODRIGOVL Technologies
con Arquitectura asistida por IA
© 2026 Todos los derechos reservados
	 */


public class EjecutaSQLAction {


	
		 public String EjecutaSQL(String Query )throws Exception{			
			
			 String exito="";
			 Conexion con = new Conexion();
		        //Llamamos al metodo que nos crea la conexion 
		        Connection conexion = null; 
		        Statement set = null; 
			  
		        try {
					conexion = con.getConexionMYSQL();  
					//conexion.getAutoCommit();
		
				 StringBuffer stQuery = new StringBuffer();
			     stQuery.append(Query);
			     System.out.println("STENMENT SQL EXECUTE:."+stQuery);
			   
			     set = conexion.createStatement();  
			     set.execute(stQuery.toString()); 
			    // conexion.commit(); 
			     
			     set.close();
			     conexion.close();	
	    
	  } catch (SQLException e) {
			System.err.println(e.getMessage());
			if (conexion != null) conexion.rollback();
		    throw e;
			//set.close();
			//conexion.close();
		}
		
		finally{
			try{
			if(conexion!=null)
		    {
			set.close();
			conexion.close();
			//con.closeConnection();
			System.out.println("Coneccion Cerrada");
			}
			}catch (Exception e){
				set.close();
				conexion.close();
			//	con.closeConnection();
			//	System.out.println("[Error SQL]"+"--->"+e.getCause()+"-->"+e.getMessage());
			}
		}
			return exito;
		}
	
	
}

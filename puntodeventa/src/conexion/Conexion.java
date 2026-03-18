package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Elaborado por RodrigolazoIA...

/*
Sistema POS Cloud
Desarrollado por RODRIGOVL Technologies
con Arquitectura asistida por IA
© 2026 Todos los derechos reservados
	 */

public class Conexion {
	
	

//Datos para conectarnos a la BD  MySQL RVL
    
    //Usuario de la BD
    private String usuario = Properties.getUsername();
    //Contraseña si tiene, si no tiene entonces dejar en blanco
    private String pass = Properties.getPassword();
    //Servidor (localhost si lo tenemos local) o puede ser un servidor remoto
    private String host = Properties.getUrl();
    //Nombre de la base de datos a la cual queremos conectarnos
    private String driver =Properties.getDriver();
 
    //Objeto del tipo conexion lo delcaramos nulo
    private Connection con = null;
 
    
   
    
    //Metodo que realiza la conexion a la BD
    //Devuelve null si no se pudo realizar la conexion
    //Devuelve la conexion en caso de exito
    public Connection getConexionMYSQL(){
        try{
           Class.forName(driver).newInstance( );
            String servidor = host;
            con = DriverManager.getConnection(servidor,usuario,pass);
            return con;
        }catch(Exception e){
            e.printStackTrace();
            try {
				con.close();
			} catch (SQLException e1) {
			
				e1.printStackTrace();
			}
            return con;
            
        }
    }
	
}

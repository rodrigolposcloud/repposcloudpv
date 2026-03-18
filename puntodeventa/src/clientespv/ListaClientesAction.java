package clientespv;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import com.opensymphony.xwork2.ActionSupport;

import conexion.Conexion;
import conexion.Util;
import estructurapv.Clientes;

public class ListaClientesAction extends ActionSupport {

	private static final long serialVersionUID = 1L;


	private List<Clientes> listaclientes;
	private String idempresa;
	private String idusuario;
	
	String existe="";
	
	
	public String execute() throws Exception{
		
		  
		listaclientes = new ArrayList<Clientes>();
		  
	       //llena la lista de productos
		  System.out.println("Llamo metodo lista de productos..");
		  listaclientes=getListaClientes(idempresa);
	       System.out.println("Lista de productos desplegada");
	       return "success";	  
	       
		
	}

	public List<Clientes> getListaclientes() {
		return listaclientes;
	}

	public void setListaclientes(List<Clientes> listaclientes) {
		this.listaclientes = listaclientes;
	}
	
	
	
	public static  List<Clientes>  getListaClientes(String idempresa) throws Exception{

		List<Clientes> listaclientes ;
		
		Clientes clies;
		listaclientes = new ArrayList<Clientes>();
		Conexion con = new Conexion();
        //Llamamos al metodo que nos crea la conexion 
        Connection conexion = con.getConexionMYSQL();
        Statement set = null; 
	    ResultSet rs = null;     
	     
	        StringBuffer stQuery1 = new StringBuffer();
	        stQuery1.append(" SELECT * FROM puntoventa.tblcliente WHERE idempresa = " + idempresa + " ORDER BY IDCLIENTE DESC;");
	        System.out.println("Query listaclientes: "+stQuery1);       
	        set = conexion.createStatement();  
	        rs = set.executeQuery(stQuery1.toString()); 

		try {
			
		
			while ( rs.next())  
			{
	
				clies=new Clientes();
				
				clies.setIdcliente(Util.getValueWithoutNulls(rs.getString("idcliente")));
				clies.setIdempresa(Util.getValueWithoutNulls(rs.getString("idempresa")));
				clies.setCodebarcliente(Util.getValueWithoutNulls(rs.getString("codebarcliente")));
				clies.setNomcliente(Util.getValueWithoutNulls(rs.getString("nomcliente")));
				clies.setRazonsocialc(Util.getValueWithoutNulls(rs.getString("razonsocialc")));
				clies.setRfcclie(Util.getValueWithoutNulls(rs.getString("rfcclie")));
				clies.setTelefonoc(Util.getValueWithoutNulls(rs.getString("telefonoc")));
				clies.setDomicilioc(Util.getValueWithoutNulls(rs.getString("domicilioc")));
				clies.setFechacreacionc(Util.getValueWithoutNulls(rs.getString("fechacreacionc")));

			
				listaclientes.add(clies);
				
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
			System.out.println("Coneccion Cerrada Lista Clientes");}
			}catch (Exception e){
				System.out.println("[Error SQL]"+"--->"+e.getCause()+"-->"+e.getMessage());
			}
		}
		
		
		return listaclientes;
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




	

}

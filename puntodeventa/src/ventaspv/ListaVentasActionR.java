package ventaspv;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import com.opensymphony.xwork2.ActionSupport;

import conexion.Conexion;
import conexion.Util;
import estructurapv.Ventas;

/*
Sistema POS Cloud
Desarrollado por RODRIGOVL Technologies
con Arquitectura asistida por IA
© 2026 Todos los derechos reservados
	 */
public class ListaVentasActionR extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<Ventas> listaventas;
	private String idempresa;
	private String idusuario;
	
	String existe="";
	
	
	public String execute() throws Exception{
	  
		  listaventas = new ArrayList<Ventas>();
		  
	       //llena la lista ventas del Dia a Dia
		  System.out.println("Llamo metodo ventas del Dia a Dia..");
		  listaventas=getListaVentas(idempresa);
		  
	       System.out.println("Lista de ventas del Dia a Dia.. desplegada");
	       return "success";	  
	       
		
	}

	
	public static  List<Ventas>  getListaVentas(String idempresa) throws Exception{

		List<Ventas> listaventas ;
		
		Ventas vtas;
		listaventas = new ArrayList<Ventas>();
		Conexion con = new Conexion();
        //Llamamos al metodo que nos crea la conexion 
        Connection conexion = con.getConexionMYSQL();
        Statement set = null; 
	    ResultSet rs = null;     
	     
	        StringBuffer stQuery1 = new StringBuffer();
	        stQuery1.append(" SELECT v.idventa,v.folioventa,v.total,v.descuento," + 
	        		" v.totalapagar,v.pagoefectivo,v.cambio,v.fecventa,v.estatusv," + 
	        		" v.feccancelacion,v.motivocancelacion,v.idempresa,c.nomcliente  " +
	        		"	FROM puntoventa.tblventas v inner join puntoventa.tblcliente c " + 
	        		"  ON v.idcliente = c.idcliente WHERE v.idempresa = "+ idempresa + " ORDER BY V.IDVENTA DESC;");
	        System.out.println("Query listaventas: "+stQuery1);       
	        set = conexion.createStatement();  
	        rs = set.executeQuery(stQuery1.toString()); 

		try {
			
		
			while ( rs.next())  
			{
	
				vtas=new Ventas();

				vtas.setIdventa(Util.getValueWithoutNulls(rs.getString("idventa")));
				vtas.setFolioventa(Util.getValueWithoutNulls(rs.getString("folioventa")));
				vtas.setTotal(Util.getValueWithoutNulls(rs.getString("total")));
				vtas.setDescuento(Util.getValueWithoutNulls(rs.getString("descuento")));
				vtas.setTotalapagar(Util.getValueWithoutNulls(rs.getString("totalapagar")));
				vtas.setPagoefectivo(Util.getValueWithoutNulls(rs.getString("pagoefectivo")));
				vtas.setCambio(Util.getValueWithoutNulls(rs.getString("cambio")));
				vtas.setFecventa(Util.getValueWithoutNulls(rs.getString("fecventa")));
				vtas.setEstatusv(Util.getValueWithoutNulls(rs.getString("estatusv")));
				vtas.setFeccancelacion(Util.getValueWithoutNulls(rs.getString("feccancelacion")));
				vtas.setMotivocancelacion(Util.getValueWithoutNulls(rs.getString("motivocancelacion")));
				vtas.setIdempresa(Util.getValueWithoutNulls(rs.getString("idempresa")));
				vtas.setNomcliente(Util.getValueWithoutNulls(rs.getString("nomcliente")));
				
				listaventas.add(vtas);
				
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
			System.out.println("Coneccion Cerrada lista ventas del Dia a Dia..");}
			}catch (Exception e){
				System.out.println("[Error SQL]"+"--->"+e.getCause()+"-->"+e.getMessage());
			}
		}
		
		
		return listaventas;
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


	public List<Ventas> getListaventas() {
		return listaventas;
	}

	public void setListaventas(List<Ventas> listaventas) {
		this.listaventas = listaventas;
	}

	

}

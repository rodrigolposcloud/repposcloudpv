package ventaspv;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import com.opensymphony.xwork2.ActionSupport;

import conexion.Conexion;
import conexion.Util;
import estructurapv.Productos;
import estructurapv.Clientes;


/*
Sistema POS Cloud
Desarrollado por RODRIGOVL Technologies
con Arquitectura asistida por IA
© 2026 Todos los derechos reservados
	 */
public class ListCatalogosVentas extends ActionSupport {

	private static final long serialVersionUID = 1L;


	private String idempresa;
	private List<Productos> listaproductosv;	
	private List<Clientes> listaclientesv;

	String existe="";
	
	
	public String execute() throws Exception{
		
		  
		  listaproductosv = new ArrayList<Productos>();
		  listaclientesv = new ArrayList<Clientes>();
		  
	       //llena la lista de productos y clientes para ventas
		  System.out.println("llena la lista de productos y clientes para ventas");
		  listaproductosv=getListaProductosV(idempresa);
		  listaclientesv=getListaClientesV(idempresa);
	       
	       return "success";	  
	       
		
	}



	
	
	
	public static  List<Productos>  getListaProductosV(String idempresa) throws Exception{

		List<Productos> listaproductosv ;
		
		Productos produs;
		listaproductosv = new ArrayList<Productos>();
		Conexion con = new Conexion();
        //Llamamos al metodo que nos crea la conexion 
        Connection conexion = con.getConexionMYSQL();
        Statement set = null; 
	    ResultSet rs = null;     
	     
	        StringBuffer stQuery1 = new StringBuffer();
	        stQuery1.append(" SELECT * FROM puntoventa.tblproductos WHERE idempresa =" + idempresa + " ORDER BY IDPRODUCTO DESC;");
	        System.out.println("Query listaproductos: "+stQuery1);       
	        set = conexion.createStatement();  
	        rs = set.executeQuery(stQuery1.toString()); 

		try {
			
		
			while ( rs.next())  
			{
	
				produs=new Productos();

				produs.setIdproducto(Util.getValueWithoutNulls(rs.getString("idproducto")));
				produs.setIdempresa(Util.getValueWithoutNulls(rs.getString("idempresa")));
				produs.setIdusuario(Util.getValueWithoutNulls(rs.getString("idusuario")));
				produs.setCodigobarrasp(Util.getValueWithoutNulls(rs.getString("codigobarrasp")));
				produs.setProducto(Util.getValueWithoutNulls(rs.getString("producto")));
				produs.setPreciocompra(Util.getValueWithoutNulls(rs.getString("preciocompra")));
				produs.setImpuesto(Util.getValueWithoutNulls(rs.getString("impuesto")));
				produs.setPrecioventa(Util.getValueWithoutNulls(rs.getString("precioventa")));
				produs.setCategoria(Util.getValueWithoutNulls(rs.getString("categoria")));
				produs.setStock(Util.getValueWithoutNulls(rs.getString("stock")));
			
				listaproductosv.add(produs);
				
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
			System.out.println("Coneccion Cerrada Lista ProductosV");}
			}catch (Exception e){
				System.out.println("[Error SQL]"+"--->"+e.getCause()+"-->"+e.getMessage());
			}
		}
		
		
		return listaproductosv;
	}

	public static  List<Clientes>  getListaClientesV(String idempresa) throws Exception{

		List<Clientes> listaclientesv ;
		
		Clientes clien;
		listaclientesv = new ArrayList<Clientes>();
		Conexion con = new Conexion();
        //Llamamos al metodo que nos crea la conexion 
        Connection conexion = con.getConexionMYSQL();
        Statement set = null; 
	    ResultSet rs = null;     
	     
	        StringBuffer stQuery1 = new StringBuffer();
	        stQuery1.append(" SELECT * FROM puntoventa.tblcliente WHERE idempresa = " + idempresa + " ORDER BY IDCLIENTE DESC;");
	        System.out.println("Query listaclientesv: "+stQuery1);       
	        set = conexion.createStatement();  
	        rs = set.executeQuery(stQuery1.toString()); 

		try {
			
		
			while ( rs.next())  
			{
	
				clien=new Clientes();

				clien.setIdcliente(Util.getValueWithoutNulls(rs.getString("idcliente")));
				clien.setIdempresa(Util.getValueWithoutNulls(rs.getString("idempresa")));
				clien.setCodebarcliente(Util.getValueWithoutNulls(rs.getString("codebarcliente")));
				clien.setNomcliente(Util.getValueWithoutNulls(rs.getString("nomcliente")));
				clien.setRazonsocialc(Util.getValueWithoutNulls(rs.getString("razonsocialc")));
				clien.setTelefonoc(Util.getValueWithoutNulls(rs.getString("telefonoc")));
				clien.setDomicilioc(Util.getValueWithoutNulls(rs.getString("domicilioc")));
				clien.setRfcclie(Util.getValueWithoutNulls(rs.getString("rfcclie")));
				clien.setFechacreacionc(Util.getValueWithoutNulls(rs.getString("fechacreacionc")));
				
				listaclientesv.add(clien);
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
			System.out.println("Coneccion Cerrada ListaClientesV");}
			}catch (Exception e){
				System.out.println("[Error SQL]"+"--->"+e.getCause()+"-->"+e.getMessage());
			}
		}
		
		
		return listaclientesv;
	}


	public List<Clientes> getListaclientesv() {
		return listaclientesv;
	}

	public void setListaclientesv(List<Clientes> listaclientesv) {
		this.listaclientesv = listaclientesv;
	}

	public List<Productos> getListaproductosv() {
		return listaproductosv;
	}

	public void setListaproductosv(List<Productos> listaproductosv) {
		this.listaproductosv = listaproductosv;
	}


	public String getIdempresa() {
		return idempresa;
	}






	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

}

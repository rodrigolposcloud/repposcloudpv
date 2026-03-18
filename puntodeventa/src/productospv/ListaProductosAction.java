package productospv;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import com.opensymphony.xwork2.ActionSupport;

import conexion.Conexion;
import conexion.Util;
import estructurapv.Productos;

public class ListaProductosAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<Productos> listaproductos;
	private String idempresa;
	private String idusuario;
	
	String existe="";
	
	
	public String execute() throws Exception{
		
		  
		  listaproductos = new ArrayList<Productos>();
		  
	       //llena la lista de productos
		  System.out.println("Llamo metodo lista de productos..");
		  listaproductos=getListaProductos(idempresa);
	       System.out.println("Lista de productos desplegada");
	       return "success";	  
	       
		
	}

	public List<Productos> getListaproductos() {
		return listaproductos;
	}

	public void setListaproductos(List<Productos> listaproductos) {
		this.listaproductos = listaproductos;
	}

	
	
	
	public static  List<Productos>  getListaProductos(String idempresa) throws Exception{

		List<Productos> listaproductos ;
		
		Productos produs;
		listaproductos = new ArrayList<Productos>();
		Conexion con = new Conexion();
        //Llamamos al metodo que nos crea la conexion 
        Connection conexion = con.getConexionMYSQL();
        Statement set = null; 
	    ResultSet rs = null;     
	     
	        StringBuffer stQuery1 = new StringBuffer();
	        stQuery1.append(" SELECT * FROM puntoventa.tblproductos WHERE idempresa = " + idempresa + " ORDER BY IDPRODUCTO DESC;");
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
			
				listaproductos.add(produs);
				
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
			System.out.println("Coneccion Cerrada Lista Productos");}
			}catch (Exception e){
				System.out.println("[Error SQL]"+"--->"+e.getCause()+"-->"+e.getMessage());
			}
		}
		
		
		return listaproductos;
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

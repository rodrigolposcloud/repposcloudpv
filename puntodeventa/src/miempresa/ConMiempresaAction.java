package miempresa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.opensymphony.xwork2.ActionSupport;

import conexion.Conexion;
import conexion.Util;


public class ConMiempresaAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String idempresa;
	private String nomempresa;
	private String razonsocial;
	private String telefono;
	private String rfc;
	private String domicilio; 
	private String estatus;
	private String fechacreacion;
	private String correo;
	private String numero;
	private String colonia;
	private String ciudad;
	private String estado;
	private String codpostal;
	

	
	
	public String execute() throws Exception{
		
		  
		  //Datos de mi Empresa
		  idempresa = ConsultaMiEmpresa (idempresa);
	      return "success";	  
		
	}


	
	public String   ConsultaMiEmpresa  (String idempresa) throws Exception{

		//Llamamos al metodo que nos crea la conexion 
		Conexion con = new Conexion();
        Connection conexion = con.getConexionMYSQL();
        Statement set = null; 
	    ResultSet rs = null;     
	     
	        StringBuffer stQuery1 = new StringBuffer();
	        stQuery1.append(" SELECT * FROM puntoventa.tblempresa WHERE IDEMPRESA = " + idempresa);
	        System.out.println("Traigo Datos Miempresa: "+stQuery1);       
	        set = conexion.createStatement();  
	        rs = set.executeQuery(stQuery1.toString()); 

		try {
			
		
			while ( rs.next())  
			{
	
				//idempresa = Util.getValueWithoutNulls(rs.getString("idempresa"));
				nomempresa = Util.getValueWithoutNulls(rs.getString("nomempresa"));
				razonsocial = Util.getValueWithoutNulls(rs.getString("razonsocial"));
				telefono = Util.getValueWithoutNulls(rs.getString("telefono"));
				rfc = Util.getValueWithoutNulls(rs.getString("rfc"));
				domicilio = Util.getValueWithoutNulls(rs.getString("domicilio"));
				estatus = Util.getValueWithoutNulls(rs.getString("estatus"));
				fechacreacion = Util.getValueWithoutNulls(rs.getString("fechacreacion"));
				correo = Util.getValueWithoutNulls(rs.getString("correo"));
				numero = Util.getValueWithoutNulls(rs.getString("numero"));
				colonia = Util.getValueWithoutNulls(rs.getString("colonia"));
				ciudad = Util.getValueWithoutNulls(rs.getString("ciudad"));
				estado = Util.getValueWithoutNulls(rs.getString("estado"));
				codpostal = Util.getValueWithoutNulls(rs.getString("codpostal"));
				
				
	
				
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
			System.out.println("Conexion cerrada miempresa");}
			}catch (Exception e){
				System.out.println("[Error SQL]"+"--->"+e.getCause()+"-->"+e.getMessage());
			}
		}
		
		
		return idempresa;
	}

	public String getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getNomempresa() {
		return nomempresa;
	}



	public void setNomempresa(String nomempresa) {
		this.nomempresa = nomempresa;
	}



	public String getRazonsocial() {
		return razonsocial;
	}



	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getRfc() {
		return rfc;
	}



	public void setRfc(String rfc) {
		this.rfc = rfc;
	}



	public String getDomicilio() {
		return domicilio;
	}



	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}



	public String getEstatus() {
		return estatus;
	}



	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}



	public String getFechacreacion() {
		return fechacreacion;
	}



	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getColonia() {
		return colonia;
	}



	public void setColonia(String colonia) {
		this.colonia = colonia;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getCodpostal() {
		return codpostal;
	}



	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}



	

}

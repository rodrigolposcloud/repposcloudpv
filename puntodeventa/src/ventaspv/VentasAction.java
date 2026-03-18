package ventaspv;

// ---com.google.gson.Gson --- ** Biblioteca Java desarrollada por Google 
// utilizada para convertir (serializar) objetos Java en formato JSON 
// y viceversa (deserializar JSON a objetos Java). 
// Facilita el manejo de datos JSON en aplicaciones, 
// siendo muy usada en APIs, Web Services y desarrollo Android 
// para intercambiar información. 
// action core principal desarrollado por IARodrigo


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import conexion.Conexion;
import conexion.EjecutaSQLAction;
import conexion.Util;
import estructurapv.DetalleVenta;
import servicepv.TicketPDFService;


/*
Sistema POS Cloud
Desarrollado por RODRIGOVL Technologies
con Arquitectura asistida por IA
© 2026 Todos los derechos reservados
	 */

public class VentasAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
//Campos de la venta
	private String idventa;
	private String idempresa;
	private String idcliente;
	private String idusuario;
	private String total;
	private String descuento;
	private String totalapagar;
	private String pagoefectivo;
	private String cambio;
	private String fecventa;
	private String folioventa;
	private String opcion="1";
	
//Campos de la cancelacion
	private String feccancelacion;
	private String motivocancelacion;

//Campos del Detatlle de la venta 

	private String detalleVenta;
	private List<DetalleVenta> listaDetalle;

	private String iddetventa;
	private String idproducto;
	private String codigoprod;
	private String producto;
	private String precio;
	private String cantidad;
	private String subtotal;

// campos de la empresa
	private String nomempresa;
	private String razonsocial;
	private String telefono;
	private String rfc;
	private String domicilio;
	private String numero;
	private String colonia;
	private String ciudad;
	private String estado;
	private String codpostal;
	private String correo;
	

	String existe="";
	String sqlQuery="";	
	// rutas del tiket digital
	String urlpdf = "C:/puntoventa/tickets/2026/02/";
	//String urlQR = "http://localhost:8080/puntodeventa/ticket/";
	String urlQR = "https://verificacfdi.facturaelectronica.sat.gob.mx/";

	
	public String execute() throws Exception{
	      //Clase que ejecuta los querys
	      EjecutaSQLAction sqleje = new EjecutaSQLAction();
	      TicketPDFService tiket = new TicketPDFService();
	      //Deserialización: Convierte cadenas JSON en objetos Java 
	      // equivalentes usando fromJson().
	      Gson gson = new Gson();
	      listaDetalle = gson.fromJson(
	          detalleVenta,new TypeToken<List<DetalleVenta>>(){}.getType());

	      //******Proceso de Venta ******
	      
	      // Obtener Datos de la empresa para tiket de venta
	      // y facturacion electronica
	      		idempresa = ObtenerDtsEmpresa(idempresa);
	      		nomempresa = (getNomempresa()!=null?getNomempresa():"0");
	      		razonsocial = (getRazonsocial()!=null?getRazonsocial():"0");
	      		telefono = 	(getTelefono()!=null?getTelefono():"0");
	      		rfc = (getRfc()!=null?getRfc():"0");
	      		domicilio = (getDomicilio()!=null?getDomicilio():"0");
	      		correo = (getCorreo()!=null?getCorreo():"0");
	      		numero = (getNumero()!=null?getNumero():"0");
	      		colonia = (getColonia()!=null?getColonia():"0");
	      		ciudad = (getCiudad()!=null?getCiudad():"0");
	      		estado = (getEstado()!=null?getEstado():"0");
	      		codpostal = (getCodpostal()!=null?getCodpostal():"0");
	      		
	      
	    //Obtengo Folio de venta for update
	      folioventa = ObtenerFolioVenta(idempresa);
	    //Inserto la Venta
	      sqlQuery= "INSERT INTO PUNTOVENTA.TBLVENTAS (idventa,idempresa,idcliente,idusuario," + 
	      						"total,descuento,totalapagar,pagoefectivo,cambio,fecventa,folioventa,estatusv,feccancelacion,motivocancelacion) " + 
	    		  	" VALUES (0,"+ idempresa +","+idcliente+","+idusuario+","+total+","+ descuento+"," +
	    		    " " + totalapagar +","+ pagoefectivo+","+ cambio+ ",NOW(),'"+ folioventa+"','A',null,null)" ;
		      existe= sqleje.EjecutaSQL (sqlQuery);

		    //Inserto el Detalle de venta
		      System.out.println("DETALLE JSON: " + detalleVenta);
		      //Se utiliza y recorre JSON cadena detalleventa a objeto  java DetalleVenta 
		      for (DetalleVenta d : listaDetalle) {
		    	    sqlQuery =
		    	      "INSERT INTO PUNTOVENTA.TBLDETALLEVENTA " +
		    	      "(iddetventa,codigoprod,producto,precio,cantidad,subtotal,folioventa) VALUES (" +
		    	      "0,'" + d.getCodigoprod() + "','" + d.getProducto() + "'," +
		    	      d.getPrecio() + "," + d.getCantidad() + "," +
		    	      d.getSubtotal() + ",'" + folioventa + "')";
		    	    sqleje.EjecutaSQL(sqlQuery);
		   
		    	}

			      //Actualizo folio venta
			      sqlQuery ="UPDATE PUNTOVENTA.TBLFOLIOSVENTA SET consecutivo = consecutivo + 1 " +
			    		  	" WHERE idempresa = " + idempresa + " ";
			      sqleje.EjecutaSQL(sqlQuery);

			      //Se forman las cadenas de ruta pdf y QR
			      urlpdf = urlpdf + folioventa + ".pdf"; //link web
			     // urlQR = urlQR + folioventa + ".pdf";  //lo que codifica el QR
		      
			      //Guardo informacion del Ticket Digital
			      sqlQuery  ="INSERT INTO PUNTOVENTA.tblticketdigital" +
			    		  	"(idticket, folioventa, totalventa, urlpdf, qrdata , enviado, fechaemision)" +
			    		  " VALUES (0,'" +folioventa+ "'," + totalapagar + ",'"+ urlpdf + "','" + urlQR + "',1,NOW())";
			      sqleje.EjecutaSQL(sqlQuery);

			      
			      //Genero tiket de venta Y/O QR para facturar
			      tiket.generarPDFVenta(nomempresa,razonsocial,telefono,rfc,correo,
			    		  domicilio,numero,colonia,ciudad,estado,codpostal, 
			    		  totalapagar, folioventa, fecventa,  urlpdf, urlQR ,listaDetalle);
			      
	    	   System.out.println("venta exitosa Y visualiza tiket de venta");
	    	   return "verTicket";  

		
	}


	
	public String ObtenerFolioVenta(String idempresa) throws Exception {
		Conexion con = new Conexion();
       //Llamamos al metodo que nos crea la conexion 
       Connection conexion = con.getConexionMYSQL();
       Statement set = null; 
	    ResultSet rs = null;     

	    StringBuffer comp = new StringBuffer();
			comp.append(" SELECT  CONCAT(nomenclatura ,DATE_FORMAT(NOW(), '%y%m%d'), consecutivo) AS  folioventa ");
			comp.append(" FROM puntoventa.tblfoliosventa WHERE idempresa = " + idempresa + " FOR UPDATE");
				set = conexion.createStatement();  
				rs = set.executeQuery(comp.toString()); 
				
				System.out.println("SQL Obtengo folioventa***"+comp);
				
	try {
		//
	
		if ( rs.next())  
		{
			
			folioventa=(Util.getValueWithoutNulls(rs.getString("folioventa")!=null?rs.getString("folioventa"):"0"));
			System.out.println("FolioVentaObtenido..."+folioventa);
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
		conexion.close();
	}
	    	finally{
				try{
				if(conexion!=null)
			    {
					conexion.close();
					rs.close();
					set.close();
				System.out.println("Cerrando conexion...FolioVentaObtenido.");}
				}catch (Exception e){
					System.out.println("Hubo un inconveniente al cerrar la conexión...");
				}
			}
	  

	        return folioventa; 
	   }
	
	public String ObtenerDtsEmpresa(String idempresa) throws Exception {
		Conexion con = new Conexion();
       //Llamamos al metodo que nos crea la conexion 
       Connection conexion = con.getConexionMYSQL();
       Statement set = null; 
	    ResultSet rs = null;     

	    StringBuffer comp = new StringBuffer();
			comp.append(" SELECT * FROM puntoventa.tblempresa ");
			comp.append(" WHERE idempresa = " + idempresa);
				set = conexion.createStatement();  
				rs = set.executeQuery(comp.toString()); 
				
				System.out.println("ObtenerDtsEmpresa***"+comp);
				
	try {
		//
	
		if ( rs.next())  
		{
			
			nomempresa=(Util.getValueWithoutNulls(rs.getString("nomempresa")!=null?rs.getString("nomempresa"):"0"));
			razonsocial=(Util.getValueWithoutNulls(rs.getString("razonsocial")!=null?rs.getString("razonsocial"):"0"));
			telefono=(Util.getValueWithoutNulls(rs.getString("telefono")!=null?rs.getString("telefono"):"0"));
			rfc=(Util.getValueWithoutNulls(rs.getString("rfc")!=null?rs.getString("rfc"):"0"));
			domicilio=(Util.getValueWithoutNulls(rs.getString("domicilio")!=null?rs.getString("domicilio"):"0"));
			correo=(Util.getValueWithoutNulls(rs.getString("correo")!=null?rs.getString("correo"):"0"));
			numero=(Util.getValueWithoutNulls(rs.getString("numero")!=null?rs.getString("numero"):"0"));
			colonia=(Util.getValueWithoutNulls(rs.getString("colonia")!=null?rs.getString("colonia"):"0"));
			ciudad=(Util.getValueWithoutNulls(rs.getString("ciudad")!=null?rs.getString("ciudad"):"0"));
			estado=(Util.getValueWithoutNulls(rs.getString("estado")!=null?rs.getString("estado"):"0"));
			codpostal=(Util.getValueWithoutNulls(rs.getString("codpostal")!=null?rs.getString("codpostal"):"0"));
			
			System.out.println("ObtenerDtsEmpresa..."+nomempresa);
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
		conexion.close();
	}
	    	finally{
				try{
				if(conexion!=null)
			    {
					conexion.close();
					rs.close();
					set.close();
				System.out.println("Cerrando conexion...Obtener Datos Empresa.");}
				}catch (Exception e){
					System.out.println("Hubo un inconveniente al cerrar la conexión...");
				}
			}
	  

	        return idempresa; 
	   }	
	


	

	
	
	public String getIdventa() {
		return idventa;
	}

	public void setIdventa(String idventa) {
		this.idventa = idventa;
	}



	public String getIdempresa() {
		return idempresa;
	}



	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}



	public String getIdcliente() {
		return idcliente;
	}



	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}



	public String getIdusuario() {
		return idusuario;
	}



	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}



	public String getTotal() {
		return total;
	}



	public void setTotal(String total) {
		this.total = total;
	}



	public String getDescuento() {
		return descuento;
	}



	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}



	public String getTotalapagar() {
		return totalapagar;
	}



	public void setTotalapagar(String totalapagar) {
		this.totalapagar = totalapagar;
	}



	public String getPagoefectivo() {
		return pagoefectivo;
	}



	public void setPagoefectivo(String pagoefectivo) {
		this.pagoefectivo = pagoefectivo;
	}



	public String getCambio() {
		return cambio;
	}



	public void setCambio(String cambio) {
		this.cambio = cambio;
	}



	public String getFecventa() {
		return fecventa;
	}



	public void setFecventa(String fecventa) {
		this.fecventa = fecventa;
	}



	public String getFolioventa() {
		return folioventa;
	}



	public void setFolioventa(String folioventa) {
		this.folioventa = folioventa;
	}



	public String getOpcion() {
		return opcion;
	}



	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}


	public String getDetalleVenta() {
		return detalleVenta;
	}


	public void setDetalleVenta(String detalleVenta) {
		this.detalleVenta = detalleVenta;
	}


	public String getIddetventa() {
		return iddetventa;
	}


	public void setIddetventa(String iddetventa) {
		this.iddetventa = iddetventa;
	}


	public String getIdproducto() {
		return idproducto;
	}


	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}


	public String getCodigoprod() {
		return codigoprod;
	}


	public void setCodigoprod(String codigoprod) {
		this.codigoprod = codigoprod;
	}


	public String getProducto() {
		return producto;
	}


	public void setProducto(String producto) {
		this.producto = producto;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


	public String getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}


	   public List<DetalleVenta> getListaDetalle() {
			return listaDetalle;
		}


		public void setListaDetalle(List<DetalleVenta> listaDetalle) {
			this.listaDetalle = listaDetalle;
		}

/********DATOS DE LA EMPRESA*****************/
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

		public String getCorreo() {
			return correo;
		}



		public void setCorreo(String correo) {
			this.correo = correo;
		}



		

		/****datos de la cancelacion**/		
		
		
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





}

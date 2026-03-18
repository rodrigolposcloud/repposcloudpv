package Acceso.Control;

import com.opensymphony.xwork2.ActionSupport;
import Acceso.Dato.LoginDatoAction;


public class LoginAction extends ActionSupport {
    /*Inicio POS Cloud
	 *RodrigoIA
	 */


	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String password;
	private String idusuario;
	private String idempresa;
	private String idrol;
	String existe="";
	
	
	public String execute()   throws Exception{
		  
	       //System.out.println(usuario);
	       //System.out.println(contrasenia);
	       LoginDatoAction ad =new LoginDatoAction();
      
	       existe=ad.validaUsuario(usuario,password);
	       idusuario = ad.getIdusuario();
	       idempresa = ad.getIdempresa();
	       idrol 	 = ad.getIdrol();

	       System.out.println("Existe==Usuario: "+existe);
	       if (idrol == null) {
	    	   System.out.println("usuario y contrasenia: son invalidos");
	    	   return "inicio"; 
	       } else {
	    	   System.out.println("usuario y contrasenia: exitosos..");
	    	   return "success"; 
	       }	       
		
	}



	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

	public String getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}


	public String getIdempresa() {
		return idempresa;
	}


	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}


	public String getIdrol() {
		return idrol;
	}


	public void setIdrol(String idrol) {
		this.idrol = idrol;
	}




}

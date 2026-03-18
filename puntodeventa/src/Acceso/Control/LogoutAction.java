package Acceso.Control;


import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;


import com.opensymphony.xwork2.ActionSupport;



public class LogoutAction extends ActionSupport implements SessionAware{
    /*final POS Cloud
	 *RodrigoIA
	 */
	private static final long serialVersionUID = -8973255488947234635L;
	private Map<String, Object> session;
	

	

	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
	
	@Override
	public String execute() throws Exception{

			 session.remove("idusuario");
			 session.remove("idempresa");
			 session.remove("idrol");
			 session.remove("loguin");
			 session.remove("nombre");
			 session.remove("estatus");
			 session.remove("nomempresa");
			 session.remove("razonsocial");
			 session.remove("rfc");
			 session.remove("nombrerol");
			 session.remove("descripcion"); //descripcion rol
		 
			 return SUCCESS;		
	
		
		
	}


	

}

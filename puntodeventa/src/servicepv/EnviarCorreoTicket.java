package servicepv;

import com.opensymphony.xwork2.ActionSupport;
import servicepv.MailSender;

public class EnviarCorreoTicket extends ActionSupport {
    /*
Sistema POS Cloud
Desarrollado por RODRIGOVL Technologies
con Arquitectura asistida por IA
© 2026 Todos los derechos reservados
	 */


	private static final long serialVersionUID = 1L;
	private String correoCliente; 
    private String folioventa;


    @Override
    public String execute() throws Exception {

        try {

            System.out.println(" ENTRO A ENVIAR CORREO");
           
            String rutaPdf =
                "C:/puntoventa/tickets/2026/02/"
                + folioventa + ".pdf";

            boolean ok = MailSender.enviarTicket(
                    correoCliente,
                    folioventa,
                    rutaPdf);

            if (ok) {
                addActionMessage("Correo enviado correctamente");
                System.out.println(" Correo enviado correctamente");

            } else {
                addActionError("Error al enviar correo");
                System.out.println(" Correo enviado correctamente");

            }

        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Error en el proceso MAIL");
        }

        return "success";
    }	
	
    public String getCorreoCliente() {
		return correoCliente;
	}


	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}


	public String getFolioventa() {
		return folioventa;
	}


	public void setFolioventa(String folioventa) {
		this.folioventa = folioventa;
	}


	

}

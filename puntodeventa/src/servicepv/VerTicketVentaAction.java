package servicepv;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileInputStream;

public class VerTicketVentaAction extends ActionSupport {

	   /*
	Sistema POS Cloud
	Desarrollado por RODRIGOVL Technologies
	con Arquitectura asistida por IA
	© 2026 Todos los derechos reservados
		 */
	private static final long serialVersionUID = 1L;
	private String folioventa;
    private String rutaPdf;

    @Override
    public String execute() throws Exception {
        try {

            //  Construyes la ruta del PDF
        	// solo se preparan datos para visualizar en jsp visor
            // Ajusta a tu lógica real
            rutaPdf = "/descargarTicketPdf?folioventa=" + folioventa;

            return "success";

        } catch (Exception e) {
            e.printStackTrace();
            return "inicio";
        }
    }

    // getters y setters
    public String getFolioventa() { return folioventa; }
    public void setFolioventa(String folioventa) { this.folioventa = folioventa; }

    public String getRutaPdf() { return rutaPdf; }
}
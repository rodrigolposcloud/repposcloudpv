package servicepv;

import java.io.File;
import java.io.FileInputStream;

import com.opensymphony.xwork2.ActionSupport;

public class VerTicketVentaActionR extends ActionSupport {
	   /*
	Sistema POS Cloud
	Desarrollado por RODRIGOVL Technologies
	con Arquitectura asistida por IA
	© 2026 Todos los derechos reservados
		 */
	private static final long serialVersionUID = 1L;
	private String folioventa;
    private FileInputStream inputStream;
    private String fileName;

    public String execute() throws Exception {

        String ruta = "C:/puntoventa/tickets/2026/02/" + folioventa + ".pdf";

        File file = new File(ruta);

        if (!file.exists()) {
            System.out.println("PDF NO EXISTE: " + ruta);
            return "inicio";
        }

        inputStream = new FileInputStream(file);
        fileName = file.getName();

        return "success";
    }

    public FileInputStream getInputStream() {
        return inputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFolioventa(String folioventa) {
        this.folioventa = folioventa;
    }
}
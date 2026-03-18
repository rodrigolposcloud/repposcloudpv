package conexion;

/*Sistema POS Cloud
Desarrollado por RODRIGOVL Technologies
con Arquitectura asistida por IA
© 2026 Todos los derechos reservados
	 */
import java.util.ResourceBundle;
import conexion.Util; 
import conexion.Properties;


public class Path {	
	static ResourceBundle filePropiedades = ResourceBundle.getBundle("global");	
	public static final String stPathImages = getPathImages();
	public static final String stPathReportes = getPathReportes();
	
	public static String getPathImages() {
		String stPath = null;
		
		try {
			String stHostName = Util.getLocalHostName();
			if (stHostName.toLowerCase().startsWith("severprod")) {				
	                stPath = filePropiedades.getString("PathImagesProdu");	                
	            } else if(stHostName.toLowerCase().startsWith("linux")) {	                
	                stPath = filePropiedades.getString("PathImagesDesa");	                
	            } else {	            	
	                stPath = Properties.getPathImagesLocal();	                
	            }                

	        } catch(Exception se) {	      
	        	System.out.println("Exception(Path Imagenes- getPathImages):" + se.getMessage());
	            stPath = filePropiedades.getString("PathImagesLocal");	            
	        }
	        return stPath;
	    }
	
	private static String getPathReportes() {
		String stPath = null;
		
		try {
			String stHostName = Util.getLocalHostName();
			if (stHostName.toLowerCase().startsWith("severprod")) {				
	                stPath = filePropiedades.getString("PathReportesProduc");	                
	            } else if(stHostName.toLowerCase().startsWith("Linux")) {	                
	                stPath = filePropiedades.getString("PathReportesDesa");	                
	            } else {	            	
	            	stPath = Properties.getPathReportesLocal();	                        
	            }                

	        } catch(Exception se) {	      
	        	System.out.println("Exception(Path Reportes - getPathReportes):" + se.getMessage());
	            stPath = filePropiedades.getString("PathReportesLocal");	            
	        }
	        return stPath;
	    }

	public static String getStpathimages() {
		return stPathImages;
	}

	public static String getStpathreportes() {
		return stPathReportes;
	}	
	
	
}

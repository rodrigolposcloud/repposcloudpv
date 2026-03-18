package conexion;

import java.io.IOException;

/*Sistema POS Cloud
Desarrollado por RODRIGOVL Technologies
con Arquitectura asistida por IA
© 2026 Todos los derechos reservados
	 */

public final class Properties {
	
	public static String get(String prop){
		
		java.util.Properties properties = new java.util.Properties();
		
		try {
			properties.load(Properties.class.getResourceAsStream("/global.properties"));
		} catch (IOException e) {
			System.out.println("IOException  (Properties-get):" + e.getMessage());
			e.printStackTrace();
		}	         
	
		return properties.getProperty(prop);  
	}
	
	public static String getAppName(){
		return Properties.get("appName");
	}
	
	public static String getResourse(){
		return Properties.get("resourse");
	}
	
	
	public static String servPath(){
		return Properties.get("serverPath");
	}
	
	public static String getPathImagesLocal() {
		return Properties.get("PathImagesLocal");
	}
	
	public static String getPathImagesDesarrollo() {
		return Properties.get("PathImagesDesa");
	}
	
	public static String getPathImagesProduccion() {
		return Properties.get("PathImagesProduc");
	}
	

	
	public static String getPathReportesLocal() {
		return Properties.get("PathReportesLocal");
	}
	
	public static String getPathReportesDesarrollo() {
		return Properties.get("PathReportesDesa");
	}
	
	public static String getPathReportesProduccion() {
		return Properties.get("PathReportesProdu");
	}
        public static String getUrl(){
		return Properties.get("url");
	}
         public static String getUsername(){
		return Properties.get("username");
	}
	public static String getPassword(){
		return Properties.get("password");
	}
	public static String getDriver(){
		return Properties.get("driver");
	}
        public static String getUrl2(){
		return Properties.get("url2");
	}
        
        public static String getUrl3(){
    		return Properties.get("url3");
    	}    
}

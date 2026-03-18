package servicepv;

//---com.google.gson.Gson --- ** Biblioteca Java desarrollada por Google 
//utilizada para convertir (serializar) objetos Java en formato JSON 
//y viceversa (deserializar JSON a objetos Java). 
//Facilita el manejo de datos JSON en aplicaciones, 
//siendo muy usada en APIs, Web Services y desarrollo Android 
//para intercambiar información. 

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.*;

import estructurapv.DetalleVenta;

/*
Sistema POS Cloud
Desarrollado por RODRIGOVL Technologies
con Arquitectura asistida por IA
© 2026 Todos los derechos reservados
	 */




public class TicketPDFServiceR {
	
	//Campos del Detatlle de la venta 

		private String detalleVenta;
		private List<DetalleVenta> listaDetalle;


 //   public String generarPDFVenta(String totalapagar ,String folioventa, String fechav,
 //   		String urlpdf, String urlQR, List<DetalleVenta> detalles ) throws Exception {
        public String generarPDFVenta(String nomempresa, String razonsocial, String telefono, String rfc, String correo,
        		String domicilio, String numero, String colonia, String ciudad, String estado, String codpostal,
        		String totalapagar ,String folioventa, String fechav,
        		String urlpdf, String urlQR, List<DetalleVenta> detalles ) throws Exception {

    	//Deserialización: Convierte cadenas JSON en objetos Java 
	      // equivalentes usando fromJson().
	      Gson gson = new Gson();
	      listaDetalle = gson.fromJson(
	          detalleVenta,new TypeToken<List<DetalleVenta>>(){}.getType());
	    //ruta  local o test repositorio tickets de venta
        String rutaBase = "C:/puntoventa/tickets/2026/02/";
        //url para generar QR para productivo o test
        String qrData =   urlQR;//"http://localhost:8080/transpersonal/ticket/" + folioventa + ".pdf";

        new File(rutaBase).mkdirs();


        //String nombreArchivo = folioventa + ".pdf";
        //String rutaPDF = rutaBase + nombreArchivo;
        String rutaPDF = urlpdf;
        
        Document document = new Document(new Rectangle(226, 600)); // 80mm
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(rutaPDF));

        document.open();

        Font titulo = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD);
        Font normal = new Font(Font.FontFamily.HELVETICA, 8);
        Font normalb = new Font(Font.FontFamily.HELVETICA, 6);
        Font normaln = new Font(Font.FontFamily.HELVETICA, 6,Font.BOLD);
        
        document.add(new Paragraph(nomempresa, titulo));
        document.add(new Paragraph(razonsocial, titulo));      
        document.add(new Paragraph("RFC: " +rfc + " Telefono: "+telefono, normalb));
        document.add(new Paragraph("Sucursal: "+domicilio, normalb));
        document.add(new Paragraph("----------------------------------"));

       document.add(new Paragraph("FOLIO: " +folioventa, normal));
        document.add(new Paragraph("FECHA: " + fechav, normal));
        document.add(new Paragraph("----------------------------------"));
        document.add(new Paragraph("CANT PRODUCTO SUBTOTAL", normaln));
        
        for (DetalleVenta d : detalles) {
            document.add(new Paragraph(
                d.getCantidad() + "  " +
                d.getProducto() + "  $" +
                d.getSubtotal(),
                normalb
            ));
        }

        document.add(new Paragraph("----------------------------------"));
        document.add(new Paragraph("TOTAL: $" + totalapagar, titulo));
        System.out.println("ruta tiket ====="+rutaPDF);
        document.add(new Paragraph("----------------------------------"));
        document.add(new Paragraph("AUTORIZADO MEDIANTE FIRMA ELECTRONICA",normaln));
        document.add(new Paragraph("NO.TICKET: " + folioventa, normal));
        document.add(new Paragraph("Escanea el QR para Facturar", normal));
        
        //url para generar QR
        //String qrData = "http://localhost:8080/transpersonal/ticket/" + folioventa;
        //Genera QR con URL productivo o test del tiket de venta 
        Image qrImage = generarQR(qrData);
        document.add(qrImage);
        document.close();
        writer.close();
               
        return rutaPDF;
    }
 
    
    
    private Image generarQR(String data) throws Exception {
        BarcodeQRCode qr = new BarcodeQRCode(data, 150, 150, null);
        Image qrImage = qr.getImage();
        qrImage.scaleAbsolute(80, 80);
        qrImage.setAlignment(Image.ALIGN_CENTER);
        return qrImage;
    }

    
    
    
    
    
    
    
    
    
    
    

	public String getDetalleVenta() {
		return detalleVenta;
	}


	public void setDetalleVenta(String detalleVenta) {
		this.detalleVenta = detalleVenta;
	}
    
	   public List<DetalleVenta> getListaDetalle() {
			return listaDetalle;
		}


		public void setListaDetalle(List<DetalleVenta> listaDetalle) {
			this.listaDetalle = listaDetalle;
		}
    
    
    
}

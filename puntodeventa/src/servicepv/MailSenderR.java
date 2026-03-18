package servicepv;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class MailSenderR extends ActionSupport {
	   /*
	Sistema POS Cloud
	Desarrollado por RODRIGOVL Technologies
	con Arquitectura asistida por IA
	© 2026 Todos los derechos reservados
		 */
	private static final long serialVersionUID = 1L;
	//  CONFIGURO AQUÍ MI CORREO
    private static final String USER = "rodrigolrvl100@gmail.com";
    private static final String PASS = "kzlwzwoaxtzazwmt"; //  NO tu password normal

    public static boolean enviarTicket(String correoDestino,
            String folioVenta,String rutaPdf) throws Exception {

        try {

            // =============================
            // CONFIG SMTP GMAIL
            // =============================
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USER, PASS);
                    }
                });

            // =============================
            // MENSAJE
            // =============================
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USER));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(correoDestino));

            message.setSubject("Ticket de Venta - Folio " + folioVenta);

            // =============================
            // CUERPO
            // =============================
            MimeBodyPart textoPart = new MimeBodyPart();
            textoPart.setText(
                    "Gracias por su compra.\n\n" +
                    "Adjuntamos su ticket de venta.\n\n" +
                    "Folio: " + folioVenta);

            // =============================
            // ADJUNTO PDF
            // =============================
            MimeBodyPart adjuntoPart = new MimeBodyPart();
            adjuntoPart.attachFile(new File(rutaPdf));
            adjuntoPart.setFileName("Ticket_" + folioVenta + ".pdf");

            // =============================
            // MULTIPART
            // =============================
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textoPart);
            multipart.addBodyPart(adjuntoPart);

            message.setContent(multipart);

            // =============================
            // ENVÍO
            // =============================
            Transport.send(message);

            System.out.println(" Correo enviado correctamente");
            return true;

        } catch (Exception e) {
            System.out.println(" Error enviando correo");
            e.printStackTrace();
            return false;
        }
    }
}
package conexion;
/*
Sistema POS Cloud
Desarrollado por RODRIGOVL Technologies
con Arquitectura asistida por IA
© 2026 Todos los derechos reservados
	 */
import java.io.*;
import java.security.*;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;



public class Encrypter
{
	String secretKey = "qualityinfosolutions"; //llave para encriptar datos
    String base64EncryptedString = "";
	
	  private static String convertToHex(byte[] data) { 
	        StringBuffer buf = new StringBuffer();
	        for (int i = 0; i < data.length; i++) { 
	            int halfbyte = (data[i] >>> 4) & 0x0F;
	            int two_halfs = 0;
	            do { 
	                if ((0 <= halfbyte) && (halfbyte <= 9)) 
	                    buf.append((char) ('0' + halfbyte));
	                else 
	                    buf.append((char) ('a' + (halfbyte - 10)));
	                halfbyte = data[i] & 0x0F;
	            } while(two_halfs++ < 1);
	        } 
	        return buf.toString().toUpperCase();
	    } 
	 
	/**
	 * 
	 * @param text
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	    public static String convertToMD5(String text) 
	    throws NoSuchAlgorithmException, UnsupportedEncodingException  { 
	        MessageDigest md;
	        md = MessageDigest.getInstance("MD5");
	        byte[] md5hash = new byte[32];
	        md.update(text.toUpperCase().getBytes("iso-8859-1"), 0, text.length());
	        md5hash = md.digest();
	        return convertToHex(md5hash).toUpperCase();
	    } 
	    

	    public static String Desencriptar(String textoEncriptado) throws Exception {
	    	 
	        String secretKey = "qualityinfosolutions"; //llave para encriptar datos
	        String base64EncryptedString = "";
	 
	        try {
	            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
	            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
	            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
	 
	            Cipher decipher = Cipher.getInstance("DESede");
	            decipher.init(Cipher.DECRYPT_MODE, key);
	 
	            byte[] plainText = decipher.doFinal(message);
	 
	            base64EncryptedString = new String(plainText, "UTF-8");
	 
	        } catch (Exception ex) {
	        }
	        return base64EncryptedString;
	    }
	    
	    
}
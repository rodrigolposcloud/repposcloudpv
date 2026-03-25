package Acceso.Dato;
/*Inicio POS Cloud
 *RodrigoIA
 */



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import conexion.Conexion;
import conexion.Util;
import org.mindrot.jbcrypt.BCrypt;

public class LoginDatoAction {

    private String idusuario;
    private String idempresa;
    private String idrol;
    private String nombre;
    private String loguin; 
    private String estatus; 
    private String fechacreacion;
    private String nomempresa;
    private String razonsocial;
    private String rfc; 
    private String nombrerol; 
    private String descripcion; 
    private String acceso;

    public String validaUsuario(String usuario, String password) throws Exception {

        Map<String, Object> session = ActionContext.getContext().getSession();

        Conexion con = new Conexion();
        Connection conexion = con.getConexionMYSQL();

        Statement set = null; 
        ResultSet rs = null;     

        String passwordBD = "";

        StringBuffer comp = new StringBuffer();
        comp.append(" SELECT u.idusuario, u.idempresa, u.idrol, u.nombre, u.loguin, u.password, ");
        comp.append(" u.estatus, u.fechacreacion, e.nomempresa, e.razonsocial, ");
        comp.append(" e.rfc, r.nombrerol, r.descripcion ");
        comp.append(" FROM tblusuario AS u ");
        comp.append(" LEFT JOIN tblempresa AS e ON u.idempresa = e.idempresa ");
        comp.append(" LEFT JOIN tblrol AS r ON u.idrol = r.idrol ");			
        comp.append(" WHERE u.loguin='" + usuario + "' ");  // 🔥 SOLO USUARIO

        set = conexion.createStatement();  
        rs = set.executeQuery(comp.toString()); 

        try {

            if (rs.next()) {

                //  Obtener password encriptado
                passwordBD = rs.getString("password");

                //  VALIDAR PASSWORD CON BCrypt
                if (BCrypt.checkpw(password, passwordBD)) {

                    idusuario = Util.getValueWithoutNulls(rs.getString("idusuario"));
                    idempresa = Util.getValueWithoutNulls(rs.getString("idempresa"));
                    idrol = Util.getValueWithoutNulls(rs.getString("idrol"));
                    nombre = Util.getValueWithoutNulls(rs.getString("nombre"));
                    loguin = Util.getValueWithoutNulls(rs.getString("loguin"));
                    estatus = Util.getValueWithoutNulls(rs.getString("estatus"));
                    fechacreacion = Util.getValueWithoutNulls(rs.getString("fechacreacion"));
                    nomempresa = Util.getValueWithoutNulls(rs.getString("nomempresa"));					
                    razonsocial = Util.getValueWithoutNulls(rs.getString("razonsocial"));
                    rfc = Util.getValueWithoutNulls(rs.getString("rfc"));
                    nombrerol = Util.getValueWithoutNulls(rs.getString("nombrerol"));
                    descripcion = Util.getValueWithoutNulls(rs.getString("descripcion"));

                    // SESSION SOLO SI PASSWORD CORRECTO
                    session.put("idusuario", idusuario);
                    session.put("idempresa", idempresa);					
                    session.put("idrol", idrol);
                    session.put("nombre", nombre);
                    session.put("loguin", loguin);
                    session.put("estatus", estatus);
                    session.put("fechacreacion", fechacreacion);
                    session.put("nomempresa", nomempresa);
                    session.put("razonsocial", razonsocial);
                    session.put("rfc", rfc); 
                    session.put("nombrerol", nombrerol); 
                    session.put("descripcion", descripcion);
                    acceso = "exitoso";
                    System.out.println("LOGIN OK==="+acceso);
                    return acceso; // LOGIN OK
                } else {
                	acceso = "incorrecto";
                	System.out.println("PASSWORD INCORRECTO==="+acceso);
                    return acceso; // PASSWORD INCORRECTO
                }

            } else {
            	acceso = "incorrecto";
            	System.out.println("USUARIO NO EXISTE===="+acceso);
                return acceso; // USUARIO NO EXISTE
            }

        } catch (SQLException e) {

            System.err.println(e.getMessage());
            conexion.close();
            return "inicio";

        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                    rs.close();
                    set.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión...");
            }
        } 
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

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getLoguin() {
			return loguin;
		}

		public void setLoguin(String loguin) {
			this.loguin = loguin;
		}

		public String getEstatus() {
			return estatus;
		}

		public void setEstatus(String estatus) {
			this.estatus = estatus;
		}

		public String getFechacreacion() {
			return fechacreacion;
		}

		public void setFechacreacion(String fechacreacion) {
			this.fechacreacion = fechacreacion;
		}

		public String getNomempresa() {
			return nomempresa;
		}


		public void setNomempresa(String nomempresa) {
			this.nomempresa = nomempresa;
		}

		public String getRazonsocial() {
			return razonsocial;
		}
		public void setRazonsocial(String razonsocial) {
			this.razonsocial = razonsocial;
		}
		public String getRfc() {
			return rfc;
		}

		public void setRfc(String rfc) {
			this.rfc = rfc;
		}

		public String getNombrerol() {
			return nombrerol;
		}

		public void setNombrerol(String nombrerol) {
			this.nombrerol = nombrerol;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
	  
	  
}

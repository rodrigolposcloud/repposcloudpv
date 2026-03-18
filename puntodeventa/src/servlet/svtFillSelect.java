package servlet;

import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class svtFillSelect extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) 
           throws ServletException, IOException{
        
    	
    	       
        String id = req.getParameter("id");
        String qr = req.getParameter("qr");
        Conexion con = new Conexion();
        //Llamamos al metodo que nos crea la conexion 
        Connection conexion = con.getConexionMYSQL();
        Statement set = null; 
	    ResultSet rs = null;  
		StringBuffer stQuery = new StringBuffer();
		
		stQuery.append(qr + "'" + id + "'");
       
        PrintWriter out = res.getWriter();
        String result="";
        try{
        	set = conexion.createStatement();  
	        rs = set.executeQuery(stQuery.toString()); 
        	
            while(rs.next()){
                result += (!result.equals("")? "@" : "") +  rs.getString(1) + "#" + rs.getString(2);
                
            }
            rs.close();
            conexion.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        out.write(result);

    }
}

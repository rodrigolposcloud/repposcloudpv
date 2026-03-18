package conexion;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.*;
import java.util.*;


public class Util
{
	
	public static String getValueWithoutNulls(String stCad)
	{
		if(stCad == null || stCad.trim().equals(""))
			return "";
		else if(stCad.toUpperCase().equals("NULL"))
			return "";
		else
			return stCad.trim();
	}
	
	public static String getValueIntWithoutNulls(String stCad)
	{
		if(stCad == null || stCad.trim().equals(""))
			return "0";
		else
		{
			if(isNumber(stCad))
				return Integer.toString(Integer.parseInt(stCad));
			else
				return "0";
		}
	}
	
	public static String getValueDoubleWithoutNulls(String stCad)
	{
		if(stCad == null || stCad.trim().equals(""))
			return "0.00";
		else
		{
			if(isNumber(stCad))
				return getFormatFloatNumber(stCad);
			else
				return "0.00";
		}
	}
	
	public static String getEmptyValueWithFormatWithoutNullsAndZeros(String stCad)
	{
		if(stCad == null || stCad.trim().equals(""))
			return "";
		else
		{
			if(isNumber(stCad))
			{
				if(Double.parseDouble(stCad) == 0)
					return "";
				else
					return getFormatFloatNumber(stCad);
			}
			else
				return "";
		}
	}
	
	public static String getEmptyValueWithoutNullsAndZeros(String stCad)
	{
		if(stCad == null || stCad.trim().equals(""))
			return "";
		else
		{
			if(isNumber(stCad))
			{
				if(Double.parseDouble(stCad) == 0)
					return "";
				else
					return getFormatFloatNumber(stCad);
			}
			else
				return "";
		}
	}

	public static String getFormatFloatNumber(String stDoubleNumber)
	{
		try{
			DecimalFormat decFormat = new DecimalFormat("0.00");
			return decFormat.format(Double.parseDouble(stDoubleNumber)).replace(',', '.');
		}catch(Exception exc){ 
			System.out.println("Exception(Util - getFormatFloatNumber):" + exc.getMessage());
			return "0.00"; }
	}
	
	public static boolean isNumber(String stNumber)
	{
		try{
			Double.parseDouble(stNumber);
			return true;
		}catch(NumberFormatException nfexc){ 
			System.out.println("Exception(Util - isNumber):" + nfexc.getMessage());
			return false; }
	}
	
	public static String getDateRef()
	{
		return new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}
	
	public static int getCurrentYear()
	{
		return Integer.parseInt(new java.text.SimpleDateFormat("yyyy").format(new Date()));
	}
	
        public static int getCurrentMonth()
	{
		return Integer.parseInt(new java.text.SimpleDateFormat("MM").format(new Date()));
	}
        
        public static int getCurrentDay()
	{
		return Integer.parseInt(new java.text.SimpleDateFormat("dd").format(new Date()));
	}
	
        public static String getDate()
	{
		return new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}
        
        public static int[] getMonthDays()
	{
		int inDays[] = new int[12];
		int inPresupYear = getCurrentYear() + 1;
		
		inDays[0] = 31; // Enero
		inDays[1] = 28; // Febrero
		if(isYearBisiesto(inPresupYear))
			inDays[1]++;
		inDays[2] = 31; // Marzo
		inDays[3] = 30; // Abril
		inDays[4] = 31; // Mayo
		inDays[5] = 30; // Junio
		inDays[6] = 31; // Julio
		inDays[7] = 31; // Agosto
		inDays[8] = 30; // Septiembre
		inDays[9] = 31; // Octubre
		inDays[10] = 30; // Noviembre
		inDays[11] = 31; // Diciembre
		
		return inDays;
	}
	
	public static boolean isYearBisiesto(int inYear)
	{
		return (inYear % 4) == 0;
	}
	
        /**
       * La fecha que recibe es en el siguiente formato YYYY/mm/dd;
       */
       public static int compareWithCurrentDate(String stFecha){
              Calendar clFechaComparar = Calendar.getInstance();
              int inValor = 0;
              //Fecha con formato yyyy/MM/dd para validar si es del dia de hoy
              String stFechaAux = new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date());
              System.out.println(stFechaAux);
              if (!stFechaAux.equals(stFecha)){
                     String arrFecha [] = stFecha.split("/");
                     clFechaComparar.clear();
                     clFechaComparar.set(Integer.parseInt(arrFecha[2]),Integer.parseInt(arrFecha[1])-1,Integer.parseInt(arrFecha[0]));
                     if (clFechaComparar.getTime().after(new Date()))
                            inValor = 1;
                     else if (clFechaComparar.getTime().before(new Date()))
                            inValor = -1;
                     }
              return inValor; 
       }
       
        /* La fecha que recibe es en el siguiente formato dd/mm/YYYY;
       */
       public static String createRFC(String nombre, String paterno, String materno, String dateNacimiento){
              String rfc = "";
              if(paterno!=null && !paterno.trim().equals("") && paterno.length()>1){
                  rfc = paterno.trim().toUpperCase().substring(0, 2);
              }else if(paterno!=null && !paterno.trim().equals("")&& paterno.length()>0){
                   rfc = paterno.trim().toUpperCase().substring(0, 1) + "X";
              }else{
                   rfc = "XX";
              }
              rfc += (materno!=null && !materno.trim().equals("")&& materno.length()>0?materno.trim().toUpperCase().substring(0, 1):"X");
              rfc += (nombre!=null && !nombre.trim().equals("")&& nombre.length()>0?nombre.trim().toUpperCase().substring(0, 1):"X");
              String[] arrFecha = dateNacimiento.split("/");
              rfc += (((String)arrFecha[2]).length()>3?arrFecha[2].substring(2, 4):arrFecha[2].substring(0, 2));
              
              NumberFormat formatoDiaMes = new DecimalFormat("00");
              rfc += formatoDiaMes.format(Integer.parseInt(arrFecha[1]));
              rfc += formatoDiaMes.format(Integer.parseInt(arrFecha[0]));
              return rfc.trim().toUpperCase(); 
       }
       
       /* La fecha que recibe es en el siguiente formato dd/mm/YYYY;
       */
       public static String subtractYearCurrentDate(int stYear){
              NumberFormat formato = new DecimalFormat("00");
              int year = getCurrentYear() - stYear;
              int month = getCurrentMonth();
              int day = getCurrentDay();
              //String strFecha = String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
              String strFecha = formato.format(day) + "/" + formato.format(month) + "/" + String.valueOf(year);
              return strFecha; 
       }
    public static String getValueIntWithoutNullsForDB(String stCad)
	{
		if(stCad == null || stCad.trim().equals(""))
			return "NULL";
		else
		{
			if(isNumber(stCad))
				return Integer.toString(Integer.parseInt(stCad));
			else
				return "NULL";
		}
	}

    public static String getValueDoubleWithoutNullsForDB(String stCad)
	{
		if(stCad == null || stCad.trim().equals(""))
			return "NULL";
		else
		{
			if(isNumber(stCad))
				return getFormatFloatNumber(stCad);
			else
				return "NULL";
		}
	}
       
	@SuppressWarnings("static-access")
	public static void main(String args[]) throws Exception {
            Util util = new Util();
            System.out.println( " RCF:-------" + util.createRFC("Rodrigo", "V", "", "15/06/2007") );
	}
	
	public static String getLocalHostName() {
		try{ 
			System.out.println("host " + InetAddress.getLocalHost().getHostName()); 
			return InetAddress.getLocalHost().getHostName();	
		}
		catch(UnknownHostException uhexc){
			System.out.println("localhost ");
			return "localhost"; }
	}
        
       
}
//Clase creada por rodrigol
//Ilustre al Pablin
//voy a enseñarle a crear pdfs desde javadu

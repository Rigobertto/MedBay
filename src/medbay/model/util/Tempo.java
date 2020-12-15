package medbay.model.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Tempo {
	public static Calendar toCalendar(String data, String hora) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Calendar calendar = Calendar.getInstance();
		
		try {
			calendar.setTime(sdf.parse(data + " " + hora));
			//System.out.println("hora: " + calendar);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		
		return calendar;
		
		/*
	    	if(data.length() > 10 || data.length() < 8) return null;
	    	List<Integer> barras = new ArrayList<Integer>();
	    	{
	    		int contador = 0;
	    		for(int index = 0; index < data.length(); index++) {
	    			if(Character.isLetter(data.charAt(index))) return null;
	    			if(data.charAt(index) == '/') {
	    				barras.add(index);
	    				contador++;
	    			}
	    		}
	    		if(contador != 2) return null;
	    	}
	    	
	    	if(hora.length() > 5 || hora.length() < 4) return null;
	    	if(hora.charAt(hora.length() - 3) != ':') return null;
	    	{
	    		int contador = 0;
	    		for(int index = 0; index < hora.length(); index++) {
	    			if(Character.isLetter(hora.charAt(index))) return null;
	    			if(hora.charAt(index) == ':') contador++;
	    		}
	    		if(contador != 1) return null;
	    	}
	    	
	    	String dia = data.substring(0, barras.get(0));
	    	String mes = data.substring(barras.get(0), barras.get(1));
	    	String ano = data.substring(barras.get(1));
	    	
	    	String horas = hora.substring(0, hora.length() - 4);
	    	String minutos = hora.substring(hora.length() - 2);
	    	
	    	
	    	Calendar calendar = Calendar.getInstance();
	    	try {
	    		// calendar.set(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(horas), Integer.parseInt(minutos));
	    		
	    		calendar.set(Calendar.YEAR, Integer.parseInt(ano));
	    		calendar.set(Calendar.MONTH, Integer.parseInt(mes));
	    		calendar.set(Calendar.DATE, Integer.parseInt(dia));
	    		calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(horas));
	    		calendar.set(Calendar.MINUTE, Integer.parseInt(minutos));
	    	}
	    	catch(NumberFormatException e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return calendar;
	    */
	}
	
	public static String toString(Calendar data) {
		return Tempo.dataToString(data) + " " + Tempo.horaToString(data);
	}

    public static String dataToString(Calendar data) {
    	if(data != null) {
    		return data.get(Calendar.DATE) + "/" + (data.get(Calendar.MONTH) + 1) + "/" + data.get(Calendar.YEAR);
    	}
    	return null;
    }
    
    public static String horaToString(Calendar data) {
    	if(data != null) {
	    	String str = "";
	    	if(data.get(Calendar.HOUR) < 10) str += "0";
	    	str += data.get(Calendar.HOUR);
	    	str += ":";
	    	if(data.get(Calendar.MINUTE) < 10) str += "0";
	        str += data.get(Calendar.MINUTE);
	        return str;
    	}
    	return null;
    }
    
    public static String whatTimeIsIt() {
    	return "it's Adventure Time!";
    }
}
package medbay.model.util;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

public class Time {
    public static Calendar toCalendar(String data) {
    	if(data.length() > 10 || data.length() < 8) return null;
    	List<int> barras = new ArrayList<int>();
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
    	
    	String dia = data.substring(0, barras.get(0) - 1);
    	String mes = data.substring(barras.get(0) + 1, barras.get(1) - 1);
    	String ano = data.substring(barras.get(1) + 1);
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(ano));
    	
    	return calendar;
    }

    public static String toString(Calendar data) {
        return data.get(Calendar.DATE) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR);
    }
    
    public static String whatTimeIsIt() {
    	return "it's Adventure Time!";
    }
}
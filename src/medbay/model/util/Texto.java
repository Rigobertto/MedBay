package medbay.model.util;

public class Texto {
	/*public static String removerAcentos(String fonte) {
		String src = new String(fonte);
		src = src.replaceAll("[ÂÀÁÄÃ]","A"); 
		src = src.replaceAll("[âãàáä]","a"); 
		src = src.replaceAll("[ÊÈÉË]","E"); 
		src = src.replaceAll("[êèéë]","e"); 
		src = src.replaceAll("ÎÍÌÏ","I"); 
		src = src.replaceAll("îíìï","i"); 
		src = src.replaceAll("[ÔÕÒÓÖ]","O"); 
		src = src.replaceAll("[ôõòóö]","o"); 
		src = src.replaceAll("[ÛÙÚÜ]","U"); 
		src = src.replaceAll("[ûúùü]","u"); 
		src = src.replaceAll("Ç","C"); 
		src = src.replaceAll("ç","c");  
		src = src.replaceAll("[ıÿ]","y"); 
		src = src.replaceAll("İ","Y"); 
		src = src.replaceAll("ñ","n"); 
		src = src.replaceAll("Ñ","N"); 
		return src; 
	}*/
	
	public static boolean contem(String fonte, String pesquisa) {
		String src = new String(fonte);
		String search = new String(pesquisa);
		
		src = src.toLowerCase();
		search = search.toLowerCase();
		
		if(src.contains(search)) return true;
		
		else return false;
	}
}

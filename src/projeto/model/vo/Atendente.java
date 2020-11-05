package projeto.model.vo;

public class Atendente {
	private int id_atendente;
	private String senha_atendente;
	
	public int getIdAtendente() {
		return id_atendente;
	}
	public void setIdAtendente(int id_atendente) {
		this.id_atendente = id_atendente;
	}
	
	public String setSenhaAtendente() {
		if(senha_atendente == null) {
			senha_atendente = "";
			return senha_atendente;
		}else
			return senha_atendente;
	}
	public void setSenhaAtendente(String senha_atendente) {
		char alfabeto[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		boolean teste = false;
		for(int i=0; i < 10; i++) {
			if(senha_atendente.indexOf(alfabeto[i]) > 0){	//senha deve conter numeros, por enquanto.
				this.senha_atendente = senha_atendente;
				teste = true;
				break;
			}
		}
		if(teste == true) {
			System.out.println("A senha deve conter números!");
		}
	} 
}

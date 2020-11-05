package projeto.model.vo;

public class Gerente {
	private int id_gerente;
	private String senha_gerente;
	
	public int getIdGerente() {
		return id_gerente;
	}
	public void setIdGerente(int id_gerente) {
		this.id_gerente = id_gerente;
	}
	
	public String getSenhaGerente(){
		if(senha_gerente == null) {
			senha_gerente = "";
			return senha_gerente;
		}else
			return senha_gerente;
	}
	public void setSenhaGerente(String senha_gerente) {
		
		char alfabeto[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		boolean teste = false;
		for(int i=0; i < 10; i++) {
			if(senha_gerente.indexOf(alfabeto[i]) > 0){
				this.senha_gerente = senha_gerente;
				teste = true;
				break;
			}
		}
		if(teste == true) {
			System.out.println("A senha deve conter números!");
		}
	}
}
package projeto.model.vo;

public class Medico {
	private int id_medico;
	private String n_conselho;	//numero do conselho nacional de medicina
	private String especialidade;
	private String senha_medico;
	
	public int getIdMedico() {
		return id_medico;
	}
	public void setIdMedico(int id_medico) {
		if(id_medico > 0)
			this.id_medico = id_medico;
		else
			System.out.println("ID inválido");
	}
	public String getConselho() {
		if(n_conselho == null) {
			n_conselho = "";
			return n_conselho;
		}else
			return n_conselho;
	}
	public void setConselho(String n_conselho) {
		if(n_conselho != null && !(n_conselho.isEmpty())) // caso o numero do conselho NÃO seja nula E vazia
			this.n_conselho = n_conselho;					// *******AINDA NAO FINALIZADO*****
		else
			System.out.println("Numero do conselho inválido");
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		if(especialidade != null && !(especialidade.isEmpty())) // caso a especilidade seja NÃO nula E vazia
			this.especialidade = especialidade;
		else
			System.out.println("Especialidade inválida");
	}
	public String getSenhaMedico() {
		return senha_medico;
	}
	public void setSenhaMedico(String senha_medico) {
		char alfabeto[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		boolean teste = false;
		for(int i=0; i < 10; i++) {			
			if(senha_medico.indexOf(alfabeto[i]) > 0){
				this.senha_medico = senha_medico;
				teste = true;
				break;
			}
		}
		if(teste == true) {
			System.out.println("A senha deve conter números!");
		}
	}
	
	
}

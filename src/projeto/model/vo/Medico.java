package projeto.model.vo;

// login por id e senha
// < pessoa tem id, a senha vai ficar onde ?>

public class Medico /* extends Pessoa */ {
	private int id_medico; // colocar a identificação em "class Pessoa"
	private int n_conselho;	//numero do conselho nacional de medicina
	private String especialidade;
	private String senha_medico; // provavel "class Usuario"
	
	public int getId_medico() {
		return id_medico;
	}
	public boolean setId_medico(int id_medico) {
		if(id_medico < 0x00) return false;
		this.id_medico = id_medico;
		return true;
	}
	public int getN_conselho() {
		return this.n_conselho;
	}
	public void setN_conselho(int n_conselho) {
		this.n_conselho = n_conselho; // provavelmente vai mudar para o tipo string, objeto especial (MedBay.util.*) ou array de caracteres
	}
	public String getEspecialidade() {
		return this.especialidade; // 
	}
	public boolean setEspecialidade(String especialidade) {
		if(especialidade == null || especialidade.isEmpty()) return false;
		this.especialidade = especialidade;
		return true;
	}
	public String getSenha_medico() {
		return this.senha_medico;
	}
	public boolean setSenha_medico(String senha_medico) {
		if(senha_medico == null || senha_medico.isEmpty()) return false;
		this.senha_medico = senha_medico;
		return true;
	}
}

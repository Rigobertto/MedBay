package projeto.model.vo;

public class Medico {
	private int id_medico;
	private int n_conselho;	//numero do conselho nacional de medicina
	private String especialidade;
	private String senha_medico;
	
	public int getId_medico() {
		return id_medico;
	}
	public void setId_medico(int id_medico) {
		this.id_medico = id_medico;
	}
	public int getN_conselho() {
		return n_conselho;
	}
	public void setN_conselho(int n_conselho) {
		this.n_conselho = n_conselho;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getSenha_medico() {
		return senha_medico;
	}
	public void setSenha_medico(String senha_medico) {
		this.senha_medico = senha_medico;
	}
	
	
}

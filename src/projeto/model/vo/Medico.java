package projeto.model.vo;

public class Medico {
	private int id_medico;
	private String n_conselho;	//numero do conselho nacional de medicina
	private String especialidade;
	
	public int getIdMedico() {
		return id_medico;
	}

	public boolean setId_medico(int id_medico) {
		if(id_medico < 0x00) return false;
		this.id_medico = id_medico;
		return true;
	}

	public String getN_conselho() {
		return this.n_conselho;
	}

	public boolean setN_conselho(String n_conselho) {
		if(n_conselho == null || n_conselho.isEmpty()) return false;
		this.n_conselho = n_conselho;
		return true;
	}

	public String getEspecialidade() {
		return this.especialidade;
	}

	public boolean setEspecialidade(String especialidade) {
		if(especialidade == null || especialidade.isEmpty()) return false;
		this.especialidade = especialidade;
		return true;
	}
}

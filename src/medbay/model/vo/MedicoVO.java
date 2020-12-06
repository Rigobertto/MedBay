package medbay.model.vo;

public class MedicoVO extends UsuarioVO{
	private String crm;	
	private String especialidade;

	public String getCrm() {
		return this.crm;
	}

	public boolean setCrm(String crm) {
		if(crm == null || crm.isEmpty())
			return false;
			this.crm = crm;
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

package medbay.model.bo;

import medbay.model.vo.PacienteVO;

public interface PacienteInterBO {
	
	public PacienteVO[] listar(PacienteVO[] paciente);
	
	public PacienteVO editar(PacienteVO paciente);
	
	public void excluir(PacienteVO paciente);
	
	public PacienteVO buscaCPF(PacienteVO paciente);
	
	public PacienteVO buscaNome(PacienteVO paciente);
	
	public PacienteVO cadastrar(PacienteVO paciente);
}

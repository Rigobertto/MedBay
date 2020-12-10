package medbay.model.bo;

import java.util.List;

import medbay.model.vo.PacienteVO;

public interface PacienteInterBO {
	
	public List<PacienteVO> listar();
	
	//public PacienteVO editar(PacienteVO paciente);
	
	//public void excluir(PacienteVO paciente);
	
	//public PacienteVO buscaCPF(PacienteVO paciente);
	
	//public PacienteVO buscaNome(PacienteVO paciente);
	
	public boolean cadastrar(PacienteVO paciente);
}

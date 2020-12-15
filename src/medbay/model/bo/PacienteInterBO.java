package medbay.model.bo;

import java.util.List;

import medbay.model.vo.PacienteVO;

public interface PacienteInterBO {
	public List<PacienteVO> listar();
	public boolean cadastrar(PacienteVO paciente);
	public List<PacienteVO> listarNome(String nome);
	public boolean editar(PacienteVO paciente);
	public PacienteVO buscaId(int id);
	public void excluir(PacienteVO paciente);
}

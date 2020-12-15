package medbay.model.bo;

import java.util.List;

import medbay.model.vo.ConsultaVO;
import medbay.model.vo.MedicoVO;
import medbay.model.vo.PacienteVO;

public interface ConsultaInterBO {
	public boolean cadastrar(ConsultaVO consulta);
	public boolean editar(ConsultaVO consulta);
	public void excluir(ConsultaVO consulta);
	
	public List<ConsultaVO> listar();
	
	public List<ConsultaVO> listarIdMedico(MedicoVO medico);
	public List<ConsultaVO> listarIdMedico(MedicoVO medico, List<ConsultaVO> lista);
	
	public List<ConsultaVO> listarIdPaciente(PacienteVO paciente);
	public List<ConsultaVO> listarIdPaciente(PacienteVO paciente, List<ConsultaVO> lista);
	
	public List<ConsultaVO> listarNomeMedico(String nome);
	public List<ConsultaVO> listarNomeMedico(String nome, List<ConsultaVO> lista);
	
	public List<ConsultaVO> listarNomePaciente(String nome);
	public List<ConsultaVO> listarNomePaciente(String nome, List<ConsultaVO> lista);
	
	public List<ConsultaVO> listarNome(String nome);
	public List<ConsultaVO> listarNome(String nome, List<ConsultaVO> lista);
	
	public ConsultaVO buscarId(int id);
}
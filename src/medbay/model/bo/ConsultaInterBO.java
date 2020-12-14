package medbay.model.bo;

import java.util.List;

import medbay.model.vo.ConsultaVO;
import medbay.model.vo.MedicoVO;

public interface ConsultaInterBO {
	public boolean cadastrar(ConsultaVO consulta);
	public boolean editar(ConsultaVO consulta); // Vincula um exame a uma consulta
	public void excluir(ConsultaVO consulta);
	public List<ConsultaVO> listar();
	public List<ConsultaVO> listarID(MedicoVO vo);
}
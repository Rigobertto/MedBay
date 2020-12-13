package medbay.model.bo;

import medbay.model.vo.ConsultaVO;

public interface ConsultaInterBO {
	public boolean cadastrar(ConsultaVO consulta);
	public boolean editar(ConsultaVO consulta); // Vincula um exame a uma consulta
	public void excluir(ConsultaVO consulta);
	public ArrayList listar();
	public ArrayList listarID(MedicoVO vo);

    
}
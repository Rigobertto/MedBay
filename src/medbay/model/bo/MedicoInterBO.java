package medbay.model.bo;

import java.util.ArrayList;
import java.util.List;

import medbay.model.vo.MedicoVO;

public interface MedicoInterBO {
	
	public MedicoVO listarID(int id);
	public boolean cadastrar(MedicoVO medico);
	public ArrayList<MedicoVO> listar();
	public List<MedicoVO> listarNome(String nome);
	public void excluir(MedicoVO medico);
	public boolean editar(MedicoVO medico);
	public MedicoVO buscaId(int id);
}

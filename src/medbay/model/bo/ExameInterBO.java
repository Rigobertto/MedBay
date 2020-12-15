package medbay.model.bo;

import java.util.ArrayList;

import medbay.model.vo.ExameVO;

public interface ExameInterBO<VO extends ExameVO> {
	public ArrayList<ExameVO> listar();
	public void cadastrar(ExameVO exame);
	public boolean excluir(ExameVO exame);
	public boolean editar(ExameVO vo);
  	ExameVO buscaId(int id);
  	public ExameVO listarID(int ID);
}
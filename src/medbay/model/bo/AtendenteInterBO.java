package medbay.model.bo;

import java.util.List;

import medbay.model.vo.AtendenteVO;

public interface AtendenteInterBO  {
	public List<AtendenteVO> listar();
	public boolean editar(AtendenteVO atendente);
	public boolean excluir(AtendenteVO atendente);
	//public AtendenteVO buscaCPF(AtendenteVO atendente);
	//public AtendenteVO buscaNome(AtendenteVO atendente);
	public boolean cadastrar(AtendenteVO atendente);
}

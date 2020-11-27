package projeto.model.bo;

import projeto.model.vo.AtendenteVO;

public interface AtendenteInterBO {
	public AtendenteVO[] listar(AtendenteVO[] atendente);
	
	public AtendenteVO editar(AtendenteVO atendente);
	
	public void excluir(AtendenteVO atendente);
	
	public AtendenteVO buscaCPF(AtendenteVO atendente);
	
	public AtendenteVO buscaNome(AtendenteVO atendente);
	
	public AtendenteVO cadastrar(AtendenteVO atendente);
}

package projeto.model.bo;

import projeto.model.vo.GerenteVO;

public interface GerenteInterBO {
	public GerenteVO[] listar(GerenteVO[] gerente);
	
	public GerenteVO editar(GerenteVO gerente);
	
	public void excluir(GerenteVO gerente);
	
	public GerenteVO buscaCPF(GerenteVO gerente);
	
	public GerenteVO buscaNome(GerenteVO gerente);
	
	public GerenteVO cadastrar(GerenteVO gerente);
}

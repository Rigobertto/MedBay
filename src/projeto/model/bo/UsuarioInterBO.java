package projeto.model.bo;

import projeto.model.vo.UsuarioVO;

public interface UsuarioInterBO {
	
	public UsuarioVO[] listar(UsuarioVO[] usuario);
	
	public UsuarioVO editar(UsuarioVO usuario);
	
	public void excluir(UsuarioVO usuario);
	
	public UsuarioVO buscaCPF(UsuarioVO usuario);
	
	public UsuarioVO buscaNome(UsuarioVO usuario);
	
	public UsuarioVO cadastrar(UsuarioVO usuario);
}

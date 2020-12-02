package projeto.model.bo;

import projeto.model.vo.MedicoVO;

public interface MedicoInterBO {
	
	public MedicoVO[] listar(MedicoVO medico);
	public MedicoVO cadastrar(MedicoVO medico);
	public void excluir(MedicoVO medico);
	public MedicoVO editar(MedicoVO medico);
	public MedicoVO buscaNome(MedicoVO medico);
	public MedicoVO buscaCPF(MedicoVO medico);
	public MedicoVO buscaCRM(MedicoVO medico);
}

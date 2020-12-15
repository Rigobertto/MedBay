package medbay.model.bo;


import medbay.model.vo.PessoaVO;


public interface PessoaInterBO{
	public PessoaVO editar(PessoaVO pessoa);
	public void excluir(PessoaVO pessoa);
	public PessoaVO buscaCPF(PessoaVO pessoa);
	public PessoaVO buscaNome(PessoaVO pessoa);
	public PessoaVO cadastrar(PessoaVO pessoa);
	
}

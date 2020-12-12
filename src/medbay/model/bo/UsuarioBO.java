package medbay.model.bo;
import medbay.model.vo.UsuarioVO;

import medbay.model.dao.AtendenteDAO;
import medbay.model.dao.GerenteDAO;
import medbay.model.dao.MedicoDAO;
import medbay.model.vo.AtendenteVO;
import medbay.model.vo.GerenteVO;
import medbay.model.vo.MedicoVO;

public class UsuarioBO implements UsuarioInterBO{
	AtendenteDAO<AtendenteVO> daoAten = new AtendenteDAO<AtendenteVO> ();
	GerenteDAO<GerenteVO> daoGer = new GerenteDAO<GerenteVO>();
	MedicoDAO<MedicoVO> daoMed = new MedicoDAO<MedicoVO>();
	
	public UsuarioVO autenticar(UsuarioVO vo){
		UsuarioVO atendente = new UsuarioVO();
		//atendente.setTabela(0);
		UsuarioVO gerente = new UsuarioVO();
		//gerente.setTabela(0);
		UsuarioVO medico = new UsuarioVO();
		//medico.setTabela(0);
		try {
			atendente = daoAten.autenticarAtendente(vo);
			gerente = daoGer.autenticarGerente(vo);
			medico = daoMed.autenticarMedico(vo);
//			List<UsuarioVO> listA = new ArrayList<>();
//			List<UsuarioVO> listG = new ArrayList<>();
//			List<UsuarioVO> listM = new ArrayList<>();
			
			
			if(atendente.getTabela() == 2){
					return atendente;
			}if(gerente.getTabela() == 1){
					return gerente;
			}if(medico.getTabela() == 3){
					return medico;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return vo;
		}
		return vo;
	}
//	
//	public UsuarioVO[] listar(UsuarioVO[] usuario){
//		return null;
//	}
//	
//	public UsuarioVO editar(UsuarioVO usuario){
//	//	Recebe objeto do tipo pessoa que poder� editar cada atributo...
//	//	...utilizando tamb�m os m�todos get e set para exibir e enviar no DAO.
//	//	Caso a o usu�rio nao escolha nenhum genero, o genero utilizado ser� o Indefinido, declarado j� no construtor;
//	//	Retorna um objeto do tipo Pessoa com os atributos editados.
//		return null;
//		
//	}
//	
//	public void excluir(UsuarioVO usuario){
//	//	Recebe um objeto Pessoa para excluir, vale destacar que excluir� n�o s� apenas um atributo, mas sim o objeto por completo.
//	//	N�o retorna nada.
//		
//	}
//	
//	public UsuarioVO buscaCPF(UsuarioVO usuario){
//	//	Ir� receber uma String CPF para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String CPF
//	//	recebida por parametro e poder retornar.
//	//	Vale destacar que antes de ir para o m�todo de busca no DAO, a String recebida por parametro ir� passar por uma valida��o
//	//	para saber se � de fato um n�mero de CPF;
//		return null;
//	}
//	
//	public UsuarioVO buscaNome(UsuarioVO usuario){
//		//	Ir� receber uma String nome para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String nome
//		//	recebida por parametro e poder retornar a exibi��o dos atributos do objeto.
//		//	Vale destacar que antes de ir para o m�todo de busca no DAO, a String recebida por parametro ir� passar por uma valida��o
//		//	para saber se � de fato uma String nula e etc.
//		return null;
//	}
//	
//	public UsuarioVO cadastrar(UsuarioVO usuario){
//	//	Recebe um objeto Pessoa para inserir os atributos incluindo os inicializados pelo construtor e envia para o DAO e posteriormente
//	//	inserir no banco de dados;
//	//	Os atributos que ser�o cadastrados passar�o pela valida��o dos mesmo com os m�todos get e set correspondente a cada um,
//	//	como idade, cpf, nome, genero e etc.
//		return null;
//	}
}

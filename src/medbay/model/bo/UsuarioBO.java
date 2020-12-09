package medbay.model.bo;
import medbay.model.vo.UsuarioVO;

import java.sql.SQLException;

import medbay.model.dao.AtendenteDAO;
import medbay.model.dao.GerenteDAO;
import medbay.model.dao.UsuarioDAO;
import medbay.model.vo.AtendenteVO;
import medbay.model.vo.GerenteVO;
import medbay.model.vo.MedicoVO;

public class UsuarioBO implements UsuarioInterBO{
	UsuarioDAO dao = new UsuarioDAO();
	
	public UsuarioVO autenticar(UsuarioVO vo){
		try {
			UsuarioVO user = new UsuarioVO();
			user = dao.autenticar(vo);
			if(user.getSenha().equals(vo.getSenha())) {
				if(user.getLogin().equals(vo.getLogin())) {
					return user;
				}
			}
			/*if(user.getTabela() == 1) {
				UsuarioVO ger = new UsuarioVO();
				ger = dao.autenticarSenha(user, "Gerente");
				ger.setTabela(1);
				return ger;
				
			}else if(user.getTabela() == 2) {
				UsuarioVO aten = new AtendenteVO();
				aten = dao.autenticarSenha(user, "Atendente");
				aten.setTabela(2);
				return aten;
				
			}else if(user.getTabela() == 3) {
				UsuarioVO med = new MedicoVO();
				med = dao.autenticarSenha(user, "Medico");
				med.setTabela(3);
				return med;
				
			}else {
				return null;
			}*/
		}catch(SQLException e){
			e.getStackTrace();
			return null;
		}
		return null;
	}
	
	public UsuarioVO[] listar(UsuarioVO[] usuario){
		
	}
	
	public UsuarioVO editar(UsuarioVO usuario){
	//	Recebe objeto do tipo pessoa que poder� editar cada atributo...
	//	...utilizando tamb�m os m�todos get e set para exibir e enviar no DAO.
	//	Caso a o usu�rio nao escolha nenhum genero, o genero utilizado ser� o Indefinido, declarado j� no construtor;
	//	Retorna um objeto do tipo Pessoa com os atributos editados.
	}
	
	public void excluir(UsuarioVO usuario){
	//	Recebe um objeto Pessoa para excluir, vale destacar que excluir� n�o s� apenas um atributo, mas sim o objeto por completo.
	//	N�o retorna nada.
	}
	
	public UsuarioVO buscaCPF(UsuarioVO usuario){
	//	Ir� receber uma String CPF para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String CPF
	//	recebida por parametro e poder retornar.
	//	Vale destacar que antes de ir para o m�todo de busca no DAO, a String recebida por parametro ir� passar por uma valida��o
	//	para saber se � de fato um n�mero de CPF;
	}
	
	public UsuarioVO buscaNome(UsuarioVO usuario){
		//	Ir� receber uma String nome para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String nome
		//	recebida por parametro e poder retornar a exibi��o dos atributos do objeto.
		//	Vale destacar que antes de ir para o m�todo de busca no DAO, a String recebida por parametro ir� passar por uma valida��o
		//	para saber se � de fato uma String nula e etc.
	}
	
	public UsuarioVO cadastrar(UsuarioVO usuario){
	//	Recebe um objeto Pessoa para inserir os atributos incluindo os inicializados pelo construtor e envia para o DAO e posteriormente
	//	inserir no banco de dados;
	//	Os atributos que ser�o cadastrados passar�o pela valida��o dos mesmo com os m�todos get e set correspondente a cada um,
	//	como idade, cpf, nome, genero e etc.
	}
}

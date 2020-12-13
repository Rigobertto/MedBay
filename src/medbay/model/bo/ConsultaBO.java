package medbay.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import medbay.model.dao.ConsultaDAO;
import medbay.model.vo.ConsultaVO;
import medbay.model.vo.ExameVO;
import medbay.model.vo.MedicoVO;

public class ConsultaBO /*implements ConsultaInterBO*/ {
	ConsultaDAO<ConsultaVO> dao = new ConsultaDAO<ConsultaVO>();
	
	ExameBO<ExameVO> ebo = new ExameBO<ExameVO>();
	PacienteBO pbo = new PacienteBO();
	MedicoBO mbo = new MedicoBO();
	
	public boolean cadastrar(ConsultaVO consulta) {
        try {
        	dao.cadastrar(consulta);
        	return true;
        }catch(Exception e){
        	e.printStackTrace();
        	return false;
        }
    }

    public boolean editar(ConsultaVO consulta) {
        try {
        	dao.editar(consulta);
        	return true;
        }catch(Exception e) {
        	e.printStackTrace();
        	return false;
        }
    }
	
	public void excluir(ConsultaVO consulta) {
        try {
        	dao.excluir(consulta);
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }

	public List<ConsultaVO> listar() {
		List<ConsultaVO> lista = new ArrayList<ConsultaVO>();
		
		try {
			ResultSet tabela = dao.listar();
			
			while(tabela.next()) {
				ConsultaVO consulta = new ConsultaVO();
				
				consulta.setId(tabela.getInt("ide"));
				
				Calendar data = Calendar.getInstance();
				data.setTimeInMillis(tabela.getTime("data").getTime());
				consulta.setData(data);
				
				consulta.setExame(ebo.buscaId(tabela.getInt("id_exame")));
				consulta.setPaciente(pbo.buscaId(tabela.getInt("id_paciente")));
				consulta.setMedico(mbo.buscaId(tabela.getInt("id_medico")));
				
				consulta.setObservacao(tabela.getString("observacao"));
				
				lista.add(consulta);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<ConsultaVO> listarID(MedicoVO medico) {
		List<ConsultaVO> lista = listar();
		List<ConsultaVO> resultado = new ArrayList<ConsultaVO>();
		
		for(int index = 0; index < lista.size(); index++) {
			if(lista.get(index).getMedico().getId() == medico.getId()) resultado.add(lista.get(index));
		}
		
		return resultado;
	}
	
	public ConsultaVO buscarId(int id) {
		ConsultaVO consulta = new ConsultaVO();
		consulta.setId(id);
		
		ResultSet tabela = dao.buscaID(consulta);
		
		try {
			Calendar data = Calendar.getInstance();
			data.setTimeInMillis(tabela.getTime("data").getTime());
			consulta.setData(data);
			
			consulta.setExame(ebo.buscaId(tabela.getInt("id_exame")));
			consulta.setPaciente(pbo.buscaId(tabela.getInt("id_paciente")));
			consulta.setMedico(mbo.buscaId(tabela.getInt("id_medico")));
			
			consulta.setObservacao(tabela.getString("observacao"));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return consulta;
	}
	
	/*

    static boolean editar(ConsultaVO consulta, Calendar data_consulta) {
        // adiciona a um objeto do tipo ConsultaVO uma data nova que não pode ser menor que a data atual.
    }

    // BUSCA
        Os métodos de busca irão chamar pelo MedicoBO e PacienteBO
        para que os mesmos encontrem médicos e/ou pacientes com a chave
        de pesquisa indicada.

        Muitos dos métodos indicados ainda precisam ser idealizados e implementados.

    static ConsultaVO buscar(int id) {
        // Chama o DAO para buscar uma consulta com o ID indicado.
        // Cada ID de consulta será único, assim resulta em apenas 1 consulta por busca.
        // Retorna um objeto do tipo ConsultaVO referente ao ID, caso o mesmo exista.
    }

    static ConsultaVO [] buscar(String nome) {
        // Chama os métodos MedicoBO.buscar(nome) e PacienteBO.buscar(nome).
        // Filtra as consultas atreladas aos médicos e/ou pacientes
        // Retorna os dois resultados concatenados.
    }

    static ConsultaVO [] buscar(CPF cpf) {
        // Chama os métodos MedicoBO.busca(cpf) e PacienteBO.busca(cpf).
        // Filtra as consultas atreladas aos médicos e/ou pacientes
        // Retorna os dois resultados concatenados.
    }

    static ConsultaVO [] buscar(Calendar data) {
        // Chama ConsultaDAO para buscar um elemento por data.
        // Busca uma consulta com a data indicada.
        // (a data procurada é a data para qual foi marcada a consulta, para evitar conflitos)
        // Retorna todos os resultados encontrados.
    }

    static ConsultaVO [] buscar(MedicoVO medico) {
        // Chama ConsultaDAO para buscar um elemento por médico.
        // Retorna todas as consultas referentes a um médico usando o seu ID.
        // ainda precisa ser implementado no objeto ConsultaVO um atributo que armazene o ID do médico.
    }

    static ConsultaVO [] buscar(PacienteVO paciente) {
        // Chama ConsultaDAO para buscar um elemento por paciente.
        // Busca todas as consultas referentes a um paciente usando o seu ID.
        // ainda precisa ser implementado no objeto ConsultaVO um atributo que armazene o ID do paciente.
    }

    // lembrar: atributos Mid e Pid
    
    */
}

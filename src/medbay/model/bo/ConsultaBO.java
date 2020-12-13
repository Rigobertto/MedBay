package medbay.model.bo;

import medbay.model.dao.ConsultaDAO;
import medbay.model.vo.ConsultaVO;

public class ConsultaBO implements ConsultaInterBO {
	ConsultaDAO<ConsultaVO> dao = new ConsultaDAO<ConsultaVO>();
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
    
    public ArrayList listar() { // listar para a tela principal de atendente;
    	try {
    		return null;
    	}catch(Exception e){
    		return null;
    	}
    }
    
    public ArrayList listarID(MedicoVO vo) { // listar para a tela principal de medico de acordo com o ID do mesmo;
    	try {
    		return null;
    	}catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }
    
}

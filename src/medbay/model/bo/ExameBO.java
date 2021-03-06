package medbay.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import medbay.model.dao.ExameDAO;
import medbay.model.vo.ExameVO;

public class ExameBO<VO extends ExameVO> implements ExameInterBO<VO>{
	ExameDAO<ExameVO> ex = new ExameDAO<ExameVO>();
	
	public ArrayList<ExameVO> listar() {
		ArrayList<ExameVO> exames = new ArrayList<ExameVO>();
		try {
			ResultSet rs = ex.listar();
			while(rs.next()){
				ExameVO vo = new ExameVO();
				vo.setId(rs.getInt("ide"));
				vo.setNome(rs.getString("nome"));
				vo.setValor(rs.getFloat("valor"));
				exames.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return exames;
	}
	
    public void cadastrar(ExameVO exame) {
    	try {
    		ex.cadastrar(exame);
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public boolean excluir(ExameVO exame){
    	try {
    		ex.excluir(exame);
    		return true;
    	}catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    }
    
    public boolean editar(ExameVO vo) {
    	try {
    		ex.editar(vo);
    		return true;
    	}catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    }
    
    public ExameVO buscaId(int id) {
    	ExameVO exame = new ExameVO();
    	exame.setId(id);
    	
    	try {
			exame = ex.buscarID(exame);
		}
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return exame;
    }

    public ExameVO listarID(int ID) {
    	try {
    		ExameVO vo = new ExameVO();
    		ResultSet rs = ex.listarID(ID);
    		if(rs.next()){
				vo.setId(rs.getInt("ide"));
				vo.setNome(rs.getString("nome"));
				vo.setValor(rs.getFloat("valor"));
			}
    		return vo;
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
}
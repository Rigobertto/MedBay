package projeto.model.vo;

public class AtendenteVO extends UsuarioVO{
private int id_atendente;
	
	public int getIdAtendente() {
		return id_atendente;
	}
	public boolean setIdAtendente(int id_atendente) {
		if(id_atendente < 0x00) return false;
		this.id_atendente = id_atendente;
		return true;
	}
	
	// reimplementação e adequação pendente
}

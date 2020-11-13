package projeto.model.vo;

public class Gerente {
	private int id_gerente;
	
	public int getIdGerente() {
		return id_gerente;
	}
	public boolean setIdGerente(int id_gerente) {
		if(id_gerente < 0x00) return false;
		this.id_gerente = id_gerente;
		return true;
	}
	// reimplementação pendente
}
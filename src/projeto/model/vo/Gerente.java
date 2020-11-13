package projeto.model.vo;

public class Gerente {
	private int id_gerente;
	private String senha_gerente;
	
	public int getIdGerente() {
		return id_gerente;
	}
	public boolean setIdGerente(int id_gerente) {
		if(id_gerente < 0x00) return false;
		this.id_gerente = id_gerente;
		return true;
	}
	
	public String getSenhaGerente() {
		return new String(this.senha_gerente);
	}
	public boolean setSenhaGerente(String senha_gerente) {
		if(senha_gerente == null || senha_gerente.isEmpty()) return false;
		this.senha_gerente = senha_gerente;
		return true;
	}
}
package projeto.model.vo;

public class Atendente {
	private int id_atendente;
	private String senha_atendente;
	
	public int getIdAtendente() {
		return id_atendente;
	}
	public boolean setIdAtendente(int id_atendente) {
		if(id_atendente < 0x00) return false;
		this.id_atendente = id_atendente;
		return true;
	}
	
	public String getSenhaAtendente() {
		return new String(this.senha_atendente);
	}
	public boolean setSenhaAtendente(String senha_atendente) {
		if(senha_atendente == null || senha_atendente.isEmpty()) return false;
		this.senha_atendente = senha_atendente;
		return true;
	}
}

package projeto.model.vo;

public class UsuarioVO extends PessoaVO{
	 	private int id;
	    private String login;
	    private String senha;

	    public void Usuario(String nome, String senha) { // Pq desse método?
	        this.setNome(nome);
	        this.setSenha(senha);
	    }

	    public int getId() { // validar idade
	        return this.id;
	    }

	    public boolean setId(int id) {
	        if(id < 0x00) return false; // adicionar mÃ©todo no pacote "util" que verifica se o ID já, existe
	        this.id = id;
	        return true;
	    }

	    public String getLogin() {
	        return new String(this.login);
	    }

	    public boolean setLogin(String login) {
	        if(login == null || login.isEmpty()) return false;
	        this.login = login;
	        return true;
	    }

	    public String getSenha() {				// getSenha privado
	        return new String(this.senha);
	    }

	    public boolean setSenha(String senha) {
	        if(senha == null || senha.isEmpty()) return false; // setSenha privado
	        this.senha = senha;
	        return true;
	    }

	    public boolean verificarSenha(String senha) {
	        if(this.getSenha().equals(senha)) return true;
	        return false;
	    }

	    public boolean trocarSenha(String senha_atual, String senha_nova) {
	        if(this.verificarSenha(senha_atual)) {
	            return this.setSenha(senha_nova);
	        }else{
	        return false;
	        }
	    }
}

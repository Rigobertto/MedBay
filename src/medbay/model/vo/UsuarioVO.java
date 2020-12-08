package medbay.model.vo;

public class UsuarioVO extends PessoaVO {
	    private String login;
	    private String senha;

	    public String getLogin() {
	        return new String(this.login);
	    }

	    public boolean setLogin(String login) {
	        if(login == null || login.isEmpty()) return false;
	        this.login = login;
	        return true;
	    }

	    public String getSenha() {
	        return new String(this.senha);
	    }

	    public boolean setSenha(String senha) {
	        if(senha == null || senha.isEmpty()) return false;
	        this.senha = senha;
	        return true;
	    }

		// usado para validação, pode estar no BO
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

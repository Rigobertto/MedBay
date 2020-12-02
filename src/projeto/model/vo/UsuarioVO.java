package projeto.model.vo;

public class UsuarioVO extends PessoaVO{
	 private int id; // remover, o ID vai servir como numero de matricula para os Pacientes
	    private String nome;
	    private String senha;

	    public void Usuario(String nome, String senha) {
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

	    public String getNome() {
	        return new String(this.nome);
	    }

	    public boolean setNome(String nome) {
	        if(nome == null || nome.isEmpty()) return false;
	        this.nome = nome;
	        return true;
	    }

	    private String getSenha() {				// getSenha privado
	        return new String(this.senha);
	    }

	    private boolean setSenha(String senha) {
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

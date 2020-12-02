package projeto.model.vo;

import java.util.Calendar;

public class ExameVO {
		private int id;
	    private String nome;
	    private float valor;

	    private Calendar data;

	    // private Medico medico;
	    // private String dados;
	    private String observacao;
	    private ProntuarioVO prontuario;

	    public int getId() {
	        return this.id;
	    }

	    public boolean setId(int id) {
	        if(id < 0) return false;
	        else this.id = id;
	        return true;
	    }

	    public String getNome() {
	        return this.nome;
	    }

	    public boolean setNome(String nome) {
	        if(nome == null || nome.isEmpty()) return false;
	        this.nome = nome.toUpperCase();
	        return true;
	    }

	    public float getValor() {
	        return this.valor;
	    }

	    public boolean setValor(float valor) {
	        if(valor < 0.00f) return false;
	        this.valor = valor;
	        return true;
	    }

	    public Calendar getData() {
	        return this.data;
	    }

	    public boolean setData(Calendar data) {
	        if(data == null) return false;
	        this.data = data;
	        return true;
	    }

	    public String getObservacao() {
	        return this.observacao;
	    }

	    public boolean setObservacao(String texto) {
	        if(texto == null) if(texto.isEmpty()) return false;
	        this.observacao = texto.toUpperCase();
	        return true;
	    }

	    public ProntuarioVO getProntuario() {
	        return this.prontuario;
	    }

	    public boolean setProntuario(ProntuarioVO prontuario) {
	        if(prontuario.getId() < 0) return false;
	        if(prontuario.getData().getTimeInMillis() < this.data.getTimeInMillis()) return false;
	        if(prontuario.getObservacao() == null || prontuario.getObservacao().isEmpty()) return false;
	        this.prontuario = prontuario;
	        return true;
	    }
}

package projeto.model.vo;

import java.util.Calendar;

public class ProntuarioVO{
	 private int id;
	    private Calendar data;

	    // private Medico medico;
	    // private String dados;
	    private String observacao;
	    
	    public int getId() {
	        return this.id;
	    }

	    public boolean setId(int id) {
	        if(id < 0) return false;
	        else this.id = id;
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
	        return new String(this.observacao);
	    }

	    public boolean setObservacao(String texto) {
	        if(texto == null || texto.isEmpty()) return false;
	        this.observacao = texto.toUpperCase();
	        return true;
	    }
}

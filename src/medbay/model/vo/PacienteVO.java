package medbay.model.vo;

public class PacienteVO extends PessoaVO{
	private float peso;
	private float altura;
	private String tipo_sangue;
	
	public float getPeso() {
		return this.peso;
	}
	public boolean setPeso(float peso) {
		if(peso <= 0.0f) return false;
		this.peso = peso;
		return true;
	}
	public float getAltura() {
		return this.altura;
	}
	public boolean setAltura(float altura) {
		if(altura <= 0.0f) return false;
		this.altura = altura;
		return true;
	}
	public String getTipoSangue() {
		return new String(this.tipo_sangue);
	}
	public boolean setTipoSangue(String tipo_sangue) {
		tipo_sangue = tipo_sangue.toUpperCase();
		String tipos[] = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}; // testar valida��o de tipo sanguineo;
		for(int i = 0; i < 8; i++) {
			if(tipos[i].equals(tipo_sangue)) {
				this.tipo_sangue = tipo_sangue;
				return true;
			}
		}
		return false;
	}
}

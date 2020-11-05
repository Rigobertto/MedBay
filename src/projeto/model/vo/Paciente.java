package projeto.model.vo;

public class Paciente {
	private int id_paciente;
	private float peso;
	private float altura;
	private String tipo_sangue;
	
	public int getId_paciente() {
		return id_paciente;
	}
	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}
	public float getPeso() {
		if(peso > 0.0f)
			return peso;
		else{
			peso = 0.0f;
			return peso;
		}
	}
	public void setPeso(float peso) {
		if(peso > 1.0f)
			this.peso = peso;
		else
			System.out.println("Peso inválido!");
	}
	public float getAltura() {
		if(altura > 0.0f)
			return altura;
		else{
			altura = 0.0f;
			return altura;
		}
	}
	public void setAltura(float altura) {
		if(altura > 30.0f)
			this.altura = altura;
		else
			System.out.println("Altura inválida!");
	}
	public String getTipoSangue() {
		if(tipo_sangue == null) {
			tipo_sangue = "";
			return tipo_sangue;}
		else
			return tipo_sangue;
	}
	public void setTipoSangue(String tipo_sangue) {
		tipo_sangue = tipo_sangue.toUpperCase();
		String tipos[] = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
		boolean teste = false;
		for(int i = 0; i < 8; i++) {
			if(tipos[i].equals(tipo_sangue)) {
				this.tipo_sangue = tipo_sangue;
				teste = true;
				break;
			}
		}
		if(teste == false)
			System.out.println("Tipo sanguineo inválido!");
	}
	
	
}

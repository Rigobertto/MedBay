package medbay.controller;
import javafx.event.ActionEvent;
import medbay.view.Telas;

public class PrincipalGerenteController{
	
	public void entrarAtendente(ActionEvent event){
		try {
			Telas.telaEntrarAtendente();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void entrarMedico(ActionEvent event) {
		try {
			Telas.telaEntrarMedico();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void entrarPaciente(ActionEvent event) {
		try {
			Telas.telaEntrarPaciente();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void entrarExame(ActionEvent event) {
		try {
			Telas.telaEntrarExame();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logOut(ActionEvent event) {
		try {
			Telas.telaLogin();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
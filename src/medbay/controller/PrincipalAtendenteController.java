package medbay.controller;

import javafx.event.ActionEvent;
import medbay.view.Telas;

public class PrincipalAtendenteController {
	
	public void logOut(ActionEvent event) {
		try {
			Telas.telaLogin();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void entrarPaciente(ActionEvent event){
		try {
			Telas.telaEntrarPaciente();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void entrarConsulta(ActionEvent event){
		try {
			Telas.telaEntrarConsulta();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

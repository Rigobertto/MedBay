package medbay.controller;

import javafx.event.ActionEvent;
import medbay.view.Telas;

public class PrincipalMedicoController {
	public void logOut(ActionEvent event) {
		try {
			Telas.telaLogin();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editarProntuario(ActionEvent event) {
		try {
			Telas.telaEditarProntuario();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

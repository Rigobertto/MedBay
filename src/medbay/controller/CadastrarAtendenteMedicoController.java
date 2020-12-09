package medbay.controller;

import javafx.event.ActionEvent;
import medbay.view.Telas;

public class CadastrarAtendenteMedicoController{
	public void logOut(ActionEvent event) {
		try {
			Telas.telaLogin();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void voltar(ActionEvent event) {
		try {
			Telas.telaInicioGerente();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

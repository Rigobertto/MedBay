package medbay.controller;

import javafx.event.ActionEvent;
import medbay.view.Telas;

public class ListarPacienteController{

	public void logOut(ActionEvent event) {
		try {
			Telas.telaLogin();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void voltar(ActionEvent event) {
		try {
			//fazer um if pra voltar para a tela certa
			Telas.telaInicioGerente();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarPaciente(ActionEvent event) {
		try {
			Telas.telaCadastrarPaciente();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

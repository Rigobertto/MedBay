package medbay.controller;

import javafx.event.ActionEvent;
import medbay.view.Telas;

public class EntrarConsultaController {
	public void logOut(ActionEvent event) {
		try {
			Telas.telaLogin();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void voltar(ActionEvent event) {
		try {
			Telas.telaInicioAtendente();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarConsulta(ActionEvent event) {
		try {
			Telas.telaCadastrarConsulta();
		}catch(Exception e) {
			e.printStackTrace();
		}
	} 
}

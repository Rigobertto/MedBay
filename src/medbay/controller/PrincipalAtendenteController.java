package medbay.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import medbay.model.vo.UsuarioVO;
import medbay.view.Telas;

public class PrincipalAtendenteController implements Initializable{
	@FXML private Label lblMensagem;
	private static UsuarioVO user = new UsuarioVO();
	
	public void initialize(URL url, ResourceBundle rb) {
    	//lblMensagem.setText(user.getNome());
    }
	
	public static UsuarioVO getUser() {
		return user;
	}

	public static void setUser(UsuarioVO user) {
		PrincipalAtendenteController.user = user;
	}
	
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

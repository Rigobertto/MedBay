package medbay.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import medbay.model.bo.UsuarioBO;
import medbay.view.Telas;

public class TelaLoginController {
	@FXML private TextField login;
	@FXML private TextField senha;
	@FXML private Label erroAut;
	
	UsuarioBO usuBO = new UsuarioBO();
	
	public void autenticar(ActionEvent event) {
		//UsuarioVO vo = new UsuarioVO();
		//vo.setLogin(login.getText());
		//vo.setSenha(senha.getText());
		
		try {
			Telas.telaInicioGerente();
			//Telas.telaInicioAtendente();
			//Telas.telaInicioMedico();
		}catch(Exception e){
			erroAut.setVisible(true);
			e.printStackTrace();
		}
	}
}

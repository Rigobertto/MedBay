package medbay.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import medbay.view.Telas;
import medbay.model.bo.ExameBO;
import medbay.model.vo.ExameVO;

public class CadastrarExameController {
	@FXML private TextField nome;
	@FXML private TextField valor;
	@FXML private Label lblMensagem;
	ExameBO exame = new ExameBO();
	
	public void cadastrar(ActionEvent event)throws Exception{
		ExameVO ex = new ExameVO();
		try {
			ex.setNome(nome.getText());
			ex.setValor(Float.parseFloat((valor.getText())));
			
			exame.cadastrar(ex);
			lblMensagem.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
			lblMensagem.setText("Falha ao Cadastrar exame!");
			lblMensagem.setVisible(true);
		}
	}
	
	public void logOut(ActionEvent event) {
		try {
			Telas.telaLogin();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void voltar(ActionEvent event) {
		try {
			Telas.telaEntrarExame();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

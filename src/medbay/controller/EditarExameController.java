package medbay.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import medbay.model.bo.ExameBO;
import medbay.model.vo.ExameVO;
import medbay.view.Telas;

public class EditarExameController implements Initializable{
	@FXML private Label ideExame;
	@FXML private Label nomeExame;
	@FXML private Label valorExame;
	@FXML private Label lblMensagem;
	@FXML private TextField editarNome;
	@FXML private TextField editarValor;
	private static ExameVO recebeExame = new ExameVO();
	ExameBO<ExameVO> bo = new ExameBO<ExameVO>();
	
	public void initialize(URL url, ResourceBundle rb) {
		ideExame.setText(Integer.toString(recebeExame.getId()));
		nomeExame.setText(recebeExame.getNome());
		valorExame.setText(Float.toString(recebeExame.getValor()));
	}
	
	public void editar(ActionEvent event){
		try {
			ExameVO vo = new ExameVO();
			vo.setId(recebeExame.getId());
			vo.setNome(editarNome.getText());
			vo.setValor(Float.parseFloat(editarValor.getText()));
			bo.editar(vo);
			lblMensagem.setText("Edição feita com sucesso!");
			lblMensagem.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
			lblMensagem.setText("Falha ao editar, verifique as informações");
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
	
	public static ExameVO getRecebeExame() {
		return recebeExame;
	}


	public static void setRecebeExame(ExameVO recebeExame) {
		EditarExameController.recebeExame = recebeExame;
	}
}

package medbay.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import medbay.model.bo.ConsultaBO;
import medbay.model.bo.ProntuarioBO;
import medbay.model.vo.ConsultaVO;
import medbay.model.vo.ProntuarioVO;
import medbay.view.Telas;

public class EditarProntuarioController implements Initializable{
	@FXML private TextArea observacao;
	@FXML private Label lblMensagem;
	private static ConsultaVO consulta = new ConsultaVO();
	ProntuarioVO prontuario = new ProntuarioVO();
	ProntuarioBO boProntuario = new ProntuarioBO();
	ConsultaBO boConsulta = new ConsultaBO();
	
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	public void cadastrar(ActionEvent event){
		try {
			prontuario.setExame(consulta.getExame());
			prontuario.setObservacao(observacao.getText());
			boProntuario.editar(prontuario);
			boConsulta.excluir(consulta);
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
	
	public void voltar(ActionEvent event) {
		try {
			//fazer um if pra voltar para a tela certa
			Telas.telaInicioMedico();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ConsultaVO getConsulta() {
		return consulta;
	}

	public static void setConsulta(ConsultaVO cons) {
		consulta = cons;
	}
}
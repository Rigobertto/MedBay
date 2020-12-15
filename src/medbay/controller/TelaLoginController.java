package medbay.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import medbay.model.bo.UsuarioBO;
import medbay.model.vo.UsuarioVO;
import medbay.view.Telas;

public class TelaLoginController {
	@FXML private TextField login;
	@FXML private TextField senha;
	@FXML private Label erroAut;
	
	UsuarioBO usuBO = new UsuarioBO();
	
	UsuarioVO vo = new UsuarioVO();
	
	public void autenticar(ActionEvent event) {
		UsuarioVO vo = new UsuarioVO();
		vo.setLogin(login.getText());
		vo.setSenha(senha.getText());
		vo = usuBO.autenticar(vo);
		//private ListarPacienteController num = new ListarPacienteController();
		//num.setNum(vo.getTabela());
		try {
			//UsuarioVO user = new UsuarioVO();
			//user = usuBO.autenticar(vo);
			if(vo.getTabela() == 1) {
				ListarPacienteController.setUser(vo);
				Telas.telaInicioGerente();
			}else if(vo.getTabela() == 2) {
				//PrincipalAtendenteController.setUser(vo);
				Telas.telaInicioAtendente();
			}else if(vo.getTabela() == 3) {
				PrincipalMedicoController.setUser(vo);
				Telas.telaInicioMedico();
			}else {
				erroAut.setVisible(true);
			}
		}catch(Exception e){
			erroAut.setVisible(true);
			e.printStackTrace();
		}
	}
}

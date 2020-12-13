package medbay.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import medbay.model.bo.AtendenteBO;
import medbay.model.bo.MedicoBO;
import medbay.model.vo.AtendenteVO;
import medbay.model.vo.MedicoVO;
import medbay.model.vo.UsuarioVO;
import medbay.view.Telas;

public class EditarAtendenteMedicoController implements Initializable{
	@FXML private Label cpf;
	@FXML private Label ide;
	@FXML private TextField editarNome;
	@FXML private TextField editarIdade;
	@FXML private TextField editarLogin;
	@FXML private TextField editarSenha;
	@FXML private TextField editarEspecialidade;
	@FXML private Label lblMensagemAtendente;
	@FXML private Label lblMensagemMedico;
	@FXML private ComboBox<String> editarGenero;
	private ObservableList<String> generoCategorias;
	private List<String> generos = new ArrayList<>();
	AtendenteBO bo = new AtendenteBO();
	//private static AtendenteVO atendente = new AtendenteVO();
	MedicoBO boMed = new MedicoBO();
	//private static MedicoVO medico = new MedicoVO();
	private static UsuarioVO user = new UsuarioVO();
	
	public void initialize(URL url, ResourceBundle rb){
		carregarGenero();
		ide.setText(Integer.toString(user.getId()));
		cpf.setText(user.getCpf());
		//editarNome.setPromptText(user.getNome());
		//editarIdade.setPromptText(Integer.toString(user.getIdade()));
		//editarLogin.setPromptText(user.getLogin());
	}
	
	public void editarA(ActionEvent event)throws Exception{
		try {
			AtendenteVO aten = new AtendenteVO();
			aten.setId(Integer.parseInt(ide.getText()));
			aten.setCpf(cpf.getText());
			aten.setNome(editarNome.getText());
			aten.setIdade(Integer.parseInt(editarIdade.getText()));
			if(editarGenero.getValue() == "Masculino") {
				aten.setGenero("M");
			}else if(editarGenero.getValue() == "Feminino") {
				aten.setGenero("F");
			}else{
				aten.setGenero("O");
			}
			aten.setLogin(editarLogin.getText());
			aten.setSenha(editarSenha.getText());
			
			boolean valor = bo.editar(aten);
			if(valor == true)
				lblMensagemAtendente.setVisible(true);
			else {
				lblMensagemAtendente.setText("Erro ao editar!");
				lblMensagemAtendente.setVisible(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
			lblMensagemAtendente.setText("Falha ao editar Atendente!");
			lblMensagemAtendente.setVisible(true);
		}
	}
	
	public void editarM(ActionEvent event)throws Exception{
		try {
			MedicoVO med = new MedicoVO();
			med.setId(user.getId());
			med.setCpf(user.getCpf());
			med.setNome(editarNome.getText());
			med.setIdade(Integer.parseInt(editarIdade.getText()));
			if(editarGenero.getValue() == "Masculino") {
				med.setGenero("M");
			}else if(editarGenero.getValue() == "Feminino") {
				med.setGenero("F");
			}else{
				med.setGenero("O");
			}
			med.setLogin(editarLogin.getText());
			med.setSenha(editarSenha.getText());
			med.setEspecialidade(editarEspecialidade.getText());
			boolean valor = boMed.editar(med);
			if(valor == true)
				lblMensagemMedico.setVisible(true);
			else {
				lblMensagemMedico.setText("Erro ao editar Médico!");
				lblMensagemMedico.setVisible(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
			lblMensagemMedico.setText("Falha ao editar Medico!");
			lblMensagemMedico.setVisible(true);
		}
	}
	
	public void carregarGenero(){
		
		generos.add("Masculino");
		generos.add("Feminino");
		generos.add("Outro");
		generoCategorias = FXCollections.observableArrayList(generos);
		editarGenero.setItems(generoCategorias);
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
			Telas.telaInicioGerente();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static UsuarioVO getUsuario() {
		return user;
	}

	public static void setUsaurio(UsuarioVO vo) {
		user = vo;
	}

	

}

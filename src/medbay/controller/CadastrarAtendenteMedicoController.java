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
import medbay.view.Telas;

public class CadastrarAtendenteMedicoController implements Initializable{
	@FXML private TextField nome;
	@FXML private TextField cpf;
	@FXML private TextField idade;
	@FXML private TextField login;
	@FXML private TextField senha;
	@FXML private TextField especialidade;
	@FXML private TextField crm;
	@FXML private Label lblMensagem;
	@FXML private ComboBox<String> genero;
	private ObservableList<String> generoCategorias;
	private List<String> generos = new ArrayList<>();
	AtendenteBO bo = new AtendenteBO();
	MedicoBO boMed = new MedicoBO();
	public void cadastrarA(ActionEvent event)throws Exception{
		try {
			AtendenteVO aten = new AtendenteVO();
			aten.setNome(nome.getText());
			aten.setCpf(cpf.getText());
			aten.setIdade(Integer.parseInt(idade.getText()));
			if(genero.getValue() == "Masculino") {
				aten.setGenero("M");
			}else if(genero.getValue() == "Feminino") {
				aten.setGenero("F");
			}else{
				aten.setGenero("O");
			}
			aten.setLogin(login.getText());
			aten.setSenha(senha.getText());
			boolean valor = bo.cadastrar(aten);
			if(valor == true)
				lblMensagem.setVisible(true);
			else {
				lblMensagem.setText("Erro no cadastrar!");
				lblMensagem.setVisible(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
			lblMensagem.setText("Falha ao Cadastrar Atendente!");
			lblMensagem.setVisible(true);
		}
	}
	
	public void cadastrarM(ActionEvent event)throws Exception{
		try {
			MedicoVO med = new MedicoVO();
			med.setNome(nome.getText());
			med.setCpf(cpf.getText());
			med.setIdade(Integer.parseInt(idade.getText()));
			if(genero.getValue() == "Masculino") {
				med.setGenero("M");
			}else if(genero.getValue() == "Feminino") {
				med.setGenero("F");
			}else{
				med.setGenero("O");
			}
			med.setLogin(login.getText());
			med.setSenha(senha.getText());
			med.setEspecialidade(especialidade.getText());
			med.setCrm(crm.getText());
			boolean valor = boMed.cadastrar(med);
			if(valor == true)
				lblMensagem.setVisible(true);
			else {
				lblMensagem.setText("Erro no cadastrar!");
				lblMensagem.setVisible(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
			lblMensagem.setText("Falha ao Cadastrar Atendente!");
			lblMensagem.setVisible(true);
		}
	}
	
	public void initialize(URL url, ResourceBundle rb){
		carregarGenero();
	}
	public void carregarGenero(){
	
		generos.add("Masculino");
		generos.add("Feminino");
		generos.add("Outro");
		generoCategorias = FXCollections.observableArrayList(generos);
		genero.setItems(generoCategorias);
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
	
}

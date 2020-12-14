package medbay.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Telas extends Application{
	private static Stage primaryStage;
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	
	public static void main(String [] args){
		launch();
	}
	//Metodo Start
	@Override
	public void start(Stage primaryStage) throws Exception{
		setPrimaryStage(primaryStage);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Projeto MedBay");
		primaryStage.show();
		telaLogin();
		
	}
	
	//Metodo TelaLogin
	public static void telaLogin() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/TelaLogin.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	//Metodo Tela Principal Gerente
	public static void telaInicioGerente() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/PrincipalGerente.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaInicioAtendente() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/PrincipalAtendente.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaInicioMedico() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/PrincipalMedico.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	//Metodo tela para entra em Atendente
	public static void telaEntrarAtendente() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/ListarAtendente.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	//Metodo tela para entrar em Medico
	public static void telaEntrarMedico() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/ListarMedico.fxml")); //Medico
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	//Metodo tela para entrar em Paciente
	public static void telaEntrarPaciente() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/ListarPaciente.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	//Metodo tela para entrar em Exame
	public static void telaEntrarExame() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/ListarExame.fxml"));
		Scene cena = new Scene(root); 
		primaryStage.setScene(cena);
	}
	
	//Metodo tela para cadastrar Exame
	public static void telaCadastrarExame() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/CadastrarExame.fxml"));
		Scene cena = new Scene(root); 
		primaryStage.setScene(cena);
	}
	
	//Metodo tela para cadastrar Medico e Atendente
	public static void telaCadastrarAtendenteMedico() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/CadastrarAtendenteMedico.fxml"));
		Scene cena = new Scene(root); 
		primaryStage.setScene(cena);
	}
	
	//Metodo tela para cadastrar Paciente
	public static void telaCadastrarPaciente() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/CadastrarPaciente.fxml"));
		Scene cena = new Scene(root); 
		primaryStage.setScene(cena);
	}
	
	public static void telaEntrarConsulta() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/ListarConsulta.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaCadastrarConsulta() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/CadastrarConsulta.fxml"));
		Scene cena = new Scene(root); 
		primaryStage.setScene(cena);
	}
	
	public static void telaEditarProntuario() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/EditarProntuario.fxml"));
		Scene cena = new Scene(root); 
		primaryStage.setScene(cena);
	}
	
	public static void telaEditarExame() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/EditarExame.fxml"));
		Scene cena = new Scene(root); 
		primaryStage.setScene(cena);
	}
	
	public static void telaEditarAtendenteMedico() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/EditarAtendenteMedico.fxml"));
		Scene cena = new Scene(root); 
		primaryStage.setScene(cena);
	}
	
	public static void telaEditarPaciente() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/EditarPaciente.fxml"));
		Scene cena = new Scene(root); 
		primaryStage.setScene(cena);
	}
	
	public static void telaEntrarProntuario() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/VisualizarProntuario.fxml"));
		Scene cena = new Scene(root); 
		primaryStage.setScene(cena);
	}
	
//	public static void telaEntrarConsulta() throws Exception{
//		Parent root = FXMLLoader.load(Telas.class.getResource("telas/VisualizarProntuario.fxml"));
//		Scene cena = new Scene(root); 
//		primaryStage.setScene(cena);
//	}
}
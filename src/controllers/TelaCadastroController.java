package controllers;

import java.io.IOException;
import java.sql.SQLException;

import dao.DaoPessoa;
import fp.Pessoa;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaCadastroController {
	
	@FXML
	private BorderPane raizTelaCadastro;
	
	@FXML
	private TextField textFieldNome;
	
	@FXML
	private TextField textFieldReceita;
	
	@FXML
	private TextField textFieldValorReceita;
	
	public void clickCadastrar() throws IOException{
		
		String nome = textFieldNome.getText().trim();
		String receita = textFieldReceita.getText();
		double valorReceita = Double.parseDouble( textFieldValorReceita.getText() );
		
		Pessoa pessoa = new Pessoa(nome, receita, valorReceita);
		
		DaoPessoa daoPessoa = new DaoPessoa();
		
		try {
			daoPessoa.inserir(pessoa);		
			clickCancelar();
		} catch (SQLException e) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Atenção");
			alert.setContentText("Erro ao cadastrar: " + e.getMessage());
			alert.show();
		}
	}
	public void clickCancelar() throws IOException {
		
		BorderPane fxml = new FXMLLoader(getClass().getResource("/views/TelaListar.fxml")).load();
		
		Scene cena = new Scene(fxml);
		
		Stage stage = (Stage) raizTelaCadastro.getScene().getWindow();
		
		stage.setScene(cena);
	}
}
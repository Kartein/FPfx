package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import dao.DaoPessoa;
import fp.Pessoa;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaListarController implements Initializable{
	
	@FXML
	private BorderPane raizTelaListar;
	
	@FXML
	private TableView<Pessoa> tabelaPessoas;
	
	@FXML
	private TableColumn<Pessoa, Integer> colunaID;
	
	@FXML
	private TableColumn<Pessoa, String> colunaNome;
	
	@FXML
	private TableColumn<Pessoa, String> colunaReceita;
	
	@FXML
	private TableColumn<Pessoa, String> colunaValorReceita;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		colunaID.setCellValueFactory( new PropertyValueFactory<>("id") );
		colunaNome.setCellValueFactory( new PropertyValueFactory<>("nome") );
		colunaReceita.setCellValueFactory( new PropertyValueFactory<>("receita") );
		colunaValorReceita.setCellValueFactory( new PropertyValueFactory<>("valorReceita") );
		
		DaoPessoa daoPessoa = new DaoPessoa();
		
		try {
			List<Pessoa> pessoas = daoPessoa.buscarTodos();
			
			tabelaPessoas.setItems( FXCollections.observableArrayList( pessoas ) ); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void clickCadastrar() throws IOException {
		
		BorderPane fxml = new FXMLLoader(getClass().getResource("/views/TelaCadastro.fxml")).load();
		
		Scene cena = new Scene(fxml);
		
		Stage stage = (Stage) raizTelaListar.getScene().getWindow();
		
		stage.setScene(cena);
	}
}
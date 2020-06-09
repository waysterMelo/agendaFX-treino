package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_tela_principal  implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemContato.setGraphic(new ImageView("/main/menuItemContact.png"));
        itemTipoContato.setGraphic(new ImageView("/main/tipoContact.png"));
        itemCidade.setGraphic(new ImageView("/main/item_city_menu.png"));
        itemUsers.setGraphic(new ImageView("/main/item_usermenu.png"));
        itemExit.setGraphic(new ImageView("/main/exit_menu.png"));

        menuRelatorios.setGraphic(new ImageView("/main/relatorio.png"));
        item_contatosGeral.setGraphic(new ImageView("/main/item_relatorio.png"));
        item_contatosEndereco.setGraphic(new ImageView("/main/item_relatorio.png"));
        item_contatosTel.setGraphic(new ImageView("/main/item_relatorio.png"));
        item_contatos_tipos.setGraphic(new ImageView("/main/item_relatorio.png"));
        menuArquivo.setGraphic(new ImageView("/main/arquivo_menuItem.png"));
    }

    @FXML
    private AnchorPane root;

    @FXML
    private MenuBar barraDeMenu;

    @FXML
    private Menu menuArquivo;

    @FXML
    private MenuItem itemContato;

    @FXML
    private MenuItem itemTipoContato;

    @FXML
    private MenuItem itemCidade;

    @FXML
    private MenuItem itemUsers;

    @FXML
    private MenuItem itemExit;

    @FXML
    private Menu menuRelatorios;

    @FXML
    private MenuItem item_contatosGeral;

    @FXML
    private MenuItem item_contatos_tipos;

    @FXML
    private MenuItem item_contatosTel;

    @FXML
    private MenuItem item_contatosEndereco;

    @FXML
    private Menu menuSobre;

    @FXML
    void acessarCidade(ActionEvent event) {
        abrirFormulario("form_cidade");
    }

    @FXML
    void acessarTipoContato(ActionEvent event) {
        abrirFormulario("tipoContatoController");
    }

    @FXML
    void acessarUsers(ActionEvent event) {
        abrirFormulario("form_user");
    }

    @FXML
    void acessar_contato(ActionEvent event) {
        abrirFormulario("form_contatos");
    }

    @FXML
    void rel_contatosEndereço(ActionEvent event) {

    }

    @FXML
    void rel_contatosGeral(ActionEvent event) {

    }

    @FXML
    void rel_contatosTel(ActionEvent event) {

    }

    @FXML
    void rel_contatosTipo(ActionEvent event) {

    }

    @FXML
    void sair_metodo(ActionEvent event) {
        Stage stage = (Stage)root.getScene().getWindow();
        stage.close();
    }

    public void abrirFormulario(String formulario){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/"+formulario+".fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Formulario");
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
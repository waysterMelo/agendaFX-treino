package controller;

import dao.cidadeDao;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.cidade;

public class cidade_controller  implements Initializable, Cadastro {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private TextField txtf_id;

    @FXML
    private TextField txf_user;

    @FXML
    private TextField txf_cep;

    @FXML
    private ComboBox<?> combobox_uf;

    @FXML
    private Button btn_new;

    @FXML
    private Button btn_save;

    @FXML
    private Button btn_remove;

    @FXML
    private TextField txtf_pesquisar;

    @FXML
    private TableView<?> tableview;

    @FXML
    void method_new(ActionEvent event) {

    }

    @FXML
    void method_remove(ActionEvent event) {

    }

    @FXML
    void method_save(ActionEvent event) {

    }

    @FXML
    void pesquisar(ActionEvent event) {

    }

    @Override
    public void criar_colunas_tabela() {

    }

    @Override
    public void atualizar_tabela() {

    }

    @Override
    public void set_campos_formularios() {

    }

    @Override
    public void limpar_campos_formularios() {

    }
}

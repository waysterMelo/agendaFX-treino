package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class form_contatos implements Initializable, Cadastro {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private TextField field_born;

    @FXML
    private TextField txtf_id;

    @FXML
    private TextField field_nome;

    @FXML
    private TextField field_address;

    @FXML
    private TextField field_n;

    @FXML
    private ComboBox<?> combo_city;

    @FXML
    private TextField field_uf;

    @FXML
    private TextField field_cep;

    @FXML
    private TextField field_tel1;

    @FXML
    private TextField field_tel2;

    @FXML
    private ComboBox<?> combo_tipoContato;

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

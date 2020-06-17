package controller;

import dao.tipo_contato_dao;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.tipoContato;
import util.Uf;


public class form_contatos implements Initializable, Cadastro {

    private final tipo_contato_dao dao_contato = new tipo_contato_dao();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titulo.setText("Formulário Contato");
        combo_uf.setItems(Uf.gerarUf());
        combo_tipoContato.setItems(dao_contato.combobox());
    }

    @FXML
    private Label titulo;

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
    private ComboBox<String> combo_uf;

    @FXML
    private TextField field_cep;

    @FXML
    private TextField field_tel1;

    @FXML
    private TextField field_tel2;

    @FXML
    private ComboBox<tipoContato> combo_tipoContato;

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

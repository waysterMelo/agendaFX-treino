package controller;

import dao.tipo_contato_dao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.tipoContato;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class tipoContatoController implements Initializable, Cadastro {


    private tipo_contato_dao tipoContatoDao = new tipo_contato_dao();
    private ObservableList<tipoContato> observableList = FXCollections.observableArrayList();
    private List<tipoContato> listaTipos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbl_titulo.setText("Formulário Tipo de Contato");
        criar_colunas_tabela();
        atualizar_tabela();
    }

    @FXML
    private Label lbl_titulo;

    @FXML
    private TextField txtf_id;

    @FXML
    private TextField txf_descricao;

    @FXML
    private Button btn_new;

    @FXML
    private Button btn_save;

    @FXML
    private Button btn_remove;

    @FXML
    private TextField txtf_pesquisar;

    @FXML
    private TableView<tipoContato> tableview;

    @FXML
    void method_new(ActionEvent event) {
        txf_descricao.setEditable(true);
    }

    @FXML
    void method_remove(ActionEvent event) {

    }

    @FXML
    void method_save(ActionEvent event) {
        tipoContato tipoContatoModel = new tipoContato();
        tipoContatoModel.setDescricao(txf_descricao.getText());
        tipoContatoDao.salvar(tipoContatoModel);
        txf_descricao.setEditable(false);
        atualizar_tabela();
    }

    @Override
    public void criar_colunas_tabela() {
        TableColumn<tipoContato, Long> id = new TableColumn<>("ID CONTATO");
        TableColumn<tipoContato, String> descricao = new TableColumn<>("DESCRIÇÃO");

        tableview.getColumns().addAll(id, descricao);
        id.setCellValueFactory(new PropertyValueFactory("id"));
        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

    }

    @Override
    public void atualizar_tabela() {
        observableList.clear();
        listaTipos = tipoContatoDao.consulta(txtf_pesquisar.getText());
        for (tipoContato t : listaTipos){
            observableList.add(t);
        }
        tableview.getItems().setAll(observableList);
        tableview.getSelectionModel().selectFirst();
    }

    @Override
    public void set_campos_formularios() {

    }

    @Override
    public void limpar_campos_formularios() {

    }

    public void filtrar_registro(javafx.scene.input.KeyEvent keyEvent) {
      atualizar_tabela();
    }
}

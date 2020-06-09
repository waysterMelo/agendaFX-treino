package controller;

import dao.tipo_contato_dao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.tipoContato;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class tipoContatoController implements Initializable, Cadastro {


    private tipo_contato_dao tipoContatoDao = new tipo_contato_dao();
    private ObservableList<tipoContato> observableList = FXCollections.observableArrayList();
    private List<tipoContato> listaTipos;
    private tipoContato objetoSelecionado = new tipoContato();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbl_titulo.setText("Formulário Tipo de Contato");
        criar_colunas_tabela();
        atualizar_tabela();
        set_campos_formularios();
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
        limpar_campos_formularios();
    }

    @FXML
    void method_remove(ActionEvent event) {
        tipoContatoDao.excluir(objetoSelecionado);
        limpar_campos_formularios();
        atualizar_tabela();
    }

    @FXML
    void movertabela(KeyEvent event) {
    set_campos_formularios();
    }

    @FXML
    void method_save(ActionEvent event) {
        tipoContato tipoContatoModel = new tipoContato();

        if (Long.valueOf(objetoSelecionado.getId()) != null){
                    tipoContatoModel.setId(objetoSelecionado.getId());
            }
        tipoContatoModel.setDescricao(txf_descricao.getText());
        tipoContatoDao.salvar(tipoContatoModel);
        atualizar_tabela();
        limpar_campos_formularios();
    }

    @Override
    public void criar_colunas_tabela() {
        TableColumn<tipoContato, Long> id = new TableColumn<>("ID CONTATO");
            id.setMinWidth(150);
            id.setMaxWidth(150);

        TableColumn<tipoContato, String> descricao = new TableColumn<>("DESCRIÇÃO");

        tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

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
        objetoSelecionado = tableview.getItems()
                .get(tableview.getSelectionModel().getSelectedIndex());
        txf_descricao.setText(objetoSelecionado.getDescricao());
        txf_descricao.setEditable(true);
        txtf_id.setText(String.valueOf(objetoSelecionado.getId()));
    }

    @FXML
    void clicarTabela(MouseEvent event) {
        set_campos_formularios();
    }

    @Override
    public void limpar_campos_formularios() {
        objetoSelecionado = null;
        txtf_id.clear();
        txf_descricao.clear();
        txf_descricao.requestFocus();
        txf_descricao.setEditable(true);
    }

    public void filtrar_registro(KeyEvent keyEvent) {
      atualizar_tabela();
    }

}

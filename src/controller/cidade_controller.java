package controller;

import dao.combo_box_generic;
import dao.crud_dao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.cidade;
import util.Alerta;
import util.Uf;

public class cidade_controller  implements Initializable, Cadastro {

    Uf comboUf = new Uf();
    private crud_dao<cidade> cidadecrud_dao = new crud_dao<>();
    private ObservableList<cidade> cidadeObservableList = FXCollections.observableArrayList();
    private List<cidade> cidadeList;
    cidade model = new cidade();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titulo.setText("Formulário Cidades");
        combobox_uf.setItems(Uf.gerarUf());
        atualizar_tabela();
        criar_colunas_tabela();
        set_campos_formularios();

    }

    @FXML
    private TextField txtf_id;

    @FXML
    private TextField txf_user;

    @FXML
    private TextField txf_cep;

    @FXML
    private ComboBox<String> combobox_uf;

    @FXML
    private Button btn_new;

    @FXML
    private Button btn_save;

    @FXML
    private Button btn_remove;

    @FXML
    private TextField txtf_pesquisar;

    @FXML
    private TableView<cidade> tableview;

    @FXML
    private Label titulo;


    @FXML
    void method_new(ActionEvent event) {
        txf_user.clear();
        txf_cep.clear();
        txtf_id.clear();
    }

    @FXML
    void method_remove(ActionEvent event) {
            if (Alerta.msgExclusao(txf_user.getText())){
                cidadecrud_dao.excluir(model);
            }
            limpar_campos_formularios();
            atualizar_tabela();
    }

    @FXML
    void method_save(ActionEvent event) {
        cidade cidadeModel = new cidade();

       if ( model != null) {
           cidadeModel.setId(model.getId());
       }

        cidadeModel.setDescricao(txf_user.getText());
        cidadeModel.setCep(Long.valueOf(txf_cep.getText()));
        cidadeModel.setUf(combobox_uf.getValue());

        if (cidadecrud_dao.salvar(cidadeModel)) {
            Alerta.msgInfo("Cidade inserida com sucesso!");
        }else {
            Alerta.msgInfo("Cidade nao inserida!");
        }
        atualizar_tabela();
            limpar_campos_formularios();
    }

    @Override
    public void criar_colunas_tabela() {
        TableColumn<cidade, Long> idColumn = new TableColumn<>("ID CIDADE");
        TableColumn<cidade, String> descricao = new TableColumn<>("DESCRIÇÃO");
        TableColumn<cidade, Long> cep = new TableColumn<>("CEP");
        TableColumn<cidade, String> uf = new TableColumn<>("UF");

        tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tableview.getColumns().addAll(idColumn, descricao, cep, uf);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        cep.setCellValueFactory(new PropertyValueFactory<>("cep"));
        uf.setCellValueFactory(new PropertyValueFactory<>("uf"));

    }

    @Override
    public void atualizar_tabela() {
        cidadeObservableList.clear();
        cidadeList = cidadecrud_dao.consulta(txtf_pesquisar.getText(), "cidade");
        cidadeObservableList.addAll(cidadeList);

        tableview.getItems().setAll(cidadeObservableList);
        tableview.getSelectionModel().selectFirst();
    }

    @FXML
    void clicar_tabela(MouseEvent event) {
        set_campos_formularios();
    }

    @Override
    public void set_campos_formularios() {
        model = tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
        txtf_id.setText(String.valueOf(model.getId()));
        txf_user.setText(model.getDescricao());
        txf_cep.setText(String.valueOf(model.getCep()));
        combobox_uf.setValue(model.getUf());
        txtf_id.setEditable(false);
    }

    @Override
    public void limpar_campos_formularios() {
        txtf_id.clear();
        txf_user.clear();
        txf_cep.clear();
    }

    public void filtrar_registro(KeyEvent keyEvent) {
        atualizar_tabela();
    }


    @FXML
    void movert_tabela(KeyEvent event) {
        set_campos_formularios();
    }

}

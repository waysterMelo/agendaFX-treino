package controller;


import dao.combo_box_generic;
import dao.crud_dao;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.cidade;
import model.contato;
import model.tipoContato;
import util.Alerta;
import util.Uf;


public class form_contatos implements Initializable, Cadastro {

    private final combo_box_generic<tipoContato> daoCombo = new combo_box_generic();
    private combo_box_generic<cidade> cidadeDao = new combo_box_generic();
    private crud_dao<contato> contatocrud_dao = new crud_dao<>();
    private contato modelContato = new contato();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titulo.setText("Formulário Contato");
        combo_uf.setItems(Uf.gerarUf());
        combo_tipoContato.setItems(daoCombo.combobox("tipoContato"));
        combo_city.setItems(cidadeDao.combobox("cidade"));
    }

    @FXML
    private Label titulo;

    @FXML
    private DatePicker field_born;

    @FXML
    private TextField txtf_id;

    @FXML
    private TextField field_nome;

    @FXML
    private TextField field_address;

    @FXML
    private TextField field_n;

    @FXML
    private ComboBox<cidade> combo_city;

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
            limpar_campos_formularios();
    }

    @FXML
    void method_remove(ActionEvent event) {

    }

    @FXML
    void method_save(ActionEvent event) {
    //    modelContato.setId(txtf_id.getId());
    cidade modelCidade = new cidade();
    modelContato.setDescricao(field_nome.getText());
    modelContato.setIdCidade(combo_city.getValue());
    modelContato.setEndereco(field_address.getText());
    modelContato.setIdTipoContato(combo_tipoContato.getValue());
    modelContato.setNascimento(LocalDate.EPOCH);
    modelContato.setTel1(Long.valueOf(field_tel1.getText()));
    modelContato.setTel2(Long.valueOf(field_tel2.getText()));
    modelContato.setNumero(Integer.valueOf(field_n.getText()));

    if (contatocrud_dao.salvar(modelContato)){
        Alerta.msgInfo("Contato Inserido com sucesso");
    }else {
        Alerta.msgInfo("Contato não inserido!");
    }

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
        field_n.clear();
        field_n.setEditable(true);

        field_nome.clear();
        field_nome.setEditable(true);

        field_address.clear();
        field_address.setEditable(true);

        field_born.setEditable(true);

        field_cep.clear();
        field_cep.setEditable(true);

        field_tel1.clear();
        field_tel1.setEditable(true);

        field_tel2.clear();
        field_tel2.setEditable(true);
    }
}

package controller;


import dao.combo_box_generic;
import dao.crud_dao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.cidade;
import model.contato;
import model.tipoContato;
import util.Alerta;
import util.Uf;


public class form_contatos implements Initializable, Cadastro {

    private final combo_box_generic<tipoContato> tipoContatocombo_box_generic = new combo_box_generic();
    private combo_box_generic<cidade> cidadecombo_box_generic = new combo_box_generic();
    private crud_dao<contato> contatocrud_dao = new crud_dao<>();
    private contato modelContato = new contato();
    private ObservableList<contato> observableList = FXCollections.observableArrayList();
    private List<contato> list;

    @FXML
    private TextField field_email;

    @FXML
    private RadioButton radio_female;

    @FXML
    private ToggleGroup sexo;

    @FXML
    private RadioButton masc_female;

    @FXML
    private CheckBox checkbox_ativo;

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
    private TextField field_uf;

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
    private TableView<contato> tableview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titulo.setText("Formulário Contato");
        combo_tipoContato.setItems(tipoContatocombo_box_generic.combobox("tipoContato"));
        combo_city.setItems(cidadecombo_box_generic.combobox("cidade"));
        criar_colunas_tabela();
        atualizar_tabela();
        set_campos_formularios();
        combo_city.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                field_uf.setText(combo_city.getSelectionModel().getSelectedItem().getUf());
                field_cep.setText(String.valueOf(combo_city.getSelectionModel().getSelectedItem().getCep()));
                field_uf.setEditable(false);
                field_cep.setEditable(false);
            }
        });

    }

    @FXML
    void method_new(ActionEvent event) {
            limpar_campos_formularios();
    }

    @FXML
    void method_remove(ActionEvent event) {

    }

    @FXML
    void method_save(ActionEvent event) {
    contato contato = new contato();

    if (modelContato != null){
        contato.setId(modelContato.getId());
    }

    contato.setDescricao(field_nome.getText());
        contato.setIdCidade(combo_city.getSelectionModel().getSelectedItem());
        contato.setEndereco(field_address.getText());
        contato.setIdTipoContato(combo_tipoContato.getSelectionModel().getSelectedItem());
        LocalDate data = field_born.getValue();
        contato.setNascimento(data);
        contato.setTel1(Long.valueOf(field_tel1.getText()));
        contato.setTel2(Long.valueOf(field_tel2.getText()));
        contato.setNumero(Integer.parseInt(field_n.getText()));
        contato.setEmail(field_email.getText());

        if (checkbox_ativo.isSelected()){
                contato.setAtivo(true);
        }else {
            contato.setAtivo(false);
        }

        if (masc_female.isSelected()){
            contato.setSexo("M");
        }else {
            contato.setSexo("F");
        }

    if (contatocrud_dao.salvar(contato)){
        Alerta.msgInfo("Contato Inserido com sucesso");
        atualizar_tabela();
    }else {
        Alerta.msgInfo("Contato não inserido!");
    }
    }

    @Override
    public void criar_colunas_tabela() {
        TableColumn<contato, String> nomeColumn = new TableColumn<>("Nome");
        TableColumn<contato, String> emailColumn = new TableColumn<>("Email");
        TableColumn<contato, cidade> cidadeColumn = new TableColumn<>("Cidade");
        TableColumn<contato, String> telColumn = new TableColumn<>("Celular");

        tableview.getColumns().addAll(nomeColumn, emailColumn,cidadeColumn,telColumn);
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        cidadeColumn.setCellValueFactory(new PropertyValueFactory<>("idCidade"));
        telColumn.setCellValueFactory(new PropertyValueFactory<>("tel1"));

        tableview.setColumnResizePolicy(tableview.CONSTRAINED_RESIZE_POLICY);

    }

    @Override
    public void atualizar_tabela() {
        observableList.clear();

        list = contatocrud_dao.consulta(field_nome.getText(), "contato");

        observableList.addAll(list);

        tableview.getItems().setAll(observableList);
        tableview.getSelectionModel().selectFirst();
    }

    @Override
    public void set_campos_formularios() {
        if (!tableview.getItems().isEmpty()){
            modelContato = tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
            txtf_id.setText(String.valueOf(modelContato.getId()));
            field_nome.setText(modelContato.getDescricao());
            field_n.setText(String.valueOf(modelContato.getNumero()));
            field_tel1.setText(String.valueOf(modelContato.getTel1()));
            field_tel2.setText(String.valueOf(modelContato.getTel2()));
            field_address.setText(modelContato.getEndereco());
            field_email.setText(modelContato.getEmail());

            checkbox_ativo.setSelected(modelContato.isAtivo());

            if (modelContato.getSexo().equals("M")){
                masc_female.setSelected(true);
            }else{
                radio_female.setSelected(true);
            }

            field_born.setValue(modelContato.getNascimento());

//            tipoContato tipoContatoModel = new tipoContato();
//            tipoContatoModel.setId(modelContato.getIdTipoContato().getId());
//            tipoContatoModel.setDescricao(modelContato.getIdTipoContato().getDescricao());
//            combo_tipoContato.getSelectionModel().selectFirst();
//            combo_tipoContato.setValue(tipoContatoModel);

            cidade cidademodel = new cidade();
            cidademodel.setId(modelContato.getIdCidade().getId());
            cidademodel.setDescricao(modelContato.getIdCidade().getDescricao());
            cidademodel.setUf(modelContato.getIdCidade().getUf());
            cidademodel.setCep(modelContato.getIdCidade().getCep());
            combo_city.getSelectionModel().selectFirst();
            combo_city.setValue(cidademodel);
        }
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

    @FXML
    void clicartabela(MouseEvent event) {
        set_campos_formularios();
    }

    @FXML
    void filtrarTabela(KeyEvent event) {
    atualizar_tabela();
    }

}

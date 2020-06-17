package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Alerta {

    static ButtonType confirm = new ButtonType("Confirmar");
    static ButtonType cancel = new ButtonType("Cancelar");
    static boolean respostas;


    public static void msgInfo(String msg){
        Alert.AlertType alertAlertType;
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setHeaderText("Informaçoes sobre Cadastro");
        alerta.setContentText(msg);
        alerta.showAndWait();
    }

    public static boolean msgExclusao(String msg){
        Alert.AlertType alertAlertType;
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setHeaderText("Exclusão de Informações");
        alerta.getButtonTypes().setAll(confirm, cancel);
        alerta.setContentText(msg);
        alerta.showAndWait().ifPresent(b ->{
            if (b == confirm){
                    respostas = true;
            }else {
                respostas = false;
            }
        });
        return respostas;
    }

}

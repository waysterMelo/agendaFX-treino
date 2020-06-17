package util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Uf {

    private static ObservableList<String> observableList;

        public static ObservableList gerarUf(){
            observableList = FXCollections.observableArrayList(
                    "MG","SP","RJ","ES"
            );
        return observableList;
        };

}

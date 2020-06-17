package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.tipoContato;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class combo_box_generic<T> {

    ObservableList<T> observableList = FXCollections.observableArrayList();


    public ObservableList<T> combobox(String nomeClass){
        List<T> lista  = new ArrayList<>();
        Session session = database.getSessionFactory().openSession();
        session.beginTransaction();
        lista = session.createQuery("from " + nomeClass).getResultList();
        session.getTransaction().commit();
        session.close();

        observableList.addAll(lista);
        return observableList;
    }

}

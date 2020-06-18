package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.tipoContato;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class crud_dao<T> {

    ObservableList<T> observableList = FXCollections.observableArrayList();

    public boolean salvar(T tipo){
        try {
            Session session = database.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(tipo);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception erro){
            return false;
        }
    }

    public List<T> consulta(String descricao, String nomeClass){
        List<T> lista = new ArrayList<>();
        Session session = database.getSessionFactory().openSession();
        session.beginTransaction();

        if (descricao.length() == 0){
            lista = session.createQuery("from " + nomeClass).getResultList();
        }else {
            lista = session.createQuery("from "+ nomeClass +" t where t.descricao like " + "'"+descricao+"%'").getResultList();
        }

        session.getTransaction().commit();
        session.close();
        return lista;
    }

    public void excluir(T tipo){
        Session session = database.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(tipo);
        session.getTransaction().commit();
        session.close();
    }

    public ObservableList<T> combobox(){
        List<T> lista  = new ArrayList<>();
        Session session = database.getSessionFactory().openSession();
        session.beginTransaction();
        lista = session.createQuery("from tipoContato ").getResultList();
        session.getTransaction().commit();
        session.close();

        observableList.addAll(lista);
        return observableList;
    }
}

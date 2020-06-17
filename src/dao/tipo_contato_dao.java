package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.tipoContato;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class tipo_contato_dao {

    ObservableList<tipoContato> observableList = FXCollections.observableArrayList();

    public boolean salvar(tipoContato tipoContato){
       try {
           Session session = database.getSessionFactory().openSession();
           session.beginTransaction();
           session.merge(tipoContato);
           session.getTransaction().commit();
           session.close();
                return true;
       }catch (Exception erro){
            return false;
       }
    }

    public List<tipoContato> consulta(String descricao){
        List<tipoContato> lista = new ArrayList<>();
        Session session = database.getSessionFactory().openSession();
        session.beginTransaction();

            if (descricao.length() == 0){
                lista = session.createQuery("from tipoContato ").getResultList();
            }else {
                lista = session.createQuery("from tipoContato t where t.descricao like " + "'"+descricao+"%'").getResultList();
            }

        session.getTransaction().commit();
        session.close();
        return lista;
    }

    public void excluir(tipoContato tipocontato){
        Session session = database.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(tipocontato);
        session.getTransaction().commit();
        session.close();
    }

    public ObservableList<tipoContato> combobox(){
        List<tipoContato> lista  = new ArrayList<>();
        Session session = database.getSessionFactory().openSession();
        session.beginTransaction();
        lista = session.createQuery("from tipoContato ").getResultList();
        session.getTransaction().commit();
        session.close();

        observableList.addAll(lista);
        return observableList;
    }

}

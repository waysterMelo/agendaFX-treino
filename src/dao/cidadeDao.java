package dao;

import model.cidade;
import model.tipoContato;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class cidadeDao {

    public boolean salvar(cidade cidade){
      try {
          Session session = database.getSessionFactory().openSession();
          session.beginTransaction();
          session.merge(cidade);
          session.getTransaction().commit();
          session.close();
          return true;
      }catch (Exception e){
          return false;
      }
    }

    public List<cidade> consultar(String descricao){
        List<cidade> lista = new ArrayList<>();
        Session session = database.getSessionFactory().openSession();
        session.beginTransaction();
        if (descricao.length() == 0){
            lista = session.createQuery("from cidade ").getResultList();
        }else{
            lista = session.createQuery("from cidade c where c.descricao like " + "'" + descricao + "%'").getResultList();
        }
        session.getTransaction().commit();
        session.close();
        return lista;
    }

}

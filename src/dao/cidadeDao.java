package dao;

import model.cidade;
import org.hibernate.Session;

public class cidadeDao {

    public void salvar(cidade cidade){
      try {
          Session session = database.getSessionFactory().openSession();
          session.beginTransaction();
          session.merge(cidade);
          session.getTransaction().commit();
          session.close();
      }catch (Exception e){
          System.out.println("Erro ... " + e );
      }
    }
}

package dao;

import model.tipoContato;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class tipo_contato_dao {

    public void salvar(tipoContato tipoContato){
       try {
           Session session = database.getSessionFactory().openSession();
           session.beginTransaction();
           session.merge(tipoContato);
           session.getTransaction().commit();
           session.close();
           System.out.println("Registro inserido com sucesso");
       }catch (Exception erro){
           System.out.println("erro é " + erro);
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

}

package org.example.repository.genericRepository;

import org.example.utils.ConnectionApplication;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

import java.util.Collection;
import java.util.List;

public class GenericRepository<T, ID> {

  private final Class<T> entity;

  public GenericRepository(Class<T> entity) {
    this.entity = entity;
  }

  public void save(T entity) {
    Transaction transaction = null;
    try (Session session = ConnectionApplication.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      session.save(entity);
      transaction.commit();
    } catch (TransactionException e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
  }

  public void saveAll(Collection<T> collection) {
    Transaction transaction = null;
    try (Session session = ConnectionApplication.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      int batchSize = 20;
      int countBatches = 0;
      for (T entity : collection) {
        session.save(entity);
        if (++countBatches % batchSize == 0) {
          session.flush();
          session.clear();
        }
      }
      transaction.commit();
    } catch (TransactionException e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
  }

  public List<T> findAll(){
    try(Session session = ConnectionApplication.getSessionFactory().openSession()){
      return session.createQuery("from " + entity.getName(), entity).list();
    }
  }


}

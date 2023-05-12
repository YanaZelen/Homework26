package org.example.dao;

import org.example.entity.CafeTable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TableDaoHiber implements TableDao {

  @Autowired
  SessionFactory sessionFactory;

  @Transactional
  public void saveTable(int numberOfTable) {
    sessionFactory.getCurrentSession().save(new CafeTable(numberOfTable));
  }

  @Transactional
  public List<CafeTable> getAllTable() {
    TypedQuery<CafeTable> query = sessionFactory.getCurrentSession().createQuery("from CafeTable");
    return query.getResultList();
  }

  @Transactional
  public CafeTable getTableById(long id) {
    TypedQuery<CafeTable> query = sessionFactory.getCurrentSession().createQuery("from CafeTable where id = :id");
    query.setParameter("id", id);
    return query.getSingleResult();
  }
}

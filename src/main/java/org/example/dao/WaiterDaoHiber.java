package org.example.dao;

import java.util.List;
import org.example.entity.Waiter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

@Repository
public class WaiterDaoHiber implements WaiterDao {

  @Autowired
  SessionFactory sessionFactory;

  @Transactional
  public void saveWaiter(String name, String lastName) {
    sessionFactory.getCurrentSession().save(new Waiter(name, lastName));
  }

  @Transactional
  public List<Waiter> getAllWaiter() {
    TypedQuery<Waiter> query = sessionFactory.getCurrentSession().createQuery("from Waiter");
    return query.getResultList();
  }

  @Transactional
  public Waiter getWaiterById(long id) {
    TypedQuery<Waiter> query = sessionFactory.getCurrentSession().createQuery("from Waiter where id = :id");
    query.setParameter("id", id);
    return query.getSingleResult();
  }
}

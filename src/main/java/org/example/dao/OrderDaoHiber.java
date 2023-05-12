package org.example.dao;

import org.example.entity.CafeOrder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderDaoHiber implements OrderDao {

  @Autowired
  SessionFactory sessionFactory;

  @Transactional
  public void saveOrder(Integer numberOfOrder) {
    sessionFactory.getCurrentSession().save(new CafeOrder(numberOfOrder));
  }

  @Transactional
  public List<CafeOrder> getAllOrder() {
    TypedQuery<CafeOrder> query = sessionFactory.getCurrentSession().createQuery("from CafeOrder");
    return query.getResultList();
  }

  @Transactional
  public CafeOrder getOrderById(long id) {
    TypedQuery<CafeOrder> query = sessionFactory.getCurrentSession().createQuery("from CafeOrder where id = :id");
    query.setParameter("id", id);
    return query.getSingleResult();
  }
}

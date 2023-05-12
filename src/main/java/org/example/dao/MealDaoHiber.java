package org.example.dao;

import org.example.entity.Meal;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MealDaoHiber implements MealDao {

  @Autowired
  SessionFactory sessionFactory;

  @Transactional
  public void saveMeal(String name) {
    sessionFactory.getCurrentSession().save(new Meal(name));
  }

  @Transactional
  public List<Meal> getAllMeal() {
    TypedQuery<Meal> query = sessionFactory.getCurrentSession().createQuery("from Meal");
    return query.getResultList();
  }

  @Transactional
  public Meal getMealById(long id) {
    TypedQuery<Meal> query = sessionFactory.getCurrentSession().createQuery("from Meal where id = :id");
    query.setParameter("id", id);
    return query.getSingleResult();
  }
}

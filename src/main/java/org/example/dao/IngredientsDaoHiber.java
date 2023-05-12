package org.example.dao;

import org.example.dto.FoodType;
import org.example.entity.Ingredients;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class IngredientsDaoHiber implements IngredientsDao {

  @Autowired
  SessionFactory sessionFactory;

  @Transactional
  public void saveIngredients(String name, FoodType foodType, int calories) {
    sessionFactory.getCurrentSession().save(new Ingredients(name, foodType, calories));
  }

  @Transactional
  public List<Ingredients> getAllIngredients() {
    TypedQuery<Ingredients> query = sessionFactory.getCurrentSession().createQuery("from Ingredients");
    return query.getResultList();
  }

  @Transactional
  public Ingredients getIngredientsById(long id) {
    TypedQuery<Ingredients> query = sessionFactory.getCurrentSession().createQuery("from Ingredients where id = :id");
    query.setParameter("id", id);
    return query.getSingleResult();
  }
}

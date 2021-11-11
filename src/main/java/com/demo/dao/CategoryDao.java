package com.demo.dao;

import com.demo.entity.CategoryEntity;
import com.demo.entity.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CategoryDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public List<CategoryEntity> getAllCategory(){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<CategoryEntity> listCategory = em.createQuery("select p from CategoryEntity p").getResultList();
        em.getTransaction().commit();
        em.close();
        return listCategory;
    }
}

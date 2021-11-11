package com.demo.dao;

import com.demo.entity.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public List<ProductEntity> getAllProduct(){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<ProductEntity> listProduct = em.createQuery("select p from ProductEntity p").getResultList();
        em.getTransaction().commit();
        em.close();
        return listProduct;
    }

    public void insertProduct(ProductEntity product){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }
}

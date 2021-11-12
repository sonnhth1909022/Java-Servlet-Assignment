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

    public void insertCategory(CategoryEntity category){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
        em.close();
    }
    public  void deleteCategory(int id){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        CategoryEntity p = em.find(CategoryEntity.class, id);
        if (p != null) {
            em.remove(p);
        }
        em.getTransaction().commit();
        em.close();
    }
    public void updateCategory(CategoryEntity categoryEntity){
        em = emf.createEntityManager();
        em.getTransaction().begin();
      /*  CategoryEntity cUpdate = em.find(CategoryEntity.class, categoryEntity.getId());
        cUpdate.setName(categoryEntity.getName());*/
        em.merge(categoryEntity);
        em.getTransaction().commit();
        em.close();
    }
    public  CategoryEntity getCategory(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();

        CategoryEntity cUpdate = em.find(CategoryEntity.class, id);
        em.getTransaction().commit();

        return cUpdate;
    }
}

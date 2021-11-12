package com.demo.dao;

import com.demo.entity.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
    public void updateProduct(ProductEntity product){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        ProductEntity pUpdate = em.find(ProductEntity.class, product.getId());
        pUpdate.setName(product.getName());
        pUpdate.setPrice(product.getPrice());
        pUpdate.setQuantity(product.getQuantity());
        pUpdate.setCategoryid(product.getCategoryid());
        pUpdate.setImage(product.getImage());
        em.getTransaction().commit();
        em.close();
    }

    public  void deleteProduct(int id){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        ProductEntity p = em.find(ProductEntity.class, id);
        if (p != null) {
            em.remove(p);
        }
        em.getTransaction().commit();
        em.close();
    }

    public  ProductEntity getProduct(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();

        ProductEntity pUpdate = em.find(ProductEntity.class, id);
        em.getTransaction().commit();

        return pUpdate;
    }

    public ProductEntity getProductById(int id){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        ProductEntity product = em.find(ProductEntity.class, id);
        Query query = em.createQuery("select p from ProductEntity p where p.id = (:id)");
        query.setParameter("id", id);
        em.getTransaction().commit();
        em.close();
        return product;
    }

    public List<ProductEntity> getLsProductByCategoryId(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select p from ProductEntity p where p.categoryid = (:id)");
        query.setParameter("id", id);
        List<ProductEntity> lsProduct = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return lsProduct;
    }
}

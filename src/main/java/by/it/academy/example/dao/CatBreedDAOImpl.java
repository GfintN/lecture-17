package by.it.academy.example.dao;

import by.it.academy.example.pojo.CatBreed;
import by.it.academy.example.util.HibernateUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;

public class CatBreedDAOImpl implements AnimalBreedDAO<CatBreed>{
    private CatBreed cat;
    private EntityManager em;

    @Override
    public CatBreed sava(CatBreed pojo) {
        
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pojo);
            em.getTransaction().commit();
            return pojo;
        } catch (HibernateException ignore) {
            em.getTransaction().rollback();
            return null;
        }finally {
            em.close();
        }
    }

    @Override
    public CatBreed find(String nameBreed) {
        cat = new CatBreed();
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            cat = em.find(CatBreed.class, nameBreed);
            em.getTransaction().commit();
            return cat;
        } catch (HibernateException ignore){
            em.getTransaction().rollback();
            return null;
        }
        finally {
            em.close();
        }
    }

    @Override
    public CatBreed delete(String nameBreed) {
        cat = new CatBreed();
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            cat = em.find(CatBreed.class, nameBreed);
            em.remove(cat);
            em.getTransaction().commit();
            return cat;
        } catch (HibernateException ignore){
            em.getTransaction().rollback();
            return null;
        }
        finally {
            em.close();
        }
    }

    @Override
    public CatBreed update(CatBreed pojo) {
        ;
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            pojo = em.find(CatBreed.class, pojo.getBreed());
            em.merge(pojo);
            em.getTransaction().commit();
            return pojo;
        } catch (HibernateException ignore){
            em.getTransaction().rollback();
            return null;
        }
        finally {
            em.close();
        }
    }
}

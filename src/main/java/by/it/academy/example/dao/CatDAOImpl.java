package by.it.academy.example.dao;

import by.it.academy.example.pojo.Cat;
import by.it.academy.example.pojo.CatBreed;
import by.it.academy.example.util.HibernateUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;



public class CatDAOImpl implements AnimalDAO<Cat> {
    private Cat cat;
    private EntityManager em;

    @Override
    public Cat sava(Cat pojo) {
        
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cat);
            em.getTransaction().commit();
            return cat;
        } catch (HibernateException ignore) {
            em.getTransaction().rollback();
            return null;
        }finally {
            em.close();
        }
    }

    @Override
    public Cat find(int id) {
        cat = new Cat();
        em = HibernateUtil.getEntityManager();
        try {
        em.getTransaction().begin();
        cat = em.find(Cat.class, id);
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
    public Cat delete(int id) {
        cat = new Cat();
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            cat = em.find(Cat.class, id);
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
    public Cat update(Cat pojo) {
        
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            cat = em.find(Cat.class, cat.getId());
            em.merge(cat);
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
}

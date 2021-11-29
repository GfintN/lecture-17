package by.it.academy.example.dao;

import by.it.academy.example.pojo.Dog;
import by.it.academy.example.pojo.DogBreed;
import by.it.academy.example.util.HibernateUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;

public class DogDAOImpl implements AnimalDAO<Dog> {
    private Dog dog;
    private EntityManager em;

    @Override
    public Dog sava(Dog pojo) {
        
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
    public Dog find(int id) {
        dog = new Dog();
        try {
            em.getTransaction().begin();
            dog = em.find(Dog.class, id);
            em.getTransaction().commit();
            return dog;
        } catch (HibernateException ignore){
            em.getTransaction().rollback();
            return null;
        }
        finally {
            em.close();
        }
    }

    @Override
    public Dog delete(int id) {
        dog = new Dog();
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            dog = em.find(Dog.class, id);
            em.remove(dog);
            em.getTransaction().commit();
            return dog;
        } catch (HibernateException ignore){
            em.getTransaction().rollback();
            return null;
        }
        finally {
            em.close();
        }
    }

    @Override
    public Dog update(Dog pojo) {
       
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            pojo = em.find(Dog.class, pojo.getId());
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

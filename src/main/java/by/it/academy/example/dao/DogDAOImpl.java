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
        dog = new Dog();
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(dog);
            em.getTransaction().commit();
            return dog;
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
        dog = new Dog();
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            dog = em.find(Dog.class, dog.getId());
            em.merge(dog);
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
}

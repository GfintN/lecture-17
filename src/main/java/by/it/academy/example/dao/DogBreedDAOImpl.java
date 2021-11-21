package by.it.academy.example.dao;

import by.it.academy.example.pojo.CatBreed;
import by.it.academy.example.pojo.DogBreed;
import by.it.academy.example.util.HibernateUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;

public class DogBreedDAOImpl implements AnimalDAO<DogBreed>{
    private DogBreed dog;
    private EntityManager em;

    @Override
    public DogBreed sava(DogBreed pojo) {
        dog = new DogBreed();
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
    public DogBreed find(int id) {
        dog = new DogBreed();
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            dog = em.find(DogBreed.class, id);
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
    public DogBreed delete(int id) {
        dog = new DogBreed();
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            dog = em.find(DogBreed.class, id);
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
    public DogBreed update(DogBreed pojo) {
        dog = new DogBreed();
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            dog = em.find(DogBreed.class, dog.getId());
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

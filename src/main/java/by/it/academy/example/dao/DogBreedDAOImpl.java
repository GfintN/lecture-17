package by.it.academy.example.dao;

import by.it.academy.example.pojo.DogBreed;
import by.it.academy.example.util.HibernateUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;

public class DogBreedDAOImpl implements AnimalBreedDAO<DogBreed>{
    private DogBreed dog;
    private EntityManager em;

    @Override
    public DogBreed sava(DogBreed pojo) {
       
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
    public DogBreed find(String nameBreed) {
        dog = new DogBreed();
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            dog = em.find(DogBreed.class, nameBreed);
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
    public DogBreed delete(String nameBreed) {
        dog = new DogBreed();
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            dog = em.find(DogBreed.class, nameBreed);
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
        
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
           pojo = em.find(DogBreed.class, pojo.getBreed());
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

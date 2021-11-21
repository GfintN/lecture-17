package by.it.academy.example;

import by.it.academy.example.util.HibernateUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.persistence.EntityManager;


public class HibernateUtilTest {

    @Test
    void notNull(){
        EntityManager em = HibernateUtil.getEntityManager();
        Assertions.assertAll(
                () -> Assertions.assertNotNull(em),
                () ->  {HibernateUtil.close();
                Assertions.assertNull(em);
                    if (em != null) {
                        em.close();
                    }
                }
        );
    }
}

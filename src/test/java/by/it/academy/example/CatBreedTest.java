package by.it.academy.example;

import by.it.academy.example.dao.AnimalDAO;
import by.it.academy.example.dao.CatBreedDAOImpl;
import by.it.academy.example.pojo.CatBreed;
import by.it.academy.example.util.HibernateUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class CatBreedTest {
    AnimalDAO dao;
    CatBreed cat;

    @BeforeEach
    void initAnimalDAO(){
        dao = mock(CatBreedDAOImpl.class);
        cat = mock(CatBreed.class);
    }

    @Test
    void saveTest() {
        Assertions.assertDoesNotThrow(()->{dao.sava(cat);});
    }

    @Test
    void findTest() {
        Assertions.assertDoesNotThrow(()->{dao.find(1);});
    }

    @Test
    void deleteTest() {
        Assertions.assertDoesNotThrow(()->{dao.delete(1);});
    }

    @Test
    void updateTest() {
        Assertions.assertDoesNotThrow(()->{dao.update(cat);});
    }

    @AfterAll
    static void cleanUp() {
        HibernateUtil.close();
    }
}

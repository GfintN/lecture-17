package by.it.academy.example;

import by.it.academy.example.dao.AnimalBreedDAO;
import by.it.academy.example.dao.CatBreedDAOImpl;
import by.it.academy.example.pojo.CatBreed;
import by.it.academy.example.util.HibernateUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class CatBreedTest {
    AnimalBreedDAO dao;
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
        Assertions.assertDoesNotThrow(()->{dao.find("");});
    }

    @Test
    void deleteTest() {
        Assertions.assertDoesNotThrow(()->{dao.delete("");});
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

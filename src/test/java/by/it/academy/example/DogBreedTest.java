package by.it.academy.example;

import by.it.academy.example.dao.AnimalBreedDAO;
import by.it.academy.example.dao.DogBreedDAOImpl;
import by.it.academy.example.pojo.DogBreed;
import by.it.academy.example.util.HibernateUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class DogBreedTest {
    AnimalBreedDAO dao;
    DogBreed dog;

    @BeforeEach
    void initAnimalDAO(){
        dao = mock(DogBreedDAOImpl.class);
        dog = mock(DogBreed.class);
    }

    @Test
    void saveTest() {
        Assertions.assertDoesNotThrow(()->{dao.sava(dog);});
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
        Assertions.assertDoesNotThrow(()->{dao.update(dog);});
    }

    @AfterAll
    static void cleanUp() {
        HibernateUtil.close();
    }
}

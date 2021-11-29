package by.it.academy.example.dao;

public interface AnimalBreedDAO <T>{
    T sava (T pojo);
    T find(String nameBreed);
    T delete(String nameBreed);
    T update(T pojo);
}


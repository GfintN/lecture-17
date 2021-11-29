package by.it.academy.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dogs_breeds")
@Entity
public class DogBreed {
    @Id
    @Column(nullable = false)
    private String breed;
}

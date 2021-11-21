package by.it.academy.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cats_breeds")
@Entity
public class CatBreed {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String breed;
}

package by.it.academy.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dogs")
@Entity
public class Dog implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String breed;
}

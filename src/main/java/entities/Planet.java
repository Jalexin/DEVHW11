package entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "planet")
@Data
public class Planet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", length = 500, nullable = false)
    private String name;

}
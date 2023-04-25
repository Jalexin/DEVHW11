package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @ManyToMany(mappedBy = "from", cascade = CascadeType.ALL)
    private List<Ticket> ticketsFrom;

    @ManyToMany(mappedBy = "to", cascade = CascadeType.ALL)
    private List<Ticket> ticketsTo;
}

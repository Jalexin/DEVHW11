package entities;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "client")
@Data
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets;
}

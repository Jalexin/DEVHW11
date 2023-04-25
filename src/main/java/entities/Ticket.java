package entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "from_planet_id", referencedColumnName = "id", nullable = false)
    private Planet from;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", referencedColumnName = "id", nullable = false)
    private Planet to;
}
package Utils;
import entities.Client;
import entities.Planet;
import entities.Ticket;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HU {
    private static final HU INSTANCE;
    @Getter
    private SessionFactory sessionFactory;
    static {
        INSTANCE = new HU();
    }
    private HU() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }
    public static HU getInstance() {
        return INSTANCE;
    }
    public void close() {
        sessionFactory.close();
    }
}

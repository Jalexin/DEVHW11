import org.flywaydb.core.Flyway;
public class DBInitService {
    public void initDB() {
        String connectionUrl = "jdbc:h2:./test2";
        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, null, null)
                .load();
        flyway.migrate();
    }
}
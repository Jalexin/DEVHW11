package entities;
import Utils.HU;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ClientCrudService {

    public void addClient(Client client) {
        Session session = HU.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
        session.close();
    }
    public Client getClientById(long id) {
        Session session = HU.getInstance().getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }
    public void updateClientById(long id, String name) {
        Session session = HU.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String updateQuery = "update Client set name = :name where id = :id";
        Query query = session.createQuery(updateQuery);
        query.setParameter("name", name);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
    public void deleteClientById(long id) {
        Session session = HU.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String deleteQuery = "delete from Client where id = :id";
        Query query = session.createQuery(deleteQuery);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}

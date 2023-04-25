package entities;

import Utils.HU;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TicketCrudService {
    public void addTicket(Client client, Planet toPlanet, Planet fromPlanet) {
        if (client != null && toPlanet != null && fromPlanet != null) {
            Session session = HU.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Ticket ticket = new Ticket();
            ticket.setClient(client);
            ticket.setFrom(fromPlanet);
            ticket.setTo(toPlanet);
            session.persist(ticket);
            transaction.commit();
            session.close();
        }
    }
    public void updateTicketById(long id, Client client, Planet toPlanet, Planet fromPlanet) {
        Session session = HU.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        ticket.setClient(client);
        ticket.setTo(toPlanet);
        ticket.setFrom(fromPlanet);
        session.persist(ticket);
        transaction.commit();
        session.close();
    }
    public Ticket getById(long id) {
        Ticket ticket;
        Session session = HU.getInstance().getSessionFactory().openSession();
        ticket = session.get(Ticket.class, id);
        session.close();
        return ticket;
    }
    public void deleteTicketById(long id) {
        Session session = HU.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String deleteQuery = "DELETE FROM Ticket WHERE id = :id";
        Query query = session.createQuery(deleteQuery);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
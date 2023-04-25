package entities;

import Utils.HU;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PlanetCrudService {
    public void addPlanet(Planet planet) {
        if (planet.getId().matches("^[A-Z0-9]+$")) {
            Session session = HU.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
            session.close();
        } else {
            System.out.println("Name is invalid!");
        }
    }
    public Planet getPlanetById(String id) {
        Planet planet;
        Session session = HU.getInstance().getSessionFactory().openSession();
        planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }
    public void updatePlanetById(String id, String name) {
        Session session = HU.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String updateQuery = "UPDATE Planet SET name = :name WHERE id = :id";
        Query query = session.createQuery(updateQuery);
        query.setParameter("name", name);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
    public void deletePlanetById(String id) {
        Session session = HU.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String deleteQuery = "DELETE FROM Planet WHERE id = :id";
        Query query = session.createQuery(deleteQuery);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

}
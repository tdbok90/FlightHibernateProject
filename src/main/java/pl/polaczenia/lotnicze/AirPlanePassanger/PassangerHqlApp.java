package pl.polaczenia.lotnicze.AirPlanePassanger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.polaczenia.lotnicze.entity.AirPlane;
import pl.polaczenia.lotnicze.entity.Passenger;

public class PassangerHqlApp {
    public static void main(String[] args) {
        // stworzenie obiektu Configuration
        Configuration conf = new Configuration();
        // wczytanie pliku konfiguracyjnego
        conf.configure("hibernate.cfg.xml");
        // wczytanie adnotacji
        conf.addAnnotatedClass(AirPlane.class);
        conf.addAnnotatedClass(Passenger.class);
        // stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        // pobranie sesji
        Session session = factory.getCurrentSession();
        // stworzenie obiektu

        String getPlane = "SELECT a FROM AirPlane a WHERE a.model LIKE '195'";


        // rozpoczęcie transakcji
        session.beginTransaction();

        Query query = session.createQuery(getPlane);
//        AirPlane airPlane = (AirPlane) query.getSingleResult();
//
//        for (Passenger passenger: airPlane.getPassengers()) {
//            if(passenger.getId().equals(13)){
//                session.delete(passenger);
//            }
//        }

        int passangerToDeleted = 12;

        Passenger passenger = session.get(Passenger.class,passangerToDeleted);

        session.delete(passenger);

        // zakończenie transakcji
        session.getTransaction().commit();
        // zamknięcie obiektu SessionFactory
        factory.close();
    }
}

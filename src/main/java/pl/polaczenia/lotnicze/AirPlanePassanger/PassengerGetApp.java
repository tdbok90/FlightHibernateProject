package pl.polaczenia.lotnicze.AirPlanePassanger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.polaczenia.lotnicze.entity.AirPlane;
import pl.polaczenia.lotnicze.entity.Passenger;

import java.math.BigInteger;

public class PassengerGetApp {
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

        query.getSingleResult();



        // zakończenie transakcji
        session.getTransaction().commit();
        // zamknięcie obiektu SessionFactory
        factory.close();
    }
}

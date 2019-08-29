package pl.polaczenia.lotnicze.PasangerFlight;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.polaczenia.lotnicze.entity.Flight;
import pl.polaczenia.lotnicze.entity.Passenger;

import javax.persistence.Query;
import java.math.BigInteger;

public class PassangerSaveApp {
    public static void main(String[] args) {
        // stworzenie obiektu Configuration
        Configuration conf = new Configuration();
        // wczytanie pliku konfiguracyjnego
        conf.configure("hibernate.cfg.xml");
        // wczytanie adnotacji
        conf.addAnnotatedClass(Flight.class);
        conf.addAnnotatedClass(Passenger.class);
        // stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        // pobranie sesji
        Session session = factory.getCurrentSession();
        // stworzenie obiektu

        String flight = "SELECT f FROM Flight f WHERE f.departureDateFly='2019-07-03'";


        // rozpoczęcie transakcji
        session.beginTransaction();

        Query query = session.createQuery(flight);

        Flight dailyFlight = (Flight) query.getSingleResult();

        System.out.println(dailyFlight);

        Passenger janusz = Passenger.builder().firstName("Janusz").lastName("Biedrona").personalIdentityNumber(new BigInteger("50040823452")).build();
        Passenger karina = Passenger.builder().firstName("Karina").lastName("Biedrona").personalIdentityNumber(new BigInteger("88011278643")).build();

        dailyFlight.addPassenger(janusz);
        dailyFlight.addPassenger(karina);

        session.persist(janusz);
        session.persist(karina);

        // zakończenie transakcji
        session.getTransaction().commit();
        // zamknięcie obiektu SessionFactory
        factory.close();
    }
}

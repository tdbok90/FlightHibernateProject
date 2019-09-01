package pl.polaczenia.lotnicze.PasangerFlight;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.polaczenia.lotnicze.entity.Flight;
import pl.polaczenia.lotnicze.entity.Passenger;

import javax.persistence.Query;
import java.math.BigInteger;

public class PassangerDeleteApp {
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

        int idPassanger = 15;

        String allPasanger = "SELECT f FROM Flight f WHERE f.id=8";

        // rozpoczęcie transakcji
        session.beginTransaction();

        Query query = session.createQuery(allPasanger);

        Flight flight = (Flight) query.getSingleResult();


        for (Passenger passenger: flight.getPassengers()) {
            if(passenger.getId().equals(19)){
                session.delete(passenger);
            }
        }

        // Jedna metoda na usunięcia obiektu passanger
//        Passenger passengerToDelete= session.get(Passenger.class,idPassanger);
//        session.remove(passengerToDelete);



        // zakończenie transakcji
        session.getTransaction().commit();
        // zamknięcie obiektu SessionFactory
        factory.close();
    }
}

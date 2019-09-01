package pl.polaczenia.lotnicze.PasangerFlight;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.polaczenia.lotnicze.entity.Flight;
import pl.polaczenia.lotnicze.entity.Passenger;

import javax.persistence.Query;
public class PassangerGetApp {
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

        Flight resultList = (Flight) query.getSingleResult();

        for (Passenger passanger: resultList.getPassengers()) {
            System.out.println(passanger);
        }


        // zakończenie transakcji
        session.getTransaction().commit();
        // zamknięcie obiektu SessionFactory
        factory.close();
    }
}

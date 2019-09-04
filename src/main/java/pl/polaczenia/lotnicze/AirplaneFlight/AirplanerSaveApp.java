package pl.polaczenia.lotnicze.AirplaneFlight;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.polaczenia.lotnicze.entity.AirPlane;
import pl.polaczenia.lotnicze.entity.Flight;


public class AirplanerSaveApp {
    public static void main(String[] args) {
        // stworzenie obiektu Configuration
        Configuration conf = new Configuration();
        // wczytanie pliku konfiguracyjnego
        conf.configure("hibernate.cfg.xml");
        // wczytanie adnotacji
        conf.addAnnotatedClass(Flight.class);
        conf.addAnnotatedClass(AirPlane.class);
        // stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        // pobranie sesji
        Session session = factory.getCurrentSession();
        // stworzenie obiektu

        // rozpoczęcie transakcji
        session.beginTransaction();

        Flight flight = new Flight();


        // zakończenie transakcji
        session.getTransaction().commit();
        // zamknięcie obiektu SessionFactory
        factory.close();
    }
}

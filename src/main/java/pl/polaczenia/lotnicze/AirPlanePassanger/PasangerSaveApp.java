package pl.polaczenia.lotnicze.AirPlanePassanger;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.polaczenia.lotnicze.entity.AirPlane;
import pl.polaczenia.lotnicze.entity.Passenger;

import java.math.BigInteger;


public class PasangerSaveApp {
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

//        String getPlane = "SELECT a FROM AirPlane a WHERE a.model LIKE '737 MAX 8'";
//
//
//        // rozpoczęcie transakcji
//        session.beginTransaction();
//
//        Query query = session.createQuery(getPlane);
//
//        AirPlane airPlane= (AirPlane) query.getSingleResult();
//
//        System.out.println(airPlane);
//
//        Passenger passenger1 = Passenger.builder()
//                .firstName("Michał")
//                .lastName("Kalinowski")
//                .personalIdentityNumber( new BigInteger("90030715551"))
//                .build();
//        Passenger passenger2 = Passenger.builder()
//                .firstName("Monika")
//                .lastName("Terlikowska")
//                .personalIdentityNumber( new BigInteger("88020123332"))
//                .build();
//
//        airPlane.addPassenger(passenger1);
//        airPlane.addPassenger(passenger2);

//        session.persist(passenger1);
//        session.persist(passenger2);

        // zakończenie transakcji
        session.getTransaction().commit();
        // zamknięcie obiektu SessionFactory
        factory.close();
    }
}

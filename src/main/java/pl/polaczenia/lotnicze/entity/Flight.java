package pl.polaczenia.lotnicze.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flight")
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure_flight")
    private Date departureDateFly;

    @Column(name = "destination_flight")
    @Temporal(TemporalType.TIMESTAMP)
    private Date destinationDateFly;


    @Enumerated(EnumType.STRING)
    @Column(name = "flight_status")
    private FlightStatus flightStatus;


    @ToString.Exclude
    @OneToMany(mappedBy = "flight",cascade = {CascadeType.ALL})
    private List<Passenger> passengers;

    public void addPassenger(Passenger passenger){
        if(passengers==null){
            passengers = new ArrayList<>();
        }
        passengers.add(passenger);
        passenger.setFlight(this);
    }

}

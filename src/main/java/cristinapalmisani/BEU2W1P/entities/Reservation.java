package cristinapalmisani.BEU2W1P.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)

    private long id;
    @Column(name = "reservation_date")
    private LocalDate reservationDate;
    private boolean isFree;
    private LocalTime endDate = LocalTime.of(23, 59, 59).plusSeconds(1);
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    public Reservation(LocalDate reservationDate, boolean isFree, User user, Station station, Building building) {
        this.reservationDate = reservationDate;
        this.isFree = isFree;
        this.user = user;
        this.station = station;
        this.building = building;
    }
}

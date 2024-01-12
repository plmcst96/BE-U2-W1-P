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
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
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

}

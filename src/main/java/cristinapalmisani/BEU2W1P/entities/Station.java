package cristinapalmisani.BEU2W1P.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "stations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID univocCode;
    private String description;
    @Enumerated(EnumType.STRING)
    private StationType stationType;
    private int numMaxOccupants;
    @OneToMany(mappedBy = "station")
    @ToString.Exclude
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
    @ManyToMany
    @JoinTable(name = "station_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "reservation_id"))
    private List<User> users;

    public Station(String description, StationType stationType, int numMaxOccupants, Building building, List<User> users) {
        this.description = description;
        this.stationType = stationType;
        this.numMaxOccupants = numMaxOccupants;
        this.reservations = reservations;
        this.building = building;
        this.users = users;
    }
}

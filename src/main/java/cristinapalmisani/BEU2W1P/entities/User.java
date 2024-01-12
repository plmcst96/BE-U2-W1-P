package cristinapalmisani.BEU2W1P.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String username;
    private String name;
    private String email;
    private String surname;
    @ManyToMany
    @JoinTable(name = "station_user",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Station> stations;
    @OneToMany(mappedBy = "users")
    private List<Reservation> reservations;
}

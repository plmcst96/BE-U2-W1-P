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
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;

    public User(String username, String name, String email, String surname, List<Station> stations) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.surname = surname;
        this.stations = stations;
    }
}

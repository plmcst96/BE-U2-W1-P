package cristinapalmisani.BEU2W1P.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "buildings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String name;
    private String address;
    private String city;
    @OneToMany(mappedBy = "buildings")
    @ToString.Exclude
    private List<Reservation> reservations;
}

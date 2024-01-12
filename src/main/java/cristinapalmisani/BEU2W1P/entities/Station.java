package cristinapalmisani.BEU2W1P.entities;

import java.util.List;
import java.util.UUID;

public class Station {
    private UUID univocCode;
    private String description;
    private StationType stationType;
    private int numMaxOccupants;
    private List<Reservation> reservations;

}
